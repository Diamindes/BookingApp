package bookingApp.service

import bookingApp.repository.TestRepository
import bookingApp.repository.entity.TestEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TestService {

    @Autowired
    private lateinit var testRepository: TestRepository

    fun getSomeData() = "Some data"

    fun getDataById(id: Int): TestEntity? {
        return testRepository.getById(id)
    }

    fun saveToDb(testData: TestEntity): TestEntity {
        return testRepository.save(testData)
    }
}