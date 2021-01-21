package bookingApp.services.utils

import net.sf.jasperreports.engine.JRException
import net.sf.jasperreports.engine.JasperPrint
import net.sf.jasperreports.engine.export.HtmlExporter
import net.sf.jasperreports.engine.export.JRCsvExporter
import net.sf.jasperreports.engine.export.JRPdfExporter
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter
import net.sf.jasperreports.export.*
import org.springframework.stereotype.Component
import java.util.logging.Level
import java.util.logging.Logger

@Component
class SimpleReportExporter {
    var jasperPrint: JasperPrint? = null

    constructor() {}
    constructor(jasperPrint: JasperPrint?) {
        this.jasperPrint = jasperPrint
    }

    fun exportToPdf(fileName: String?, author: String?) {

        // print report to file
        val exporter = JRPdfExporter()
        exporter.setExporterInput(SimpleExporterInput(jasperPrint))
        exporter.setExporterOutput(SimpleOutputStreamExporterOutput(fileName))
        val reportConfig = SimplePdfReportConfiguration()
        reportConfig.isSizePageToContent = true
        reportConfig.isForceLineBreakPolicy = false
        val exportConfig = SimplePdfExporterConfiguration()
        exportConfig.metadataAuthor = author
        exportConfig.isEncrypted = true
        exportConfig.setAllowedPermissionsHint("PRINTING")
        exporter.setConfiguration(reportConfig)
        exporter.setConfiguration(exportConfig)
        try {
            exporter.exportReport()
        } catch (ex: JRException) {
            Logger.getLogger(SimpleReportFiller::class.java.name).log(Level.SEVERE, null, ex)
        }
    }

    fun exportToXlsx(fileName: String?, sheetName: String) {
        val exporter = JRXlsxExporter()
        exporter.setExporterInput(SimpleExporterInput(jasperPrint))
        exporter.setExporterOutput(SimpleOutputStreamExporterOutput(fileName))
        val reportConfig = SimpleXlsxReportConfiguration()
        reportConfig.sheetNames = arrayOf(sheetName)
        exporter.setConfiguration(reportConfig)
        try {
            exporter.exportReport()
        } catch (ex: JRException) {
            Logger.getLogger(SimpleReportFiller::class.java.name).log(Level.SEVERE, null, ex)
        }
    }

    fun exportToCsv(fileName: String?) {
        val exporter = JRCsvExporter()
        exporter.setExporterInput(SimpleExporterInput(jasperPrint))
        exporter.setExporterOutput(SimpleWriterExporterOutput(fileName))
        try {
            exporter.exportReport()
        } catch (ex: JRException) {
            Logger.getLogger(SimpleReportFiller::class.java.name).log(Level.SEVERE, null, ex)
        }
    }

    fun exportToHtml(fileName: String?) {
        val exporter = HtmlExporter()
        exporter.setExporterInput(SimpleExporterInput(jasperPrint))
        exporter.setExporterOutput(SimpleHtmlExporterOutput(fileName))
        try {
            exporter.exportReport()
        } catch (ex: JRException) {
            Logger.getLogger(SimpleReportFiller::class.java.name).log(Level.SEVERE, null, ex)
        }
    }
}