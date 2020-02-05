package org.clesun.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.clesun.entity.DUser;
import org.clesun.entity.DUserExample;

public interface DUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_user
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    int countByExample(DUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_user
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    int deleteByExample(DUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_user
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_user
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    int insert(DUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_user
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    int insertSelective(DUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_user
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    List<DUser> selectByExample(DUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_user
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    DUser selectByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_user
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    int updateByExampleSelective(@Param("record") DUser record, @Param("example") DUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_user
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    int updateByExample(@Param("record") DUser record, @Param("example") DUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_user
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    int updateByPrimaryKeySelective(DUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_user
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    int updateByPrimaryKey(DUser record);
}