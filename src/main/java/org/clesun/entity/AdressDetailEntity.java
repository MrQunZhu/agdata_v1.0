package org.clesun.entity;

public class AdressDetailEntity {
    private String province; //省
    private String city; //市
    private String county; //县
    private String town; //乡镇
    private String subdistrict; //村
    private String address; //详细地址
    private String postalcode; //邮政编码
    private String lng; //经纬度
    private String lat;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getSubdistrict() {
        return subdistrict;
    }

    public void setSubdistrict(String subdistrict) {
        this.subdistrict = subdistrict;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "AdressDetailEntity{" + "province='" + province + '\'' + ", city='" + city + '\'' + ", county='" + county + '\'' + ", town='" + town + '\'' + ", subdistrict='" + subdistrict + '\'' + ", address='" + address + '\'' + ", postalcode='" + postalcode + '\'' + ", lng='" + lng + '\'' + ", lat='" + lat + '\'' + '}';
    }
}
