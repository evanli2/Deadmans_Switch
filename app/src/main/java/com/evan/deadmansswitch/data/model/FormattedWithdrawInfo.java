package com.evan.deadmansswitch.data.model;

import com.evan.deadmansswitch.util.Constants;
import com.evan.deadmansswitch.util.DateConverter;
import com.evan.deadmansswitch.util.WalletUtil;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class FormattedWithdrawInfo {

    private final String formattedDateWithdrawn;
    private final String formattedAmount;

    public FormattedWithdrawInfo(Withdrawal withdrawal) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_PATTERN, Locale.US);
        long dateWithdrawn = DateConverter.secondsToMilliseconds(BigInteger.valueOf(withdrawal.getDateWithdrawn()));

        this.formattedDateWithdrawn = dateFormat.format(dateWithdrawn);
        this.formattedAmount = WalletUtil.formatBalance(BigInteger.valueOf(withdrawal.getAmount()));
    }

    public String getFormattedDateWithdrawn() {
        return formattedDateWithdrawn;
    }

    public String getFormattedAmount() {
        return formattedAmount;
    }

}
