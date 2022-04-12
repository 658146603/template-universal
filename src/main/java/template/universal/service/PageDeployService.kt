package template.universal.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import template.universal.repository.PageMetaDataRepository

@Service
class PageDeployService {

    @Autowired
    private lateinit var pageMetaDataRepository: PageMetaDataRepository


    fun deployPage(token: String) {

    }
}