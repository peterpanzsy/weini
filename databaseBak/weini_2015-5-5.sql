/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : weini

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2015-05-05 08:37:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_action`
-- ----------------------------
DROP TABLE IF EXISTS `t_action`;
CREATE TABLE `t_action` (
  `action_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `A` varchar(255) DEFAULT NULL,
  `B` varchar(255) DEFAULT NULL,
  `C` varchar(255) DEFAULT NULL,
  `D` varchar(255) DEFAULT NULL,
  `correct` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`action_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_action
-- ----------------------------
INSERT INTO `t_action` VALUES ('1', '以下哪种菜系不属于我国八大菜系？', '苏菜', '鲁菜', '川菜', '本帮菜', 'D');
INSERT INTO `t_action` VALUES ('2', '午夜十二点/灰姑娘/饿了/吃掉了南瓜车/第二天/水晶鞋/穿不进去,这首诗的作者是一位？', '高中生', '本科生', '研究生', '社会青年', 'A');
INSERT INTO `t_action` VALUES ('3', '以下哪本著作出自作家陆文夫？', '《深夜食堂》', '《雅舍谈吃》', '《老饕漫笔》', '《美食家》', 'D');
INSERT INTO `t_action` VALUES ('4', '2014年9月发生员工流血斗殴的是哪两家外卖公司？', '美团&饿了么', '美团&百度外卖', '饿了么&淘点点', '百度外卖&飞饭', 'A');
INSERT INTO `t_action` VALUES ('5', '下列哪家企业不是行业三大披萨巨头之一？', '必胜客', '味你', '棒约翰', '达美乐', 'B');
INSERT INTO `t_action` VALUES ('6', '日剧《深夜食堂》中主人公没有做过的食物是？', '猫饭', '茶泡饭', '牛油拌饭', '咖喱牛腩饭', 'D');
INSERT INTO `t_action` VALUES ('7', '美剧《master chef》第三季第一集中美籍华裔弯男用哪种食物征服了主厨Gordon Ramsay', '麻婆豆腐', '鱼香肉丝', '煎饼果子', '饺子', 'D');
INSERT INTO `t_action` VALUES ('8', '以下哪种功能不是味你APP拥有的？', '食物溯源', '菜谱点菜', '神秘盒子', '个人记录', 'B');
INSERT INTO `t_action` VALUES ('9', '被称作“寿司之神”的小野二郎是世界上年龄最大的米其林三星厨师，他认为制作寿司的米饭应该在多少度？', '20度以下', '20—30度', '30—35度', '35—38度', 'D');
INSERT INTO `t_action` VALUES ('10', '电影《食神》中食神落难后，用撒尿牛丸重启市场，而后生产罐头供应全香港超市便利店，这些密密麻麻的点在电脑上汇聚成一个字，这个字是？', '旺', '发', '掂', '兴', 'C');

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_username` varchar(255) NOT NULL DEFAULT '',
  `admin_pwd` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('2', 'zsy', 'zsyaaa');
INSERT INTO `t_admin` VALUES ('3', 'cyjaaa', 'cyjaaa');
INSERT INTO `t_admin` VALUES ('4', 'plin', 'plin');
INSERT INTO `t_admin` VALUES ('7', 'root', 'root');
INSERT INTO `t_admin` VALUES ('8', 'root1', 'root1');
INSERT INTO `t_admin` VALUES ('10', 'root1', 'root1');
INSERT INTO `t_admin` VALUES ('15', 'root1', 'root1');
INSERT INTO `t_admin` VALUES ('20', 'zsy', 'aaaaaa');
INSERT INTO `t_admin` VALUES ('21', 'cccc', 'ccccccccc');
INSERT INTO `t_admin` VALUES ('22', 'ddd', 'dddddd');
INSERT INTO `t_admin` VALUES ('24', 'gege', 'gegege');
INSERT INTO `t_admin` VALUES ('25', 'zouge', 'A4D37957C001A8F5F696171D2CF55E2E');
INSERT INTO `t_admin` VALUES ('26', 'root', '21232F297A57A5A743894A0E4A801FC3');
INSERT INTO `t_admin` VALUES ('27', 'zsy', '21232F297A57A5A743894A0E4A801FC3');
INSERT INTO `t_admin` VALUES ('28', '123', 'E10ADC3949BA59ABBE56E057F20F883E');

