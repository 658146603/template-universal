package template.universal.controller

import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
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
    private lateinit var dataReceiveService: DataReceiveService

    @RequestMapping("/upload/data/{page}")
    fun uploadDataReceiver(request: HttpServletRequest, @PathVariable page: String): Responses<FormData> {
        val formData = FormData()
        formData.submitId = uuid()
        formData.submitPage = page
        formData.submitTime = Date()
        formData.submitIpAddress = request.getRequestIpAddress()
        formData.submitContent = Gson().toJson(request.parameterMap)

        return dataReceiveService.receiveData(formData)
    }
}