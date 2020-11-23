package bookingApp.services.api

interface WaiterService {
    fun markTableAsFree(tableId: Int)
    fun markTableAsBusy(tableId: Int)
}