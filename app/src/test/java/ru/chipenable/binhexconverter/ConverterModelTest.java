package ru.chipenable.binhexconverter;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ConverterModelTest {

    private static final int AMOUNT_TESTS = 20;
    private static final int MAX_INT_TEST_VALUE = 0xffff;

    private IConverterModel model;
    private Random random;

    @Before
    public void createConverterModel(){
        model = new Model(null);
        random = new Random();
    }

    @Test
    public void hexConverterTest() throws Exception {

        for (int i = 0; i < AMOUNT_TESTS; i++) {
            int value = Math.abs(random.nextInt(MAX_INT_TEST_VALUE));

            String decStr = Integer.toString(value);
            String hexStr = Integer.toHexString(value).toUpperCase();
            String binStr = Integer.toBinaryString(value);

            String decTestStr = model.hexToDec(hexStr);
            assertEquals(decStr, decTestStr);

            String binTestStr = model.hexToBin(hexStr);
            assertEquals(binStr, binTestStr);
        }
    }

    @Test
    public void decConverterTest() throws Exception {

        for (int i = 0; i < AMOUNT_TESTS; i++) {
            int value = Math.abs(random.nextInt(MAX_INT_TEST_VALUE));

            String decStr = Integer.toString(value);
            String hexStr = Integer.toHexString(value).toUpperCase();
            String binStr = Integer.toBinaryString(value);

            String hexTestStr = model.decToHex(decStr);
            assertEquals(hexStr, hexTestStr);

            String binTestStr = model.decToBin(decStr);
            assertEquals(binStr, binTestStr);
        }
    }

    @Test
    public void binConverterTest() throws Exception {

        for (int i = 0; i < AMOUNT_TESTS; i++) {
            int value = Math.abs(random.nextInt(MAX_INT_TEST_VALUE));

            String decStr = Integer.toString(value);
            String hexStr = Integer.toHexString(value).toUpperCase();
            String binStr = Integer.toBinaryString(value);

            String hexTestStr = model.binToHex(binStr);
            assertEquals(hexStr, hexTestStr);

            String decTestStr = model.binToDec(binStr);
            assertEquals(decStr, decTestStr);
        }
    }

}