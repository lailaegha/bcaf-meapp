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
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.StringSelection as StringSelection
import java.awt.event.KeyEvent as KeyEvent


TestData input = findTestData('71-Maintenance-PN-Bulk/01-Maintenance-pn-bulk-Normal')

// search maintenance pn bulk
WebUI.setText(findTestObject('Object Repository/67-Maintenance-PN-Bulk/Search_dev/input_Cari_menu'), 'maintenance pn')
WebUI.sendKeys(findTestObject('Object Repository/67-Maintenance-PN-Bulk/Search_dev/input_Cari_menu'), Keys.chord(Keys.ENTER))
WebUI.takeScreenshot() 
WebUI.click(findTestObject('Object Repository/67-Maintenance-PN-Bulk/span_Maintenance PN Bulk'))
WebUI.delay(1)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/67-Maintenance-PN-Bulk/span_Tambah Data'))
WebUI.delay(1)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/67-Maintenance-PN-Bulk/u_download disini'))
WebUI.delay(2)


// upload file

for (int baris = 1; baris <= input.getRowNumbers(); baris++) {
WebUI.click(findTestObject('Object Repository/67-Maintenance-PN-Bulk/span_Pilih Dokumen'))



Robot robot=new Robot();

StringSelection filepath=new StringSelection(input.getValue('local_file', baris))

Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

robot.keyPress(KeyEvent.VK_CONTROL);
Thread.sleep(1000);

robot.keyPress(KeyEvent.VK_V);
Thread.sleep(1000);

robot.keyRelease(KeyEvent.VK_K);
Thread.sleep(1000);

robot.keyRelease(KeyEvent.VK_CONTROL);
Thread.sleep(1000);

robot.keyPress(KeyEvent.VK_ENTER);
Thread.sleep(1000);

robot.keyRelease(KeyEvent.VK_ENTER);
Thread.sleep(1000);

WebUI.scrollToElement(findTestObject('Object Repository/67-Maintenance-PN-Bulk/span_file_uploadUnggah'), 1)

WebUI.click(findTestObject('Object Repository/67-Maintenance-PN-Bulk/span_file_uploadUnggah'))
WebUI.scrollToElement(findTestObject('Object Repository/67-Maintenance-PN-Bulk/Spv/ID_SPV/input_ID Supervisor_listSupervisor'), 0)

WebUI.setText(findTestObject('Object Repository/67-Maintenance-PN-Bulk/Spv/ID_SPV/input_ID Supervisor_listSupervisor'), GlobalVariable.user_spv)
WebUI.waitForElementPresent(findTestObject('Object Repository/67-Maintenance-PN-Bulk/Send Request/new spv/div_0206001  AKHMAD PURWAKAJAYA  0206'), 0)

WebUI.click(findTestObject('Object Repository/67-Maintenance-PN-Bulk/Send Request/new spv/div_0206001  AKHMAD PURWAKAJAYA  0206'))
WebUI.takeScreenshot()
WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/67-Maintenance-PN-Bulk/Send Request/span_Send Request'))
WebUI.takeScreenshot()

WebUI.verifyTextPresent('Konfirmasi', false, FailureHandling.OPTIONAL)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/67-Maintenance-PN-Bulk/Send Request/Konfirmasi/span_Ok'))
WebUI.delay(1)
WebUI.verifyTextPresent('Sukses!', false, FailureHandling.OPTIONAL)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/67-Maintenance-PN-Bulk/Send Request/span_Ok'))

WebUI.callTestCase(findTestCase('Test Cases/logout/01-logout'), null)

WebUI.refresh()

}


// Approval spv

WebUI.callTestCase(findTestCase('00-login/01-login-sukses-spv'), [:], FailureHandling.OPTIONAL)
WebUI.click(findTestObject('Object Repository/00-Dashboard-NDS-v3/00-Approval-System-v3/button_Ok - Copy'), FailureHandling.OPTIONAL)
WebUI.takeScreenshot()
WebUI.setText(findTestObject('Object Repository/67-Maintenance-PN-Bulk/Search_dev/input_Cari_menu'), 'approval')
WebUI.sendKeys(findTestObject('Object Repository/67-Maintenance-PN-Bulk/Search_dev/input_Cari_menu'), Keys.chord(Keys.ENTER))
WebUI.delay(1)
WebUI.takeScreenshot()

WebUI.click(findTestObject('67-Maintenance-PN-Bulk/Approval-Spv/span_Approval'))
WebUI.click(findTestObject('67-Maintenance-PN-Bulk/Approval-Spv/i_remove_red_eye'))
WebUI.click(findTestObject('67-Maintenance-PN-Bulk/Approval-Spv/span_file_downloadUnduh'))
WebUI.click(findTestObject('67-Maintenance-PN-Bulk/Approval-Spv/span_Approve'))
WebUI.verifyTextPresent('Konfirmasi', false, FailureHandling.OPTIONAL)
WebUI.click(findTestObject('67-Maintenance-PN-Bulk/Approval-Spv/span_Ok'))

WebUI.setText(findTestObject('67-Maintenance-PN-Bulk/Approval-Spv/input_Masukkan Kata Sandi_passwordApproval'), GlobalVariable.pass_super2)
WebUI.click(findTestObject('67-Maintenance-PN-Bulk/Approval-Spv/span_Submit'))
WebUI.verifyTextPresent('Approval', false, FailureHandling.OPTIONAL)
WebUI.takeScreenshot()

WebUI.refresh()
WebUI.callTestCase(findTestCase('Test Cases/logout/01-logout'), null)
WebUI.callTestCase(findTestCase('00-login/01-login-sukses-cs'), [:], FailureHandling.OPTIONAL)




















