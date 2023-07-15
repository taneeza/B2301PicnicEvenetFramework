package com.izaanschool.picnicEventTest;

import com.izaanschool.base.BaseTest;
import com.izaanschool.pages.PicnicEventPage;
import org.testng.annotations.Test;

public class FormSubmissionTest extends BaseTest {

    @Test
    public void SubmitButtonTest() {
        //creating picnic event page object
        PicnicEventPage picnicEventPage = new PicnicEventPage(driver, log);

        //open url
        picnicEventPage.openPage();

        //input data
        picnicEventPage.eventRegistration("tanija","123@gmail.com", "1234567890");

        //Verify

        //dropdown page method to select
       picnicEventPage.dropdownAdultSelect();

       //click submit button
        picnicEventPage.submit();

        //switch to alert and accept alert
        picnicEventPage.pressAlertOkButton();



        //dropdown verify
      //  String actualValue = picnicEventPage.textNoOfAdult();
      //  Assert.assertEquals(actualValue, 1);


    }
}
