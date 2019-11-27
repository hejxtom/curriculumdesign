package com.atmangxing.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class AdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
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

        public Criteria andSysIdIsNull() {
            addCriterion("sys_id is null");
            return (Criteria) this;
        }

        public Criteria andSysIdIsNotNull() {
            addCriterion("sys_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysIdEqualTo(Integer value) {
            addCriterion("sys_id =", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotEqualTo(Integer value) {
            addCriterion("sys_id <>", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdGreaterThan(Integer value) {
            addCriterion("sys_id >", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_id >=", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdLessThan(Integer value) {
            addCriterion("sys_id <", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdLessThanOrEqualTo(Integer value) {
            addCriterion("sys_id <=", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdIn(List<Integer> values) {
            addCriterion("sys_id in", values, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotIn(List<Integer> values) {
            addCriterion("sys_id not in", values, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdBetween(Integer value1, Integer value2) {
            addCriterion("sys_id between", value1, value2, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_id not between", value1, value2, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysUserIsNull() {
            addCriterion("sys_user is null");
            return (Criteria) this;
        }

        public Criteria andSysUserIsNotNull() {
            addCriterion("sys_user is not null");
            return (Criteria) this;
        }

        public Criteria andSysUserEqualTo(String value) {
            addCriterion("sys_user =", value, "sysUser");
            return (Criteria) this;
        }

        public Criteria andSysUserNotEqualTo(String value) {
            addCriterion("sys_user <>", value, "sysUser");
            return (Criteria) this;
        }

        public Criteria andSysUserGreaterThan(String value) {
            addCriterion("sys_user >", value, "sysUser");
            return (Criteria) this;
        }

        public Criteria andSysUserGreaterThanOrEqualTo(String value) {
            addCriterion("sys_user >=", value, "sysUser");
            return (Criteria) this;
        }

        public Criteria andSysUserLessThan(String value) {
            addCriterion("sys_user <", value, "sysUser");
            return (Criteria) this;
        }

        public Criteria andSysUserLessThanOrEqualTo(String value) {
            addCriterion("sys_user <=", value, "sysUser");
            return (Criteria) this;
        }

        public Criteria andSysUserLike(String value) {
            addCriterion("sys_user like", value, "sysUser");
            return (Criteria) this;
        }

        public Criteria andSysUserNotLike(String value) {
            addCriterion("sys_user not like", value, "sysUser");
            return (Criteria) this;
        }

        public Criteria andSysUserIn(List<String> values) {
            addCriterion("sys_user in", values, "sysUser");
            return (Criteria) this;
        }

        public Criteria andSysUserNotIn(List<String> values) {
            addCriterion("sys_user not in", values, "sysUser");
            return (Criteria) this;
        }

        public Criteria andSysUserBetween(String value1, String value2) {
            addCriterion("sys_user between", value1, value2, "sysUser");
            return (Criteria) this;
        }

        public Criteria andSysUserNotBetween(String value1, String value2) {
            addCriterion("sys_user not between", value1, value2, "sysUser");
            return (Criteria) this;
        }

        public Criteria andSysPassIsNull() {
            addCriterion("sys_pass is null");
            return (Criteria) this;
        }

        public Criteria andSysPassIsNotNull() {
            addCriterion("sys_pass is not null");
            return (Criteria) this;
        }

        public Criteria andSysPassEqualTo(String value) {
            addCriterion("sys_pass =", value, "sysPass");
            return (Criteria) this;
        }

        public Criteria andSysPassNotEqualTo(String value) {
            addCriterion("sys_pass <>", value, "sysPass");
            return (Criteria) this;
        }

        public Criteria andSysPassGreaterThan(String value) {
            addCriterion("sys_pass >", value, "sysPass");
            return (Criteria) this;
        }

        public Criteria andSysPassGreaterThanOrEqualTo(String value) {
            addCriterion("sys_pass >=", value, "sysPass");
            return (Criteria) this;
        }

        public Criteria andSysPassLessThan(String value) {
            addCriterion("sys_pass <", value, "sysPass");
            return (Criteria) this;
        }

        public Criteria andSysPassLessThanOrEqualTo(String value) {
            addCriterion("sys_pass <=", value, "sysPass");
            return (Criteria) this;
        }

        public Criteria andSysPassLike(String value) {
            addCriterion("sys_pass like", value, "sysPass");
            return (Criteria) this;
        }

        public Criteria andSysPassNotLike(String value) {
            addCriterion("sys_pass not like", value, "sysPass");
            return (Criteria) this;
        }

        public Criteria andSysPassIn(List<String> values) {
            addCriterion("sys_pass in", values, "sysPass");
            return (Criteria) this;
        }

        public Criteria andSysPassNotIn(List<String> values) {
            addCriterion("sys_pass not in", values, "sysPass");
            return (Criteria) this;
        }

        public Criteria andSysPassBetween(String value1, String value2) {
            addCriterion("sys_pass between", value1, value2, "sysPass");
            return (Criteria) this;
        }

        public Criteria andSysPassNotBetween(String value1, String value2) {
            addCriterion("sys_pass not between", value1, value2, "sysPass");
            return (Criteria) this;
        }

        public Criteria andWordIdIsNull() {
            addCriterion("word_id is null");
            return (Criteria) this;
        }

        public Criteria andWordIdIsNotNull() {
            addCriterion("word_id is not null");
            return (Criteria) this;
        }

        public Criteria andWordIdEqualTo(Integer value) {
            addCriterion("word_id =", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdNotEqualTo(Integer value) {
            addCriterion("word_id <>", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdGreaterThan(Integer value) {
            addCriterion("word_id >", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("word_id >=", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdLessThan(Integer value) {
            addCriterion("word_id <", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdLessThanOrEqualTo(Integer value) {
            addCriterion("word_id <=", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdIn(List<Integer> values) {
            addCriterion("word_id in", values, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdNotIn(List<Integer> values) {
            addCriterion("word_id not in", values, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdBetween(Integer value1, Integer value2) {
            addCriterion("word_id between", value1, value2, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("word_id not between", value1, value2, "wordId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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