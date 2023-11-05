package com.thelocalmarketplace.software;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

import java.math.BigDecimal;
import com.jjjwelectronics.Coin;
import com.jjjwelectronics.CoinSlot;
import com.jjjwelectronics.CoinValidator;
import com.jjjwelectronics.CoinStorageUnit;
import com.jjjwelectronics.DisabledException;


public class coinPaymentTest() {

        // Initializing Slot, Validator, Unit and Paymeny objects
        private CoinSlot coinSlot;
        private CoinValidator coinValidator;
        private CoinStorageUnit coinStorageUnit;
        private CoinPayment coinPayment;

        
        @Before
        public void setUp() {

        // Creates the stub for the classes
        coinSlot = new coinSlotStub();
        coinValidator = new coinValidatorStub();
        coinStorage = new CoinStorageUnitStub()'

        // Initializes a CoinPayment instance 
        coinPayment = new CoinPayment(coinSlot, coinValidator, coinStorage);

        }

        @Test
        public void testCoinInserted() {

                // Simulate a coin being inserted
                CoinSlotListener listener = coinSlot.getListener();
                listener.coinInserted(coinSlot);

                // Add an assertion here

        }

        @Test
        public void testValidCoinDetected() {

                // Simulate a valid coin being detected
                CoinValidatorListener listener = coinValidator.getListener();
                listener.validCoinDetected(coinValidator, new BigDecimal("1.00"));

                // Assert that your expected behavior occurs
                assertEquals(new BigDecimal("1.00"), coinPayment.getCoinRemain());
                assertTrue(coinStorage.hasSpace());

         }

         @Test
        public void testInvalidCoinDetected() {

                // Simulate an invalid coin being detected
                CoinValidatorListener listener = coinValidator.getListener();
                listener.invalidCoinDetected(coinValidator);

                // Add some assertions here

         }

        @Test
        public void testCoinPaymentDisabled() {

                // Simulate coinRemain being zero
                CoinValidatorListener listener = coinValidator.getListener();
                listener.validCoinDetected(coinValidator, BigDecimal.ZERO);
        
                // Checks that the coinSlot is disabled
                assertFalse(coinSlot.isEnabled());
        }


        // Stub implementations for CoinSlot, CoinValidator
        private class CoinSlotStub() {

                private CoinSlotListener listener;
                private boolean enabled = true;


                @Override
                public void register( CoinSlotListener listener ) {

                        this.listener = listener;

                }

                public CoinSlotListener getListener() {
                        return listener;
                }

                public boolean isEnabled() {

                        return enabled;

                }

                public void setEnable () {

                        this.enabled = enabled;

                }

        }

        private class CoinValidatorStub extends CoinValidator {
                private CoinValidatorListener listener;

                @Override
                public void register(CoinValidatorListener listener) {

                this.listener = listener;

                }

                public CoinValidatorListener getListener() {

                    return listener;

                }
        }

}
