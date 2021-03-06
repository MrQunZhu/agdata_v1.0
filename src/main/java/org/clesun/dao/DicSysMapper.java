package org.clesun.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.clesun.entity.DicSys;
import org.clesun.entity.DicSysExample;

public interface DicSysMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    int countByExample(DicSysExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    int deleteByExample(DicSysExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    int deleteByPrimaryKey(Long dicId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    int insert(DicSys record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    int insertSelective(DicSys record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    List<DicSys> selectByExample(DicSysExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    DicSys selectByPrimaryKey(Long dicId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    int updateByExampleSelective(@Param("record") DicSys record, @Param("example") DicSysExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    int updateByExample(@Param("record") DicSys record, @Param("example") DicSysExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    int updateByPrimaryKeySelective(DicSys record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    int updateByPrimaryKey(DicSys record);
}