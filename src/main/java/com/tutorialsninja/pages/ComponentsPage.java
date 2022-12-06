package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class ComponentsPage extends Utility {

    By componentsText = By.xpath("//h2[contains(text(),'Components')]");


    public String getComponentsPageText(){
        return getTextFromElement(componentsText);
    }
}
