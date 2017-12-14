package com.huebeiro.kotlintictactoe

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers

import com.huebeiro.kotlintictactoe.view.GameActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Author: Adilson Ribeiro
 * Date: 14/12/17
 */

@RunWith(AndroidJUnit4::class)
class GameActivityTest {

    @get:Rule
    val main = ActivityTestRule<GameActivity>(GameActivity::class.java)

    @Test
    fun hasInitializedGameUI() {
        Espresso.onView(ViewMatchers.withId(R.id.button00))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}