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
        val value = formDataRepository.insertFormData(data)
        if (value > 0) {
            return Responses.ok(data = data)
        }
        return Responses.fail(message = "提交数据异常")
    }
}