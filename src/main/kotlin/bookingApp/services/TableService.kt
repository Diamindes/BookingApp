package bookingApp.services

import bookingApp.repositories.TableRepository
import bookingApp.repositories.entity.TableEntity
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

    fun getByNumberOfSeats(numOfSeats: Int): TableEntity? {
        return tableRepository.getByNumberOfSeats(numOfSeats)
    }

    fun setEmployee(employeeId: Int, tableId: Int): Boolean {
        val entity = tableRepository.getById(tableId)
        return if (entity != null) {
            entity.employeeId = employeeId
            true
        } else {
            false
        }
    }
}