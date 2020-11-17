package bookingApp.service

import bookingApp.repository.TableRepository
import bookingApp.repository.entity.TableEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TableService {

    @Autowired
    private lateinit var tableRepository: TableRepository

    fun getDataById(id: Int): TableEntity? {
        return tableRepository.getById(id)
    }

    fun saveToDb(data: TableEntity): TableEntity {
        return tableRepository.save(data)
    }
}