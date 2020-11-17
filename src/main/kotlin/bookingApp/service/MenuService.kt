package bookingApp.service

import bookingApp.repository.MenuRepository
import bookingApp.repository.entity.Menu
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MenuService {

    @Autowired
    private lateinit var menuRepository: MenuRepository

    fun getDataById(id: Int): Menu? {
        return menuRepository.getById(id)
    }

    fun saveToDb(data: Menu): Menu {
        return menuRepository.save(data)
    }
}