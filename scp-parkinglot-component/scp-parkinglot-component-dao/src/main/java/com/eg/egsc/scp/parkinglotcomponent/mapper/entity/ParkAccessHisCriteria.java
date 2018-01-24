package com.eg.egsc.scp.parkinglotcomponent.mapper.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkAccessHisCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParkAccessHisCriteria() {
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

        public Criteria andParkCodeIsNull() {
            addCriterion("park_code is null");
            return (Criteria) this;
        }

        public Criteria andParkCodeIsNotNull() {
            addCriterion("park_code is not null");
            return (Criteria) this;
        }

        public Criteria andParkCodeEqualTo(String value) {
            addCriterion("park_code =", value, "parkCode");
            return (Criteria) this;
        }

        public Criteria andParkCodeNotEqualTo(String value) {
            addCriterion("park_code <>", value, "parkCode");
            return (Criteria) this;
        }

        public Criteria andParkCodeGreaterThan(String value) {
            addCriterion("park_code >", value, "parkCode");
            return (Criteria) this;
        }

        public Criteria andParkCodeGreaterThanOrEqualTo(String value) {
            addCriterion("park_code >=", value, "parkCode");
            return (Criteria) this;
        }

        public Criteria andParkCodeLessThan(String value) {
            addCriterion("park_code <", value, "parkCode");
            return (Criteria) this;
        }

        public Criteria andParkCodeLessThanOrEqualTo(String value) {
            addCriterion("park_code <=", value, "parkCode");
            return (Criteria) this;
        }

        public Criteria andParkCodeLike(String value) {
            addCriterion("park_code like", value, "parkCode");
            return (Criteria) this;
        }

        public Criteria andParkCodeNotLike(String value) {
            addCriterion("park_code not like", value, "parkCode");
            return (Criteria) this;
        }

        public Criteria andParkCodeIn(List<String> values) {
            addCriterion("park_code in", values, "parkCode");
            return (Criteria) this;
        }

        public Criteria andParkCodeNotIn(List<String> values) {
            addCriterion("park_code not in", values, "parkCode");
            return (Criteria) this;
        }

        public Criteria andParkCodeBetween(String value1, String value2) {
            addCriterion("park_code between", value1, value2, "parkCode");
            return (Criteria) this;
        }

        public Criteria andParkCodeNotBetween(String value1, String value2) {
            addCriterion("park_code not between", value1, value2, "parkCode");
            return (Criteria) this;
        }

        public Criteria andCardNumberIsNull() {
            addCriterion("card_number is null");
            return (Criteria) this;
        }

        public Criteria andCardNumberIsNotNull() {
            addCriterion("card_number is not null");
            return (Criteria) this;
        }

        public Criteria andCardNumberEqualTo(String value) {
            addCriterion("card_number =", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotEqualTo(String value) {
            addCriterion("card_number <>", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberGreaterThan(String value) {
            addCriterion("card_number >", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberGreaterThanOrEqualTo(String value) {
            addCriterion("card_number >=", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLessThan(String value) {
            addCriterion("card_number <", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLessThanOrEqualTo(String value) {
            addCriterion("card_number <=", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLike(String value) {
            addCriterion("card_number like", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotLike(String value) {
            addCriterion("card_number not like", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberIn(List<String> values) {
            addCriterion("card_number in", values, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotIn(List<String> values) {
            addCriterion("card_number not in", values, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberBetween(String value1, String value2) {
            addCriterion("card_number between", value1, value2, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotBetween(String value1, String value2) {
            addCriterion("card_number not between", value1, value2, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCarportTypeIsNull() {
            addCriterion("carport_type is null");
            return (Criteria) this;
        }

        public Criteria andCarportTypeIsNotNull() {
            addCriterion("carport_type is not null");
            return (Criteria) this;
        }

        public Criteria andCarportTypeEqualTo(Short value) {
            addCriterion("carport_type =", value, "carportType");
            return (Criteria) this;
        }

        public Criteria andCarportTypeNotEqualTo(Short value) {
            addCriterion("carport_type <>", value, "carportType");
            return (Criteria) this;
        }

        public Criteria andCarportTypeGreaterThan(Short value) {
            addCriterion("carport_type >", value, "carportType");
            return (Criteria) this;
        }

        public Criteria andCarportTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("carport_type >=", value, "carportType");
            return (Criteria) this;
        }

        public Criteria andCarportTypeLessThan(Short value) {
            addCriterion("carport_type <", value, "carportType");
            return (Criteria) this;
        }

        public Criteria andCarportTypeLessThanOrEqualTo(Short value) {
            addCriterion("carport_type <=", value, "carportType");
            return (Criteria) this;
        }

        public Criteria andCarportTypeIn(List<Short> values) {
            addCriterion("carport_type in", values, "carportType");
            return (Criteria) this;
        }

        public Criteria andCarportTypeNotIn(List<Short> values) {
            addCriterion("carport_type not in", values, "carportType");
            return (Criteria) this;
        }

        public Criteria andCarportTypeBetween(Short value1, Short value2) {
            addCriterion("carport_type between", value1, value2, "carportType");
            return (Criteria) this;
        }

        public Criteria andCarportTypeNotBetween(Short value1, Short value2) {
            addCriterion("carport_type not between", value1, value2, "carportType");
            return (Criteria) this;
        }

        public Criteria andPackageIdIsNull() {
            addCriterion("package_id is null");
            return (Criteria) this;
        }

        public Criteria andPackageIdIsNotNull() {
            addCriterion("package_id is not null");
            return (Criteria) this;
        }

        public Criteria andPackageIdEqualTo(String value) {
            addCriterion("package_id =", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotEqualTo(String value) {
            addCriterion("package_id <>", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdGreaterThan(String value) {
            addCriterion("package_id >", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdGreaterThanOrEqualTo(String value) {
            addCriterion("package_id >=", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdLessThan(String value) {
            addCriterion("package_id <", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdLessThanOrEqualTo(String value) {
            addCriterion("package_id <=", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdLike(String value) {
            addCriterion("package_id like", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotLike(String value) {
            addCriterion("package_id not like", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdIn(List<String> values) {
            addCriterion("package_id in", values, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotIn(List<String> values) {
            addCriterion("package_id not in", values, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdBetween(String value1, String value2) {
            addCriterion("package_id between", value1, value2, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotBetween(String value1, String value2) {
            addCriterion("package_id not between", value1, value2, "packageId");
            return (Criteria) this;
        }

        public Criteria andCarModeIsNull() {
            addCriterion("car_mode is null");
            return (Criteria) this;
        }

        public Criteria andCarModeIsNotNull() {
            addCriterion("car_mode is not null");
            return (Criteria) this;
        }

        public Criteria andCarModeEqualTo(String value) {
            addCriterion("car_mode =", value, "carMode");
            return (Criteria) this;
        }

        public Criteria andCarModeNotEqualTo(String value) {
            addCriterion("car_mode <>", value, "carMode");
            return (Criteria) this;
        }

        public Criteria andCarModeGreaterThan(String value) {
            addCriterion("car_mode >", value, "carMode");
            return (Criteria) this;
        }

        public Criteria andCarModeGreaterThanOrEqualTo(String value) {
            addCriterion("car_mode >=", value, "carMode");
            return (Criteria) this;
        }

        public Criteria andCarModeLessThan(String value) {
            addCriterion("car_mode <", value, "carMode");
            return (Criteria) this;
        }

        public Criteria andCarModeLessThanOrEqualTo(String value) {
            addCriterion("car_mode <=", value, "carMode");
            return (Criteria) this;
        }

        public Criteria andCarModeLike(String value) {
            addCriterion("car_mode like", value, "carMode");
            return (Criteria) this;
        }

        public Criteria andCarModeNotLike(String value) {
            addCriterion("car_mode not like", value, "carMode");
            return (Criteria) this;
        }

        public Criteria andCarModeIn(List<String> values) {
            addCriterion("car_mode in", values, "carMode");
            return (Criteria) this;
        }

        public Criteria andCarModeNotIn(List<String> values) {
            addCriterion("car_mode not in", values, "carMode");
            return (Criteria) this;
        }

        public Criteria andCarModeBetween(String value1, String value2) {
            addCriterion("car_mode between", value1, value2, "carMode");
            return (Criteria) this;
        }

        public Criteria andCarModeNotBetween(String value1, String value2) {
            addCriterion("car_mode not between", value1, value2, "carMode");
            return (Criteria) this;
        }

        public Criteria andInChannelIdIsNull() {
            addCriterion("in_channel_id is null");
            return (Criteria) this;
        }

        public Criteria andInChannelIdIsNotNull() {
            addCriterion("in_channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andInChannelIdEqualTo(String value) {
            addCriterion("in_channel_id =", value, "inChannelId");
            return (Criteria) this;
        }

        public Criteria andInChannelIdNotEqualTo(String value) {
            addCriterion("in_channel_id <>", value, "inChannelId");
            return (Criteria) this;
        }

        public Criteria andInChannelIdGreaterThan(String value) {
            addCriterion("in_channel_id >", value, "inChannelId");
            return (Criteria) this;
        }

        public Criteria andInChannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("in_channel_id >=", value, "inChannelId");
            return (Criteria) this;
        }

        public Criteria andInChannelIdLessThan(String value) {
            addCriterion("in_channel_id <", value, "inChannelId");
            return (Criteria) this;
        }

        public Criteria andInChannelIdLessThanOrEqualTo(String value) {
            addCriterion("in_channel_id <=", value, "inChannelId");
            return (Criteria) this;
        }

        public Criteria andInChannelIdLike(String value) {
            addCriterion("in_channel_id like", value, "inChannelId");
            return (Criteria) this;
        }

        public Criteria andInChannelIdNotLike(String value) {
            addCriterion("in_channel_id not like", value, "inChannelId");
            return (Criteria) this;
        }

        public Criteria andInChannelIdIn(List<String> values) {
            addCriterion("in_channel_id in", values, "inChannelId");
            return (Criteria) this;
        }

        public Criteria andInChannelIdNotIn(List<String> values) {
            addCriterion("in_channel_id not in", values, "inChannelId");
            return (Criteria) this;
        }

        public Criteria andInChannelIdBetween(String value1, String value2) {
            addCriterion("in_channel_id between", value1, value2, "inChannelId");
            return (Criteria) this;
        }

        public Criteria andInChannelIdNotBetween(String value1, String value2) {
            addCriterion("in_channel_id not between", value1, value2, "inChannelId");
            return (Criteria) this;
        }

        public Criteria andInCameraCodeIsNull() {
            addCriterion("in_camera_code is null");
            return (Criteria) this;
        }

        public Criteria andInCameraCodeIsNotNull() {
            addCriterion("in_camera_code is not null");
            return (Criteria) this;
        }

        public Criteria andInCameraCodeEqualTo(String value) {
            addCriterion("in_camera_code =", value, "inCameraCode");
            return (Criteria) this;
        }

        public Criteria andInCameraCodeNotEqualTo(String value) {
            addCriterion("in_camera_code <>", value, "inCameraCode");
            return (Criteria) this;
        }

        public Criteria andInCameraCodeGreaterThan(String value) {
            addCriterion("in_camera_code >", value, "inCameraCode");
            return (Criteria) this;
        }

        public Criteria andInCameraCodeGreaterThanOrEqualTo(String value) {
            addCriterion("in_camera_code >=", value, "inCameraCode");
            return (Criteria) this;
        }

        public Criteria andInCameraCodeLessThan(String value) {
            addCriterion("in_camera_code <", value, "inCameraCode");
            return (Criteria) this;
        }

        public Criteria andInCameraCodeLessThanOrEqualTo(String value) {
            addCriterion("in_camera_code <=", value, "inCameraCode");
            return (Criteria) this;
        }

        public Criteria andInCameraCodeLike(String value) {
            addCriterion("in_camera_code like", value, "inCameraCode");
            return (Criteria) this;
        }

        public Criteria andInCameraCodeNotLike(String value) {
            addCriterion("in_camera_code not like", value, "inCameraCode");
            return (Criteria) this;
        }

        public Criteria andInCameraCodeIn(List<String> values) {
            addCriterion("in_camera_code in", values, "inCameraCode");
            return (Criteria) this;
        }

        public Criteria andInCameraCodeNotIn(List<String> values) {
            addCriterion("in_camera_code not in", values, "inCameraCode");
            return (Criteria) this;
        }

        public Criteria andInCameraCodeBetween(String value1, String value2) {
            addCriterion("in_camera_code between", value1, value2, "inCameraCode");
            return (Criteria) this;
        }

        public Criteria andInCameraCodeNotBetween(String value1, String value2) {
            addCriterion("in_camera_code not between", value1, value2, "inCameraCode");
            return (Criteria) this;
        }

        public Criteria andInSluiceCodeIsNull() {
            addCriterion("in_sluice_code is null");
            return (Criteria) this;
        }

        public Criteria andInSluiceCodeIsNotNull() {
            addCriterion("in_sluice_code is not null");
            return (Criteria) this;
        }

        public Criteria andInSluiceCodeEqualTo(String value) {
            addCriterion("in_sluice_code =", value, "inSluiceCode");
            return (Criteria) this;
        }

        public Criteria andInSluiceCodeNotEqualTo(String value) {
            addCriterion("in_sluice_code <>", value, "inSluiceCode");
            return (Criteria) this;
        }

        public Criteria andInSluiceCodeGreaterThan(String value) {
            addCriterion("in_sluice_code >", value, "inSluiceCode");
            return (Criteria) this;
        }

        public Criteria andInSluiceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("in_sluice_code >=", value, "inSluiceCode");
            return (Criteria) this;
        }

        public Criteria andInSluiceCodeLessThan(String value) {
            addCriterion("in_sluice_code <", value, "inSluiceCode");
            return (Criteria) this;
        }

        public Criteria andInSluiceCodeLessThanOrEqualTo(String value) {
            addCriterion("in_sluice_code <=", value, "inSluiceCode");
            return (Criteria) this;
        }

        public Criteria andInSluiceCodeLike(String value) {
            addCriterion("in_sluice_code like", value, "inSluiceCode");
            return (Criteria) this;
        }

        public Criteria andInSluiceCodeNotLike(String value) {
            addCriterion("in_sluice_code not like", value, "inSluiceCode");
            return (Criteria) this;
        }

        public Criteria andInSluiceCodeIn(List<String> values) {
            addCriterion("in_sluice_code in", values, "inSluiceCode");
            return (Criteria) this;
        }

        public Criteria andInSluiceCodeNotIn(List<String> values) {
            addCriterion("in_sluice_code not in", values, "inSluiceCode");
            return (Criteria) this;
        }

        public Criteria andInSluiceCodeBetween(String value1, String value2) {
            addCriterion("in_sluice_code between", value1, value2, "inSluiceCode");
            return (Criteria) this;
        }

        public Criteria andInSluiceCodeNotBetween(String value1, String value2) {
            addCriterion("in_sluice_code not between", value1, value2, "inSluiceCode");
            return (Criteria) this;
        }

        public Criteria andInImgUrlIsNull() {
            addCriterion("in_img_url is null");
            return (Criteria) this;
        }

        public Criteria andInImgUrlIsNotNull() {
            addCriterion("in_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andInImgUrlEqualTo(String value) {
            addCriterion("in_img_url =", value, "inImgUrl");
            return (Criteria) this;
        }

        public Criteria andInImgUrlNotEqualTo(String value) {
            addCriterion("in_img_url <>", value, "inImgUrl");
            return (Criteria) this;
        }

        public Criteria andInImgUrlGreaterThan(String value) {
            addCriterion("in_img_url >", value, "inImgUrl");
            return (Criteria) this;
        }

        public Criteria andInImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("in_img_url >=", value, "inImgUrl");
            return (Criteria) this;
        }

        public Criteria andInImgUrlLessThan(String value) {
            addCriterion("in_img_url <", value, "inImgUrl");
            return (Criteria) this;
        }

        public Criteria andInImgUrlLessThanOrEqualTo(String value) {
            addCriterion("in_img_url <=", value, "inImgUrl");
            return (Criteria) this;
        }

        public Criteria andInImgUrlLike(String value) {
            addCriterion("in_img_url like", value, "inImgUrl");
            return (Criteria) this;
        }

        public Criteria andInImgUrlNotLike(String value) {
            addCriterion("in_img_url not like", value, "inImgUrl");
            return (Criteria) this;
        }

        public Criteria andInImgUrlIn(List<String> values) {
            addCriterion("in_img_url in", values, "inImgUrl");
            return (Criteria) this;
        }

        public Criteria andInImgUrlNotIn(List<String> values) {
            addCriterion("in_img_url not in", values, "inImgUrl");
            return (Criteria) this;
        }

        public Criteria andInImgUrlBetween(String value1, String value2) {
            addCriterion("in_img_url between", value1, value2, "inImgUrl");
            return (Criteria) this;
        }

        public Criteria andInImgUrlNotBetween(String value1, String value2) {
            addCriterion("in_img_url not between", value1, value2, "inImgUrl");
            return (Criteria) this;
        }

        public Criteria andInMemoIsNull() {
            addCriterion("in_memo is null");
            return (Criteria) this;
        }

        public Criteria andInMemoIsNotNull() {
            addCriterion("in_memo is not null");
            return (Criteria) this;
        }

        public Criteria andInMemoEqualTo(String value) {
            addCriterion("in_memo =", value, "inMemo");
            return (Criteria) this;
        }

        public Criteria andInMemoNotEqualTo(String value) {
            addCriterion("in_memo <>", value, "inMemo");
            return (Criteria) this;
        }

        public Criteria andInMemoGreaterThan(String value) {
            addCriterion("in_memo >", value, "inMemo");
            return (Criteria) this;
        }

        public Criteria andInMemoGreaterThanOrEqualTo(String value) {
            addCriterion("in_memo >=", value, "inMemo");
            return (Criteria) this;
        }

        public Criteria andInMemoLessThan(String value) {
            addCriterion("in_memo <", value, "inMemo");
            return (Criteria) this;
        }

        public Criteria andInMemoLessThanOrEqualTo(String value) {
            addCriterion("in_memo <=", value, "inMemo");
            return (Criteria) this;
        }

        public Criteria andInMemoLike(String value) {
            addCriterion("in_memo like", value, "inMemo");
            return (Criteria) this;
        }

        public Criteria andInMemoNotLike(String value) {
            addCriterion("in_memo not like", value, "inMemo");
            return (Criteria) this;
        }

        public Criteria andInMemoIn(List<String> values) {
            addCriterion("in_memo in", values, "inMemo");
            return (Criteria) this;
        }

        public Criteria andInMemoNotIn(List<String> values) {
            addCriterion("in_memo not in", values, "inMemo");
            return (Criteria) this;
        }

        public Criteria andInMemoBetween(String value1, String value2) {
            addCriterion("in_memo between", value1, value2, "inMemo");
            return (Criteria) this;
        }

        public Criteria andInMemoNotBetween(String value1, String value2) {
            addCriterion("in_memo not between", value1, value2, "inMemo");
            return (Criteria) this;
        }

        public Criteria andOutCarNumIsNull() {
            addCriterion("out_car_num is null");
            return (Criteria) this;
        }

        public Criteria andOutCarNumIsNotNull() {
            addCriterion("out_car_num is not null");
            return (Criteria) this;
        }

        public Criteria andOutCarNumEqualTo(String value) {
            addCriterion("out_car_num =", value, "outCarNum");
            return (Criteria) this;
        }

        public Criteria andOutCarNumNotEqualTo(String value) {
            addCriterion("out_car_num <>", value, "outCarNum");
            return (Criteria) this;
        }

        public Criteria andOutCarNumGreaterThan(String value) {
            addCriterion("out_car_num >", value, "outCarNum");
            return (Criteria) this;
        }

        public Criteria andOutCarNumGreaterThanOrEqualTo(String value) {
            addCriterion("out_car_num >=", value, "outCarNum");
            return (Criteria) this;
        }

        public Criteria andOutCarNumLessThan(String value) {
            addCriterion("out_car_num <", value, "outCarNum");
            return (Criteria) this;
        }

        public Criteria andOutCarNumLessThanOrEqualTo(String value) {
            addCriterion("out_car_num <=", value, "outCarNum");
            return (Criteria) this;
        }

        public Criteria andOutCarNumLike(String value) {
            addCriterion("out_car_num like", value, "outCarNum");
            return (Criteria) this;
        }

        public Criteria andOutCarNumNotLike(String value) {
            addCriterion("out_car_num not like", value, "outCarNum");
            return (Criteria) this;
        }

        public Criteria andOutCarNumIn(List<String> values) {
            addCriterion("out_car_num in", values, "outCarNum");
            return (Criteria) this;
        }

        public Criteria andOutCarNumNotIn(List<String> values) {
            addCriterion("out_car_num not in", values, "outCarNum");
            return (Criteria) this;
        }

        public Criteria andOutCarNumBetween(String value1, String value2) {
            addCriterion("out_car_num between", value1, value2, "outCarNum");
            return (Criteria) this;
        }

        public Criteria andOutCarNumNotBetween(String value1, String value2) {
            addCriterion("out_car_num not between", value1, value2, "outCarNum");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdIsNull() {
            addCriterion("out_channel_id is null");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdIsNotNull() {
            addCriterion("out_channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdEqualTo(String value) {
            addCriterion("out_channel_id =", value, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdNotEqualTo(String value) {
            addCriterion("out_channel_id <>", value, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdGreaterThan(String value) {
            addCriterion("out_channel_id >", value, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("out_channel_id >=", value, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdLessThan(String value) {
            addCriterion("out_channel_id <", value, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdLessThanOrEqualTo(String value) {
            addCriterion("out_channel_id <=", value, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdLike(String value) {
            addCriterion("out_channel_id like", value, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdNotLike(String value) {
            addCriterion("out_channel_id not like", value, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdIn(List<String> values) {
            addCriterion("out_channel_id in", values, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdNotIn(List<String> values) {
            addCriterion("out_channel_id not in", values, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdBetween(String value1, String value2) {
            addCriterion("out_channel_id between", value1, value2, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdNotBetween(String value1, String value2) {
            addCriterion("out_channel_id not between", value1, value2, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutCameraCodeIsNull() {
            addCriterion("out_camera_code is null");
            return (Criteria) this;
        }

        public Criteria andOutCameraCodeIsNotNull() {
            addCriterion("out_camera_code is not null");
            return (Criteria) this;
        }

        public Criteria andOutCameraCodeEqualTo(String value) {
            addCriterion("out_camera_code =", value, "outCameraCode");
            return (Criteria) this;
        }

        public Criteria andOutCameraCodeNotEqualTo(String value) {
            addCriterion("out_camera_code <>", value, "outCameraCode");
            return (Criteria) this;
        }

        public Criteria andOutCameraCodeGreaterThan(String value) {
            addCriterion("out_camera_code >", value, "outCameraCode");
            return (Criteria) this;
        }

        public Criteria andOutCameraCodeGreaterThanOrEqualTo(String value) {
            addCriterion("out_camera_code >=", value, "outCameraCode");
            return (Criteria) this;
        }

        public Criteria andOutCameraCodeLessThan(String value) {
            addCriterion("out_camera_code <", value, "outCameraCode");
            return (Criteria) this;
        }

        public Criteria andOutCameraCodeLessThanOrEqualTo(String value) {
            addCriterion("out_camera_code <=", value, "outCameraCode");
            return (Criteria) this;
        }

        public Criteria andOutCameraCodeLike(String value) {
            addCriterion("out_camera_code like", value, "outCameraCode");
            return (Criteria) this;
        }

        public Criteria andOutCameraCodeNotLike(String value) {
            addCriterion("out_camera_code not like", value, "outCameraCode");
            return (Criteria) this;
        }

        public Criteria andOutCameraCodeIn(List<String> values) {
            addCriterion("out_camera_code in", values, "outCameraCode");
            return (Criteria) this;
        }

        public Criteria andOutCameraCodeNotIn(List<String> values) {
            addCriterion("out_camera_code not in", values, "outCameraCode");
            return (Criteria) this;
        }

        public Criteria andOutCameraCodeBetween(String value1, String value2) {
            addCriterion("out_camera_code between", value1, value2, "outCameraCode");
            return (Criteria) this;
        }

        public Criteria andOutCameraCodeNotBetween(String value1, String value2) {
            addCriterion("out_camera_code not between", value1, value2, "outCameraCode");
            return (Criteria) this;
        }

        public Criteria andOutSluiceCodeIsNull() {
            addCriterion("out_sluice_code is null");
            return (Criteria) this;
        }

        public Criteria andOutSluiceCodeIsNotNull() {
            addCriterion("out_sluice_code is not null");
            return (Criteria) this;
        }

        public Criteria andOutSluiceCodeEqualTo(String value) {
            addCriterion("out_sluice_code =", value, "outSluiceCode");
            return (Criteria) this;
        }

        public Criteria andOutSluiceCodeNotEqualTo(String value) {
            addCriterion("out_sluice_code <>", value, "outSluiceCode");
            return (Criteria) this;
        }

        public Criteria andOutSluiceCodeGreaterThan(String value) {
            addCriterion("out_sluice_code >", value, "outSluiceCode");
            return (Criteria) this;
        }

        public Criteria andOutSluiceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("out_sluice_code >=", value, "outSluiceCode");
            return (Criteria) this;
        }

        public Criteria andOutSluiceCodeLessThan(String value) {
            addCriterion("out_sluice_code <", value, "outSluiceCode");
            return (Criteria) this;
        }

        public Criteria andOutSluiceCodeLessThanOrEqualTo(String value) {
            addCriterion("out_sluice_code <=", value, "outSluiceCode");
            return (Criteria) this;
        }

        public Criteria andOutSluiceCodeLike(String value) {
            addCriterion("out_sluice_code like", value, "outSluiceCode");
            return (Criteria) this;
        }

        public Criteria andOutSluiceCodeNotLike(String value) {
            addCriterion("out_sluice_code not like", value, "outSluiceCode");
            return (Criteria) this;
        }

        public Criteria andOutSluiceCodeIn(List<String> values) {
            addCriterion("out_sluice_code in", values, "outSluiceCode");
            return (Criteria) this;
        }

        public Criteria andOutSluiceCodeNotIn(List<String> values) {
            addCriterion("out_sluice_code not in", values, "outSluiceCode");
            return (Criteria) this;
        }

        public Criteria andOutSluiceCodeBetween(String value1, String value2) {
            addCriterion("out_sluice_code between", value1, value2, "outSluiceCode");
            return (Criteria) this;
        }

        public Criteria andOutSluiceCodeNotBetween(String value1, String value2) {
            addCriterion("out_sluice_code not between", value1, value2, "outSluiceCode");
            return (Criteria) this;
        }

        public Criteria andOutImgUrlIsNull() {
            addCriterion("out_img_url is null");
            return (Criteria) this;
        }

        public Criteria andOutImgUrlIsNotNull() {
            addCriterion("out_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andOutImgUrlEqualTo(String value) {
            addCriterion("out_img_url =", value, "outImgUrl");
            return (Criteria) this;
        }

        public Criteria andOutImgUrlNotEqualTo(String value) {
            addCriterion("out_img_url <>", value, "outImgUrl");
            return (Criteria) this;
        }

        public Criteria andOutImgUrlGreaterThan(String value) {
            addCriterion("out_img_url >", value, "outImgUrl");
            return (Criteria) this;
        }

        public Criteria andOutImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("out_img_url >=", value, "outImgUrl");
            return (Criteria) this;
        }

        public Criteria andOutImgUrlLessThan(String value) {
            addCriterion("out_img_url <", value, "outImgUrl");
            return (Criteria) this;
        }

        public Criteria andOutImgUrlLessThanOrEqualTo(String value) {
            addCriterion("out_img_url <=", value, "outImgUrl");
            return (Criteria) this;
        }

        public Criteria andOutImgUrlLike(String value) {
            addCriterion("out_img_url like", value, "outImgUrl");
            return (Criteria) this;
        }

        public Criteria andOutImgUrlNotLike(String value) {
            addCriterion("out_img_url not like", value, "outImgUrl");
            return (Criteria) this;
        }

        public Criteria andOutImgUrlIn(List<String> values) {
            addCriterion("out_img_url in", values, "outImgUrl");
            return (Criteria) this;
        }

        public Criteria andOutImgUrlNotIn(List<String> values) {
            addCriterion("out_img_url not in", values, "outImgUrl");
            return (Criteria) this;
        }

        public Criteria andOutImgUrlBetween(String value1, String value2) {
            addCriterion("out_img_url between", value1, value2, "outImgUrl");
            return (Criteria) this;
        }

        public Criteria andOutImgUrlNotBetween(String value1, String value2) {
            addCriterion("out_img_url not between", value1, value2, "outImgUrl");
            return (Criteria) this;
        }

        public Criteria andOutMemoIsNull() {
            addCriterion("out_memo is null");
            return (Criteria) this;
        }

        public Criteria andOutMemoIsNotNull() {
            addCriterion("out_memo is not null");
            return (Criteria) this;
        }

        public Criteria andOutMemoEqualTo(String value) {
            addCriterion("out_memo =", value, "outMemo");
            return (Criteria) this;
        }

        public Criteria andOutMemoNotEqualTo(String value) {
            addCriterion("out_memo <>", value, "outMemo");
            return (Criteria) this;
        }

        public Criteria andOutMemoGreaterThan(String value) {
            addCriterion("out_memo >", value, "outMemo");
            return (Criteria) this;
        }

        public Criteria andOutMemoGreaterThanOrEqualTo(String value) {
            addCriterion("out_memo >=", value, "outMemo");
            return (Criteria) this;
        }

        public Criteria andOutMemoLessThan(String value) {
            addCriterion("out_memo <", value, "outMemo");
            return (Criteria) this;
        }

        public Criteria andOutMemoLessThanOrEqualTo(String value) {
            addCriterion("out_memo <=", value, "outMemo");
            return (Criteria) this;
        }

        public Criteria andOutMemoLike(String value) {
            addCriterion("out_memo like", value, "outMemo");
            return (Criteria) this;
        }

        public Criteria andOutMemoNotLike(String value) {
            addCriterion("out_memo not like", value, "outMemo");
            return (Criteria) this;
        }

        public Criteria andOutMemoIn(List<String> values) {
            addCriterion("out_memo in", values, "outMemo");
            return (Criteria) this;
        }

        public Criteria andOutMemoNotIn(List<String> values) {
            addCriterion("out_memo not in", values, "outMemo");
            return (Criteria) this;
        }

        public Criteria andOutMemoBetween(String value1, String value2) {
            addCriterion("out_memo between", value1, value2, "outMemo");
            return (Criteria) this;
        }

        public Criteria andOutMemoNotBetween(String value1, String value2) {
            addCriterion("out_memo not between", value1, value2, "outMemo");
            return (Criteria) this;
        }

        public Criteria andEnterModeIsNull() {
            addCriterion("enter_mode is null");
            return (Criteria) this;
        }

        public Criteria andEnterModeIsNotNull() {
            addCriterion("enter_mode is not null");
            return (Criteria) this;
        }

        public Criteria andEnterModeEqualTo(Short value) {
            addCriterion("enter_mode =", value, "enterMode");
            return (Criteria) this;
        }

        public Criteria andEnterModeNotEqualTo(Short value) {
            addCriterion("enter_mode <>", value, "enterMode");
            return (Criteria) this;
        }

        public Criteria andEnterModeGreaterThan(Short value) {
            addCriterion("enter_mode >", value, "enterMode");
            return (Criteria) this;
        }

        public Criteria andEnterModeGreaterThanOrEqualTo(Short value) {
            addCriterion("enter_mode >=", value, "enterMode");
            return (Criteria) this;
        }

        public Criteria andEnterModeLessThan(Short value) {
            addCriterion("enter_mode <", value, "enterMode");
            return (Criteria) this;
        }

        public Criteria andEnterModeLessThanOrEqualTo(Short value) {
            addCriterion("enter_mode <=", value, "enterMode");
            return (Criteria) this;
        }

        public Criteria andEnterModeIn(List<Short> values) {
            addCriterion("enter_mode in", values, "enterMode");
            return (Criteria) this;
        }

        public Criteria andEnterModeNotIn(List<Short> values) {
            addCriterion("enter_mode not in", values, "enterMode");
            return (Criteria) this;
        }

        public Criteria andEnterModeBetween(Short value1, Short value2) {
            addCriterion("enter_mode between", value1, value2, "enterMode");
            return (Criteria) this;
        }

        public Criteria andEnterModeNotBetween(Short value1, Short value2) {
            addCriterion("enter_mode not between", value1, value2, "enterMode");
            return (Criteria) this;
        }

        public Criteria andPayedMoneyIsNull() {
            addCriterion("payed_money is null");
            return (Criteria) this;
        }

        public Criteria andPayedMoneyIsNotNull() {
            addCriterion("payed_money is not null");
            return (Criteria) this;
        }

        public Criteria andPayedMoneyEqualTo(Integer value) {
            addCriterion("payed_money =", value, "payedMoney");
            return (Criteria) this;
        }

        public Criteria andPayedMoneyNotEqualTo(Integer value) {
            addCriterion("payed_money <>", value, "payedMoney");
            return (Criteria) this;
        }

        public Criteria andPayedMoneyGreaterThan(Integer value) {
            addCriterion("payed_money >", value, "payedMoney");
            return (Criteria) this;
        }

        public Criteria andPayedMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("payed_money >=", value, "payedMoney");
            return (Criteria) this;
        }

        public Criteria andPayedMoneyLessThan(Integer value) {
            addCriterion("payed_money <", value, "payedMoney");
            return (Criteria) this;
        }

        public Criteria andPayedMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("payed_money <=", value, "payedMoney");
            return (Criteria) this;
        }

        public Criteria andPayedMoneyIn(List<Integer> values) {
            addCriterion("payed_money in", values, "payedMoney");
            return (Criteria) this;
        }

        public Criteria andPayedMoneyNotIn(List<Integer> values) {
            addCriterion("payed_money not in", values, "payedMoney");
            return (Criteria) this;
        }

        public Criteria andPayedMoneyBetween(Integer value1, Integer value2) {
            addCriterion("payed_money between", value1, value2, "payedMoney");
            return (Criteria) this;
        }

        public Criteria andPayedMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("payed_money not between", value1, value2, "payedMoney");
            return (Criteria) this;
        }

        public Criteria andLastPayedTimeIsNull() {
            addCriterion("last_payed_time is null");
            return (Criteria) this;
        }

        public Criteria andLastPayedTimeIsNotNull() {
            addCriterion("last_payed_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastPayedTimeEqualTo(Date value) {
            addCriterion("last_payed_time =", value, "lastPayedTime");
            return (Criteria) this;
        }

        public Criteria andLastPayedTimeNotEqualTo(Date value) {
            addCriterion("last_payed_time <>", value, "lastPayedTime");
            return (Criteria) this;
        }

        public Criteria andLastPayedTimeGreaterThan(Date value) {
            addCriterion("last_payed_time >", value, "lastPayedTime");
            return (Criteria) this;
        }

        public Criteria andLastPayedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_payed_time >=", value, "lastPayedTime");
            return (Criteria) this;
        }

        public Criteria andLastPayedTimeLessThan(Date value) {
            addCriterion("last_payed_time <", value, "lastPayedTime");
            return (Criteria) this;
        }

        public Criteria andLastPayedTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_payed_time <=", value, "lastPayedTime");
            return (Criteria) this;
        }

        public Criteria andLastPayedTimeIn(List<Date> values) {
            addCriterion("last_payed_time in", values, "lastPayedTime");
            return (Criteria) this;
        }

        public Criteria andLastPayedTimeNotIn(List<Date> values) {
            addCriterion("last_payed_time not in", values, "lastPayedTime");
            return (Criteria) this;
        }

        public Criteria andLastPayedTimeBetween(Date value1, Date value2) {
            addCriterion("last_payed_time between", value1, value2, "lastPayedTime");
            return (Criteria) this;
        }

        public Criteria andLastPayedTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_payed_time not between", value1, value2, "lastPayedTime");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNull() {
            addCriterion("car_type is null");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNotNull() {
            addCriterion("car_type is not null");
            return (Criteria) this;
        }

        public Criteria andCarTypeEqualTo(Short value) {
            addCriterion("car_type =", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotEqualTo(Short value) {
            addCriterion("car_type <>", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThan(Short value) {
            addCriterion("car_type >", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("car_type >=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThan(Short value) {
            addCriterion("car_type <", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThanOrEqualTo(Short value) {
            addCriterion("car_type <=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeIn(List<Short> values) {
            addCriterion("car_type in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotIn(List<Short> values) {
            addCriterion("car_type not in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeBetween(Short value1, Short value2) {
            addCriterion("car_type between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotBetween(Short value1, Short value2) {
            addCriterion("car_type not between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andCarStatusIsNull() {
            addCriterion("car_status is null");
            return (Criteria) this;
        }

        public Criteria andCarStatusIsNotNull() {
            addCriterion("car_status is not null");
            return (Criteria) this;
        }

        public Criteria andCarStatusEqualTo(Short value) {
            addCriterion("car_status =", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusNotEqualTo(Short value) {
            addCriterion("car_status <>", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusGreaterThan(Short value) {
            addCriterion("car_status >", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("car_status >=", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusLessThan(Short value) {
            addCriterion("car_status <", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusLessThanOrEqualTo(Short value) {
            addCriterion("car_status <=", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusIn(List<Short> values) {
            addCriterion("car_status in", values, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusNotIn(List<Short> values) {
            addCriterion("car_status not in", values, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusBetween(Short value1, Short value2) {
            addCriterion("car_status between", value1, value2, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusNotBetween(Short value1, Short value2) {
            addCriterion("car_status not between", value1, value2, "carStatus");
            return (Criteria) this;
        }

        public Criteria andForceOperatorIsNull() {
            addCriterion("force_operator is null");
            return (Criteria) this;
        }

        public Criteria andForceOperatorIsNotNull() {
            addCriterion("force_operator is not null");
            return (Criteria) this;
        }

        public Criteria andForceOperatorEqualTo(String value) {
            addCriterion("force_operator =", value, "forceOperator");
            return (Criteria) this;
        }

        public Criteria andForceOperatorNotEqualTo(String value) {
            addCriterion("force_operator <>", value, "forceOperator");
            return (Criteria) this;
        }

        public Criteria andForceOperatorGreaterThan(String value) {
            addCriterion("force_operator >", value, "forceOperator");
            return (Criteria) this;
        }

        public Criteria andForceOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("force_operator >=", value, "forceOperator");
            return (Criteria) this;
        }

        public Criteria andForceOperatorLessThan(String value) {
            addCriterion("force_operator <", value, "forceOperator");
            return (Criteria) this;
        }

        public Criteria andForceOperatorLessThanOrEqualTo(String value) {
            addCriterion("force_operator <=", value, "forceOperator");
            return (Criteria) this;
        }

        public Criteria andForceOperatorLike(String value) {
            addCriterion("force_operator like", value, "forceOperator");
            return (Criteria) this;
        }

        public Criteria andForceOperatorNotLike(String value) {
            addCriterion("force_operator not like", value, "forceOperator");
            return (Criteria) this;
        }

        public Criteria andForceOperatorIn(List<String> values) {
            addCriterion("force_operator in", values, "forceOperator");
            return (Criteria) this;
        }

        public Criteria andForceOperatorNotIn(List<String> values) {
            addCriterion("force_operator not in", values, "forceOperator");
            return (Criteria) this;
        }

        public Criteria andForceOperatorBetween(String value1, String value2) {
            addCriterion("force_operator between", value1, value2, "forceOperator");
            return (Criteria) this;
        }

        public Criteria andForceOperatorNotBetween(String value1, String value2) {
            addCriterion("force_operator not between", value1, value2, "forceOperator");
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