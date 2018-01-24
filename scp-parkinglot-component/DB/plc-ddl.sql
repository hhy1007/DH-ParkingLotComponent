/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     2018/1/23 16:06:00                           */
/*==============================================================*/

/*==============================================================*/
/* Table: park_access_cur                                       */
/*==============================================================*/
create table park_access_cur (
   uuid                 VARCHAR(32)          not null,
   car_num              VARCHAR(16)          not null,
   owner_id             VARCHAR(32)          null,
   park_code            VARCHAR(32)          null,
   card_number          VARCHAR(32)          null,
   carport_type         SMALLINT             not null,
   park_package_id      VARCHAR(32)          null,
   in_camera_code       VARCHAR(32)          null,
   in_channel_id        VARCHAR(32)          null,
   in_img_url           VARCHAR(256)         null,
   in_num_url           VARCHAR(256)         null,
   in_memo              VARCHAR(512)         null,
   enter_mode           SMALLINT             null,
   need_pay             SMALLINT             null,
   payed_money          INTEGER              null,
   car_type             SMALLINT             null,
   car_mode             VARCHAR(16)          null default '0',
   court_uuid           VARCHAR(32)          null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_ACCESS_CUR primary key (uuid)
);

comment on table park_access_cur is
'车辆在场记录表';

comment on column park_access_cur.uuid is
'ID';

comment on column park_access_cur.car_num is
'车牌号码';

comment on column park_access_cur.owner_id is
'车主ID';

comment on column park_access_cur.park_code is
'停车场编号';

comment on column park_access_cur.card_number is
'卡号';

comment on column park_access_cur.carport_type is
'车位授权类型：0-临停，1-月租，2-产权';

comment on column park_access_cur.park_package_id is
'使用套餐ID';

comment on column park_access_cur.in_camera_code is
'入场抓拍相机编号';

comment on column park_access_cur.in_channel_id is
'入场通道ID';

comment on column park_access_cur.in_img_url is
'入场车辆图片';

comment on column park_access_cur.in_num_url is
'入场车牌图片';

comment on column park_access_cur.in_memo is
'进场备注';

comment on column park_access_cur.enter_mode is
'入场方式:0-刷卡，1-自动识别，2-手动录入，3-预约停车';

comment on column park_access_cur.need_pay is
'是否需收费：0-否，1-是';

comment on column park_access_cur.payed_money is
'已缴费用';

comment on column park_access_cur.car_type is
'汽车类型（0-普通车，1-特殊车，2-临停）';

comment on column park_access_cur.car_mode is
'车型（0-小车，1-大车，2-超大车，3-摩托车）';

comment on column park_access_cur.court_uuid is
'小区UUID';

comment on column park_access_cur.create_time is
'创建时间/入场时间';

comment on column park_access_cur.update_time is
'更新时间/最后缴费时间';

comment on column park_access_cur.create_user is
'创建人';

comment on column park_access_cur.update_user is
'修订人';

/*==============================================================*/
/* Index: idx_park_access_cur_car                               */
/*==============================================================*/
create  index idx_park_access_cur_car on park_access_cur using BTREE (
car_num
);

/*==============================================================*/
/* Index: idx_park_access_cur_card                              */
/*==============================================================*/
create  index idx_park_access_cur_card on park_access_cur using BTREE (
card_number
);

/*==============================================================*/
/* Index: idx_park_access_cur_time                              */
/*==============================================================*/
create  index idx_park_access_cur_time on park_access_cur using BTREE (
create_time
);

/*==============================================================*/
/* Table: park_access_his                                       */
/*==============================================================*/
create table park_access_his (
   uuid                 varchar(32)          not null,
   car_num              VARCHAR(16)          null,
   owner_id             VARCHAR(32)          null,
   park_code            VARCHAR(32)          null,
   card_number          VARCHAR(16)          null,
   carport_type         SMALLINT             null,
   package_id           VARCHAR(32)          null,
   car_mode             VARCHAR(16)          null,
   in_channel_id        VARCHAR(32)          null,
   in_camera_code       VARCHAR(32)          null,
   in_sluice_code       VARCHAR(32)          null,
   in_img_url           VARCHAR(256)         null,
   in_memo              VARCHAR(512)         null,
   out_car_num          VARCHAR(16)          null,
   out_channel_id       VARCHAR(32)          null,
   out_camera_code      VARCHAR(32)          null,
   out_sluice_code      VARCHAR(32)          null,
   out_img_url          VARCHAR(256)         null,
   out_memo             VARCHAR(512)         null,
   enter_mode           SMALLINT             null,
   payed_money          INTEGER              null,
   last_payed_time      TIMESTAMP            null,
   car_type             SMALLINT             null,
   car_status           SMALLINT             null,
   force_operator       VARCHAR(32)          null,
   court_uuid           VARCHAR(32)          null,
   create_time          TIMESTAMP            not null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_ACCESS_HIS primary key (uuid)
);

comment on table park_access_his is
'车辆进出历史表';

comment on column park_access_his.uuid is
'ID';

comment on column park_access_his.car_num is
'车牌号码';

comment on column park_access_his.owner_id is
'车主ID';

comment on column park_access_his.park_code is
'停车场编号';

comment on column park_access_his.card_number is
'卡号';

comment on column park_access_his.carport_type is
'车位类型：1-月租，2-产权，0-临停';

comment on column park_access_his.package_id is
'使用套餐ID';

comment on column park_access_his.car_mode is
'车型（0-小车，1-大车，2-超大车，3-摩托车）';

comment on column park_access_his.in_channel_id is
'入场通道ID';

comment on column park_access_his.in_camera_code is
'入场抓拍相机编号';

comment on column park_access_his.in_sluice_code is
'入场道闸编号';

comment on column park_access_his.in_img_url is
'入场车辆图片';

comment on column park_access_his.in_memo is
'进场备注';

comment on column park_access_his.out_car_num is
'出场车牌号码';

comment on column park_access_his.out_channel_id is
'出场通道ID';

comment on column park_access_his.out_camera_code is
'出场抓拍相机编号';

comment on column park_access_his.out_sluice_code is
'出场道闸编号';

comment on column park_access_his.out_img_url is
'出场车辆图片';

comment on column park_access_his.out_memo is
'出场备注';

comment on column park_access_his.enter_mode is
'入场方式:0-刷卡，1-自动识别,2-手动录入，3-预约停车';

comment on column park_access_his.payed_money is
'已缴费用';

comment on column park_access_his.last_payed_time is
'最后缴费时间';

comment on column park_access_his.car_type is
'汽车类型（0-普通车，1-特殊车，2-临停）';

comment on column park_access_his.car_status is
'车辆停车状态(0-进入，1-离开，2-只有出车)';

comment on column park_access_his.force_operator is
'强制出场操作人员ID';

comment on column park_access_his.court_uuid is
'小区UUID';

comment on column park_access_his.create_time is
'创建时间/入场时间';

comment on column park_access_his.update_time is
'更新时间/出场时间';

comment on column park_access_his.create_user is
'创建人';

comment on column park_access_his.update_user is
'修订人';

