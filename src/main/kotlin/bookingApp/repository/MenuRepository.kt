package bookingApp.repository

import bookingApp.repository.entity.MenuEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MenuRepository : JpaRepository<MenuEntity, Int> {

    fun getById(id: Int): MenuEntity?
}