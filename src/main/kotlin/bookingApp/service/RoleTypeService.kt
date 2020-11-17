package bookingApp.service

import bookingApp.repository.RoleTypeRepository
import bookingApp.repository.entity.RoleTypeEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RoleTypeService {

    @Autowired
    private lateinit var roleTypeRepository: RoleTypeRepository

    fun getDataById(id: Int): RoleTypeEntity? {
        return roleTypeRepository.getById(id)
    }

    fun saveToDb(data: RoleTypeEntity): RoleTypeEntity {
        return roleTypeRepository.save(data)
    }
}