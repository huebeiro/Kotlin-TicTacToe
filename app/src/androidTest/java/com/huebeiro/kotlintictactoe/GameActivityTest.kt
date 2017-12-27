package com.huebeiro.kotlintictactoe

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import com.huebeiro.kotlintictactoe.model.Player

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

    @Test
    fun checkTurnIteration() {
        //First turn should be for X player
        Espresso.onView(ViewMatchers.withId(R.id.button00))
                .perform(ViewActions.click())
                .check(ViewAssertions.matches(ViewMatchers.withText(Player.X.toString())))

        //Second turn should be for O player
        Espresso.onView(ViewMatchers.withId(R.id.button01))
                .perform(ViewActions.click())
                .check(ViewAssertions.matches(ViewMatchers.withText(Player.O.toString())))

    }

    @Test
    fun checkWinnerPlayerX(){
        //Makes a series of moves in order to make Player X win
        Espresso.onView(ViewMatchers.withId(R.id.button00)) //X
                .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.button01)) //O
                .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.button10)) //X
                .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.button11)) //O
                .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.button20)) //X winning move
                .perform(ViewActions.click())

        //Checks if the winner message has successfully shown
        Espresso.onView(ViewMatchers.withId(R.id.winnerPlayerLabel))
                .check(ViewAssertions.matches(ViewMatchers.withText(Player.X.toString())))
    }

    @Test
    fun checkWinnerPlayerO(){
        //Makes a series of moves in order to make Player O win
        Espresso.onView(ViewMatchers.withId(R.id.button00)) //X
                .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.button01)) //O
                .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.button10)) //X
                .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.button11)) //O
                .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.button02)) //X
                .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.button21)) //O Winning Move
                .perform(ViewActions.click())

        //Checks if the winner message has successfully shown
        Espresso.onView(ViewMatchers.withId(R.id.winnerPlayerLabel))
                .check(ViewAssertions.matches(ViewMatchers.withText(Player.O.toString())))
    }

}