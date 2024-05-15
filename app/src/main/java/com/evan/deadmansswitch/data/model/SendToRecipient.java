package com.evan.deadmansswitch.data.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SendToRecipient {

    private CharSequence recipientAddress = "";
    private CharSequence amountLisk = "";
    private CharSequence comments = "";

    private SendToRecipient() {
    }

    public static SendToRecipient createEmptyRecipient() {
        return new SendToRecipient();
    }

    public String getRecipientAddress() {
        return recipientAddress.toString();
    }

    public void setRecipientAddress(CharSequence recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getAmountLisk() {
        return amountLisk.toString();
    }

    public BigInteger getAmountLiskAsBigInt() {
        BigDecimal amountDecimal = new BigDecimal(amountLisk.toString());
        return amountDecimal.multiply(BigDecimal.valueOf(10).pow(18)).toBigInteger();
    }

    public void setAmountLisk(CharSequence amountLisk) {
        this.amountLisk = amountLisk;
    }

    public String getComments() {
        return comments.toString();
    }

    public void setComments(CharSequence comments) {
        this.comments = comments;
    }
}
