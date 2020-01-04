package com.briup.studentmanage.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResultsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResultsExample() {
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

        public Criteria andChineseIsNull() {
            addCriterion("chinese is null");
            return (Criteria) this;
        }

        public Criteria andChineseIsNotNull() {
            addCriterion("chinese is not null");
            return (Criteria) this;
        }

        public Criteria andChineseEqualTo(Double value) {
            addCriterion("chinese =", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseNotEqualTo(Double value) {
            addCriterion("chinese <>", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseGreaterThan(Double value) {
            addCriterion("chinese >", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseGreaterThanOrEqualTo(Double value) {
            addCriterion("chinese >=", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseLessThan(Double value) {
            addCriterion("chinese <", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseLessThanOrEqualTo(Double value) {
            addCriterion("chinese <=", value, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseIn(List<Double> values) {
            addCriterion("chinese in", values, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseNotIn(List<Double> values) {
            addCriterion("chinese not in", values, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseBetween(Double value1, Double value2) {
            addCriterion("chinese between", value1, value2, "chinese");
            return (Criteria) this;
        }

        public Criteria andChineseNotBetween(Double value1, Double value2) {
            addCriterion("chinese not between", value1, value2, "chinese");
            return (Criteria) this;
        }

        public Criteria andMathIsNull() {
            addCriterion("math is null");
            return (Criteria) this;
        }

        public Criteria andMathIsNotNull() {
            addCriterion("math is not null");
            return (Criteria) this;
        }

        public Criteria andMathEqualTo(Double value) {
            addCriterion("math =", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathNotEqualTo(Double value) {
            addCriterion("math <>", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathGreaterThan(Double value) {
            addCriterion("math >", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathGreaterThanOrEqualTo(Double value) {
            addCriterion("math >=", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathLessThan(Double value) {
            addCriterion("math <", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathLessThanOrEqualTo(Double value) {
            addCriterion("math <=", value, "math");
            return (Criteria) this;
        }

        public Criteria andMathIn(List<Double> values) {
            addCriterion("math in", values, "math");
            return (Criteria) this;
        }

        public Criteria andMathNotIn(List<Double> values) {
            addCriterion("math not in", values, "math");
            return (Criteria) this;
        }

        public Criteria andMathBetween(Double value1, Double value2) {
            addCriterion("math between", value1, value2, "math");
            return (Criteria) this;
        }

        public Criteria andMathNotBetween(Double value1, Double value2) {
            addCriterion("math not between", value1, value2, "math");
            return (Criteria) this;
        }

        public Criteria andEnglishIsNull() {
            addCriterion("english is null");
            return (Criteria) this;
        }

        public Criteria andEnglishIsNotNull() {
            addCriterion("english is not null");
            return (Criteria) this;
        }

        public Criteria andEnglishEqualTo(Double value) {
            addCriterion("english =", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishNotEqualTo(Double value) {
            addCriterion("english <>", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishGreaterThan(Double value) {
            addCriterion("english >", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishGreaterThanOrEqualTo(Double value) {
            addCriterion("english >=", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishLessThan(Double value) {
            addCriterion("english <", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishLessThanOrEqualTo(Double value) {
            addCriterion("english <=", value, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishIn(List<Double> values) {
            addCriterion("english in", values, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishNotIn(List<Double> values) {
            addCriterion("english not in", values, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishBetween(Double value1, Double value2) {
            addCriterion("english between", value1, value2, "english");
            return (Criteria) this;
        }

        public Criteria andEnglishNotBetween(Double value1, Double value2) {
            addCriterion("english not between", value1, value2, "english");
            return (Criteria) this;
        }

        public Criteria andPoliticalIsNull() {
            addCriterion("political is null");
            return (Criteria) this;
        }

        public Criteria andPoliticalIsNotNull() {
            addCriterion("political is not null");
            return (Criteria) this;
        }

        public Criteria andPoliticalEqualTo(Double value) {
            addCriterion("political =", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalNotEqualTo(Double value) {
            addCriterion("political <>", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalGreaterThan(Double value) {
            addCriterion("political >", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalGreaterThanOrEqualTo(Double value) {
            addCriterion("political >=", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalLessThan(Double value) {
            addCriterion("political <", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalLessThanOrEqualTo(Double value) {
            addCriterion("political <=", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalIn(List<Double> values) {
            addCriterion("political in", values, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalNotIn(List<Double> values) {
            addCriterion("political not in", values, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalBetween(Double value1, Double value2) {
            addCriterion("political between", value1, value2, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalNotBetween(Double value1, Double value2) {
            addCriterion("political not between", value1, value2, "political");
            return (Criteria) this;
        }

        public Criteria andHistoryIsNull() {
            addCriterion("history is null");
            return (Criteria) this;
        }

        public Criteria andHistoryIsNotNull() {
            addCriterion("history is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryEqualTo(Double value) {
            addCriterion("history =", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryNotEqualTo(Double value) {
            addCriterion("history <>", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryGreaterThan(Double value) {
            addCriterion("history >", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryGreaterThanOrEqualTo(Double value) {
            addCriterion("history >=", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryLessThan(Double value) {
            addCriterion("history <", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryLessThanOrEqualTo(Double value) {
            addCriterion("history <=", value, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryIn(List<Double> values) {
            addCriterion("history in", values, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryNotIn(List<Double> values) {
            addCriterion("history not in", values, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryBetween(Double value1, Double value2) {
            addCriterion("history between", value1, value2, "history");
            return (Criteria) this;
        }

        public Criteria andHistoryNotBetween(Double value1, Double value2) {
            addCriterion("history not between", value1, value2, "history");
            return (Criteria) this;
        }

        public Criteria andGeographicIsNull() {
            addCriterion("geographic is null");
            return (Criteria) this;
        }

        public Criteria andGeographicIsNotNull() {
            addCriterion("geographic is not null");
            return (Criteria) this;
        }

        public Criteria andGeographicEqualTo(Double value) {
            addCriterion("geographic =", value, "geographic");
            return (Criteria) this;
        }

        public Criteria andGeographicNotEqualTo(Double value) {
            addCriterion("geographic <>", value, "geographic");
            return (Criteria) this;
        }

        public Criteria andGeographicGreaterThan(Double value) {
            addCriterion("geographic >", value, "geographic");
            return (Criteria) this;
        }

        public Criteria andGeographicGreaterThanOrEqualTo(Double value) {
            addCriterion("geographic >=", value, "geographic");
            return (Criteria) this;
        }

        public Criteria andGeographicLessThan(Double value) {
            addCriterion("geographic <", value, "geographic");
            return (Criteria) this;
        }

        public Criteria andGeographicLessThanOrEqualTo(Double value) {
            addCriterion("geographic <=", value, "geographic");
            return (Criteria) this;
        }

        public Criteria andGeographicIn(List<Double> values) {
            addCriterion("geographic in", values, "geographic");
            return (Criteria) this;
        }

        public Criteria andGeographicNotIn(List<Double> values) {
            addCriterion("geographic not in", values, "geographic");
            return (Criteria) this;
        }

        public Criteria andGeographicBetween(Double value1, Double value2) {
            addCriterion("geographic between", value1, value2, "geographic");
            return (Criteria) this;
        }

        public Criteria andGeographicNotBetween(Double value1, Double value2) {
            addCriterion("geographic not between", value1, value2, "geographic");
            return (Criteria) this;
        }

        public Criteria andExamtimeIsNull() {
            addCriterion("examTime is null");
            return (Criteria) this;
        }

        public Criteria andExamtimeIsNotNull() {
            addCriterion("examTime is not null");
            return (Criteria) this;
        }

        public Criteria andExamtimeEqualTo(Date value) {
            addCriterion("examTime =", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeNotEqualTo(Date value) {
            addCriterion("examTime <>", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeGreaterThan(Date value) {
            addCriterion("examTime >", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("examTime >=", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeLessThan(Date value) {
            addCriterion("examTime <", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeLessThanOrEqualTo(Date value) {
            addCriterion("examTime <=", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeIn(List<Date> values) {
            addCriterion("examTime in", values, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeNotIn(List<Date> values) {
            addCriterion("examTime not in", values, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeBetween(Date value1, Date value2) {
            addCriterion("examTime between", value1, value2, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeNotBetween(Date value1, Date value2) {
            addCriterion("examTime not between", value1, value2, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamstatusIsNull() {
            addCriterion("examStatus is null");
            return (Criteria) this;
        }

        public Criteria andExamstatusIsNotNull() {
            addCriterion("examStatus is not null");
            return (Criteria) this;
        }

        public Criteria andExamstatusEqualTo(Integer value) {
            addCriterion("examStatus =", value, "examstatus");
            return (Criteria) this;
        }

        public Criteria andExamstatusNotEqualTo(Integer value) {
            addCriterion("examStatus <>", value, "examstatus");
            return (Criteria) this;
        }

        public Criteria andExamstatusGreaterThan(Integer value) {
            addCriterion("examStatus >", value, "examstatus");
            return (Criteria) this;
        }

        public Criteria andExamstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("examStatus >=", value, "examstatus");
            return (Criteria) this;
        }

        public Criteria andExamstatusLessThan(Integer value) {
            addCriterion("examStatus <", value, "examstatus");
            return (Criteria) this;
        }

        public Criteria andExamstatusLessThanOrEqualTo(Integer value) {
            addCriterion("examStatus <=", value, "examstatus");
            return (Criteria) this;
        }

        public Criteria andExamstatusIn(List<Integer> values) {
            addCriterion("examStatus in", values, "examstatus");
            return (Criteria) this;
        }

        public Criteria andExamstatusNotIn(List<Integer> values) {
            addCriterion("examStatus not in", values, "examstatus");
            return (Criteria) this;
        }

        public Criteria andExamstatusBetween(Integer value1, Integer value2) {
            addCriterion("examStatus between", value1, value2, "examstatus");
            return (Criteria) this;
        }

        public Criteria andExamstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("examStatus not between", value1, value2, "examstatus");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNull() {
            addCriterion("studentId is null");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNotNull() {
            addCriterion("studentId is not null");
            return (Criteria) this;
        }

        public Criteria andStudentidEqualTo(Integer value) {
            addCriterion("studentId =", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotEqualTo(Integer value) {
            addCriterion("studentId <>", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThan(Integer value) {
            addCriterion("studentId >", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("studentId >=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThan(Integer value) {
            addCriterion("studentId <", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThanOrEqualTo(Integer value) {
            addCriterion("studentId <=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidIn(List<Integer> values) {
            addCriterion("studentId in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotIn(List<Integer> values) {
            addCriterion("studentId not in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidBetween(Integer value1, Integer value2) {
            addCriterion("studentId between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotBetween(Integer value1, Integer value2) {
            addCriterion("studentId not between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
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