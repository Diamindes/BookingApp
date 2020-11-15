package bookingApp.controller

import bookingApp.repository.entity.TestEntity
import bookingApp.service.TestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(path = ["/db"])
class TestDbController {

    @Autowired
    private lateinit var testService: TestService

    @GetMapping("/testGet/{id}")
    fun getFromDb(@PathVariable id: Int): TestEntity? {
        return testService.getDataById(id)
    }

    @PostMapping(path = ["/testPost"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun saveToDb(@RequestBody testData: TestEntity): TestEntity {
        return testService.saveToDb(testData)
    }
}


