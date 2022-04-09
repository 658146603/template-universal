package template.universal.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import template.universal.mapper.FormDataMapper
import template.universal.model.FormData

@Service
class DataReceiveService {
    @Autowired
    lateinit var formDataMapper: FormDataMapper

    fun receiveData(data: FormData) {
        formDataMapper.insertFormData(data)
    }
}