package org.clesun.entity;

import java.util.ArrayList;
import java.util.List;

public class DEquipmentParameterExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    protected int offset = -1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    protected int limit = -1;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    public DEquipmentParameterExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    public void setOffset(int offset) {
        this.offset=offset;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    public int getOffset() {
        return offset;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    public void setLimit(int limit) {
        this.limit=limit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    public int getLimit() {
        return limit;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        public void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        public void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andParamentIdIsNull() {
            addCriterion("parament_id is null");
            return (Criteria) this;
        }

        public Criteria andParamentIdIsNotNull() {
            addCriterion("parament_id is not null");
            return (Criteria) this;
        }

        public Criteria andParamentIdEqualTo(Long value) {
            addCriterion("parament_id =", value, "paramentId");
            return (Criteria) this;
        }

        public Criteria andParamentIdNotEqualTo(Long value) {
            addCriterion("parament_id <>", value, "paramentId");
            return (Criteria) this;
        }

        public Criteria andParamentIdGreaterThan(Long value) {
            addCriterion("parament_id >", value, "paramentId");
            return (Criteria) this;
        }

        public Criteria andParamentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parament_id >=", value, "paramentId");
            return (Criteria) this;
        }

        public Criteria andParamentIdLessThan(Long value) {
            addCriterion("parament_id <", value, "paramentId");
            return (Criteria) this;
        }

        public Criteria andParamentIdLessThanOrEqualTo(Long value) {
            addCriterion("parament_id <=", value, "paramentId");
            return (Criteria) this;
        }

        public Criteria andParamentIdIn(List<Long> values) {
            addCriterion("parament_id in", values, "paramentId");
            return (Criteria) this;
        }

        public Criteria andParamentIdNotIn(List<Long> values) {
            addCriterion("parament_id not in", values, "paramentId");
            return (Criteria) this;
        }

        public Criteria andParamentIdBetween(Long value1, Long value2) {
            addCriterion("parament_id between", value1, value2, "paramentId");
            return (Criteria) this;
        }

        public Criteria andParamentIdNotBetween(Long value1, Long value2) {
            addCriterion("parament_id not between", value1, value2, "paramentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrIsNull() {
            addCriterion("equipment_addr is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrIsNotNull() {
            addCriterion("equipment_addr is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrEqualTo(String value) {
            addCriterion("equipment_addr =", value, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrNotEqualTo(String value) {
            addCriterion("equipment_addr <>", value, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrGreaterThan(String value) {
            addCriterion("equipment_addr >", value, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_addr >=", value, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrLessThan(String value) {
            addCriterion("equipment_addr <", value, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrLessThanOrEqualTo(String value) {
            addCriterion("equipment_addr <=", value, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrLike(String value) {
            addCriterion("equipment_addr like", value, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrNotLike(String value) {
            addCriterion("equipment_addr not like", value, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrIn(List<String> values) {
            addCriterion("equipment_addr in", values, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrNotIn(List<String> values) {
            addCriterion("equipment_addr not in", values, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrBetween(String value1, String value2) {
            addCriterion("equipment_addr between", value1, value2, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrNotBetween(String value1, String value2) {
            addCriterion("equipment_addr not between", value1, value2, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnitnameIsNull() {
            addCriterion("equipment_unitname is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnitnameIsNotNull() {
            addCriterion("equipment_unitname is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnitnameEqualTo(String value) {
            addCriterion("equipment_unitname =", value, "equipmentUnitname");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnitnameNotEqualTo(String value) {
            addCriterion("equipment_unitname <>", value, "equipmentUnitname");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnitnameGreaterThan(String value) {
            addCriterion("equipment_unitname >", value, "equipmentUnitname");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnitnameGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_unitname >=", value, "equipmentUnitname");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnitnameLessThan(String value) {
            addCriterion("equipment_unitname <", value, "equipmentUnitname");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnitnameLessThanOrEqualTo(String value) {
            addCriterion("equipment_unitname <=", value, "equipmentUnitname");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnitnameLike(String value) {
            addCriterion("equipment_unitname like", value, "equipmentUnitname");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnitnameNotLike(String value) {
            addCriterion("equipment_unitname not like", value, "equipmentUnitname");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnitnameIn(List<String> values) {
            addCriterion("equipment_unitname in", values, "equipmentUnitname");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnitnameNotIn(List<String> values) {
            addCriterion("equipment_unitname not in", values, "equipmentUnitname");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnitnameBetween(String value1, String value2) {
            addCriterion("equipment_unitname between", value1, value2, "equipmentUnitname");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnitnameNotBetween(String value1, String value2) {
            addCriterion("equipment_unitname not between", value1, value2, "equipmentUnitname");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddressIsNull() {
            addCriterion("equipment_address is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddressIsNotNull() {
            addCriterion("equipment_address is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddressEqualTo(String value) {
            addCriterion("equipment_address =", value, "equipmentAddress");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddressNotEqualTo(String value) {
            addCriterion("equipment_address <>", value, "equipmentAddress");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddressGreaterThan(String value) {
            addCriterion("equipment_address >", value, "equipmentAddress");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddressGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_address >=", value, "equipmentAddress");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddressLessThan(String value) {
            addCriterion("equipment_address <", value, "equipmentAddress");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddressLessThanOrEqualTo(String value) {
            addCriterion("equipment_address <=", value, "equipmentAddress");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddressLike(String value) {
            addCriterion("equipment_address like", value, "equipmentAddress");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddressNotLike(String value) {
            addCriterion("equipment_address not like", value, "equipmentAddress");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddressIn(List<String> values) {
            addCriterion("equipment_address in", values, "equipmentAddress");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddressNotIn(List<String> values) {
            addCriterion("equipment_address not in", values, "equipmentAddress");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddressBetween(String value1, String value2) {
            addCriterion("equipment_address between", value1, value2, "equipmentAddress");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddressNotBetween(String value1, String value2) {
            addCriterion("equipment_address not between", value1, value2, "equipmentAddress");
            return (Criteria) this;
        }

        public Criteria andEquipmentOrgnameIsNull() {
            addCriterion("equipment_orgname is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentOrgnameIsNotNull() {
            addCriterion("equipment_orgname is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentOrgnameEqualTo(String value) {
            addCriterion("equipment_orgname =", value, "equipmentOrgname");
            return (Criteria) this;
        }

        public Criteria andEquipmentOrgnameNotEqualTo(String value) {
            addCriterion("equipment_orgname <>", value, "equipmentOrgname");
            return (Criteria) this;
        }

        public Criteria andEquipmentOrgnameGreaterThan(String value) {
            addCriterion("equipment_orgname >", value, "equipmentOrgname");
            return (Criteria) this;
        }

        public Criteria andEquipmentOrgnameGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_orgname >=", value, "equipmentOrgname");
            return (Criteria) this;
        }

        public Criteria andEquipmentOrgnameLessThan(String value) {
            addCriterion("equipment_orgname <", value, "equipmentOrgname");
            return (Criteria) this;
        }

        public Criteria andEquipmentOrgnameLessThanOrEqualTo(String value) {
            addCriterion("equipment_orgname <=", value, "equipmentOrgname");
            return (Criteria) this;
        }

        public Criteria andEquipmentOrgnameLike(String value) {
            addCriterion("equipment_orgname like", value, "equipmentOrgname");
            return (Criteria) this;
        }

        public Criteria andEquipmentOrgnameNotLike(String value) {
            addCriterion("equipment_orgname not like", value, "equipmentOrgname");
            return (Criteria) this;
        }

        public Criteria andEquipmentOrgnameIn(List<String> values) {
            addCriterion("equipment_orgname in", values, "equipmentOrgname");
            return (Criteria) this;
        }

        public Criteria andEquipmentOrgnameNotIn(List<String> values) {
            addCriterion("equipment_orgname not in", values, "equipmentOrgname");
            return (Criteria) this;
        }

        public Criteria andEquipmentOrgnameBetween(String value1, String value2) {
            addCriterion("equipment_orgname between", value1, value2, "equipmentOrgname");
            return (Criteria) this;
        }

        public Criteria andEquipmentOrgnameNotBetween(String value1, String value2) {
            addCriterion("equipment_orgname not between", value1, value2, "equipmentOrgname");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnittypeIsNull() {
            addCriterion("equipment_unittype is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnittypeIsNotNull() {
            addCriterion("equipment_unittype is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnittypeEqualTo(String value) {
            addCriterion("equipment_unittype =", value, "equipmentUnittype");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnittypeNotEqualTo(String value) {
            addCriterion("equipment_unittype <>", value, "equipmentUnittype");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnittypeGreaterThan(String value) {
            addCriterion("equipment_unittype >", value, "equipmentUnittype");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnittypeGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_unittype >=", value, "equipmentUnittype");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnittypeLessThan(String value) {
            addCriterion("equipment_unittype <", value, "equipmentUnittype");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnittypeLessThanOrEqualTo(String value) {
            addCriterion("equipment_unittype <=", value, "equipmentUnittype");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnittypeLike(String value) {
            addCriterion("equipment_unittype like", value, "equipmentUnittype");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnittypeNotLike(String value) {
            addCriterion("equipment_unittype not like", value, "equipmentUnittype");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnittypeIn(List<String> values) {
            addCriterion("equipment_unittype in", values, "equipmentUnittype");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnittypeNotIn(List<String> values) {
            addCriterion("equipment_unittype not in", values, "equipmentUnittype");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnittypeBetween(String value1, String value2) {
            addCriterion("equipment_unittype between", value1, value2, "equipmentUnittype");
            return (Criteria) this;
        }

        public Criteria andEquipmentUnittypeNotBetween(String value1, String value2) {
            addCriterion("equipment_unittype not between", value1, value2, "equipmentUnittype");
            return (Criteria) this;
        }

        public Criteria andEquipmentLngIsNull() {
            addCriterion("equipment_lng is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentLngIsNotNull() {
            addCriterion("equipment_lng is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentLngEqualTo(Double value) {
            addCriterion("equipment_lng =", value, "equipmentLng");
            return (Criteria) this;
        }

        public Criteria andEquipmentLngNotEqualTo(Double value) {
            addCriterion("equipment_lng <>", value, "equipmentLng");
            return (Criteria) this;
        }

        public Criteria andEquipmentLngGreaterThan(Double value) {
            addCriterion("equipment_lng >", value, "equipmentLng");
            return (Criteria) this;
        }

        public Criteria andEquipmentLngGreaterThanOrEqualTo(Double value) {
            addCriterion("equipment_lng >=", value, "equipmentLng");
            return (Criteria) this;
        }

        public Criteria andEquipmentLngLessThan(Double value) {
            addCriterion("equipment_lng <", value, "equipmentLng");
            return (Criteria) this;
        }

        public Criteria andEquipmentLngLessThanOrEqualTo(Double value) {
            addCriterion("equipment_lng <=", value, "equipmentLng");
            return (Criteria) this;
        }

        public Criteria andEquipmentLngIn(List<Double> values) {
            addCriterion("equipment_lng in", values, "equipmentLng");
            return (Criteria) this;
        }

        public Criteria andEquipmentLngNotIn(List<Double> values) {
            addCriterion("equipment_lng not in", values, "equipmentLng");
            return (Criteria) this;
        }

        public Criteria andEquipmentLngBetween(Double value1, Double value2) {
            addCriterion("equipment_lng between", value1, value2, "equipmentLng");
            return (Criteria) this;
        }

        public Criteria andEquipmentLngNotBetween(Double value1, Double value2) {
            addCriterion("equipment_lng not between", value1, value2, "equipmentLng");
            return (Criteria) this;
        }

        public Criteria andEquipmentLatIsNull() {
            addCriterion("equipment_lat is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentLatIsNotNull() {
            addCriterion("equipment_lat is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentLatEqualTo(Double value) {
            addCriterion("equipment_lat =", value, "equipmentLat");
            return (Criteria) this;
        }

        public Criteria andEquipmentLatNotEqualTo(Double value) {
            addCriterion("equipment_lat <>", value, "equipmentLat");
            return (Criteria) this;
        }

        public Criteria andEquipmentLatGreaterThan(Double value) {
            addCriterion("equipment_lat >", value, "equipmentLat");
            return (Criteria) this;
        }

        public Criteria andEquipmentLatGreaterThanOrEqualTo(Double value) {
            addCriterion("equipment_lat >=", value, "equipmentLat");
            return (Criteria) this;
        }

        public Criteria andEquipmentLatLessThan(Double value) {
            addCriterion("equipment_lat <", value, "equipmentLat");
            return (Criteria) this;
        }

        public Criteria andEquipmentLatLessThanOrEqualTo(Double value) {
            addCriterion("equipment_lat <=", value, "equipmentLat");
            return (Criteria) this;
        }

        public Criteria andEquipmentLatIn(List<Double> values) {
            addCriterion("equipment_lat in", values, "equipmentLat");
            return (Criteria) this;
        }

        public Criteria andEquipmentLatNotIn(List<Double> values) {
            addCriterion("equipment_lat not in", values, "equipmentLat");
            return (Criteria) this;
        }

        public Criteria andEquipmentLatBetween(Double value1, Double value2) {
            addCriterion("equipment_lat between", value1, value2, "equipmentLat");
            return (Criteria) this;
        }

        public Criteria andEquipmentLatNotBetween(Double value1, Double value2) {
            addCriterion("equipment_lat not between", value1, value2, "equipmentLat");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andPostCodeIsNull() {
            addCriterion("post_code is null");
            return (Criteria) this;
        }

        public Criteria andPostCodeIsNotNull() {
            addCriterion("post_code is not null");
            return (Criteria) this;
        }

        public Criteria andPostCodeEqualTo(String value) {
            addCriterion("post_code =", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotEqualTo(String value) {
            addCriterion("post_code <>", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeGreaterThan(String value) {
            addCriterion("post_code >", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeGreaterThanOrEqualTo(String value) {
            addCriterion("post_code >=", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLessThan(String value) {
            addCriterion("post_code <", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLessThanOrEqualTo(String value) {
            addCriterion("post_code <=", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLike(String value) {
            addCriterion("post_code like", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotLike(String value) {
            addCriterion("post_code not like", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeIn(List<String> values) {
            addCriterion("post_code in", values, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotIn(List<String> values) {
            addCriterion("post_code not in", values, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeBetween(String value1, String value2) {
            addCriterion("post_code between", value1, value2, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotBetween(String value1, String value2) {
            addCriterion("post_code not between", value1, value2, "postCode");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNull() {
            addCriterion("city_name is null");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNotNull() {
            addCriterion("city_name is not null");
            return (Criteria) this;
        }

        public Criteria andCityNameEqualTo(String value) {
            addCriterion("city_name =", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotEqualTo(String value) {
            addCriterion("city_name <>", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThan(String value) {
            addCriterion("city_name >", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("city_name >=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThan(String value) {
            addCriterion("city_name <", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThanOrEqualTo(String value) {
            addCriterion("city_name <=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLike(String value) {
            addCriterion("city_name like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotLike(String value) {
            addCriterion("city_name not like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameIn(List<String> values) {
            addCriterion("city_name in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotIn(List<String> values) {
            addCriterion("city_name not in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameBetween(String value1, String value2) {
            addCriterion("city_name between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotBetween(String value1, String value2) {
            addCriterion("city_name not between", value1, value2, "cityName");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated do_not_delete_during_merge Thu Jun 28 11:03:25 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table d_equipment_parameter
     *
     * @mbggenerated Thu Jun 28 11:03:25 CST 2018
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}