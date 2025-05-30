package Java;




	import java.io.File;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.List;
	import java.util.Set;

	import org.apache.pdfbox.pdmodel.PDDocument;
	import org.apache.pdfbox.pdmodel.PDPage;
	import org.apache.pdfbox.pdmodel.PDPageContentStream;
	import org.apache.pdfbox.pdmodel.font.PDFont;
	import org.apache.pdfbox.pdmodel.font.PDType1Font;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class Yardi extends LoginTest {
		public static String tenant_name, address_1, address_2, city, zip, unit, owner,city_zip;

		public static void main(String[] args) throws InterruptedException, IOException {

			WebDriver d = new ChromeDriver();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			d.manage().window().maximize();
			d.get("https://03049silve.yardione.com/Account/Login");
			String login_handle = d.getWindowHandle();

			login();
			d.get(url());
			d.findElement(By.id("Username")).sendKeys(un());
			d.findElement(By.id("txtPassword")).sendKeys(pw());
			d.findElement(By.xpath("//button[@name='button']")).click();
			d.findElement(By.xpath("//div[contains(text(),'Voyager 7S')]")).click();

			Set<String> child_handles = d.getWindowHandles();
			for (String ele : child_handles)
				d.switchTo().window(ele);
			WebElement types1 = d.findElement(By.id("loginAlias"));
			Select t1 = new Select(types1);
			t1.selectByVisibleText("Live");
			d.findElement(By.id("cmdLogin")).click();
//			Thread.sleep(2000);

			// 1st child frame
			d.switchTo().frame(0);
			WebElement drop_down = d.findElement(By.xpath("(//select[@name='chooseApp'])[1]"));

			Select sel = new Select(drop_down);
			sel.selectByVisibleText("Residential Manager");

			// 2nd child frame
			d.switchTo().frame(0);

			WebElement element = d.findElement(By.id("PropLookup_LookupCode"));
			element.sendKeys(Keys.CONTROL + "a");
			element.sendKeys("alp");
			element.sendKeys(Keys.ENTER);
//			Thread.sleep(2000);

			JavascriptExecutor js = (JavascriptExecutor) d;
//			WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(3));
//			Thread.sleep(2000);
			d.findElement(By.xpath("//span[text()='Person Search']")).click();
			// ---------------------------------------------
//			String script = "return prompt('Please enter your input:', 'Default Value');";
//			String user_unit = (String) jsExecutor.executeScript(script);
			// Display the input received from the user
//			System.out.println("User entered: " + user_unit);
//			d.findElement(By.id("PersonSearch_UnitLookup_LookupCode")).sendKeys(user_unit);
			d.findElement(By.id("PersonSearch_UnitLookup_LookupCode")).sendKeys(prop.getProperty("Unit"));
			WebElement search_button = d.findElement(By.id("PersonSearch_btnSearch_Button"));
			search_button.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			
			
			
			List<WebElement> ledger_button = d.findElements(By.xpath("//table[@id='PersonSearch_Results_DataTable']/tbody/tr"));
			System.out.println("Size " + ledger_button.size());
			for (int i = 1; i <= ledger_button.size(); i++) {
				WebElement col = d.findElement(By.xpath("//table[@id='PersonSearch_Results_DataTable']/tbody/tr[" + i + "]/td[6]"));
				String parent_handle;
				if (" Ledger".equalsIgnoreCase(col.getText())) {
					parent_handle = d.getWindowHandle();
					col.click();
					System.out.println(col.getText() + " " + i);
					Set<String> set = d.getWindowHandles();
					for (String ele : set)
						d.switchTo().window(ele);
					d.manage().window().maximize();
					Thread.sleep(2000);
					System.out.println(i+" iteration____________");
					tenant_name = d.findElement(By.xpath("//span[@id='TenantInfoHeader_FirstAndLastName_Label']")).getText();
					address_1 = d.findElement(By.xpath("//span[@id='TenantInfoHeader_Address1_Label']")).getText();
					address_2 = d.findElement(By.xpath("//span[@id='TenantInfoHeader_Address2_Label']")).getText();
					city_zip = d.findElement(By.xpath("//span[@id='TenantInfoHeader_CityStateZip_Label']")).getText();

					List<WebElement> rows = d.findElements(By.xpath("//table[@id='LedgerGrid_DataTable']/tbody/tr"));
					for (int j = 1; j < rows.size(); j++) {
						WebElement col1 = d.findElement(By.xpath("//table[@id='LedgerGrid_DataTable']/tbody/tr[" + j + "]/td[4]"));
						if (" rent".equalsIgnoreCase(col1.getText())) {
//							System.out.println("Row no " + i + " " + " Count " + j++ + " " + col.getText());
							System.out.print(d.findElement(By.xpath("//table[@id='LedgerGrid_DataTable']/tbody/tr[" + j + "]/td[3]")).getText() + " ");

							System.out.print(d.findElement(By.xpath("//table[@id='LedgerGrid_DataTable']/tbody/tr[" + j + "]/td[4]")).getText() + " ");
							String amount = d.findElement(By.xpath("//table[@id='LedgerGrid_DataTable']/tbody/tr[" + j + "]/td[8]")).getText();
							amount = amount.replace(",", "");
//							amount= amount.replace(".00", "");
							amount = amount.replace("(", "");
							amount = amount.replace(")", "");
							double double1 = Double.parseDouble(amount);
							System.out.println(double1);
						}
					}
					d.close();
					d.switchTo().window(parent_handle);

				}
				
			}
//			WebElement ledger = d.findElement(By.xpath("//a[@id='PersonSearch:Results:DataTable:row10:LedgerLink_anchor']"));
//			wait.withTimeout(Duration.ofSeconds(15));
//		    wait.until(ExpectedConditions.elementToBeClickable(ledger);

	//_____________________________________
//			WebElement rent = d.findElement(By.xpath("//span[@id='LedgerGrid_DataTable_row68_chargecode']"));

//			for (int i = 1; i < rows.size(); i++) {
//				WebElement col_2 = d.findElement(By.xpath("//table[@id='LedgerGrid_DataTable']/tbody/tr[" + i + "]/td[5]"));
//				if (" chk#".equalsIgnoreCase(col_2.getText().substring(0,5))) {
//				
//				}
//			}

//			System.out.println(d.findElement(By.xpath("(//div[@id='LedgerGrid_DataDiv'])[1]")));
//			System.out.println(d.findElement(By.id("LedgerGrid_DataTable")));
//			

//			String[] str = city_zip.split(",");
//			city = str[0];
//			zip = str[1].substring(4);
//			unit = prop.getProperty("Unit");
//			owner = prop.getProperty("LandLord");
//			d.quit();

			// Retrieving the pages of the document

////			PDDocument doc = Loader.loadPDF(new File("./src/main/resources/Files/3DayNotice_GSM_01-A_OK.pdf"));
//			PDDocument doc = PDDocument.load(new File("./src/main/resources/Files/3DayNotice.pdf"));
//			PDPage page = doc.getPage(0);
//			// calling the method
//			PDPageContentStream contentStream = getPdPageContentStream(doc, page);
//			System.out.println("***/ PDF Generated Successfully /****");
	//
//			// Closing the content stream
//			contentStream.close();
	//
//			// Saving the document
//			doc.save(new File("./src/main/resources/Files/Updated_PDF.pdf"));
	//
//			// Closing the document
//			doc.close();
		}

		private static PDPageContentStream getPdPageContentStream(PDDocument doc, PDPage page)
				throws IOException, InterruptedException {

			PDPageContentStream contentStream = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND,
					true);

			// Begin the Content stream
//			contentStream.beginText();

			// Setting the font to the Content stream
			PDFont pdfFont = PDType1Font.HELVETICA_BOLD;
			contentStream.setFont(pdfFont, 12);

			String[] texts = { tenant_name, address_1, unit, city, zip, "", owner };
//			String[] texts = { "First", "Second Location", "Third", "Fourth Location", "Fifth", "Sixth Location", "Seventh",
//					"Eight", "Ninth", "Tenth", "Eleventh", "Ninth", "Tenth", "Eleventh", "Ninth", "Tenth", "Eleventh",
//					"Ninth", "Tenth", "Eleventh", "Ninth", "Tenth", "Eleventh", };
			int[][] coordinates = { { 45, 728 }, { 45, 660 }, { 545, 660 }, { 45, 627 }, { 450, 630 }, { 128, 584 },
					{ 45, 523 }, { 160, 489 }, { 40, 455 }, { 247, 456 }, { 450, 456 }, { 40, 433 }, { 247, 434 },
					{ 450, 434 }, { 40, 411 }, { 247, 411 }, { 450, 411 }, { 40, 387 }, { 247, 387 }, { 450, 387 },
					{ 40, 367 }, { 247, 367 }, { 450, 367 } };
			for (int i = 0; i < texts.length; i++) {
				contentStream.beginText();
				if (texts[i] != null) {
					// Setting the position for the line
					contentStream.newLineAtOffset(coordinates[i][0], coordinates[i][1]);
					// Adding text in the form of string
					contentStream.showText(texts[i]);
				}
				// Ending the content stream
				contentStream.endText();
			}
//			contentStream.newLineAtOffset(545, 660);
//			contentStream.showText("21");

			return contentStream;
		}
	}

}
