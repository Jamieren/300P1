//Arian Popal UCID 30189384
package com.thelocalmarketplace.software;

import java.math.BigDecimal;
import com.jjjwelectronics.Coin;
import com.jjjwelectronics.CoinSlot;
import com.jjjwelectronics.CoinValidator;
import com.jjjwelectronics.CoinStorageUnit;
import com.jjjwelectronics.DisabledException;

public class CoinPayment {
    private CoinSlot coinSlot;
    private CoinValidator coinValidator;
    private CoinStorageUnit coinStorage;
    private boolean debug = false;
    private BigDecimal coinRemain;

    public CoinPayment(CoinSlot coinSlot, CoinValidator coinValidator, CoinStorageUnit coinStorage) {
        this.coinSlot = coinSlot;
        this.coinValidator = coinValidator;
        this.coinStorage = coinStorage;

        initializeCoinSlotListener();
        initializeCoinValidatorListener();
    }

    private void initializeCoinSlotListener() {
        coinSlot.register(new CoinSlotListener() {
            @Override
            public void coinInserted(CoinSlot slot) {
                if (debug) System.out.println("Coin is inserted!");
            }

            @Override
            public void enabled(AbstractDevice<?> device) {
                // Handle device enabled event
            }

            @Override
            public void disabled(AbstractDevice<?> device) {
                // Handle device disabled event
            }
        });
    }

    private void initializeCoinValidatorListener() {
        coinValidator.register(new CoinValidatorListener() {
            @Override
            public void validCoinDetected(CoinValidator validator, BigDecimal value) {
                coinRemain = value;

                if (coinRemain.compareTo(BigDecimal.ZERO) > 0) {
                    if (coinStorage.hasSpace()) {
                        coinRemain = coinRemain.subtract(coinRemain);
                    }
                } else {
                    coinSlot.disable();
                }
            }

            @Override
            public void invalidCoinDetected(CoinValidator validator) {
                if (debug) System.out.println("Invalid coin detected!");
            }

            @Override
            public void enabled(AbstractDevice<?> device) {
                // Handle device enabled event
            }

            @Override
            public void disabled(AbstractDevice<?> device) {
                // Handle device disabled event
            }
        });
    }
}
