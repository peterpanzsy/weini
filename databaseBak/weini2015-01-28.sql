/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50616
Source Host           : localhost:3306
Source Database       : weini

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2015-01-28 20:18:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_username` varchar(255) NOT NULL DEFAULT '',
  `admin_pwd` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `t_admin_role`;
CREATE TABLE `t_admin_role` (
  `admin_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_role_adminid` int(11) NOT NULL,
  `admin_role_roleid` int(11) NOT NULL,
  PRIMARY KEY (`admin_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_alipay
-- ----------------------------
DROP TABLE IF EXISTS `t_alipay`;
CREATE TABLE `t_alipay` (
  `alipay_id` int(11) NOT NULL AUTO_INCREMENT,
  `alipay_username` varchar(255) NOT NULL DEFAULT '',
  `alipay_userAccount` varchar(255) NOT NULL DEFAULT '',
  `alipay_userid` int(11) NOT NULL,
  PRIMARY KEY (`alipay_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_authority`;
CREATE TABLE `t_authority` (
  `authority_id` int(11) NOT NULL AUTO_INCREMENT,
  `authority_name` varchar(255) NOT NULL DEFAULT '',
  `authority_remark` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`authority_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_bank
-- ----------------------------
DROP TABLE IF EXISTS `t_bank`;
CREATE TABLE `t_bank` (
  `bank_id` int(11) NOT NULL AUTO_INCREMENT,
  `bank_username` varchar(255) NOT NULL DEFAULT '',
  `bank_cardNumber` varchar(255) NOT NULL DEFAULT '',
  `bank_bankname` varchar(255) NOT NULL DEFAULT '',
  `bank_sub_bankname` varchar(255) NOT NULL DEFAULT '',
  `bank_sub_bankAddress` varchar(255) NOT NULL DEFAULT '',
  `bank_userType` int(11) NOT NULL,
  `bank_userid` int(11) NOT NULL,
  PRIMARY KEY (`bank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_box
-- ----------------------------
DROP TABLE IF EXISTS `t_box`;
CREATE TABLE `t_box` (
  `box_id` int(11) NOT NULL AUTO_INCREMENT,
  `box_gender` int(11) NOT NULL DEFAULT '0',
  `box_price` float NOT NULL DEFAULT '0',
  `box_cityid` int(11) NOT NULL,
  `box_image1` varchar(255) NOT NULL DEFAULT '',
  `box_image2` varchar(255) NOT NULL DEFAULT '',
  `box_image3` varchar(255) NOT NULL DEFAULT '',
  `box_image4` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`box_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_boxpage
-- ----------------------------
DROP TABLE IF EXISTS `t_boxpage`;
CREATE TABLE `t_boxpage` (
  `boxpage_id` int(11) NOT NULL AUTO_INCREMENT,
  `boxpage_title` varchar(255) NOT NULL DEFAULT '',
  `boxpage_tiptext` varchar(255) NOT NULL DEFAULT '',
  `boxpage_oneText` varchar(255) NOT NULL DEFAULT '',
  `boxpage_onedesctext` varchar(255) NOT NULL DEFAULT '',
  `boxpage_threetext` varchar(255) NOT NULL DEFAULT '',
  `boxpage_threedesctext` varchar(255) NOT NULL DEFAULT '',
  `boxpage_fiveboxtext` varchar(255) NOT NULL DEFAULT '',
  `boxpage_fivedesctext` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`boxpage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_boxtype
-- ----------------------------
DROP TABLE IF EXISTS `t_boxtype`;
CREATE TABLE `t_boxtype` (
  `typeid` int(11) NOT NULL AUTO_INCREMENT,
  `desc1` varchar(255) DEFAULT NULL,
  `desc2` varchar(255) DEFAULT NULL,
  `desc3` varchar(255) DEFAULT NULL,
  `desc4` varchar(255) DEFAULT NULL,
  `typename` varchar(255) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_businessarea
-- ----------------------------
DROP TABLE IF EXISTS `t_businessarea`;
CREATE TABLE `t_businessarea` (
  `businessArea_id` int(11) NOT NULL AUTO_INCREMENT,
  `businessArea_name` varchar(255) NOT NULL DEFAULT '',
  `district_id` int(11) NOT NULL,
  PRIMARY KEY (`businessArea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_city
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `province_id` int(11) NOT NULL,
  `city_name` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_consumerecord
-- ----------------------------
DROP TABLE IF EXISTS `t_consumerecord`;
CREATE TABLE `t_consumerecord` (
  `consumeRecord_id` int(11) NOT NULL AUTO_INCREMENT,
  `pointExchange_id` int(11) NOT NULL,
  `consumeRecord_time` datetime NOT NULL,
  `consumeRecord_userid` int(11) NOT NULL,
  PRIMARY KEY (`consumeRecord_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_cookinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_cookinfo`;
CREATE TABLE `t_cookinfo` (
  `cookinfo_id` int(11) NOT NULL AUTO_INCREMENT,
  `cookinfo_name` varchar(255) NOT NULL,
  `cookinfo_image` varchar(255) DEFAULT NULL,
  `cookinfo_vendorid` int(11) NOT NULL,
  PRIMARY KEY (`cookinfo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_dishes
-- ----------------------------
DROP TABLE IF EXISTS `t_dishes`;
CREATE TABLE `t_dishes` (
  `dishes_id` int(11) NOT NULL AUTO_INCREMENT,
  `dishes_name` varchar(255) NOT NULL,
  `dishes_series_1` varchar(255) DEFAULT NULL,
  `dishes_series_2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dishes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='锟斤拷品锟斤拷';

-- ----------------------------
-- Table structure for t_dispatching
-- ----------------------------
DROP TABLE IF EXISTS `t_dispatching`;
CREATE TABLE `t_dispatching` (
  `dispatching_id` int(11) NOT NULL AUTO_INCREMENT,
  `dispatching_province` int(11) NOT NULL,
  `dispatching_city` int(11) NOT NULL,
  `dispatching_businessAreaid` int(11) NOT NULL,
  `dispatching_officeBuilding` int(11) NOT NULL,
  `dispatching_addressDetail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dispatching_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_dispatchingstatus
-- ----------------------------
DROP TABLE IF EXISTS `t_dispatchingstatus`;
CREATE TABLE `t_dispatchingstatus` (
  `dispatchingStatus_id` int(11) NOT NULL AUTO_INCREMENT,
  `dispatchingStatus_name` varchar(255) NOT NULL DEFAULT '',
  `dispatchingStatus_imagename` varchar(255) NOT NULL DEFAULT '',
  `dispatchingStatus_desctext` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`dispatchingStatus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_district
-- ----------------------------
DROP TABLE IF EXISTS `t_district`;
CREATE TABLE `t_district` (
  `district_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_id` int(11) NOT NULL,
  `district_name` varchar(255) NOT NULL,
  PRIMARY KEY (`district_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_menuinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_menuinfo`;
CREATE TABLE `t_menuinfo` (
  `menuinfo_id` int(11) NOT NULL AUTO_INCREMENT,
  `menuinfo_name` varchar(255) NOT NULL,
  `vendor_id` int(11) NOT NULL,
  `menuinfo_image1` varchar(255) DEFAULT NULL,
  `menuinfo_image2` varchar(255) DEFAULT NULL,
  `menuinfo_image3` varchar(255) DEFAULT NULL,
  `menuinfo_image4` varchar(255) DEFAULT NULL,
  `menuinfo_detail` text,
  `menuinfo_date` datetime NOT NULL,
  `menuinfo_status` int(4) NOT NULL DEFAULT '1',
  `menuinfo_point` float DEFAULT NULL,
  `menuinfo_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`menuinfo_id`,`menuinfo_name`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_menu_cookinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_cookinfo`;
CREATE TABLE `t_menu_cookinfo` (
  `menu_cookinfoid` int(11) NOT NULL AUTO_INCREMENT,
  `menuinfo_id` int(11) NOT NULL,
  `cookinfo_id` int(11) NOT NULL,
  PRIMARY KEY (`menu_cookinfoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_menu_dishes
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_dishes`;
CREATE TABLE `t_menu_dishes` (
  `menu_dishes_id` int(11) NOT NULL AUTO_INCREMENT,
  `menuinfo_id` int(11) DEFAULT NULL,
  `dishes_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`menu_dishes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_officebuilding
-- ----------------------------
DROP TABLE IF EXISTS `t_officebuilding`;
CREATE TABLE `t_officebuilding` (
  `officeBuilding_id` int(11) NOT NULL AUTO_INCREMENT,
  `businessArea_id` int(11) NOT NULL,
  `officeBuilding_longitude` float DEFAULT NULL,
  `officeBuilding_latitude` float DEFAULT NULL,
  `officeBuilding_radius` float DEFAULT NULL,
  `officeBuilding_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`officeBuilding_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `box_id` int(11) NOT NULL,
  `order_startTime` datetime NOT NULL,
  `order_orderTime` datetime NOT NULL,
  `order_payStatus` int(11) NOT NULL,
  `S_order_consumeStatus` int(11) NOT NULL,
  `order_isRefund` tinyint(1) NOT NULL,
  `order_payTime` datetime NOT NULL,
  `box_price` float NOT NULL,
  `order_isFirst` int(11) NOT NULL,
  `order_isvalid` tinyint(1) NOT NULL,
  `order_dispatching_id` int(11) NOT NULL,
  `order_settleStatus` int(11) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_point
-- ----------------------------
DROP TABLE IF EXISTS `t_point`;
CREATE TABLE `t_point` (
  `point_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `point_first` int(11) DEFAULT NULL,
  `point_activity` int(11) DEFAULT NULL,
  `point_confirm` int(11) DEFAULT NULL,
  `point_expenditure` int(11) DEFAULT NULL,
  `point_total` int(11) DEFAULT NULL,
  PRIMARY KEY (`point_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_pointactivity
-- ----------------------------
DROP TABLE IF EXISTS `t_pointactivity`;
CREATE TABLE `t_pointactivity` (
  `pointActivity_id` int(11) NOT NULL AUTO_INCREMENT,
  `pointActivity_city` varchar(255) DEFAULT NULL,
  `pointActivity_times` int(11) DEFAULT NULL,
  PRIMARY KEY (`pointActivity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_pointexchange
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
-- Table structure for t_province
-- ----------------------------
DROP TABLE IF EXISTS `t_province`;
CREATE TABLE `t_province` (
  `province_id` int(11) NOT NULL AUTO_INCREMENT,
  `province_name` varchar(255) NOT NULL,
  PRIMARY KEY (`province_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_registeraddress
-- ----------------------------
DROP TABLE IF EXISTS `t_registeraddress`;
CREATE TABLE `t_registeraddress` (
  `registerAddress_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `registerAddress_detail` varchar(255) DEFAULT NULL,
  `registerAddress_businessAreaid` int(11) NOT NULL,
  PRIMARY KEY (`registerAddress_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_role_authority`;
CREATE TABLE `t_role_authority` (
  `role_authority_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_authority_roleid` int(11) NOT NULL,
  `role_authority_authorityid` int(11) NOT NULL,
  PRIMARY KEY (`role_authority_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_settle
-- ----------------------------
DROP TABLE IF EXISTS `t_settle`;
CREATE TABLE `t_settle` (
  `settle_id` int(11) NOT NULL AUTO_INCREMENT,
  `vendor_id` int(11) NOT NULL,
  `settle_type` int(11) NOT NULL,
  `settle_money` float NOT NULL,
  `settle_state` varchar(255) NOT NULL,
  `settle_date` datetime NOT NULL,
  `settle_order_startID` int(11) NOT NULL,
  `settle_order_endID` int(11) NOT NULL,
  PRIMARY KEY (`settle_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='锟斤拷锟斤拷锟';

-- ----------------------------
-- Table structure for t_startpageinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_startpageinfo`;
CREATE TABLE `t_startpageinfo` (
  `startpage_id` int(11) NOT NULL AUTO_INCREMENT,
  `startpage_status` int(11) NOT NULL DEFAULT '0',
  `startpage_starttime` datetime NOT NULL,
  `startpage_endtime` datetime NOT NULL,
  `startpage_imageloc` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`startpage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_s_order
-- ----------------------------
DROP TABLE IF EXISTS `t_s_order`;
CREATE TABLE `t_s_order` (
  `S_order_id` int(11) NOT NULL AUTO_INCREMENT,
  `F_order_id` int(11) NOT NULL,
  `dispatchingStatus_id` char(10) NOT NULL,
  `menu_id` int(11) NOT NULL,
  `S_order_whichday` int(11) NOT NULL,
  `S_order_consumeStatus` int(11) NOT NULL,
  `S_order_consumeEvaluate` varchar(255) DEFAULT NULL,
  `S_order_dispatchingID` int(11) NOT NULL,
  `S_order_dispatchingStartT` datetime NOT NULL,
  `S_order_logisticsEvaluate` varchar(255) DEFAULT NULL,
  `S_order_predictTime` datetime NOT NULL,
  `S_order_isdispatchingStateOpen` int(11) NOT NULL,
  `S_order_isRefund` int(11) NOT NULL,
  `S_order_userheat` varchar(255) NOT NULL,
  PRIMARY KEY (`S_order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_trackpage
-- ----------------------------
DROP TABLE IF EXISTS `t_trackpage`;
CREATE TABLE `t_trackpage` (
  `trackpage_id` int(11) NOT NULL AUTO_INCREMENT,
  `trackpage_currentstate` varchar(255) NOT NULL DEFAULT '',
  `trackpage_curbackcolindex` int(11) NOT NULL DEFAULT '0',
  `trackpage_tiptext` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`trackpage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_userextra
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
-- Table structure for t_userheat
-- ----------------------------
DROP TABLE IF EXISTS `t_userheat`;
CREATE TABLE `t_userheat` (
  `userheat_id` int(11) NOT NULL,
  `userheat_detail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userheat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_vendor
-- ----------------------------
DROP TABLE IF EXISTS `t_vendor`;
CREATE TABLE `t_vendor` (
  `vendor_id` int(11) NOT NULL AUTO_INCREMENT,
  `vendor_name` varchar(255) NOT NULL DEFAULT '',
  `vendor_mail` varchar(255) DEFAULT '',
  `vendor_phonenum` varchar(11) NOT NULL DEFAULT '',
  `vendor_pwd` varchar(255) NOT NULL DEFAULT '',
  `vendor_isopen` int(11) NOT NULL DEFAULT '0',
  `vendor_totalmoney` double(11,0) DEFAULT '0',
  `vendor_paidmoney` double(11,0) DEFAULT '0',
  `vendor_remainedmoney` double(11,0) DEFAULT '0',
  `vendor_employernum` int(11) DEFAULT '0',
  `vendor_cooknum` int(11) DEFAULT '0',
  `vendor_detail` varchar(255) DEFAULT '',
  `vendor_shophour_start` datetime NOT NULL,
  `vendor_paytype` int(11) NOT NULL DEFAULT '0',
  `vendor_business_areaid` int(11) NOT NULL,
  `vendor_default_accountid` int(11) NOT NULL,
  `vendor_shophour_end` datetime NOT NULL,
  PRIMARY KEY (`vendor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_vendorextra
-- ----------------------------
DROP TABLE IF EXISTS `t_vendorextra`;
CREATE TABLE `t_vendorextra` (
  `vendorextra_id` int(11) NOT NULL AUTO_INCREMENT,
  `vendor_id` int(11) DEFAULT NULL,
  `vendorextra_name` varchar(255) DEFAULT NULL,
  `vendorextra_regBrand` varchar(255) DEFAULT NULL,
  `vendorextra_regAddress` varchar(255) DEFAULT NULL,
  `vendorextra_validPeriod` varchar(255) DEFAULT NULL,
  `vendorextra_commonAddress` varchar(255) DEFAULT NULL,
  `vendorextra_phoneNumber` varchar(255) DEFAULT NULL,
  `vendorextra_scanningImage` varchar(255) DEFAULT NULL,
  `vendorextra_indenfityFront` varchar(255) DEFAULT NULL,
  `vendorextra_indenfityBack` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vendorextra_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='锟斤拷锟斤拷锟斤拷息';

-- ----------------------------
-- Table structure for t_version
-- ----------------------------
DROP TABLE IF EXISTS `t_version`;
CREATE TABLE `t_version` (
  `version_id` int(11) NOT NULL AUTO_INCREMENT,
  `version_type` int(11) NOT NULL DEFAULT '0',
  `version_info` varchar(255) NOT NULL DEFAULT '',
  `version_loc` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`version_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
