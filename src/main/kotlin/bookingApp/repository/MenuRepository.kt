package bookingApp.repository

import bookingApp.repository.entity.Menu
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MenuRepository : JpaRepository<Menu, Int> {

    fun getById(id: Int): Menu?
}