/*==============================================================*/
/* Index: idx_park_access_his_time                              */
/*==============================================================*/
create  index idx_park_access_his_time on park_access_his using BTREE (
create_time
);

/*==============================================================*/
/* Table: park_alarm_abnormal                                   */
/*==============================================================*/
create table park_alarm_abnormal (
   uuid                 VARCHAR(32)          not null,
   carportCode          VARCHAR(32)          null,
   car_num              VARCHAR(16)          null,
   in_time              TIMESTAMP            null,
   fee_amount           INTEGER              null,
   dispatch_state       SMALLINT             not null,
   dispatch_user        VARCHAR(32)          null,
   alarm_state          SMALLINT             not null,
   relieve_user         VARCHAR(32)          null,
   court_uuid           VARCHAR(32)          null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_ALARM_ABNORMAL primary key (uuid)
);

comment on table park_alarm_abnormal is
'临停车长时间未出场告警';

comment on column park_alarm_abnormal.uuid is
'ID';

comment on column park_alarm_abnormal.carportCode is
'车位编号';

comment on column park_alarm_abnormal.car_num is
'车牌';

comment on column park_alarm_abnormal.in_time is
'入场时间';

comment on column park_alarm_abnormal.fee_amount is
'费用';

comment on column park_alarm_abnormal.dispatch_state is
'派遣保安状态:0-未派遣,1-已派遣';

comment on column park_alarm_abnormal.dispatch_user is
'派遣保安id';

comment on column park_alarm_abnormal.alarm_state is
'预警状态:0无预警，1有预警';

comment on column park_alarm_abnormal.relieve_user is
'解除预警人';

comment on column park_alarm_abnormal.court_uuid is
'小区UUID';

comment on column park_alarm_abnormal.create_time is
'创建时间/预警时间';

comment on column park_alarm_abnormal.update_time is
'更新时间/解除预警时间';

comment on column park_alarm_abnormal.create_user is
'创建人';

comment on column park_alarm_abnormal.update_user is
'修订人';

/*==============================================================*/
/* Index: idx_park_alarm_abnormal_at                            */
/*==============================================================*/
create  index idx_park_alarm_abnormal_at on park_alarm_abnormal using BTREE (
create_time
);

/*==============================================================*/
/* Table: park_alarm_arrear                                     */
/*==============================================================*/
create table park_alarm_arrear (
   uuid                 VARCHAR(32)          not null,
   carport_code         VARCHAR(32)          null,
   car_num              VARCHAR(16)          null,
   owner_id             VARCHAR(32)          null,
   owner_name           VARCHAR(32)          null,
   owner_phone          VARCHAR(16)          null,
   carport_type         SMALLINT             null,
   fee_amount           INTEGER              null,
   charge_state         SMALLINT             not null,
   arrear_amount        INTEGER              null,
   alarm_state          SMALLINT             not null,
   relieve_user         VARCHAR(32)          null,
   court_uuid           VARCHAR(32)          null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_ALARM_ARREAR primary key (uuid)
);

comment on table park_alarm_arrear is
'车位即将到期预警';

comment on column park_alarm_arrear.uuid is
'ID';

comment on column park_alarm_arrear.carport_code is
'车位号';

comment on column park_alarm_arrear.car_num is
'车牌';

comment on column park_alarm_arrear.owner_id is
'车主ID';

comment on column park_alarm_arrear.owner_name is
'车主姓名';

comment on column park_alarm_arrear.owner_phone is
'车主电话';

comment on column park_alarm_arrear.carport_type is
'车位类型：0-临停，1-月保，2-产权';

comment on column park_alarm_arrear.fee_amount is
'费用（元）';

comment on column park_alarm_arrear.charge_state is
'缴费状态：0即将到期，1欠费，2已缴费';

comment on column park_alarm_arrear.arrear_amount is
'费用（元）';

comment on column park_alarm_arrear.alarm_state is
'预警状态：0无预警，1有预警';

comment on column park_alarm_arrear.relieve_user is
'解除人';

comment on column park_alarm_arrear.court_uuid is
'小区UUID';

comment on column park_alarm_arrear.create_time is
'创建时间/预警时间';

comment on column park_alarm_arrear.update_time is
'更新时间/解除时间';

comment on column park_alarm_arrear.create_user is
'创建人';

comment on column park_alarm_arrear.update_user is
'修订人';

/*==============================================================*/
/* Index: idx_park_alarm_arrear_at                              */
/*==============================================================*/
create  index idx_park_alarm_arrear_at on park_alarm_arrear using BTREE (
create_time
);

/*==============================================================*/
/* Table: park_alarm_occupy                                     */
/*==============================================================*/
create table park_alarm_occupy (
   uuid                 VARCHAR(32)          not null,
   carport_code         VARCHAR(50)          null,
   car_num_fixed        VARCHAR(16)          null,
   car_num_cur          VARCHAR(16)          null,
   owner_id             VARCHAR(32)          null,
   owner_name           VARCHAR(32)          null,
   owner_phone          VARCHAR(16)          null,
   dispatch_state       SMALLINT             not null,
   dispatch_user        VARCHAR(32)          null,
   alarm_state          SMALLINT             not null,
   relieve_user         VARCHAR(32)          null,
   court_uuid           VARCHAR(32)          null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_ALARM_OCCUPY primary key (uuid)
);

comment on table park_alarm_occupy is
'车位占用预警表';

comment on column park_alarm_occupy.uuid is
'ID';

comment on column park_alarm_occupy.carport_code is
'车位编号';

comment on column park_alarm_occupy.car_num_fixed is
'固定车牌';

comment on column park_alarm_occupy.car_num_cur is
'现停车牌';

comment on column park_alarm_occupy.owner_id is
'业主id';

comment on column park_alarm_occupy.owner_name is
'业主姓名';

comment on column park_alarm_occupy.owner_phone is
'业主电话';

comment on column park_alarm_occupy.dispatch_state is
'保安派遣状态:0-未派遣,1-已派遣';

comment on column park_alarm_occupy.dispatch_user is
'派遣保安ID';

comment on column park_alarm_occupy.alarm_state is
'预警状态:0无预警，1有预警';

comment on column park_alarm_occupy.relieve_user is
'解除人';

comment on column park_alarm_occupy.court_uuid is
'小区UUID';

comment on column park_alarm_occupy.create_time is
'创建时间/预警时间';

comment on column park_alarm_occupy.update_time is
'更新时间/解除预警时间';

comment on column park_alarm_occupy.create_user is
'创建人';

comment on column park_alarm_occupy.update_user is
'修订人';

/*==============================================================*/
/* Index: idx_park_alarm_occupy_at                              */
/*==============================================================*/
create  index idx_park_alarm_occupy_at on park_alarm_occupy using BTREE (
create_time
);