-- ----------------------------
-- Table structure for `t_admin_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin_role`;
CREATE TABLE `t_admin_role` (
  `admin_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_role_adminid` int(11) NOT NULL,
  `admin_role_roleid` int(11) NOT NULL,
  PRIMARY KEY (`admin_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin_role
-- ----------------------------
INSERT INTO `t_admin_role` VALUES ('2', '2', '4');
INSERT INTO `t_admin_role` VALUES ('3', '3', '2');
INSERT INTO `t_admin_role` VALUES ('4', '4', '3');
INSERT INTO `t_admin_role` VALUES ('7', '7', '1');
INSERT INTO `t_admin_role` VALUES ('8', '8', '1');
INSERT INTO `t_admin_role` VALUES ('9', '9', '1');
INSERT INTO `t_admin_role` VALUES ('11', '7', '1');
INSERT INTO `t_admin_role` VALUES ('12', '8', '1');
INSERT INTO `t_admin_role` VALUES ('13', '9', '1');
INSERT INTO `t_admin_role` VALUES ('14', '10', '1');
INSERT INTO `t_admin_role` VALUES ('19', '15', '1');
INSERT INTO `t_admin_role` VALUES ('27', '20', '1');
INSERT INTO `t_admin_role` VALUES ('28', '21', '1');
INSERT INTO `t_admin_role` VALUES ('29', '22', '1');
INSERT INTO `t_admin_role` VALUES ('31', '24', '4');
INSERT INTO `t_admin_role` VALUES ('32', '25', '1');
INSERT INTO `t_admin_role` VALUES ('33', '26', '1');
INSERT INTO `t_admin_role` VALUES ('34', '27', '3');
INSERT INTO `t_admin_role` VALUES ('35', '28', '4');

-- ----------------------------
-- Table structure for `t_alipay`
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
-- Table structure for `t_answer`
-- ----------------------------
DROP TABLE IF EXISTS `t_answer`;
CREATE TABLE `t_answer` (
  `ans_id` int(11) NOT NULL AUTO_INCREMENT,
  `ans_content` varchar(255) DEFAULT NULL,
  `ans_correct` varchar(255) DEFAULT NULL,
  `ans_time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `ans_correct_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`ans_id`)
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_answer
-- ----------------------------
INSERT INTO `t_answer` VALUES ('19', 'DDCABAAAC', '2=D9=C', '2015-04-15 19:23:12', '97', '2');
INSERT INTO `t_answer` VALUES ('30', 'D&A&D&A&B&D&D&B&D&C', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&7=B&8=D&9=C', '2015-04-15 19:46:21', '63', '10');
INSERT INTO `t_answer` VALUES ('31', '&&&&&&&&&', '', '2015-04-15 19:46:57', '63', '0');
INSERT INTO `t_answer` VALUES ('32', '&&&&&&&&&', '', '2015-04-15 19:47:00', '63', '0');
INSERT INTO `t_answer` VALUES ('33', '&&&&&&&&&', '', '2015-04-15 19:47:06', '63', '0');
INSERT INTO `t_answer` VALUES ('36', 'D&A&D&A&B&B&A&D&B&D', '0=D&1=A&2=D&3=A&4=B&', '2015-04-15 19:57:24', '85', '5');
INSERT INTO `t_answer` VALUES ('37', 'D&A&D&A&B&D&A&C&D&A', '0=D&1=A&2=D&3=A&4=B&5=D&8=D&', '2015-04-15 19:59:06', '105', '7');
INSERT INTO `t_answer` VALUES ('38', 'D&A&D&A&B&D&D&C&D&A', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&8=D&', '2015-04-15 20:04:21', '105', '8');
INSERT INTO `t_answer` VALUES ('39', 'D&A&D&A&B&D&D&C&C&A', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&', '2015-04-15 20:05:16', '105', '7');
INSERT INTO `t_answer` VALUES ('40', 'D&A&D&A&B&D&D&C&D&D', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&8=D&', '2015-04-15 20:05:49', '105', '8');
INSERT INTO `t_answer` VALUES ('41', 'D&A&D&A&B&D&D&C&D&B', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&8=D&', '2015-04-15 20:06:25', '105', '8');
INSERT INTO `t_answer` VALUES ('42', 'D&A&D&A&B&D&D&A&D&C', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&8=D&9=C', '2015-04-15 20:06:56', '105', '9');
INSERT INTO `t_answer` VALUES ('43', 'D&A&D&A&B&D&D&D&D&C', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&8=D&9=C', '2015-04-15 20:07:52', '105', '9');
INSERT INTO `t_answer` VALUES ('44', 'D&A&D&A&B&D&D&B&D&C', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&7=B&8=D&9=C', '2015-04-15 20:08:34', '105', '10');
INSERT INTO `t_answer` VALUES ('45', 'D&D&D&D&D&D&D&D&D&D', '0=D&2=D&5=D&6=D&8=D&', '2015-04-15 20:14:18', '63', '5');
INSERT INTO `t_answer` VALUES ('50', 'D&D&D&D&D&D&C&D&D&D', '0=D&2=D&5=D&8=D&', '2015-04-15 20:23:28', '63', '4');
INSERT INTO `t_answer` VALUES ('63', 'D&A&D&A&B&A&D&B&C&C', '0=D&1=A&2=D&3=A&4=B&6=D&7=B&9=C', '2015-04-15 20:30:33', '106', '8');
INSERT INTO `t_answer` VALUES ('66', 'D&A&D&A&B&A&D&C&C&C', '0=D&1=A&2=D&3=A&4=B&6=D&9=C', '2015-04-15 20:34:55', '106', '7');
INSERT INTO `t_answer` VALUES ('67', 'D&A&D&A&B&C&D&C&C&C', '0=D&1=A&2=D&3=A&4=B&6=D&9=C', '2015-04-15 20:36:13', '106', '7');
INSERT INTO `t_answer` VALUES ('68', 'D&A&D&A&B&D&D&A&C&B', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&', '2015-04-15 20:37:52', '106', '7');
INSERT INTO `t_answer` VALUES ('69', 'D&A&D&A&B&A&D&C&C&C', '0=D&1=A&2=D&3=A&4=B&6=D&9=C', '2015-04-15 20:41:01', '106', '7');
INSERT INTO `t_answer` VALUES ('70', 'D&B&A&B&D&D&B&C&B&C', '0=D&5=D&9=C', '2015-04-15 20:57:47', '63', '3');
INSERT INTO `t_answer` VALUES ('71', 'D&D&D&D&D&D&D&D&D&C', '0=D&2=D&5=D&6=D&8=D&9=C', '2015-04-15 20:59:41', '63', '6');
INSERT INTO `t_answer` VALUES ('72', 'C&B&C&D&D&D&C&D&D&D', '5=D&8=D&', '2015-04-15 21:00:32', '63', '2');
INSERT INTO `t_answer` VALUES ('74', 'D&D&D&D&D&D&D&B&D&C', '0=D&2=D&5=D&6=D&7=B&8=D&9=C', '2015-04-15 21:03:19', '63', '7');
INSERT INTO `t_answer` VALUES ('76', 'D&D&B&A&B&B&B&A&A&D', '0=D&3=A&4=B&', '2015-04-15 21:05:22', '108', '3');
INSERT INTO `t_answer` VALUES ('77', 'D&D&D&D&D&D&D&D&D&D', '0=D&2=D&5=D&6=D&8=D&', '2015-04-15 21:07:52', '63', '5');
INSERT INTO `t_answer` VALUES ('79', '&&&&&&&&&', '', '2015-04-15 21:11:02', '63', '0');
INSERT INTO `t_answer` VALUES ('82', 'D&B&D&A&B&D&D&A&B&A', '0=D&2=D&3=A&4=B&5=D&6=D&', '2015-04-15 21:12:05', '88', '6');
INSERT INTO `t_answer` VALUES ('83', 'D&D&D&D&D&D&D&D&D&D', '0=D&2=D&5=D&6=D&8=D&', '2015-04-15 21:12:58', '63', '5');
INSERT INTO `t_answer` VALUES ('84', '&&&&&&&&&', '', '2015-04-15 21:13:10', '88', '0');
INSERT INTO `t_answer` VALUES ('85', 'D&D&B&A&B&A&B&A&B&A', '0=D&3=A&4=B&', '2015-04-15 21:13:15', '100', '3');
INSERT INTO `t_answer` VALUES ('86', 'D&A&D&A&B&D&D&B&D&C', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&7=B&8=D&9=C', '2015-04-15 21:14:27', '63', '10');
INSERT INTO `t_answer` VALUES ('87', '&&&&&&&&&', '', '2015-04-15 21:16:45', '63', '0');
INSERT INTO `t_answer` VALUES ('88', '&&&&&&&&&', '', '2015-04-15 21:17:04', '63', '0');
INSERT INTO `t_answer` VALUES ('89', 'D&D&D&A&B&D&A&A&D&A', '0=D&2=D&3=A&4=B&5=D&8=D&', '2015-04-15 21:21:56', '109', '6');
INSERT INTO `t_answer` VALUES ('90', 'A&D&D&A&B&D&D&C&C&C', '2=D&3=A&4=B&5=D&6=D&9=C', '2015-04-15 21:23:39', '53', '6');
INSERT INTO `t_answer` VALUES ('91', 'B&D&C&B&B&A&D&B&D&A', '4=B&6=D&7=B&8=D&', '2015-04-15 21:24:56', '64', '4');
INSERT INTO `t_answer` VALUES ('92', 'A&C&D&A&B&D&D&A&C&C', '2=D&3=A&4=B&5=D&6=D&9=C', '2015-04-15 21:27:44', '53', '6');
INSERT INTO `t_answer` VALUES ('93', 'D&D&B&A&B&A&D&A&B&C', '0=D&3=A&4=B&6=D&9=C', '2015-04-15 21:37:22', '54', '5');
INSERT INTO `t_answer` VALUES ('94', 'D&D&D&D&D&D&D&D&D&D', '0=D&2=D&5=D&6=D&8=D&', '2015-04-15 21:41:34', '63', '5');
INSERT INTO `t_answer` VALUES ('95', 'D&B&D&A&B&B&B&A&B&C', '0=D&2=D&3=A&4=B&9=C', '2015-04-15 21:43:44', '113', '5');
INSERT INTO `t_answer` VALUES ('97', 'D&D&D&D&D&D&D&D&D&D', '0=D&2=D&5=D&6=D&8=D&', '2015-04-15 21:47:57', '63', '5');
INSERT INTO `t_answer` VALUES ('99', '&&&&&&&&&', '', '2015-04-15 21:58:49', '63', '0');
INSERT INTO `t_answer` VALUES ('100', 'D&A&B&A&B&B&B&A&C&D', '0=D&1=A&3=A&4=B&', '2015-04-15 22:05:56', '72', '4');
INSERT INTO `t_answer` VALUES ('101', 'D&A&D&A&B&D&A&C&B&A', '0=D&1=A&2=D&3=A&4=B&5=D&', '2015-04-15 22:09:06', '115', '6');
INSERT INTO `t_answer` VALUES ('102', 'D&A&D&A&B&D&D&B&C&B', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&7=B&', '2015-04-15 22:12:06', '115', '8');
INSERT INTO `t_answer` VALUES ('103', 'D&A&D&A&B&D&D&B&C&C', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&7=B&9=C', '2015-04-15 22:16:57', '115', '9');
INSERT INTO `t_answer` VALUES ('104', 'D&A&D&A&B&D&D&C&C&C', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&9=C', '2015-04-15 22:19:23', '115', '8');
INSERT INTO `t_answer` VALUES ('105', 'D&B&D&C&B&A&A&D&B&B', '0=D&2=D&4=B&', '2015-04-15 22:20:34', '121', '3');
INSERT INTO `t_answer` VALUES ('106', 'D&A&D&A&B&D&B&C&C&B', '0=D&1=A&2=D&3=A&4=B&5=D&', '2015-04-15 22:20:49', '122', '6');
INSERT INTO `t_answer` VALUES ('107', 'D&A&D&A&B&D&D&C&C&B', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&', '2015-04-15 22:21:47', '122', '7');
INSERT INTO `t_answer` VALUES ('108', 'D&A&D&A&B&D&D&D&C&B', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&', '2015-04-15 22:22:40', '122', '7');
INSERT INTO `t_answer` VALUES ('109', 'D&D&D&D&D&D&D&D&D&D', '0=D&2=D&5=D&6=D&8=D&', '2015-04-15 22:23:05', '63', '5');
INSERT INTO `t_answer` VALUES ('110', 'D&A&D&A&B&D&D&A&C&B', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&', '2015-04-15 22:23:17', '122', '7');
INSERT INTO `t_answer` VALUES ('111', 'D&A&D&A&B&D&D&B&C&B', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&7=B&', '2015-04-15 22:23:58', '122', '8');
INSERT INTO `t_answer` VALUES ('112', 'D&A&D&A&B&D&D&B&D&B', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&7=B&8=D&', '2015-04-15 22:24:40', '122', '9');
INSERT INTO `t_answer` VALUES ('117', 'D&A&D&A&B&D&D&B&D&D', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&7=B&8=D&', '2015-04-15 22:25:21', '122', '9');
INSERT INTO `t_answer` VALUES ('118', 'D&A&D&A&B&D&D&B&B&C', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&7=B&9=C', '2015-04-15 22:25:46', '115', '9');
INSERT INTO `t_answer` VALUES ('119', 'D&A&D&A&B&D&D&B&D&A', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&7=B&8=D&', '2015-04-15 22:25:56', '122', '9');
INSERT INTO `t_answer` VALUES ('120', 'D&A&D&A&B&D&D&C&C&D', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&', '2015-04-15 22:26:54', '115', '7');
INSERT INTO `t_answer` VALUES ('121', 'D&A&D&A&B&D&D&B&D&C', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&7=B&8=D&9=C', '2015-04-15 22:27:00', '122', '10');
INSERT INTO `t_answer` VALUES ('122', 'D&A&D&A&B&D&D&B&D&C', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&7=B&8=D&9=C', '2015-04-15 22:27:52', '115', '10');
INSERT INTO `t_answer` VALUES ('124', 'D&A&D&A&B&D&D&B&D&C', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&7=B&8=D&9=C', '2015-04-15 22:29:39', '122', '10');
INSERT INTO `t_answer` VALUES ('127', '&&&&&&&&&', '', '2015-04-15 22:33:41', '63', '0');
INSERT INTO `t_answer` VALUES ('128', 'D&C&D&A&B&C&A&B&B&A', '0=D&2=D&3=A&4=B&7=B&', '2015-04-15 22:35:38', '54', '5');
INSERT INTO `t_answer` VALUES ('131', 'D&A&D&A&B&D&D&C&D&A', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&8=D&', '2015-04-15 22:49:19', '126', '8');
INSERT INTO `t_answer` VALUES ('132', 'D&C&A&A&B&B&D&C&B&B', '0=D&3=A&4=B&6=D&', '2015-04-15 22:51:58', '86', '4');
INSERT INTO `t_answer` VALUES ('133', 'D&A&D&A&B&D&D&C&D&D', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&8=D&', '2015-04-15 22:56:37', '126', '8');
INSERT INTO `t_answer` VALUES ('134', '&&&&&&&&&', '', '2015-04-15 23:03:33', '63', '0');
INSERT INTO `t_answer` VALUES ('135', 'D&B&D&A&B&D&A&B&B&B', '0=D&2=D&3=A&4=B&5=D&7=B&', '2015-04-15 23:09:39', '128', '6');
INSERT INTO `t_answer` VALUES ('136', 'D&D&D&A&B&D&A&B&B&B', '0=D&2=D&3=A&4=B&5=D&7=B&', '2015-04-15 23:22:37', '128', '6');
INSERT INTO `t_answer` VALUES ('137', 'D&D&D&A&B&D&B&A&A&A', '0=D&2=D&3=A&4=B&5=D&', '2015-04-15 23:23:33', '128', '5');
INSERT INTO `t_answer` VALUES ('138', 'D&A&D&A&B&D&B&B&A&D', '0=D&1=A&2=D&3=A&4=B&5=D&7=B&', '2015-04-15 23:25:16', '128', '7');
INSERT INTO `t_answer` VALUES ('139', 'A&A&D&A&B&D&B&B&A&D', '1=A&2=D&3=A&4=B&5=D&7=B&', '2015-04-15 23:25:59', '128', '6');
INSERT INTO `t_answer` VALUES ('140', 'D&D&D&A&B&D&B&B&A&D', '0=D&2=D&3=A&4=B&5=D&7=B&', '2015-04-15 23:26:37', '128', '6');
INSERT INTO `t_answer` VALUES ('141', 'D&A&D&A&B&D&C&B&A&D', '0=D&1=A&2=D&3=A&4=B&5=D&7=B&', '2015-04-15 23:27:15', '128', '7');
INSERT INTO `t_answer` VALUES ('142', 'D&A&D&A&B&D&C&B&B&B', '0=D&1=A&2=D&3=A&4=B&5=D&7=B&', '2015-04-15 23:27:51', '128', '7');
INSERT INTO `t_answer` VALUES ('143', 'C&D&A&A&B&D&A&A&A&A', '3=A&4=B&5=D&', '2015-04-15 23:49:01', '73', '3');
INSERT INTO `t_answer` VALUES ('144', 'D&A&D&A&B&A&B&A&A&D', '0=D&1=A&2=D&3=A&4=B&', '2015-04-15 23:57:46', '60', '5');
INSERT INTO `t_answer` VALUES ('145', 'D&A&D&A&B&A&D&A&B&B', '0=D&1=A&2=D&3=A&4=B&6=D&', '2015-04-15 23:59:16', '68', '6');
INSERT INTO `t_answer` VALUES ('146', 'D&D&D&A&B&A&D&A&A&A', '0=D&2=D&3=A&4=B&6=D&', '2015-04-15 23:59:38', '57', '5');
INSERT INTO `t_answer` VALUES ('147', '&&&&&&&&&', '', '2015-04-16 00:00:53', '57', '0');
INSERT INTO `t_answer` VALUES ('148', 'A&D&D&D&D&D&D&D&D&C', '2=D&5=D&6=D&8=D&9=C', '2015-04-16 00:08:20', '63', '5');
INSERT INTO `t_answer` VALUES ('149', '&&&&&&&&&', '', '2015-04-16 00:09:58', '63', '0');
INSERT INTO `t_answer` VALUES ('150', 'D&A&D&A&B&D&D&B&D&C', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&7=B&8=D&9=C', '2015-04-16 00:22:23', '105', '10');
INSERT INTO `t_answer` VALUES ('151', 'A&A&C&A&B&A&B&D&C&A', '1=A&3=A&4=B&', '2015-04-16 01:37:23', '133', '3');
INSERT INTO `t_answer` VALUES ('152', 'D&D&C&A&B&D&B&B&A&B', '0=D&3=A&4=B&5=D&7=B&', '2015-04-16 02:57:59', '28', '5');
INSERT INTO `t_answer` VALUES ('153', 'D&D&A&D&B&B&C&C&B&D', '0=D&4=B&', '2015-04-16 06:50:25', '134', '2');
INSERT INTO `t_answer` VALUES ('154', 'D&D&D&D&D&D&C&D&C&C', '0=D&2=D&5=D&9=C', '2015-04-16 08:22:25', '63', '4');
INSERT INTO `t_answer` VALUES ('155', 'D&D&D&A&C&D&D&B&D&C', '0=D&2=D&3=A&5=D&6=D&7=B&8=D&9=C', '2015-04-16 08:33:06', '63', '8');
INSERT INTO `t_answer` VALUES ('156', 'D&A&D&A&B&D&D&B&D&C', '0=D&1=A&2=D&3=A&4=B&5=D&6=D&7=B&8=D&9=C', '2015-04-16 11:58:24', '122', '10');
INSERT INTO `t_answer` VALUES ('157', 'D&B&C&A&D&B&C&D&A&B', '0=D&3=A&', '2015-04-16 12:33:31', '1', '2');
INSERT INTO `t_answer` VALUES ('158', 'D&A&B&B&B&B&C&C&C&B', '0=D&1=A&4=B&', '2015-04-16 13:28:52', '140', '3');

-- ----------------------------
-- Table structure for `t_authority`
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
-- Table structure for `t_bank`
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
-- Table structure for `t_box`
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_box
-- ----------------------------
INSERT INTO `t_box` VALUES ('1', '1', '15', '3', 'tupian1', '每段旅程都有起点，现在开始并不晚', '可以选择跟我么么哒~', '能入口皆留香', '最初的体验 犹如青木瓜的清爽回甘', '1', '1天体验套餐');
INSERT INTO `t_box` VALUES ('2', '1', '30', '3', 'tupian2', '只有勇气才能带你到远方', '“吃”绝对是一门技术活~', '易情动则眼迷', '深入味觉 调动起酸甜混合的奇妙感受', '3', '3天体验套餐');
INSERT INTO `t_box` VALUES ('3', '1', '45', '3', 'tupian3', '没有一帆风顺的旅途，即使暗夜行路，也有我们为你掌灯', '请自由的 策马奔腾~', '“食”与“欲”可合可分', '浓郁发酵 为食物而忘我 ', '5', '5天体验套餐');
INSERT INTO `t_box` VALUES ('4', '1', '19', '3', 'tupian3', '举手之劳，替别人分忧!', '举手之劳，替别人分忧!', '举手之劳，替别人分忧!', '举手之劳，替别人分忧!', '1', '代购多份套餐');

-- ----------------------------
-- Table structure for `t_boxpage`
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
-- Table structure for `t_businessarea`
-- ----------------------------
DROP TABLE IF EXISTS `t_businessarea`;
CREATE TABLE `t_businessarea` (
  `businessArea_id` int(11) NOT NULL AUTO_INCREMENT,
  `businessArea_name` varchar(255) NOT NULL DEFAULT '',
  `district_id` int(11) NOT NULL,
  PRIMARY KEY (`businessArea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_businessarea
-- ----------------------------
INSERT INTO `t_businessarea` VALUES ('3', '西安邮电大学', '4');
INSERT INTO `t_businessarea` VALUES ('5', '都市之门', '6');

-- ----------------------------
-- Table structure for `t_city`
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `province_id` int(11) NOT NULL,
  `city_name` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_city
-- ----------------------------
INSERT INTO `t_city` VALUES ('3', '3', '西安市');

-- ----------------------------
-- Table structure for `t_consumerecord`
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
-- Table structure for `t_cookinfo`
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
-- Table structure for `t_dishes`
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
-- Table structure for `t_dispatching`
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dispatching
-- ----------------------------
INSERT INTO `t_dispatching` VALUES ('2', '3', '3', '4', '3', '11', 'rrrr', '2', '15339231453');
INSERT INTO `t_dispatching` VALUES ('6', '3', '3', '4', '3', '12', '你妹你妹', '24', '15339231453');
INSERT INTO `t_dispatching` VALUES ('7', '3', '3', '4', '3', '12', '2#553', '28', '18292801423');
INSERT INTO `t_dispatching` VALUES ('8', '3', '3', '4', '3', '12', '6号楼565', '17', '13152471502');
INSERT INTO `t_dispatching` VALUES ('9', '3', '3', '4', '3', '11', '3楼', '20', '15029485462');
INSERT INTO `t_dispatching` VALUES ('10', '3', '3', '4', '3', '12', '邮电\n', '20', '18930852101');
INSERT INTO `t_dispatching` VALUES ('11', '3', '3', '4', '3', '12', '3楼', '31', '15029485462');
INSERT INTO `t_dispatching` VALUES ('12', '3', '3', '4', '3', '11', '东区教学楼', '29', '18930852101');
INSERT INTO `t_dispatching` VALUES ('13', '3', '3', '4', '3', '11', '3号楼', '18', '13991370112');
INSERT INTO `t_dispatching` VALUES ('14', '3', '3', '4', '3', '11', '家属楼A1栋', '1', '18995123080');
INSERT INTO `t_dispatching` VALUES ('15', '3', '3', '4', '3', '12', 'xx楼号', '12', '15529203632');
INSERT INTO `t_dispatching` VALUES ('16', '3', '3', '4', '3', '11', '食堂门口', '83', '18710419469');
INSERT INTO `t_dispatching` VALUES ('17', '3', '3', '4', '3', '11', '东区', '147', '18930852101');

-- ----------------------------
-- Table structure for `t_dispatchingstatus`
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
-- Table structure for `t_district`
-- ----------------------------
DROP TABLE IF EXISTS `t_district`;
CREATE TABLE `t_district` (
  `district_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_id` int(11) NOT NULL,
  `district_name` varchar(255) NOT NULL,
  PRIMARY KEY (`district_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_district
-- ----------------------------
INSERT INTO `t_district` VALUES ('4', '3', '长安区');
INSERT INTO `t_district` VALUES ('6', '3', '雁塔区');

-- ----------------------------
-- Table structure for `t_fans_name`
-- ----------------------------
DROP TABLE IF EXISTS `t_fans_name`;
CREATE TABLE `t_fans_name` (
  `fans_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`fans_id`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_fans_name
-- ----------------------------
INSERT INTO `t_fans_name` VALUES ('17', '味精', '97', '肖胜文');
INSERT INTO `t_fans_name` VALUES ('28', '', '63', '陈全');
INSERT INTO `t_fans_name` VALUES ('29', '', '63', '');
INSERT INTO `t_fans_name` VALUES ('30', '', '63', '');
INSERT INTO `t_fans_name` VALUES ('31', '', '63', '');
INSERT INTO `t_fans_name` VALUES ('34', '味心', '85', '李卉宁');
INSERT INTO `t_fans_name` VALUES ('35', '维他命就挺好的，寓意着生命不可缺少之元素', '105', '武靓靓');
INSERT INTO `t_fans_name` VALUES ('36', '', '105', '');
INSERT INTO `t_fans_name` VALUES ('37', '', '105', '');
INSERT INTO `t_fans_name` VALUES ('38', '', '105', '');
INSERT INTO `t_fans_name` VALUES ('39', '', '105', '');
INSERT INTO `t_fans_name` VALUES ('40', '', '105', '');
INSERT INTO `t_fans_name` VALUES ('41', '', '105', '');
INSERT INTO `t_fans_name` VALUES ('42', '', '105', '');
INSERT INTO `t_fans_name` VALUES ('43', '', '63', '');
INSERT INTO `t_fans_name` VALUES ('48', '', '63', '');
INSERT INTO `t_fans_name` VALUES ('61', '兰云', '106', '兰云');
INSERT INTO `t_fans_name` VALUES ('64', '看见了', '106', '');
INSERT INTO `t_fans_name` VALUES ('65', '考虑考虑', '106', '');
INSERT INTO `t_fans_name` VALUES ('66', '\'\'\'', '106', '');
INSERT INTO `t_fans_name` VALUES ('67', '考虑考虑', '106', '');
INSERT INTO `t_fans_name` VALUES ('68', '', '63', '');
INSERT INTO `t_fans_name` VALUES ('69', '卢比咋可靠', '63', '难兄难弟家');
INSERT INTO `t_fans_name` VALUES ('70', '', '63', '');
INSERT INTO `t_fans_name` VALUES ('72', '对方哈哈', '63', '层次感');
INSERT INTO `t_fans_name` VALUES ('74', '唯一     味你，唯一爱你！', '108', '程');
INSERT INTO `t_fans_name` VALUES ('75', '', '63', '');
INSERT INTO `t_fans_name` VALUES ('77', '', '63', '');
INSERT INTO `t_fans_name` VALUES ('80', 'Winnie 维尼熊 味尼斯 小味士 V5. Vico（题目好丧心病狂）', '88', '马心浩');
INSERT INTO `t_fans_name` VALUES ('81', '收到', '63', '钟点工');
INSERT INTO `t_fans_name` VALUES ('82', '', '88', '');
INSERT INTO `t_fans_name` VALUES ('83', '', '100', '徐稀饭');
INSERT INTO `t_fans_name` VALUES ('84', '', '63', '');
INSERT INTO `t_fans_name` VALUES ('85', '', '63', '');
INSERT INTO `t_fans_name` VALUES ('86', '', '63', '');
INSERT INTO `t_fans_name` VALUES ('87', 'viky', '109', '王禹博');
INSERT INTO `t_fans_name` VALUES ('88', '威尼斯', '53', '郭婷');
INSERT INTO `t_fans_name` VALUES ('89', '', '64', '');
INSERT INTO `t_fans_name` VALUES ('90', '', '53', '');
INSERT INTO `t_fans_name` VALUES ('91', '', '54', '王畅');
INSERT INTO `t_fans_name` VALUES ('92', '', '63', '');
INSERT INTO `t_fans_name` VALUES ('93', '', '113', '千千');
INSERT INTO `t_fans_name` VALUES ('95', '', '63', '');
INSERT INTO `t_fans_name` VALUES ('97', '', '63', '');
INSERT INTO `t_fans_name` VALUES ('98', '芦苇    泥鳅   哈哈～', '72', '吴桐');
INSERT INTO `t_fans_name` VALUES ('99', '', '115', '辛佳');
INSERT INTO `t_fans_name` VALUES ('100', '', '115', '李豆豆');
INSERT INTO `t_fans_name` VALUES ('101', '', '115', '周凯航');
INSERT INTO `t_fans_name` VALUES ('102', '', '115', '惠皓晨');
INSERT INTO `t_fans_name` VALUES ('103', '维果', '121', '张妮');
INSERT INTO `t_fans_name` VALUES ('104', '', '122', '王琳琳');
INSERT INTO `t_fans_name` VALUES ('105', '', '122', '王');
INSERT INTO `t_fans_name` VALUES ('106', '', '122', '王');
INSERT INTO `t_fans_name` VALUES ('107', '就是今生今世', '63', '开始觉得好');
INSERT INTO `t_fans_name` VALUES ('108', '', '122', '王');
INSERT INTO `t_fans_name` VALUES ('109', '', '122', '王');
INSERT INTO `t_fans_name` VALUES ('110', '', '122', '王');
INSERT INTO `t_fans_name` VALUES ('115', '', '122', '王');
INSERT INTO `t_fans_name` VALUES ('116', '', '115', '李豆豆');
INSERT INTO `t_fans_name` VALUES ('117', '', '122', '王');
INSERT INTO `t_fans_name` VALUES ('118', '', '115', '安雪山');
INSERT INTO `t_fans_name` VALUES ('119', '', '122', '王');
INSERT INTO `t_fans_name` VALUES ('120', '', '115', '周凯航');
INSERT INTO `t_fans_name` VALUES ('122', '', '122', '安雪姗');
INSERT INTO `t_fans_name` VALUES ('125', '', '63', '');
INSERT INTO `t_fans_name` VALUES ('126', '', '54', '张晓晴');
INSERT INTO `t_fans_name` VALUES ('129', '”味生”，意味着食品卫生，粉丝主要是学生。原创，望采纳', '126', '杨博文');
INSERT INTO `t_fans_name` VALUES ('130', '粉丝群可以叫“味品会”\r\n粉丝就叫“爱味儿”（爱味er）', '86', '安朋辉');
INSERT INTO `t_fans_name` VALUES ('131', '味士，原创望采纳', '126', '杨博文');
INSERT INTO `t_fans_name` VALUES ('132', '', '63', '');
INSERT INTO `t_fans_name` VALUES ('133', '味饭', '128', '钟智鹏');
INSERT INTO `t_fans_name` VALUES ('134', '', '128', 'jk');
INSERT INTO `t_fans_name` VALUES ('135', '', '128', '就恢复健康');
INSERT INTO `t_fans_name` VALUES ('136', '', '128', 'qfu');
INSERT INTO `t_fans_name` VALUES ('137', '', '128', 'sgjj');
INSERT INTO `t_fans_name` VALUES ('138', '', '128', 'fkgo');
INSERT INTO `t_fans_name` VALUES ('139', '', '128', 'wyyj');
INSERT INTO `t_fans_name` VALUES ('140', '', '128', 'shf');
INSERT INTO `t_fans_name` VALUES ('141', '可以随时定随时送吗', '73', '张晋睿');
INSERT INTO `t_fans_name` VALUES ('142', '', '60', '孙博文');
INSERT INTO `t_fans_name` VALUES ('143', '喂腻', '68', '山林');
INSERT INTO `t_fans_name` VALUES ('144', '味道', '57', '苏宇宁');
INSERT INTO `t_fans_name` VALUES ('145', '', '57', '');
INSERT INTO `t_fans_name` VALUES ('146', '', '63', '把顶焦度计');
INSERT INTO `t_fans_name` VALUES ('147', '', '63', '');
INSERT INTO `t_fans_name` VALUES ('148', '', '105', 'bettyhxz');
INSERT INTO `t_fans_name` VALUES ('149', '味宝', '133', '童彤');
INSERT INTO `t_fans_name` VALUES ('150', '', '28', '烹烹');
INSERT INTO `t_fans_name` VALUES ('151', '味饱', '134', '李卓');
INSERT INTO `t_fans_name` VALUES ('152', '觉得基督教', '63', '那些那么多');
INSERT INTO `t_fans_name` VALUES ('153', '充分认识过', '63', '仿佛交界处');
INSERT INTO `t_fans_name` VALUES ('154', '', '122', '王琳琳');
INSERT INTO `t_fans_name` VALUES ('155', '小味味', '1', '陈生珠');
INSERT INTO `t_fans_name` VALUES ('156', '味粉  威风', '140', '何小乔');

-- ----------------------------
-- Table structure for `t_feed_back`
-- ----------------------------
DROP TABLE IF EXISTS `t_feed_back`;
CREATE TABLE `t_feed_back` (
  `feedBackId` int(20) NOT NULL AUTO_INCREMENT,
  `phoneNum` varchar(20) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`feedBackId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_feed_back
-- ----------------------------
INSERT INTO `t_feed_back` VALUES ('1', '18930852101', 'verary', '1');
INSERT INTO `t_feed_back` VALUES ('2', '18930852101', 'verary', '2');
INSERT INTO `t_feed_back` VALUES ('3', '', '哦哦哦的', '3');
INSERT INTO `t_feed_back` VALUES ('4', '15339231453', '陌陌分', '4');
INSERT INTO `t_feed_back` VALUES ('6', '18930852101', '冯骥才 v 女', '6');
INSERT INTO `t_feed_back` VALUES ('7', '18930852101', '冯骥才 v 女', '6');
INSERT INTO `t_feed_back` VALUES ('8', '18930852101', '你好珠珠', '7');
INSERT INTO `t_feed_back` VALUES ('9', '18930852101', 'é¥­èå¥½å', '8');
INSERT INTO `t_feed_back` VALUES ('10', '18930852101', 'haha', '9');
INSERT INTO `t_feed_back` VALUES ('11', '18930852101', 'haha', '1');
INSERT INTO `t_feed_back` VALUES ('12', '18930852101', '更好吃k', '8');
INSERT INTO `t_feed_back` VALUES ('13', '18930852101', 'vjcj公布成绩', '1');
INSERT INTO `t_feed_back` VALUES ('14', '陈名佳\n', 'bug太多 不忍直视', '29');
INSERT INTO `t_feed_back` VALUES ('15', '陈名佳\n', '各种闪退', '29');
INSERT INTO `t_feed_back` VALUES ('16', '陈名佳\n', '已卸载', '29');
INSERT INTO `t_feed_back` VALUES ('17', '', '  请详细描述您在使用过程中所遇到的问题、意见、建议等', '1');

-- ----------------------------
-- Table structure for `t_index`
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
INSERT INTO `t_index` VALUES ('1', 'order_date', '20150421');
INSERT INTO `t_index` VALUES ('2', 'order_num', '10');

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
  `menuinfo_id` int(11) NOT NULL AUTO_INCREMENT,
  `menuinfo_name` varchar(255) NOT NULL,
  `vendor_id` int(11) NOT NULL,
  `menuinfo_image1` varchar(255) DEFAULT '',
  `menuinfo_image2` varchar(255) DEFAULT '',
  `menuinfo_image3` varchar(255) DEFAULT '',
  `menuinfo_image4` varchar(255) DEFAULT '',
  `menuinfo_detail` text,
  `menuinfo_date` datetime NOT NULL,
  `menuinfo_startDate` datetime NOT NULL,
  `menuinfo_endDate` datetime NOT NULL,
  `menuinfo_status` int(4) NOT NULL DEFAULT '1',
  `menuinfo_point` float DEFAULT '0',
  `menuinfo_western` int(11) NOT NULL DEFAULT '0',
  `menuinfo_type` int(11) NOT NULL DEFAULT '0',
  `menuinfo_consumernum` int(11) DEFAULT '0',
  `menuinfo_bussinessAreaID` int(11) NOT NULL DEFAULT '-1',
  `menuinfo_price` float DEFAULT '0',
  PRIMARY KEY (`menuinfo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menuinfo
-- ----------------------------
INSERT INTO `t_menuinfo` VALUES ('1', '经典鸡肉咖喱饭', '1', 'upload\\menuinfo\\1.jpg', 'upload\\menuinfo\\2.jpg', 'upload\\menuinfo\\4.jpg', 'upload\\menuinfo\\1.jpg', '鲜艳的色彩是大自然的馈赠，红色的胡萝卜，绿色的青豆，白色的鸡肉，辅以姜黄色的咖喱，是少年眼中的世界。', '2015-04-15 17:00:00', '2015-04-23 16:58:55', '2015-04-21 10:30:00', '1', '4.2', '1', '6', '0', '5', '19');
INSERT INTO `t_menuinfo` VALUES ('2', '意式肉酱意大利面', '2', 'upload\\menuinfo\\3.jpg', 'upload\\menuinfo\\3.jpg', 'upload\\menuinfo\\5.jpg', 'upload\\menuinfo\\5.jpg', '高温沸煮，卷曲的意大利面必须找到最恰当的烹调时间，太长或太短，都不能获得最佳的弹性。', '2015-04-13 17:00:00', '2015-04-23 16:58:59', '2015-04-21 10:00:00', '0', '3.4', '1', '3', '0', '5', '19');
INSERT INTO `t_menuinfo` VALUES ('3', '宫保鸡丁', '3', 'upload\\menuinfo\\_EN_8403.jpg', 'upload\\menuinfo\\_EN_8399.jpg', 'upload\\menuinfo\\_EN_8419.jpg', 'upload\\menuinfo\\_EN_8403.jpg', '翠绿的鲜莴笋，带来破土而出的春意，清香阵阵，加入火候适当的大块鸡肉，肉质细嫩，是主打新鲜的组合。', '2015-01-21 09:19:26', '2015-04-23 16:59:02', '2015-04-10 00:00:00', '0', '2.6', '0', '3', '0', '5', '15');
INSERT INTO `t_menuinfo` VALUES ('5', '红烧小排饭123', '2', 'uploads\\goodsPic\\c512057ada784f0d86e3a3ac5ea87401.jpg', 'uploads\\goodsPic\\001f87951b264f90bfe04be4aa797ecc.jpg', 'uploads\\goodsPic\\bba2b4517dc64f4890de53d26c0263c8.jpg', 'uploads\\goodsPic\\bcaaec02aaf54f5794ed1d371dc849d5.jpg', '第一眼就被这道菜浓郁的色泽吸引，绛红色的小排层层堆叠，浸入饱满的酱汁，泛出诱人的光泽', '2015-04-22 10:58:27', '2015-04-23 16:59:04', '2015-04-10 00:00:00', '1', '2.5', '0', '1', '0', '3', '15');
INSERT INTO `t_menuinfo` VALUES ('6', '萨拉米肠披萨', '2', 'upload\\menuinfo\\640.jpg', 'upload\\menuinfo\\640.jpg', 'upload\\menuinfo\\640.jpg', 'upload\\menuinfo\\640.jpg', '意大利是披萨的故乡,随处可见红色屋顶的艺术之都。而这款披萨就像这个国度一般富有想象力，', '2015-04-23 20:33:20', '2015-04-22 16:59:07', '2015-04-21 10:30:00', '1', '11', '0', '1', '11', '3', '19');
INSERT INTO `t_menuinfo` VALUES ('7', '鸡肉培根布法罗披萨', '2', 'upload\\menuinfo\\640.jpg', 'upload\\menuinfo\\640.jpg', 'upload\\menuinfo\\640.jpg', 'upload\\menuinfo\\640.jpg', '以培根为主料的披萨，总是无法忽略其本身独特的烟熏香味，片成薄状，裹入鲜美多汁的蘑菇，一口咬下，厚实的口感，给唇齿带来双重的刺激。', '2015-04-13 17:00:00', '2015-04-23 16:59:09', '2015-04-14 10:30:00', '1', '5', '1', '6', '0', '3', '19');
INSERT INTO `t_menuinfo` VALUES ('9', '黑椒肉酱意大利面', '2', 'upload\\menuinfo\\7.jpg', 'upload\\menuinfo\\7.jpg', 'upload\\menuinfo\\7.jpg', 'upload\\menuinfo\\7.jpg', '高温沸煮，卷曲的意大利面必须找到最恰当的烹调时间，太长或太短，都不能获得最佳的弹性。', '2015-04-14 17:00:00', '2015-04-23 16:59:12', '2015-04-20 10:00:00', '1', '3.4', '1', '3', '0', '5', '19');
INSERT INTO `t_menuinfo` VALUES ('10', '海鲜咖喱饭', '2', 'upload\\menuinfo\\1.jpg', 'upload\\menuinfo\\1.jpg', 'upload\\menuinfo\\1.jpg', 'upload\\menuinfo\\1.jpg', '高温沸煮，卷曲的意大利面必须找到最恰当的烹调时间，太长或太短，都不能获得最佳的弹性。', '2015-04-14 17:00:00', '2015-04-23 16:59:15', '2015-04-20 10:00:00', '1', '3.4', '1', '3', '0', '5', '19');
INSERT INTO `t_menuinfo` VALUES ('11', '培根蘑菇肉松披萨', '2', 'upload\\menuinfo\\18.jpg', 'upload\\menuinfo\\18.jpg', 'upload\\menuinfo\\18.jpg', 'upload\\menuinfo\\18.jpg', '培根本身自带的烟熏香味，总是无法被人忽略，与新鲜蘑菇搭配在一起，使两者各自不同的口感相互融合，撒上絮状的肉松，与奶酪的组合，每当咬下时，都给人带来不一样的刺激。撒上絮状的肉松，整体的颜色与口味更加深一层。', '2015-04-15 17:00:00', '2015-04-23 16:59:17', '2015-04-16 10:30:00', '1', '0', '0', '3', '0', '5', '19');
INSERT INTO `t_menuinfo` VALUES ('12', '海鲜至尊披萨', '2', 'upload\\menuinfo\\28.jpg', 'upload\\menuinfo\\28.jpg', 'upload\\menuinfo\\28.jpg', 'upload\\menuinfo\\28.jpg', '鲜虾、鱿鱼、蟹肉，三者的组合带来大海的味道，水清沙白的中国南海，摇曳的椰林树影，穿越时空送给你清凉的季候风以及丰富的矿物质。丝状的青红甜椒，更像是一幅油画的底色，遵循抽象派的宗旨，不规则的撒下披萨草来完善细节，每一种配料的变换，都能成就全新的味觉生命。', '2015-04-15 17:00:00', '2015-04-23 16:59:19', '2015-04-21 10:30:00', '1', '0', '1', '3', '0', '5', '19');
INSERT INTO `t_menuinfo` VALUES ('13', '怒火意大利面', '2', 'upload\\menuinfo\\11.jpg', 'upload\\menuinfo\\11.jpg', 'upload\\menuinfo\\11.jpg', 'upload\\menuinfo\\11.jpg', '新鲜冷榨而成的橄榄油，在高温下沸腾，翻滚的意大利粉，再配上特制的辣酱，注定将是一道火热刺激的美食，专为爱好冒险挑战的食客而准备。正如它的名字一般，像一座蠢蠢欲动，将要喷发的火山，冲刺味觉的极限。', '2015-04-15 17:00:00', '2015-04-23 16:59:21', '2015-04-17 10:30:00', '1', '0', '1', '3', '0', '5', '19');

-- ----------------------------
-- Table structure for `t_menutype`
-- ----------------------------
DROP TABLE IF EXISTS `t_menutype`;
CREATE TABLE `t_menutype` (
  `menutype_id` int(11) NOT NULL AUTO_INCREMENT,
  `menutype_desc` varchar(255) NOT NULL,
  PRIMARY KEY (`menutype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menutype
-- ----------------------------
INSERT INTO `t_menutype` VALUES ('1', '猪肉');
INSERT INTO `t_menutype` VALUES ('2', '鱼肉');
INSERT INTO `t_menutype` VALUES ('3', '牛肉');
INSERT INTO `t_menutype` VALUES ('4', '蔬菜');
INSERT INTO `t_menutype` VALUES ('5', '咖喱饭');
INSERT INTO `t_menutype` VALUES ('6', '披萨');
INSERT INTO `t_menutype` VALUES ('7', '意大利面');
INSERT INTO `t_menutype` VALUES ('8', '鸡肉');

-- ----------------------------
-- Table structure for `t_menu_cookinfo`
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
-- Table structure for `t_menu_dishes`
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
-- Table structure for `t_officebuilding`
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_officebuilding
-- ----------------------------
INSERT INTO `t_officebuilding` VALUES ('11', '3', '1', '1', '1', '西安邮电大学（东区A点）');
INSERT INTO `t_officebuilding` VALUES ('12', '3', '1', '1', '1', '西安邮电大学（西区A点）');
INSERT INTO `t_officebuilding` VALUES ('13', '5', '1', '1', '1', '都市之门A座');
INSERT INTO `t_officebuilding` VALUES ('14', '5', '1', '1', '1', '都市之门B座');
INSERT INTO `t_officebuilding` VALUES ('15', '5', '1', '1', '1', '都市之门C座');
INSERT INTO `t_officebuilding` VALUES ('16', '5', '1', '1', '1', '都市之门D座');
INSERT INTO `t_officebuilding` VALUES ('17', '5', '1', '1', '1', '汇鑫IBC A座');
INSERT INTO `t_officebuilding` VALUES ('18', '5', '1', '1', '1', '汇鑫IBC B座');
INSERT INTO `t_officebuilding` VALUES ('19', '5', '1', '1', '1', '汇鑫IBC C座');
INSERT INTO `t_officebuilding` VALUES ('20', '5', '1', '1', '1', '汇鑫IBC D座');
INSERT INTO `t_officebuilding` VALUES ('21', '5', '1', '1', '1', '蓝海领地');
INSERT INTO `t_officebuilding` VALUES ('22', '5', '1', '1', '1', 'SOHO联盟A');
INSERT INTO `t_officebuilding` VALUES ('23', '5', '1', '1', '1', 'SOHO联盟B');

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_num` varchar(255) NOT NULL DEFAULT '',
  `user_id` int(11) NOT NULL,
  `order_menuinfo_id` int(11) NOT NULL,
  `box_id` int(11) NOT NULL,
  `order_startTime` datetime NOT NULL,
  `order_orderTime` datetime NOT NULL,
  `order_payStatus` int(11) NOT NULL DEFAULT '0',
  `S_order_ConsumeStatus` int(11) NOT NULL,
  `order_payTime` datetime DEFAULT NULL,
  `box_price` float NOT NULL,
  `order_isFirst` int(11) NOT NULL,
  `order_dispatching_id` int(11) NOT NULL,
  `order_settleStatus` int(11) NOT NULL,
  `order_status` int(11) NOT NULL DEFAULT '3',
  `order_notice` varchar(255) DEFAULT '',
  `order_phone` varchar(11) NOT NULL DEFAULT '',
  `order_nike` varchar(255) NOT NULL DEFAULT '',
  `order_gender` smallint(1) NOT NULL DEFAULT '0',
  `order_type` smallint(6) NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('20150311000001', '16', '5', '1', '2015-03-11 00:47:17', '2015-04-16 00:47:17', '0', '0', null, '12', '0', '30', '0', '0', '注意：饭量：中等 辣度：吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150311000003', '2', '5', '2', '2015-03-11 20:20:39', '2015-03-11 20:20:48', '0', '0', null, '36', '0', '4', '0', '0', '注意：饭量：小份 辣度：不吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150312000041', '1', '1', '3', '2015-03-12 15:31:54', '2015-03-11 15:31:54', '0', '0', null, '60', '0', '6', '0', '0', '注意：饭量：中等 辣度：吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150312000043', '24', '5', '3', '2015-03-12 20:47:32', '2015-03-12 20:47:39', '0', '0', null, '60', '0', '6', '0', '0', '注意：饭量：小份 辣度：不吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150313000005', '28', '5', '3', '2015-03-13 23:51:25', '2015-03-13 23:51:33', '0', '0', null, '60', '0', '7', '0', '0', '注意：饭量：小份 辣度：不吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150314000000', '28', '5', '1', '2015-03-14 08:06:22', '2015-03-14 08:06:51', '0', '0', null, '12', '0', '7', '0', '0', '注意：饭量：小份 辣度：不吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150317000035', '17', '5', '1', '2015-03-17 21:16:37', '2015-03-17 21:16:48', '0', '0', null, '15', '0', '8', '0', '0', '注意：饭量：小份 辣度：不吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150317000058', '1', '5', '1', '2015-03-17 23:26:20', '2015-03-17 23:26:20', '0', '0', null, '15', '0', '1', '0', '0', '注意：饭量：中等 辣度：吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150317000059', '31', '5', '1', '2015-03-17 23:31:36', '2015-03-17 23:31:44', '0', '0', null, '15', '0', '11', '0', '0', '注意：饭量：小份 辣度：不吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150317000060', '31', '5', '1', '2015-03-17 23:31:49', '2015-03-17 23:32:08', '0', '0', null, '15', '0', '11', '0', '1', '注意：饭量：小份 辣度：不吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150319000003', '1', '5', '3', '2015-03-19 15:37:55', '2015-03-19 15:37:55', '0', '0', null, '45', '0', '1', '0', '1', '注意：饭量：中等 辣度：吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150319000004', '31', '5', '1', '2015-03-19 15:44:07', '2015-03-19 15:44:12', '0', '0', null, '15', '0', '11', '0', '0', '注意：饭量：小份 辣度：不吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150320000011', '1', '5', '1', '2015-03-20 10:56:00', '2015-03-20 10:56:00', '1', '0', null, '15', '0', '1', '0', '3', '注意：饭量：中等 辣度：吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150323000001', '31', '5', '1', '2015-03-23 16:25:46', '2015-03-23 16:25:49', '0', '0', null, '15', '0', '11', '0', '0', '注意：饭量：小份 辣度：不吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150323000002', '31', '5', '1', '2015-03-23 16:26:20', '2015-03-13 16:12:22', '0', '0', null, '15', '0', '11', '0', '0', '注意：饭量：小份 辣度：不吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150323000005', '28', '5', '2', '2015-03-23 19:58:41', '2015-03-23 19:58:46', '0', '0', null, '30', '0', '7', '0', '1', '注意：饭量：小份 辣度：吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150324000013', '29', '5', '1', '2015-03-24 16:27:21', '2015-03-24 16:27:21', '0', '0', null, '15', '0', '12', '0', '0', '注意：饭量：中等 辣度：吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150324000014', '29', '5', '1', '2015-03-24 16:29:24', '2015-03-24 16:29:24', '0', '0', null, '15', '0', '12', '0', '0', '注意：饭量：中等 辣度：吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150324000015', '29', '5', '1', '2015-03-24 16:32:22', '2015-03-24 16:32:22', '0', '0', null, '15', '0', '12', '0', '0', '注意：饭量：中等 辣度：吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150324000016', '29', '5', '1', '2015-03-24 16:33:29', '2015-03-24 16:33:29', '3', '0', null, '15', '0', '12', '0', '0', '注意：饭量：中等 辣度：吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150324000017', '29', '5', '1', '2015-03-26 16:34:37', '2015-03-26 16:34:37', '0', '0', null, '15', '0', '12', '0', '3', '注意：饭量：中等 辣度：吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150327000000', '29', '5', '3', '2015-03-27 13:10:05', '2015-03-27 13:10:05', '0', '0', null, '45', '0', '12', '0', '2', '注意：饭量：中等 辣度：吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150327000001', '28', '5', '1', '2015-03-27 15:35:02', '2015-03-27 15:35:31', '0', '0', null, '0.01', '0', '7', '0', '0', '注意：饭量：小份 辣度：不吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150327000002', '28', '5', '1', '2015-03-27 15:35:41', '2015-03-27 15:35:47', '0', '0', null, '0.01', '0', '7', '0', '0', '注意：饭量：小份 辣度：不吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150327000003', '31', '5', '1', '2015-03-27 19:09:30', '2015-03-27 19:09:37', '0', '0', null, '0.01', '0', '11', '0', '0', '注意：饭量：小份 辣度：不吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150328000000', '1', '5', '1', '2015-03-28 06:54:29', '2015-03-28 06:54:29', '0', '0', null, '15', '0', '1', '0', '2', '注意：饭量：中等 辣度：吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150402000004', '18', '5', '2', '2015-04-02 16:42:42', '2015-04-02 16:42:42', '0', '0', null, '30', '0', '13', '0', '1', '注意：饭量：中等 辣度：吃辣', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150406000012', '1', '1', '1', '2015-04-06 23:19:51', '2015-04-06 23:19:51', '0', '0', null, '57', '0', '12', '0', '3', '', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150406000013', '1', '1', '1', '2015-04-06 23:20:04', '2015-04-06 23:20:04', '0', '0', null, '57', '0', '12', '0', '0', '', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150407000000', '1', '0', '1', '2015-04-07 00:38:24', '2015-04-07 00:38:24', '0', '0', null, '0', '0', '0', '0', '2', '', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150407000001', '1', '1', '1', '2015-04-07 01:43:40', '2015-04-07 01:43:40', '0', '0', null, '19', '0', '0', '0', '2', '', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150407000002', '1', '1', '1', '2015-04-07 01:44:12', '2015-04-07 01:44:12', '0', '0', null, '19', '0', '12', '0', '2', '', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150407000003', '1', '1', '1', '2015-04-07 03:03:13', '2015-04-07 03:03:13', '0', '0', null, '76', '0', '12', '0', '2', '', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150407000004', '1', '1', '1', '2015-04-07 04:50:06', '2015-04-07 04:50:06', '0', '0', null, '57', '0', '12', '0', '2', '', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150407000005', '29', '2', '1', '2015-04-07 05:01:26', '2015-04-07 05:01:26', '0', '0', null, '0', '0', '0', '0', '2', '', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150407000006', '29', '1', '1', '2015-04-07 05:02:00', '2015-04-07 05:02:00', '0', '0', null, '19', '0', '0', '0', '2', '', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150407000007', '29', '2', '1', '2015-04-07 05:29:11', '2015-04-07 05:29:11', '0', '0', null, '15', '0', '0', '0', '2', '', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150407000008', '29', '2', '1', '2015-04-07 05:39:37', '2015-04-07 05:39:37', '0', '0', null, '15', '0', '11', '0', '2', '', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150407000009', '1', '1', '1', '2015-04-07 05:40:40', '2015-04-07 05:40:40', '0', '0', null, '19', '0', '12', '0', '2', '', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150407000010', '29', '2', '1', '2015-04-07 05:41:58', '2015-04-07 05:41:58', '0', '0', null, '15', '0', '11', '0', '2', '', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150407000011', '1', '1', '1', '2015-04-07 05:42:45', '2015-04-07 05:42:45', '0', '0', null, '19', '0', '11', '0', '2', '', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150407000012', '29', '1', '1', '2015-04-07 13:38:07', '2015-04-07 13:38:07', '0', '0', null, '19', '0', '11', '0', '0', '', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150407000013', '28', '1', '1', '2015-04-07 13:54:32', '2015-04-07 13:54:32', '0', '0', null, '19', '0', '12', '0', '0', '', '0', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150407000034', '56', '1', '1', '2015-04-07 21:30:01', '2015-04-07 21:30:01', '0', '0', null, '19', '0', '11', '0', '0', '', '15910535608', ' 曹伟', '0', '0');
INSERT INTO `t_order` VALUES ('20150407000035', '53', '2', '1', '2015-04-07 21:30:15', '2015-04-07 21:30:15', '0', '0', null, '19', '0', '12', '0', '0', '', '15809200450', '郭', '0', '0');
INSERT INTO `t_order` VALUES ('20150407000037', '57', '2', '1', '2015-04-07 21:32:22', '2015-04-07 21:32:22', '0', '0', null, '19', '0', '11', '0', '0', '', '18829288756', '苏苏', '1', '0');
INSERT INTO `t_order` VALUES ('20150407000038', '54', '2', '1', '2015-04-07 22:31:29', '2015-04-07 22:31:29', '0', '0', null, '19', '0', '12', '0', '0', '', '15389448351', '王畅', '0', '0');
INSERT INTO `t_order` VALUES ('20150408000000', '31', '1', '1', '2015-04-08 16:40:13', '2015-04-08 16:40:13', '0', '0', null, '19', '0', '12', '0', '0', '', '15029485462', '吴', '0', '0');
INSERT INTO `t_order` VALUES ('20150408000001', '1', '7', '1', '2015-04-08 16:42:24', '2015-04-08 16:42:24', '0', '0', null, '19', '0', '11', '0', '0', '', '18930852101', '啊咯', '0', '0');
INSERT INTO `t_order` VALUES ('20150408000002', '29', '7', '1', '2015-04-08 16:59:11', '2015-04-08 16:59:11', '0', '0', null, '19', '0', '12', '0', '0', '', '18995123080', '陈', '0', '0');
INSERT INTO `t_order` VALUES ('20150408000003', '18', '7', '1', '2015-04-08 17:00:27', '2015-04-08 17:00:27', '0', '0', null, '19', '0', '11', '0', '0', '', '13991370112', '陈名佳', '0', '0');
INSERT INTO `t_order` VALUES ('20150408000004', '18', '7', '1', '2015-04-08 17:57:13', '2015-04-08 17:57:13', '0', '0', null, '19', '0', '12', '0', '0', '', '13991370112', '陈名佳', '0', '0');
INSERT INTO `t_order` VALUES ('20150408000005', '54', '7', '1', '2015-04-08 18:26:48', '2015-04-08 18:26:48', '0', '0', null, '19', '0', '12', '0', '0', '', '15389448351', '王畅', '0', '0');
INSERT INTO `t_order` VALUES ('20150408000006', '54', '7', '1', '2015-04-08 18:26:48', '2015-04-08 18:26:48', '0', '0', null, '19', '0', '12', '0', '0', '', '15389448351', '王畅', '0', '0');
INSERT INTO `t_order` VALUES ('20150408000007', '1', '7', '1', '2015-04-08 18:37:56', '2015-04-08 18:37:56', '0', '0', null, '19', '0', '12', '0', '0', '', '18930852101', '陈生珠', '1', '0');
INSERT INTO `t_order` VALUES ('20150408000008', '18', '7', '1', '2015-04-08 18:42:01', '2015-04-08 18:42:01', '0', '0', null, '19', '0', '12', '0', '0', '', '13991370112', '陈名佳', '0', '0');
INSERT INTO `t_order` VALUES ('20150408000009', '53', '7', '1', '2015-04-08 18:44:32', '2015-04-08 18:44:32', '0', '0', null, '19', '0', '12', '0', '0', '', '15809200450', '郭', '0', '0');
INSERT INTO `t_order` VALUES ('20150408000019', '60', '7', '1', '2015-04-08 22:40:35', '2015-04-08 22:40:35', '0', '0', null, '19', '0', '11', '0', '0', '', '13809183166', '孙哥', '1', '0');
INSERT INTO `t_order` VALUES ('20150408000020', '61', '7', '1', '2015-04-08 22:52:41', '2015-04-08 22:52:41', '0', '0', null, '19', '0', '12', '0', '0', '', '18220192436', 'zhangmei', '0', '0');
INSERT INTO `t_order` VALUES ('20150408000021', '62', '7', '1', '2015-04-08 23:15:50', '2015-04-08 23:15:50', '0', '0', null, '19', '0', '12', '0', '0', '', '13484533259', '牛金阁', '0', '0');
INSERT INTO `t_order` VALUES ('20150409000001', '31', '7', '1', '2015-04-09 15:53:48', '2015-04-09 15:53:48', '0', '0', null, '19', '0', '12', '0', '0', '', '15029485462', '吴', '0', '0');
INSERT INTO `t_order` VALUES ('20150409000002', '18', '7', '1', '2015-04-09 16:12:42', '2015-04-09 16:12:42', '0', '0', null, '19', '0', '12', '0', '0', '', '13991370112', '陈名佳', '0', '0');
INSERT INTO `t_order` VALUES ('20150409000003', '1', '7', '1', '2015-04-09 16:22:04', '2015-04-09 16:22:04', '0', '0', null, '19', '0', '11', '0', '0', '', '18930852101', '陈生珠', '0', '0');
INSERT INTO `t_order` VALUES ('20150409000006', '64', '1', '1', '2015-04-09 18:13:00', '2015-04-09 18:13:00', '0', '0', null, '19', '0', '12', '0', '0', '', '13659213407', '陈婧瑶', '0', '0');
INSERT INTO `t_order` VALUES ('20150409000007', '65', '1', '1', '2015-04-09 18:37:18', '2015-04-09 18:37:18', '0', '0', null, '19', '0', '12', '0', '0', '', '15829207763', '刘', '0', '0');
INSERT INTO `t_order` VALUES ('20150409000008', '66', '1', '1', '2015-04-09 18:41:50', '2015-04-09 18:41:50', '0', '0', null, '19', '0', '12', '0', '0', '', '18829291986', '方', '0', '0');
INSERT INTO `t_order` VALUES ('20150409000009', '66', '1', '1', '2015-04-09 18:41:53', '2015-04-09 18:41:53', '0', '0', null, '19', '0', '12', '0', '0', '', '18829291986', '方', '0', '0');
INSERT INTO `t_order` VALUES ('20150409000010', '67', '2', '1', '2015-04-09 18:56:43', '2015-04-09 18:56:43', '0', '0', null, '57', '0', '12', '0', '0', '', '18829290611', '李豆豆', '0', '0');
INSERT INTO `t_order` VALUES ('20150409000013', '60', '1', '1', '2015-04-09 23:01:13', '2015-04-09 23:01:13', '0', '0', null, '19', '0', '11', '0', '0', '', '13809183166', '孙哥哥', '1', '0');
INSERT INTO `t_order` VALUES ('20150409000014', '68', '1', '1', '2015-04-09 23:03:31', '2015-04-09 23:03:31', '0', '0', null, '19', '0', '11', '0', '0', '', '15596899673', '山林', '1', '0');
INSERT INTO `t_order` VALUES ('20150412000000', '69', '7', '1', '2015-04-12 18:29:57', '2015-04-12 18:29:57', '0', '0', null, '38', '0', '11', '0', '0', '', '13186017135', '赵思晨', '0', '0');
INSERT INTO `t_order` VALUES ('20150412000001', '69', '7', '1', '2015-04-12 18:29:57', '2015-04-12 18:29:57', '0', '0', null, '38', '0', '11', '0', '0', '', '13186017135', '赵思晨', '0', '0');
INSERT INTO `t_order` VALUES ('20150412000002', '70', '7', '1', '2015-04-12 18:45:46', '2015-04-12 18:45:46', '0', '0', null, '19', '0', '11', '0', '0', '', '13259438592', '张地', '1', '0');
INSERT INTO `t_order` VALUES ('20150412000003', '71', '7', '1', '2015-04-12 18:52:15', '2015-04-12 18:52:15', '0', '0', null, '19', '0', '11', '0', '0', '', '18710901841', '吴', '0', '0');
INSERT INTO `t_order` VALUES ('20150412000004', '72', '7', '1', '2015-04-12 18:59:09', '2015-04-12 18:59:09', '0', '0', null, '19', '0', '12', '0', '0', '', '18829288581', '薛璐', '0', '0');
INSERT INTO `t_order` VALUES ('20150412000005', '73', '7', '1', '2015-04-12 19:11:39', '2015-04-12 19:11:39', '0', '0', null, '19', '0', '11', '0', '0', '', '13259493560', '张晋睿', '1', '0');
INSERT INTO `t_order` VALUES ('20150412000006', '62', '7', '1', '2015-04-12 20:15:14', '2015-04-12 20:15:14', '0', '0', null, '19', '0', '12', '0', '0', '', '13484533259', '牛金阁', '0', '0');
INSERT INTO `t_order` VALUES ('20150412000007', '74', '7', '1', '2015-04-12 20:39:36', '2015-04-12 20:39:36', '0', '0', null, '19', '0', '12', '0', '0', '', '18829290465', '赵林航', '1', '0');
INSERT INTO `t_order` VALUES ('20150412000008', '75', '7', '1', '2015-04-12 21:48:03', '2015-04-12 21:48:03', '0', '0', null, '19', '0', '12', '0', '0', '', '13429774265', '王月', '0', '0');
INSERT INTO `t_order` VALUES ('20150412000009', '76', '7', '1', '2015-04-12 21:48:44', '2015-04-12 21:48:44', '0', '0', null, '19', '0', '12', '0', '0', '', '15091832170', '庞新宇', '0', '0');
INSERT INTO `t_order` VALUES ('20150412000010', '77', '7', '1', '2015-04-12 22:25:30', '2015-04-12 22:25:30', '0', '0', null, '38', '0', '11', '0', '0', '', '13152470397', '赵汉青', '1', '0');
INSERT INTO `t_order` VALUES ('20150412000011', '78', '7', '1', '2015-04-12 22:54:57', '2015-04-12 22:54:57', '0', '0', null, '19', '0', '12', '0', '0', '', '15091851774', '张莹', '0', '0');
INSERT INTO `t_order` VALUES ('20150412000012', '60', '7', '1', '2015-04-12 23:25:04', '2015-04-12 23:25:04', '0', '0', null, '19', '0', '11', '0', '0', '', '13809183166', '孙哥哥', '1', '0');
INSERT INTO `t_order` VALUES ('20150412000013', '68', '7', '1', '2015-04-12 23:29:08', '2015-04-12 23:29:08', '0', '0', null, '19', '0', '11', '0', '0', '', '15596899673', '山林', '1', '0');
INSERT INTO `t_order` VALUES ('20150412000014', '79', '7', '1', '2015-04-12 23:34:16', '2015-04-12 23:34:16', '0', '0', null, '19', '0', '11', '0', '0', '', '18654125607', '代宏', '1', '0');
INSERT INTO `t_order` VALUES ('20150412000015', '80', '7', '1', '2015-04-12 23:56:07', '2015-04-12 23:56:07', '0', '0', null, '19', '0', '12', '0', '0', '', '18829272693', '高悦', '0', '0');
INSERT INTO `t_order` VALUES ('20150412000016', '81', '7', '1', '2015-04-12 23:59:21', '2015-04-12 23:59:21', '0', '0', null, '19', '0', '11', '0', '0', '', '13152492838', '臧辛桐', '0', '0');
INSERT INTO `t_order` VALUES ('20150413000000', '82', '7', '1', '2015-04-13 01:23:44', '2015-04-13 01:23:44', '0', '0', null, '19', '0', '12', '0', '2', '', '15129029986', '赵鸿硕', '1', '0');
INSERT INTO `t_order` VALUES ('20150413000001', '53', '7', '1', '2015-04-13 08:31:50', '2015-04-13 08:31:50', '0', '0', null, '19', '0', '12', '0', '2', '', '15809200450', '郭婷', '0', '0');
INSERT INTO `t_order` VALUES ('20150413000002', '84', '2', '1', '2015-04-13 17:47:23', '2015-04-13 17:47:23', '0', '0', null, '19', '0', '11', '0', '0', '', '18729239826', '张', '0', '0');
INSERT INTO `t_order` VALUES ('20150413000003', '83', '7', '1', '2015-04-13 17:51:29', '2015-04-13 17:51:29', '0', '0', null, '19', '0', '11', '0', '0', '', '18710419469', '张', '1', '0');
INSERT INTO `t_order` VALUES ('20150413000004', '85', '2', '1', '2015-04-13 19:39:51', '2015-04-13 19:39:51', '0', '0', null, '19', '0', '11', '0', '0', '', '18066635509', '李卉宁', '0', '0');
INSERT INTO `t_order` VALUES ('20150413000005', '86', '7', '1', '2015-04-13 20:56:51', '2015-04-13 20:56:51', '0', '0', null, '19', '0', '12', '0', '0', '', '13609194954', '周佩佩', '0', '0');
INSERT INTO `t_order` VALUES ('20150413000006', '87', '7', '1', '2015-04-13 21:11:54', '2015-04-13 21:11:54', '0', '0', null, '19', '0', '12', '0', '0', '', '18609584392', '石', '1', '0');
INSERT INTO `t_order` VALUES ('20150413000007', '88', '7', '1', '2015-04-13 21:24:09', '2015-04-13 21:24:09', '0', '0', null, '19', '0', '12', '0', '0', '', '15829308070', '马心浩', '1', '0');
INSERT INTO `t_order` VALUES ('20150413000008', '89', '7', '1', '2015-04-13 22:52:22', '2015-04-13 22:52:22', '0', '0', null, '19', '0', '12', '0', '0', '', '15091765914', '赵思琪', '0', '0');
INSERT INTO `t_order` VALUES ('20150413000009', '90', '2', '1', '2015-04-13 23:35:55', '2015-04-13 23:35:55', '0', '0', null, '19', '0', '12', '0', '0', '', '18710902163', '白丹', '0', '0');
INSERT INTO `t_order` VALUES ('20150414000000', '91', '1', '1', '2015-04-14 00:17:31', '2015-04-14 00:17:31', '0', '0', null, '19', '0', '12', '0', '2', '', '15809207264', '闫溪', '0', '0');
INSERT INTO `t_order` VALUES ('20150414000001', '92', '1', '1', '2015-04-14 08:13:10', '2015-04-14 08:13:10', '0', '0', null, '19', '0', '12', '0', '2', '', '18829289183', '刘岩', '1', '0');
INSERT INTO `t_order` VALUES ('20150414000002', '93', '1', '1', '2015-04-14 08:21:32', '2015-04-14 08:21:32', '0', '0', null, '38', '0', '11', '0', '2', '', '15667022370', '段唐奇', '1', '0');
INSERT INTO `t_order` VALUES ('20150414000003', '93', '1', '1', '2015-04-14 08:24:13', '2015-04-14 08:24:13', '0', '0', null, '19', '0', '11', '0', '2', '', '15667022370', '段唐奇', '1', '0');
INSERT INTO `t_order` VALUES ('20150414000004', '94', '9', '1', '2015-04-14 17:23:38', '2015-04-14 17:23:38', '0', '0', null, '57', '0', '11', '0', '0', '', '18829292575', '熊同学', '0', '0');
INSERT INTO `t_order` VALUES ('20150414000005', '73', '10', '1', '2015-04-14 18:40:32', '2015-04-14 18:40:32', '0', '0', null, '19', '0', '11', '0', '0', '', '13259493560', '张晋睿', '1', '0');
INSERT INTO `t_order` VALUES ('20150414000006', '77', '9', '1', '2015-04-14 20:06:39', '2015-04-14 20:06:39', '0', '0', null, '19', '0', '11', '0', '0', '', '13152470397', '赵汉青', '1', '0');
INSERT INTO `t_order` VALUES ('20150414000007', '95', '10', '1', '2015-04-14 22:40:52', '2015-04-14 22:40:52', '0', '0', null, '19', '0', '11', '0', '0', '', '15929369298', '杜安', '0', '0');
INSERT INTO `t_order` VALUES ('20150414000008', '96', '6', '1', '2015-04-14 23:06:02', '2015-04-14 23:06:02', '0', '0', null, '19', '0', '11', '0', '0', '', '13149286361', '齐烁', '0', '0');
INSERT INTO `t_order` VALUES ('20150415000000', '97', '9', '1', '2015-04-15 00:22:10', '2015-04-15 00:22:10', '0', '0', null, '19', '0', '11', '0', '2', '', '18537506157', '肖', '1', '0');
INSERT INTO `t_order` VALUES ('20150415000010', '28', '1', '1', '2015-04-15 00:44:30', '2015-04-15 00:45:04', '0', '0', null, '209', '0', '7', '0', '2', '注意：饭量：中等 辣度：吃辣', '', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150415000011', '68', '9', '1', '2015-04-15 01:10:48', '2015-04-15 01:10:48', '0', '0', null, '19', '0', '11', '0', '2', '', '15596899673', '山林', '1', '0');
INSERT INTO `t_order` VALUES ('20150415000012', '98', '9', '1', '2015-04-15 07:37:09', '2015-04-15 07:37:09', '0', '0', null, '19', '0', '12', '0', '2', '', '15809260512', '冉梦佳', '0', '0');
INSERT INTO `t_order` VALUES ('20150415000013', '99', '9', '1', '2015-04-15 07:39:04', '2015-04-15 07:39:04', '0', '0', null, '19', '0', '12', '0', '2', '', '15809291324', '曹雅婷', '0', '0');
INSERT INTO `t_order` VALUES ('20150415000014', '100', '9', '1', '2015-04-15 08:38:19', '2015-04-15 08:38:19', '0', '0', null, '38', '0', '11', '0', '2', '', '13763869767', '徐稀饭', '0', '0');
INSERT INTO `t_order` VALUES ('20150415000015', '100', '9', '1', '2015-04-15 08:39:11', '2015-04-15 08:39:11', '0', '0', null, '19', '0', '11', '0', '2', '', '13763869767', '徐稀饭', '0', '0');
INSERT INTO `t_order` VALUES ('20150415000016', '101', '10', '1', '2015-04-15 09:57:33', '2015-04-15 09:57:33', '0', '0', null, '19', '0', '11', '0', '2', '', '13259431172', '陶荣花', '0', '0');
INSERT INTO `t_order` VALUES ('20150415000017', '102', '9', '1', '2015-04-15 09:59:40', '2015-04-15 09:59:40', '0', '0', null, '38', '0', '11', '0', '2', '', '13772041546', '段唐奇', '1', '0');
INSERT INTO `t_order` VALUES ('20150415000018', '102', '6', '1', '2015-04-15 10:05:58', '2015-04-15 10:05:58', '0', '0', null, '19', '0', '11', '0', '2', '', '13772041546', '段唐奇', '1', '0');
INSERT INTO `t_order` VALUES ('20150415000019', '104', '1', '1', '2015-04-15 19:24:44', '2015-04-15 19:24:44', '0', '0', null, '19', '0', '11', '0', '0', '', '15091679720', '薛茹馨', '0', '0');
INSERT INTO `t_order` VALUES ('20150415000020', '60', '9', '1', '2015-04-15 20:15:46', '2015-04-15 20:15:46', '0', '0', null, '19', '0', '11', '0', '0', '', '13809183166', '孙哥哥', '1', '0');
INSERT INTO `t_order` VALUES ('20150415000021', '112', '9', '1', '2015-04-15 21:39:55', '2015-04-15 21:39:55', '0', '0', null, '19', '0', '11', '0', '0', '', '15667689009', '张同学', '0', '0');
INSERT INTO `t_order` VALUES ('20150415000022', '120', '1', '1', '2015-04-15 22:17:31', '2015-04-15 22:17:31', '0', '0', null, '19', '0', '12', '0', '0', '', '18706862282', '李绍勋', '1', '0');
INSERT INTO `t_order` VALUES ('20150415000023', '129', '9', '1', '2015-04-15 23:11:20', '2015-04-15 23:11:20', '0', '0', null, '19', '0', '12', '0', '0', '', '15829209589', '杨小啦', '1', '0');
INSERT INTO `t_order` VALUES ('20150415000024', '130', '9', '1', '2015-04-15 23:32:13', '2015-04-15 23:32:13', '0', '0', null, '19', '0', '11', '0', '0', '', '13259426813', '仵佩', '0', '0');
INSERT INTO `t_order` VALUES ('20150415000025', '130', '9', '1', '2015-04-15 23:39:56', '2015-04-15 23:39:56', '0', '0', null, '19', '0', '12', '0', '0', '', '13259426813', '吴京蔚', '0', '0');
INSERT INTO `t_order` VALUES ('20150415000026', '68', '1', '1', '2015-04-15 23:43:46', '2015-04-15 23:43:46', '0', '0', null, '19', '0', '11', '0', '0', '', '15596899673', '山林', '1', '0');
INSERT INTO `t_order` VALUES ('20150416000000', '70', '9', '1', '2015-04-16 09:41:48', '2015-04-16 09:41:48', '0', '0', null, '19', '0', '11', '0', '2', '', '13259438592', '张地', '1', '0');
INSERT INTO `t_order` VALUES ('20150416000001', '100', '1', '1', '2015-04-16 09:55:44', '2015-04-16 09:55:44', '0', '0', null, '38', '0', '11', '0', '2', '', '13763869767', '徐稀饭', '0', '0');
INSERT INTO `t_order` VALUES ('20150416000002', '100', '11', '1', '2015-04-16 09:56:12', '2015-04-16 09:56:12', '0', '0', null, '19', '0', '11', '0', '2', '', '13763869767', '徐稀饭', '0', '0');
INSERT INTO `t_order` VALUES ('20150416000003', '136', '9', '1', '2015-04-16 10:01:17', '2015-04-16 10:01:17', '0', '0', null, '19', '0', '11', '0', '2', '', '18829290144', '王维', '1', '0');
INSERT INTO `t_order` VALUES ('20150416000004', '77', '1', '1', '2015-04-16 19:37:13', '2015-04-16 19:37:13', '0', '0', null, '19', '0', '11', '0', '0', '', '13152470397', '赵汉青', '1', '0');
INSERT INTO `t_order` VALUES ('20150416000005', '60', '13', '1', '2015-04-16 19:50:23', '2015-04-16 19:50:23', '0', '0', null, '19', '0', '11', '0', '0', '', '13809183166', '孙哥哥', '1', '0');
INSERT INTO `t_order` VALUES ('20150416000006', '68', '1', '1', '2015-04-16 19:51:11', '2015-04-16 19:51:11', '0', '0', null, '19', '0', '11', '0', '0', '', '15596899673', '山林', '1', '0');
INSERT INTO `t_order` VALUES ('20150416000007', '104', '12', '1', '2015-04-16 20:21:02', '2015-04-16 20:21:02', '0', '0', null, '19', '0', '11', '0', '0', '', '15091679720', '薛机智', '0', '0');
INSERT INTO `t_order` VALUES ('20150416000008', '141', '12', '1', '2015-04-16 22:40:10', '2015-04-16 22:40:10', '0', '0', null, '19', '0', '11', '0', '0', '', '18700993021', '曹新涛', '0', '0');
INSERT INTO `t_order` VALUES ('20150417000000', '102', '13', '1', '2015-04-17 09:00:51', '2015-04-17 09:00:51', '0', '0', null, '38', '0', '11', '0', '2', '', '13772041546', '蜡笔小新', '0', '0');
INSERT INTO `t_order` VALUES ('20150417000001', '142', '13', '1', '2015-04-17 10:06:09', '2015-04-17 10:06:09', '0', '0', null, '38', '0', '11', '0', '2', '', '18092417706', '胡晓月', '0', '0');
INSERT INTO `t_order` VALUES ('20150417000002', '143', '13', '1', '2015-04-17 10:08:59', '2015-04-17 10:08:59', '0', '0', null, '19', '0', '11', '0', '2', '', '15809271417', '郝月', '0', '0');
INSERT INTO `t_order` VALUES ('20150417000003', '92', '12', '1', '2015-04-17 10:22:07', '2015-04-17 10:22:07', '0', '0', null, '19', '0', '12', '0', '2', '', '18829289183', '刘岩', '1', '0');
INSERT INTO `t_order` VALUES ('20150419000006', '69', '6', '1', '2015-04-19 19:53:06', '2015-04-19 19:53:06', '0', '0', null, '19', '0', '11', '0', '0', '', '13186017135', '赵思晨', '0', '0');
INSERT INTO `t_order` VALUES ('20150419000017', '60', '10', '1', '2015-04-19 20:37:59', '2015-04-19 20:37:59', '0', '0', null, '19', '0', '11', '0', '0', '', '13809183166', '孙同学', '1', '0');
INSERT INTO `t_order` VALUES ('20150419000054', '1', '5', '1', '2015-04-19 21:18:23', '2015-04-19 21:18:23', '4', '0', null, '15', '0', '14', '0', '5', '注意：饭量：中等 辣度：吃辣', '', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150419000055', '144', '10', '1', '2015-04-19 21:43:32', '2015-04-19 21:43:32', '0', '0', null, '19', '0', '11', '0', '0', '', '18182632218', '于明慧', '0', '0');
INSERT INTO `t_order` VALUES ('20150419000056', '145', '10', '1', '2015-04-19 21:46:01', '2015-04-19 21:46:01', '0', '0', null, '19', '0', '11', '0', '0', '', '18691763598', '杨楠楠', '0', '0');
INSERT INTO `t_order` VALUES ('20150419000057', '73', '9', '1', '2015-04-19 22:10:32', '2015-04-19 22:10:32', '0', '0', null, '19', '0', '11', '0', '0', '', '13259493560', '张晋睿', '1', '0');
INSERT INTO `t_order` VALUES ('20150419000058', '73', '9', '1', '2015-04-19 22:10:32', '2015-04-19 22:10:32', '0', '0', null, '19', '0', '11', '0', '0', '', '13259493560', '张晋睿', '1', '0');
INSERT INTO `t_order` VALUES ('20150419000059', '68', '10', '1', '2015-04-19 22:58:29', '2015-04-19 22:58:29', '0', '0', null, '19', '0', '11', '0', '0', '', '15596899673', '山林', '1', '0');
INSERT INTO `t_order` VALUES ('20150419000061', '146', '6', '1', '2015-04-19 23:03:39', '2015-04-19 23:03:39', '0', '0', null, '19', '0', '12', '0', '0', '', '18392101891', '冯悦', '0', '0');
INSERT INTO `t_order` VALUES ('20150420000000', '102', '9', '1', '2015-04-20 08:39:47', '2015-04-20 08:39:47', '0', '0', null, '38', '0', '11', '0', '2', '', '13772041546', '东区2号楼', '1', '0');
INSERT INTO `t_order` VALUES ('20150420000001', '76', '10', '1', '2015-04-20 09:51:05', '2015-04-20 09:51:05', '0', '0', null, '19', '0', '12', '0', '2', '', '15091832170', '庞新宇', '0', '0');
INSERT INTO `t_order` VALUES ('20150420000002', '76', '10', '1', '2015-04-20 09:51:14', '2015-04-20 09:51:14', '0', '0', null, '19', '0', '12', '0', '2', '', '15091832170', '庞新宇', '0', '0');
INSERT INTO `t_order` VALUES ('20150420000003', '123', '6', '1', '2015-04-20 10:10:54', '2015-04-20 10:10:54', '0', '0', null, '19', '0', '11', '0', '2', '', '13720495414', '詹家佳', '0', '0');
INSERT INTO `t_order` VALUES ('20150420000036', '147', '5', '1', '2015-04-20 15:33:56', '2015-04-20 15:33:56', '3', '0', null, '15', '0', '17', '0', '0', '注意：饭量：中等 辣度：吃辣', '', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150420000037', '69', '2', '1', '2015-04-20 17:22:40', '2015-04-20 17:22:40', '3', '0', null, '38', '0', '11', '0', '0', '', '13186017135', '赵思晨', '0', '0');
INSERT INTO `t_order` VALUES ('20150420000038', '147', '1', '1', '2015-04-20 17:37:01', '2015-04-20 17:37:01', '3', '0', null, '19', '0', '11', '0', '0', '', '18017866798', '陈全', '1', '0');
INSERT INTO `t_order` VALUES ('20150420000046', '85', '12', '1', '2015-04-20 18:12:25', '2015-04-20 18:12:25', '0', '0', null, '19', '0', '11', '0', '0', '', '18066635509', '李卉宁', '0', '0');
INSERT INTO `t_order` VALUES ('20150420000048', '60', '1', '1', '2015-04-20 18:18:51', '2015-04-20 18:18:51', '0', '0', null, '19', '0', '11', '0', '0', '', '13809183166', '孙同学', '1', '0');
INSERT INTO `t_order` VALUES ('20150420000049', '148', '2', '1', '2015-04-20 18:32:25', '2015-04-20 18:32:25', '0', '0', null, '19', '0', '11', '0', '0', '', '15667025716', '樊易腾', '1', '0');
INSERT INTO `t_order` VALUES ('20150420000050', '53', '12', '1', '2015-04-20 19:48:09', '2015-04-20 19:48:09', '0', '0', null, '19', '0', '12', '0', '0', '', '15809200450', '郭婷', '0', '0');
INSERT INTO `t_order` VALUES ('20150420000051', '53', '12', '1', '2015-04-20 19:48:10', '2015-04-20 19:48:10', '0', '0', null, '19', '0', '12', '0', '0', '', '15809200450', '郭婷', '0', '0');
INSERT INTO `t_order` VALUES ('20150420000053', '145', '12', '1', '2015-04-20 22:54:25', '2015-04-20 22:54:25', '0', '0', null, '19', '0', '11', '0', '0', '', '18691763598', '杨楠楠', '0', '0');
INSERT INTO `t_order` VALUES ('20150420000055', '68', '2', '1', '2015-04-20 23:00:00', '2015-04-20 23:00:00', '0', '0', null, '19', '0', '11', '0', '0', '', '15596899673', '山林', '1', '0');
INSERT INTO `t_order` VALUES ('20150420000057', '150', '2', '1', '2015-04-20 23:29:08', '2015-04-20 23:29:08', '0', '0', null, '19', '0', '11', '0', '0', '', '18829289010', '孙璐', '0', '0');
INSERT INTO `t_order` VALUES ('20150421000000', '18', '6', '1', '2015-04-21 00:01:52', '2015-04-21 00:01:52', '2', '0', null, '15', '0', '13', '0', '1', '注意：饭量：小份 辣度：不吃辣', '', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150421000008', '73', '1', '1', '2015-04-21 00:33:06', '2015-04-21 00:33:06', '0', '0', null, '19', '0', '11', '0', '0', '', '13259493560', '张晋睿', '1', '0');
INSERT INTO `t_order` VALUES ('20150421000009', '1', '5', '1', '2015-04-21 02:04:58', '2015-04-21 02:04:58', '0', '0', null, '15', '0', '14', '0', '0', '注意：饭量：中等 辣度：吃辣', '', '', '0', '0');
INSERT INTO `t_order` VALUES ('20150421000010', '1', '1', '1', '2015-04-21 02:21:36', '2015-04-21 02:21:36', '0', '0', null, '19', '0', '11', '0', '0', '', '18930852101', '陈生珠', '1', '0');
INSERT INTO `t_order` VALUES ('20150421000011', '54', '12', '1', '2015-04-21 08:23:01', '2015-04-21 08:23:01', '0', '0', null, '19', '0', '12', '0', '0', '', '15389448351', '王畅', '0', '0');
INSERT INTO `t_order` VALUES ('20150421000012', '152', '2', '1', '2015-04-21 08:58:21', '2015-04-21 08:58:21', '0', '0', null, '19', '0', '11', '0', '0', '', '13772015530', '李慧颖', '0', '0');
INSERT INTO `t_order` VALUES ('20150421000013', '153', '1', '1', '2015-04-21 08:58:22', '2015-04-21 08:58:22', '0', '0', null, '19', '0', '11', '0', '0', '', '15891716850', '尤雅青', '0', '0');
INSERT INTO `t_order` VALUES ('20150421000014', '153', '12', '1', '2015-04-21 09:06:39', '2015-04-21 09:06:39', '0', '0', null, '19', '0', '11', '0', '0', '', '15891716850', '尤雅青', '0', '0');

-- ----------------------------
-- Table structure for `t_orderrefund`
-- ----------------------------
DROP TABLE IF EXISTS `t_orderrefund`;
CREATE TABLE `t_orderrefund` (
  `orderrefund_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_num` varchar(255) NOT NULL,
  `orderrefund_reason` int(11) NOT NULL,
  `orderrefund_status` int(11) NOT NULL,
  `orderrefund_result` int(11) NOT NULL,
  `orderrefund_date` datetime DEFAULT NULL,
  PRIMARY KEY (`orderrefund_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_orderrefund
-- ----------------------------
INSERT INTO `t_orderrefund` VALUES ('1', '20150419000062', '1', '0', '0', '2015-04-19 23:54:34');
INSERT INTO `t_orderrefund` VALUES ('3', '20150420000005', '1', '0', '0', '2015-04-20 11:28:14');

-- ----------------------------
-- Table structure for `t_point`
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
  `province_name` varchar(255) NOT NULL,
  PRIMARY KEY (`province_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_province
-- ----------------------------
INSERT INTO `t_province` VALUES ('3', '陕西省');

-- ----------------------------
-- Table structure for `t_refundreason`
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
-- Table structure for `t_registeraddress`
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
  `role_authority_roleid` int(11) NOT NULL,
  `role_authority_authorityid` int(11) NOT NULL,
  PRIMARY KEY (`role_authority_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_authority
-- ----------------------------
INSERT INTO `t_role_authority` VALUES ('2', '1', '2');
INSERT INTO `t_role_authority` VALUES ('4', '1', '4');
INSERT INTO `t_role_authority` VALUES ('5', '1', '5');
INSERT INTO `t_role_authority` VALUES ('7', '3', '2');
INSERT INTO `t_role_authority` VALUES ('9', '2', '6');
INSERT INTO `t_role_authority` VALUES ('10', '3', '2');
INSERT INTO `t_role_authority` VALUES ('27', '2', '5');
INSERT INTO `t_role_authority` VALUES ('28', '4', '1');
INSERT INTO `t_role_authority` VALUES ('29', '4', '2');
INSERT INTO `t_role_authority` VALUES ('30', '4', '5');
INSERT INTO `t_role_authority` VALUES ('31', '4', '3');
INSERT INTO `t_role_authority` VALUES ('32', '4', '4');
INSERT INTO `t_role_authority` VALUES ('36', '1', '3');
INSERT INTO `t_role_authority` VALUES ('37', '2', '2');
INSERT INTO `t_role_authority` VALUES ('38', '1', '6');
INSERT INTO `t_role_authority` VALUES ('41', '1', '1');

-- ----------------------------
-- Table structure for `t_settle`
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
-- Table structure for `t_sorder_dispatching`
-- ----------------------------
DROP TABLE IF EXISTS `t_sorder_dispatching`;
CREATE TABLE `t_sorder_dispatching` (
  `sorderdispatching_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_order_id` int(11) NOT NULL,
  `dispatchingstatus_id` int(11) NOT NULL,
  `status_time` datetime NOT NULL,
  PRIMARY KEY (`sorderdispatching_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sorder_dispatching
-- ----------------------------
INSERT INTO `t_sorder_dispatching` VALUES ('3', '318', '1', '2015-02-10 22:04:50');
INSERT INTO `t_sorder_dispatching` VALUES ('4', '318', '2', '2015-02-11 22:04:58');

-- ----------------------------
-- Table structure for `t_startpageinfo`
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
-- Table structure for `t_s_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_s_order`;
CREATE TABLE `t_s_order` (
  `S_order_id` int(11) NOT NULL AUTO_INCREMENT,
  `F_order_num` varchar(255) NOT NULL DEFAULT '',
  `menu_id` int(11) NOT NULL,
  `S_order_whichday` int(11) NOT NULL,
  `S_order_consumeEvaluate` int(2) DEFAULT NULL,
  `S_order_dispatchingDate` date NOT NULL,
  `S_order_logisticsEvaluate` int(11) DEFAULT NULL,
  `S_order_predictTime` datetime DEFAULT NULL,
  `S_order_isdispatchingStateOpen` int(11) NOT NULL DEFAULT '1',
  `S_order_notice` varchar(255) DEFAULT NULL,
  `S_order_dispatchingID` int(11) NOT NULL,
  `S_order_status` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `count` int(11) DEFAULT '1',
  PRIMARY KEY (`S_order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1212 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_order
-- ----------------------------
INSERT INTO `t_s_order` VALUES ('618', '20150310000002', '3', '2', '0', '2015-04-16', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '6', '0', '1', '1');
INSERT INTO `t_s_order` VALUES ('621', '20150310000001', '3', '5', '0', '2015-03-08', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '6', '2', '1', '1');
INSERT INTO `t_s_order` VALUES ('622', '20150310000001', '1', '3', '0', '2015-02-16', '0', '0000-00-00 00:00:00', '1', '注意：饭量：中等 辣度：吃辣', '6', '2', '1', '1');
INSERT INTO `t_s_order` VALUES ('625', '20150310000002', '2', '4', null, '2015-02-26', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '0', '2', '1', '1');
INSERT INTO `t_s_order` VALUES ('626', '20150310000002', '1', '4', null, '2015-03-01', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '0', '2', '1', '1');
INSERT INTO `t_s_order` VALUES ('627', '20150310000002', '1', '5', null, '2015-03-08', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '0', '2', '1', '1');
INSERT INTO `t_s_order` VALUES ('683', '20150311000001', '5', '1', '0', '2015-03-11', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '30', '0', '16', '1');
INSERT INTO `t_s_order` VALUES ('685', '20150311000003', '5', '1', '0', '2015-03-11', '0', null, '1', '注意：饭量：小份 辣度：不吃辣', '4', '0', '2', '1');
INSERT INTO `t_s_order` VALUES ('686', '20150311000003', '5', '2', '0', '2015-03-12', '0', null, '1', '注意：饭量：小份 辣度：不吃辣', '4', '0', '2', '1');
INSERT INTO `t_s_order` VALUES ('687', '20150311000003', '5', '3', '0', '2015-03-13', '0', null, '1', '注意：饭量：小份 辣度：不吃辣', '4', '0', '2', '1');
INSERT INTO `t_s_order` VALUES ('720', '20150312000041', '1', '1', '0', '2015-03-13', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '6', '0', '1', '1');
INSERT INTO `t_s_order` VALUES ('721', '20150312000041', '1', '2', '4', '2015-03-16', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '6', '2', '1', '1');
INSERT INTO `t_s_order` VALUES ('723', '20150312000041', '1', '4', '0', '2015-03-17', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '6', '2', '1', '1');
INSERT INTO `t_s_order` VALUES ('725', '20150312000043', '5', '1', '0', '2015-03-13', '0', null, '1', '注意：饭量：小份 辣度：不吃辣', '6', '0', '24', '1');
INSERT INTO `t_s_order` VALUES ('726', '20150312000043', '5', '2', '0', '2015-03-16', '0', null, '1', '注意：饭量：小份 辣度：不吃辣', '6', '0', '24', '1');
INSERT INTO `t_s_order` VALUES ('727', '20150312000043', '5', '3', '0', '2015-03-17', '0', null, '1', '注意：饭量：小份 辣度：不吃辣', '6', '0', '24', '1');
INSERT INTO `t_s_order` VALUES ('728', '20150312000043', '5', '4', '0', '2015-03-18', '0', null, '1', '注意：饭量：小份 辣度：不吃辣', '6', '0', '24', '1');
INSERT INTO `t_s_order` VALUES ('729', '20150312000043', '5', '5', '0', '2015-03-19', '0', null, '1', '注意：饭量：小份 辣度：不吃辣', '6', '0', '24', '1');
INSERT INTO `t_s_order` VALUES ('730', '20150313000005', '5', '1', '0', '2015-03-16', '0', null, '1', '注意：饭量：小份 辣度：不吃辣', '7', '0', '28', '1');
INSERT INTO `t_s_order` VALUES ('731', '20150313000005', '5', '2', '0', '2015-03-17', '0', null, '1', '注意：饭量：小份 辣度：不吃辣', '7', '0', '28', '1');
INSERT INTO `t_s_order` VALUES ('732', '20150313000005', '5', '3', '0', '2015-03-18', '0', null, '1', '注意：饭量：小份 辣度：不吃辣', '7', '0', '28', '1');
INSERT INTO `t_s_order` VALUES ('733', '20150313000005', '5', '4', '0', '2015-03-19', '0', null, '1', '注意：饭量：小份 辣度：不吃辣', '7', '0', '28', '1');
INSERT INTO `t_s_order` VALUES ('735', '20150314000000', '5', '1', '0', '2015-03-16', '0', null, '1', '注意：饭量：小份 辣度：不吃辣', '7', '0', '28', '1');
INSERT INTO `t_s_order` VALUES ('800', '20150317000059', '5', '1', '0', '2015-03-18', '0', null, '1', '注意：饭量：小份 辣度：不吃辣', '11', '0', '31', '1');
INSERT INTO `t_s_order` VALUES ('801', '20150317000060', '5', '1', '0', '2015-03-18', '0', null, '1', '注意：饭量：小份 辣度：不吃辣', '11', '0', '31', '1');
INSERT INTO `t_s_order` VALUES ('835', '20150320000011', '5', '1', '0', '2015-03-23', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '1', '2', '1', '1');
INSERT INTO `t_s_order` VALUES ('838', '20150323000001', '5', '1', '0', '2015-03-24', '0', null, '1', '注意：饭量：小份 辣度：不吃辣', '11', '0', '31', '1');
INSERT INTO `t_s_order` VALUES ('839', '20150323000002', '5', '1', '0', '2015-03-24', '0', null, '1', '注意：饭量：小份 辣度：不吃辣', '11', '0', '31', '1');
INSERT INTO `t_s_order` VALUES ('845', '20150323000005', '5', '1', '0', '2015-03-24', '0', null, '1', '注意：饭量：小份 辣度：吃辣', '7', '0', '28', '1');
INSERT INTO `t_s_order` VALUES ('846', '20150323000005', '5', '2', '0', '2015-03-25', '0', null, '1', '注意：饭量：小份 辣度：吃辣', '7', '0', '28', '1');
INSERT INTO `t_s_order` VALUES ('847', '20150323000005', '5', '3', '0', '2015-03-26', '0', null, '1', '注意：饭量：小份 辣度：吃辣', '7', '2', '28', '1');
INSERT INTO `t_s_order` VALUES ('866', '20150327000000', '5', '1', '0', '2015-03-27', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '12', '2', '29', '1');
INSERT INTO `t_s_order` VALUES ('867', '20150327000000', '5', '2', '0', '2015-03-31', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '12', '0', '29', '1');
INSERT INTO `t_s_order` VALUES ('868', '20150327000000', '5', '3', '0', '2015-04-01', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '12', '0', '29', '1');
INSERT INTO `t_s_order` VALUES ('869', '20150327000000', '5', '4', '0', '2015-04-02', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '12', '0', '29', '1');
INSERT INTO `t_s_order` VALUES ('870', '20150327000000', '5', '5', '0', '2015-04-03', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '12', '2', '29', '1');
INSERT INTO `t_s_order` VALUES ('871', '20150327000001', '5', '1', '0', '2015-03-30', '0', null, '1', '注意：饭量：小份 辣度：不吃辣', '7', '0', '28', '1');
INSERT INTO `t_s_order` VALUES ('872', '20150327000002', '5', '1', '0', '2015-03-30', '0', null, '1', '注意：饭量：小份 辣度：不吃辣', '7', '0', '28', '1');
INSERT INTO `t_s_order` VALUES ('873', '20150327000003', '5', '1', '0', '2015-03-30', '0', null, '1', '注意：饭量：小份 辣度：不吃辣', '11', '0', '31', '1');
INSERT INTO `t_s_order` VALUES ('874', '20150328000000', '5', '1', '0', '2015-03-30', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '1', '0', '1', '1');
INSERT INTO `t_s_order` VALUES ('875', '20150402000004', '5', '1', '0', '2015-04-03', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '13', '2', '18', '1');
INSERT INTO `t_s_order` VALUES ('876', '20150402000004', '5', '2', '0', '2015-04-06', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '13', '0', '18', '1');
INSERT INTO `t_s_order` VALUES ('877', '20150402000004', '5', '3', '0', '2015-04-07', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '13', '2', '18', '1');
INSERT INTO `t_s_order` VALUES ('908', '20150406000012', '1', '0', '5', '2015-04-07', null, null, '1', null, '12', '2', '1', '1');
INSERT INTO `t_s_order` VALUES ('909', '20150406000013', '1', '0', null, '2015-04-07', null, null, '1', null, '12', '2', '1', '1');
INSERT INTO `t_s_order` VALUES ('910', '20150407000000', '0', '0', null, '2015-04-07', null, null, '1', null, '0', '2', '1', '1');
INSERT INTO `t_s_order` VALUES ('911', '20150407000001', '1', '0', null, '2015-04-07', null, null, '1', null, '0', '2', '1', '1');
INSERT INTO `t_s_order` VALUES ('912', '20150407000002', '1', '0', null, '2015-04-07', null, null, '1', null, '12', '2', '1', '1');
INSERT INTO `t_s_order` VALUES ('913', '20150407000003', '1', '0', null, '2015-04-07', null, null, '1', null, '12', '2', '1', '1');
INSERT INTO `t_s_order` VALUES ('914', '20150407000004', '1', '0', null, '2015-04-07', null, null, '1', null, '12', '2', '1', '1');
INSERT INTO `t_s_order` VALUES ('915', '20150407000005', '0', '0', null, '2015-04-07', null, null, '1', null, '0', '2', '29', '1');
INSERT INTO `t_s_order` VALUES ('916', '20150407000006', '1', '0', null, '2015-04-07', null, null, '1', null, '0', '2', '29', '1');
INSERT INTO `t_s_order` VALUES ('917', '20150407000007', '2', '0', null, '2015-04-07', null, null, '1', null, '0', '2', '29', '1');
INSERT INTO `t_s_order` VALUES ('918', '20150407000008', '2', '0', null, '2015-04-07', null, null, '1', null, '11', '2', '29', '1');
INSERT INTO `t_s_order` VALUES ('919', '20150407000009', '1', '0', null, '2015-04-07', null, null, '1', null, '12', '2', '1', '1');
INSERT INTO `t_s_order` VALUES ('920', '20150407000010', '2', '0', null, '2015-04-07', null, null, '1', null, '11', '2', '29', '1');
INSERT INTO `t_s_order` VALUES ('921', '20150407000011', '1', '0', null, '2015-04-07', null, null, '1', null, '11', '2', '1', '1');
INSERT INTO `t_s_order` VALUES ('922', '20150407000012', '1', '0', null, '2015-04-08', null, null, '1', null, '11', '0', '29', '1');
INSERT INTO `t_s_order` VALUES ('923', '20150407000013', '1', '0', null, '2015-04-08', null, null, '1', null, '12', '0', '28', '1');
INSERT INTO `t_s_order` VALUES ('928', '20150407000018', '1', '0', null, '2015-04-08', null, null, '1', null, '11', '0', '29', '1');
INSERT INTO `t_s_order` VALUES ('929', '20150407000019', '2', '0', null, '2015-04-08', null, null, '1', null, '11', '0', '29', '1');
INSERT INTO `t_s_order` VALUES ('930', '20150407000020', '2', '0', null, '2015-04-08', null, null, '1', null, '11', '0', '29', '1');
INSERT INTO `t_s_order` VALUES ('931', '20150407000021', '1', '0', null, '2015-04-08', null, null, '1', null, '11', '0', '29', '1');
INSERT INTO `t_s_order` VALUES ('932', '20150407000022', '2', '0', null, '2015-04-08', null, null, '1', null, '11', '0', '29', '1');
INSERT INTO `t_s_order` VALUES ('933', '20150407000023', '1', '0', null, '2015-04-08', null, null, '1', null, '12', '0', '29', '1');
INSERT INTO `t_s_order` VALUES ('938', '20150407000028', '1', '0', null, '2015-04-08', null, null, '1', null, '12', '0', '18', '1');
INSERT INTO `t_s_order` VALUES ('944', '20150407000034', '1', '0', null, '2015-04-08', null, null, '1', null, '11', '0', '56', '1');
INSERT INTO `t_s_order` VALUES ('945', '20150407000035', '2', '0', null, '2015-04-08', null, null, '1', null, '12', '0', '53', '1');
INSERT INTO `t_s_order` VALUES ('947', '20150407000037', '2', '0', null, '2015-04-08', null, null, '1', null, '11', '0', '57', '1');
INSERT INTO `t_s_order` VALUES ('953', '20150407000038', '2', '0', null, '2015-04-08', null, null, '1', null, '12', '0', '54', '1');
INSERT INTO `t_s_order` VALUES ('954', '20150408000000', '1', '0', null, '2015-04-09', null, null, '1', null, '12', '2', '31', '1');
INSERT INTO `t_s_order` VALUES ('955', '20150408000001', '7', '0', null, '2015-04-09', null, null, '1', null, '11', '2', '1', '1');
INSERT INTO `t_s_order` VALUES ('956', '20150408000002', '7', '0', null, '2015-04-09', null, null, '1', null, '12', '2', '29', '1');
INSERT INTO `t_s_order` VALUES ('957', '20150408000003', '7', '0', null, '2015-04-09', null, null, '1', null, '11', '2', '18', '1');
INSERT INTO `t_s_order` VALUES ('958', '20150408000004', '7', '0', null, '2015-04-09', null, null, '1', null, '12', '2', '18', '1');
INSERT INTO `t_s_order` VALUES ('959', '20150408000005', '7', '0', null, '2015-04-09', null, null, '1', null, '12', '2', '54', '1');
INSERT INTO `t_s_order` VALUES ('960', '20150408000006', '7', '0', null, '2015-04-09', null, null, '1', null, '12', '2', '54', '1');
INSERT INTO `t_s_order` VALUES ('961', '20150408000007', '7', '0', null, '2015-04-09', null, null, '1', null, '12', '2', '1', '1');
INSERT INTO `t_s_order` VALUES ('962', '20150408000008', '7', '0', null, '2015-04-09', null, null, '1', null, '12', '2', '18', '1');
INSERT INTO `t_s_order` VALUES ('963', '20150408000009', '7', '0', null, '2015-04-09', null, null, '1', null, '12', '2', '53', '1');
INSERT INTO `t_s_order` VALUES ('973', '20150408000019', '7', '0', null, '2015-04-09', null, null, '1', null, '11', '2', '60', '1');
INSERT INTO `t_s_order` VALUES ('975', '20150408000020', '7', '0', null, '2015-04-09', null, null, '1', null, '12', '2', '61', '1');
INSERT INTO `t_s_order` VALUES ('978', '20150408000021', '7', '0', null, '2015-04-09', null, null, '1', null, '12', '2', '62', '1');
INSERT INTO `t_s_order` VALUES ('981', '20150409000001', '7', '0', null, '2015-04-10', null, null, '1', null, '12', '0', '31', '1');
INSERT INTO `t_s_order` VALUES ('982', '20150409000002', '7', '0', null, '2015-04-10', null, null, '1', null, '12', '0', '18', '1');
INSERT INTO `t_s_order` VALUES ('983', '20150409000003', '7', '0', null, '2015-04-10', null, null, '1', null, '11', '0', '1', '5');
INSERT INTO `t_s_order` VALUES ('986', '20150409000006', '1', '0', null, '2015-04-10', null, null, '1', null, '12', '0', '64', '1');
INSERT INTO `t_s_order` VALUES ('987', '20150409000007', '1', '0', null, '2015-04-10', null, null, '1', null, '12', '0', '65', '1');
INSERT INTO `t_s_order` VALUES ('988', '20150409000008', '1', '0', null, '2015-04-10', null, null, '1', null, '12', '0', '66', '1');
INSERT INTO `t_s_order` VALUES ('989', '20150409000009', '1', '0', null, '2015-04-10', null, null, '1', null, '12', '0', '66', '1');
INSERT INTO `t_s_order` VALUES ('990', '20150409000010', '2', '0', null, '2015-04-10', null, null, '1', null, '12', '0', '67', '3');
INSERT INTO `t_s_order` VALUES ('996', '20150409000013', '1', '0', null, '2015-04-10', null, null, '1', null, '11', '0', '60', '1');
INSERT INTO `t_s_order` VALUES ('997', '20150409000014', '1', '0', null, '2015-04-10', null, null, '1', null, '11', '0', '68', '1');
INSERT INTO `t_s_order` VALUES ('1024', '20150412000000', '7', '0', null, '2015-04-13', null, null, '1', null, '11', '2', '69', '2');
INSERT INTO `t_s_order` VALUES ('1025', '20150412000001', '7', '0', null, '2015-04-13', null, null, '1', null, '11', '2', '69', '2');
INSERT INTO `t_s_order` VALUES ('1026', '20150412000002', '7', '0', null, '2015-04-13', null, null, '1', null, '11', '2', '70', '1');
INSERT INTO `t_s_order` VALUES ('1027', '20150412000003', '7', '0', null, '2015-04-13', null, null, '1', null, '11', '2', '71', '1');
INSERT INTO `t_s_order` VALUES ('1028', '20150412000004', '7', '0', null, '2015-04-13', null, null, '1', null, '12', '2', '72', '1');
INSERT INTO `t_s_order` VALUES ('1029', '20150412000005', '7', '0', null, '2015-04-13', null, null, '1', null, '11', '2', '73', '1');
INSERT INTO `t_s_order` VALUES ('1030', '20150412000006', '7', '0', null, '2015-04-13', null, null, '1', null, '12', '2', '62', '1');
INSERT INTO `t_s_order` VALUES ('1031', '20150412000007', '7', '0', null, '2015-04-13', null, null, '1', null, '12', '2', '74', '1');
INSERT INTO `t_s_order` VALUES ('1032', '20150412000008', '7', '0', null, '2015-04-13', null, null, '1', null, '12', '2', '75', '1');
INSERT INTO `t_s_order` VALUES ('1033', '20150412000009', '7', '0', null, '2015-04-13', null, null, '1', null, '12', '2', '76', '1');
INSERT INTO `t_s_order` VALUES ('1034', '20150412000010', '7', '0', null, '2015-04-13', null, null, '1', null, '11', '2', '77', '2');
INSERT INTO `t_s_order` VALUES ('1035', '20150412000011', '7', '0', null, '2015-04-13', null, null, '1', null, '12', '2', '78', '1');
INSERT INTO `t_s_order` VALUES ('1036', '20150412000012', '7', '0', null, '2015-04-13', null, null, '1', null, '11', '2', '60', '1');
INSERT INTO `t_s_order` VALUES ('1037', '20150412000013', '7', '0', null, '2015-04-13', null, null, '1', null, '11', '2', '68', '1');
INSERT INTO `t_s_order` VALUES ('1038', '20150412000014', '7', '0', null, '2015-04-13', null, null, '1', null, '11', '2', '79', '1');
INSERT INTO `t_s_order` VALUES ('1039', '20150412000015', '7', '0', null, '2015-04-13', null, null, '1', null, '12', '2', '80', '1');
INSERT INTO `t_s_order` VALUES ('1040', '20150412000016', '7', '0', null, '2015-04-13', null, null, '1', null, '11', '2', '81', '1');
INSERT INTO `t_s_order` VALUES ('1041', '20150413000000', '7', '0', null, '2015-04-13', null, null, '1', null, '12', '2', '82', '1');
INSERT INTO `t_s_order` VALUES ('1042', '20150413000001', '7', '0', null, '2015-04-13', null, null, '1', null, '12', '2', '53', '1');
INSERT INTO `t_s_order` VALUES ('1044', '20150413000002', '2', '0', null, '2015-04-14', null, null, '1', null, '11', '2', '84', '1');
INSERT INTO `t_s_order` VALUES ('1045', '20150413000003', '7', '0', null, '2015-04-14', null, null, '1', null, '11', '2', '83', '1');
INSERT INTO `t_s_order` VALUES ('1046', '20150413000004', '2', '0', null, '2015-04-14', null, null, '1', null, '11', '2', '85', '1');
INSERT INTO `t_s_order` VALUES ('1047', '20150413000005', '7', '0', null, '2015-04-14', null, null, '1', null, '12', '2', '86', '1');
INSERT INTO `t_s_order` VALUES ('1048', '20150413000006', '7', '0', null, '2015-04-14', null, null, '1', null, '12', '2', '87', '1');
INSERT INTO `t_s_order` VALUES ('1049', '20150413000007', '7', '0', null, '2015-04-14', null, null, '1', null, '12', '2', '88', '1');
INSERT INTO `t_s_order` VALUES ('1050', '20150413000008', '7', '0', null, '2015-04-14', null, null, '1', null, '12', '2', '89', '1');
INSERT INTO `t_s_order` VALUES ('1051', '20150413000009', '2', '0', null, '2015-04-14', null, null, '1', null, '12', '2', '90', '1');
INSERT INTO `t_s_order` VALUES ('1052', '20150414000000', '1', '0', null, '2015-04-14', null, null, '1', null, '12', '2', '91', '1');
INSERT INTO `t_s_order` VALUES ('1053', '20150414000001', '1', '0', null, '2015-04-14', null, null, '1', null, '12', '2', '92', '1');
INSERT INTO `t_s_order` VALUES ('1054', '20150414000002', '1', '0', null, '2015-04-14', null, null, '1', null, '11', '2', '93', '1');
INSERT INTO `t_s_order` VALUES ('1055', '20150414000003', '1', '0', null, '2015-04-14', null, null, '1', null, '11', '2', '93', '1');
INSERT INTO `t_s_order` VALUES ('1056', '20150414000004', '9', '0', null, '2015-04-15', null, null, '1', null, '11', '2', '94', '1');
INSERT INTO `t_s_order` VALUES ('1057', '20150414000005', '10', '0', null, '2015-04-15', null, null, '1', null, '11', '2', '73', '1');
INSERT INTO `t_s_order` VALUES ('1058', '20150414000006', '9', '0', null, '2015-04-15', null, null, '1', null, '11', '2', '77', '1');
INSERT INTO `t_s_order` VALUES ('1059', '20150414000007', '10', '0', null, '2015-04-15', null, null, '1', null, '11', '2', '95', '1');
INSERT INTO `t_s_order` VALUES ('1060', '20150414000008', '6', '0', null, '2015-04-15', null, null, '1', null, '11', '2', '96', '1');
INSERT INTO `t_s_order` VALUES ('1061', '20150415000000', '9', '0', null, '2015-04-15', null, null, '1', null, '11', '2', '97', '1');
INSERT INTO `t_s_order` VALUES ('1074', '20150415000011', '9', '0', null, '2015-04-15', null, null, '1', null, '11', '2', '68', '1');
INSERT INTO `t_s_order` VALUES ('1075', '20150415000012', '9', '0', null, '2015-04-15', null, null, '1', null, '12', '2', '98', '1');
INSERT INTO `t_s_order` VALUES ('1076', '20150415000013', '9', '0', null, '2015-04-15', null, null, '1', null, '12', '2', '99', '1');
INSERT INTO `t_s_order` VALUES ('1077', '20150415000014', '9', '0', null, '2015-04-15', null, null, '1', null, '11', '2', '100', '1');
INSERT INTO `t_s_order` VALUES ('1078', '20150415000015', '9', '0', null, '2015-04-15', null, null, '1', null, '11', '2', '100', '1');
INSERT INTO `t_s_order` VALUES ('1079', '20150415000016', '10', '0', null, '2015-04-15', null, null, '1', null, '11', '2', '101', '1');
INSERT INTO `t_s_order` VALUES ('1080', '20150415000017', '9', '0', null, '2015-04-15', null, null, '1', null, '11', '2', '102', '1');
INSERT INTO `t_s_order` VALUES ('1081', '20150415000018', '6', '0', null, '2015-04-16', null, null, '1', null, '11', '2', '102', '1');
INSERT INTO `t_s_order` VALUES ('1082', '20150415000019', '1', '0', null, '2015-04-16', null, null, '1', null, '11', '2', '104', '1');
INSERT INTO `t_s_order` VALUES ('1083', '20150415000020', '9', '0', null, '2015-04-16', null, null, '1', null, '11', '2', '60', '1');
INSERT INTO `t_s_order` VALUES ('1084', '20150415000021', '9', '0', null, '2015-04-16', null, null, '1', null, '11', '2', '112', '1');
INSERT INTO `t_s_order` VALUES ('1085', '20150415000022', '1', '0', null, '2015-04-16', null, null, '1', null, '12', '2', '120', '1');
INSERT INTO `t_s_order` VALUES ('1086', '20150415000023', '9', '0', null, '2015-04-16', null, null, '1', null, '12', '2', '129', '1');
INSERT INTO `t_s_order` VALUES ('1087', '20150415000024', '9', '0', null, '2015-04-16', null, null, '1', null, '11', '2', '130', '1');
INSERT INTO `t_s_order` VALUES ('1088', '20150415000025', '9', '0', null, '2015-04-16', null, null, '1', null, '12', '2', '130', '1');
INSERT INTO `t_s_order` VALUES ('1089', '20150415000026', '1', '0', null, '2015-04-16', null, null, '1', null, '11', '2', '68', '1');
INSERT INTO `t_s_order` VALUES ('1090', '20150416000000', '9', '0', null, '2015-04-16', null, null, '1', null, '11', '2', '70', '1');
INSERT INTO `t_s_order` VALUES ('1091', '20150416000001', '1', '0', null, '2015-04-16', null, null, '1', null, '11', '2', '100', '1');
INSERT INTO `t_s_order` VALUES ('1092', '20150416000002', '11', '0', null, '2015-04-16', null, null, '1', null, '11', '2', '100', '1');
INSERT INTO `t_s_order` VALUES ('1093', '20150416000003', '9', '0', null, '2015-04-17', null, null, '1', null, '11', '2', '136', '1');
INSERT INTO `t_s_order` VALUES ('1094', '20150416000004', '1', '0', null, '2015-04-17', null, null, '1', null, '11', '2', '77', '1');
INSERT INTO `t_s_order` VALUES ('1095', '20150416000005', '13', '0', null, '2015-04-17', null, null, '1', null, '11', '2', '60', '1');
INSERT INTO `t_s_order` VALUES ('1096', '20150416000006', '1', '0', null, '2015-04-17', null, null, '1', null, '11', '2', '68', '1');
INSERT INTO `t_s_order` VALUES ('1097', '20150416000007', '12', '0', null, '2015-04-17', null, null, '1', null, '11', '2', '104', '1');
INSERT INTO `t_s_order` VALUES ('1098', '20150416000008', '12', '0', null, '2015-04-17', null, null, '1', null, '11', '2', '141', '1');
INSERT INTO `t_s_order` VALUES ('1099', '20150417000000', '13', '0', null, '2015-04-17', null, null, '1', null, '11', '2', '102', '1');
INSERT INTO `t_s_order` VALUES ('1100', '20150417000001', '13', '0', null, '2015-04-18', null, null, '1', null, '11', '0', '142', '1');
INSERT INTO `t_s_order` VALUES ('1101', '20150417000002', '13', '0', null, '2015-04-18', null, null, '1', null, '11', '0', '143', '1');
INSERT INTO `t_s_order` VALUES ('1102', '20150417000003', '12', '0', null, '2015-04-18', null, null, '1', null, '12', '0', '92', '1');
INSERT INTO `t_s_order` VALUES ('1111', '20150419000006', '6', '0', null, '2015-04-20', null, null, '1', null, '11', '2', '69', '1');
INSERT INTO `t_s_order` VALUES ('1122', '20150419000017', '10', '0', null, '2015-04-20', null, null, '1', null, '11', '2', '60', '1');
INSERT INTO `t_s_order` VALUES ('1152', '20150419000055', '10', '0', null, '2015-04-20', null, null, '1', null, '11', '2', '144', '1');
INSERT INTO `t_s_order` VALUES ('1153', '20150419000056', '10', '0', null, '2015-04-20', null, null, '1', null, '11', '2', '145', '1');
INSERT INTO `t_s_order` VALUES ('1154', '20150419000057', '9', '0', null, '2015-04-20', null, null, '1', null, '11', '2', '73', '1');
INSERT INTO `t_s_order` VALUES ('1155', '20150419000058', '9', '0', null, '2015-04-20', null, null, '1', null, '11', '2', '73', '1');
INSERT INTO `t_s_order` VALUES ('1159', '20150420000000', '9', '0', null, '2015-04-20', null, null, '1', null, '11', '2', '102', '1');
INSERT INTO `t_s_order` VALUES ('1160', '20150420000001', '10', '0', null, '2015-04-20', null, null, '1', null, '12', '2', '76', '1');
INSERT INTO `t_s_order` VALUES ('1161', '20150420000002', '10', '0', null, '2015-04-20', null, null, '1', null, '12', '2', '76', '1');
INSERT INTO `t_s_order` VALUES ('1162', '20150420000003', '6', '0', null, '2015-04-21', null, null, '1', null, '11', '0', '123', '1');
INSERT INTO `t_s_order` VALUES ('1168', '20150419000061', '6', '1', '0', '2015-04-20', null, null, '1', null, '12', '2', '146', '1');
INSERT INTO `t_s_order` VALUES ('1171', '20150419000059', '10', '1', '0', '2015-04-20', null, null, '1', null, '11', '0', '68', '1');
INSERT INTO `t_s_order` VALUES ('1173', '20150420000036', '5', '1', '0', '2015-04-21', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '17', '0', '147', '1');
INSERT INTO `t_s_order` VALUES ('1174', '20150420000037', '2', '0', null, '2015-04-21', null, null, '1', null, '11', '0', '69', '1');
INSERT INTO `t_s_order` VALUES ('1175', '20150420000038', '1', '0', null, '2015-04-21', null, null, '1', null, '11', '0', '147', '1');
INSERT INTO `t_s_order` VALUES ('1183', '20150420000046', '12', '0', null, '2015-04-21', null, null, '1', null, '11', '0', '85', '1');
INSERT INTO `t_s_order` VALUES ('1185', '20150420000048', '1', '0', null, '2015-04-21', null, null, '1', null, '11', '0', '60', '1');
INSERT INTO `t_s_order` VALUES ('1186', '20150420000049', '2', '0', null, '2015-04-21', null, null, '1', null, '11', '0', '148', '1');
INSERT INTO `t_s_order` VALUES ('1187', '20150420000050', '12', '0', null, '2015-04-21', null, null, '1', null, '12', '0', '53', '1');
INSERT INTO `t_s_order` VALUES ('1188', '20150420000051', '12', '0', null, '2015-04-21', null, null, '1', null, '12', '0', '53', '1');
INSERT INTO `t_s_order` VALUES ('1189', '20150420000052', '1', '0', null, '2015-04-21', null, null, '1', null, '12', '0', '149', '1');
INSERT INTO `t_s_order` VALUES ('1190', '20150420000053', '12', '0', null, '2015-04-21', null, null, '1', null, '11', '0', '145', '1');
INSERT INTO `t_s_order` VALUES ('1192', '20150420000055', '2', '0', null, '2015-04-21', null, null, '1', null, '11', '0', '68', '1');
INSERT INTO `t_s_order` VALUES ('1194', '20150420000057', '2', '0', null, '2015-04-21', null, null, '1', null, '11', '0', '150', '1');
INSERT INTO `t_s_order` VALUES ('1195', '20150421000000', '6', '1', '0', '2015-04-21', '0', null, '1', '注意：饭量：小份 辣度：不吃辣', '13', '0', '18', '1');
INSERT INTO `t_s_order` VALUES ('1196', '20150421000005', '5', '1', '0', '2015-04-21', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '14', '0', '1', '1');
INSERT INTO `t_s_order` VALUES ('1197', '20150421000006', '5', '1', '0', '2015-04-21', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '14', '0', '1', '1');
INSERT INTO `t_s_order` VALUES ('1198', '20150421000006', '5', '2', '0', '2015-04-22', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '14', '0', '1', '1');
INSERT INTO `t_s_order` VALUES ('1199', '20150421000006', '5', '3', '0', '2015-04-23', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '14', '0', '1', '1');
INSERT INTO `t_s_order` VALUES ('1200', '20150421000007', '5', '1', '0', '2015-04-21', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '14', '0', '1', '1');
INSERT INTO `t_s_order` VALUES ('1201', '20150421000007', '5', '2', '0', '2015-04-22', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '14', '0', '1', '1');
INSERT INTO `t_s_order` VALUES ('1202', '20150421000007', '5', '3', '0', '2015-04-23', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '14', '0', '1', '1');
INSERT INTO `t_s_order` VALUES ('1203', '20150421000007', '5', '4', '0', '2015-04-24', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '14', '0', '1', '1');
INSERT INTO `t_s_order` VALUES ('1204', '20150421000007', '5', '5', '0', '2015-04-27', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '14', '0', '1', '1');
INSERT INTO `t_s_order` VALUES ('1205', '20150421000008', '1', '0', null, '2015-04-21', null, null, '1', null, '11', '0', '73', '1');
INSERT INTO `t_s_order` VALUES ('1206', '20150421000009', '5', '1', '0', '2015-04-21', '0', null, '1', '注意：饭量：中等 辣度：吃辣', '14', '0', '1', '1');
INSERT INTO `t_s_order` VALUES ('1207', '20150421000010', '1', '0', null, '2015-04-21', null, null, '1', null, '11', '0', '1', '1');
INSERT INTO `t_s_order` VALUES ('1208', '20150421000011', '12', '0', null, '2015-04-21', null, null, '1', null, '12', '0', '54', '1');
INSERT INTO `t_s_order` VALUES ('1209', '20150421000012', '2', '0', null, '2015-04-21', null, null, '1', null, '11', '0', '152', '1');
INSERT INTO `t_s_order` VALUES ('1210', '20150421000013', '1', '0', null, '2015-04-21', null, null, '1', null, '11', '0', '153', '1');
INSERT INTO `t_s_order` VALUES ('1211', '20150421000014', '12', '0', null, '2015-04-21', null, null, '1', null, '11', '0', '153', '1');

-- ----------------------------
-- Table structure for `t_trackpage`
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_trackpage
-- ----------------------------
INSERT INTO `t_trackpage` VALUES ('1', '食材送达', '0', '“新鲜”是一种态度', '2015-02-06 06:15:00', '2015-02-06 06:45:00');
INSERT INTO `t_trackpage` VALUES ('2', '你好早安', '1', '理想与你的距离 取决于你离开被窝的速度', '2015-02-11 06:45:00', '2015-02-16 07:59:00');
INSERT INTO `t_trackpage` VALUES ('3', '疯狂清洗', '2', '在这嘈杂的城市 为你寻回一片纯净', '2015-02-06 08:00:00', '2015-02-06 08:59:00');
INSERT INTO `t_trackpage` VALUES ('4', '创意拼菜', '3', '食物的世界 只有想不到 没有不可能', '2015-02-09 09:00:00', '2015-02-06 09:59:00');
INSERT INTO `t_trackpage` VALUES ('5', '大厨交响', '4', '一种味道 百样人生', '2015-02-06 10:00:00', '2015-02-06 10:59:00');
INSERT INTO `t_trackpage` VALUES ('6', '美味启程', '5', '虽然明天充满未知 但温暖会如期而至', '2015-02-06 11:20:00', '2015-02-06 11:59:00');
INSERT INTO `t_trackpage` VALUES ('7', '用心品味', '6', '只能给你 四季不变的守候', '2015-02-06 13:00:00', '2015-02-06 12:00:00');

-- ----------------------------
-- Table structure for `t_user`
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
  `user_point_default` int(11) DEFAULT '200',
  `user_regdate` date NOT NULL,
  `user_heat` int(11) DEFAULT '-1',
  `user_dispatchdefault_id` int(11) DEFAULT '-1',
  `user_appetite` int(11) DEFAULT '1',
  `user_pungent` int(11) DEFAULT '1',
  `user_weChatAccount` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '', '111111', '1', null, '18930852101', '-1', '-1', '-1', '-1', null, '1000', '2015-02-11', '-1', '14', '1', null, 'oV5JPsyQiqZYQdCzcfuY57UVtEXY');
INSERT INTO `t_user` VALUES ('12', '味你新用户', '80809090', '1', null, '15529203632', '-1', '-1', '-1', '-1', null, '200', '2015-02-28', '4', '-1', '1', '1', null);
INSERT INTO `t_user` VALUES ('17', '味你新用户', '111111', '0', null, '13152471502', '-1', '-1', '-1', '-1', null, '200', '2015-03-03', '1', '37', '1', '1', null);
INSERT INTO `t_user` VALUES ('18', '哼哼', '111111', '0', null, '13991370112', '-1', '-1', '-1', '-1', null, '200', '2015-03-04', '1', '-1', '1', '1', 'oV5JPs3B8Zc2nkBqfEccLUHo9rlw');
INSERT INTO `t_user` VALUES ('19', '味你新用户', '111111', '-1', null, '18602919697', '-1', '-1', '-1', '-1', null, '200', '2015-03-05', '0', '-1', '1', '1', null);
INSERT INTO `t_user` VALUES ('21', '15594682901', '15594682901', '-1', null, '15594682901', '-1', '-1', '-1', '-1', null, '200', '2015-03-11', '-1', '-1', '1', '1', null);
INSERT INTO `t_user` VALUES ('22', '15209518775', 'myn20093028', '-1', null, '15209518775', '-1', '-1', '-1', '-1', null, '200', '2015-03-11', '-1', '-1', '1', '1', null);
INSERT INTO `t_user` VALUES ('23', '18792674654', 'Feng0821', '-1', null, '18792674654', '-1', '-1', '-1', '-1', null, '200', '2015-03-12', '-1', '-1', '1', '1', null);
INSERT INTO `t_user` VALUES ('25', '13669248718', '123456', '1', null, '13669248718', '-1', '-1', '-1', '-1', null, '200', '2015-03-12', '3', '-1', '1', '1', null);
INSERT INTO `t_user` VALUES ('26', '18710898812', 'xwchixinaini', '-1', null, '18710898812', '-1', '-1', '-1', '-1', null, '200', '2015-03-13', '-1', '-1', '1', '1', null);
INSERT INTO `t_user` VALUES ('28', '15339231453', '111111', '1', null, '15339231453', '-1', '-1', '-1', '-1', null, '200', '2015-03-13', '3', '-1', '1', '1', 'oV5JPs-hRveeVBDKsdV-k_J1mai0');
INSERT INTO `t_user` VALUES ('30', '15891739716', 'nainiwei', '-1', null, '15891739716', '-1', '-1', '-1', '-1', null, '200', '2015-03-16', '-1', '-1', '1', '1', null);
INSERT INTO `t_user` VALUES ('31', '15029485462', '111111', '-1', null, '15029485462', '-1', '-1', '-1', '-1', null, '200', '2015-03-17', '-1', '-1', '1', '1', 'oV5JPs7lQ5wvv_HXH-Mvk1XgikJM');
INSERT INTO `t_user` VALUES ('32', '13571978903', 'wangdale313', '-1', null, '13571978903', '-1', '-1', '-1', '-1', null, '200', '2015-03-17', '-1', '-1', '1', '1', null);
INSERT INTO `t_user` VALUES ('33', '18095168314', '18095168314', '-1', null, '18095168314', '-1', '-1', '-1', '-1', null, '200', '2015-03-21', '-1', '-1', '1', '1', null);
INSERT INTO `t_user` VALUES ('34', '15891778670', '15891778670', '-1', null, '15891778670', '-1', '-1', '-1', '-1', null, '200', '2015-03-24', '-1', '-1', '1', '1', null);
INSERT INTO `t_user` VALUES ('35', '18995113397', '18995113397', '-1', null, '18995113397', '-1', '-1', '-1', '-1', null, '200', '2015-03-25', '-1', '-1', '1', '1', null);
INSERT INTO `t_user` VALUES ('52', '张', '18930852102', '1', '', '18930852102', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', null);
INSERT INTO `t_user` VALUES ('53', '', '15809200450', '0', '', '15809200450', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs5098Z5d88jUjCDn4wAglgg');
INSERT INTO `t_user` VALUES ('54', '', '15389448351', '0', '', '15389448351', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs7s0ehDpzhecUXcwisJhK1M');
INSERT INTO `t_user` VALUES ('55', '', '13259735163', '0', '', '13259735163', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', '');
INSERT INTO `t_user` VALUES ('56', '', '15910535608', '0', '', '15910535608', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPswIeNhr4sEA0xy0Si3sB9oo');
INSERT INTO `t_user` VALUES ('57', '', '18829288756', '0', '', '18829288756', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs2ftFfOJb411BsFbJgYx_PM');
INSERT INTO `t_user` VALUES ('58', '', '15667076508', '0', '', '15667076508', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs7jTAmQEB9pqj0KUgAsVhGQ');
INSERT INTO `t_user` VALUES ('59', '', '18829292447', '0', '', '18829292447', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs3QX7pIUZt3bj56FaVqPeM0');
INSERT INTO `t_user` VALUES ('60', '', '13809183166', '0', '', '13809183166', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs1qs8ky2967OdJiFGZqH2HU');
INSERT INTO `t_user` VALUES ('61', '', '18220192436', '0', '', '18220192436', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs3loySrL5tNWZ6RMxEo6Bjs');
INSERT INTO `t_user` VALUES ('62', '', '13484533259', '0', '', '13484533259', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs8NqKeRW10zOOhOKMq3iRx8');
INSERT INTO `t_user` VALUES ('64', '', '13659213407', '0', '', '13659213407', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs_v_aKEsxdSnUT60MN_1CWg');
INSERT INTO `t_user` VALUES ('65', '', '15829207763', '0', '', '15829207763', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs9OiNqe8Vtjo5D3iydpiSwE');
INSERT INTO `t_user` VALUES ('66', '', '18829291986', '0', '', '18829291986', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs0UMegiHYnoE3KLoxPUI1HQ');
INSERT INTO `t_user` VALUES ('67', '', '18829290611', '0', '', '18829290611', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs7mWnxr-fn7sQ5XMawP6Swk');
INSERT INTO `t_user` VALUES ('68', '', '15596899673', '0', '', '15596899673', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs6qC6UKx8LzIHwnJI045MiQ');
INSERT INTO `t_user` VALUES ('69', '', '13186017135', '0', '', '13186017135', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPsxh3wclCkCZP_DcqkOkhYbg');
INSERT INTO `t_user` VALUES ('70', '', '13259438592', '0', '', '13259438592', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs28ci6lAhWnfaczMrNRGa1Q');
INSERT INTO `t_user` VALUES ('71', '', '18710901841', '0', '', '18710901841', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs-efp2k1mpCp3LqJ_5aIDbw');
INSERT INTO `t_user` VALUES ('72', '', '18829288581', '0', '', '18829288581', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPszCurhbCAcWrndxPg7jNtGQ');
INSERT INTO `t_user` VALUES ('73', '', '13259493560', '0', '', '13259493560', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs89lBFD0EROd4EZSPEDRRrQ');
INSERT INTO `t_user` VALUES ('74', '', '18829290465', '0', '', '18829290465', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs1FHspEbslCbhoaXhVr8DRw');
INSERT INTO `t_user` VALUES ('75', '', '13429774265', '0', '', '13429774265', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs_ASOGKfPLANk-fEkP-pN6k');
INSERT INTO `t_user` VALUES ('76', '', '15091832170', '0', '', '15091832170', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPsxiPaS8p0i63nffbERCaZ4s');
INSERT INTO `t_user` VALUES ('77', '', '13152470397', '0', '', '13152470397', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs1__T67Acxqx5eja357JXTM');
INSERT INTO `t_user` VALUES ('78', '', '15091851774', '0', '', '15091851774', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs_cAgNtpPk79INKl8M9VXMQ');
INSERT INTO `t_user` VALUES ('79', '', '18654125607', '0', '', '18654125607', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs1ZoR6cvg92_d247_zhXuiE');
INSERT INTO `t_user` VALUES ('80', '', '18829272693', '0', '', '18829272693', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPszMcD9nqfcSIdFvuv6Er7a0');
INSERT INTO `t_user` VALUES ('81', '', '13152492838', '0', '', '13152492838', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs2XMCH8zpunnKQdBA4ZiohQ');
INSERT INTO `t_user` VALUES ('82', '', '15129029986', '0', '', '15129029986', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPsxTEOnObIBqwMhdBe53UI7A');
INSERT INTO `t_user` VALUES ('83', '18710419469', '18710419469', '-1', null, '18710419469', '-1', '-1', '-1', '-1', null, '-1', '2015-04-13', '-1', '-1', '1', '1', 'oV5JPswJjXVWMjVoUmBCCqSdKijU');
INSERT INTO `t_user` VALUES ('84', '', '18729239826', '0', '', '18729239826', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs01Y48y1vP_ofkE91l-81Ck');
INSERT INTO `t_user` VALUES ('85', '', '18066635509', '0', '', '18066635509', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs8MT85yH47oqDje2DsBZxO0');
INSERT INTO `t_user` VALUES ('86', '', '13609194954', '0', '', '13609194954', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPswyF0LqtKoJ8ONJ2VAOhnQ8');
INSERT INTO `t_user` VALUES ('87', '', '18609584392', '0', '', '18609584392', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs5e9f6SXKsFBgd57TYz4NZE');
INSERT INTO `t_user` VALUES ('88', '', '15829308070', '0', '', '15829308070', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs9NnIyLM0zx5a-aF7L3vIns');
INSERT INTO `t_user` VALUES ('89', '', '15091765914', '0', '', '15091765914', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPsxtAGIpslH1Puomg9BpzAVU');
INSERT INTO `t_user` VALUES ('90', '', '18710902163', '0', '', '18710902163', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs-FxxpQW81H7xNGqJW163-w');
INSERT INTO `t_user` VALUES ('91', '', '15809207264', '0', '', '15809207264', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs3DzhtrEp8W1y0iPigSSvkc');
INSERT INTO `t_user` VALUES ('92', '', '18829289183', '0', '', '18829289183', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs8cOcojXp_N4C3Fpc37uKbY');
INSERT INTO `t_user` VALUES ('93', '', '15667022370', '0', '', '15667022370', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPsxr4GN_vtgpBkFD0MVoFXEI');
INSERT INTO `t_user` VALUES ('94', '', '18829292575', '0', '', '18829292575', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPszsir5ATX5yBVQrU0YAi-IQ');
INSERT INTO `t_user` VALUES ('95', '', '15929369298', '0', '', '15929369298', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs9Hqd23o3GZmWGB6_f8wHQY');
INSERT INTO `t_user` VALUES ('96', '', '13149286361', '0', '', '13149286361', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs4Sqiv7m8L0PV3TmVFM_yv8');
INSERT INTO `t_user` VALUES ('97', '', '18537506157', '0', '', '18537506157', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs1OrzwbS1zntBdJRbOvs9vU');
INSERT INTO `t_user` VALUES ('98', '', '15809260512', '0', '', '15809260512', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs9UMnRY5bPhUF-KkSWy_wyk');
INSERT INTO `t_user` VALUES ('99', '', '15809291324', '0', '', '15809291324', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs9zEEg4mWdqCv2hJyloWQAo');
INSERT INTO `t_user` VALUES ('100', '', '13763869767', '0', '', '13763869767', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs5dx-lME58yTvrmlrhMyQ9s');
INSERT INTO `t_user` VALUES ('101', '', '13259431172', '0', '', '13259431172', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs4zJpkZtcRj-B-fw8DGJbOU');
INSERT INTO `t_user` VALUES ('102', '', '13772041546', '0', '', '13772041546', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs8QJd6UOKvBZd0sWpio2oKM');
INSERT INTO `t_user` VALUES ('103', '13201533886', '13201533886', '-1', null, '13201533886', '-1', '-1', '-1', '-1', null, '-1', '2015-04-15', '-1', '-1', '1', '1', null);
INSERT INTO `t_user` VALUES ('104', '', '15091679720', '0', '', '15091679720', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPsw4xVDPGpPIqqcm-k3CuiI4');
INSERT INTO `t_user` VALUES ('105', '', '15652935419', '0', '', '15652935419', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs2LtsakPWbaLSZDOnvyJxzQ');
INSERT INTO `t_user` VALUES ('106', '', '18829290158', '0', '', '18829290158', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs-6wLrinKep8sjGP2_JmkV0');
INSERT INTO `t_user` VALUES ('107', '', '', '0', '', '', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs8RJpAEpbJ5TemarBGc98wA');
INSERT INTO `t_user` VALUES ('108', '', '13488196204', '0', '', '13488196204', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPsySHH0EN5e50515d94lLrH8');
INSERT INTO `t_user` VALUES ('109', '', '13186916669', '0', '', '13186916669', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs64R6fa62WGMCPOVd18Ywi4');
INSERT INTO `t_user` VALUES ('110', '', '', '0', '', '', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs3oN2j01wuTYlMmEAdC-Jg0');
INSERT INTO `t_user` VALUES ('111', '', '18092769737', '0', '', '18092769737', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPsyWLXvJ-w-bj1JHsIPQ5HlA');
INSERT INTO `t_user` VALUES ('112', '', '15667689009', '0', '', '15667689009', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPsxtZKKsX0dzDIS9Qwes9lc4');
INSERT INTO `t_user` VALUES ('113', '', '13720408768', '0', '', '13720408768', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs2NiQZHx2Hd50c-IjrIJ684');
INSERT INTO `t_user` VALUES ('114', '', '18291915437', '0', '', '18291915437', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPsyA37sEfuthUXeV6ZjLyq9g');
INSERT INTO `t_user` VALUES ('115', '', '18829291482', '0', '', '18829291482', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs6TJxv5GNT4KyhsXEMHc3ss');
INSERT INTO `t_user` VALUES ('116', '', '15202953096', '0', '', '15202953096', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPsyFaVhd4qJdYrILgm-5EPbY');
INSERT INTO `t_user` VALUES ('117', '', '15991618004', '0', '', '15991618004', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs9_KlGMg-ajbn8eXLGrq4fg');
INSERT INTO `t_user` VALUES ('118', '', '15809209046', '0', '', '15809209046', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs5PN1E04PxqmAUcScU01R8g');
INSERT INTO `t_user` VALUES ('119', '', '15802993201', '0', '', '15802993201', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs3roYeCpPLcJawqtuyv2HaI');
INSERT INTO `t_user` VALUES ('120', '', '18706862282', '0', '', '18706862282', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs1m6CqpX6oI9u38z8nKtSFI');
INSERT INTO `t_user` VALUES ('121', '', '15829081934', '0', '', '15829081934', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPsyrFmoyR_00J6JVdbcoqh_4');
INSERT INTO `t_user` VALUES ('122', '', '18829290802', '0', '', '18829290802', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs_vF3mt89-e_YL359sPTLJ4');
INSERT INTO `t_user` VALUES ('123', '', '13720495414', '0', '', '13720495414', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs6BadIdu-gWZr8thX6pp2yA');
INSERT INTO `t_user` VALUES ('124', '', '13152471718', '0', '', '13152471718', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs-yJZJlpfdawGw-9hgmYtBY');
INSERT INTO `t_user` VALUES ('125', '', '17865191991', '0', '', '17865191991', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs3mJWXWlUqSZBmV-lo9YjqE');
INSERT INTO `t_user` VALUES ('126', '', '15109280478', '0', '', '15109280478', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs8ATlcMtuMLL-aHSyQpakk8');
INSERT INTO `t_user` VALUES ('127', '', '18829291497', '0', '', '18829291497', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs9WInPTqOqZLfiCse4i1FNI');
INSERT INTO `t_user` VALUES ('128', '', '18829289381', '0', '', '18829289381', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPsyODWiRmAKALfshkg6cLII8');
INSERT INTO `t_user` VALUES ('129', '', '15829209589', '0', '', '15829209589', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs3wGrDhvvsmfepf1SJ39Gqo');
INSERT INTO `t_user` VALUES ('130', '', '13259426813', '0', '', '13259426813', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPsxTzclBKCZza9I8URaYZTFg');
INSERT INTO `t_user` VALUES ('131', '', '15529203632', '0', '', '15529203632', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs4NwH4aKunsAbPbbV2PG8gY');
INSERT INTO `t_user` VALUES ('132', '', '18829289181', '0', '', '18829289181', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs8jpF8g3k4mg09wnf9rkIcg');
INSERT INTO `t_user` VALUES ('133', '', '18829292034', '0', '', '18829292034', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPszAt1IVOPv6Qo1vg-R0J9qw');
INSERT INTO `t_user` VALUES ('134', '', '18706829066', '0', '', '18706829066', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs9j5gwyY8vN_HNddMjEjoEA');
INSERT INTO `t_user` VALUES ('135', '', '18700489029', '0', '', '18700489029', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs7p03qpDcpQPgrYBaM-QIUk');
INSERT INTO `t_user` VALUES ('136', '', '18829290144', '0', '', '18829290144', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPswY2tzk19QIuevunl3lwVaA');
INSERT INTO `t_user` VALUES ('137', '', '17755478828', '0', '', '17755478828', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs-WNCtRpRBtStY_lJBnkRiQ');
INSERT INTO `t_user` VALUES ('139', '', '13402960389', '0', '', '13402960389', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs8BSjurKV8W_3pbjdCKnYOw');
INSERT INTO `t_user` VALUES ('140', '', '18829289543', '0', '', '18829289543', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs3otRHcbodqsyPgFCh4uwUc');
INSERT INTO `t_user` VALUES ('141', '', '18700993021', '0', '', '18700993021', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs1lwP16NDPZoyRsPWKtzlQg');
INSERT INTO `t_user` VALUES ('142', '', '18092417706', '0', '', '18092417706', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs_v3gnetdj47JsJMCv55Jfk');
INSERT INTO `t_user` VALUES ('143', '', '15809271417', '0', '', '15809271417', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs8OF1OzYzgWsC521Ut3H5xA');
INSERT INTO `t_user` VALUES ('144', '', '18182632218', '0', '', '18182632218', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs6Yu_NwuaoEzoYmphltjlew');
INSERT INTO `t_user` VALUES ('145', '', '18691763598', '0', '', '18691763598', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs7-4T3IBHwGjMCmasY1ZBiU');
INSERT INTO `t_user` VALUES ('146', '', '18392101891', '0', '', '18392101891', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPsznyfIECmSj2JUfFC23LnQg');
INSERT INTO `t_user` VALUES ('147', '18017866798', '18017866798', '-1', null, '18017866798', '-1', '-1', '-1', '-1', null, '-1', '2015-04-20', '-1', '-1', '1', '1', 'oV5JPs0j7H6FBFGCRQOfp_BAZGz8');
INSERT INTO `t_user` VALUES ('148', '', '15667025716', '0', '', '15667025716', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs1A8Dad6jPsl7pBPiL2_By4');
INSERT INTO `t_user` VALUES ('149', '', '13572045774', '0', '', '13572045774', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs92aYpAZ2jk823tesuOL3p8');
INSERT INTO `t_user` VALUES ('150', '', '18829289010', '0', '', '18829289010', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs20ktsX3Tp-Kof3BJc1mbFc');
INSERT INTO `t_user` VALUES ('151', '18508449454', '18508449454', '-1', null, '18508449454', '-1', '-1', '-1', '-1', null, '-1', '2015-04-21', '-1', '-1', '1', '1', null);
INSERT INTO `t_user` VALUES ('152', '', '13772015530', '0', '', '13772015530', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs0b8rXQpxKllNTIp6U8I3ek');
INSERT INTO `t_user` VALUES ('153', '', '15891716850', '0', '', '15891716850', '3', '-1', '-1', '-1', '', '200', '0000-00-00', '-1', '-1', '1', '1', 'oV5JPs6jMn-O9vly-70TX3s93ADk');

-- ----------------------------
-- Table structure for `t_userextra`
-- ----------------------------
DROP TABLE IF EXISTS `t_userextra`;
CREATE TABLE `t_userextra` (
  `userextra_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `userextra_image` varchar(255) DEFAULT '',
  `userextra_reserved` varchar(255) DEFAULT '',
  `userextra_birthday` date DEFAULT NULL,
  PRIMARY KEY (`userextra_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_userextra
-- ----------------------------
INSERT INTO `t_userextra` VALUES ('5', '1', 'upload\\menuinfo\\_EN_8399.jpg', '', '1990-11-26');
INSERT INTO `t_userextra` VALUES ('6', '2', '', '', '1979-04-13');
INSERT INTO `t_userextra` VALUES ('7', '3', '', '', null);
INSERT INTO `t_userextra` VALUES ('8', '4', '', '', null);
INSERT INTO `t_userextra` VALUES ('10', '6', '', '', null);
INSERT INTO `t_userextra` VALUES ('11', '7', '', '', null);
INSERT INTO `t_userextra` VALUES ('12', '8', '', '', null);
INSERT INTO `t_userextra` VALUES ('13', '9', '', '', '2015-02-14');
INSERT INTO `t_userextra` VALUES ('14', '10', '', '', '1983-08-21');
INSERT INTO `t_userextra` VALUES ('15', '11', '', '', '2011-03-06');
INSERT INTO `t_userextra` VALUES ('16', '12', '', '', '2015-02-26');
INSERT INTO `t_userextra` VALUES ('18', '14', '', '', null);
INSERT INTO `t_userextra` VALUES ('19', '15', '', '', null);
INSERT INTO `t_userextra` VALUES ('20', '16', '', '', '1998-03-03');
INSERT INTO `t_userextra` VALUES ('21', '17', '', '', '1993-11-03');
INSERT INTO `t_userextra` VALUES ('22', '18', '', '', '1992-08-04');
INSERT INTO `t_userextra` VALUES ('23', '19', '', '', null);
INSERT INTO `t_userextra` VALUES ('24', '20', '', '', null);
INSERT INTO `t_userextra` VALUES ('25', '21', '', '', null);
INSERT INTO `t_userextra` VALUES ('26', '22', '', '', null);
INSERT INTO `t_userextra` VALUES ('27', '23', '', '', null);
INSERT INTO `t_userextra` VALUES ('28', '24', '', '', null);
INSERT INTO `t_userextra` VALUES ('29', '25', '', '', null);
INSERT INTO `t_userextra` VALUES ('30', '26', '', '', null);
INSERT INTO `t_userextra` VALUES ('31', '27', '', '', null);
INSERT INTO `t_userextra` VALUES ('32', '28', '', '', '2015-03-20');
INSERT INTO `t_userextra` VALUES ('33', '29', '', '', null);
INSERT INTO `t_userextra` VALUES ('34', '30', '', '', null);
INSERT INTO `t_userextra` VALUES ('35', '31', '', '', null);
INSERT INTO `t_userextra` VALUES ('36', '32', '', '', null);
INSERT INTO `t_userextra` VALUES ('37', '33', '', '', null);
INSERT INTO `t_userextra` VALUES ('38', '34', '', '', null);
INSERT INTO `t_userextra` VALUES ('39', '35', '', '', null);
INSERT INTO `t_userextra` VALUES ('40', '83', '', '', null);
INSERT INTO `t_userextra` VALUES ('41', '103', '', '', null);
INSERT INTO `t_userextra` VALUES ('42', '147', '', '', null);
INSERT INTO `t_userextra` VALUES ('43', '151', '', '', null);

-- ----------------------------
-- Table structure for `t_vendor`
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
  `vendor_shophour_start` time NOT NULL,
  `vendor_paytype` int(11) NOT NULL DEFAULT '0',
  `vendor_business_areaid` int(11) NOT NULL,
  `vendor_default_accountid` int(11) NOT NULL,
  `vendor_shophour_end` time NOT NULL,
  `vendor_paytypev` int(11) DEFAULT NULL,
  PRIMARY KEY (`vendor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_vendor
-- ----------------------------
INSERT INTO `t_vendor` VALUES ('1', '55', '33@qq.com', '18789009090', '', '0', '0', '0', '0', '1', '10', '', '21:30:25', '0', '-1', '-1', '21:30:13', '-1');
INSERT INTO `t_vendor` VALUES ('2', 'zsy', 'zsy@qq.com', '465456', '', '0', '0', '0', '0', '0', '1', '', '21:40:25', '0', '-1', '-1', '06:20:00', '12');
INSERT INTO `t_vendor` VALUES ('3', 'cyjhh', '1324@pp.com', '456465', '', '1', '0', '0', '0', '0', '0', '', '00:00:00', '0', '-1', '-1', '00:00:00', '-1');
INSERT INTO `t_vendor` VALUES ('4', 'plhh', 'pl@qq.com', '13618709099', '', '1', '0', '0', '0', '0', '0', '', '06:20:00', '0', '3', '-1', '06:50:00', '-1');

-- ----------------------------
-- Table structure for `t_vendorextra`
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
-- Table structure for `t_version`
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
INSERT INTO `t_version` VALUES ('1', '0', '1.1.0', 'upload/ApkUpdate/weini.apk');
INSERT INTO `t_version` VALUES ('2', '1', '1.0.2', 'http://www.baidu.com');
INSERT INTO `t_version` VALUES ('3', '1', '1.0.3', 'http://www.baidu.com');
