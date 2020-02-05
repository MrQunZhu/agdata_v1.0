package org.clesun.entity;

import java.util.ArrayList;
import java.util.List;

public class DyFarmEquipmentExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
     */
    protected int offset = -1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
     */
    protected int limit = -1;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
     */
    public DyFarmEquipmentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
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
     * This method corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
     */
    public void setOffset(int offset) {
        this.offset=offset;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
     */
    public int getOffset() {
        return offset;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
     */
    public void setLimit(int limit) {
        this.limit=limit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
     */
    public int getLimit() {
        return limit;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
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

        public Criteria andFarmEquipmentIdIsNull() {
            addCriterion("farm_equipment_id is null");
            return (Criteria) this;
        }

        public Criteria andFarmEquipmentIdIsNotNull() {
            addCriterion("farm_equipment_id is not null");
            return (Criteria) this;
        }

        public Criteria andFarmEquipmentIdEqualTo(Long value) {
            addCriterion("farm_equipment_id =", value, "farmEquipmentId");
            return (Criteria) this;
        }

        public Criteria andFarmEquipmentIdNotEqualTo(Long value) {
            addCriterion("farm_equipment_id <>", value, "farmEquipmentId");
            return (Criteria) this;
        }

        public Criteria andFarmEquipmentIdGreaterThan(Long value) {
            addCriterion("farm_equipment_id >", value, "farmEquipmentId");
            return (Criteria) this;
        }

        public Criteria andFarmEquipmentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("farm_equipment_id >=", value, "farmEquipmentId");
            return (Criteria) this;
        }

        public Criteria andFarmEquipmentIdLessThan(Long value) {
            addCriterion("farm_equipment_id <", value, "farmEquipmentId");
            return (Criteria) this;
        }

        public Criteria andFarmEquipmentIdLessThanOrEqualTo(Long value) {
            addCriterion("farm_equipment_id <=", value, "farmEquipmentId");
            return (Criteria) this;
        }

        public Criteria andFarmEquipmentIdIn(List<Long> values) {
            addCriterion("farm_equipment_id in", values, "farmEquipmentId");
            return (Criteria) this;
        }

        public Criteria andFarmEquipmentIdNotIn(List<Long> values) {
            addCriterion("farm_equipment_id not in", values, "farmEquipmentId");
            return (Criteria) this;
        }

        public Criteria andFarmEquipmentIdBetween(Long value1, Long value2) {
            addCriterion("farm_equipment_id between", value1, value2, "farmEquipmentId");
            return (Criteria) this;
        }

        public Criteria andFarmEquipmentIdNotBetween(Long value1, Long value2) {
            addCriterion("farm_equipment_id not between", value1, value2, "farmEquipmentId");
            return (Criteria) this;
        }

        public Criteria andFarmIdIsNull() {
            addCriterion("farm_id is null");
            return (Criteria) this;
        }

        public Criteria andFarmIdIsNotNull() {
            addCriterion("farm_id is not null");
            return (Criteria) this;
        }

        public Criteria andFarmIdEqualTo(Long value) {
            addCriterion("farm_id =", value, "farmId");
            return (Criteria) this;
        }

        public Criteria andFarmIdNotEqualTo(Long value) {
            addCriterion("farm_id <>", value, "farmId");
            return (Criteria) this;
        }

        public Criteria andFarmIdGreaterThan(Long value) {
            addCriterion("farm_id >", value, "farmId");
            return (Criteria) this;
        }

        public Criteria andFarmIdGreaterThanOrEqualTo(Long value) {
            addCriterion("farm_id >=", value, "farmId");
            return (Criteria) this;
        }

        public Criteria andFarmIdLessThan(Long value) {
            addCriterion("farm_id <", value, "farmId");
            return (Criteria) this;
        }

        public Criteria andFarmIdLessThanOrEqualTo(Long value) {
            addCriterion("farm_id <=", value, "farmId");
            return (Criteria) this;
        }

        public Criteria andFarmIdIn(List<Long> values) {
            addCriterion("farm_id in", values, "farmId");
            return (Criteria) this;
        }

        public Criteria andFarmIdNotIn(List<Long> values) {
            addCriterion("farm_id not in", values, "farmId");
            return (Criteria) this;
        }

        public Criteria andFarmIdBetween(Long value1, Long value2) {
            addCriterion("farm_id between", value1, value2, "farmId");
            return (Criteria) this;
        }

        public Criteria andFarmIdNotBetween(Long value1, Long value2) {
            addCriterion("farm_id not between", value1, value2, "farmId");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("addr is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("addr is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("addr =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("addr <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("addr >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("addr >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("addr <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("addr <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("addr like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("addr not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("addr in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("addr not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("addr between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("addr not between", value1, value2, "addr");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated do_not_delete_during_merge Thu Aug 17 15:52:03 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dy_farm_equipment
     *
     * @mbggenerated Thu Aug 17 15:52:03 CST 2017
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