package bookingApp.repository

import bookingApp.repository.entity.TableEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TableRepository : JpaRepository<TableEntity, Int> {

    fun getById(id: Int): TableEntity?
}