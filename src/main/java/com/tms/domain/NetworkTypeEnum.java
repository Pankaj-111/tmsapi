package com.tms.domain;

public enum NetworkTypeEnum {
    NWTWORK_2G("2G"),
    NETWORK_3G("3G"),
    NETWORK_4G("4G"),
    NETWORK_WIFI("WIFI");

    private final String text;

    
    NetworkTypeEnum(final String text) {
        this.text = text;
    }
    
    @Override
    public String toString() {
        return text;
    }
}
