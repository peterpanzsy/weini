/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : weini

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2014-12-11 10:52:47
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `vendor_remianedmoney` int(11) DEFAULT NULL,
  `vendor_employernum` int(11) DEFAULT NULL,
  `vendor_cooknum` int(11) DEFAULT NULL,
  `vendor_detail` varchar(255) DEFAULT NULL,
  `vendor_shophour` datetime DEFAULT NULL,
  `vendor_paytype` int(11) DEFAULT NULL,
  `vendor_default_accountid` int(11) DEFAULT NULL,
  PRIMARY KEY (`vendor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_vendor
-- ----------------------------
