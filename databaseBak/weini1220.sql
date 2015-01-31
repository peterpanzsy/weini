/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : weini

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2014-12-20 23:07:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_username` varchar(255) DEFAULT NULL,
  `admin_pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('2', 'zsy', 'zsyaaa');
INSERT INTO `t_admin` VALUES ('3', 'cyjaaa', 'cyjaaa');
INSERT INTO `t_admin` VALUES ('4', 'plin', 'plin');
INSERT INTO `t_admin` VALUES ('6', 'root2a', '0B4E7A0E5FE84AD35FB5F95B9CEEAC79');
INSERT INTO `t_admin` VALUES ('7', 'root1', 'root1');
INSERT INTO `t_admin` VALUES ('8', 'root1', 'root1');
INSERT INTO `t_admin` VALUES ('10', 'root1', 'root1');
INSERT INTO `t_admin` VALUES ('15', 'root1', 'root1');
INSERT INTO `t_admin` VALUES ('18', 'zsy', 'zsy');
INSERT INTO `t_admin` VALUES ('20', 'zsy', 'aaaaaa');
INSERT INTO `t_admin` VALUES ('21', 'cccc', 'ccccccccc');
INSERT INTO `t_admin` VALUES ('22', 'ddd', 'dddddd');
INSERT INTO `t_admin` VALUES ('24', 'gege', 'gegege');
INSERT INTO `t_admin` VALUES ('25', 'zouge', 'A4D37957C001A8F5F696171D2CF55E2E');
INSERT INTO `t_admin` VALUES ('26', 'root', '21232F297A57A5A743894A0E4A801FC3');
INSERT INTO `t_admin` VALUES ('27', 'zsy', '21232F297A57A5A743894A0E4A801FC3');

