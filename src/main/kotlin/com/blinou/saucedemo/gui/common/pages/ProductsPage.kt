package com.blinou.saucedemo.gui.common.pages

import com.blinou.saucedemo.gui.common.pages.component.Header
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy
import com.zebrunner.carina.webdriver.gui.AbstractPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy

class ProductsPage: AbstractPage {

    @FindBy(id = "inventory_container")
    private lateinit var inventoryContainer: ExtendedWebElement

    @FindBy(id = "header_containerr")
    private lateinit var header: Header

    constructor(driver: WebDriver) : super(driver) {
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT)
        setUiLoadedMarker(inventoryContainer)
    }

    fun getHeader(): Header {
        return header
    }
}