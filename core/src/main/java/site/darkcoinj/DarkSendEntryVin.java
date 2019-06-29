package org.darkcoinj;

import site.mtnsj.core.NetworkParameters;
import site.mtnsj.core.TransactionInput;

/**
 * Created by Eric on 2/8/2015.
 * modified OmotenashiCoin Project by kani
 */
public class DarkSendEntryVin {
    boolean isSigSet;
    TransactionInput vin;

    DarkSendEntryVin(NetworkParameters params)
    {
        isSigSet = false;
        vin = new TransactionInput(params, null, null);  //need to set later
    }
}
