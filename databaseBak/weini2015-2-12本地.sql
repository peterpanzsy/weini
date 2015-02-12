/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : weini

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2015-02-12 11:41:15
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
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('2', 'zsy', 'zsyaaa');
INSERT INTO `t_admin` VALUES ('3', 'cyjaaa', 'cyjaaa');
INSERT INTO `t_admin` VALUES ('4', 'plin', 'plin');
INSERT INTO `t_admin` VALUES ('6', 'root2a', '827CCB0EEA8A706C4C34A16891F84E7B');
INSERT INTO `t_admin` VALUES ('7', 'root', 'root');
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
-- Table structure for t_alipay
-- ----------------------------
DROP TABLE IF EXISTS `t_alipay`;
CREATE TABLE `t_alipay` (
  `alipay_id` int(11) NOT NULL AUTO_INCREMENT,
  `alipay_username` varchar(255) NOT NULL DEFAULT '',
  `alipay_userAccount` varchar(255) NOT NULL DEFAULT '',
  `alipay_userid` int(11) NOT NULL,
  PRIMARY KEY (`alipay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_alipay
-- ----------------------------

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
-- Records of t_authority
-- ----------------------------
INSERT INTO `t_authority` VALUES ('1', 'order', '璁㈠崟绠＄悊');
INSERT INTO `t_authority` VALUES ('2', 'good', '鍟嗗搧绠＄悊');
INSERT INTO `t_authority` VALUES ('3', 'vendor', '鍟嗗?绠＄悊');
INSERT INTO `t_authority` VALUES ('4', 'user', '鐢ㄦ埛绠＄悊');
INSERT INTO `t_authority` VALUES ('5', 'admin', '绠＄悊鍛樿处鎴风?鐞');
INSERT INTO `t_authority` VALUES ('6', 'report', '鎶ヨ〃鏌ョ湅');

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
  `alipay_username` varchar(255) NOT NULL,
  PRIMARY KEY (`bank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bank
-- ----------------------------
INSERT INTO `t_bank` VALUES ('1', '閭瑰瓩棰', '1111111111111', '涓?浗宸ュ晢閾惰?', '浜ゅぇ鏀??', '鍜稿畞瑗胯矾', '0', '1', '');

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
  `box_desc1` varchar(255) NOT NULL,
  `box_desc2` varchar(255) NOT NULL,
  `box_desc3` varchar(255) NOT NULL,
  `box_desc4` varchar(255) NOT NULL,
  `box_type` int(11) NOT NULL,
  `box_typename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`box_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_box
-- ----------------------------
INSERT INTO `t_box` VALUES ('1', '1', '12', '1', 'tupian1', '体验藏在盒子中的美食', '这是说明2', '这是说明2', '这是说明2', '1', '体验1天');
INSERT INTO `t_box` VALUES ('2', '1', '36', '1', 'tupian2', '感叹每天的新奇和与众不同', '这是说明2', '这是说明2', '这是说明2', '3', '体验3天');
INSERT INTO `t_box` VALUES ('3', '1', '60', '1', 'tupian3', '让美妙伴随你一周的工作', '这是说明2', '这是说明2', '这是说明2', '5', '体验5天');

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
  `boxpage_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`boxpage_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_boxpage
-- ----------------------------
INSERT INTO `t_boxpage` VALUES ('1', '味你而在', '理想不死，我们一直在路上', '启程', '每段旅程都有起点，现在开始并不晚', '追寻', '只有勇气才能带你到远方', '执着', '没有一帆风顺的旅途，即使暗夜行路，也有我们为你掌灯', '1');
INSERT INTO `t_boxpage` VALUES ('2', 'aa1', 'bb2', 'cc2', 'dd2', 'ee2', 'ff2', 'gg2', 'hh2', '0');
INSERT INTO `t_boxpage` VALUES ('4', 'aa', 'bb', 'cc', 'dd', 'ee', 'ff', 'gg', 'hh', '0');
INSERT INTO `t_boxpage` VALUES ('5', 'aa', 'bb', 'cc', 'dd', 'ee', 'ff', 'gg', 'hh', '0');

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
-- Records of t_businessarea
-- ----------------------------
INSERT INTO `t_businessarea` VALUES ('1', '西安交通大学', '4');
INSERT INTO `t_businessarea` VALUES ('2', '西安理工大学', '4');
INSERT INTO `t_businessarea` VALUES ('3', '中科院', '4');
INSERT INTO `t_businessarea` VALUES ('4', '清华大学', '4');

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
-- Records of t_city
-- ----------------------------
INSERT INTO `t_city` VALUES ('1', '5', '海淀区');
INSERT INTO `t_city` VALUES ('2', '5', '朝阳区');
INSERT INTO `t_city` VALUES ('3', '3', '西安市');
INSERT INTO `t_city` VALUES ('4', '3', '咸阳市');

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
-- Records of t_consumerecord
-- ----------------------------

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
-- Records of t_cookinfo
-- ----------------------------

-- ----------------------------
-- Table structure for t_dishes
-- ----------------------------
DROP TABLE IF EXISTS `t_dishes`;
CREATE TABLE `t_dishes` (
  `dishes_id` int(11) NOT NULL AUTO_INCREMENT,
  `dishes_name` varchar(255) NOT NULL,
  `dishes_series_1` varchar(255) DEFAULT NULL,
  `dishes_series_2` varchar(255) DEFAULT NULL,
  `dishesWeight` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dishes_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='锟斤拷品锟斤拷';

-- ----------------------------
-- Records of t_dishes
-- ----------------------------
INSERT INTO `t_dishes` VALUES ('1', '黑椒猪扒', '大荤', null, null);
INSERT INTO `t_dishes` VALUES ('2', '青椒鱿鱼', '小荤', null, null);

-- ----------------------------
-- Table structure for t_dispatching
-- ----------------------------
DROP TABLE IF EXISTS `t_dispatching`;
CREATE TABLE `t_dispatching` (
  `dispatching_id` int(11) NOT NULL AUTO_INCREMENT,
  `dispatching_province` int(11) NOT NULL,
  `dispatching_city` int(11) NOT NULL,
  `dispatching_district` int(11) NOT NULL,
  `dispatching_businessAreaid` int(11) NOT NULL,
  `dispatching_officeBuilding` int(11) NOT NULL,
  `dispatching_addressDetail` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `dispatching_phoneNum` varchar(255) DEFAULT '',
  PRIMARY KEY (`dispatching_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dispatching
-- ----------------------------
INSERT INTO `t_dispatching` VALUES ('2', '3', '3', '4', '0', '0', '给将错就错', '1', '18930852101');

-- ----------------------------
-- Table structure for t_dispatchingstatus
-- ----------------------------
DROP TABLE IF EXISTS `t_dispatchingstatus`;
CREATE TABLE `t_dispatchingstatus` (
  `dispatchingStatus_id` int(11) NOT NULL AUTO_INCREMENT,
  `dispatchingStatus_imagename` varchar(255) NOT NULL DEFAULT '',
  `dispatchingStatus_desctext` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`dispatchingStatus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dispatchingstatus
-- ----------------------------
INSERT INTO `t_dispatchingstatus` VALUES ('1', 'aaa.gif', '下锅');
INSERT INTO `t_dispatchingstatus` VALUES ('2', 'bbb.gif', '打包');

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
-- Records of t_district
-- ----------------------------
INSERT INTO `t_district` VALUES ('1', '1', '中关村');
INSERT INTO `t_district` VALUES ('2', '1', '北京村');
INSERT INTO `t_district` VALUES ('3', '4', '碑林区');
INSERT INTO `t_district` VALUES ('4', '4', '长安区');

-- ----------------------------
-- Table structure for t_index
-- ----------------------------
DROP TABLE IF EXISTS `t_index`;
CREATE TABLE `t_index` (
  `index_id` int(11) NOT NULL AUTO_INCREMENT,
  `index_name` varchar(255) NOT NULL,
  `index_value` varchar(255) NOT NULL,
  PRIMARY KEY (`index_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_index
-- ----------------------------
INSERT INTO `t_index` VALUES ('1', 'order_date', '20150211');
INSERT INTO `t_index` VALUES ('2', 'order_num', '82');

-- ----------------------------
-- Table structure for t_legalinfo
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
-- Table structure for t_menuinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_menuinfo`;
CREATE TABLE `t_menuinfo` (
  `menuinfo_id` int(11) NOT NULL AUTO_INCREMENT,
  `menuinfo_name` varchar(255) NOT NULL,
  `vendor_id` int(11) NOT NULL,
  `menuinfo_image1` varchar(255) DEFAULT '',
  `menuinfo_image2` varchar(255) DEFAULT '',
  `menuinfo_image3` varchar(255) DEFAULT '',
  `menuinfo_image4` varchar(255) DEFAULT '',
  `menuinfo_detail` text,
  `menuinfo_date` datetime NOT NULL,
  `menuinfo_status` int(4) NOT NULL DEFAULT '1',
  `menuinfo_point` float DEFAULT '0',
  `menuinfo_western` int(11) NOT NULL DEFAULT '0',
  `menuinfo_type` int(11) NOT NULL DEFAULT '0',
  `menuinfo_consumernum` int(11) DEFAULT '0',
  `menuinfo_bussinessAreaID` int(11) NOT NULL DEFAULT '-1',
  PRIMARY KEY (`menuinfo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menuinfo
-- ----------------------------
INSERT INTO `t_menuinfo` VALUES ('1', '肉夹馍', '1', 'uploads\\goodsPic\\5036d668893247628db64e72a436dff5.jpg', 'uploads\\goodsPic\\f743ba4b6f7c43ce9d52386f4440638e.jpg', 'uploads\\goodsPic\\43a9245dc21c4ef39d80bb2880998736.jpg', 'uploads\\goodsPic\\f1d4db3f49294edd865e78491a00232b.jpg', 'fasdfasd', '2015-01-21 14:08:38', '1', '0', '1', '4', '0', '1');
INSERT INTO `t_menuinfo` VALUES ('2', '鸡排饭', '2', 'uploads\\goodsPic\\2fd18adf9a1349b7a6b53d4a1f2094ef.jpg', 'uploads\\goodsPic\\624bf8d38c41473e9d6fae829f0ce30b.jpg', 'uploads\\goodsPic\\6115260bb4874e5ba2a37325e33db327.jpg', 'uploads\\goodsPic\\4c785f09c0214b1c8ad7a7b215744610.jpg', 'fasd', '2015-01-21 09:53:16', '1', '0', '1', '2', '0', '1');
INSERT INTO `t_menuinfo` VALUES ('3', '户县软面', '3', 'uploads\\goodsPic\\f46e79de09c4461287808320af9a7464.jpg', 'uploads\\goodsPic\\b0872d74acec4037a7b17346c8ec231a.jpg', 'uploads\\goodsPic\\4ed5eeeb4a79422e9bba0d044f6d4bef.jpg', 'uploads\\goodsPic\\0a12dca8dcd64270954544585aa99d42.jpg', 'fasd', '2015-01-21 09:19:26', '1', '0', '0', '3', '0', '1');
INSERT INTO `t_menuinfo` VALUES ('5', '鸡排饭123', '2', 'uploads\\goodsPic\\17cff0daeac74c4c869d352012af772e.jpg', 'uploads\\goodsPic\\660d9d302a52421fb2835c03a1fcc83b.jpg', 'uploads\\goodsPic\\04080fe492a84fba9cf97b24c267d87b.jpg', 'uploads\\goodsPic\\62f879a596ac4dbeb363c0099caee995.jpg', 'fffffffffffffffff', '2015-01-21 14:39:59', '1', '0', '1', '1', '0', '1');
INSERT INTO `t_menuinfo` VALUES ('6', '鱼香肉丝', '2', 'uploads\\goodsPic\\9668d259453747d2b926b1e7272a9a6d.jpg', 'uploads\\goodsPic\\149eb5c07cc947228299fbac294dfabf.jpg', 'uploads\\goodsPic\\90fb5281e2374411851a30cbc729c5b5.jpg', 'uploads\\goodsPic\\026224b6721348c5bfe1cfc2947a8d6c.jpg', 'fasd', '2015-01-21 09:56:53', '0', '0', '0', '1', '0', '1');
INSERT INTO `t_menuinfo` VALUES ('7', '凉皮', '2', null, null, null, null, null, '2014-12-20 17:07:34', '1', '0', '1', '1', '0', '-1');
INSERT INTO `t_menuinfo` VALUES ('8', '小盘鸡', '3', null, null, null, null, null, '2014-12-20 17:07:37', '1', '0', '0', '1', '0', '-1');
INSERT INTO `t_menuinfo` VALUES ('10', '盖浇饭', '3', null, null, null, null, null, '2014-12-20 17:07:42', '1', '0', '0', '1', '0', '-1');
INSERT INTO `t_menuinfo` VALUES ('11', '糖醋里脊', '1', null, null, null, null, null, '2014-12-20 17:07:09', '1', '0', '0', '1', '0', '-1');
INSERT INTO `t_menuinfo` VALUES ('12', '', '-1', '', '', '', '', '', '2015-01-21 13:32:34', '1', '0', '0', '1', '0', '-1');
INSERT INTO `t_menuinfo` VALUES ('13', '', '-1', '', '', '', '', '', '2015-01-21 13:32:40', '1', '0', '0', '1', '0', '-1');
INSERT INTO `t_menuinfo` VALUES ('14', '', '-1', '', '', '', '', '', '2015-01-21 13:32:57', '1', '0', '1', '1', '0', '-1');
INSERT INTO `t_menuinfo` VALUES ('15', 'fasd', '-1', '', '', '', '', '', '2015-01-21 13:41:55', '1', '0', '0', '1', '0', '-1');
INSERT INTO `t_menuinfo` VALUES ('16', '', '-1', '', '', '', '', '', '2015-01-21 13:46:11', '1', '0', '0', '1', '0', '-1');
INSERT INTO `t_menuinfo` VALUES ('17', 'fasdafds', '-1', 'uploads\\goodsPic\\e5e4ef3e92d64047bce14dcad5e80b39.jpg', '', '', '', '', '2015-01-21 13:46:28', '1', '0', '0', '1', '0', '-1');
INSERT INTO `t_menuinfo` VALUES ('18', 'fasdfas', '-1', 'uploads\\goodsPic\\268e8ffd043c44a0b555ba624ae9407d.jpg', '', '', '', '', '2015-01-21 13:58:00', '1', '0', '0', '1', '0', '-1');
INSERT INTO `t_menuinfo` VALUES ('19', 'fsdasdf', '-1', '', 'uploads\\goodsPic\\bbe19367e61342199ae32a96e61fbc57.jpg', '', '', 'fasda', '2015-01-21 13:58:21', '1', '0', '0', '1', '0', '-1');

-- ----------------------------
-- Table structure for t_menutype
-- ----------------------------
DROP TABLE IF EXISTS `t_menutype`;
CREATE TABLE `t_menutype` (
  `menutype_id` int(11) NOT NULL AUTO_INCREMENT,
  `menutype_desc` varchar(255) NOT NULL,
  PRIMARY KEY (`menutype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menutype
-- ----------------------------
INSERT INTO `t_menutype` VALUES ('1', '鸡肉');
INSERT INTO `t_menutype` VALUES ('2', '猪肉');
INSERT INTO `t_menutype` VALUES ('3', '鱼肉');
INSERT INTO `t_menutype` VALUES ('4', '猪肉');

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
-- Records of t_menu_cookinfo
-- ----------------------------

-- ----------------------------
-- Table structure for t_menu_dishes
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_dishes`;
CREATE TABLE `t_menu_dishes` (
  `menu_dishes_id` int(11) NOT NULL AUTO_INCREMENT,
  `menuinfo_id` int(11) NOT NULL,
  `dishes_id` int(11) NOT NULL,
  `dishes_weight` varchar(255) DEFAULT '0',
  PRIMARY KEY (`menu_dishes_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu_dishes
-- ----------------------------
INSERT INTO `t_menu_dishes` VALUES ('1', '1', '1', '100克');
INSERT INTO `t_menu_dishes` VALUES ('2', '1', '2', '600毫克');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_officebuilding
-- ----------------------------
INSERT INTO `t_officebuilding` VALUES ('1', '1', '1', '10.2', '11.3', '交大校区男生宿舍楼D栋');
INSERT INTO `t_officebuilding` VALUES ('2', '2', null, null, null, null);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_num` varchar(255) NOT NULL DEFAULT '',
  `user_id` int(11) NOT NULL,
  `order_menuinfo_id` int(11) NOT NULL,
  `box_id` int(11) NOT NULL,
  `order_startTime` datetime NOT NULL,
  `order_orderTime` datetime NOT NULL,
  `order_payStatus` int(11) NOT NULL,
  `S_order_ConsumeStatus` int(11) NOT NULL,
  `order_payTime` datetime DEFAULT NULL,
  `box_price` float NOT NULL,
  `order_isFirst` int(11) NOT NULL,
  `order_dispatching_id` int(11) NOT NULL,
  `order_settleStatus` int(11) NOT NULL,
  `order_status` int(11) NOT NULL,
  `order_notice` varchar(255) DEFAULT '',
  PRIMARY KEY (`order_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_orderrefund
-- ----------------------------
DROP TABLE IF EXISTS `t_orderrefund`;
CREATE TABLE `t_orderrefund` (
  `orderrefund_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_num` varchar(255) NOT NULL,
  `orderrefund_reason` int(11) NOT NULL,
  `orderrefund_status` int(11) NOT NULL,
  `orderrefund_result` int(11) NOT NULL,
  PRIMARY KEY (`orderrefund_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_orderrefund
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_point
-- ----------------------------

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
-- Records of t_pointactivity
-- ----------------------------

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
-- Records of t_pointexchange
-- ----------------------------

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
-- Records of t_province
-- ----------------------------
INSERT INTO `t_province` VALUES ('2', '上海市');
INSERT INTO `t_province` VALUES ('3', '西安市');
INSERT INTO `t_province` VALUES ('4', '河南市');
INSERT INTO `t_province` VALUES ('5', '北京市');

-- ----------------------------
-- Table structure for t_refundreason
-- ----------------------------
DROP TABLE IF EXISTS `t_refundreason`;
CREATE TABLE `t_refundreason` (
  `refundreason_id` int(11) NOT NULL AUTO_INCREMENT,
  `refundreason_desc` varchar(255) DEFAULT '',
  PRIMARY KEY (`refundreason_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_refundreason
-- ----------------------------
INSERT INTO `t_refundreason` VALUES ('1', '不好吃');
INSERT INTO `t_refundreason` VALUES ('2', '不喜欢盒子模式');
INSERT INTO `t_refundreason` VALUES ('3', '太贵');
INSERT INTO `t_refundreason` VALUES ('4', '其他');

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
-- Records of t_registeraddress
-- ----------------------------

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
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'root');
INSERT INTO `t_role` VALUES ('2', 'finance_admin');
INSERT INTO `t_role` VALUES ('3', 'good_admin');
INSERT INTO `t_role` VALUES ('4', 'ordinary_admin');

-- ----------------------------
-- Table structure for t_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_role_authority`;
CREATE TABLE `t_role_authority` (
  `role_authority_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_authority_roleid` int(11) NOT NULL,
  `role_authority_authorityid` int(11) NOT NULL,
  PRIMARY KEY (`role_authority_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

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
INSERT INTO `t_role_authority` VALUES ('25', '1', '6');
INSERT INTO `t_role_authority` VALUES ('27', '2', '5');
INSERT INTO `t_role_authority` VALUES ('28', '4', '1');
INSERT INTO `t_role_authority` VALUES ('29', '4', '2');
INSERT INTO `t_role_authority` VALUES ('30', '4', '5');
INSERT INTO `t_role_authority` VALUES ('31', '4', '3');
INSERT INTO `t_role_authority` VALUES ('32', '4', '4');
INSERT INTO `t_role_authority` VALUES ('35', '1', '1');
INSERT INTO `t_role_authority` VALUES ('36', '1', '3');
INSERT INTO `t_role_authority` VALUES ('37', '2', '2');

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
-- Records of t_settle
-- ----------------------------

-- ----------------------------
-- Table structure for t_sorder_dispatching
-- ----------------------------
DROP TABLE IF EXISTS `t_sorder_dispatching`;
CREATE TABLE `t_sorder_dispatching` (
  `sorderdispatching_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_order_id` int(11) NOT NULL,
  `dispatchingstatus_id` int(11) NOT NULL,
  `status_time` datetime NOT NULL,
  PRIMARY KEY (`sorderdispatching_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sorder_dispatching
-- ----------------------------

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
  `startpage_phonetype` int(11) NOT NULL,
  PRIMARY KEY (`startpage_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_startpageinfo
-- ----------------------------
INSERT INTO `t_startpageinfo` VALUES ('1', '1', '2015-01-29 21:45:18', '2015-01-29 21:45:21', 'XXXXXXXX', '0');

-- ----------------------------
-- Table structure for t_s_order
-- ----------------------------
DROP TABLE IF EXISTS `t_s_order`;
CREATE TABLE `t_s_order` (
  `S_order_id` int(11) NOT NULL AUTO_INCREMENT,
  `F_order_num` varchar(255) NOT NULL DEFAULT '',
  `menu_id` int(11) NOT NULL,
  `S_order_whichday` int(11) NOT NULL,
  `S_order_consumeEvaluate` varchar(255) DEFAULT NULL,
  `S_order_dispatchingDate` date NOT NULL,
  `S_order_logisticsEvaluate` varchar(255) DEFAULT NULL,
  `S_order_predictTime` datetime DEFAULT NULL,
  `S_order_isdispatchingStateOpen` int(11) NOT NULL,
  `S_order_notice` varchar(255) DEFAULT NULL,
  `S_order_dispatchingID` int(11) NOT NULL,
  `S_order_status` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`S_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_trackpage
-- ----------------------------
DROP TABLE IF EXISTS `t_trackpage`;
CREATE TABLE `t_trackpage` (
  `trackpage_id` int(11) NOT NULL AUTO_INCREMENT,
  `trackpage_currentstate` varchar(255) NOT NULL DEFAULT '',
  `trackpage_curbackcolindex` int(11) NOT NULL DEFAULT '0',
  `trackpage_tiptext` varchar(255) NOT NULL DEFAULT '',
  `trackpage_startTime` datetime NOT NULL,
  `trackpage_endTime` datetime NOT NULL,
  PRIMARY KEY (`trackpage_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_trackpage
-- ----------------------------
INSERT INTO `t_trackpage` VALUES ('1', '食材送达', '0', '“新鲜”是一种态度', '2015-02-06 06:15:00', '2015-02-06 06:45:00');
INSERT INTO `t_trackpage` VALUES ('2', '你好早安', '4', '理想与你的距离 取决于你离开被窝的速度', '2015-02-11 06:45:00', '2015-02-16 07:59:00');
INSERT INTO `t_trackpage` VALUES ('3', '疯狂清洗', '4', '在这嘈杂的城市 为你寻回一片纯净', '2015-02-06 08:00:00', '2015-02-06 08:59:00');
INSERT INTO `t_trackpage` VALUES ('4', '创意拼菜', '0', '食物的世界 只有想不到 没有不可能', '2015-02-09 09:00:00', '2015-02-06 09:59:00');
INSERT INTO `t_trackpage` VALUES ('5', '大厨交响', '0', '一种味道 百样人生', '2015-02-06 10:00:00', '2015-02-06 11:20:00');
INSERT INTO `t_trackpage` VALUES ('6', '美味启程', '0', '虽然明天充满未知 但温暖会如期而至', '2015-02-06 11:20:00', '2015-02-06 12:59:00');
INSERT INTO `t_trackpage` VALUES ('7', '用心品味', '0', '只能给你 四季不变的守候', '2015-02-06 13:00:00', '2015-02-06 23:59:00');
INSERT INTO `t_trackpage` VALUES ('8', '用心品味', '0', '只能给你 四季不变的守候', '2015-02-06 00:00:00', '2015-02-06 06:15:00');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL DEFAULT '',
  `user_pwd` varchar(255) DEFAULT '',
  `user_gender` int(11) DEFAULT '0',
  `user_address` varchar(255) DEFAULT '',
  `user_phoneNumber` varchar(11) DEFAULT '',
  `user_phoneType` int(11) DEFAULT '-1',
  `user_scale` int(11) DEFAULT '-1',
  `user_bank_default` int(11) DEFAULT '-1',
  `user_alipay_default` int(11) DEFAULT '-1',
  `user_weChatPay` varchar(255) DEFAULT '',
  `user_point_default` int(11) DEFAULT '0',
  `user_regdate` date NOT NULL,
  `user_heat` int(11) DEFAULT '-1',
  `user_dispatchdefault_id` int(11) DEFAULT '-1',
  `user_appetite` int(11) DEFAULT '1',
  `user_pungent` int(11) DEFAULT '1',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '味你新用户', '1111111', '-1', null, '18930852101', '-1', '-1', '-1', '-1', null, '-1', '2015-02-11', '-1', '-1', '1', null);

-- ----------------------------
-- Table structure for t_userextra
-- ----------------------------
DROP TABLE IF EXISTS `t_userextra`;
CREATE TABLE `t_userextra` (
  `userextra_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `userextra_image` varchar(255) DEFAULT '',
  `userextra_reserved` varchar(255) DEFAULT '',
  `userextra_birthday` date DEFAULT NULL,
  PRIMARY KEY (`userextra_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_userextra
-- ----------------------------
INSERT INTO `t_userextra` VALUES ('1', '1', null, null, null);

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
-- Records of t_vendor
-- ----------------------------
INSERT INTO `t_vendor` VALUES ('1', 'pl', '1234@qq.com', '123132', '1231', '0', null, null, null, null, null, null, '0000-00-00 00:00:00', '0', '3', '0', '0000-00-00 00:00:00');
INSERT INTO `t_vendor` VALUES ('2', 'zsy', '1234', '465456', '', '0', null, null, null, null, null, null, '0000-00-00 00:00:00', '0', '3', '0', '0000-00-00 00:00:00');
INSERT INTO `t_vendor` VALUES ('3', 'cyj', '1324', '456465', '', '0', null, null, null, null, null, null, '0000-00-00 00:00:00', '0', '2', '0', '0000-00-00 00:00:00');
INSERT INTO `t_vendor` VALUES ('4', 'pl', '12313', '1231', '123', '0', '0', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '0', '0', '0', '0000-00-00 00:00:00');

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
-- Records of t_vendorextra
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_version
-- ----------------------------
INSERT INTO `t_version` VALUES ('1', '1', 'V1.0.1', 'http://www.baidu.com');
INSERT INTO `t_version` VALUES ('2', '1', 'V1.0.2', 'http://www.baidu.com');
INSERT INTO `t_version` VALUES ('3', '1', 'V1.0.3', 'http://www.baidu.com');