/*==============================================================*/
/* Table: park_auth_package                                     */
/*==============================================================*/
create table park_auth_package (
   uuid                 VARCHAR(32)          not null,
   owner_id             VARCHAR(32)          not null,
   carport_code         VARCHAR(32)          null,
   card_number          VARCHAR(16)          null,
   park_rule_id         VARCHAR(32)          null,
   valid_start_time     TIMESTAMP            null,
   valid_end_time       TIMESTAMP            null,
   carport_type         SMALLINT             not null,
   state                VARCHAR(16)          null default 'enable',
   memo                 VARCHAR(256)         null,
   delete_flag          SMALLINT             null default '0',
   court_uuid           VARCHAR(32)          null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_AUTH_PACKAGE primary key (uuid)
);

comment on table park_auth_package is
'授权套餐表';

comment on column park_auth_package.uuid is
'ID';

comment on column park_auth_package.owner_id is
'车主ID';

comment on column park_auth_package.carport_code is
'车位编号';

comment on column park_auth_package.card_number is
'卡号';

comment on column park_auth_package.park_rule_id is
'进出规则ID';

comment on column park_auth_package.valid_start_time is
'有效期开始时间';

comment on column park_auth_package.valid_end_time is
'有效期结束时间';

comment on column park_auth_package.carport_type is
'车位类型：1-月租，2-产权/固定，0-临停';

comment on column park_auth_package.state is
'授权状态:enable-正常状态;frozen-冻结;disable-不可用';

comment on column park_auth_package.memo is
'备注';

comment on column park_auth_package.delete_flag is
'删除标记：0-正常,1-删除';

comment on column park_auth_package.court_uuid is
'小区UUID';

comment on column park_auth_package.create_time is
'创建时间';

comment on column park_auth_package.update_time is
'更新时间';

comment on column park_auth_package.create_user is
'创建人ID';

comment on column park_auth_package.update_user is
'更新人ID';

/*==============================================================*/
/* Index: idx_park_auth_owner_id                                */
/*==============================================================*/
create  index idx_park_auth_owner_id on park_auth_package using BTREE (
owner_id
);

/*==============================================================*/
/* Index: idx_park_auth_code                                    */
/*==============================================================*/
create  index idx_park_auth_code on park_auth_package using BTREE (
carport_code
);

/*==============================================================*/
/* Table: park_car                                              */
/*==============================================================*/
create table park_car (
   uuid                 VARCHAR(32)          not null,
   car_num              VARCHAR(16)          not null,
   car_code             VARCHAR(32)          null,
   car_num_color        VARCHAR(16)          null,
   car_type             SMALLINT             null,
   valid_start_time     TIMESTAMP            null,
   valid_end_time       TIMESTAMP            null,
   car_mode             VARCHAR(16)          null,
   car_brand            VARCHAR(16)          null,
   car_color            VARCHAR(16)          null,
   car_pic              VARCHAR(256)         null,
   owner_id             VARCHAR(32)          null,
   house_no             VARCHAR(64)          null,
   list_type            SMALLINT             null,
   car_num_type         SMALLINT             null,
   memo                 VARCHAR(256)         null,
   delete_flag          SMALLINT             null default '0',
   court_uuid           VARCHAR(32)          null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_CAR primary key (uuid)
);

comment on table park_car is
'车辆基本信息表';

comment on column park_car.uuid is
'ID';

comment on column park_car.car_num is
'车牌号码';

comment on column park_car.car_code is
'车辆编号';

comment on column park_car.car_num_color is
'车牌颜色';

comment on column park_car.car_type is
'汽车类型（0-普通车，1-特殊车）';

comment on column park_car.valid_start_time is
'特殊车开始时间';

comment on column park_car.valid_end_time is
'特殊车结束时间';

comment on column park_car.car_mode is
'车型（0-小车，1-大车，2-超大车，3-摩托车）';

comment on column park_car.car_brand is
'汽车品牌';

comment on column park_car.car_color is
'汽车颜色';

comment on column park_car.car_pic is
'车辆图片';

comment on column park_car.owner_id is
'业主ID';

comment on column park_car.house_no is
'房号';

comment on column park_car.list_type is
'黑白名单（0-普通车，1-白名单，2-黑名单）';

comment on column park_car.car_num_type is
'车牌类型（0-普通车牌， 1-电子车牌）';

comment on column park_car.memo is
'备注';

comment on column park_car.delete_flag is
'删除标记：0-正常,1-删除';

comment on column park_car.court_uuid is
'小区UUID';

comment on column park_car.create_time is
'创建时间';

comment on column park_car.update_time is
'更新时间';

comment on column park_car.create_user is
'创建人ID';

comment on column park_car.update_user is
'更新人ID';

/*==============================================================*/
/* Index: idx_park_car_car_num                                  */
/*==============================================================*/
create  index idx_park_car_car_num on park_car using BTREE (
car_num
);

/*==============================================================*/
/* Index: idx_park_car_create_time                              */
/*==============================================================*/
create  index idx_park_car_create_time on park_car using BTREE (
create_time
);

/*==============================================================*/
/* Table: park_car_capture                                      */
/*==============================================================*/
create table park_car_capture (
   uuid                 VARCHAR(32)          not null,
   car_num              VARCHAR(16)          null,
   channel_id           VARCHAR(32)          null,
   camera_code          VARCHAR(32)          null,
   camera_name          VARCHAR(64)          null,
   direct               SMALLINT             null,
   car_num_color        VARCHAR(16)          null,
   car_mode             VARCHAR(16)          null,
   car_brand            VARCHAR(16)          null,
   img_url              VARCHAR(256)         null,
   num_url              VARCHAR(256)         null,
   court_uuid           VARCHAR(32)          null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_CAR_CAPTURE primary key (uuid)
);

comment on table park_car_capture is
'相机抓拍记录表';

comment on column park_car_capture.uuid is
'ID';

comment on column park_car_capture.car_num is
'车牌号码';

comment on column park_car_capture.channel_id is
'通道ID';

comment on column park_car_capture.camera_code is
'   入场抓拍相机编号';

comment on column park_car_capture.camera_name is
'入场抓拍相机名称';

comment on column park_car_capture.direct is
'方向：0-进，1-出';

comment on column park_car_capture.car_num_color is
'车牌颜色';

comment on column park_car_capture.car_mode is
'车型（0-小车，1-大车，2-超大车，3-摩托车）';

comment on column park_car_capture.car_brand is
'车辆商标';

comment on column park_car_capture.img_url is
'车辆图片';

comment on column park_car_capture.num_url is
'车牌图片';

comment on column park_car_capture.court_uuid is
'小区UUID';

comment on column park_car_capture.create_time is
'创建时间/抓拍时间';

comment on column park_car_capture.update_time is
'更新时间';

comment on column park_car_capture.create_user is
'创建人';

comment on column park_car_capture.update_user is
'修订人';

/*==============================================================*/
/* Index: idx_park_car_capture_time                             */
/*==============================================================*/
create  index idx_park_car_capture_time on park_car_capture using BTREE (
create_time
);

