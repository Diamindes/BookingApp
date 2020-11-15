package bookingApp.controller

import bookingApp.service.TestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @Autowired
    private lateinit var testService: TestService

    @GetMapping("/testGet")
    fun getData():String {
        return testService.getSomeData();
    }

    @PostMapping(path = ["/testPost"])
    fun postData(@RequestBody input:testDto): String {
        return "Received data -  ${input.firstName} and ${input.lastName}";
    }
}

data class testDto(val firstName:String, val lastName:String)