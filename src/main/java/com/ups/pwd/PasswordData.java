package com.ups.pwd;

import java.text.SimpleDateFormat;

public class PasswordData implements Comparable<PasswordData> {
    private String serverName;
    private String accountName;
    private Long lastChanged;

    public PasswordData(String serverName, String accountName, long lastChanged) {
        this.serverName = serverName;
        this.accountName = accountName;
        this.lastChanged = lastChanged;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public long getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(long lastChanged) {
        this.lastChanged = lastChanged;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        long epoch = this.lastChanged.longValue() * 24 * 60 * 60 * 1000;
        return this.serverName + "," + this.accountName + "," + sdf.format(epoch) + "\n";
    }

    @Override
    public int compareTo(PasswordData o) {
        return this.lastChanged.compareTo(o.lastChanged);
    }

}
