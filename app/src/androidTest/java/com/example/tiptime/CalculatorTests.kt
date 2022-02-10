package com.example.tiptime

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorTests {
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_20_tip() {
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00"))

        onView(withId(R.id.calculate_button)).perform(click())

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("10.00"))))
    }

    @Test
    fun calculate_20_tip_without_round_up() {
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.50"))

        onView(withId(R.id.calculate_button)).perform(click())

        onView(withId(R.id.round_up_switch)).perform(click())

        onView(withId(R.id.tip_result)).check(matches(withText(containsString("10.10"))))
    }

    @Test
    fun calculate_18_tip() {
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("100.00"))

        onView(withId(R.id.calculate_button)).perform(click())

        onView(withId(R.id.tip_result)).check(matches(withText(containsString("18.00"))))
    }

    @Test
    fun calculate_18_tip_without_round_up() {
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("180.00"))

        onView(withId(R.id.calculate_button)).perform(click())

        onView(withId(R.id.round_up_switch)).perform(click())

        onView(withId(R.id.tip_result)).check(matches(withText(containsString("32.40"))))
    }

    @Test
    fun calculate_15_tip() {
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("100.00"))

        onView(withId(R.id.calculate_button)).perform(click())

        onView(withId(R.id.tip_result)).check(matches(withText(containsString("15.00"))))
    }

    @Test
    fun calculate_15_tip_without_round_up() {
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("150.00"))

        onView(withId(R.id.calculate_button)).perform(click())

        onView(withId(R.id.round_up_switch)).perform(click())

        onView(withId(R.id.tip_result)).check(matches(withText(containsString("22.5"))))
    }
}