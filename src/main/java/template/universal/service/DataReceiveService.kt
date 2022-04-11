package template.universal.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import template.universal.repository.FormDataRepository
import template.universal.model.FormData
import template.universal.model.PageMetaData
import template.universal.model.Responses
import template.universal.repository.PageMetaDataRepository
import template.universal.security.TrustableKeyProvider
import java.util.*

@Service
class DataReceiveService {
    @Autowired
    lateinit var formDataRepository: FormDataRepository

    @Autowired
    lateinit var pageMetaDataRepository: PageMetaDataRepository

    @Autowired
    lateinit var trustableKeyProvider: TrustableKeyProvider

    fun receiveData(token: String?, data: FormData): Responses<FormData> {
        val metaData = pageMetaDataRepository.getPageMetaData(data.submitPage)
            ?: return Responses.fail(message = "页面不存在")

        if (metaData.pageVerify && token != null) {
            val trustableKey = trustableKeyProvider.verifyTrustableToken(token)
                ?: return Responses.fail(message = "用户验证失败")

            if (trustableKey.page != metaData.pageId) {
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