/*==============================================================*/
/* Table: park_car_dev_rel                                      */
/*==============================================================*/
create table park_car_dev_rel (
   uuid                 VARCHAR(32)          not null,
   car_num              VARCHAR(16)          null,
   dev_code             VARCHAR(32)          null,
   dev_name             VARCHAR(64)          null,
   park_code            VARCHAR(32)          null,
   list_type            SMALLINT             null,
   task_type            SMALLINT             null,
   opt_type             VARCHAR(16)          null,
   status               VARCHAR(16)          null,
   court_uuid           VARCHAR(32)          null,
   start_time           TIMESTAMP            null,
   end_time             TIMESTAMP            null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_CAR_DEV_REL primary key (uuid)
);

comment on table park_car_dev_rel is
'车牌/卡片下发设备表';

comment on column park_car_dev_rel.uuid is
'id';

comment on column park_car_dev_rel.car_num is
'车牌号码';

comment on column park_car_dev_rel.dev_code is
'设备编号';

comment on column park_car_dev_rel.dev_name is
'设备名称';

comment on column park_car_dev_rel.park_code is
'停车场编号';

comment on column park_car_dev_rel.list_type is
'黑白名单类型（0-普通车，1-白名单，2-黑名单）';

comment on column park_car_dev_rel.task_type is
'任务类型：0-车牌下发，1-卡片下发';

comment on column park_car_dev_rel.opt_type is
'操作类型：ADD增DEL删UPDATE改';

comment on column park_car_dev_rel.status is
'下发状态:SEND-下发中，SUCCESS-下发成功；FAILED-下发失败；OFFLINE-设备不在线';

comment on column park_car_dev_rel.court_uuid is
'小区UUID';

comment on column park_car_dev_rel.start_time is
'有效期开始时间';

comment on column park_car_dev_rel.end_time is
'有效期结束时间';

comment on column park_car_dev_rel.create_time is
'创建时间';

comment on column park_car_dev_rel.update_time is
'更新时间';

comment on column park_car_dev_rel.create_user is
'创建人';

comment on column park_car_dev_rel.update_user is
'更新人';

/*==============================================================*/
/* Table: park_carport                                          */
/*==============================================================*/
create table park_carport (
   uuid                 VARCHAR(32)          not null,
   carport_code         VARCHAR(32)          not null,
   carport_shape        VARCHAR(256)         null,
   carport_allocation   SMALLINT             not null,
   detector_code        VARCHAR(32)          null,
   monitor_code         VARCHAR(32)          null,
   monitor_mode         SMALLINT             null,
   monitor_text         VARCHAR(256)         null,
   lock_code            VARCHAR(32)          null,
   map_id               VARCHAR(32)          null,
   suit_car_model       SMALLINT             not null,
   property_right       SMALLINT             not null,
   carport_center_x     DECIMAL(9,6)         null,
   carport_center_y     DECIMAL(9,6)         null,
   carport_center_z     DECIMAL(9,6)         null,
   carport_type         SMALLINT             null,
   org_id               VARCHAR(32)          null,
   enable_flag          SMALLINT             null default '1',
   area_total           SMALLINT             null,
   area_idle            SMALLINT             null,
   park_id              VARCHAR(32)          null,
   memo                 VARCHAR(256)         null,
   delete_flag          SMALLINT             null default '0',
   court_uuid           VARCHAR(32)          null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_CARPORT primary key (uuid)
);

comment on table park_carport is
'车位信息表';

comment on column park_carport.uuid is
'ID';

comment on column park_carport.carport_code is
'车位编号';

comment on column park_carport.carport_shape is
'车位形状';

comment on column park_carport.carport_allocation is
'是否分配:  0-未分配；1-已分配';

comment on column park_carport.detector_code is
'车位探测器编号';

comment on column park_carport.monitor_code is
'车牌显示器编号';

comment on column park_carport.monitor_mode is
'车牌显示器模式：0-车牌，1-自定义';

comment on column park_carport.monitor_text is
'车牌显示器自定义内容';

comment on column park_carport.lock_code is
'车位锁编号';

comment on column park_carport.map_id is
'车位图层';

comment on column park_carport.suit_car_model is
'适用车型（0-小车位，1-大车位，2-超大车位）';

comment on column park_carport.property_right is
'车位产权（0-公共产权，1-个人产权）';

comment on column park_carport.carport_center_x is
'坐标X';

comment on column park_carport.carport_center_y is
'坐标Y';

comment on column park_carport.carport_center_z is
'坐标Z';

comment on column park_carport.carport_type is
'车位类型：1-月租，2-产权/固定，0-临停';

comment on column park_carport.org_id is
'所属组织';

comment on column park_carport.enable_flag is
'是否可用：1-正常，0-不可用';

comment on column park_carport.area_total is
'停车区域总车位数';

comment on column park_carport.area_idle is
'区域空余车位数';

comment on column park_carport.park_id is
'所属的停车场ID';

comment on column park_carport.memo is
'备注';

comment on column park_carport.delete_flag is
'删除标记：0-正常,1-删除';

comment on column park_carport.court_uuid is
'小区UUID';

comment on column park_carport.create_time is
'创建时间';

comment on column park_carport.update_time is
'更新时间';

comment on column park_carport.create_user is
'创建人ID';

comment on column park_carport.update_user is
'更新人ID';

/*==============================================================*/
/* Index: idx_park_carport_code                                 */
/*==============================================================*/
create  index idx_park_carport_code on park_carport using BTREE (
carport_code
);

/*==============================================================*/
/* Table: park_channel                                          */
/*==============================================================*/
create table park_channel (
   uuid                 VARCHAR(32)          not null,
   name                 VARCHAR(64)          null,
   park_code            VARCHAR(32)          null,
   type                 SMALLINT             null,
   direct               SMALLINT             null,
   ip                   VARCHAR(64)          null,
   delete_flag          SMALLINT             null default '0',
   court_uuid           VARCHAR(32)          null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_CHANNEL primary key (uuid)
);

comment on table park_channel is
'进出口通道表';

comment on column park_channel.uuid is
'ID';

comment on column park_channel.name is
'车道名称';

comment on column park_channel.park_code is
'停车场编号';

comment on column park_channel.type is
'通道类型';

comment on column park_channel.direct is
'车道方向:0-进，1-出';

comment on column park_channel.ip is
'绑定ip';

comment on column park_channel.delete_flag is
'删除标记：0-正常,1-删除';

comment on column park_channel.court_uuid is
'小区UUID';

comment on column park_channel.create_time is
'创建时间';

comment on column park_channel.update_time is
'更新时间';

comment on column park_channel.create_user is
'创建人ID';

comment on column park_channel.update_user is
'更新人ID';

/*==============================================================*/
/* Table: park_channel_rel                                      */
/*==============================================================*/
create table park_channel_rel (
   uuid                 VARCHAR(32)          not null,
   channel_id           VARCHAR(32)          not null,
   dev_code             VARCHAR(32)          not null,
   dev_type             SMALLINT             null,
   control_type         SMALLINT             null default '0',
   court_uuid           VARCHAR(32)          null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_CHANNEL_REL primary key (uuid)
);

comment on table park_channel_rel is
'通道绑定设备表';

comment on column park_channel_rel.uuid is
'ID';

comment on column park_channel_rel.channel_id is
'通道ID';

comment on column park_channel_rel.dev_code is
'设备编号';

