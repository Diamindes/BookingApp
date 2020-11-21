package bookingApp.services.api

import bookingApp.repositories.entity.Dish

interface CustomerService {
    fun reserveTable(tableId: Int)
    fun getRestaurants()
    fun getMenuByRestaurant(restaurantId: Int)
    fun getDishesByMenu()
    fun doPreOrder(order: List<Dish>)
    fun payOrder()
    fun addDishToFavorites(dishesId: Int)
    fun getFavorites()
}