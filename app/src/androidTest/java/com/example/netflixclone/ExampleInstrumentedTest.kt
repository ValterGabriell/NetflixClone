package com.example.netflixclone

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.netflixclone.View.Activities.CreatePerfilActivity
import com.example.netflixclone.View.Activities.MainActivity

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    var mainActivity : IntentsTestRule<MainActivity> = IntentsTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.netflixclone", appContext.packageName)
    }

    @Test
    fun testEt(){
        onView(withId(R.id.imgAddPerfil)).perform(click())
        onView(withId(R.id.etNameUser)).perform(typeText("Gabriel"))
        onView(withId(R.id.switch1)).perform(click())
    }

    @Test
    fun testEtWithNoChild(){
        onView(withId(R.id.imgAddPerfil)).perform(click())
        onView(withId(R.id.etNameUser)).perform(typeText("Pedro"))
    }

}