import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.StringSelection as StringSelection
import com.thoughtworks.selenium.Selenium as Selenium
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.openqa.selenium.WebDriver as WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths

Robot robot = new Robot()

String userDir = System.getProperty('user.dir')

//String filePath = userDir + 'C:\\Users\\savir\\Katalon Studio\\BCAF Sprint 4\\Assets\\npwp-dummy.jpg'
//String Path absolutePath = Paths.get(RunConfiguration.getProjectDir(), 'C:\Users\savir\Downloads\I3 Project\BCAF\BCAF Sprint 4\Assets', "npwp-dummy");
//Path absolutePath = Paths.get(filePath)
//String absolutePathStr = absolutePath.toString()
WebUI.openBrowser('')

def driver = DriverFactory.getWebDriver()

WebUI.navigateToUrl(GlobalVariable.ME_url)

WebUI.maximizeWindow()

WebUI.delay(1)

WebUI.setText(findTestObject('Page_AppBaru-ME/input_User ID_login'), GlobalVariable.CMO)

WebUI.setText(findTestObject('Page_AppBaru-ME/input_User Password_login'), GlobalVariable.password)

WebUI.click(findTestObject('Page_AppBaru-ME/button_Login'))

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('Page_AppBaru-ME/span_Transaksi'), 0)

WebUI.click(findTestObject('Page_AppBaru-ME/span_Transaksi'))

WebUI.delay(1)

WebUI.click(findTestObject('Page_AppBaru-ME/span_Aplikasi Baru'))

WebUI.delay(1)

WebUI.click(findTestObject('Page_AppBaru-ME/input_perorangan_radios-apptype'))

WebUI.delay(1)

WebUI.click(findTestObject('Page_AppBaru-ME/input_korporasi_radios-apptype'))

WebUI.delay(1)

WebUI.click(findTestObject('Page_AppBaru-ME/input-badanusaha'))

WebUI.delay(1)

WebUI.setText(findTestObject('Page_AppBaru-ME/input-badanusaha'), 'Perseroan Terbatas ( PT. , NV. , LTD. )')

WebUI.delay(1)

WebUI.click(findTestObject('Page_AppBaru-ME/span_Perseroan Terbatas ( PT. , NV. , LTD. )'))

WebUI.delay(5)

WebUI.click(findTestObject('Page_AppBaru-ME/button_Capture_npwp'))

WebUI.delay(5)

//WebUI.uploadFile(findTestObject('Page_AppBaru-ME/button_Local File_npwp'), absolutePathStr)
CustomKeywords.'upload.uploadfile.uploadFile'(findTestObject('Page_AppBaru-ME/button_Local File_npwp'), GlobalVariable.pathfinder_npwp)

WebUI.waitForElementPresent(findTestObject('Page_AppBaru-ME/button_NPWP'), 0)

WebUI.setText(findTestObject('Page_Mobile Entry - BCAF/input_NPWP No fix'), '318114725026000')

WebUI.delay(1)

WebUI.setText(findTestObject('Page_Mobile Entry - BCAF/input_Name fix'), 'LTIFNISFILEOIO NIIPE IK INOINOO')

WebUI.click(findTestObject('Page_Mobile Entry - BCAF/button_Capture_siupfix'))

WebUI.delay(5)

CustomKeywords.'upload.uploadsiuptdp.uploadFile'(findTestObject('Page_AppBaru-ME/button_Local File_SIUP'), GlobalVariable.pathfinder_siup)

WebUI.delay(5)

WebUI.click(findTestObject('Page_AppBaru-ME/button_Capture_TDP'))

WebUI.delay(5)

CustomKeywords.'upload.uploadsiuptdp.uploadFile'(findTestObject('Page_AppBaru-ME/button_Local File_TDP'), GlobalVariable.pathfinder_tdp)

WebUI.delay(5)

WebUI.click(findTestObject('Page_Mobile Entry - BCAF/input_Ada Perubahan Data Tidak'))

WebUI.delay(1)

WebUI.click(findTestObject('Page_Mobile Entry - BCAF/input_Ada Perubahan Data YA'))

WebUI.delay(1)

WebUI.click(findTestObject('Page_Mobile Entry - BCAF/button_Prosesfix'))

WebUI.delay(1)

WebUI.waitForElementPresent(findTestObject('Page_Mobile Entry - BCAF/AplikasiBaruMatching'), 300)

WebUI.delay(1)

WebUI.click(findTestObject('Page_Mobile Entry - BCAF/a_Ok'))

WebUI.delay(1)

WebUI.click(findTestObject('Page_Mobile Entry - BCAF/button_Ya'))

