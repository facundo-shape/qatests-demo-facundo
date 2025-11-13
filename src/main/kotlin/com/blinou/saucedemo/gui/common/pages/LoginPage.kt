package com.blinou.saucedemo.gui.common.pages

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy
import com.zebrunner.carina.webdriver.gui.AbstractPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy

class LoginPage: AbstractPage {

    @FindBy(id = "login_button_container")
    private lateinit var loginButtonContainer: ExtendedWebElement

    @FindBy(id = "user-name")
    private lateinit var inputUserName: ExtendedWebElement

    @FindBy(id = "password")
    private lateinit var inputPassword: ExtendedWebElement

    @FindBy(id = "login-button")
    private lateinit var loginButton: ExtendedWebElement

    @FindBy(className = "error-message-container")
    private lateinit var errorMessageContainer: ExtendedWebElement

    constructor(driver: WebDriver) : super(driver) {
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT)
        setUiLoadedMarker(loginButtonContainer)
    }

    fun typeUsername(username: String) {
        inputUserName.type(username)
    }

    fun typePassword(password: String) {
        inputPassword.type(password)
    }

    fun login(username: String, password: String) {
        typeUsername(username)
        typePassword(password)
        loginButton.click()

    }

    fun getErrorMessage(): String {
        return errorMessageContainer.text
    }
}
