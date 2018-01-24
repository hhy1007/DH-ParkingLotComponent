package com.eg.egsc.scp.parkinglotcomponent.mapper.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkSysConfigCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParkSysConfigCriteria() {
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

        public Criteria andConfigTypeIsNull() {
            addCriterion("config_type is null");
            return (Criteria) this;
        }

        public Criteria andConfigTypeIsNotNull() {
            addCriterion("config_type is not null");
            return (Criteria) this;
        }

        public Criteria andConfigTypeEqualTo(String value) {
            addCriterion("config_type =", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeNotEqualTo(String value) {
            addCriterion("config_type <>", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeGreaterThan(String value) {
            addCriterion("config_type >", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeGreaterThanOrEqualTo(String value) {
            addCriterion("config_type >=", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeLessThan(String value) {
            addCriterion("config_type <", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeLessThanOrEqualTo(String value) {
            addCriterion("config_type <=", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeLike(String value) {
            addCriterion("config_type like", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeNotLike(String value) {
            addCriterion("config_type not like", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeIn(List<String> values) {
            addCriterion("config_type in", values, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeNotIn(List<String> values) {
            addCriterion("config_type not in", values, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeBetween(String value1, String value2) {
            addCriterion("config_type between", value1, value2, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeNotBetween(String value1, String value2) {
            addCriterion("config_type not between", value1, value2, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigNameIsNull() {
            addCriterion("config_name is null");
            return (Criteria) this;
        }

        public Criteria andConfigNameIsNotNull() {
            addCriterion("config_name is not null");
            return (Criteria) this;
        }

        public Criteria andConfigNameEqualTo(String value) {
            addCriterion("config_name =", value, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigNameNotEqualTo(String value) {
            addCriterion("config_name <>", value, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigNameGreaterThan(String value) {
            addCriterion("config_name >", value, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigNameGreaterThanOrEqualTo(String value) {
            addCriterion("config_name >=", value, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigNameLessThan(String value) {
            addCriterion("config_name <", value, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigNameLessThanOrEqualTo(String value) {
            addCriterion("config_name <=", value, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigNameLike(String value) {
            addCriterion("config_name like", value, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigNameNotLike(String value) {
            addCriterion("config_name not like", value, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigNameIn(List<String> values) {
            addCriterion("config_name in", values, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigNameNotIn(List<String> values) {
            addCriterion("config_name not in", values, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigNameBetween(String value1, String value2) {
            addCriterion("config_name between", value1, value2, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigNameNotBetween(String value1, String value2) {
            addCriterion("config_name not between", value1, value2, "configName");
            return (Criteria) this;
        }

        public Criteria andConfigSeqIsNull() {
            addCriterion("config_seq is null");
            return (Criteria) this;
        }

        public Criteria andConfigSeqIsNotNull() {
            addCriterion("config_seq is not null");
            return (Criteria) this;
        }

        public Criteria andConfigSeqEqualTo(Short value) {
            addCriterion("config_seq =", value, "configSeq");
            return (Criteria) this;
        }

        public Criteria andConfigSeqNotEqualTo(Short value) {
            addCriterion("config_seq <>", value, "configSeq");
            return (Criteria) this;
        }

        public Criteria andConfigSeqGreaterThan(Short value) {
            addCriterion("config_seq >", value, "configSeq");
            return (Criteria) this;
        }

        public Criteria andConfigSeqGreaterThanOrEqualTo(Short value) {
            addCriterion("config_seq >=", value, "configSeq");
            return (Criteria) this;
        }

        public Criteria andConfigSeqLessThan(Short value) {
            addCriterion("config_seq <", value, "configSeq");
            return (Criteria) this;
        }

        public Criteria andConfigSeqLessThanOrEqualTo(Short value) {
            addCriterion("config_seq <=", value, "configSeq");
            return (Criteria) this;
        }

        public Criteria andConfigSeqIn(List<Short> values) {
            addCriterion("config_seq in", values, "configSeq");
            return (Criteria) this;
        }

        public Criteria andConfigSeqNotIn(List<Short> values) {
            addCriterion("config_seq not in", values, "configSeq");
            return (Criteria) this;
        }

        public Criteria andConfigSeqBetween(Short value1, Short value2) {
            addCriterion("config_seq between", value1, value2, "configSeq");
            return (Criteria) this;
        }

        public Criteria andConfigSeqNotBetween(Short value1, Short value2) {
            addCriterion("config_seq not between", value1, value2, "configSeq");
            return (Criteria) this;
        }

        public Criteria andConfigPar1IsNull() {
            addCriterion("config_par1 is null");
            return (Criteria) this;
        }

        public Criteria andConfigPar1IsNotNull() {
            addCriterion("config_par1 is not null");
            return (Criteria) this;
        }

        public Criteria andConfigPar1EqualTo(String value) {
            addCriterion("config_par1 =", value, "configPar1");
            return (Criteria) this;
        }

        public Criteria andConfigPar1NotEqualTo(String value) {
            addCriterion("config_par1 <>", value, "configPar1");
            return (Criteria) this;
        }

        public Criteria andConfigPar1GreaterThan(String value) {
            addCriterion("config_par1 >", value, "configPar1");
            return (Criteria) this;
        }

        public Criteria andConfigPar1GreaterThanOrEqualTo(String value) {
            addCriterion("config_par1 >=", value, "configPar1");
            return (Criteria) this;
        }

        public Criteria andConfigPar1LessThan(String value) {
            addCriterion("config_par1 <", value, "configPar1");
            return (Criteria) this;
        }

        public Criteria andConfigPar1LessThanOrEqualTo(String value) {
            addCriterion("config_par1 <=", value, "configPar1");
            return (Criteria) this;
        }

        public Criteria andConfigPar1Like(String value) {
            addCriterion("config_par1 like", value, "configPar1");
            return (Criteria) this;
        }

        public Criteria andConfigPar1NotLike(String value) {
            addCriterion("config_par1 not like", value, "configPar1");
            return (Criteria) this;
        }

        public Criteria andConfigPar1In(List<String> values) {
            addCriterion("config_par1 in", values, "configPar1");
            return (Criteria) this;
        }

        public Criteria andConfigPar1NotIn(List<String> values) {
            addCriterion("config_par1 not in", values, "configPar1");
            return (Criteria) this;
        }

        public Criteria andConfigPar1Between(String value1, String value2) {
            addCriterion("config_par1 between", value1, value2, "configPar1");
            return (Criteria) this;
        }

        public Criteria andConfigPar1NotBetween(String value1, String value2) {
            addCriterion("config_par1 not between", value1, value2, "configPar1");
            return (Criteria) this;
        }

        public Criteria andConfigPar2IsNull() {
            addCriterion("config_par2 is null");
            return (Criteria) this;
        }

        public Criteria andConfigPar2IsNotNull() {
            addCriterion("config_par2 is not null");
            return (Criteria) this;
        }

        public Criteria andConfigPar2EqualTo(String value) {
            addCriterion("config_par2 =", value, "configPar2");
            return (Criteria) this;
        }

        public Criteria andConfigPar2NotEqualTo(String value) {
            addCriterion("config_par2 <>", value, "configPar2");
            return (Criteria) this;
        }

        public Criteria andConfigPar2GreaterThan(String value) {
            addCriterion("config_par2 >", value, "configPar2");
            return (Criteria) this;
        }

        public Criteria andConfigPar2GreaterThanOrEqualTo(String value) {
            addCriterion("config_par2 >=", value, "configPar2");
            return (Criteria) this;
        }

        public Criteria andConfigPar2LessThan(String value) {
            addCriterion("config_par2 <", value, "configPar2");
            return (Criteria) this;
        }

        public Criteria andConfigPar2LessThanOrEqualTo(String value) {
            addCriterion("config_par2 <=", value, "configPar2");
            return (Criteria) this;
        }

        public Criteria andConfigPar2Like(String value) {
            addCriterion("config_par2 like", value, "configPar2");
            return (Criteria) this;
        }

        public Criteria andConfigPar2NotLike(String value) {
            addCriterion("config_par2 not like", value, "configPar2");
            return (Criteria) this;
        }

        public Criteria andConfigPar2In(List<String> values) {
            addCriterion("config_par2 in", values, "configPar2");
            return (Criteria) this;
        }

        public Criteria andConfigPar2NotIn(List<String> values) {
            addCriterion("config_par2 not in", values, "configPar2");
            return (Criteria) this;
        }

        public Criteria andConfigPar2Between(String value1, String value2) {
            addCriterion("config_par2 between", value1, value2, "configPar2");
            return (Criteria) this;
        }

        public Criteria andConfigPar2NotBetween(String value1, String value2) {
            addCriterion("config_par2 not between", value1, value2, "configPar2");
            return (Criteria) this;
        }

        public Criteria andConfigPar3IsNull() {
            addCriterion("config_par3 is null");
            return (Criteria) this;
        }

        public Criteria andConfigPar3IsNotNull() {
            addCriterion("config_par3 is not null");
            return (Criteria) this;
        }

        public Criteria andConfigPar3EqualTo(String value) {
            addCriterion("config_par3 =", value, "configPar3");
            return (Criteria) this;
        }

        public Criteria andConfigPar3NotEqualTo(String value) {
            addCriterion("config_par3 <>", value, "configPar3");
            return (Criteria) this;
        }

        public Criteria andConfigPar3GreaterThan(String value) {
            addCriterion("config_par3 >", value, "configPar3");
            return (Criteria) this;
        }

        public Criteria andConfigPar3GreaterThanOrEqualTo(String value) {
            addCriterion("config_par3 >=", value, "configPar3");
            return (Criteria) this;
        }

        public Criteria andConfigPar3LessThan(String value) {
            addCriterion("config_par3 <", value, "configPar3");
            return (Criteria) this;
        }

        public Criteria andConfigPar3LessThanOrEqualTo(String value) {
            addCriterion("config_par3 <=", value, "configPar3");
            return (Criteria) this;
        }

        public Criteria andConfigPar3Like(String value) {
            addCriterion("config_par3 like", value, "configPar3");
            return (Criteria) this;
        }

        public Criteria andConfigPar3NotLike(String value) {
            addCriterion("config_par3 not like", value, "configPar3");
            return (Criteria) this;
        }

        public Criteria andConfigPar3In(List<String> values) {
            addCriterion("config_par3 in", values, "configPar3");
            return (Criteria) this;
        }

        public Criteria andConfigPar3NotIn(List<String> values) {
            addCriterion("config_par3 not in", values, "configPar3");
            return (Criteria) this;
        }

        public Criteria andConfigPar3Between(String value1, String value2) {
            addCriterion("config_par3 between", value1, value2, "configPar3");
            return (Criteria) this;
        }

        public Criteria andConfigPar3NotBetween(String value1, String value2) {
            addCriterion("config_par3 not between", value1, value2, "configPar3");
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