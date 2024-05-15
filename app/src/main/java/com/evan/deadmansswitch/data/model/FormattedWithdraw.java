package com.evan.deadmansswitch.data.model;

import com.evan.deadmansswitch.util.Constants;
import com.evan.deadmansswitch.util.DateConverter;
import com.evan.deadmansswitch.util.WalletUtil;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class FormattedWithdraw {

    private final String formattedDateWithdrawn;
    private final String contractAddress;
    private final String formattedAmount;

    public FormattedWithdraw(long dateWithdrawnSeconds, String contractAddress, BigInteger amountWei) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_PATTERN, Locale.US);

        this.formattedDateWithdrawn = dateFormat.format(
                DateConverter.secondsToMilliseconds(BigInteger.valueOf(dateWithdrawnSeconds)));
        this.contractAddress = contractAddress;
        this.formattedAmount = WalletUtil.formatBalance(amountWei);
    }

    public String getFormattedDateWithdrawn() {
        return formattedDateWithdrawn;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public String getFormattedAmount() {
        return formattedAmount;
    }
}
