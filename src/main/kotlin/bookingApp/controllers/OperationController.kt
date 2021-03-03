package bookingApp.controllers

import bookingApp.repositories.entity.TableEntity
import bookingApp.repositories.entity.User
import bookingApp.services.TableService
import bookingApp.services.api.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/restaurants/{restaurantId}"])
class OperationController {

    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var tableService: TableService

    @GetMapping(path =["/workers"])
    fun getAllEmployees(@PathVariable restaurantId: Int) = userService.getAll(restaurantId)

    @PostMapping(path = ["/workers/add"])
    fun registerEmployee(@PathVariable restaurantId: Int, @RequestBody user: UserDto): User = userService.registerEmployee(user, restaurantId)

    @DeleteMapping(path = ["/workers/delete"])
    fun deleteEmployee(@PathVariable restaurantId: Int, @RequestParam userId: Int) = userService.deleteEmployee(userId, restaurantId)

    @GetMapping(path = ["/tables"])
    fun getAllTables(@PathVariable restaurantId: Int): List<TableDto> = tableService.getAll(restaurantId)

    @GetMapping(path = ["/{userId}/tables"])
    fun getByUserId(@PathVariable restaurantId: Int, @PathVariable userId: Int): List<TableDto> = tableService.getByUserId(userId, restaurantId)

    @PostMapping(path = ["/tables/add"])
    fun addNewTable(@PathVariable restaurantId: Int, @RequestBody tableDto: TableDto): TableDto = tableService.registerTable(tableDto, restaurantId)

    @DeleteMapping(path = ["/tables/delete"])
    fun deleteTable(@PathVariable restaurantId: Int, @RequestParam tableId: Int) = tableService.deleteTable(tableId, restaurantId)

    @PostMapping(path = ["/tables/assign"])
    fun assignTable(@PathVariable restaurantId: Int,@RequestParam tableId: Int, @RequestParam userId: Int): TableDto = tableService.changeAssign(tableId, userId)

    @PutMapping(path = ["/tables/changeStatus"])
    fun changeTableStatus(@PathVariable restaurantId: Int, @RequestParam tableId: Int, @RequestParam isFree: Boolean): TableDto = tableService.changeStatus(tableId, isFree)

    data class TableDto(var id: Int?, val isFree: Boolean, val numberName: Int, val numberOfSeats: Int, val isNearTheWindow: Boolean, val waiterId: Int)
}