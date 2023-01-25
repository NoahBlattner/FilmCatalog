package com.divtec.blatnoa.filmcatalog.API.ApiObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApiKeyInfo implements JsonConvertible {
    public int count;
    public int maximum;
    public String account;
    public String expireDate;
    public String errorMessage;

    public ApiKeyInfo(int count, int maximum, String account, String expireDate, String errorMessage) {
        this.count = count;
        this.maximum = maximum;
        this.account = account;
        this.expireDate = expireDate;
        this.errorMessage = errorMessage;
    }

    public int getCount() {
        return count;
    }

    public int getMaximum() {
        return maximum;
    }

    public String getAccount() {
        return account;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Checks if the key has expired
     * @return true if the key has expired
     */
    public boolean isExpired() {
        if (getExpireDate() == null) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date expireDate = null;

        try {
            // Get the expire date from the string
            expireDate = sdf.parse(getExpireDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // If today is after the expire date, then the key is expired
        Date currentDate = new Date();
        return currentDate.after(expireDate);
    }

    /**
     * Checks if the key has exceeded the maximum number of requests
     * @return true if the key has exceeded the maximum number of requests
     */
    public boolean isExceeded() {
        return getCount() >= getMaximum();
    }

    public boolean isOk() {
        return errorMessage.isEmpty() && !isExpired() && !isExceeded();
    }
}

