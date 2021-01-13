package com.huypham.fastlaneandbeyond

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import tools.fastlane.screengrab.Screengrab
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy
import tools.fastlane.screengrab.locale.LocaleTestRule

/**
 * @author huypham on 1/11/21
 */
@RunWith(JUnit4::class)
class ExampleInstrumentedTest {
    // JVMField needed!
    @Rule
    @JvmField
    val localeTestRule = LocaleTestRule()

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    @Test
    fun testTakeScreenshot() {
        activityRule.launchActivity(null)

        // 1. Prepares to take a screenshot of the app
        Screengrab.setDefaultScreenshotStrategy(UiAutomatorScreenshotStrategy())
        Espresso.onView(ViewMatchers.withId(R.id.btnAsk))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        // 2. Takes a screenshot of the first screen
        Screengrab.screenshot("magic_ball_before_click")

        // 3. Selects the Ask button and triggers a click on it
        Espresso.onView(ViewMatchers.withId(R.id.btnAsk))
            .perform(ViewActions.click())

        // 4. Take another screenshot
        Screengrab.screenshot("magic_ball_after_click")
    }
}