comment on column park_channel_rel.dev_type is
'设备类型：0-道闸，1-出入口相机，2-led';

comment on column park_channel_rel.control_type is
'主辅类型：0-主，1-辅.';

comment on column park_channel_rel.court_uuid is
'小区UUID';

comment on column park_channel_rel.create_time is
'创建时间';

comment on column park_channel_rel.update_time is
'更新时间';

comment on column park_channel_rel.create_user is
'创建人ID';

comment on column park_channel_rel.update_user is
'更新人ID';

/*==============================================================*/
/* Index: idx_park_channel_rel_chn_id                           */
/*==============================================================*/
create  index idx_park_channel_rel_chn_id on park_channel_rel using BTREE (
channel_id
);

/*==============================================================*/
/* Index: idx_park_channel_rel_dev_code                         */
/*==============================================================*/
create  index idx_park_channel_rel_dev_code on park_channel_rel using BTREE (
dev_code
);

/*==============================================================*/
/* Table: park_charge                                           */
/*==============================================================*/
create table park_charge (
   uuid                 VARCHAR(32)          not null,
   owner_id             VARCHAR(32)          not null,
   carport_code         VARCHAR(32)          not null,
   package_id           VARCHAR(32)          null,
   original_start_time  TIMESTAMP            null,
   original_end_time    TIMESTAMP            null,
   charge_number        SMALLINT             null,
   start_time           TIMESTAMP            null,
   end_time             TIMESTAMP            null,
   money                INTEGER              null,
   charge_type          SMALLINT             null,
   memo                 VARCHAR(256)         null,
   court_uuid           VARCHAR(32)          null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_CHARGE primary key (uuid)
);

comment on table park_charge is
'缴费记录表';

comment on column park_charge.uuid is
'ID';

comment on column park_charge.owner_id is
'车主ID';

comment on column park_charge.carport_code is
'车位编号';

comment on column park_charge.package_id is
'授权套餐ID';

comment on column park_charge.original_start_time is
'原开始时间';

comment on column park_charge.original_end_time is
'原结束时间';

comment on column park_charge.charge_number is
'充值月数';

comment on column park_charge.start_time is
'开始时间';

comment on column park_charge.end_time is
'结束时间';

comment on column park_charge.money is
'缴费金额（分）';

comment on column park_charge.charge_type is
'缴费方式(0-现金，1-微信，2-支付宝，3-APP微信，4-APP支付宝)';

comment on column park_charge.memo is
'备注';

comment on column park_charge.court_uuid is
'小区UUID';

comment on column park_charge.create_time is
'创建时间';

comment on column park_charge.update_time is
'更新时间';

comment on column park_charge.create_user is
'创建人ID';

comment on column park_charge.update_user is
'更新人ID';

/*==============================================================*/
/* Index: idx_park_charge_owner_id                              */
/*==============================================================*/
create  index idx_park_charge_owner_id on park_charge using BTREE (
owner_id
);

/*==============================================================*/
/* Index: idx_park_charge_carport                               */
/*==============================================================*/
create  index idx_park_charge_carport on park_charge using BTREE (
carport_code
);

/*==============================================================*/
/* Index: idx_park_charge_time                                  */
/*==============================================================*/
create  index idx_park_charge_time on park_charge using BTREE (
create_time
);

/*==============================================================*/
/* Table: park_consume_record                                   */
/*==============================================================*/
create table park_consume_record (
   uuid                 VARCHAR(32)          not null,
   car_num              VARCHAR(16)          null,
   card_number          VARCHAR(16)          null,
   owner_id             VARCHAR(32)          null,
   consume_amount       INTEGER              null,
   fee_amount           INTEGER              null,
   serial_number        VARCHAR(32)          null,
   fee_type             SMALLINT             null,
   favorable_amount     INTEGER              null,
   favorable_type       SMALLINT             null,
   favorable_ticket_number VARCHAR(64)          null,
   operator_id          VARCHAR(32)          null,
   operator_name        VARCHAR(32)          null,
   time_length          VARCHAR(32)          null,
   access_id            VARCHAR(32)          null,
   memo                 VARCHAR(250)         null,
   court_uuid           VARCHAR(32)          null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_CONSUME_RECORD primary key (uuid)
);

comment on table park_consume_record is
'消费记录表';

comment on column park_consume_record.uuid is
'ID';

comment on column park_consume_record.car_num is
'车牌号码';

comment on column park_consume_record.card_number is
'卡号';

comment on column park_consume_record.owner_id is
'交款人ID';

comment on column park_consume_record.consume_amount is
'消费金额（分）';

comment on column park_consume_record.fee_amount is
'实收款金额（分）';

comment on column park_consume_record.serial_number is
'流水号';

comment on column park_consume_record.fee_type is
'收款类型';

comment on column park_consume_record.favorable_amount is
'优惠金额（分）';

comment on column park_consume_record.favorable_type is
'优惠类型';

comment on column park_consume_record.favorable_ticket_number is
'优惠票号';

comment on column park_consume_record.operator_id is
'操作员ID';

comment on column park_consume_record.operator_name is
'操作员姓名';

comment on column park_consume_record.time_length is
'停车时长';

comment on column park_consume_record.access_id is
'车辆进出记录id';

comment on column park_consume_record.memo is
'备注';

comment on column park_consume_record.court_uuid is
'小区UUID';

comment on column park_consume_record.create_time is
'创建时间/消费时间';

comment on column park_consume_record.update_time is
'更新时间';

comment on column park_consume_record.create_user is
'创建人';

comment on column park_consume_record.update_user is
'修订人';

/*==============================================================*/
/* Index: idx_park_consume_record_time                          */
/*==============================================================*/
create  index idx_park_consume_record_time on park_consume_record using BTREE (
create_time
);

/*==============================================================*/
/* Table: park_fee_rule                                         */
/*==============================================================*/
create table park_fee_rule (
   uuid                 VARCHAR(32)          not null,
   rule_name            VARCHAR(64)          null,
   rule_type            VARCHAR(16)          null,
   detail               VARCHAR(2048)        null,
   memo                 VARCHAR(256)         null,
   delete_flag          SMALLINT             null default '0',
   court_uuid           VARCHAR(32)          null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_FEE_RULE primary key (uuid)
);

comment on table park_fee_rule is
'收费规则';

comment on column park_fee_rule.uuid is
'ID';

comment on column park_fee_rule.rule_name is
'名称';

comment on column park_fee_rule.rule_type is
'类型:time-按次,interval-时段,ladder-代表是按阶梯收费';

comment on column park_fee_rule.detail is
'规则内容';

comment on column park_fee_rule.memo is
'备注';

comment on column park_fee_rule.delete_flag is
'删除标记：0-正常,1-删除';

comment on column park_fee_rule.court_uuid is
'小区UUID';

comment on column park_fee_rule.create_time is
'创建时间';

comment on column park_fee_rule.update_time is
'更新时间';

comment on column park_fee_rule.create_user is
'创建人ID';

comment on column park_fee_rule.update_user is
'更新人ID';

