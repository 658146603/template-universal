package template.universal.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import template.universal.repository.PageInfoRepository

@Service
class PageDeployService {

    @Autowired
    private lateinit var pageInfoRepository: PageInfoRepository

    fun deployPage(token: String) {

    }
}