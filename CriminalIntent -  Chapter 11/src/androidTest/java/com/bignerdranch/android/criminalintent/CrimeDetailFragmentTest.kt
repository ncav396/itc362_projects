package com.bignerdranch.android.criminalintent

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class CrimeDetailFragmentTest {


    //fragment scenario
    @Test
    fun editTextUpdatesCrimeTitle() {
        val scenario: FragmentScenario<CrimeDetailFragment> =
            launchFragmentInContainer(themeResId = R.style.Theme_criminalintent)
        onView(withId(R.id.crime_title)).perform(typeText("New Crime Title"))
        //Check that the fragment's crime.title is set to the new text
        scenario.onFragment { fragment ->
            assertEquals(fragment.crime.title, "New Crime Title")
        }
    }

    @Test
    fun checkBoxUpdatesCrimeSolved() {
        val scenario: FragmentScenario<CrimeDetailFragment> =
            launchFragmentInContainer(themeResId = R.style.Theme_criminalintent)

        onView(withId(R.id.crime_solved)).perform(click())
        scenario.onFragment { fragment ->
            assertTrue(fragment.crime.isSolved)
        }
    }
}
