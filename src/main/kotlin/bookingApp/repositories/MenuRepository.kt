package bookingApp.repositories

import bookingApp.repositories.entity.Menu
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MenuRepository : JpaRepository<Menu, Int> {

    fun getById(id: Int): Menu?
}