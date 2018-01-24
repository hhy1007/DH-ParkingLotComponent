package com.eg.egsc.scp.parkinglotcomponent.mapper.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkAlarmAbnormalCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParkAlarmAbnormalCriteria() {
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

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andCarportcodeIsNull() {
            addCriterion("carportcode is null");
            return (Criteria) this;
        }

        public Criteria andCarportcodeIsNotNull() {
            addCriterion("carportcode is not null");
            return (Criteria) this;
        }

        public Criteria andCarportcodeEqualTo(String value) {
            addCriterion("carportcode =", value, "carportcode");
            return (Criteria) this;
        }

        public Criteria andCarportcodeNotEqualTo(String value) {
            addCriterion("carportcode <>", value, "carportcode");
            return (Criteria) this;
        }

        public Criteria andCarportcodeGreaterThan(String value) {
            addCriterion("carportcode >", value, "carportcode");
            return (Criteria) this;
        }

        public Criteria andCarportcodeGreaterThanOrEqualTo(String value) {
            addCriterion("carportcode >=", value, "carportcode");
            return (Criteria) this;
        }

        public Criteria andCarportcodeLessThan(String value) {
            addCriterion("carportcode <", value, "carportcode");
            return (Criteria) this;
        }

        public Criteria andCarportcodeLessThanOrEqualTo(String value) {
            addCriterion("carportcode <=", value, "carportcode");
            return (Criteria) this;
        }

        public Criteria andCarportcodeLike(String value) {
            addCriterion("carportcode like", value, "carportcode");
            return (Criteria) this;
        }

        public Criteria andCarportcodeNotLike(String value) {
            addCriterion("carportcode not like", value, "carportcode");
            return (Criteria) this;
        }

        public Criteria andCarportcodeIn(List<String> values) {
            addCriterion("carportcode in", values, "carportcode");
            return (Criteria) this;
        }

        public Criteria andCarportcodeNotIn(List<String> values) {
            addCriterion("carportcode not in", values, "carportcode");
            return (Criteria) this;
        }

        public Criteria andCarportcodeBetween(String value1, String value2) {
            addCriterion("carportcode between", value1, value2, "carportcode");
            return (Criteria) this;
        }

        public Criteria andCarportcodeNotBetween(String value1, String value2) {
            addCriterion("carportcode not between", value1, value2, "carportcode");
            return (Criteria) this;
        }

        public Criteria andCarNumIsNull() {
            addCriterion("car_num is null");
            return (Criteria) this;
        }

        public Criteria andCarNumIsNotNull() {
            addCriterion("car_num is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumEqualTo(String value) {
            addCriterion("car_num =", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumNotEqualTo(String value) {
            addCriterion("car_num <>", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumGreaterThan(String value) {
            addCriterion("car_num >", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumGreaterThanOrEqualTo(String value) {
            addCriterion("car_num >=", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumLessThan(String value) {
            addCriterion("car_num <", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumLessThanOrEqualTo(String value) {
            addCriterion("car_num <=", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumLike(String value) {
            addCriterion("car_num like", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumNotLike(String value) {
            addCriterion("car_num not like", value, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumIn(List<String> values) {
            addCriterion("car_num in", values, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumNotIn(List<String> values) {
            addCriterion("car_num not in", values, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumBetween(String value1, String value2) {
            addCriterion("car_num between", value1, value2, "carNum");
            return (Criteria) this;
        }

        public Criteria andCarNumNotBetween(String value1, String value2) {
            addCriterion("car_num not between", value1, value2, "carNum");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNull() {
            addCriterion("in_time is null");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNotNull() {
            addCriterion("in_time is not null");
            return (Criteria) this;
        }

        public Criteria andInTimeEqualTo(Date value) {
            addCriterion("in_time =", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotEqualTo(Date value) {
            addCriterion("in_time <>", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThan(Date value) {
            addCriterion("in_time >", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("in_time >=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThan(Date value) {
            addCriterion("in_time <", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThanOrEqualTo(Date value) {
            addCriterion("in_time <=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeIn(List<Date> values) {
            addCriterion("in_time in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotIn(List<Date> values) {
            addCriterion("in_time not in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeBetween(Date value1, Date value2) {
            addCriterion("in_time between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotBetween(Date value1, Date value2) {
            addCriterion("in_time not between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andFeeAmountIsNull() {
            addCriterion("fee_amount is null");
            return (Criteria) this;
        }

        public Criteria andFeeAmountIsNotNull() {
            addCriterion("fee_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFeeAmountEqualTo(Integer value) {
            addCriterion("fee_amount =", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountNotEqualTo(Integer value) {
            addCriterion("fee_amount <>", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountGreaterThan(Integer value) {
            addCriterion("fee_amount >", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("fee_amount >=", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountLessThan(Integer value) {
            addCriterion("fee_amount <", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountLessThanOrEqualTo(Integer value) {
            addCriterion("fee_amount <=", value, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountIn(List<Integer> values) {
            addCriterion("fee_amount in", values, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountNotIn(List<Integer> values) {
            addCriterion("fee_amount not in", values, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountBetween(Integer value1, Integer value2) {
            addCriterion("fee_amount between", value1, value2, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andFeeAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("fee_amount not between", value1, value2, "feeAmount");
            return (Criteria) this;
        }

        public Criteria andDispatchStateIsNull() {
            addCriterion("dispatch_state is null");
            return (Criteria) this;
        }

        public Criteria andDispatchStateIsNotNull() {
            addCriterion("dispatch_state is not null");
            return (Criteria) this;
        }

        public Criteria andDispatchStateEqualTo(Short value) {
            addCriterion("dispatch_state =", value, "dispatchState");
            return (Criteria) this;
        }

        public Criteria andDispatchStateNotEqualTo(Short value) {
            addCriterion("dispatch_state <>", value, "dispatchState");
            return (Criteria) this;
        }

        public Criteria andDispatchStateGreaterThan(Short value) {
            addCriterion("dispatch_state >", value, "dispatchState");
            return (Criteria) this;
        }

        public Criteria andDispatchStateGreaterThanOrEqualTo(Short value) {
            addCriterion("dispatch_state >=", value, "dispatchState");
            return (Criteria) this;
        }

        public Criteria andDispatchStateLessThan(Short value) {
            addCriterion("dispatch_state <", value, "dispatchState");
            return (Criteria) this;
        }

        public Criteria andDispatchStateLessThanOrEqualTo(Short value) {
            addCriterion("dispatch_state <=", value, "dispatchState");
            return (Criteria) this;
        }

        public Criteria andDispatchStateIn(List<Short> values) {
            addCriterion("dispatch_state in", values, "dispatchState");
            return (Criteria) this;
        }

        public Criteria andDispatchStateNotIn(List<Short> values) {
            addCriterion("dispatch_state not in", values, "dispatchState");
            return (Criteria) this;
        }

        public Criteria andDispatchStateBetween(Short value1, Short value2) {
            addCriterion("dispatch_state between", value1, value2, "dispatchState");
            return (Criteria) this;
        }

        public Criteria andDispatchStateNotBetween(Short value1, Short value2) {
            addCriterion("dispatch_state not between", value1, value2, "dispatchState");
            return (Criteria) this;
        }

        public Criteria andDispatchUserIsNull() {
            addCriterion("dispatch_user is null");
            return (Criteria) this;
        }

        public Criteria andDispatchUserIsNotNull() {
            addCriterion("dispatch_user is not null");
            return (Criteria) this;
        }

        public Criteria andDispatchUserEqualTo(String value) {
            addCriterion("dispatch_user =", value, "dispatchUser");
            return (Criteria) this;
        }

        public Criteria andDispatchUserNotEqualTo(String value) {
            addCriterion("dispatch_user <>", value, "dispatchUser");
            return (Criteria) this;
        }

        public Criteria andDispatchUserGreaterThan(String value) {
            addCriterion("dispatch_user >", value, "dispatchUser");
            return (Criteria) this;
        }

        public Criteria andDispatchUserGreaterThanOrEqualTo(String value) {
            addCriterion("dispatch_user >=", value, "dispatchUser");
            return (Criteria) this;
        }

        public Criteria andDispatchUserLessThan(String value) {
            addCriterion("dispatch_user <", value, "dispatchUser");
            return (Criteria) this;
        }

        public Criteria andDispatchUserLessThanOrEqualTo(String value) {
            addCriterion("dispatch_user <=", value, "dispatchUser");
            return (Criteria) this;
        }

        public Criteria andDispatchUserLike(String value) {
            addCriterion("dispatch_user like", value, "dispatchUser");
            return (Criteria) this;
        }

        public Criteria andDispatchUserNotLike(String value) {
            addCriterion("dispatch_user not like", value, "dispatchUser");
            return (Criteria) this;
        }

        public Criteria andDispatchUserIn(List<String> values) {
            addCriterion("dispatch_user in", values, "dispatchUser");
            return (Criteria) this;
        }

        public Criteria andDispatchUserNotIn(List<String> values) {
            addCriterion("dispatch_user not in", values, "dispatchUser");
            return (Criteria) this;
        }

        public Criteria andDispatchUserBetween(String value1, String value2) {
            addCriterion("dispatch_user between", value1, value2, "dispatchUser");
            return (Criteria) this;
        }

        public Criteria andDispatchUserNotBetween(String value1, String value2) {
            addCriterion("dispatch_user not between", value1, value2, "dispatchUser");
            return (Criteria) this;
        }

        public Criteria andAlarmStateIsNull() {
            addCriterion("alarm_state is null");
            return (Criteria) this;
        }

        public Criteria andAlarmStateIsNotNull() {
            addCriterion("alarm_state is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmStateEqualTo(Short value) {
            addCriterion("alarm_state =", value, "alarmState");
            return (Criteria) this;
        }

        public Criteria andAlarmStateNotEqualTo(Short value) {
            addCriterion("alarm_state <>", value, "alarmState");
            return (Criteria) this;
        }

        public Criteria andAlarmStateGreaterThan(Short value) {
            addCriterion("alarm_state >", value, "alarmState");
            return (Criteria) this;
        }

        public Criteria andAlarmStateGreaterThanOrEqualTo(Short value) {
            addCriterion("alarm_state >=", value, "alarmState");
            return (Criteria) this;
        }

        public Criteria andAlarmStateLessThan(Short value) {
            addCriterion("alarm_state <", value, "alarmState");
            return (Criteria) this;
        }

        public Criteria andAlarmStateLessThanOrEqualTo(Short value) {
            addCriterion("alarm_state <=", value, "alarmState");
            return (Criteria) this;
        }

        public Criteria andAlarmStateIn(List<Short> values) {
            addCriterion("alarm_state in", values, "alarmState");
            return (Criteria) this;
        }

        public Criteria andAlarmStateNotIn(List<Short> values) {
            addCriterion("alarm_state not in", values, "alarmState");
            return (Criteria) this;
        }

        public Criteria andAlarmStateBetween(Short value1, Short value2) {
            addCriterion("alarm_state between", value1, value2, "alarmState");
            return (Criteria) this;
        }

        public Criteria andAlarmStateNotBetween(Short value1, Short value2) {
            addCriterion("alarm_state not between", value1, value2, "alarmState");
            return (Criteria) this;
        }

        public Criteria andRelieveUserIsNull() {
            addCriterion("relieve_user is null");
            return (Criteria) this;
        }

        public Criteria andRelieveUserIsNotNull() {
            addCriterion("relieve_user is not null");
            return (Criteria) this;
        }

        public Criteria andRelieveUserEqualTo(String value) {
            addCriterion("relieve_user =", value, "relieveUser");
            return (Criteria) this;
        }

        public Criteria andRelieveUserNotEqualTo(String value) {
            addCriterion("relieve_user <>", value, "relieveUser");
            return (Criteria) this;
        }

        public Criteria andRelieveUserGreaterThan(String value) {
            addCriterion("relieve_user >", value, "relieveUser");
            return (Criteria) this;
        }

        public Criteria andRelieveUserGreaterThanOrEqualTo(String value) {
            addCriterion("relieve_user >=", value, "relieveUser");
            return (Criteria) this;
        }

        public Criteria andRelieveUserLessThan(String value) {
            addCriterion("relieve_user <", value, "relieveUser");
            return (Criteria) this;
        }

        public Criteria andRelieveUserLessThanOrEqualTo(String value) {
            addCriterion("relieve_user <=", value, "relieveUser");
            return (Criteria) this;
        }

        public Criteria andRelieveUserLike(String value) {
            addCriterion("relieve_user like", value, "relieveUser");
            return (Criteria) this;
        }

        public Criteria andRelieveUserNotLike(String value) {
            addCriterion("relieve_user not like", value, "relieveUser");
            return (Criteria) this;
        }

        public Criteria andRelieveUserIn(List<String> values) {
            addCriterion("relieve_user in", values, "relieveUser");
            return (Criteria) this;
        }

        public Criteria andRelieveUserNotIn(List<String> values) {
            addCriterion("relieve_user not in", values, "relieveUser");
            return (Criteria) this;
        }

        public Criteria andRelieveUserBetween(String value1, String value2) {
            addCriterion("relieve_user between", value1, value2, "relieveUser");
            return (Criteria) this;
        }

        public Criteria andRelieveUserNotBetween(String value1, String value2) {
            addCriterion("relieve_user not between", value1, value2, "relieveUser");
            return (Criteria) this;
        }

        public Criteria andCourtUuidIsNull() {
            addCriterion("court_uuid is null");
            return (Criteria) this;
        }

        public Criteria andCourtUuidIsNotNull() {
            addCriterion("court_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andCourtUuidEqualTo(String value) {
            addCriterion("court_uuid =", value, "courtUuid");
            return (Criteria) this;
        }

        public Criteria andCourtUuidNotEqualTo(String value) {
            addCriterion("court_uuid <>", value, "courtUuid");
            return (Criteria) this;
        }

        public Criteria andCourtUuidGreaterThan(String value) {
            addCriterion("court_uuid >", value, "courtUuid");
            return (Criteria) this;
        }

        public Criteria andCourtUuidGreaterThanOrEqualTo(String value) {
            addCriterion("court_uuid >=", value, "courtUuid");
            return (Criteria) this;
        }

        public Criteria andCourtUuidLessThan(String value) {
            addCriterion("court_uuid <", value, "courtUuid");
            return (Criteria) this;
        }

        public Criteria andCourtUuidLessThanOrEqualTo(String value) {
            addCriterion("court_uuid <=", value, "courtUuid");
            return (Criteria) this;
        }

        public Criteria andCourtUuidLike(String value) {
            addCriterion("court_uuid like", value, "courtUuid");
            return (Criteria) this;
        }

        public Criteria andCourtUuidNotLike(String value) {
            addCriterion("court_uuid not like", value, "courtUuid");
            return (Criteria) this;
        }

        public Criteria andCourtUuidIn(List<String> values) {
            addCriterion("court_uuid in", values, "courtUuid");
            return (Criteria) this;
        }

        public Criteria andCourtUuidNotIn(List<String> values) {
            addCriterion("court_uuid not in", values, "courtUuid");
            return (Criteria) this;
        }

        public Criteria andCourtUuidBetween(String value1, String value2) {
            addCriterion("court_uuid between", value1, value2, "courtUuid");
            return (Criteria) this;
        }

        public Criteria andCourtUuidNotBetween(String value1, String value2) {
            addCriterion("court_uuid not between", value1, value2, "courtUuid");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
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