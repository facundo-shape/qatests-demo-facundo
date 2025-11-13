package com.blinou.saucedemo.gui.common.pages.component

import com.blinou.saucedemo.gui.common.pages.CardPage
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement
import com.zebrunner.carina.webdriver.gui.AbstractUIObject
import org.openqa.selenium.SearchContext
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy

class Header(
    driver: WebDriver,
    searchContext: SearchContext
) : AbstractUIObject(driver, searchContext) {

    @FindBy(id = "shopping_cart_container")
    private lateinit var shoppingCartIcon: ExtendedWebElement

    @FindBy(id = "back-to-products")
    private lateinit var backToProductsButton: ExtendedWebElement

    fun isShoppingCartIconPresent(): Boolean {
        return shoppingCartIcon.isElementPresent
    }

    fun clickShoppingCartIconPresent() : CardPage {
        shoppingCartIcon.click()
        return CardPage(getDriver())
    }

    fun isBackToProductsButton(): Boolean {
        return backToProductsButton.isElementPresent
    }

    fun clickBackToProductsButton() {
        backToProductsButton.click()
    }
}