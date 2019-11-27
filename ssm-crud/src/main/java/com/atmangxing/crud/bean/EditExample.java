package com.atmangxing.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class EditExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EditExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andWordIdEqualTo(String value) {
            addCriterion("word_id =", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdNotEqualTo(String value) {
            addCriterion("word_id <>", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdGreaterThan(String value) {
            addCriterion("word_id >", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdGreaterThanOrEqualTo(String value) {
            addCriterion("word_id >=", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdLessThan(String value) {
            addCriterion("word_id <", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdLessThanOrEqualTo(String value) {
            addCriterion("word_id <=", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdLike(String value) {
            addCriterion("word_id like", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdNotLike(String value) {
            addCriterion("word_id not like", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdIn(List<String> values) {
            addCriterion("word_id in", values, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdNotIn(List<String> values) {
            addCriterion("word_id not in", values, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdBetween(String value1, String value2) {
            addCriterion("word_id between", value1, value2, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdNotBetween(String value1, String value2) {
            addCriterion("word_id not between", value1, value2, "wordId");
            return (Criteria) this;
        }

        public Criteria andStusIdIsNull() {
            addCriterion("stus_id is null");
            return (Criteria) this;
        }

        public Criteria andStusIdIsNotNull() {
            addCriterion("stus_id is not null");
            return (Criteria) this;
        }

        public Criteria andStusIdEqualTo(String value) {
            addCriterion("stus_id =", value, "stusId");
            return (Criteria) this;
        }

        public Criteria andStusIdNotEqualTo(String value) {
            addCriterion("stus_id <>", value, "stusId");
            return (Criteria) this;
        }

        public Criteria andStusIdGreaterThan(String value) {
            addCriterion("stus_id >", value, "stusId");
            return (Criteria) this;
        }

        public Criteria andStusIdGreaterThanOrEqualTo(String value) {
            addCriterion("stus_id >=", value, "stusId");
            return (Criteria) this;
        }

        public Criteria andStusIdLessThan(String value) {
            addCriterion("stus_id <", value, "stusId");
            return (Criteria) this;
        }

        public Criteria andStusIdLessThanOrEqualTo(String value) {
            addCriterion("stus_id <=", value, "stusId");
            return (Criteria) this;
        }

        public Criteria andStusIdLike(String value) {
            addCriterion("stus_id like", value, "stusId");
            return (Criteria) this;
        }

        public Criteria andStusIdNotLike(String value) {
            addCriterion("stus_id not like", value, "stusId");
            return (Criteria) this;
        }

        public Criteria andStusIdIn(List<String> values) {
            addCriterion("stus_id in", values, "stusId");
            return (Criteria) this;
        }

        public Criteria andStusIdNotIn(List<String> values) {
            addCriterion("stus_id not in", values, "stusId");
            return (Criteria) this;
        }

        public Criteria andStusIdBetween(String value1, String value2) {
            addCriterion("stus_id between", value1, value2, "stusId");
            return (Criteria) this;
        }

        public Criteria andStusIdNotBetween(String value1, String value2) {
            addCriterion("stus_id not between", value1, value2, "stusId");
            return (Criteria) this;
        }

        public Criteria andEditIsNull() {
            addCriterion("edit is null");
            return (Criteria) this;
        }

        public Criteria andEditIsNotNull() {
            addCriterion("edit is not null");
            return (Criteria) this;
        }

        public Criteria andEditEqualTo(String value) {
            addCriterion("edit =", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditNotEqualTo(String value) {
            addCriterion("edit <>", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditGreaterThan(String value) {
            addCriterion("edit >", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditGreaterThanOrEqualTo(String value) {
            addCriterion("edit >=", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditLessThan(String value) {
            addCriterion("edit <", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditLessThanOrEqualTo(String value) {
            addCriterion("edit <=", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditLike(String value) {
            addCriterion("edit like", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditNotLike(String value) {
            addCriterion("edit not like", value, "edit");
            return (Criteria) this;
        }

        public Criteria andEditIn(List<String> values) {
            addCriterion("edit in", values, "edit");
            return (Criteria) this;
        }

        public Criteria andEditNotIn(List<String> values) {
            addCriterion("edit not in", values, "edit");
            return (Criteria) this;
        }

        public Criteria andEditBetween(String value1, String value2) {
            addCriterion("edit between", value1, value2, "edit");
            return (Criteria) this;
        }

        public Criteria andEditNotBetween(String value1, String value2) {
            addCriterion("edit not between", value1, value2, "edit");
            return (Criteria) this;
        }

        public Criteria andTestIsNull() {
            addCriterion("test is null");
            return (Criteria) this;
        }

        public Criteria andTestIsNotNull() {
            addCriterion("test is not null");
            return (Criteria) this;
        }

        public Criteria andTestEqualTo(String value) {
            addCriterion("test =", value, "test");
            return (Criteria) this;
        }

        public Criteria andTestNotEqualTo(String value) {
            addCriterion("test <>", value, "test");
            return (Criteria) this;
        }

        public Criteria andTestGreaterThan(String value) {
            addCriterion("test >", value, "test");
            return (Criteria) this;
        }

        public Criteria andTestGreaterThanOrEqualTo(String value) {
            addCriterion("test >=", value, "test");
            return (Criteria) this;
        }

        public Criteria andTestLessThan(String value) {
            addCriterion("test <", value, "test");
            return (Criteria) this;
        }

        public Criteria andTestLessThanOrEqualTo(String value) {
            addCriterion("test <=", value, "test");
            return (Criteria) this;
        }

        public Criteria andTestLike(String value) {
            addCriterion("test like", value, "test");
            return (Criteria) this;
        }

        public Criteria andTestNotLike(String value) {
            addCriterion("test not like", value, "test");
            return (Criteria) this;
        }

        public Criteria andTestIn(List<String> values) {
            addCriterion("test in", values, "test");
            return (Criteria) this;
        }

        public Criteria andTestNotIn(List<String> values) {
            addCriterion("test not in", values, "test");
            return (Criteria) this;
        }

        public Criteria andTestBetween(String value1, String value2) {
            addCriterion("test between", value1, value2, "test");
            return (Criteria) this;
        }

        public Criteria andTestNotBetween(String value1, String value2) {
            addCriterion("test not between", value1, value2, "test");
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