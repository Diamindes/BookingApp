package bookingApp.services.utils

import net.sf.jasperreports.engine.*
import net.sf.jasperreports.engine.util.JRSaver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.sql.SQLException
import java.util.*
import java.util.logging.Level
import java.util.logging.Logger
import javax.sql.DataSource

@Component
class SimpleReportFiller {
    var reportFileName: String? = null
    private var jasperReport: JasperReport? = null
    private var jasperPrint: JasperPrint? = null


    @Autowired
    var dataSource: DataSource? = null
    var parameters: Map<String, Any>? = null
    fun prepareReport() {
        compileReport()
        fillReport()
    }


    fun compileReport() {
        try {
            val reportStream = javaClass.getResourceAsStream("/$reportFileName")
            jasperReport = JasperCompileManager.compileReport(reportStream)
            JRSaver.saveObject(jasperReport, reportFileName!!.replace(".jrxml", ".jasper"))
        } catch (ex: JRException) {
            Logger.getLogger(SimpleReportFiller::class.java.name).log(Level.SEVERE, null, ex)
        }
    }

    fun fillReport() {
        try {
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource!!.connection)
        } catch (ex: JRException) {
            Logger.getLogger(SimpleReportFiller::class.java.name).log(Level.SEVERE, null, ex)
        } catch (ex: SQLException) {
            Logger.getLogger(SimpleReportFiller::class.java.name).log(Level.SEVERE, null, ex)
        }
    }

    fun getJasperPrint(): JasperPrint? {
        return this.jasperPrint

    }

    init {
        parameters = HashMap()
    }
}