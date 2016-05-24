package ru.chipenable.binhexconverter;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

/**
 * Created by Pashgan on 24.05.2016.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class RepositoryTest {

    private static final int AMOUNT_TESTS = 10;
    private IConverterRepository mRepo;
    private Random mRandom;

    @Before
    public void createRepo(){
        mRepo = new Repository(InstrumentationRegistry.getContext());
        mRandom = new Random();
    }

    @Test
    public void repoTest(){
        for(int i = 0; i < AMOUNT_TESTS; i++){
            String key = Integer.toString(mRandom.nextInt());
            String value = Integer.toString(mRandom.nextInt());

            mRepo.saveData(key, value);
            String savedValue = mRepo.restoreData(key);

            Assert.assertEquals(savedValue, value);
        }
    }
}
