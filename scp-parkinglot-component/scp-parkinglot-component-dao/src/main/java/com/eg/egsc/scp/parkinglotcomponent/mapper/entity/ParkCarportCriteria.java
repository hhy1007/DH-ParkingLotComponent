package com.eg.egsc.scp.parkinglotcomponent.mapper.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkCarportCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParkCarportCriteria() {
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

        public Criteria andCarportShapeIsNull() {
            addCriterion("carport_shape is null");
            return (Criteria) this;
        }

        public Criteria andCarportShapeIsNotNull() {
            addCriterion("carport_shape is not null");
            return (Criteria) this;
        }

        public Criteria andCarportShapeEqualTo(String value) {
            addCriterion("carport_shape =", value, "carportShape");
            return (Criteria) this;
        }

        public Criteria andCarportShapeNotEqualTo(String value) {
            addCriterion("carport_shape <>", value, "carportShape");
            return (Criteria) this;
        }

        public Criteria andCarportShapeGreaterThan(String value) {
            addCriterion("carport_shape >", value, "carportShape");
            return (Criteria) this;
        }

        public Criteria andCarportShapeGreaterThanOrEqualTo(String value) {
            addCriterion("carport_shape >=", value, "carportShape");
            return (Criteria) this;
        }

        public Criteria andCarportShapeLessThan(String value) {
            addCriterion("carport_shape <", value, "carportShape");
            return (Criteria) this;
        }

        public Criteria andCarportShapeLessThanOrEqualTo(String value) {
            addCriterion("carport_shape <=", value, "carportShape");
            return (Criteria) this;
        }

        public Criteria andCarportShapeLike(String value) {
            addCriterion("carport_shape like", value, "carportShape");
            return (Criteria) this;
        }

        public Criteria andCarportShapeNotLike(String value) {
            addCriterion("carport_shape not like", value, "carportShape");
            return (Criteria) this;
        }

        public Criteria andCarportShapeIn(List<String> values) {
            addCriterion("carport_shape in", values, "carportShape");
            return (Criteria) this;
        }

        public Criteria andCarportShapeNotIn(List<String> values) {
            addCriterion("carport_shape not in", values, "carportShape");
            return (Criteria) this;
        }

        public Criteria andCarportShapeBetween(String value1, String value2) {
            addCriterion("carport_shape between", value1, value2, "carportShape");
            return (Criteria) this;
        }

        public Criteria andCarportShapeNotBetween(String value1, String value2) {
            addCriterion("carport_shape not between", value1, value2, "carportShape");
            return (Criteria) this;
        }

        public Criteria andCarportAllocationIsNull() {
            addCriterion("carport_allocation is null");
            return (Criteria) this;
        }

        public Criteria andCarportAllocationIsNotNull() {
            addCriterion("carport_allocation is not null");
            return (Criteria) this;
        }

        public Criteria andCarportAllocationEqualTo(Short value) {
            addCriterion("carport_allocation =", value, "carportAllocation");
            return (Criteria) this;
        }

        public Criteria andCarportAllocationNotEqualTo(Short value) {
            addCriterion("carport_allocation <>", value, "carportAllocation");
            return (Criteria) this;
        }

        public Criteria andCarportAllocationGreaterThan(Short value) {
            addCriterion("carport_allocation >", value, "carportAllocation");
            return (Criteria) this;
        }

        public Criteria andCarportAllocationGreaterThanOrEqualTo(Short value) {
            addCriterion("carport_allocation >=", value, "carportAllocation");
            return (Criteria) this;
        }

        public Criteria andCarportAllocationLessThan(Short value) {
            addCriterion("carport_allocation <", value, "carportAllocation");
            return (Criteria) this;
        }

        public Criteria andCarportAllocationLessThanOrEqualTo(Short value) {
            addCriterion("carport_allocation <=", value, "carportAllocation");
            return (Criteria) this;
        }

        public Criteria andCarportAllocationIn(List<Short> values) {
            addCriterion("carport_allocation in", values, "carportAllocation");
            return (Criteria) this;
        }

        public Criteria andCarportAllocationNotIn(List<Short> values) {
            addCriterion("carport_allocation not in", values, "carportAllocation");
            return (Criteria) this;
        }

        public Criteria andCarportAllocationBetween(Short value1, Short value2) {
            addCriterion("carport_allocation between", value1, value2, "carportAllocation");
            return (Criteria) this;
        }

        public Criteria andCarportAllocationNotBetween(Short value1, Short value2) {
            addCriterion("carport_allocation not between", value1, value2, "carportAllocation");
            return (Criteria) this;
        }

        public Criteria andDetectorCodeIsNull() {
            addCriterion("detector_code is null");
            return (Criteria) this;
        }

        public Criteria andDetectorCodeIsNotNull() {
            addCriterion("detector_code is not null");
            return (Criteria) this;
        }

        public Criteria andDetectorCodeEqualTo(String value) {
            addCriterion("detector_code =", value, "detectorCode");
            return (Criteria) this;
        }

        public Criteria andDetectorCodeNotEqualTo(String value) {
            addCriterion("detector_code <>", value, "detectorCode");
            return (Criteria) this;
        }

        public Criteria andDetectorCodeGreaterThan(String value) {
            addCriterion("detector_code >", value, "detectorCode");
            return (Criteria) this;
        }

        public Criteria andDetectorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("detector_code >=", value, "detectorCode");
            return (Criteria) this;
        }

        public Criteria andDetectorCodeLessThan(String value) {
            addCriterion("detector_code <", value, "detectorCode");
            return (Criteria) this;
        }

        public Criteria andDetectorCodeLessThanOrEqualTo(String value) {
            addCriterion("detector_code <=", value, "detectorCode");
            return (Criteria) this;
        }

        public Criteria andDetectorCodeLike(String value) {
            addCriterion("detector_code like", value, "detectorCode");
            return (Criteria) this;
        }

        public Criteria andDetectorCodeNotLike(String value) {
            addCriterion("detector_code not like", value, "detectorCode");
            return (Criteria) this;
        }

        public Criteria andDetectorCodeIn(List<String> values) {
            addCriterion("detector_code in", values, "detectorCode");
            return (Criteria) this;
        }

        public Criteria andDetectorCodeNotIn(List<String> values) {
            addCriterion("detector_code not in", values, "detectorCode");
            return (Criteria) this;
        }

        public Criteria andDetectorCodeBetween(String value1, String value2) {
            addCriterion("detector_code between", value1, value2, "detectorCode");
            return (Criteria) this;
        }

        public Criteria andDetectorCodeNotBetween(String value1, String value2) {
            addCriterion("detector_code not between", value1, value2, "detectorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeIsNull() {
            addCriterion("monitor_code is null");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeIsNotNull() {
            addCriterion("monitor_code is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeEqualTo(String value) {
            addCriterion("monitor_code =", value, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeNotEqualTo(String value) {
            addCriterion("monitor_code <>", value, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeGreaterThan(String value) {
            addCriterion("monitor_code >", value, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("monitor_code >=", value, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeLessThan(String value) {
            addCriterion("monitor_code <", value, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeLessThanOrEqualTo(String value) {
            addCriterion("monitor_code <=", value, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeLike(String value) {
            addCriterion("monitor_code like", value, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeNotLike(String value) {
            addCriterion("monitor_code not like", value, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeIn(List<String> values) {
            addCriterion("monitor_code in", values, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeNotIn(List<String> values) {
            addCriterion("monitor_code not in", values, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeBetween(String value1, String value2) {
            addCriterion("monitor_code between", value1, value2, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeNotBetween(String value1, String value2) {
            addCriterion("monitor_code not between", value1, value2, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorModeIsNull() {
            addCriterion("monitor_mode is null");
            return (Criteria) this;
        }

        public Criteria andMonitorModeIsNotNull() {
            addCriterion("monitor_mode is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorModeEqualTo(Short value) {
            addCriterion("monitor_mode =", value, "monitorMode");
            return (Criteria) this;
        }

        public Criteria andMonitorModeNotEqualTo(Short value) {
            addCriterion("monitor_mode <>", value, "monitorMode");
            return (Criteria) this;
        }

        public Criteria andMonitorModeGreaterThan(Short value) {
            addCriterion("monitor_mode >", value, "monitorMode");
            return (Criteria) this;
        }

        public Criteria andMonitorModeGreaterThanOrEqualTo(Short value) {
            addCriterion("monitor_mode >=", value, "monitorMode");
            return (Criteria) this;
        }

        public Criteria andMonitorModeLessThan(Short value) {
            addCriterion("monitor_mode <", value, "monitorMode");
            return (Criteria) this;
        }

        public Criteria andMonitorModeLessThanOrEqualTo(Short value) {
            addCriterion("monitor_mode <=", value, "monitorMode");
            return (Criteria) this;
        }

        public Criteria andMonitorModeIn(List<Short> values) {
            addCriterion("monitor_mode in", values, "monitorMode");
            return (Criteria) this;
        }

        public Criteria andMonitorModeNotIn(List<Short> values) {
            addCriterion("monitor_mode not in", values, "monitorMode");
            return (Criteria) this;
        }

        public Criteria andMonitorModeBetween(Short value1, Short value2) {
            addCriterion("monitor_mode between", value1, value2, "monitorMode");
            return (Criteria) this;
        }

        public Criteria andMonitorModeNotBetween(Short value1, Short value2) {
            addCriterion("monitor_mode not between", value1, value2, "monitorMode");
            return (Criteria) this;
        }

        public Criteria andMonitorTextIsNull() {
            addCriterion("monitor_text is null");
            return (Criteria) this;
        }

        public Criteria andMonitorTextIsNotNull() {
            addCriterion("monitor_text is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorTextEqualTo(String value) {
            addCriterion("monitor_text =", value, "monitorText");
            return (Criteria) this;
        }

        public Criteria andMonitorTextNotEqualTo(String value) {
            addCriterion("monitor_text <>", value, "monitorText");
            return (Criteria) this;
        }

        public Criteria andMonitorTextGreaterThan(String value) {
            addCriterion("monitor_text >", value, "monitorText");
            return (Criteria) this;
        }

        public Criteria andMonitorTextGreaterThanOrEqualTo(String value) {
            addCriterion("monitor_text >=", value, "monitorText");
            return (Criteria) this;
        }

        public Criteria andMonitorTextLessThan(String value) {
            addCriterion("monitor_text <", value, "monitorText");
            return (Criteria) this;
        }

        public Criteria andMonitorTextLessThanOrEqualTo(String value) {
            addCriterion("monitor_text <=", value, "monitorText");
            return (Criteria) this;
        }

        public Criteria andMonitorTextLike(String value) {
            addCriterion("monitor_text like", value, "monitorText");
            return (Criteria) this;
        }

        public Criteria andMonitorTextNotLike(String value) {
            addCriterion("monitor_text not like", value, "monitorText");
            return (Criteria) this;
        }

        public Criteria andMonitorTextIn(List<String> values) {
            addCriterion("monitor_text in", values, "monitorText");
            return (Criteria) this;
        }

        public Criteria andMonitorTextNotIn(List<String> values) {
            addCriterion("monitor_text not in", values, "monitorText");
            return (Criteria) this;
        }

        public Criteria andMonitorTextBetween(String value1, String value2) {
            addCriterion("monitor_text between", value1, value2, "monitorText");
            return (Criteria) this;
        }

        public Criteria andMonitorTextNotBetween(String value1, String value2) {
            addCriterion("monitor_text not between", value1, value2, "monitorText");
            return (Criteria) this;
        }

        public Criteria andLockCodeIsNull() {
            addCriterion("lock_code is null");
            return (Criteria) this;
        }

        public Criteria andLockCodeIsNotNull() {
            addCriterion("lock_code is not null");
            return (Criteria) this;
        }

        public Criteria andLockCodeEqualTo(String value) {
            addCriterion("lock_code =", value, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeNotEqualTo(String value) {
            addCriterion("lock_code <>", value, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeGreaterThan(String value) {
            addCriterion("lock_code >", value, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeGreaterThanOrEqualTo(String value) {
            addCriterion("lock_code >=", value, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeLessThan(String value) {
            addCriterion("lock_code <", value, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeLessThanOrEqualTo(String value) {
            addCriterion("lock_code <=", value, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeLike(String value) {
            addCriterion("lock_code like", value, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeNotLike(String value) {
            addCriterion("lock_code not like", value, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeIn(List<String> values) {
            addCriterion("lock_code in", values, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeNotIn(List<String> values) {
            addCriterion("lock_code not in", values, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeBetween(String value1, String value2) {
            addCriterion("lock_code between", value1, value2, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeNotBetween(String value1, String value2) {
            addCriterion("lock_code not between", value1, value2, "lockCode");
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

        public Criteria andSuitCarModelIsNull() {
            addCriterion("suit_car_model is null");
            return (Criteria) this;
        }

        public Criteria andSuitCarModelIsNotNull() {
            addCriterion("suit_car_model is not null");
            return (Criteria) this;
        }

        public Criteria andSuitCarModelEqualTo(Short value) {
            addCriterion("suit_car_model =", value, "suitCarModel");
            return (Criteria) this;
        }

        public Criteria andSuitCarModelNotEqualTo(Short value) {
            addCriterion("suit_car_model <>", value, "suitCarModel");
            return (Criteria) this;
        }

        public Criteria andSuitCarModelGreaterThan(Short value) {
            addCriterion("suit_car_model >", value, "suitCarModel");
            return (Criteria) this;
        }

        public Criteria andSuitCarModelGreaterThanOrEqualTo(Short value) {
            addCriterion("suit_car_model >=", value, "suitCarModel");
            return (Criteria) this;
        }

        public Criteria andSuitCarModelLessThan(Short value) {
            addCriterion("suit_car_model <", value, "suitCarModel");
            return (Criteria) this;
        }

        public Criteria andSuitCarModelLessThanOrEqualTo(Short value) {
            addCriterion("suit_car_model <=", value, "suitCarModel");
            return (Criteria) this;
        }

        public Criteria andSuitCarModelIn(List<Short> values) {
            addCriterion("suit_car_model in", values, "suitCarModel");
            return (Criteria) this;
        }

        public Criteria andSuitCarModelNotIn(List<Short> values) {
            addCriterion("suit_car_model not in", values, "suitCarModel");
            return (Criteria) this;
        }

        public Criteria andSuitCarModelBetween(Short value1, Short value2) {
            addCriterion("suit_car_model between", value1, value2, "suitCarModel");
            return (Criteria) this;
        }

        public Criteria andSuitCarModelNotBetween(Short value1, Short value2) {
            addCriterion("suit_car_model not between", value1, value2, "suitCarModel");
            return (Criteria) this;
        }

        public Criteria andPropertyRightIsNull() {
            addCriterion("property_right is null");
            return (Criteria) this;
        }

        public Criteria andPropertyRightIsNotNull() {
            addCriterion("property_right is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyRightEqualTo(Short value) {
            addCriterion("property_right =", value, "propertyRight");
            return (Criteria) this;
        }

        public Criteria andPropertyRightNotEqualTo(Short value) {
            addCriterion("property_right <>", value, "propertyRight");
            return (Criteria) this;
        }

        public Criteria andPropertyRightGreaterThan(Short value) {
            addCriterion("property_right >", value, "propertyRight");
            return (Criteria) this;
        }

        public Criteria andPropertyRightGreaterThanOrEqualTo(Short value) {
            addCriterion("property_right >=", value, "propertyRight");
            return (Criteria) this;
        }

        public Criteria andPropertyRightLessThan(Short value) {
            addCriterion("property_right <", value, "propertyRight");
            return (Criteria) this;
        }

        public Criteria andPropertyRightLessThanOrEqualTo(Short value) {
            addCriterion("property_right <=", value, "propertyRight");
            return (Criteria) this;
        }

        public Criteria andPropertyRightIn(List<Short> values) {
            addCriterion("property_right in", values, "propertyRight");
            return (Criteria) this;
        }

        public Criteria andPropertyRightNotIn(List<Short> values) {
            addCriterion("property_right not in", values, "propertyRight");
            return (Criteria) this;
        }

        public Criteria andPropertyRightBetween(Short value1, Short value2) {
            addCriterion("property_right between", value1, value2, "propertyRight");
            return (Criteria) this;
        }

        public Criteria andPropertyRightNotBetween(Short value1, Short value2) {
            addCriterion("property_right not between", value1, value2, "propertyRight");
            return (Criteria) this;
        }

        public Criteria andCarportCenterXIsNull() {
            addCriterion("carport_center_x is null");
            return (Criteria) this;
        }

        public Criteria andCarportCenterXIsNotNull() {
            addCriterion("carport_center_x is not null");
            return (Criteria) this;
        }

        public Criteria andCarportCenterXEqualTo(BigDecimal value) {
            addCriterion("carport_center_x =", value, "carportCenterX");
            return (Criteria) this;
        }

        public Criteria andCarportCenterXNotEqualTo(BigDecimal value) {
            addCriterion("carport_center_x <>", value, "carportCenterX");
            return (Criteria) this;
        }

        public Criteria andCarportCenterXGreaterThan(BigDecimal value) {
            addCriterion("carport_center_x >", value, "carportCenterX");
            return (Criteria) this;
        }

        public Criteria andCarportCenterXGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("carport_center_x >=", value, "carportCenterX");
            return (Criteria) this;
        }

        public Criteria andCarportCenterXLessThan(BigDecimal value) {
            addCriterion("carport_center_x <", value, "carportCenterX");
            return (Criteria) this;
        }

        public Criteria andCarportCenterXLessThanOrEqualTo(BigDecimal value) {
            addCriterion("carport_center_x <=", value, "carportCenterX");
            return (Criteria) this;
        }

        public Criteria andCarportCenterXIn(List<BigDecimal> values) {
            addCriterion("carport_center_x in", values, "carportCenterX");
            return (Criteria) this;
        }

        public Criteria andCarportCenterXNotIn(List<BigDecimal> values) {
            addCriterion("carport_center_x not in", values, "carportCenterX");
            return (Criteria) this;
        }

        public Criteria andCarportCenterXBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("carport_center_x between", value1, value2, "carportCenterX");
            return (Criteria) this;
        }

        public Criteria andCarportCenterXNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("carport_center_x not between", value1, value2, "carportCenterX");
            return (Criteria) this;
        }

        public Criteria andCarportCenterYIsNull() {
            addCriterion("carport_center_y is null");
            return (Criteria) this;
        }

        public Criteria andCarportCenterYIsNotNull() {
            addCriterion("carport_center_y is not null");
            return (Criteria) this;
        }

        public Criteria andCarportCenterYEqualTo(BigDecimal value) {
            addCriterion("carport_center_y =", value, "carportCenterY");
            return (Criteria) this;
        }

        public Criteria andCarportCenterYNotEqualTo(BigDecimal value) {
            addCriterion("carport_center_y <>", value, "carportCenterY");
            return (Criteria) this;
        }

        public Criteria andCarportCenterYGreaterThan(BigDecimal value) {
            addCriterion("carport_center_y >", value, "carportCenterY");
            return (Criteria) this;
        }

        public Criteria andCarportCenterYGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("carport_center_y >=", value, "carportCenterY");
            return (Criteria) this;
        }

        public Criteria andCarportCenterYLessThan(BigDecimal value) {
            addCriterion("carport_center_y <", value, "carportCenterY");
            return (Criteria) this;
        }

        public Criteria andCarportCenterYLessThanOrEqualTo(BigDecimal value) {
            addCriterion("carport_center_y <=", value, "carportCenterY");
            return (Criteria) this;
        }

        public Criteria andCarportCenterYIn(List<BigDecimal> values) {
            addCriterion("carport_center_y in", values, "carportCenterY");
            return (Criteria) this;
        }

        public Criteria andCarportCenterYNotIn(List<BigDecimal> values) {
            addCriterion("carport_center_y not in", values, "carportCenterY");
            return (Criteria) this;
        }

        public Criteria andCarportCenterYBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("carport_center_y between", value1, value2, "carportCenterY");
            return (Criteria) this;
        }

        public Criteria andCarportCenterYNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("carport_center_y not between", value1, value2, "carportCenterY");
            return (Criteria) this;
        }

        public Criteria andCarportCenterZIsNull() {
            addCriterion("carport_center_z is null");
            return (Criteria) this;
        }

        public Criteria andCarportCenterZIsNotNull() {
            addCriterion("carport_center_z is not null");
            return (Criteria) this;
        }

        public Criteria andCarportCenterZEqualTo(BigDecimal value) {
            addCriterion("carport_center_z =", value, "carportCenterZ");
            return (Criteria) this;
        }

        public Criteria andCarportCenterZNotEqualTo(BigDecimal value) {
            addCriterion("carport_center_z <>", value, "carportCenterZ");
            return (Criteria) this;
        }

        public Criteria andCarportCenterZGreaterThan(BigDecimal value) {
            addCriterion("carport_center_z >", value, "carportCenterZ");
            return (Criteria) this;
        }

        public Criteria andCarportCenterZGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("carport_center_z >=", value, "carportCenterZ");
            return (Criteria) this;
        }

        public Criteria andCarportCenterZLessThan(BigDecimal value) {
            addCriterion("carport_center_z <", value, "carportCenterZ");
            return (Criteria) this;
        }

        public Criteria andCarportCenterZLessThanOrEqualTo(BigDecimal value) {
            addCriterion("carport_center_z <=", value, "carportCenterZ");
            return (Criteria) this;
        }

        public Criteria andCarportCenterZIn(List<BigDecimal> values) {
            addCriterion("carport_center_z in", values, "carportCenterZ");
            return (Criteria) this;
        }

        public Criteria andCarportCenterZNotIn(List<BigDecimal> values) {
            addCriterion("carport_center_z not in", values, "carportCenterZ");
            return (Criteria) this;
        }

        public Criteria andCarportCenterZBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("carport_center_z between", value1, value2, "carportCenterZ");
            return (Criteria) this;
        }

        public Criteria andCarportCenterZNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("carport_center_z not between", value1, value2, "carportCenterZ");
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

        public Criteria andEnableFlagIsNull() {
            addCriterion("enable_flag is null");
            return (Criteria) this;
        }

        public Criteria andEnableFlagIsNotNull() {
            addCriterion("enable_flag is not null");
            return (Criteria) this;
        }

        public Criteria andEnableFlagEqualTo(Short value) {
            addCriterion("enable_flag =", value, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagNotEqualTo(Short value) {
            addCriterion("enable_flag <>", value, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagGreaterThan(Short value) {
            addCriterion("enable_flag >", value, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("enable_flag >=", value, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagLessThan(Short value) {
            addCriterion("enable_flag <", value, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagLessThanOrEqualTo(Short value) {
            addCriterion("enable_flag <=", value, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagIn(List<Short> values) {
            addCriterion("enable_flag in", values, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagNotIn(List<Short> values) {
            addCriterion("enable_flag not in", values, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagBetween(Short value1, Short value2) {
            addCriterion("enable_flag between", value1, value2, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagNotBetween(Short value1, Short value2) {
            addCriterion("enable_flag not between", value1, value2, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andAreaTotalIsNull() {
            addCriterion("area_total is null");
            return (Criteria) this;
        }

        public Criteria andAreaTotalIsNotNull() {
            addCriterion("area_total is not null");
            return (Criteria) this;
        }

        public Criteria andAreaTotalEqualTo(Short value) {
            addCriterion("area_total =", value, "areaTotal");
            return (Criteria) this;
        }

        public Criteria andAreaTotalNotEqualTo(Short value) {
            addCriterion("area_total <>", value, "areaTotal");
            return (Criteria) this;
        }

        public Criteria andAreaTotalGreaterThan(Short value) {
            addCriterion("area_total >", value, "areaTotal");
            return (Criteria) this;
        }

        public Criteria andAreaTotalGreaterThanOrEqualTo(Short value) {
            addCriterion("area_total >=", value, "areaTotal");
            return (Criteria) this;
        }

        public Criteria andAreaTotalLessThan(Short value) {
            addCriterion("area_total <", value, "areaTotal");
            return (Criteria) this;
        }

        public Criteria andAreaTotalLessThanOrEqualTo(Short value) {
            addCriterion("area_total <=", value, "areaTotal");
            return (Criteria) this;
        }

        public Criteria andAreaTotalIn(List<Short> values) {
            addCriterion("area_total in", values, "areaTotal");
            return (Criteria) this;
        }

        public Criteria andAreaTotalNotIn(List<Short> values) {
            addCriterion("area_total not in", values, "areaTotal");
            return (Criteria) this;
        }

        public Criteria andAreaTotalBetween(Short value1, Short value2) {
            addCriterion("area_total between", value1, value2, "areaTotal");
            return (Criteria) this;
        }

        public Criteria andAreaTotalNotBetween(Short value1, Short value2) {
            addCriterion("area_total not between", value1, value2, "areaTotal");
            return (Criteria) this;
        }

        public Criteria andAreaIdleIsNull() {
            addCriterion("area_idle is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdleIsNotNull() {
            addCriterion("area_idle is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdleEqualTo(Short value) {
            addCriterion("area_idle =", value, "areaIdle");
            return (Criteria) this;
        }

        public Criteria andAreaIdleNotEqualTo(Short value) {
            addCriterion("area_idle <>", value, "areaIdle");
            return (Criteria) this;
        }

        public Criteria andAreaIdleGreaterThan(Short value) {
            addCriterion("area_idle >", value, "areaIdle");
            return (Criteria) this;
        }

        public Criteria andAreaIdleGreaterThanOrEqualTo(Short value) {
            addCriterion("area_idle >=", value, "areaIdle");
            return (Criteria) this;
        }

        public Criteria andAreaIdleLessThan(Short value) {
            addCriterion("area_idle <", value, "areaIdle");
            return (Criteria) this;
        }

        public Criteria andAreaIdleLessThanOrEqualTo(Short value) {
            addCriterion("area_idle <=", value, "areaIdle");
            return (Criteria) this;
        }

        public Criteria andAreaIdleIn(List<Short> values) {
            addCriterion("area_idle in", values, "areaIdle");
            return (Criteria) this;
        }

        public Criteria andAreaIdleNotIn(List<Short> values) {
            addCriterion("area_idle not in", values, "areaIdle");
            return (Criteria) this;
        }

        public Criteria andAreaIdleBetween(Short value1, Short value2) {
            addCriterion("area_idle between", value1, value2, "areaIdle");
            return (Criteria) this;
        }

        public Criteria andAreaIdleNotBetween(Short value1, Short value2) {
            addCriterion("area_idle not between", value1, value2, "areaIdle");
            return (Criteria) this;
        }

        public Criteria andParkIdIsNull() {
            addCriterion("park_id is null");
            return (Criteria) this;
        }

        public Criteria andParkIdIsNotNull() {
            addCriterion("park_id is not null");
            return (Criteria) this;
        }

        public Criteria andParkIdEqualTo(String value) {
            addCriterion("park_id =", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotEqualTo(String value) {
            addCriterion("park_id <>", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdGreaterThan(String value) {
            addCriterion("park_id >", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdGreaterThanOrEqualTo(String value) {
            addCriterion("park_id >=", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLessThan(String value) {
            addCriterion("park_id <", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLessThanOrEqualTo(String value) {
            addCriterion("park_id <=", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLike(String value) {
            addCriterion("park_id like", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotLike(String value) {
            addCriterion("park_id not like", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdIn(List<String> values) {
            addCriterion("park_id in", values, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotIn(List<String> values) {
            addCriterion("park_id not in", values, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdBetween(String value1, String value2) {
            addCriterion("park_id between", value1, value2, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotBetween(String value1, String value2) {
            addCriterion("park_id not between", value1, value2, "parkId");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("memo is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("memo is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("memo =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("memo <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("memo >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("memo >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("memo <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("memo <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("memo like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("memo not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("memo in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("memo not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("memo between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("memo not between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Short value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Short value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Short value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Short value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Short value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Short> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Short> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Short value1, Short value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Short value1, Short value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
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

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("org_id like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("org_id not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
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