-- 初始化系统配置数据
INSERT INTO "park_sys_config" VALUES ('1', '月保、产权车位过期前提醒', 1, '7', '天', NULL, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_config" VALUES ('2', '临停车长时间未出场告警', 2, '48', '小时', NULL, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_config" VALUES ('3', '人工抬杆次数限制', 3, '100', '次', NULL, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);

-- ----------------------------
-- Records of park_sys_code_type
-- ----------------------------
INSERT INTO "park_sys_code_type" VALUES ('1', 'car_num_color', '1', '车牌颜色', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code_type" VALUES ('2', 'car_brand', '1', '汽车品牌', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code_type" VALUES ('3', 'car_color', '1', '汽车颜色', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code_type" VALUES ('4', 'car_mode', '1', '车型', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);

-- ----------------------------
-- Records of park_sys_code
-- ----------------------------
INSERT INTO "park_sys_code" VALUES ('0', '蓝色', null, '1', '0', '1', '小型车辆', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('0', '未识别', null, '2', '0', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('0', '白色', null, '3', '0', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('0', '小型车', null, '4', '0', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('1', '黄色', null, '1', '1', '1', '大型车辆', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('1', '奥迪', null, '2', '1', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('1', '黑色', null, '3', '1', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('1', '大型车', null, '4', '1', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('-1', '其它', null, '2', '-1', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('10', '尼桑', null, '2', '10', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('10', '粉色', null, '3', '10', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('100', '其它颜色', null, '1', '100', '1', '其他车辆', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('100', '其他', null, '3', '100', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('11', '现代', null, '2', '11', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('11', '棕色', null, '3', '11', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('12', '铃木', null, '2', '12', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('13', '雪铁龙', null, '2', '13', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('14', '奔驰', null, '2', '14', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('15', '比亚迪', null, '2', '15', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('16', '吉利', null, '2', '16', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('17', '雷克萨斯', null, '2', '17', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('18', '雪佛兰', null, '2', '18', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('19', '奇瑞', null, '2', '19', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('2', '白色', null, '1', '2', '1', '军警车辆', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('2', '本田', null, '2', '2', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('2', '红色', null, '3', '2', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('2', '超大型车', null, '4', '2', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('20', '起亚', null, '2', '20', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('21', '夏利', null, '2', '21', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('22', '东风', null, '2', '22', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('23', '依维柯', null, '2', '23', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('24', '五菱', null, '2', '24', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('25', '金杯', null, '2', '25', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('26', '保时捷', null, '2', '26', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('27', '法拉利', null, '2', '27', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('28', '兰博基尼', null, '2', '28', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('3', '黑色', null, '1', '3', '1', '外籍车辆', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('3', '别克', null, '2', '3', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('3', '黄色', null, '3', '3', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('3', '摩托车', null, '4', '3', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('4', '大众', null, '2', '4', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('4', '银灰色', null, '3', '4', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('5', '丰田', null, '2', '5', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('5', '蓝色', null, '3', '5', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('6', '宝马', null, '2', '6', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('6', '绿色', null, '3', '6', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('7', '标致', null, '2', '7', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('7', '橙色', null, '3', '7', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('8', '福特', null, '2', '8', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('8', '紫色', null, '3', '8', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('9', '马自达', null, '2', '9', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('9', '青色', null, '3', '9', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('99', '未识别', null, '1', '99', '1', '未识别', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);
INSERT INTO "park_sys_code" VALUES ('99', '未识别', null, '3', '99', '1', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL);