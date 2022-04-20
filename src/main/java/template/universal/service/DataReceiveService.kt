package template.universal.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import template.universal.model.DeployOption
import template.universal.repository.FormDataRepository
import template.universal.model.FormData
import template.universal.model.Responses
import template.universal.repository.PageInfoRepository
import template.universal.security.TrustableKeyProvider

@Service
class DataReceiveService {
    @Autowired
    lateinit var formDataRepository: FormDataRepository

    @Autowired
    lateinit var pageInfoRepository: PageInfoRepository

    @Autowired
    lateinit var trustableKeyProvider: TrustableKeyProvider

    fun receiveData(token: String?, data: FormData): Responses<FormData> {
        val pageInfo = pageInfoRepository.getPageInfo(data.submitPage) ?: return Responses.fail(message = "页面不存在")

        val deployType = DeployOption.DEPLOY_TYPE.firstOrNull { it.id == pageInfo.deployType }
        val userVerify = DeployOption.USER_VERIFY.firstOrNull { it.id == pageInfo.userVerify }

        if (deployType == null) {
            // 默认不接受数据
            return Responses.fail(message = "页面未配置发布方式")
        }

        if (userVerify != null && (userVerify.id == DeployOption.USER_VERIFY_TEL || userVerify.id == DeployOption.USER_VERIFY_EMAIL)) {
            if (token.isNullOrEmpty()) {
                return Responses.fail(message = "数据提交需要验证身份")
            }
            val trustableKey = trustableKeyProvider.verifyTrustableToken(token) ?: return Responses.fail(message = "用户验证失败")

            if (trustableKey.page != pageInfo.pageId) {
                return Responses.fail(message = "提交页面错误")
            }

            data.submitUser = trustableKey.key
        }

        val value = formDataRepository.insertFormData(data)
        if (value > 0) {
            return Responses.ok(data = data)
        }
        return Responses.fail(message = "提交数据异常")
    }
}