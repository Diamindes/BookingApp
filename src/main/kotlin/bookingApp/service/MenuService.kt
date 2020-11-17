package bookingApp.service

import bookingApp.repository.MenuRepository
import bookingApp.repository.entity.MenuEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MenuService {

    @Autowired
    private lateinit var menuRepository: MenuRepository

    fun getDataById(id: Int): MenuEntity? {
        return menuRepository.getById(id)
    }

    fun saveToDb(data: MenuEntity): MenuEntity {
        return menuRepository.save(data)
    }
}