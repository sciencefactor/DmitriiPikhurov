package com.epam.tc.gdi.hw1.tests.steps;

import com.epam.tc.gdi.hw1.site.entities.Users;
import com.epam.tc.gdi.hw1.site.pages.components.complex.Header;

public class Preconditions {

    public static void loginIfNot() {
        if (!Header.userNameText.isDisplayed()) {
            Header.userIcon.click();
            Header.loginForm.loginAs(Users.DEFAULT_USER);
        }
    }
}
