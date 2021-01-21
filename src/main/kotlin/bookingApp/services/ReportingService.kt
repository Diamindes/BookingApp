package bookingApp.services

import bookingApp.services.utils.SimpleReportExporter
import bookingApp.services.utils.SimpleReportFiller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ReportingService {
    @Autowired
    private val simpleReportFiller: SimpleReportFiller? = null

    @Autowired
    private val simpleExporter: SimpleReportExporter? = null
    fun generateReservationsReport() {
        simpleReportFiller!!.reportFileName = "Reservations.jrxml"
        simpleReportFiller.compileReport()
        simpleReportFiller.fillReport()
        simpleExporter!!.jasperPrint = simpleReportFiller.getJasperPrint()
        simpleExporter.exportToPdf("Reservations.pdf", "Camunda BPM")
        simpleExporter.exportToXlsx("Reservations.xlsx", "Reservations Data")
        simpleExporter.exportToCsv("reservations.csv")
        simpleExporter.exportToHtml("reservations.html")
    }
}