-- ----------------------------
-- Table structure for `t_admin_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin_role`;
CREATE TABLE `t_admin_role` (
  `admin_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_role_adminid` int(11) DEFAULT NULL,
  `admin_role_roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`admin_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin_role
-- ----------------------------
INSERT INTO `t_admin_role` VALUES ('2', '2', '4');
INSERT INTO `t_admin_role` VALUES ('3', '3', '2');
INSERT INTO `t_admin_role` VALUES ('4', '4', '3');
INSERT INTO `t_admin_role` VALUES ('6', '6', '1');
INSERT INTO `t_admin_role` VALUES ('7', '7', '1');
INSERT INTO `t_admin_role` VALUES ('8', '8', '1');
INSERT INTO `t_admin_role` VALUES ('9', '9', '1');
INSERT INTO `t_admin_role` VALUES ('11', '7', '1');
INSERT INTO `t_admin_role` VALUES ('12', '8', '1');
INSERT INTO `t_admin_role` VALUES ('13', '9', '1');
INSERT INTO `t_admin_role` VALUES ('14', '10', '1');
INSERT INTO `t_admin_role` VALUES ('19', '15', '1');
INSERT INTO `t_admin_role` VALUES ('25', '18', '1');
INSERT INTO `t_admin_role` VALUES ('27', '20', '1');
INSERT INTO `t_admin_role` VALUES ('28', '21', '1');
INSERT INTO `t_admin_role` VALUES ('29', '22', '1');
INSERT INTO `t_admin_role` VALUES ('31', '24', '4');
INSERT INTO `t_admin_role` VALUES ('32', '25', '1');
INSERT INTO `t_admin_role` VALUES ('33', '26', '1');
INSERT INTO `t_admin_role` VALUES ('34', '27', '3');

-- ----------------------------
-- Table structure for `t_alipay`
-- ----------------------------
DROP TABLE IF EXISTS `t_alipay`;
CREATE TABLE `t_alipay` (
  `alipay_id` int(11) NOT NULL AUTO_INCREMENT,
  `alipay_username` varchar(255) DEFAULT NULL,
  `alipay_userAccount` varchar(255) DEFAULT NULL,
  `alipay_userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`alipay_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_alipay
-- ----------------------------
INSERT INTO `t_alipay` VALUES ('1', '邹孙颖', '15829675981', '1');

-- ----------------------------
-- Table structure for `t_authority`
-- ----------------------------
DROP TABLE IF EXISTS `t_authority`;
CREATE TABLE `t_authority` (
  `authority_id` int(11) NOT NULL AUTO_INCREMENT,
  `authority_name` varchar(255) DEFAULT NULL,
  `authority_remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`authority_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_authority
-- ----------------------------
INSERT INTO `t_authority` VALUES ('1', 'order', '订单管理');
INSERT INTO `t_authority` VALUES ('2', 'good', '商品管理');
INSERT INTO `t_authority` VALUES ('3', 'vendor', '商家管理');
INSERT INTO `t_authority` VALUES ('4', 'user', '用户管理');
INSERT INTO `t_authority` VALUES ('5', 'admin', '管理员账户管理');
INSERT INTO `t_authority` VALUES ('6', 'report', '报表查看');

-- ----------------------------
-- Table structure for `t_bank`
-- ----------------------------
DROP TABLE IF EXISTS `t_bank`;
CREATE TABLE `t_bank` (
  `bank_id` int(11) NOT NULL AUTO_INCREMENT,
  `bank_username` varchar(255) DEFAULT NULL,
  `bank_cardNumber` varchar(255) DEFAULT NULL,
  `bank_bankname` varchar(255) DEFAULT NULL,
  `bank_sub_bankname` varchar(255) DEFAULT NULL,
  `bank_sub_bankAddress` varchar(255) DEFAULT NULL,
  `bank_userType` int(11) DEFAULT NULL,
  `bank_userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`bank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bank
-- ----------------------------
INSERT INTO `t_bank` VALUES ('1', '邹孙颖', '1111111111111', '中国工商银行', '交大支行', '咸宁西路', null, '1');

-- ----------------------------
-- Table structure for `t_box`
-- ----------------------------
DROP TABLE IF EXISTS `t_box`;
CREATE TABLE `t_box` (
  `box_id` int(11) NOT NULL AUTO_INCREMENT,
  `officeBuilding_id` int(11) DEFAULT NULL,
  `box_type` int(11) DEFAULT NULL,
  `box_gender` int(11) DEFAULT NULL,
  `box_price` float DEFAULT NULL,
  `box_cityid` int(11) DEFAULT NULL,
  PRIMARY KEY (`box_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_box
-- ----------------------------

-- ----------------------------
-- Table structure for `t_businessarea`
-- ----------------------------
DROP TABLE IF EXISTS `t_businessarea`;
CREATE TABLE `t_businessarea` (
  `businessArea_id` int(11) NOT NULL AUTO_INCREMENT,
  `businessArea_name` varchar(255) DEFAULT NULL,
  `district_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`businessArea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_businessarea
-- ----------------------------
INSERT INTO `t_businessarea` VALUES ('1', '交大商圈', '1');

-- ----------------------------
-- Table structure for `t_city`
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `province_id` int(11) DEFAULT NULL,
  `city_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_city
-- ----------------------------
INSERT INTO `t_city` VALUES ('1', '1', '西安');

-- ----------------------------
-- Table structure for `t_consumerecord`
-- ----------------------------
DROP TABLE IF EXISTS `t_consumerecord`;
CREATE TABLE `t_consumerecord` (
  `consumeRecord_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `pointExchange_id` int(11) DEFAULT NULL,
  `consumeRecord_time` datetime DEFAULT NULL,
  `consumeRecord_userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`consumeRecord_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_consumerecord
-- ----------------------------

-- ----------------------------
-- Table structure for `t_cookinfo`
-- ----------------------------
DROP TABLE IF EXISTS `t_cookinfo`;
CREATE TABLE `t_cookinfo` (
  `cookinfo_id` int(11) NOT NULL AUTO_INCREMENT,
  `cookinfo_name` varchar(255) DEFAULT NULL,
  `cookinfo_image` varchar(255) DEFAULT NULL,
  `cookinfo_businfoid` int(11) DEFAULT NULL,
  PRIMARY KEY (`cookinfo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cookinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `t_dishes`
-- ----------------------------
DROP TABLE IF EXISTS `t_dishes`;
CREATE TABLE `t_dishes` (
  `dishes_id` int(11) NOT NULL AUTO_INCREMENT,
  `dishes_name` varchar(255) DEFAULT NULL,
  `dishes_series_1` varchar(255) DEFAULT NULL,
  `dishes_series_2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dishes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��Ʒ��';

-- ----------------------------
-- Records of t_dishes
-- ----------------------------

-- ----------------------------
-- Table structure for `t_dispatching`
-- ----------------------------
DROP TABLE IF EXISTS `t_dispatching`;
CREATE TABLE `t_dispatching` (
  `dispatching_id` int(11) NOT NULL AUTO_INCREMENT,
  `dispatching_province` varchar(255) DEFAULT NULL,
  `dispatching_city` varchar(255) DEFAULT NULL,
  `dispatching_businessAreaid` int(11) DEFAULT NULL,
  `dispatching_officeBuilding` varchar(255) DEFAULT NULL,
  `dispatching_addressDetail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dispatching_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dispatching
-- ----------------------------

-- ----------------------------
-- Table structure for `t_dispatchingstatus`
-- ----------------------------
DROP TABLE IF EXISTS `t_dispatchingstatus`;
CREATE TABLE `t_dispatchingstatus` (
  `dispatchingStatus_id` int(11) NOT NULL AUTO_INCREMENT,
  `dispatchingStatus_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dispatchingStatus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dispatchingstatus
-- ----------------------------

-- ----------------------------
-- Table structure for `t_district`
-- ----------------------------
DROP TABLE IF EXISTS `t_district`;
CREATE TABLE `t_district` (
  `district_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_id` int(11) DEFAULT NULL,
  `district_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`district_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_district
-- ----------------------------
INSERT INTO `t_district` VALUES ('1', '1', '碑林区');

-- ----------------------------
-- Table structure for `t_legalinfo`
-- ----------------------------
DROP TABLE IF EXISTS `t_legalinfo`;
CREATE TABLE `t_legalinfo` (
  `legalinfo_id` int(11) NOT NULL AUTO_INCREMENT,
  `bssinfo_id` int(11) DEFAULT NULL,
  `legalinfo_name` varchar(255) DEFAULT NULL,
  `legalinfo_regBrand` varchar(255) DEFAULT NULL,
  `legalinfo_regAddress` varchar(255) DEFAULT NULL,
  `legalinfo_validPeriod` varchar(255) DEFAULT NULL,
  `legalinfo_commonAddress` varchar(255) DEFAULT NULL,
  `legalinfo_phoneNumber` varchar(255) DEFAULT NULL,
  `legalinfo_scanningImage` varchar(255) DEFAULT NULL,
  `legalinfo_indenfityFront` varchar(255) DEFAULT NULL,
  `legalinfo_indenfityBack` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`legalinfo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='������Ϣ';

-- ----------------------------
-- Records of t_legalinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `t_menuinfo`
-- ----------------------------
DROP TABLE IF EXISTS `t_menuinfo`;
CREATE TABLE `t_menuinfo` (
  `menuinfo_id` int(11) NOT NULL,
  `bussinfo_id` int(11) DEFAULT NULL,
  `menuinfo_image1` varchar(255) DEFAULT NULL,
  `menuinfo_image2` varchar(255) DEFAULT NULL,
  `menuinfo_image3` varchar(255) DEFAULT NULL,
  `menuinfo_image4` varchar(255) DEFAULT NULL,
  `menuinfo_detail` text,
  `menuinfo_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`menuinfo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menuinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `t_menu_cookinfo`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_cookinfo`;
CREATE TABLE `t_menu_cookinfo` (
  `menu_cookinfoid` int(11) NOT NULL AUTO_INCREMENT,
  `menuinfo_id` int(11) DEFAULT NULL,
  `cookinfo_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`menu_cookinfoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu_cookinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `t_menu_dishes`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_dishes`;
CREATE TABLE `t_menu_dishes` (
  `menu_dishes_id` int(11) NOT NULL AUTO_INCREMENT,
  `menuinfo_id` int(11) DEFAULT NULL,
  `dishes_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`menu_dishes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu_dishes
-- ----------------------------

-- ----------------------------
-- Table structure for `t_officebuilding`
-- ----------------------------
DROP TABLE IF EXISTS `t_officebuilding`;
CREATE TABLE `t_officebuilding` (
  `officeBuilding_id` int(11) NOT NULL AUTO_INCREMENT,
  `businessArea_id` int(11) DEFAULT NULL,
  `officeBuilding_longitude` float DEFAULT NULL,
  `officeBuilding_latitude` float DEFAULT NULL,
  `officeBuilding_radius` float DEFAULT NULL,
  `officeBuilding_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`officeBuilding_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_officebuilding
-- ----------------------------

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `box_id` int(11) DEFAULT NULL,
  `order_startTime` datetime DEFAULT NULL,
  `order_orderTime` datetime DEFAULT NULL,
  `order_payStatus` int(11) DEFAULT NULL,
  `S_order_consumeStatus` int(11) DEFAULT NULL,
  `order_isRefund` tinyint(1) DEFAULT NULL,
  `order_payTime` datetime DEFAULT NULL,
  `box_price` float DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for `t_point`
-- ----------------------------
DROP TABLE IF EXISTS `t_point`;
CREATE TABLE `t_point` (
  `point_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `point_first` int(11) DEFAULT NULL,
  `point_activity` int(11) DEFAULT NULL,
  `point_confirm` int(11) DEFAULT NULL,
  `point_expenditure` int(11) DEFAULT NULL,
  `point_total` int(11) DEFAULT NULL,
  PRIMARY KEY (`point_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_point
-- ----------------------------
INSERT INTO `t_point` VALUES ('1', '1', '11', null, null, null, '12');

-- ----------------------------
-- Table structure for `t_pointactivity`
-- ----------------------------
DROP TABLE IF EXISTS `t_pointactivity`;
CREATE TABLE `t_pointactivity` (
  `pointActivity_id` int(11) NOT NULL AUTO_INCREMENT,
  `pointActivity_city` varchar(255) DEFAULT NULL,
  `pointActivity_times` int(11) DEFAULT NULL,
  PRIMARY KEY (`pointActivity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pointactivity
-- ----------------------------

-- ----------------------------
-- Table structure for `t_pointexchange`
-- ----------------------------
DROP TABLE IF EXISTS `t_pointexchange`;
CREATE TABLE `t_pointexchange` (
  `pointExchange_id` int(11) NOT NULL AUTO_INCREMENT,
  `pointExchange_describe` text,
  `pointExchange_needPoint` float DEFAULT NULL,
  `pointExchange_imageAddress` varchar(255) DEFAULT NULL,
  `pointExchange_canExchange` tinyint(1) DEFAULT NULL,
  `pointExchange_startT` datetime DEFAULT NULL,
  `pointExchange_endT` datetime DEFAULT NULL,
  PRIMARY KEY (`pointExchange_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pointexchange
-- ----------------------------

-- ----------------------------
-- Table structure for `t_province`
-- ----------------------------
DROP TABLE IF EXISTS `t_province`;
CREATE TABLE `t_province` (
  `province_id` int(11) NOT NULL AUTO_INCREMENT,
  `province_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`province_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_province
-- ----------------------------
INSERT INTO `t_province` VALUES ('1', '陕西');

-- ----------------------------
-- Table structure for `t_registeraddress`
-- ----------------------------
DROP TABLE IF EXISTS `t_registeraddress`;
CREATE TABLE `t_registeraddress` (
  `registerAddress_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `registerAddress_detail` varchar(255) DEFAULT NULL,
  `registerAddress_businessAreaid` int(11) DEFAULT NULL,
  PRIMARY KEY (`registerAddress_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_registeraddress
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'root');
INSERT INTO `t_role` VALUES ('2', 'finance_admin');
INSERT INTO `t_role` VALUES ('3', 'good_admin');
INSERT INTO `t_role` VALUES ('4', 'ordinary_admin');

-- ----------------------------
-- Table structure for `t_role_authority`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_authority`;
CREATE TABLE `t_role_authority` (
  `role_authority_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_authority_roleid` int(11) DEFAULT NULL,
  `role_authority_authorityid` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_authority_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_authority
-- ----------------------------
INSERT INTO `t_role_authority` VALUES ('2', '1', '2');
INSERT INTO `t_role_authority` VALUES ('4', '1', '4');
INSERT INTO `t_role_authority` VALUES ('5', '1', '5');
INSERT INTO `t_role_authority` VALUES ('7', '3', '2');
INSERT INTO `t_role_authority` VALUES ('9', '2', '6');
INSERT INTO `t_role_authority` VALUES ('10', '3', '2');
INSERT INTO `t_role_authority` VALUES ('11', '4', '6');
INSERT INTO `t_role_authority` VALUES ('24', '1', '1');
INSERT INTO `t_role_authority` VALUES ('25', '1', '6');
INSERT INTO `t_role_authority` VALUES ('26', '1', '3');
INSERT INTO `t_role_authority` VALUES ('27', '2', '5');
INSERT INTO `t_role_authority` VALUES ('28', '4', '1');
INSERT INTO `t_role_authority` VALUES ('29', '4', '2');
INSERT INTO `t_role_authority` VALUES ('30', '4', '5');
INSERT INTO `t_role_authority` VALUES ('31', '4', '3');

-- ----------------------------
-- Table structure for `t_settle`
-- ----------------------------
DROP TABLE IF EXISTS `t_settle`;
CREATE TABLE `t_settle` (
  `settle_id` int(11) NOT NULL AUTO_INCREMENT,
  `bssinfo_id` int(11) DEFAULT NULL,
  `settle_type` int(11) DEFAULT NULL,
  `settle_money` float DEFAULT NULL,
  `settle_state` varchar(255) DEFAULT NULL,
  `settle_date` datetime DEFAULT NULL,
  `settle_startT` datetime DEFAULT NULL,
  `settle_endT` datetime DEFAULT NULL,
  PRIMARY KEY (`settle_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�����';

-- ----------------------------
-- Records of t_settle
-- ----------------------------

-- ----------------------------
-- Table structure for `t_s_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_s_order`;
CREATE TABLE `t_s_order` (
  `S_order_id` int(11) NOT NULL AUTO_INCREMENT,
  `F_order_id` int(11) DEFAULT NULL,
  `dispatching_id` int(11) DEFAULT NULL,
  `dispatchingStatus_id` char(10) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `S_order_whichday` int(11) DEFAULT NULL,
  `S_order_consumeStatus` int(11) DEFAULT NULL,
  `S_order_consumeEvaluate` varchar(255) DEFAULT NULL,
  `S_order_dispatchingID` int(11) DEFAULT NULL,
  `S_order_dispatchingStartT` datetime DEFAULT NULL,
  `S_order_logisticsEvaluate` varchar(255) DEFAULT NULL,
  `S_order_predictTime` datetime DEFAULT NULL,
  `S_order_isdispatchingStateOpen` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`S_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_order
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_pwd` varchar(255) DEFAULT NULL,
  `user_gender` int(11) DEFAULT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `user_phoneNumber` varchar(11) DEFAULT NULL,
  `user_phoneType` int(11) DEFAULT NULL,
  `user_scale` int(11) DEFAULT NULL,
  `user_bank_default` int(11) DEFAULT NULL,
  `user_alipay_default` int(11) DEFAULT NULL,
  `user_weChatPay` varchar(255) DEFAULT NULL,
  `user_point_default` int(11) DEFAULT NULL,
  `user_regdate` date DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'zsy', 'zsy', '0', 'a', '1', '1', '1', '1', '1', '1', '1', '2014-12-13');

-- ----------------------------
-- Table structure for `t_userextra`
-- ----------------------------
DROP TABLE IF EXISTS `t_userextra`;
CREATE TABLE `t_userextra` (
  `userextra_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` char(10) DEFAULT NULL,
  `userextra_image` varchar(255) DEFAULT NULL,
  `userextra_reserved` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userextra_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_userextra
-- ----------------------------

-- ----------------------------
-- Table structure for `t_vendor`
-- ----------------------------
DROP TABLE IF EXISTS `t_vendor`;
CREATE TABLE `t_vendor` (
  `vendor_id` int(11) NOT NULL AUTO_INCREMENT,
  `vendor_name` varchar(255) DEFAULT NULL,
  `vendor_mail` varchar(255) DEFAULT NULL,
  `vendor_phonenum` varchar(11) DEFAULT NULL,
  `vendor_pwd` varchar(255) DEFAULT NULL,
  `vendor_isopen` tinyint(1) DEFAULT NULL,
  `vendor_totalmoney` int(11) DEFAULT NULL,
  `vendor_paidmoney` int(11) DEFAULT NULL,
  `vendor_remainedmoney` int(11) DEFAULT NULL,
  `vendor_employernum` int(11) DEFAULT NULL,
  `vendor_cooknum` int(11) DEFAULT NULL,
  `vendor_shophour_start` varchar(255) DEFAULT NULL,
  `vendor_shophour_end` varchar(255) DEFAULT NULL,
  `vendor_paytype` int(11) DEFAULT NULL,
  `vendor_default_accountid` int(11) DEFAULT NULL,
  `vendor_business_areaid` int(11) DEFAULT NULL,
  `vendor_detail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vendor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_vendor
-- ----------------------------
INSERT INTO `t_vendor` VALUES ('1', 'a', 'a', '1', '1', '1', '1', '1', '0', '2', '1', '08:14:12', '12:00:00', '1', '1', '1', '');
INSERT INTO `t_vendor` VALUES ('2', 'z', 'z', '1', null, '1', null, null, null, '1', '1', '08:24:12', '22:00:00', null, null, '1', '');
INSERT INTO `t_vendor` VALUES ('4', '1', '1', '1', null, '1', null, null, null, '1', '1', '16:04:12', '23:00:00', null, null, '1', '');
INSERT INTO `t_vendor` VALUES ('5', 'a', 'a', '1', null, '1', null, null, null, '1', '1', '18:44:12', '22:20:00', null, null, '1', '');
INSERT INTO `t_vendor` VALUES ('6', '1', '1', '1', null, '0', null, null, null, '1', '1', '08:24:12', '11:20:00', null, null, '1', '');
INSERT INTO `t_vendor` VALUES ('8', 'a', 'a', '1', null, '1', null, null, null, '1', '1', '06:00:00', '06:10:00', '1', '1', '1', null);
INSERT INTO `t_vendor` VALUES ('9', '外婆印象', 'hehe@gmai.com', '123', null, '1', null, null, null, '111', '111', '06:00:00', '23:00:00', null, null, '1', '难吃');
