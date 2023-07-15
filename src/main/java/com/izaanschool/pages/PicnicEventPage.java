package com.izaanschool.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PicnicEventPage extends BasePageObject {

	//page url
	private String pageUrl = "https://develop.d2thmk3us0b2mb.amplifyapp.com";


	//locator
	private By nameBoxLocator = By.id("name");

	private By emailBoxLocator = By.id("email");
	private By phoneNumberBoxLocator = By.id("phone");
	private By noOfAdultBoxLocator = By.id("adults");
	private By noOfChildrenBoxLocator = By.id("children");
	private By submitButtonLocator = By.xpath("//*[@id=\"registration-form\"]/input[4]");






	//welcome page constructor initializing web-driver and logger object
	public PicnicEventPage(WebDriver driver, Logger log) {

		super(driver, log);
	}

	/**
	 * 1.Open WelcomePage with it's url
	 */

	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("page opened");
	}

	public void eventRegistration(String name, String email, String phoneNumber){
		log.info("Executing submit with name [" + name + "] and email [" + email + "] and phone numer ["+ phoneNumber+"]");
		type(name,nameBoxLocator);
		type(email,emailBoxLocator);
		type(phoneNumber,phoneNumberBoxLocator);

	}



	public String dropdownAdultSelect() {
		//Declare the drop-down element as an instance of the Select class.
		Select dropdownAdult = new Select(find(noOfAdultBoxLocator));
		// choose 2
		dropdownAdult.selectByIndex(3);
		String noOfAdult= dropdownAdult.getFirstSelectedOption().getText();
		log.info(noOfAdult+ " is selected");
		return noOfAdult;

	}




	public String dropdownChildrenSelect() {
		//Declare the drop-down element as an instance of the Select class.
		Select dropdownChildren = new Select(find(noOfChildrenBoxLocator));
		// choose 10
		dropdownChildren.selectByVisibleText("10");
		log.info("10 is selected");
		String noOfChildren= dropdownChildren.getFirstSelectedOption().getText();
		log.info(noOfChildren+ " is selected");
		return noOfChildren;
	}
	/*public String textNoOfChildren() {
		String actualNumberOfChildren = dropdownChildren.getFirstSelectedOption().getText();
		log.info(actualNumberOfChildren);
		return actualNumberOfChildren;
	}*/

	public void submit(){
		click(submitButtonLocator);
	}

	public void pressAlertOkButton(){
		switchToAlert().accept();
		//alert.accept();
	}





}