/*==============================================================*/
/* Table: park_hand_record                                      */
/*==============================================================*/
create table park_hand_record (
   uuid                 VARCHAR(32)          not null,
   type                 SMALLINT             null,
   car_num              VARCHAR(16)          null,
   park_code            VARCHAR(32)          null,
   access_id            VARCHAR(32)          null,
   owner_id             VARCHAR(32)          null,
   camera_code          VARCHAR(32)          null,
   channel_id           VARCHAR(32)          null,
   img_url              VARCHAR(256)         null,
   num_url              VARCHAR(256)         null,
   create_user_name     VARCHAR(32)          null,
   court_uuid           VARCHAR(32)          null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_HAND_RECORD primary key (uuid)
);

comment on table park_hand_record is
'异常操作记录表';

comment on column park_hand_record.uuid is
'ID';

comment on column park_hand_record.type is
'类型：0-确认开闸，1-手动开闸';

comment on column park_hand_record.car_num is
'车牌号码';

comment on column park_hand_record.park_code is
'停车场编号';

comment on column park_hand_record.access_id is
'进出ID';

comment on column park_hand_record.owner_id is
'车主ID';

comment on column park_hand_record.camera_code is
'入场抓拍相机编号';

comment on column park_hand_record.channel_id is
'通道id';

comment on column park_hand_record.img_url is
'车辆图片';

comment on column park_hand_record.num_url is
'车牌图片';

comment on column park_hand_record.create_user_name is
'操作人姓名';

comment on column park_hand_record.court_uuid is
'小区UUID';

comment on column park_hand_record.create_time is
'创建时间/操作时间';

comment on column park_hand_record.update_time is
'更新时间';

comment on column park_hand_record.create_user is
'创建人/操作人ID';

comment on column park_hand_record.update_user is
'修订人';

/*==============================================================*/
/* Index: idx_park_hand_record_time                             */
/*==============================================================*/
create  index idx_park_hand_record_time on park_hand_record using BTREE (
create_time
);

/*==============================================================*/
/* Table: park_led_carport_rel                                  */
/*==============================================================*/
create table park_led_carport_rel (
   uuid                 VARCHAR(32)          not null,
   led_code             VARCHAR(32)          null,
   carport_id           VARCHAR(32)          null,
   court_uuid           VARCHAR(32)          null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_LED_CARPORT_REL primary key (uuid)
);

comment on table park_led_carport_rel is
'诱导屏&车位绑定表';

comment on column park_led_carport_rel.uuid is
'ID';

comment on column park_led_carport_rel.led_code is
'LED设备编号';

comment on column park_led_carport_rel.carport_id is
'车位ID';

comment on column park_led_carport_rel.court_uuid is
'小区UUID';

comment on column park_led_carport_rel.create_time is
'创建时间';

comment on column park_led_carport_rel.update_time is
'更新时间';

comment on column park_led_carport_rel.create_user is
'创建人';

comment on column park_led_carport_rel.update_user is
'修订人';

/*==============================================================*/
/* Index: idx_park_led_carport_rell                             */
/*==============================================================*/
create  index idx_park_led_carport_rell on park_led_carport_rel using BTREE (
led_code
);

/*==============================================================*/
/* Index: idx_park_led_carport_relc                             */
/*==============================================================*/
create  index idx_park_led_carport_relc on park_led_carport_rel using BTREE (
carport_id
);

/*==============================================================*/
/* Table: park_package_car_rel                                  */
/*==============================================================*/
create table park_package_car_rel (
   package_id           VARCHAR(32)          null,
   car_num              VARCHAR(16)          null
);

comment on table park_package_car_rel is
'授权套餐&车牌关联';

comment on column park_package_car_rel.package_id is
'授权套餐ID';

comment on column park_package_car_rel.car_num is
'车牌号码';

/*==============================================================*/
/* Index: idx_park_package_car_relp                             */
/*==============================================================*/
create  index idx_park_package_car_relp on park_package_car_rel using BTREE (
package_id
);

/*==============================================================*/
/* Index: idx_park_package_car_relc                             */
/*==============================================================*/
create  index idx_park_package_car_relc on park_package_car_rel using BTREE (
car_num
);

/*==============================================================*/
/* Table: park_package_park_rel                                 */
/*==============================================================*/
create table park_package_park_rel (
   package_id           VARCHAR(32)          not null,
   park_code            VARCHAR(32)          not null
);

comment on table park_package_park_rel is
'服务套餐&车场关联';

comment on column park_package_park_rel.package_id is
'授权套餐ID';

comment on column park_package_park_rel.park_code is
'车场编号';

/*==============================================================*/
/* Index: idx_par_package_park_rel_pid                          */
/*==============================================================*/
create  index idx_par_package_park_rel_pid on park_package_park_rel using BTREE (
package_id
);

/*==============================================================*/
/* Index: idx_park_package_park_rel_park                        */
/*==============================================================*/
create  index idx_park_package_park_rel_park on park_package_park_rel using BTREE (
park_code
);

/*==============================================================*/
/* Table: park_parked_cur                                       */
/*==============================================================*/
create table park_parked_cur (
   uuid                 VARCHAR(32)          not null,
   device_code          VARCHAR(32)          null,
   device_name          VARCHAR(100)         null,
   map_id               VARCHAR(32)          null,
   carport_code         VARCHAR(32)          not null,
   car_num              VARCHAR(20)          null,
   car_num_color        VARCHAR(16)          null,
   car_color            VARCHAR(16)          null,
   car_mark             VARCHAR(16)          null,
   owner_id             VARCHAR(32)          null,
   park_start           TIMESTAMP            null,
   park_date            TIMESTAMP            null,
   park_type            SMALLINT             null,
   alarm_status         SMALLINT             null,
   alarm_arrear         SMALLINT             null,
   alarm_abnormal       SMALLINT             null,
   img_url              VARCHAR(255)         null,
   court_uuid           VARCHAR(32)          null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_PARKED_CUR primary key (uuid)
);

comment on table park_parked_cur is
'车位实时停车表';

comment on column park_parked_cur.uuid is
'ID';

comment on column park_parked_cur.device_code is
'设备编号';

comment on column park_parked_cur.device_name is
'设备名称';

comment on column park_parked_cur.map_id is
'停车地图ID';

comment on column park_parked_cur.carport_code is
'车位编号';

comment on column park_parked_cur.car_num is
'车牌号码';

comment on column park_parked_cur.car_num_color is
'车牌颜色';

comment on column park_parked_cur.car_color is
'车身颜色';

comment on column park_parked_cur.car_mark is
'车标';

comment on column park_parked_cur.owner_id is
'车主ID';

comment on column park_parked_cur.park_start is
'停车开始 当检车为出车时，自动将当次停车的开始时间补上';

comment on column park_parked_cur.park_date is
'停车时间 停车检查时间，无论是出车还是进车，都记录当时的时间';

comment on column park_parked_cur.park_type is
'停车检测类型 0-无车；1-有车';

comment on column park_parked_cur.alarm_status is
'车位占用报警：0-无报警，1-有报警';

comment on column park_parked_cur.alarm_arrear is
'车位欠费报警：0-无报警，1-有报警';

