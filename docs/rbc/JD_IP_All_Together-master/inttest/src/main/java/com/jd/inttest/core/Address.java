package com.jd.inttest.core;

/**
 * Created by jd birla on 02-02-2023 at 13:38
 */
public class Address {
    private String city;
    private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address() {
        super();
    }

    public Address(String city, String country) {
        super();
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", country=" + country + "]";
    }
}
