/**
 *
 */

package com.blinou.saucedemo.gui.desktop

import com.blinou.saucedemo.gui.common.pages.LoginPage
import com.blinou.saucedemo.gui.common.pages.ProductsPage
import com.blinou.saucedemo.gui.constants.GuiConstants.EXPECTED_ERROR_MESSAGE
import com.blinou.saucedemo.gui.constants.GuiConstants.LOCKED_OUT_USERNAME
//import com.blinou.saucedemo.gui.common.pages.ProductsPage
import com.zebrunner.agent.core.annotation.TestLabel
import com.zebrunner.carina.core.IAbstractTest
import com.zebrunner.carina.core.registrar.ownership.MethodOwner
import org.testng.Assert
import org.testng.annotations.Test
import com.blinou.saucedemo.gui.constants.GuiConstants.PASSWORD
import com.blinou.saucedemo.gui.constants.GuiConstants.STANDARD_USERNAME
//import com.blinou.saucedemo.gui.constants.RegexConstants.NON_EMPTY_STRING_PATTERN
//import com.blinou.saucedemo.gui.constants.RegexConstants.PRICE_PATTERN

class SaucedemoGuiDeskTest : IAbstractTest {

    @Test(groups = ["functional"])
    @MethodOwner(owner = "saucedemoGuiDesktop")
    @TestLabel(name = "feature", value = ["web", "regression"])
    fun testSuccessfulUserAccess() {
        val loginPage = LoginPage(getDriver())
        loginPage.open()
        Assert.assertTrue(loginPage.isPageOpened, "Login page is not opened.")

        // Credentials from your config or constants
        loginPage.login(STANDARD_USERNAME, PASSWORD)

        val productsPage = ProductsPage(getDriver())
        Assert.assertTrue(productsPage.isPageOpened, "Products page is not opened.")
    }

    @Test(groups = ["functional"])
    @MethodOwner(owner = "saucedemoGuiDesktop")
    @TestLabel(name = "feature", value = ["web", "regression"])
    fun testLockedOutUserAccess() {
        val loginPage = LoginPage(getDriver())
        loginPage.open()
        Assert.assertTrue(loginPage.isPageOpened, "Login page is not opened.")

        loginPage.login(LOCKED_OUT_USERNAME, PASSWORD)
        Assert.assertEquals(
            loginPage.getErrorMessage(), EXPECTED_ERROR_MESSAGE, "Error message does not match")
    }

    @Test(groups = ["functional"])
    @MethodOwner(owner = "saucedemoGuiDesktop")
    @TestLabel(name = "feature", value = ["web", "regression"])
    fun testCartIconTrue() {
        val loginPage = LoginPage(getDriver())
        loginPage.open()
        Assert.assertTrue(loginPage.isPageOpened, "Login page is not opened.")

        // Credentials from your config or constants
        loginPage.login(STANDARD_USERNAME, PASSWORD)

        val productsPage = ProductsPage(getDriver())
        Assert.assertTrue(productsPage.getHeader().isShoppingCartIconPresent(), "Error")
    }






















