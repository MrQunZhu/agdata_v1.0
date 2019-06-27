package org.clesun.entity;

/**
 * Created by clesun on 2017/6/19.
 */
public class DisTrictEntity {
    private String province; //省
    private String city; //市
    private String citycode; //城市编码
    private String district; //区/县
    private String adcode; //行政区编码
    private String township; //乡镇/街道
    private String towncode; //乡镇街道编码
    private String formatted_address; //结构化地址信息：省+市+区+乡镇+街道+门牌号

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

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public String getTowncode() {
        return towncode;
    }

    public void setTowncode(String towncode) {
        this.towncode = towncode;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    @Override
    public String toString() {
        return "DisTrictEntity{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", citycode='" + citycode + '\'' +
                ", district='" + district + '\'' +
                ", adcode='" + adcode + '\'' +
                ", township='" + township + '\'' +
                ", towncode='" + towncode + '\'' +
                ", formatted_address='" + formatted_address + '\'' +
                '}';
    }
}
