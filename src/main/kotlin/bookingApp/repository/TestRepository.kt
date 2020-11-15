package bookingApp.repository

import bookingApp.repository.entity.TestEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TestRepository : JpaRepository<TestEntity, Int> {

    fun getById(id: Int): TestEntity?
}