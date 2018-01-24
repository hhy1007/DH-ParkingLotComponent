package com.eg.egsc.scp.parkinglotcomponent.mapper.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkParkedCurCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParkParkedCurCriteria() {
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

        public Criteria andDeviceCodeIsNull() {
            addCriterion("device_code is null");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeIsNotNull() {
            addCriterion("device_code is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeEqualTo(String value) {
            addCriterion("device_code =", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeNotEqualTo(String value) {
            addCriterion("device_code <>", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeGreaterThan(String value) {
            addCriterion("device_code >", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("device_code >=", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeLessThan(String value) {
            addCriterion("device_code <", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeLessThanOrEqualTo(String value) {
            addCriterion("device_code <=", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeLike(String value) {
            addCriterion("device_code like", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeNotLike(String value) {
            addCriterion("device_code not like", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeIn(List<String> values) {
            addCriterion("device_code in", values, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeNotIn(List<String> values) {
            addCriterion("device_code not in", values, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeBetween(String value1, String value2) {
            addCriterion("device_code between", value1, value2, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeNotBetween(String value1, String value2) {
            addCriterion("device_code not between", value1, value2, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNull() {
            addCriterion("device_name is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNotNull() {
            addCriterion("device_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameEqualTo(String value) {
            addCriterion("device_name =", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotEqualTo(String value) {
            addCriterion("device_name <>", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThan(String value) {
            addCriterion("device_name >", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThanOrEqualTo(String value) {
            addCriterion("device_name >=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThan(String value) {
            addCriterion("device_name <", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThanOrEqualTo(String value) {
            addCriterion("device_name <=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLike(String value) {
            addCriterion("device_name like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotLike(String value) {
            addCriterion("device_name not like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIn(List<String> values) {
            addCriterion("device_name in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotIn(List<String> values) {
            addCriterion("device_name not in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameBetween(String value1, String value2) {
            addCriterion("device_name between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotBetween(String value1, String value2) {
            addCriterion("device_name not between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andMapIdIsNull() {
            addCriterion("map_id is null");
            return (Criteria) this;
        }

        public Criteria andMapIdIsNotNull() {
            addCriterion("map_id is not null");
            return (Criteria) this;
        }

        public Criteria andMapIdEqualTo(String value) {
            addCriterion("map_id =", value, "mapId");
            return (Criteria) this;
        }

        public Criteria andMapIdNotEqualTo(String value) {
            addCriterion("map_id <>", value, "mapId");
            return (Criteria) this;
        }

        public Criteria andMapIdGreaterThan(String value) {
            addCriterion("map_id >", value, "mapId");
            return (Criteria) this;
        }

        public Criteria andMapIdGreaterThanOrEqualTo(String value) {
            addCriterion("map_id >=", value, "mapId");
            return (Criteria) this;
        }

        public Criteria andMapIdLessThan(String value) {
            addCriterion("map_id <", value, "mapId");
            return (Criteria) this;
        }

        public Criteria andMapIdLessThanOrEqualTo(String value) {
            addCriterion("map_id <=", value, "mapId");
            return (Criteria) this;
        }

        public Criteria andMapIdLike(String value) {
            addCriterion("map_id like", value, "mapId");
            return (Criteria) this;
        }

        public Criteria andMapIdNotLike(String value) {
            addCriterion("map_id not like", value, "mapId");
            return (Criteria) this;
        }

        public Criteria andMapIdIn(List<String> values) {
            addCriterion("map_id in", values, "mapId");
            return (Criteria) this;
        }

        public Criteria andMapIdNotIn(List<String> values) {
            addCriterion("map_id not in", values, "mapId");
            return (Criteria) this;
        }

        public Criteria andMapIdBetween(String value1, String value2) {
            addCriterion("map_id between", value1, value2, "mapId");
            return (Criteria) this;
        }

        public Criteria andMapIdNotBetween(String value1, String value2) {
            addCriterion("map_id not between", value1, value2, "mapId");
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

        public Criteria andCarNumColorIsNull() {
            addCriterion("car_num_color is null");
            return (Criteria) this;
        }

        public Criteria andCarNumColorIsNotNull() {
            addCriterion("car_num_color is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumColorEqualTo(String value) {
            addCriterion("car_num_color =", value, "carNumColor");
            return (Criteria) this;
        }

        public Criteria andCarNumColorNotEqualTo(String value) {
            addCriterion("car_num_color <>", value, "carNumColor");
            return (Criteria) this;
        }

        public Criteria andCarNumColorGreaterThan(String value) {
            addCriterion("car_num_color >", value, "carNumColor");
            return (Criteria) this;
        }

        public Criteria andCarNumColorGreaterThanOrEqualTo(String value) {
            addCriterion("car_num_color >=", value, "carNumColor");
            return (Criteria) this;
        }

        public Criteria andCarNumColorLessThan(String value) {
            addCriterion("car_num_color <", value, "carNumColor");
            return (Criteria) this;
        }

        public Criteria andCarNumColorLessThanOrEqualTo(String value) {
            addCriterion("car_num_color <=", value, "carNumColor");
            return (Criteria) this;
        }

        public Criteria andCarNumColorLike(String value) {
            addCriterion("car_num_color like", value, "carNumColor");
            return (Criteria) this;
        }

        public Criteria andCarNumColorNotLike(String value) {
            addCriterion("car_num_color not like", value, "carNumColor");
            return (Criteria) this;
        }

        public Criteria andCarNumColorIn(List<String> values) {
            addCriterion("car_num_color in", values, "carNumColor");
            return (Criteria) this;
        }

        public Criteria andCarNumColorNotIn(List<String> values) {
            addCriterion("car_num_color not in", values, "carNumColor");
            return (Criteria) this;
        }

        public Criteria andCarNumColorBetween(String value1, String value2) {
            addCriterion("car_num_color between", value1, value2, "carNumColor");
            return (Criteria) this;
        }

        public Criteria andCarNumColorNotBetween(String value1, String value2) {
            addCriterion("car_num_color not between", value1, value2, "carNumColor");
            return (Criteria) this;
        }

        public Criteria andCarColorIsNull() {
            addCriterion("car_color is null");
            return (Criteria) this;
        }

        public Criteria andCarColorIsNotNull() {
            addCriterion("car_color is not null");
            return (Criteria) this;
        }

        public Criteria andCarColorEqualTo(String value) {
            addCriterion("car_color =", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorNotEqualTo(String value) {
            addCriterion("car_color <>", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorGreaterThan(String value) {
            addCriterion("car_color >", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorGreaterThanOrEqualTo(String value) {
            addCriterion("car_color >=", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorLessThan(String value) {
            addCriterion("car_color <", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorLessThanOrEqualTo(String value) {
            addCriterion("car_color <=", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorLike(String value) {
            addCriterion("car_color like", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorNotLike(String value) {
            addCriterion("car_color not like", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorIn(List<String> values) {
            addCriterion("car_color in", values, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorNotIn(List<String> values) {
            addCriterion("car_color not in", values, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorBetween(String value1, String value2) {
            addCriterion("car_color between", value1, value2, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorNotBetween(String value1, String value2) {
            addCriterion("car_color not between", value1, value2, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarMarkIsNull() {
            addCriterion("car_mark is null");
            return (Criteria) this;
        }

        public Criteria andCarMarkIsNotNull() {
            addCriterion("car_mark is not null");
            return (Criteria) this;
        }

        public Criteria andCarMarkEqualTo(String value) {
            addCriterion("car_mark =", value, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkNotEqualTo(String value) {
            addCriterion("car_mark <>", value, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkGreaterThan(String value) {
            addCriterion("car_mark >", value, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkGreaterThanOrEqualTo(String value) {
            addCriterion("car_mark >=", value, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkLessThan(String value) {
            addCriterion("car_mark <", value, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkLessThanOrEqualTo(String value) {
            addCriterion("car_mark <=", value, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkLike(String value) {
            addCriterion("car_mark like", value, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkNotLike(String value) {
            addCriterion("car_mark not like", value, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkIn(List<String> values) {
            addCriterion("car_mark in", values, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkNotIn(List<String> values) {
            addCriterion("car_mark not in", values, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkBetween(String value1, String value2) {
            addCriterion("car_mark between", value1, value2, "carMark");
            return (Criteria) this;
        }

        public Criteria andCarMarkNotBetween(String value1, String value2) {
            addCriterion("car_mark not between", value1, value2, "carMark");
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

        public Criteria andParkStartIsNull() {
            addCriterion("park_start is null");
            return (Criteria) this;
        }

        public Criteria andParkStartIsNotNull() {
            addCriterion("park_start is not null");
            return (Criteria) this;
        }

        public Criteria andParkStartEqualTo(Date value) {
            addCriterion("park_start =", value, "parkStart");
            return (Criteria) this;
        }

        public Criteria andParkStartNotEqualTo(Date value) {
            addCriterion("park_start <>", value, "parkStart");
            return (Criteria) this;
        }

        public Criteria andParkStartGreaterThan(Date value) {
            addCriterion("park_start >", value, "parkStart");
            return (Criteria) this;
        }

        public Criteria andParkStartGreaterThanOrEqualTo(Date value) {
            addCriterion("park_start >=", value, "parkStart");
            return (Criteria) this;
        }

        public Criteria andParkStartLessThan(Date value) {
            addCriterion("park_start <", value, "parkStart");
            return (Criteria) this;
        }

        public Criteria andParkStartLessThanOrEqualTo(Date value) {
            addCriterion("park_start <=", value, "parkStart");
            return (Criteria) this;
        }

        public Criteria andParkStartIn(List<Date> values) {
            addCriterion("park_start in", values, "parkStart");
            return (Criteria) this;
        }

        public Criteria andParkStartNotIn(List<Date> values) {
            addCriterion("park_start not in", values, "parkStart");
            return (Criteria) this;
        }

        public Criteria andParkStartBetween(Date value1, Date value2) {
            addCriterion("park_start between", value1, value2, "parkStart");
            return (Criteria) this;
        }

        public Criteria andParkStartNotBetween(Date value1, Date value2) {
            addCriterion("park_start not between", value1, value2, "parkStart");
            return (Criteria) this;
        }

        public Criteria andParkDateIsNull() {
            addCriterion("park_date is null");
            return (Criteria) this;
        }

        public Criteria andParkDateIsNotNull() {
            addCriterion("park_date is not null");
            return (Criteria) this;
        }

        public Criteria andParkDateEqualTo(Date value) {
            addCriterion("park_date =", value, "parkDate");
            return (Criteria) this;
        }

        public Criteria andParkDateNotEqualTo(Date value) {
            addCriterion("park_date <>", value, "parkDate");
            return (Criteria) this;
        }

        public Criteria andParkDateGreaterThan(Date value) {
            addCriterion("park_date >", value, "parkDate");
            return (Criteria) this;
        }

        public Criteria andParkDateGreaterThanOrEqualTo(Date value) {
            addCriterion("park_date >=", value, "parkDate");
            return (Criteria) this;
        }

        public Criteria andParkDateLessThan(Date value) {
            addCriterion("park_date <", value, "parkDate");
            return (Criteria) this;
        }

        public Criteria andParkDateLessThanOrEqualTo(Date value) {
            addCriterion("park_date <=", value, "parkDate");
            return (Criteria) this;
        }

        public Criteria andParkDateIn(List<Date> values) {
            addCriterion("park_date in", values, "parkDate");
            return (Criteria) this;
        }

        public Criteria andParkDateNotIn(List<Date> values) {
            addCriterion("park_date not in", values, "parkDate");
            return (Criteria) this;
        }

        public Criteria andParkDateBetween(Date value1, Date value2) {
            addCriterion("park_date between", value1, value2, "parkDate");
            return (Criteria) this;
        }

        public Criteria andParkDateNotBetween(Date value1, Date value2) {
            addCriterion("park_date not between", value1, value2, "parkDate");
            return (Criteria) this;
        }

        public Criteria andParkTypeIsNull() {
            addCriterion("park_type is null");
            return (Criteria) this;
        }

        public Criteria andParkTypeIsNotNull() {
            addCriterion("park_type is not null");
            return (Criteria) this;
        }

        public Criteria andParkTypeEqualTo(Short value) {
            addCriterion("park_type =", value, "parkType");
            return (Criteria) this;
        }

        public Criteria andParkTypeNotEqualTo(Short value) {
            addCriterion("park_type <>", value, "parkType");
            return (Criteria) this;
        }

        public Criteria andParkTypeGreaterThan(Short value) {
            addCriterion("park_type >", value, "parkType");
            return (Criteria) this;
        }

        public Criteria andParkTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("park_type >=", value, "parkType");
            return (Criteria) this;
        }

        public Criteria andParkTypeLessThan(Short value) {
            addCriterion("park_type <", value, "parkType");
            return (Criteria) this;
        }

        public Criteria andParkTypeLessThanOrEqualTo(Short value) {
            addCriterion("park_type <=", value, "parkType");
            return (Criteria) this;
        }

        public Criteria andParkTypeIn(List<Short> values) {
            addCriterion("park_type in", values, "parkType");
            return (Criteria) this;
        }

        public Criteria andParkTypeNotIn(List<Short> values) {
            addCriterion("park_type not in", values, "parkType");
            return (Criteria) this;
        }

        public Criteria andParkTypeBetween(Short value1, Short value2) {
            addCriterion("park_type between", value1, value2, "parkType");
            return (Criteria) this;
        }

        public Criteria andParkTypeNotBetween(Short value1, Short value2) {
            addCriterion("park_type not between", value1, value2, "parkType");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusIsNull() {
            addCriterion("alarm_status is null");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusIsNotNull() {
            addCriterion("alarm_status is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusEqualTo(Short value) {
            addCriterion("alarm_status =", value, "alarmStatus");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusNotEqualTo(Short value) {
            addCriterion("alarm_status <>", value, "alarmStatus");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusGreaterThan(Short value) {
            addCriterion("alarm_status >", value, "alarmStatus");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("alarm_status >=", value, "alarmStatus");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusLessThan(Short value) {
            addCriterion("alarm_status <", value, "alarmStatus");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusLessThanOrEqualTo(Short value) {
            addCriterion("alarm_status <=", value, "alarmStatus");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusIn(List<Short> values) {
            addCriterion("alarm_status in", values, "alarmStatus");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusNotIn(List<Short> values) {
            addCriterion("alarm_status not in", values, "alarmStatus");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusBetween(Short value1, Short value2) {
            addCriterion("alarm_status between", value1, value2, "alarmStatus");
            return (Criteria) this;
        }

        public Criteria andAlarmStatusNotBetween(Short value1, Short value2) {
            addCriterion("alarm_status not between", value1, value2, "alarmStatus");
            return (Criteria) this;
        }

        public Criteria andAlarmArrearIsNull() {
            addCriterion("alarm_arrear is null");
            return (Criteria) this;
        }

        public Criteria andAlarmArrearIsNotNull() {
            addCriterion("alarm_arrear is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmArrearEqualTo(Short value) {
            addCriterion("alarm_arrear =", value, "alarmArrear");
            return (Criteria) this;
        }

        public Criteria andAlarmArrearNotEqualTo(Short value) {
            addCriterion("alarm_arrear <>", value, "alarmArrear");
            return (Criteria) this;
        }

        public Criteria andAlarmArrearGreaterThan(Short value) {
            addCriterion("alarm_arrear >", value, "alarmArrear");
            return (Criteria) this;
        }

        public Criteria andAlarmArrearGreaterThanOrEqualTo(Short value) {
            addCriterion("alarm_arrear >=", value, "alarmArrear");
            return (Criteria) this;
        }

        public Criteria andAlarmArrearLessThan(Short value) {
            addCriterion("alarm_arrear <", value, "alarmArrear");
            return (Criteria) this;
        }

        public Criteria andAlarmArrearLessThanOrEqualTo(Short value) {
            addCriterion("alarm_arrear <=", value, "alarmArrear");
            return (Criteria) this;
        }

        public Criteria andAlarmArrearIn(List<Short> values) {
            addCriterion("alarm_arrear in", values, "alarmArrear");
            return (Criteria) this;
        }

        public Criteria andAlarmArrearNotIn(List<Short> values) {
            addCriterion("alarm_arrear not in", values, "alarmArrear");
            return (Criteria) this;
        }

        public Criteria andAlarmArrearBetween(Short value1, Short value2) {
            addCriterion("alarm_arrear between", value1, value2, "alarmArrear");
            return (Criteria) this;
        }

        public Criteria andAlarmArrearNotBetween(Short value1, Short value2) {
            addCriterion("alarm_arrear not between", value1, value2, "alarmArrear");
            return (Criteria) this;
        }

        public Criteria andAlarmAbnormalIsNull() {
            addCriterion("alarm_abnormal is null");
            return (Criteria) this;
        }

        public Criteria andAlarmAbnormalIsNotNull() {
            addCriterion("alarm_abnormal is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmAbnormalEqualTo(Short value) {
            addCriterion("alarm_abnormal =", value, "alarmAbnormal");
            return (Criteria) this;
        }

        public Criteria andAlarmAbnormalNotEqualTo(Short value) {
            addCriterion("alarm_abnormal <>", value, "alarmAbnormal");
            return (Criteria) this;
        }

        public Criteria andAlarmAbnormalGreaterThan(Short value) {
            addCriterion("alarm_abnormal >", value, "alarmAbnormal");
            return (Criteria) this;
        }

        public Criteria andAlarmAbnormalGreaterThanOrEqualTo(Short value) {
            addCriterion("alarm_abnormal >=", value, "alarmAbnormal");
            return (Criteria) this;
        }

        public Criteria andAlarmAbnormalLessThan(Short value) {
            addCriterion("alarm_abnormal <", value, "alarmAbnormal");
            return (Criteria) this;
        }

        public Criteria andAlarmAbnormalLessThanOrEqualTo(Short value) {
            addCriterion("alarm_abnormal <=", value, "alarmAbnormal");
            return (Criteria) this;
        }

        public Criteria andAlarmAbnormalIn(List<Short> values) {
            addCriterion("alarm_abnormal in", values, "alarmAbnormal");
            return (Criteria) this;
        }

        public Criteria andAlarmAbnormalNotIn(List<Short> values) {
            addCriterion("alarm_abnormal not in", values, "alarmAbnormal");
            return (Criteria) this;
        }

        public Criteria andAlarmAbnormalBetween(Short value1, Short value2) {
            addCriterion("alarm_abnormal between", value1, value2, "alarmAbnormal");
            return (Criteria) this;
        }

        public Criteria andAlarmAbnormalNotBetween(Short value1, Short value2) {
            addCriterion("alarm_abnormal not between", value1, value2, "alarmAbnormal");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNull() {
            addCriterion("img_url is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNotNull() {
            addCriterion("img_url is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEqualTo(String value) {
            addCriterion("img_url =", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotEqualTo(String value) {
            addCriterion("img_url <>", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThan(String value) {
            addCriterion("img_url >", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("img_url >=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThan(String value) {
            addCriterion("img_url <", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThanOrEqualTo(String value) {
            addCriterion("img_url <=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLike(String value) {
            addCriterion("img_url like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotLike(String value) {
            addCriterion("img_url not like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlIn(List<String> values) {
            addCriterion("img_url in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotIn(List<String> values) {
            addCriterion("img_url not in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlBetween(String value1, String value2) {
            addCriterion("img_url between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotBetween(String value1, String value2) {
            addCriterion("img_url not between", value1, value2, "imgUrl");
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