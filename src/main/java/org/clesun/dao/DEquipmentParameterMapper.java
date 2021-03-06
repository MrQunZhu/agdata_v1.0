package org.clesun.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.clesun.entity.DEquipmentParameter;
import org.clesun.entity.DEquipmentParameterExample;

public interface DEquipmentParameterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    int countByExample(DEquipmentParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    int deleteByExample(DEquipmentParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    int deleteByPrimaryKey(Long paramentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    int insert(DEquipmentParameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    int insertSelective(DEquipmentParameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    List<DEquipmentParameter> selectByExample(DEquipmentParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    DEquipmentParameter selectByPrimaryKey(Long paramentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    int updateByExampleSelective(@Param("record") DEquipmentParameter record, @Param("example") DEquipmentParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    int updateByExample(@Param("record") DEquipmentParameter record, @Param("example") DEquipmentParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    int updateByPrimaryKeySelective(DEquipmentParameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    int updateByPrimaryKey(DEquipmentParameter record);
}