package org.clesun.entity;

public class DyEquipment {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dy_equipment.equipment_id
     *
     * @mbggenerated Tue Nov 14 11:47:37 CST 2017
     */
    private Long equipmentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dy_equipment.addr
     *
     * @mbggenerated Tue Nov 14 11:47:37 CST 2017
     */
    private String addr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dy_equipment.equipment_lng
     *
     * @mbggenerated Tue Nov 14 11:47:37 CST 2017
     */
    private Double equipmentLng;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dy_equipment.equipment_lat
     *
     * @mbggenerated Tue Nov 14 11:47:37 CST 2017
     */
    private Double equipmentLat;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dy_equipment.farm_id
     *
     * @mbggenerated Tue Nov 14 11:47:37 CST 2017
     */
    private Long farmId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dy_equipment.equipment_id
     *
     * @return the value of dy_equipment.equipment_id
     *
     * @mbggenerated Tue Nov 14 11:47:37 CST 2017
     */
    public Long getEquipmentId() {
        return equipmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dy_equipment.equipment_id
     *
     * @param equipmentId the value for dy_equipment.equipment_id
     *
     * @mbggenerated Tue Nov 14 11:47:37 CST 2017
     */
    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dy_equipment.addr
     *
     * @return the value of dy_equipment.addr
     *
     * @mbggenerated Tue Nov 14 11:47:37 CST 2017
     */
    public String getAddr() {
        return addr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dy_equipment.addr
     *
     * @param addr the value for dy_equipment.addr
     *
     * @mbggenerated Tue Nov 14 11:47:37 CST 2017
     */
    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dy_equipment.equipment_lng
     *
     * @return the value of dy_equipment.equipment_lng
     *
     * @mbggenerated Tue Nov 14 11:47:37 CST 2017
     */
    public Double getEquipmentLng() {
        return equipmentLng;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dy_equipment.equipment_lng
     *
     * @param equipmentLng the value for dy_equipment.equipment_lng
     *
     * @mbggenerated Tue Nov 14 11:47:37 CST 2017
     */
    public void setEquipmentLng(Double equipmentLng) {
        this.equipmentLng = equipmentLng;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dy_equipment.equipment_lat
     *
     * @return the value of dy_equipment.equipment_lat
     *
     * @mbggenerated Tue Nov 14 11:47:37 CST 2017
     */
    public Double getEquipmentLat() {
        return equipmentLat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dy_equipment.equipment_lat
     *
     * @param equipmentLat the value for dy_equipment.equipment_lat
     *
     * @mbggenerated Tue Nov 14 11:47:37 CST 2017
     */
    public void setEquipmentLat(Double equipmentLat) {
        this.equipmentLat = equipmentLat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dy_equipment.farm_id
     *
     * @return the value of dy_equipment.farm_id
     *
     * @mbggenerated Tue Nov 14 11:47:37 CST 2017
     */
    public Long getFarmId() {
        return farmId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dy_equipment.farm_id
     *
     * @param farmId the value for dy_equipment.farm_id
     *
     * @mbggenerated Tue Nov 14 11:47:37 CST 2017
     */
    public void setFarmId(Long farmId) {
        this.farmId = farmId;
    }
}