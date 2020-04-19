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
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MenuActivityTest {

    @Rule
    public ActivityTestRule<SplashActivity> mActivityTestRule = new ActivityTestRule<>(SplashActivity.class);

    @Test
    public void menuActivityTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // GIVEN

        ViewInteraction appCompatImageButton = onView(withId(R.id.spanishButton));
        appCompatImageButton.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction linearLayout = onView(withId(R.id.sobreCorea_btn));
        linearLayout.perform(scrollTo(), click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction imageButton = onView(withId(R.id.preguntasFrecuentesImageButton));
        imageButton.check(matches(isDisplayed()));

        ViewInteraction textView = onView(withId(R.id.tripkoTextView));
        textView.check(matches(withText("TripKo")));

        ViewInteraction imageButton2 = onView(withId(R.id.homeImageButton));
        imageButton2.check(matches(isDisplayed()));

        ViewInteraction viewGroup = onView(withId(R.id.cabecera));
        viewGroup.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(withId(R.id.sobreCoreaTitle));
        textView2.check(matches(withText("Sobre Corea del Sur")));

        ViewInteraction imageView = onView(withId(R.id.image1));
        imageView.check(matches(isDisplayed()));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.sobreCoreaDescriptionText), withText("La República de Corea es un país soberano de Asia Oriental, cuyo territorio comprende la mitad sur de la península de Corea englobando unas tres mil islas que la rodean. Aproximadamente la mitad de la población del país vive en su capital, Seúl, o en su zona metropolitana, que es una de las áreas metropolitanas más pobladas del mundo. Corea es una de las civilizaciones más antiguas del mundo, su idioma oficial es el coreano y su moneda el won coreano."),
                        childAtPosition(
                                allOf(withId(R.id.LinearLayout),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                                0)),
                                2),
                        isDisplayed()));
        textView3.check(matches(withText("La República de Corea es un país soberano de Asia Oriental, cuyo territorio comprende la mitad sur de la península de Corea englobando unas tres mil islas que la rodean. Aproximadamente la mitad de la población del país vive en su capital, Seúl, o en su zona metropolitana, que es una de las áreas metropolitanas más pobladas del mundo. Corea es una de las civilizaciones más antiguas del mundo, su idioma oficial es el coreano y su moneda el won coreano.")));

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.image2),
                        childAtPosition(
                                allOf(withId(R.id.LinearLayout),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                                0)),
                                3),
                        isDisplayed()));
        imageView2.check(matches(isDisplayed()));
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
