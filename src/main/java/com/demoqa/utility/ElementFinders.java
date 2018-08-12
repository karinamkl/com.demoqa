package com.demoqa.utility;

import com.codeborne.selenide.ElementsCollection;


public class ElementFinders {

    public void setCheckboxRadio(String keyword, ElementsCollection findBy) {
        ElementsCollection checkRadioButtons = findBy;
        int iSize = checkRadioButtons.size();
        for(int i=0; i < iSize; i++) {
            String keyworD = checkRadioButtons.get(i).getAttribute("value");
            if(keyworD.equalsIgnoreCase(keyword)) {
                checkRadioButtons.get(i).click();
                break;
            }
            else System.out.println("Option #" + i + " doesn't match keyword");
        }
    }

}
