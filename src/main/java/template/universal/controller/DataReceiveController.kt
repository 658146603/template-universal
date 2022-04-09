package template.universal.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import template.universal.model.Responses
import javax.servlet.http.HttpServletRequest

@RestController
class DataReceiveController {

    @RequestMapping("/upload/data")
    fun uploadDataReceiver(request: HttpServletRequest): Responses<Map<String, Any>> {
        val data = HashMap<String, Array<String>>(request.parameterMap)
        return Responses.ok(data = data)
    }
}