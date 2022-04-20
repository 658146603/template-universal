package template.universal.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import template.universal.model.PageInfo
import template.universal.model.Responses
import template.universal.service.PageService

@RestController
class PageController {
    @Autowired
    private lateinit var pageService: PageService

    @RequestMapping("/page/{page}")
    fun getPageInfo(@PathVariable page: String): Responses<PageInfo> {
        return pageService.getPageInfo(page)
    }
}