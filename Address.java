package com.whs.wcdm.pojo;

import org.springframework.data.annotation.Id;

/**
 * Created by oem on 23/03/17.
 */
public class Address {
    @Id
    private String id;

    private String country;

    private String city;

    public Address() {
    }

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
