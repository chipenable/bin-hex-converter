package ru.chipenable.binhexconverter;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Pashgan on 23.05.2016.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ConverterTest {

    private static final int MAX_TEST_INTEGER = (int)Math.pow(2, 32);
    private static final int AMOUNT_CONV_TESTS = 20;
    private static final int AMOUNT_ROTATION_TESTS = 10;

    private Random mRandom;

    @Rule
    public ActivityTestRule<MainActivity> mActivity = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void init(){
        mRandom = new Random();
    }

    @Test
    public void activityTest(){
        Assert.assertNotNull(mActivity);
    }

    @Test
    public void decConverterTest(){

        for(int i = 0; i < AMOUNT_CONV_TESTS; i++){
            int nextRandom = Math.abs(mRandom.nextInt(MAX_TEST_INTEGER));
            String decStr = Integer.toString(nextRandom);
            String hexStr = Integer.toHexString(nextRandom).toUpperCase();
            String binStr = Integer.toBinaryString(nextRandom);

            onView(withId(R.id.dec_edit_text))
                    .perform(clearText())
                    .perform(typeText(decStr))
                    .perform(closeSoftKeyboard());

            onView(withId(R.id.hex_edit_text))
                    .check(matches(withText(hexStr)));

            onView(withId(R.id.bin_edit_text))
                    .check(matches(withText(binStr)));
        }
    }

    @Test
    public void hexConverterTest(){

        for(int i = 0; i < AMOUNT_CONV_TESTS; i++){

            int nextRandom = Math.abs(mRandom.nextInt(MAX_TEST_INTEGER));
            String decStr = Integer.toString(nextRandom);
            String hexStr = Integer.toHexString(nextRandom).toUpperCase();
            String binStr = Integer.toBinaryString(nextRandom);

            onView(withId(R.id.hex_edit_text))
                    .perform(clearText())
                    .perform(typeText(hexStr))
                    .perform(closeSoftKeyboard());

            onView(withId(R.id.dec_edit_text))
                    .check(matches(withText(decStr)));

            onView(withId(R.id.bin_edit_text))
                    .check(matches(withText(binStr)));
        }
    }

    @Test
    public void binConverterTest(){

        for(int i = 0; i < AMOUNT_CONV_TESTS; i++){
            int nextRandom = Math.abs(mRandom.nextInt(MAX_TEST_INTEGER));
            String decStr = Integer.toString(nextRandom);
            String hexStr = Integer.toHexString(nextRandom).toUpperCase();
            String binStr = Integer.toBinaryString(nextRandom);

            onView(withId(R.id.bin_edit_text))
                    .perform(clearText())
                    .perform(typeText(binStr))
                    .perform(closeSoftKeyboard());

            onView(withId(R.id.dec_edit_text))
                    .check(matches(withText(decStr)));

            onView(withId(R.id.hex_edit_text))
                    .check(matches(withText(hexStr)));
        }
    }

    @Test
    public void rotationTest(){

        for(int i = 0; i < AMOUNT_ROTATION_TESTS; i++) {
            int nextRandom = Math.abs(mRandom.nextInt(MAX_TEST_INTEGER));
            String decStr = Integer.toString(nextRandom);
            String hexStr = Integer.toHexString(nextRandom).toUpperCase();
            String binStr = Integer.toBinaryString(nextRandom);

            onView(withId(R.id.dec_edit_text))
                    .perform(clearText())
                    .perform(typeText(decStr))
                    .perform(closeSoftKeyboard());

            InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
                @Override
                public void run() {
                    mActivity.getActivity().recreate();
                }
            });

            onView(withId(R.id.dec_edit_text))
                    .check(matches(withText(decStr)));

            onView(withId(R.id.hex_edit_text))
                    .check(matches(withText(hexStr)));

            onView(withId(R.id.bin_edit_text))
                    .check(matches(withText(binStr)));
        }
    }

}
