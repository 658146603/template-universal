package template.universal.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import template.universal.model.DeployPageResp
import template.universal.model.PageInfo
import template.universal.model.Responses
import template.universal.repository.PageInfoRepository

@Service
class PageDeployService {

    @Autowired
    private lateinit var pageInfoRepository: PageInfoRepository

    fun deployPage(pageInfo: PageInfo): Responses<DeployPageResp> {
        val result = pageInfoRepository.deployPage(pageInfo)
        if (result == 0) {
            return Responses.fail(message = "部署失败")
        }
        return Responses.ok(data = DeployPageResp(pageInfo.pageId))
    }
}