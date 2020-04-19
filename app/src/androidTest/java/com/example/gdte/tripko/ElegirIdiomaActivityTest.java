package com.example.gdte.tripko;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.splash.SplashActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ElegirIdiomaActivityTest {

    @Rule
    public ActivityTestRule<SplashActivity> mActivityTestRule = new ActivityTestRule<>(SplashActivity.class);

    @Test
    public void elegirIdiomaActivityTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // GIVEN

        ViewInteraction imageButton = onView(withId(R.id.spanishButton));
        imageButton.check(matches(isDisplayed()));

        ViewInteraction imageButton2 = onView(withId(R.id.englishButton));
        imageButton2.check(matches(isDisplayed()));

        // WHEN

        ViewInteraction appCompatImageButton = onView(withId(R.id.spanishButton));
        appCompatImageButton.perform(click());

        // THEN
        ViewInteraction linearLayout = onView(withId(R.id.sobreCorea_btn));
        linearLayout.check(matches(isDisplayed()));

        ViewInteraction linearLayout2 = onView(withId(R.id.idioma_btn));
        linearLayout2.check(matches(isDisplayed()));

        ViewInteraction linearLayout3 = onView(withId(R.id.conversion_de_moneda_btn));
        linearLayout3.check(matches(isDisplayed()));

        ViewInteraction linearLayout4 = onView(withId(R.id.transporte_btn));
        linearLayout4.check(matches(isDisplayed()));

        ViewInteraction linearLayout5 = onView(withId(R.id.entretenimiento_btn));
        linearLayout5.check(matches(isDisplayed()));

        ViewInteraction linearLayout6 = onView(withId(R.id.gastronomia_btn));
        linearLayout6.check(matches(isDisplayed()));

        ViewInteraction linearLayout7 = onView(withId(R.id.sitios_turisticos_btn));
        linearLayout6.check(matches(isDisplayed()));

        ViewInteraction linearLayout8 = onView(withId(R.id.contactos_de_interes_btn));
        linearLayout6.check(matches(isDisplayed()));


    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
