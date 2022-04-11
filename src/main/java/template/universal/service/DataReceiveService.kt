package template.universal.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import template.universal.repository.FormDataRepository
import template.universal.model.FormData
import template.universal.model.Responses

@Service
class DataReceiveService {
    @Autowired
    lateinit var formDataRepository: FormDataRepository

    fun receiveData(data: FormData): Responses<FormData> {
        formDataRepository.insertFormData(data)
        return Responses.ok(data = data)
    }
}