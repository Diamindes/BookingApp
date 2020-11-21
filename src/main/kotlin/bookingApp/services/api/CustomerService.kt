package bookingApp.services.api

interface CustomerService {
    fun reserveTable(tableId: Int)
    fun getRestaurants()
    fun getMenuByRestaurant(restaurantId: Int)
    fun getDishesByMenu()
    fun addDishToFavorites(dishesId: Int)
    fun getFavorites()
}