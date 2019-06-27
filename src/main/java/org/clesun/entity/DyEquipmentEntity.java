package org.clesun.entity;

/**
 * Created by clesun on 2017/11/14.
 */
public class DyEquipmentEntity extends DyEquipment {
    private String baseName;//基地名称
    private String workUnitName;//设备名称
    private String imageUrl;//设备图片
    private String address;//设备所在地点



    public String getWorkUnitName() {
        return workUnitName;
    }

    public void setWorkUnitName(String workUnitName) {
        this.workUnitName = workUnitName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
