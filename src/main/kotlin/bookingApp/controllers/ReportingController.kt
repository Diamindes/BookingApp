package bookingApp.controllers

import bookingApp.services.ReportingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/reporting")
class ReportingController {
    @Autowired
    private val reportingService: ReportingService? = null
    @GetMapping("/reservations")
    fun reservationsReport() {
        reportingService!!.generateReservationsReport()
    }
}