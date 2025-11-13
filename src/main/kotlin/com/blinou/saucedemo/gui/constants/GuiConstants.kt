package com.blinou.saucedemo.gui.constants

/**
 * SwagDemo GUI Test Automation Project
 * Author: Artyom Blinov
 * Year: 2025
 */

import com.zebrunner.carina.utils.R

object GuiConstants {
    val STANDARD_USERNAME: String = R.TESTDATA.get("saucedemo.standard.username")
    val LOCKED_OUT_USERNAME: String = R.TESTDATA.get("saucedemo.locked.out.username")
    val PROBLEM_USERNAME: String = R.TESTDATA.get("saucedemo.problem.username")
    val PERFORMANCE_GLITCH_USERNAME: String = R.TESTDATA.get("saucedemo.performance.glitch.username")
    val VISUAL_USERNAME: String = R.TESTDATA.get("saucedemo.visual.username")
    val ERROR_USERNAME: String = R.TESTDATA.get("saucedemo.error.username")
    val PASSWORD: String = R.TESTDATA.get("saucedemo.password")

    const val EXPECTED_ERROR_MESSAGE = "Epic sadface: Sorry, this user has been locked out."

    //const val EXPECTED_ERROR_MESSAGE_LOCKED_OUT_USER = "Sorry, this user has been locked out."
    const val EXPECTED_ERROR_MESSAGE_INVALID_CREDENTIALS = "Username and password do not match any user in this service."

    const val COLOR_NAME = "color"
    const val RED_COLOR = "rgba(226, 35, 26, 1)"
}