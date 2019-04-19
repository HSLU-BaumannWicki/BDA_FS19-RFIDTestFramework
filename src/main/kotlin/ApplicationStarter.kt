import feature.report.ReportTxtPersistor
import gui.GuiLess
import gui.ScannerAbstractionImpl
import test.cases.dataloader.JsonDataLoader
import util.ReadableResourceFile
import util.WriteableFileImpl
import java.io.File

fun main() {
    val scannerAbstractionImpl = ScannerAbstractionImpl()
    val guiLess = GuiLess(scannerAbstractionImpl)
    val jsonReadableFile = ReadableResourceFile("package.json")
    val dataLoader = JsonDataLoader(jsonReadableFile)
    val txtFile = File("./Report.txt")
    val reportPersistor = ReportTxtPersistor(WriteableFileImpl(txtFile))
    val multipleSequentialTestExecutor = MultipleSequentialTestExecutor(guiLess, dataLoader, reportPersistor)

    guiLess.subscribe(multipleSequentialTestExecutor)

    multipleSequentialTestExecutor.start()
}
