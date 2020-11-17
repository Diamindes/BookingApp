package bookingApp.repository

import bookingApp.repository.entity.RoleTypeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleTypeRepository : JpaRepository<RoleTypeEntity, Int> {

    fun getById(id: Int): RoleTypeEntity?
}