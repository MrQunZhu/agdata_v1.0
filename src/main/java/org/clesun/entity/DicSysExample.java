package org.clesun.entity;

import java.util.ArrayList;
import java.util.List;

public class DicSysExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    protected int offset = -1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    protected int limit = -1;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    public DicSysExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
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
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    public void setOffset(int offset) {
        this.offset=offset;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    public int getOffset() {
        return offset;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    public void setLimit(int limit) {
        this.limit=limit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
     */
    public int getLimit() {
        return limit;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
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

        public Criteria andDicIdIsNull() {
            addCriterion("dic_id is null");
            return (Criteria) this;
        }

        public Criteria andDicIdIsNotNull() {
            addCriterion("dic_id is not null");
            return (Criteria) this;
        }

        public Criteria andDicIdEqualTo(Long value) {
            addCriterion("dic_id =", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdNotEqualTo(Long value) {
            addCriterion("dic_id <>", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdGreaterThan(Long value) {
            addCriterion("dic_id >", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dic_id >=", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdLessThan(Long value) {
            addCriterion("dic_id <", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdLessThanOrEqualTo(Long value) {
            addCriterion("dic_id <=", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdIn(List<Long> values) {
            addCriterion("dic_id in", values, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdNotIn(List<Long> values) {
            addCriterion("dic_id not in", values, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdBetween(Long value1, Long value2) {
            addCriterion("dic_id between", value1, value2, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdNotBetween(Long value1, Long value2) {
            addCriterion("dic_id not between", value1, value2, "dicId");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andDicKeyIsNull() {
            addCriterion("dic_key is null");
            return (Criteria) this;
        }

        public Criteria andDicKeyIsNotNull() {
            addCriterion("dic_key is not null");
            return (Criteria) this;
        }

        public Criteria andDicKeyEqualTo(String value) {
            addCriterion("dic_key =", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyNotEqualTo(String value) {
            addCriterion("dic_key <>", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyGreaterThan(String value) {
            addCriterion("dic_key >", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("dic_key >=", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyLessThan(String value) {
            addCriterion("dic_key <", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyLessThanOrEqualTo(String value) {
            addCriterion("dic_key <=", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyLike(String value) {
            addCriterion("dic_key like", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyNotLike(String value) {
            addCriterion("dic_key not like", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyIn(List<String> values) {
            addCriterion("dic_key in", values, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyNotIn(List<String> values) {
            addCriterion("dic_key not in", values, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyBetween(String value1, String value2) {
            addCriterion("dic_key between", value1, value2, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyNotBetween(String value1, String value2) {
            addCriterion("dic_key not between", value1, value2, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicValueIsNull() {
            addCriterion("dic_value is null");
            return (Criteria) this;
        }

        public Criteria andDicValueIsNotNull() {
            addCriterion("dic_value is not null");
            return (Criteria) this;
        }

        public Criteria andDicValueEqualTo(String value) {
            addCriterion("dic_value =", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueNotEqualTo(String value) {
            addCriterion("dic_value <>", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueGreaterThan(String value) {
            addCriterion("dic_value >", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueGreaterThanOrEqualTo(String value) {
            addCriterion("dic_value >=", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueLessThan(String value) {
            addCriterion("dic_value <", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueLessThanOrEqualTo(String value) {
            addCriterion("dic_value <=", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueLike(String value) {
            addCriterion("dic_value like", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueNotLike(String value) {
            addCriterion("dic_value not like", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueIn(List<String> values) {
            addCriterion("dic_value in", values, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueNotIn(List<String> values) {
            addCriterion("dic_value not in", values, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueBetween(String value1, String value2) {
            addCriterion("dic_value between", value1, value2, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueNotBetween(String value1, String value2) {
            addCriterion("dic_value not between", value1, value2, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicTypeIsNull() {
            addCriterion("dic_type is null");
            return (Criteria) this;
        }

        public Criteria andDicTypeIsNotNull() {
            addCriterion("dic_type is not null");
            return (Criteria) this;
        }

        public Criteria andDicTypeEqualTo(Integer value) {
            addCriterion("dic_type =", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeNotEqualTo(Integer value) {
            addCriterion("dic_type <>", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeGreaterThan(Integer value) {
            addCriterion("dic_type >", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("dic_type >=", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeLessThan(Integer value) {
            addCriterion("dic_type <", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeLessThanOrEqualTo(Integer value) {
            addCriterion("dic_type <=", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeIn(List<Integer> values) {
            addCriterion("dic_type in", values, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeNotIn(List<Integer> values) {
            addCriterion("dic_type not in", values, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeBetween(Integer value1, Integer value2) {
            addCriterion("dic_type between", value1, value2, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("dic_type not between", value1, value2, "dicType");
            return (Criteria) this;
        }

        public Criteria andRefTableIsNull() {
            addCriterion("ref_table is null");
            return (Criteria) this;
        }

        public Criteria andRefTableIsNotNull() {
            addCriterion("ref_table is not null");
            return (Criteria) this;
        }

        public Criteria andRefTableEqualTo(String value) {
            addCriterion("ref_table =", value, "refTable");
            return (Criteria) this;
        }

        public Criteria andRefTableNotEqualTo(String value) {
            addCriterion("ref_table <>", value, "refTable");
            return (Criteria) this;
        }

        public Criteria andRefTableGreaterThan(String value) {
            addCriterion("ref_table >", value, "refTable");
            return (Criteria) this;
        }

        public Criteria andRefTableGreaterThanOrEqualTo(String value) {
            addCriterion("ref_table >=", value, "refTable");
            return (Criteria) this;
        }

        public Criteria andRefTableLessThan(String value) {
            addCriterion("ref_table <", value, "refTable");
            return (Criteria) this;
        }

        public Criteria andRefTableLessThanOrEqualTo(String value) {
            addCriterion("ref_table <=", value, "refTable");
            return (Criteria) this;
        }

        public Criteria andRefTableLike(String value) {
            addCriterion("ref_table like", value, "refTable");
            return (Criteria) this;
        }

        public Criteria andRefTableNotLike(String value) {
            addCriterion("ref_table not like", value, "refTable");
            return (Criteria) this;
        }

        public Criteria andRefTableIn(List<String> values) {
            addCriterion("ref_table in", values, "refTable");
            return (Criteria) this;
        }

        public Criteria andRefTableNotIn(List<String> values) {
            addCriterion("ref_table not in", values, "refTable");
            return (Criteria) this;
        }

        public Criteria andRefTableBetween(String value1, String value2) {
            addCriterion("ref_table between", value1, value2, "refTable");
            return (Criteria) this;
        }

        public Criteria andRefTableNotBetween(String value1, String value2) {
            addCriterion("ref_table not between", value1, value2, "refTable");
            return (Criteria) this;
        }

        public Criteria andRefIdIsNull() {
            addCriterion("ref_id is null");
            return (Criteria) this;
        }

        public Criteria andRefIdIsNotNull() {
            addCriterion("ref_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefIdEqualTo(Long value) {
            addCriterion("ref_id =", value, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdNotEqualTo(Long value) {
            addCriterion("ref_id <>", value, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdGreaterThan(Long value) {
            addCriterion("ref_id >", value, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ref_id >=", value, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdLessThan(Long value) {
            addCriterion("ref_id <", value, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdLessThanOrEqualTo(Long value) {
            addCriterion("ref_id <=", value, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdIn(List<Long> values) {
            addCriterion("ref_id in", values, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdNotIn(List<Long> values) {
            addCriterion("ref_id not in", values, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdBetween(Long value1, Long value2) {
            addCriterion("ref_id between", value1, value2, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdNotBetween(Long value1, Long value2) {
            addCriterion("ref_id not between", value1, value2, "refId");
            return (Criteria) this;
        }

        public Criteria andDicRemarkIsNull() {
            addCriterion("dic_remark is null");
            return (Criteria) this;
        }

        public Criteria andDicRemarkIsNotNull() {
            addCriterion("dic_remark is not null");
            return (Criteria) this;
        }

        public Criteria andDicRemarkEqualTo(String value) {
            addCriterion("dic_remark =", value, "dicRemark");
            return (Criteria) this;
        }

        public Criteria andDicRemarkNotEqualTo(String value) {
            addCriterion("dic_remark <>", value, "dicRemark");
            return (Criteria) this;
        }

        public Criteria andDicRemarkGreaterThan(String value) {
            addCriterion("dic_remark >", value, "dicRemark");
            return (Criteria) this;
        }

        public Criteria andDicRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("dic_remark >=", value, "dicRemark");
            return (Criteria) this;
        }

        public Criteria andDicRemarkLessThan(String value) {
            addCriterion("dic_remark <", value, "dicRemark");
            return (Criteria) this;
        }

        public Criteria andDicRemarkLessThanOrEqualTo(String value) {
            addCriterion("dic_remark <=", value, "dicRemark");
            return (Criteria) this;
        }

        public Criteria andDicRemarkLike(String value) {
            addCriterion("dic_remark like", value, "dicRemark");
            return (Criteria) this;
        }

        public Criteria andDicRemarkNotLike(String value) {
            addCriterion("dic_remark not like", value, "dicRemark");
            return (Criteria) this;
        }

        public Criteria andDicRemarkIn(List<String> values) {
            addCriterion("dic_remark in", values, "dicRemark");
            return (Criteria) this;
        }

        public Criteria andDicRemarkNotIn(List<String> values) {
            addCriterion("dic_remark not in", values, "dicRemark");
            return (Criteria) this;
        }

        public Criteria andDicRemarkBetween(String value1, String value2) {
            addCriterion("dic_remark between", value1, value2, "dicRemark");
            return (Criteria) this;
        }

        public Criteria andDicRemarkNotBetween(String value1, String value2) {
            addCriterion("dic_remark not between", value1, value2, "dicRemark");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dic_sys
     *
     * @mbggenerated do_not_delete_during_merge Fri Nov 17 16:38:55 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dic_sys
     *
     * @mbggenerated Fri Nov 17 16:38:55 CST 2017
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