comment on column park_parked_cur.alarm_abnormal is
'车辆异常报警：0-无报警，1-有报警';

comment on column park_parked_cur.img_url is
'车辆全景图';

comment on column park_parked_cur.court_uuid is
'小区UUID';

comment on column park_parked_cur.create_time is
'创建时间';

comment on column park_parked_cur.update_time is
'更新时间';

comment on column park_parked_cur.create_user is
'创建人';

comment on column park_parked_cur.update_user is
'修订人';

/*==============================================================*/
/* Index: idx_park_parked_cur_code                              */
/*==============================================================*/
create  index idx_park_parked_cur_code on park_parked_cur using BTREE (
carport_code
);

/*==============================================================*/
/* Table: park_parked_his                                       */
/*==============================================================*/
create table park_parked_his (
   uuid                 VARCHAR(32)          not null,
   device_code          VARCHAR(32)          null,
   device_name          VARCHAR(64)          null,
   map_id               VARCHAR(32)          null,
   carport_code         VARCHAR(32)          not null,
   car_num              VARCHAR(16)          null,
   car_num_color        VARCHAR(16)          null,
   car_color            VARCHAR(16)          null,
   car_mark             VARCHAR(16)          null,
   owner_id             VARCHAR(32)          null,
   park_start           TIMESTAMP            null,
   park_date            TIMESTAMP            null,
   alarm_status         SMALLINT             null,
   park_type            SMALLINT             null,
   img_url              VARCHAR(256)         null,
   court_uuid           VARCHAR(32)          null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_PARKED_HIS primary key (uuid)
);

comment on table park_parked_his is
'车位停车表历史表';

comment on column park_parked_his.uuid is
'ID';

comment on column park_parked_his.device_code is
'设备编号';

comment on column park_parked_his.device_name is
'设备名称';

comment on column park_parked_his.map_id is
'停车地图ID';

comment on column park_parked_his.carport_code is
'车位编号';

comment on column park_parked_his.car_num is
'车牌号码';

comment on column park_parked_his.car_num_color is
'车牌颜色';

comment on column park_parked_his.car_color is
'车身颜色';

comment on column park_parked_his.car_mark is
'车标';

comment on column park_parked_his.owner_id is
'车主ID';

comment on column park_parked_his.park_start is
'停车开始 当检车为出车时，自动将当次停车的开始时间补上';

comment on column park_parked_his.park_date is
'停车时间 停车检查时间，无论是出车还是进车，都记录当时的时间';

comment on column park_parked_his.alarm_status is
'报警的处理状态：0-无报警，1-车位占用报警';

comment on column park_parked_his.park_type is
'停车检测类型 0-无车；1-有车';

comment on column park_parked_his.img_url is
'车辆全景图';

comment on column park_parked_his.court_uuid is
'小区UUID';

comment on column park_parked_his.create_time is
'创建时间';

comment on column park_parked_his.update_time is
'更新时间';

comment on column park_parked_his.create_user is
'创建人';

comment on column park_parked_his.update_user is
'修订人';

/*==============================================================*/
/* Index: idx_park_parked_his_code                              */
/*==============================================================*/
create  index idx_park_parked_his_code on park_parked_his using BTREE (
carport_code
);

/*==============================================================*/
/* Table: park_parking_lot                                      */
/*==============================================================*/
create table park_parking_lot (
   uuid                 VARCHAR(32)          not null,
   park_name            VARCHAR(64)          null,
   park_code            VARCHAR(32)          null,
   total                INTEGER              null,
   idle                 INTEGER              null,
   parent_code          VARCHAR(64)          null,
   org_id               VARCHAR(32)          null,
   fee_rule_id          VARCHAR(32)          null,
   park_rule_id         VARCHAR(32)          null,
   config_info          VARCHAR(1024)        null,
   pic_path             VARCHAR(256)         null,
   address              VARCHAR(512)         null,
   longitude            DECIMAL(9,6)         null,
   latitude             DECIMAL(9,6)         null,
   phone_number         VARCHAR(20)          null,
   delete_flag          SMALLINT             null default '0',
   memo                 VARCHAR(256)         null,
   court_uuid           VARCHAR(32)          null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   constraint PK_PARK_PARKING_LOT primary key (uuid)
);

comment on table park_parking_lot is
'停车场信息表';

comment on column park_parking_lot.uuid is
'ID';

comment on column park_parking_lot.park_name is
'停车场名称';

comment on column park_parking_lot.park_code is
'停车场编号';

comment on column park_parking_lot.total is
'总车位';

comment on column park_parking_lot.idle is
'余位数';

comment on column park_parking_lot.parent_code is
'父场区编号';

comment on column park_parking_lot.org_id is
'所属组织';

comment on column park_parking_lot.fee_rule_id is
'默认临停车收费规则';

comment on column park_parking_lot.park_rule_id is
'默认进出放行规则规则';

comment on column park_parking_lot.config_info is
'其它配置信息';

comment on column park_parking_lot.pic_path is
'停车场图片';

comment on column park_parking_lot.address is
'停车场地址信息';

comment on column park_parking_lot.longitude is
'位置坐标：经度';

comment on column park_parking_lot.latitude is
'位置坐标：纬度';

comment on column park_parking_lot.phone_number is
'联系电话';

comment on column park_parking_lot.delete_flag is
'删除标记：0-正常,1-删除';

comment on column park_parking_lot.memo is
'备注';

comment on column park_parking_lot.court_uuid is
'小区UUID';

comment on column park_parking_lot.create_user is
'创建人ID';

comment on column park_parking_lot.update_user is
'更新人ID';

comment on column park_parking_lot.create_time is
'创建时间';

comment on column park_parking_lot.update_time is
'更新时间';

/*==============================================================*/
/* Index: idx_park_park_code                                    */
/*==============================================================*/
create  index idx_park_park_code on park_parking_lot using BTREE (
park_code
);

/*==============================================================*/
/* Table: park_reservation                                      */
/*==============================================================*/
create table park_reservation (
   uuid                 VARCHAR(32)          not null,
   car_num              VARCHAR(16)          null,
   park_code            VARCHAR(32)          null,
   start_time           TIMESTAMP            null,
   end_time             TIMESTAMP            null,
   serial_number        VARCHAR(32)          null,
   consumer_name        VARCHAR(32)          null,
   phone_number         VARCHAR(16)          null,
   enter_model          SMALLINT             null,
   exit_model           SMALLINT             null,
   access_id            VARCHAR(32)          null,
   notify_url           VARCHAR(256)         null,
   memo                 VARCHAR(256)         null,
   delete_flag          SMALLINT             null default '0',
   court_uuid           VARCHAR(32)          null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_RESERVATION primary key (uuid)
);

comment on table park_reservation is
'预约登记表';

comment on column park_reservation.uuid is
'ID';

comment on column park_reservation.car_num is
'车牌号码';

comment on column park_reservation.park_code is
'车场编号';

comment on column park_reservation.start_time is
'入场时间范围';

comment on column park_reservation.end_time is
'入场时间范围2';

