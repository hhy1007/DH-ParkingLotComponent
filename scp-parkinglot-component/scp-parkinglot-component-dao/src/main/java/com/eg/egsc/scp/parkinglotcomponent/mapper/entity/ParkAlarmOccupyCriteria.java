package com.eg.egsc.scp.parkinglotcomponent.mapper.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkAlarmOccupyCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParkAlarmOccupyCriteria() {
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

        public Criteria andCarportCodeIsNull() {
            addCriterion("carport_code is null");
            return (Criteria) this;
        }

        public Criteria andCarportCodeIsNotNull() {
            addCriterion("carport_code is not null");
            return (Criteria) this;
        }

        public Criteria andCarportCodeEqualTo(String value) {
            addCriterion("carport_code =", value, "carportCode");
            return (Criteria) this;
        }

        public Criteria andCarportCodeNotEqualTo(String value) {
            addCriterion("carport_code <>", value, "carportCode");
            return (Criteria) this;
        }

        public Criteria andCarportCodeGreaterThan(String value) {
            addCriterion("carport_code >", value, "carportCode");
            return (Criteria) this;
        }

        public Criteria andCarportCodeGreaterThanOrEqualTo(String value) {
            addCriterion("carport_code >=", value, "carportCode");
            return (Criteria) this;
        }

        public Criteria andCarportCodeLessThan(String value) {
            addCriterion("carport_code <", value, "carportCode");
            return (Criteria) this;
        }

        public Criteria andCarportCodeLessThanOrEqualTo(String value) {
            addCriterion("carport_code <=", value, "carportCode");
            return (Criteria) this;
        }

        public Criteria andCarportCodeLike(String value) {
            addCriterion("carport_code like", value, "carportCode");
            return (Criteria) this;
        }

        public Criteria andCarportCodeNotLike(String value) {
            addCriterion("carport_code not like", value, "carportCode");
            return (Criteria) this;
        }

        public Criteria andCarportCodeIn(List<String> values) {
            addCriterion("carport_code in", values, "carportCode");
            return (Criteria) this;
        }

        public Criteria andCarportCodeNotIn(List<String> values) {
            addCriterion("carport_code not in", values, "carportCode");
            return (Criteria) this;
        }

        public Criteria andCarportCodeBetween(String value1, String value2) {
            addCriterion("carport_code between", value1, value2, "carportCode");
            return (Criteria) this;
        }

        public Criteria andCarportCodeNotBetween(String value1, String value2) {
            addCriterion("carport_code not between", value1, value2, "carportCode");
            return (Criteria) this;
        }

        public Criteria andCarNumFixedIsNull() {
            addCriterion("car_num_fixed is null");
            return (Criteria) this;
        }

        public Criteria andCarNumFixedIsNotNull() {
            addCriterion("car_num_fixed is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumFixedEqualTo(String value) {
            addCriterion("car_num_fixed =", value, "carNumFixed");
            return (Criteria) this;
        }

        public Criteria andCarNumFixedNotEqualTo(String value) {
            addCriterion("car_num_fixed <>", value, "carNumFixed");
            return (Criteria) this;
        }

        public Criteria andCarNumFixedGreaterThan(String value) {
            addCriterion("car_num_fixed >", value, "carNumFixed");
            return (Criteria) this;
        }

        public Criteria andCarNumFixedGreaterThanOrEqualTo(String value) {
            addCriterion("car_num_fixed >=", value, "carNumFixed");
            return (Criteria) this;
        }

        public Criteria andCarNumFixedLessThan(String value) {
            addCriterion("car_num_fixed <", value, "carNumFixed");
            return (Criteria) this;
        }

        public Criteria andCarNumFixedLessThanOrEqualTo(String value) {
            addCriterion("car_num_fixed <=", value, "carNumFixed");
            return (Criteria) this;
        }

        public Criteria andCarNumFixedLike(String value) {
            addCriterion("car_num_fixed like", value, "carNumFixed");
            return (Criteria) this;
        }

        public Criteria andCarNumFixedNotLike(String value) {
            addCriterion("car_num_fixed not like", value, "carNumFixed");
            return (Criteria) this;
        }

        public Criteria andCarNumFixedIn(List<String> values) {
            addCriterion("car_num_fixed in", values, "carNumFixed");
            return (Criteria) this;
        }

        public Criteria andCarNumFixedNotIn(List<String> values) {
            addCriterion("car_num_fixed not in", values, "carNumFixed");
            return (Criteria) this;
        }

        public Criteria andCarNumFixedBetween(String value1, String value2) {
            addCriterion("car_num_fixed between", value1, value2, "carNumFixed");
            return (Criteria) this;
        }

        public Criteria andCarNumFixedNotBetween(String value1, String value2) {
            addCriterion("car_num_fixed not between", value1, value2, "carNumFixed");
            return (Criteria) this;
        }

        public Criteria andCarNumCurIsNull() {
            addCriterion("car_num_cur is null");
            return (Criteria) this;
        }

        public Criteria andCarNumCurIsNotNull() {
            addCriterion("car_num_cur is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumCurEqualTo(String value) {
            addCriterion("car_num_cur =", value, "carNumCur");
            return (Criteria) this;
        }

        public Criteria andCarNumCurNotEqualTo(String value) {
            addCriterion("car_num_cur <>", value, "carNumCur");
            return (Criteria) this;
        }

        public Criteria andCarNumCurGreaterThan(String value) {
            addCriterion("car_num_cur >", value, "carNumCur");
            return (Criteria) this;
        }

        public Criteria andCarNumCurGreaterThanOrEqualTo(String value) {
            addCriterion("car_num_cur >=", value, "carNumCur");
            return (Criteria) this;
        }

        public Criteria andCarNumCurLessThan(String value) {
            addCriterion("car_num_cur <", value, "carNumCur");
            return (Criteria) this;
        }

        public Criteria andCarNumCurLessThanOrEqualTo(String value) {
            addCriterion("car_num_cur <=", value, "carNumCur");
            return (Criteria) this;
        }

        public Criteria andCarNumCurLike(String value) {
            addCriterion("car_num_cur like", value, "carNumCur");
            return (Criteria) this;
        }

        public Criteria andCarNumCurNotLike(String value) {
            addCriterion("car_num_cur not like", value, "carNumCur");
            return (Criteria) this;
        }

        public Criteria andCarNumCurIn(List<String> values) {
            addCriterion("car_num_cur in", values, "carNumCur");
            return (Criteria) this;
        }

        public Criteria andCarNumCurNotIn(List<String> values) {
            addCriterion("car_num_cur not in", values, "carNumCur");
            return (Criteria) this;
        }

        public Criteria andCarNumCurBetween(String value1, String value2) {
            addCriterion("car_num_cur between", value1, value2, "carNumCur");
            return (Criteria) this;
        }

        public Criteria andCarNumCurNotBetween(String value1, String value2) {
            addCriterion("car_num_cur not between", value1, value2, "carNumCur");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNull() {
            addCriterion("owner_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNotNull() {
            addCriterion("owner_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdEqualTo(String value) {
            addCriterion("owner_id =", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotEqualTo(String value) {
            addCriterion("owner_id <>", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThan(String value) {
            addCriterion("owner_id >", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("owner_id >=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThan(String value) {
            addCriterion("owner_id <", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThanOrEqualTo(String value) {
            addCriterion("owner_id <=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLike(String value) {
            addCriterion("owner_id like", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotLike(String value) {
            addCriterion("owner_id not like", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIn(List<String> values) {
            addCriterion("owner_id in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotIn(List<String> values) {
            addCriterion("owner_id not in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdBetween(String value1, String value2) {
            addCriterion("owner_id between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotBetween(String value1, String value2) {
            addCriterion("owner_id not between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerNameIsNull() {
            addCriterion("owner_name is null");
            return (Criteria) this;
        }

        public Criteria andOwnerNameIsNotNull() {
            addCriterion("owner_name is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerNameEqualTo(String value) {
            addCriterion("owner_name =", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotEqualTo(String value) {
            addCriterion("owner_name <>", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameGreaterThan(String value) {
            addCriterion("owner_name >", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("owner_name >=", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLessThan(String value) {
            addCriterion("owner_name <", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLessThanOrEqualTo(String value) {
            addCriterion("owner_name <=", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLike(String value) {
            addCriterion("owner_name like", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotLike(String value) {
            addCriterion("owner_name not like", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameIn(List<String> values) {
            addCriterion("owner_name in", values, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotIn(List<String> values) {
            addCriterion("owner_name not in", values, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameBetween(String value1, String value2) {
            addCriterion("owner_name between", value1, value2, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotBetween(String value1, String value2) {
            addCriterion("owner_name not between", value1, value2, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneIsNull() {
            addCriterion("owner_phone is null");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneIsNotNull() {
            addCriterion("owner_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneEqualTo(String value) {
            addCriterion("owner_phone =", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneNotEqualTo(String value) {
            addCriterion("owner_phone <>", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneGreaterThan(String value) {
            addCriterion("owner_phone >", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("owner_phone >=", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneLessThan(String value) {
            addCriterion("owner_phone <", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneLessThanOrEqualTo(String value) {
            addCriterion("owner_phone <=", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneLike(String value) {
            addCriterion("owner_phone like", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneNotLike(String value) {
            addCriterion("owner_phone not like", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneIn(List<String> values) {
            addCriterion("owner_phone in", values, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneNotIn(List<String> values) {
            addCriterion("owner_phone not in", values, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneBetween(String value1, String value2) {
            addCriterion("owner_phone between", value1, value2, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneNotBetween(String value1, String value2) {
            addCriterion("owner_phone not between", value1, value2, "ownerPhone");
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