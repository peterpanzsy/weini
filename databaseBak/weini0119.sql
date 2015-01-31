/*
SQLyog Community v10.3 
MySQL - 5.0.18 : Database - weini
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`weini` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `weini`;

/*Table structure for table `t_admin` */

DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (
  `admin_id` int(11) NOT NULL auto_increment,
  `admin_username` varchar(255) default NULL,
  `admin_pwd` varchar(255) default NULL,
  PRIMARY KEY  (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_admin` */

insert  into `t_admin`(`admin_id`,`admin_username`,`admin_pwd`) values (2,'zsy','zsyaaa'),(3,'cyjaaa','cyjaaa'),(4,'plin','plin'),(6,'root2a','0B4E7A0E5FE84AD35FB5F95B9CEEAC79'),(7,'root1','root1'),(8,'root1','root1'),(10,'root1','root1'),(15,'root1','root1'),(18,'zsy','zsy'),(20,'zsy','aaaaaa'),(21,'cccc','ccccccccc'),(22,'ddd','dddddd'),(24,'gege','gegege'),(25,'zouge','A4D37957C001A8F5F696171D2CF55E2E'),(26,'root','21232F297A57A5A743894A0E4A801FC3'),(27,'zsy','21232F297A57A5A743894A0E4A801FC3');

/*Table structure for table `t_admin_role` */

DROP TABLE IF EXISTS `t_admin_role`;

CREATE TABLE `t_admin_role` (
  `admin_role_id` int(11) NOT NULL auto_increment,
  `admin_role_adminid` int(11) default NULL,
  `admin_role_roleid` int(11) default NULL,
  PRIMARY KEY  (`admin_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_admin_role` */

insert  into `t_admin_role`(`admin_role_id`,`admin_role_adminid`,`admin_role_roleid`) values (2,2,4),(3,3,2),(4,4,3),(6,6,1),(7,7,1),(8,8,1),(9,9,1),(11,7,1),(12,8,1),(13,9,1),(14,10,1),(19,15,1),(25,18,1),(27,20,1),(28,21,1),(29,22,1),(31,24,4),(32,25,1),(33,26,1),(34,27,3);

/*Table structure for table `t_alipay` */

DROP TABLE IF EXISTS `t_alipay`;

CREATE TABLE `t_alipay` (
  `alipay_id` int(11) NOT NULL auto_increment,
  `alipay_username` varchar(255) default NULL,
  `alipay_userAccount` varchar(255) default NULL,
  `alipay_userid` int(11) default NULL,
  PRIMARY KEY  (`alipay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_alipay` */

insert  into `t_alipay`(`alipay_id`,`alipay_username`,`alipay_userAccount`,`alipay_userid`) values (1,'邹孙颖','15829675981',1);

/*Table structure for table `t_authority` */

DROP TABLE IF EXISTS `t_authority`;

CREATE TABLE `t_authority` (
  `authority_id` int(11) NOT NULL auto_increment,
  `authority_name` varchar(255) default NULL,
  `authority_remark` varchar(255) default NULL,
  PRIMARY KEY  (`authority_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_authority` */

insert  into `t_authority`(`authority_id`,`authority_name`,`authority_remark`) values (1,'order','订单管理'),(2,'good','商品管理'),(3,'vendor','商家管理'),(4,'user','用户管理'),(5,'admin','管理员账户管理'),(6,'report','报表查看');

/*Table structure for table `t_bank` */

DROP TABLE IF EXISTS `t_bank`;

CREATE TABLE `t_bank` (
  `bank_id` int(11) NOT NULL auto_increment,
  `bank_username` varchar(255) default NULL,
  `bank_cardNumber` varchar(255) default NULL,
  `bank_bankname` varchar(255) default NULL,
  `bank_sub_bankname` varchar(255) default NULL,
  `bank_sub_bankAddress` varchar(255) default NULL,
  `bank_userType` int(11) default NULL,
  `bank_userid` int(11) default NULL,
  PRIMARY KEY  (`bank_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_bank` */

insert  into `t_bank`(`bank_id`,`bank_username`,`bank_cardNumber`,`bank_bankname`,`bank_sub_bankname`,`bank_sub_bankAddress`,`bank_userType`,`bank_userid`) values (1,'邹孙颖','1111111111111','中国工商银行','交大支行','咸宁西路',NULL,1);

/*Table structure for table `t_box` */

DROP TABLE IF EXISTS `t_box`;

CREATE TABLE `t_box` (
  `box_id` int(11) NOT NULL auto_increment,
  `bussinessarea_id` int(11) default NULL,
  `box_type` int(11) default NULL,
  `box_gender` int(11) default NULL,
  `box_price` float default NULL,
  `box_cityid` int(11) default NULL,
  PRIMARY KEY  (`box_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_box` */

insert  into `t_box`(`box_id`,`bussinessarea_id`,`box_type`,`box_gender`,`box_price`,`box_cityid`) values (1,1,2,3,12,1),(2,1,3,3,12.9,1),(3,2,2,NULL,13.9,1),(4,3,2,NULL,14,1),(5,4,2,NULL,15,1);

/*Table structure for table `t_boxtype` */

DROP TABLE IF EXISTS `t_boxtype`;

CREATE TABLE `t_boxtype` (
  `typeid` int(11) NOT NULL auto_increment,
  `desc1` varchar(255) default NULL,
  `desc2` varchar(255) default NULL,
  `desc3` varchar(255) default NULL,
  `desc4` varchar(255) default NULL,
  `typename` varchar(255) default NULL,
  `time` int(11) default NULL,
  PRIMARY KEY  (`typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_boxtype` */

insert  into `t_boxtype`(`typeid`,`desc1`,`desc2`,`desc3`,`desc4`,`typename`,`time`) values (1,'体验藏在盒子中的美食','这是说明','这是说明','这是说明','体验1天',1),(2,'感叹每天的新奇和与众不同','这是说明','这是说明','这是说明','午餐3天',3),(3,'让美妙伴随你一周的工作','这是说明','这是说明','这是说明','午餐5天',5);

/*Table structure for table `t_bssinfo` */

DROP TABLE IF EXISTS `t_bssinfo`;

CREATE TABLE `t_bssinfo` (
  `bssinfo_id` int(11) NOT NULL auto_increment,
  `bssinfo` varchar(255) default NULL,
  `bssinfo_mail` varchar(255) default NULL,
  `bssinfo_phonenum` varchar(11) default NULL,
  `bssinfo_pwd` varchar(255) default NULL,
  `bssinfo_isopen` tinyint(1) default NULL,
  `bssinfo_totalmoney` int(11) default NULL,
  `bssinfo_paidmoney` int(11) default NULL,
  `bssinfo_remianedmoney` int(11) default NULL,
  `bssinfo_employernum` int(11) default NULL,
  `bssinfo_cooknum` int(11) default NULL,
  `bssinfo_detail` varchar(255) default NULL,
  `bssinfo_shophour` datetime default NULL,
  `bssinfo_paytype` int(11) default NULL,
  `bssinfo_default_accountid` int(11) default NULL,
  PRIMARY KEY  (`bssinfo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_bssinfo` */

/*Table structure for table `t_businessarea` */

DROP TABLE IF EXISTS `t_businessarea`;

CREATE TABLE `t_businessarea` (
  `businessArea_id` int(11) NOT NULL auto_increment,
  `businessArea_name` varchar(255) default NULL,
  `district_id` int(11) default NULL,
  PRIMARY KEY  (`businessArea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_businessarea` */

insert  into `t_businessarea`(`businessArea_id`,`businessArea_name`,`district_id`) values (1,'交大商圈',1),(2,'都市之门',1),(3,'汇鑫BCD',1),(4,'绿地世纪城',1);

/*Table structure for table `t_city` */

DROP TABLE IF EXISTS `t_city`;

CREATE TABLE `t_city` (
  `city_id` int(11) NOT NULL auto_increment,
  `province_id` int(11) default NULL,
  `city_name` varchar(255) default NULL,
  PRIMARY KEY  (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_city` */

insert  into `t_city`(`city_id`,`province_id`,`city_name`) values (1,1,'西安'),(2,2,'咸阳'),(3,3,'渭南');

/*Table structure for table `t_consumerecord` */

DROP TABLE IF EXISTS `t_consumerecord`;

CREATE TABLE `t_consumerecord` (
  `consumeRecord_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `pointExchange_id` int(11) default NULL,
  `consumeRecord_time` datetime default NULL,
  `consumeRecord_userid` int(11) default NULL,
  PRIMARY KEY  (`consumeRecord_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_consumerecord` */

/*Table structure for table `t_cookinfo` */

DROP TABLE IF EXISTS `t_cookinfo`;

CREATE TABLE `t_cookinfo` (
  `cookinfo_id` int(11) NOT NULL auto_increment,
  `cookinfo_name` varchar(255) default NULL,
  `cookinfo_image` varchar(255) default NULL,
  `cookinfo_businfoid` int(11) default NULL,
  PRIMARY KEY  (`cookinfo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_cookinfo` */

/*Table structure for table `t_dishes` */

DROP TABLE IF EXISTS `t_dishes`;

CREATE TABLE `t_dishes` (
  `dishes_id` int(11) NOT NULL auto_increment,
  `dishes_name` varchar(255) default NULL,
  `dishes_series_1` varchar(255) default NULL,
  `dishes_series_2` varchar(255) default NULL,
  PRIMARY KEY  (`dishes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��Ʒ��';

/*Data for the table `t_dishes` */

/*Table structure for table `t_dispatching` */

DROP TABLE IF EXISTS `t_dispatching`;

CREATE TABLE `t_dispatching` (
  `dispatching_id` int(11) NOT NULL auto_increment,
  `dispatching_province` varchar(255) default NULL,
  `dispatching_city` varchar(255) default NULL,
  `dispatching_businessAreaid` int(11) default NULL,
  `dispatching_officeBuilding` varchar(255) default NULL,
  `dispatching_addressDetail` varchar(255) default NULL,
  PRIMARY KEY  (`dispatching_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_dispatching` */

insert  into `t_dispatching`(`dispatching_id`,`dispatching_province`,`dispatching_city`,`dispatching_businessAreaid`,`dispatching_officeBuilding`,`dispatching_addressDetail`) values (1,'陕西','西安',1,'2','东2');

/*Table structure for table `t_dispatchingstatus` */

DROP TABLE IF EXISTS `t_dispatchingstatus`;

CREATE TABLE `t_dispatchingstatus` (
  `dispatchingStatus_id` int(11) NOT NULL auto_increment,
  `dispatchingStatus_name` varchar(255) default NULL,
  PRIMARY KEY  (`dispatchingStatus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_dispatchingstatus` */

insert  into `t_dispatchingstatus`(`dispatchingStatus_id`,`dispatchingStatus_name`) values (1,'已送达');

/*Table structure for table `t_district` */

DROP TABLE IF EXISTS `t_district`;

CREATE TABLE `t_district` (
  `district_id` int(11) NOT NULL auto_increment,
  `city_id` int(11) default NULL,
  `district_name` varchar(255) default NULL,
  PRIMARY KEY  (`district_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_district` */

insert  into `t_district`(`district_id`,`city_id`,`district_name`) values (1,1,'碑林区');

/*Table structure for table `t_legalinfo` */

DROP TABLE IF EXISTS `t_legalinfo`;

CREATE TABLE `t_legalinfo` (
  `legalinfo_id` int(11) NOT NULL auto_increment,
  `bssinfo_id` int(11) default NULL,
  `legalinfo_name` varchar(255) default NULL,
  `legalinfo_regBrand` varchar(255) default NULL,
  `legalinfo_regAddress` varchar(255) default NULL,
  `legalinfo_validPeriod` varchar(255) default NULL,
  `legalinfo_commonAddress` varchar(255) default NULL,
  `legalinfo_phoneNumber` varchar(255) default NULL,
  `legalinfo_scanningImage` varchar(255) default NULL,
  `legalinfo_indenfityFront` varchar(255) default NULL,
  `legalinfo_indenfityBack` varchar(255) default NULL,
  PRIMARY KEY  (`legalinfo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='������Ϣ';

/*Data for the table `t_legalinfo` */

/*Table structure for table `t_menu_cookinfo` */

DROP TABLE IF EXISTS `t_menu_cookinfo`;

CREATE TABLE `t_menu_cookinfo` (
  `menu_cookinfoid` int(11) NOT NULL auto_increment,
  `menuinfo_id` int(11) default NULL,
  `cookinfo_id` int(11) default NULL,
  PRIMARY KEY  (`menu_cookinfoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_menu_cookinfo` */

/*Table structure for table `t_menu_dishes` */

DROP TABLE IF EXISTS `t_menu_dishes`;

CREATE TABLE `t_menu_dishes` (
  `menu_dishes_id` int(11) NOT NULL auto_increment,
  `menuinfo_id` int(11) default NULL,
  `dishes_id` int(11) default NULL,
  PRIMARY KEY  (`menu_dishes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_menu_dishes` */

/*Table structure for table `t_menuinfo` */

DROP TABLE IF EXISTS `t_menuinfo`;

CREATE TABLE `t_menuinfo` (
  `menuinfo_id` int(11) NOT NULL,
  `bussinfo_id` int(11) default NULL,
  `menuinfo_image1` varchar(255) default NULL,
  `menuinfo_image2` varchar(255) default NULL,
  `menuinfo_image3` varchar(255) default NULL,
  `menuinfo_image4` varchar(255) default NULL,
  `menuinfo_detail` text,
  `menuinfo_name` varchar(255) default NULL,
  PRIMARY KEY  (`menuinfo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_menuinfo` */

insert  into `t_menuinfo`(`menuinfo_id`,`bussinfo_id`,`menuinfo_image1`,`menuinfo_image2`,`menuinfo_image3`,`menuinfo_image4`,`menuinfo_detail`,`menuinfo_name`) values (1,NULL,NULL,NULL,NULL,NULL,NULL,'意大利面'),(2,NULL,NULL,NULL,NULL,NULL,NULL,'土豆烧牛腩'),(3,NULL,NULL,NULL,NULL,NULL,NULL,'宫保鸡丁');

/*Table structure for table `t_officebuilding` */

DROP TABLE IF EXISTS `t_officebuilding`;

CREATE TABLE `t_officebuilding` (
  `officeBuilding_id` int(11) NOT NULL auto_increment,
  `businessArea_id` int(11) default NULL,
  `officeBuilding_longitude` float default NULL,
  `officeBuilding_latitude` float default NULL,
  `officeBuilding_radius` float default NULL,
  `officeBuilding_name` varchar(255) default NULL,
  PRIMARY KEY  (`officeBuilding_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_officebuilding` */

insert  into `t_officebuilding`(`officeBuilding_id`,`businessArea_id`,`officeBuilding_longitude`,`officeBuilding_latitude`,`officeBuilding_radius`,`officeBuilding_name`) values (1,1,1,1,1,'仲英'),(2,1,2,2,2,'南洋'),(5,1,3,3,3,'彭康'),(6,2,4,4,4,'都市之门A座'),(7,2,5,5,5,'都市之门B座'),(8,2,6,6,6,'都市之门C座'),(9,2,7,7,7,'都市之门D座');

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `order_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `box_id` int(11) default NULL,
  `order_startTime` datetime default NULL,
  `order_orderTime` datetime default NULL,
  `order_payStatus` int(11) default NULL,
  `S_order_consumeStatus` int(11) default NULL,
  `order_isRefund` tinyint(1) default NULL,
  `order_payTime` datetime default NULL,
  `box_price` float default NULL,
  PRIMARY KEY  (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_order` */

insert  into `t_order`(`order_id`,`user_id`,`box_id`,`order_startTime`,`order_orderTime`,`order_payStatus`,`S_order_consumeStatus`,`order_isRefund`,`order_payTime`,`box_price`) values (1,1,1,'2015-01-02 09:42:38','2015-01-03 09:42:48',0,NULL,NULL,NULL,NULL);

/*Table structure for table `t_point` */

DROP TABLE IF EXISTS `t_point`;

CREATE TABLE `t_point` (
  `point_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `point_first` int(11) default NULL,
  `point_activity` int(11) default NULL,
  `point_confirm` int(11) default NULL,
  `point_expenditure` int(11) default NULL,
  `point_total` int(11) default NULL,
  PRIMARY KEY  (`point_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_point` */

insert  into `t_point`(`point_id`,`user_id`,`point_first`,`point_activity`,`point_confirm`,`point_expenditure`,`point_total`) values (1,1,11,NULL,NULL,NULL,12);

/*Table structure for table `t_pointactivity` */

DROP TABLE IF EXISTS `t_pointactivity`;

CREATE TABLE `t_pointactivity` (
  `pointActivity_id` int(11) NOT NULL auto_increment,
  `pointActivity_city` varchar(255) default NULL,
  `pointActivity_times` int(11) default NULL,
  PRIMARY KEY  (`pointActivity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_pointactivity` */

/*Table structure for table `t_pointexchange` */

DROP TABLE IF EXISTS `t_pointexchange`;

CREATE TABLE `t_pointexchange` (
  `pointExchange_id` int(11) NOT NULL auto_increment,
  `pointExchange_describe` text,
  `pointExchange_needPoint` float default NULL,
  `pointExchange_imageAddress` varchar(255) default NULL,
  `pointExchange_canExchange` tinyint(1) default NULL,
  `pointExchange_startT` datetime default NULL,
  `pointExchange_endT` datetime default NULL,
  PRIMARY KEY  (`pointExchange_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_pointexchange` */

/*Table structure for table `t_province` */

DROP TABLE IF EXISTS `t_province`;

CREATE TABLE `t_province` (
  `province_id` int(11) NOT NULL auto_increment,
  `province_name` varchar(255) default NULL,
  PRIMARY KEY  (`province_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_province` */

insert  into `t_province`(`province_id`,`province_name`) values (1,'陕西');

/*Table structure for table `t_registeraddress` */

DROP TABLE IF EXISTS `t_registeraddress`;

CREATE TABLE `t_registeraddress` (
  `registerAddress_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `registerAddress_detail` varchar(255) default NULL,
  `registerAddress_businessAreaid` int(11) default NULL,
  PRIMARY KEY  (`registerAddress_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_registeraddress` */

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `role_id` int(11) NOT NULL auto_increment,
  `role_name` varchar(255) default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

insert  into `t_role`(`role_id`,`role_name`) values (1,'root'),(2,'finance_admin'),(3,'good_admin'),(4,'ordinary_admin');

/*Table structure for table `t_role_authority` */

DROP TABLE IF EXISTS `t_role_authority`;

CREATE TABLE `t_role_authority` (
  `role_authority_id` int(11) NOT NULL auto_increment,
  `role_authority_roleid` int(11) default NULL,
  `role_authority_authorityid` int(11) default NULL,
  PRIMARY KEY  (`role_authority_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_role_authority` */

insert  into `t_role_authority`(`role_authority_id`,`role_authority_roleid`,`role_authority_authorityid`) values (2,1,2),(4,1,4),(5,1,5),(7,3,2),(9,2,6),(10,3,2),(11,4,6),(24,1,1),(25,1,6),(26,1,3),(27,2,5),(28,4,1),(29,4,2),(30,4,5),(31,4,3);

/*Table structure for table `t_s_order` */

DROP TABLE IF EXISTS `t_s_order`;

CREATE TABLE `t_s_order` (
  `S_order_id` int(11) NOT NULL auto_increment,
  `F_order_id` int(11) default NULL,
  `dispatching_id` int(11) default NULL,
  `dispatchingStatus_id` char(10) default NULL,
  `menu_id` int(11) default NULL,
  `S_order_whichday` int(11) default NULL,
  `S_order_consumeStatus` int(11) default NULL,
  `S_order_consumeEvaluate` varchar(255) default NULL,
  `S_order_dispatchingID` int(11) default NULL,
  `S_order_dispatchingStartT` datetime default NULL,
  `S_order_logisticsEvaluate` varchar(255) default NULL,
  `S_order_predictTime` datetime default NULL,
  `S_order_isdispatchingStateOpen` tinyint(1) default NULL,
  PRIMARY KEY  (`S_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_s_order` */

insert  into `t_s_order`(`S_order_id`,`F_order_id`,`dispatching_id`,`dispatchingStatus_id`,`menu_id`,`S_order_whichday`,`S_order_consumeStatus`,`S_order_consumeEvaluate`,`S_order_dispatchingID`,`S_order_dispatchingStartT`,`S_order_logisticsEvaluate`,`S_order_predictTime`,`S_order_isdispatchingStateOpen`) values (1,1,1,'1',3,1,1,'还行',1,'2015-01-02 10:43:05','还行','2015-01-02 10:42:48',0),(2,1,1,'1',2,2,1,'还行',1,'2015-01-03 10:46:30','还行','2015-01-03 10:47:00',0),(3,1,1,'1',1,3,1,'棒棒的',1,'2015-01-04 10:46:35','很快','2015-01-04 10:47:06',0);

/*Table structure for table `t_settle` */

DROP TABLE IF EXISTS `t_settle`;

CREATE TABLE `t_settle` (
  `settle_id` int(11) NOT NULL auto_increment,
  `bssinfo_id` int(11) default NULL,
  `settle_type` int(11) default NULL,
  `settle_money` float default NULL,
  `settle_state` varchar(255) default NULL,
  `settle_date` datetime default NULL,
  `settle_startT` datetime default NULL,
  `settle_endT` datetime default NULL,
  PRIMARY KEY  (`settle_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�����';

/*Data for the table `t_settle` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL auto_increment,
  `user_name` varchar(255) default NULL,
  `user_pwd` varchar(255) default NULL,
  `user_gender` int(11) default NULL,
  `user_address` varchar(255) default NULL,
  `user_phoneNumber` varchar(11) default NULL,
  `user_phoneType` int(11) default NULL,
  `user_scale` int(11) default NULL,
  `user_bank_default` int(11) default NULL,
  `user_alipay_default` int(11) default NULL,
  `user_weChatPay` varchar(255) default NULL,
  `user_point_default` int(11) default NULL,
  `user_regdate` date default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`user_id`,`user_name`,`user_pwd`,`user_gender`,`user_address`,`user_phoneNumber`,`user_phoneType`,`user_scale`,`user_bank_default`,`user_alipay_default`,`user_weChatPay`,`user_point_default`,`user_regdate`) values (1,'zsy','zsy',0,'a','1',1,1,1,1,'1',1,'2014-12-13');

/*Table structure for table `t_userextra` */

DROP TABLE IF EXISTS `t_userextra`;

CREATE TABLE `t_userextra` (
  `userextra_id` int(11) NOT NULL auto_increment,
  `user_id` char(10) default NULL,
  `userextra_image` varchar(255) default NULL,
  `userextra_reserved` varchar(255) default NULL,
  PRIMARY KEY  (`userextra_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_userextra` */

/*Table structure for table `t_vendor` */

DROP TABLE IF EXISTS `t_vendor`;

CREATE TABLE `t_vendor` (
  `vendor_id` int(11) NOT NULL auto_increment,
  `vendor_name` varchar(255) default NULL,
  `vendor_mail` varchar(255) default NULL,
  `vendor_phonenum` varchar(11) default NULL,
  `vendor_pwd` varchar(255) default NULL,
  `vendor_isopen` tinyint(1) default NULL,
  `vendor_totalmoney` int(11) default NULL,
  `vendor_paidmoney` int(11) default NULL,
  `vendor_remainedmoney` int(11) default NULL,
  `vendor_employernum` int(11) default NULL,
  `vendor_cooknum` int(11) default NULL,
  `vendor_shophour_start` varchar(255) default NULL,
  `vendor_shophour_end` varchar(255) default NULL,
  `vendor_paytype` int(11) default NULL,
  `vendor_default_accountid` int(11) default NULL,
  `vendor_business_areaid` int(11) default NULL,
  `vendor_detail` varchar(255) default NULL,
  PRIMARY KEY  (`vendor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_vendor` */

insert  into `t_vendor`(`vendor_id`,`vendor_name`,`vendor_mail`,`vendor_phonenum`,`vendor_pwd`,`vendor_isopen`,`vendor_totalmoney`,`vendor_paidmoney`,`vendor_remainedmoney`,`vendor_employernum`,`vendor_cooknum`,`vendor_shophour_start`,`vendor_shophour_end`,`vendor_paytype`,`vendor_default_accountid`,`vendor_business_areaid`,`vendor_detail`) values (1,'a','a','1','1',1,1,1,0,2,1,'08:14:12','12:00:00',1,1,1,''),(2,'z','z','1',NULL,1,NULL,NULL,NULL,1,1,'08:24:12','22:00:00',NULL,NULL,1,''),(4,'1','1','1',NULL,1,NULL,NULL,NULL,1,1,'16:04:12','23:00:00',NULL,NULL,1,''),(5,'a','a','1',NULL,1,NULL,NULL,NULL,1,1,'18:44:12','22:20:00',NULL,NULL,1,''),(6,'1','1','1',NULL,0,NULL,NULL,NULL,1,1,'08:24:12','11:20:00',NULL,NULL,1,''),(8,'a','a','1',NULL,1,NULL,NULL,NULL,1,1,'06:00:00','06:10:00',1,1,1,NULL),(9,'外婆印象','hehe@gmai.com','123',NULL,1,NULL,NULL,NULL,111,111,'06:00:00','23:00:00',NULL,NULL,1,'难吃');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