    /*
    @Test(groups = ["functional"])
    @MethodOwner(owner = "saucedemoGuiDesktop")
    @TestLabel(name = "feature", value = ["web", "regression"])
    fun testLockedOutUserAccess() {
        val loginPage = LoginPage(getDriver())
        loginPage.open()
        Assert.assertTrue(loginPage.isPageOpened, "Home page is not opened")

        loginPage.login(LOCKED_OUT_USERNAME, PASSWORD)
        Assert.assertEquals(loginPage.getErrorMessage(), EXPECTED_ERROR_MESSAGE, "Error message does not match.")
    }

    @Test(groups = ["functional"])
    @MethodOwner(owner = "saucedemoGuiDesktop")
    @TestLabel(name = "feature", value = ["web", "regression"])
    fun testProductCardsDisplay() {
        val loginPage = LoginPage(getDriver())
        loginPage.open()
        Assert.assertTrue(loginPage.isPageOpened, "Home page is not opened")

        loginPage.login(STANDARD_USERNAME, PASSWORD)

        val productsPage = ProductsPage(getDriver())
        Assert.assertTrue(productsPage.isPageOpened, "Products page is not opened after login")

        for (i in productsPage.getProductCards().indices) {
            Assert.assertTrue(productsPage.isProductNamePresent(i),
                "Product name is not present for product card at index $i")
            Assert.assertTrue(productsPage.isProductDescriptionPresent(i),
                "Product description is not present for product card at index $i")
            Assert.assertTrue(productsPage.isProductPricePresent(i),
                "Product price is not present for product card at index $i")
            Assert.assertTrue(productsPage.isAddToCartButtonPresent(i),
                "Add to cart button is not present for product card at index $i")
            Assert.assertTrue(productsPage.isProductImagePresent(i),
                "Product image is not displayed for product card at index $i")
        }
    }

    @Test(groups = ["functional"])
    @MethodOwner(owner = "saucedemoGuiDesktop")
    @TestLabel(name = "feature", value = ["web", "regression"])
    fun testProductDetailsDisplay() {
        val loginPage = LoginPage(getDriver())
        loginPage.open()
        Assert.assertTrue(loginPage.isPageOpened, "Login page is not opened.")

        loginPage.login(STANDARD_USERNAME, PASSWORD)

        val productsPage = ProductsPage(getDriver())
        Assert.assertTrue(productsPage.isPageOpened, "Products page is not opened after login.")

        val productDetailsPage = productsPage.clickProductTitle(0)
        Assert.assertTrue(productDetailsPage.isPageOpened,
            "Product details page is not opened.")
        Assert.assertTrue(NON_EMPTY_STRING_PATTERN.matcher(productDetailsPage.getProductName()).matches(),
            "Product name is not displayed or is empty.")
        Assert.assertTrue(NON_EMPTY_STRING_PATTERN.matcher(productDetailsPage.getProductDescription()).matches(),
            "Product description is not displayed or is empty.")
        Assert.assertTrue(PRICE_PATTERN.matcher(productDetailsPage.getProductPrice()).matches(),
            "Product price is not displayed or is empty.")
        Assert.assertTrue(productDetailsPage.isAddToCartButtonPresent(),
            "Add to Cart button is not displayed.")
        Assert.assertTrue(productDetailsPage.isProductImagePresent(),
            "Product image is not displayed.")
        Assert.assertTrue(productDetailsPage.isBackToProductsButtonPresent(),
            "Back to Products button is not displayed.")
    }

    @Test(groups = ["functional"])
    @MethodOwner(owner = "saucedemoGuiDesktop")
    @TestLabel(name = "feature", value = ["web", "regression"])
    fun testAddProductToCart() {
        val loginPage = LoginPage(getDriver())
        loginPage.open()
        Assert.assertTrue(loginPage.isPageOpened, "Home page is not opened")

        loginPage.login(STANDARD_USERNAME, PASSWORD)

        val productsPage = ProductsPage(getDriver())
        Assert.assertTrue(productsPage.isPageOpened, "Products page is not opened after login")

        val firstProductCard = productsPage.getProductCards()[0]
        firstProductCard.clickAddToCartButton()

        Assert.assertEquals(firstProductCard.getButtonLabel(), "Remove", "Button label is not 'Remove'.")
        Assert.assertEquals(firstProductCard.getRemoveButtonColor(), RED_COLOR, "Unexpected color of remove button")

        val cartPage = productsPage.clickShoppingCartIcon()
        Assert.assertTrue(cartPage.isPageOpened, "Cart page is not opened.")
        Assert.assertEquals(cartPage.getCartItemsCount(), 1, "Cart does not contain the correct number of items.")

        val cartItem = cartPage.getCartItems()[0]
        Assert.assertTrue(NON_EMPTY_STRING_PATTERN.matcher(cartItem.getProductName()).matches(), "Product name is not displayed.")
        Assert.assertTrue(NON_EMPTY_STRING_PATTERN.matcher(cartItem.getProductDescription()).matches(), "Product description is not displayed.")
        Assert.assertTrue(PRICE_PATTERN.matcher(cartItem.getProductPrice()).matches(), "Product price is not displayed.")
        Assert.assertTrue(cartItem.isRemoveButtonPresent(), "'Remove' button is not displayed.")

        Assert.assertTrue(cartPage.isContinueShoppingButtonPresent(), "'Continue Shopping' button is not displayed.")
        Assert.assertTrue(cartPage.isCheckoutButtonPresent(), "'Checkout' button is not displayed.")
    }
     */
}