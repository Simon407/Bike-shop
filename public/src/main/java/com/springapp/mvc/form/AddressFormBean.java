package com.springapp.mvc.form;

import javax.validation.constraints.Size;

public class AddressFormBean {

    @Size(min = 1, max = 50, message = "Название города должно быть от 1 до 50 символов")
    private String city;

    @Size(min = 1, max = 50, message = "Название улицы должно быть от 1 до 50 символов")
    private String street;

    @Size(min = 1, max = 9, message = "Номер дома должен быть от 1 до 9 символов")
    private String house;

    @Size(min = 1, max = 9, message = "Номер квартиры должен быть от 1 до 9 символов, если нет то 0")
    private String flat;

    @Size(min = 6, max = 6, message = "Индекс должен быть 6 символов")
    private String index;

    @Override
    public String toString() {
        return "OrderFormBean{" +
                ", city='" + city + '\'' +
                ", flat='" + flat + '\'' +
                ",  street='" + street + '\'' +
                ", house='" + house + '\'' +
                ",index='" + index + '\'' +
                '}';
    }

    public AddressFormBean(String city, String street, String house, String flat, String index) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.index = index;
    }

    public AddressFormBean() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
