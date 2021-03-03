package bookingApp.services

import bookingApp.controllers.OperationController
import bookingApp.repositories.TableRepository
import bookingApp.repositories.entity.TableEntity
import bookingApp.services.api.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TableService {

    @Autowired
    private lateinit var tableRepository: TableRepository

    @Autowired
    private lateinit var restaurantService: RestaurantService

    @Autowired
    private lateinit var userService: UserService

    fun getById(id: Int): TableEntity? {
        return tableRepository.getById(id)
    }

    fun getByUserId(userId: Int, restaurantId: Int): List<OperationController.TableDto> {
        return tableRepository.getByWaiterAndRestaurantId(userService.getById(userId), restaurantId)
                .map(this::convertToDto)
                .toList()
    }

    fun getAll(restaurantId: Int): List<OperationController.TableDto> {
        return tableRepository.getByRestaurantId(restaurantId)
                .map(this::convertToDto)
                .toList()
    }

    fun registerTable(tableDto: OperationController.TableDto, restaurantId: Int): OperationController.TableDto {
        return convertToDto(tableRepository.save(convertToEntity(tableDto, restaurantId)))
    }

    fun deleteTable(tableId: Int, restaurantId: Int) {
        tableRepository.deleteById(tableId)
    }

    fun changeStatus(tableId: Int, isFree: Boolean): OperationController.TableDto {
        val table = tableRepository.getById(tableId)
        table.isFree = isFree
        return convertToDto(tableRepository.save(table))
    }

    fun changeAssign(tableId: Int, userId: Int): OperationController.TableDto {
        val table = tableRepository.getById(tableId)
        table.waiter = userService.getById(userId)
        return convertToDto(tableRepository.save(table))
    }

    fun convertToDto(tableEntity: TableEntity): OperationController.TableDto {
        return OperationController.TableDto(
                id = tableEntity.id,
                isFree = tableEntity.isFree,
                numberName = tableEntity.numberName,
                numberOfSeats = tableEntity.numberOfSeats,
                isNearTheWindow = tableEntity.isNearTheWindow,
                waiterId = tableEntity.waiter?.id!!
        )
    }

    fun convertToEntity(tableDto: OperationController.TableDto, restaurantId: Int): TableEntity {
        return TableEntity(
                id = tableDto.id,
                isFree = tableDto.isFree,
                numberName = tableDto.numberName,
                numberOfSeats = tableDto.numberOfSeats,
                isNearTheWindow = tableDto.isNearTheWindow,
                waiter = userService.getById(tableDto.waiterId),
                restaurant = restaurantService.getById(restaurantId)
        )
    }

}