comment on column park_reservation.serial_number is
'预约编号';

comment on column park_reservation.consumer_name is
'客户姓名';

comment on column park_reservation.phone_number is
'客户电话';

comment on column park_reservation.enter_model is
'预约车辆入场模式：0-不自动放行，1-自动放行';

comment on column park_reservation.exit_model is
'预约车辆出场模式：0-不自动放行，收费为0元,1-自动放行，2-按收费规则收费';

comment on column park_reservation.access_id is
'停车记录id';

comment on column park_reservation.notify_url is
'车辆进出时通知接口';

comment on column park_reservation.memo is
'备注';

comment on column park_reservation.delete_flag is
'删除标记';

comment on column park_reservation.court_uuid is
'小区UUID';

comment on column park_reservation.create_time is
'创建时间';

comment on column park_reservation.update_time is
'更新时间';

comment on column park_reservation.create_user is
'创建人ID';

comment on column park_reservation.update_user is
'更新人ID';

/*==============================================================*/
/* Index: idx_park_reservation_car                              */
/*==============================================================*/
create  index idx_park_reservation_car on park_reservation using BTREE (
car_num
);

/*==============================================================*/
/* Index: idx_park_reservation_serial                           */
/*==============================================================*/
create  index idx_park_reservation_serial on park_reservation using BTREE (
serial_number
);

/*==============================================================*/
/* Table: park_rule                                             */
/*==============================================================*/
create table park_rule (
   uuid                 VARCHAR(32)          not null,
   rule_name            VARCHAR(64)          null,
   carport_type         SMALLINT             null,
   detail               VARCHAR(2048)        null,
   memo                 VARCHAR(256)         null,
   delete_flag          SMALLINT             null default '0',
   court_uuid           VARCHAR(32)          null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_RULE primary key (uuid)
);

comment on table park_rule is
'停车规则表';

comment on column park_rule.uuid is
'ID';

comment on column park_rule.rule_name is
'进出规则名称';

comment on column park_rule.carport_type is
'是否是月保、产权车（0-否，1-是）';

comment on column park_rule.detail is
'规则内容';

comment on column park_rule.memo is
'备注';

comment on column park_rule.delete_flag is
'删除标记：0-正常,1-删除';

comment on column park_rule.court_uuid is
'小区UUID';

comment on column park_rule.create_time is
'创建时间';

comment on column park_rule.update_time is
'更新时间';

comment on column park_rule.create_user is
'创建人ID';

comment on column park_rule.update_user is
'更新人ID';

/*==============================================================*/
/* Table: park_sys_code                                         */
/*==============================================================*/
create table park_sys_code (
   item_code            VARCHAR(32)          not null,
   item_name            VARCHAR(32)          null,
   parent_code          VARCHAR(32)          null,
   type_code            VARCHAR(32)          not null,
   sort                 SMALLINT             null,
   enable_flag          SMALLINT             null default '1',
   memo                 VARCHAR(256)         null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_SYS_CODE primary key (item_code, type_code)
);

comment on table park_sys_code is
'数据字典表';

comment on column park_sys_code.item_code is
'项目编码';

comment on column park_sys_code.item_name is
'项目名称';

comment on column park_sys_code.parent_code is
'父编码';

comment on column park_sys_code.type_code is
'类型编码，关联数据字典主表';

comment on column park_sys_code.sort is
'排序码';

comment on column park_sys_code.enable_flag is
'是否启用:0-禁用，1-启用,默认启用';

comment on column park_sys_code.memo is
'描述';

comment on column park_sys_code.create_time is
'创建时间';

comment on column park_sys_code.update_time is
'更新时间';

comment on column park_sys_code.create_user is
'创建人id';

comment on column park_sys_code.update_user is
'更新人id';

/*==============================================================*/
/* Table: park_sys_code_type                                    */
/*==============================================================*/
create table park_sys_code_type (
   type_code            VARCHAR(32)          not null,
   type_name            VARCHAR(64)          null,
   enable_flag          SMALLINT             null default '1',
   memo                 VARCHAR(256)         null,
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_SYS_CODE_TYPE primary key (type_code)
);

comment on table park_sys_code_type is
'字典表大类';

comment on column park_sys_code_type.type_code is
'类型编码';

comment on column park_sys_code_type.type_name is
'类型名称';

comment on column park_sys_code_type.enable_flag is
'是否启用:0-禁用，1-启用,默认启用';

comment on column park_sys_code_type.memo is
'描述';

comment on column park_sys_code_type.create_time is
'创建时间';

comment on column park_sys_code_type.update_time is
'更新时间';

comment on column park_sys_code_type.create_user is
'创建人id';

comment on column park_sys_code_type.update_user is
'更新人id';

/*==============================================================*/
/* Table: park_sys_config                                       */
/*==============================================================*/
create table park_sys_config (
   config_type          VARCHAR(32)          not null,
   config_name          VARCHAR(64)          null,
   config_seq           SMALLINT             null,
   config_par1          VARCHAR(256)         null,
   config_par2          VARCHAR(256)         null,
   config_par3          VARCHAR(256)         null,
   enable_flag          SMALLINT             null default '1',
   create_time          TIMESTAMP            null,
   update_time          TIMESTAMP            null,
   create_user          VARCHAR(32)          null,
   update_user          VARCHAR(32)          null,
   constraint PK_PARK_SYS_CONFIG primary key (config_type)
);

comment on table park_sys_config is
'停车场配置表';

comment on column park_sys_config.config_type is
'配置类型';

comment on column park_sys_config.config_name is
'配置名称';

comment on column park_sys_config.config_seq is
'配置序列';

comment on column park_sys_config.config_par1 is
'参数1';

comment on column park_sys_config.config_par2 is
'参数2';

comment on column park_sys_config.config_par3 is
'参数3';

comment on column park_sys_config.enable_flag is
'状态:0-不启用，1启用';

comment on column park_sys_config.create_time is
'添加时间';

comment on column park_sys_config.update_time is
'更新时间';

comment on column park_sys_config.create_user is
'创建人id';

comment on column park_sys_config.update_user is
'更新人id';

alter table park_channel_rel
   add constraint FK_PARK_CHA_FK_PARK_C_PARK_CHA foreign key (channel_id)
      references park_channel (uuid)
      on delete restrict on update restrict;

alter table park_led_carport_rel
   add constraint FK_PARK_LED_FK_PARK_L_PARK_CAR foreign key (carport_id)
      references park_carport (uuid)
      on delete restrict on update restrict;

alter table park_package_car_rel
   add constraint FK_PARK_PAC_FK_PARK_C_PARK_AUT foreign key (package_id)
      references park_auth_package (uuid)
      on delete restrict on update restrict;

alter table park_package_park_rel
   add constraint FK_PARK_PAC_FK_PARK_R_PARK_AUT foreign key (package_id)
      references park_auth_package (uuid)
      on delete restrict on update restrict;

alter table park_sys_code
   add constraint FK_PARK_SYS_FK_PARK_S_PARK_SYS foreign key (type_code)
      references park_sys_code_type (type_code)
      on delete restrict on update restrict;

