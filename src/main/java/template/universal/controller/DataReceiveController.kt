package template.universal.controller

import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import template.universal.model.FormData
import template.universal.model.Responses
import template.universal.service.DataReceiveService
import template.universal.util.getRequestIpAddress
import template.universal.util.uuid
import java.util.*
import javax.servlet.http.HttpServletRequest

@RestController
class DataReceiveController {

    @Autowired
    lateinit var dataReceiveService: DataReceiveService

    @RequestMapping("/upload/data")
    fun uploadDataReceiver(request: HttpServletRequest): Responses<FormData> {
        val formData = FormData()
        formData.submitId = uuid()
        formData.submitTime = Date()
        formData.submitIpAddress = request.getRequestIpAddress()
        formData.submitContent = Gson().toJson(request.parameterMap)

        dataReceiveService.receiveData(formData)

        return Responses.ok(data = formData)
    }
}