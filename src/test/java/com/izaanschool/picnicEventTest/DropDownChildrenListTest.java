package com.izaanschool.picnicEventTest;

import com.izaanschool.base.BaseTest;
import com.izaanschool.pages.PicnicEventPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownChildrenListTest extends BaseTest {
    @Test
    public void DropDownForNumberOfAdultTest() {
        //creating picnic event page object
        PicnicEventPage picnicEventPage = new PicnicEventPage(driver, log);

        //open url
        picnicEventPage.openPage();

        //select no of adult using index no.3 and get the ext
        String actualChildrenNumber= picnicEventPage.dropdownChildrenSelect();
        Assert.assertEquals(actualChildrenNumber, "10");

    }
}
