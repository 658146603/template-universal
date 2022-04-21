package template.universal.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import template.universal.model.DeployPageReq
import template.universal.model.DeployPageResp
import template.universal.model.PageInfo
import template.universal.model.Responses
import template.universal.security.RemoteControlProvider
import template.universal.security.RemoteInfoProperties
import template.universal.service.PageDeployService
import template.universal.service.PageService

@RestController
class PageController {
    @Autowired
    private lateinit var pageService: PageService

    @Autowired
    private lateinit var pageDeployService: PageDeployService

    @Autowired
    private lateinit var remoteControlProvider: RemoteControlProvider

    @Autowired
    private lateinit var remoteInfo: RemoteInfoProperties


    @RequestMapping("/page/{page}")
    fun getPageInfo(@PathVariable page: String): Responses<PageInfo> {
        return pageService.getPageInfo(page)
    }

    @RequestMapping("/page/deploy")
    fun deployPage(@RequestHeader("Authorization") token: String?, @RequestBody deploy: DeployPageReq?): Responses<DeployPageResp> {
        if (token == null) {
            return Responses.fail(message = "凭证为空")
        }
        val remoteAction = remoteControlProvider.verifyServer(token) ?: return Responses.fail(message = "凭证验证失败")
        if (remoteInfo.templateShopUrl != remoteAction.server || !remoteAction.isDeploy) {
            return Responses.fail(message = "ACTION与URL不匹配")
        }

        if (deploy?.pageId == null || deploy.title == null || deploy.elements == null || deploy.deployType == null || deploy.userVerify == null || deploy.deployAddition == null) {
            return Responses.fail(message = "参数不能为空")
        }
        return pageDeployService.deployPage(PageInfo(deploy.pageId, deploy.title, deploy.elements, deploy.deployType, deploy.userVerify, deploy.deployAddition))
    }
}