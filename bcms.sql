/*
Navicat MySQL Data Transfer

Source Server         : docmanage
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : bcms

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-06-25 17:17:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `cl_id` varchar(255) NOT NULL,
  `cl_name` varchar(20) DEFAULT NULL,
  `cl_pswd` varchar(6) DEFAULT NULL,
  `cl_identity` varchar(18) DEFAULT NULL,
  `cl_all` varchar(8) DEFAULT NULL,
  `cl_status` varchar(4) DEFAULT NULL,
  `cl_address` varchar(40) DEFAULT NULL,
  `cl_date` datetime DEFAULT NULL,
  PRIMARY KEY (`cl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('10100000', '何先生', '123', '50001', '970', '正常', '河南', '2017-06-24 09:45:39');
INSERT INTO `client` VALUES ('10100001', '张先生', '123456', '50002', '70', '正常', '河南', '2017-06-24 09:46:19');
INSERT INTO `client` VALUES ('10100202', '张先森', '123456', '50003', '120', '正常', '四川', '2017-06-25 09:36:22');
INSERT INTO `client` VALUES ('10100303', '李先生', '123', '50004', '90', '正常', '四川', '2017-06-25 10:09:17');
INSERT INTO `client` VALUES ('10100304', '王先生', '123', '50005', '180', '挂失', '中国', '2017-06-25 10:12:10');
INSERT INTO `client` VALUES ('10100404', '王', '123', '50006', '200', '正常', '北京', '2017-06-25 13:02:38');
INSERT INTO `client` VALUES ('10100405', '王珊', '123', '50007', '12345', '正常', '山西', '2017-06-25 13:03:12');
INSERT INTO `client` VALUES ('10100406', '何时', '123', '50008', '1000', '正常', '四川省', '2017-06-25 13:03:52');
INSERT INTO `client` VALUES ('10100408', '搜搜', '123454', '50009', '2003', '正常', '成都', '2017-06-25 13:06:04');
INSERT INTO `client` VALUES ('10100506', '王世杰', '123456', '50010', '23455', '正常', '美国洛杉矶', '2017-06-25 13:12:33');
INSERT INTO `client` VALUES ('10100608', '何小二', '1232', '50021', '2341', '正常', '加拿大', '2017-06-25 13:18:51');
INSERT INTO `client` VALUES ('10100707', '王石', '123', '50022', '1234', '挂失', '重庆', '2017-06-25 15:01:54');

-- ----------------------------
-- Table structure for deposit
-- ----------------------------
DROP TABLE IF EXISTS `deposit`;
CREATE TABLE `deposit` (
  `de_id` varchar(255) NOT NULL,
  `mg_id` varchar(255) DEFAULT NULL,
  `cl_id` varchar(255) DEFAULT NULL,
  `de_date` datetime DEFAULT NULL,
  `de_money` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`de_id`),
  KEY `FK5CA7169E9EC50460` (`mg_id`),
  KEY `FK5CA7169E1B223F49` (`cl_id`),
  CONSTRAINT `FK5CA7169E1B223F49` FOREIGN KEY (`cl_id`) REFERENCES `client` (`cl_id`),
  CONSTRAINT `FK5CA7169E9EC50460` FOREIGN KEY (`mg_id`) REFERENCES `manager` (`mg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deposit
-- ----------------------------
INSERT INTO `deposit` VALUES ('402881ea5cdaf176015cdaf189a40000', '123', '10100000', '2017-06-25 00:31:21', '1');
INSERT INTO `deposit` VALUES ('402881ea5cdcd866015cdcd9ae340000', '123', '10100000', '2017-06-25 09:24:32', '20');
INSERT INTO `deposit` VALUES ('402881ea5cdce327015cdce993a00002', '123', '10100202', '2017-06-25 09:41:54', '10');
INSERT INTO `deposit` VALUES ('402881ea5cdd00a8015cdd012cdc0001', '123', '10100000', '2017-06-25 10:07:40', '18');
INSERT INTO `deposit` VALUES ('402881ea5cdd00a8015cdd034ee10005', '123', '10100303', '2017-06-25 10:10:00', '10');
INSERT INTO `deposit` VALUES ('402881ea5cdd00a8015cdd061f260008', '123', '10100304', '2017-06-25 10:13:04', '29');
INSERT INTO `deposit` VALUES ('402881ea5cde0d58015cde17e6150002', '123', '10100000', '2017-06-25 15:12:07', '13');
INSERT INTO `deposit` VALUES ('402881ea5cde76e1015cde7938950001', '123', '10100000', '2017-06-25 16:58:25', '1000');

-- ----------------------------
-- Table structure for deposit_clall
-- ----------------------------
DROP TABLE IF EXISTS `deposit_clall`;
CREATE TABLE `deposit_clall` (
  `de_id` varchar(255) NOT NULL,
  `de_clAll` varchar(255) DEFAULT NULL,
  KEY `FK1A58BB97C9234F0A` (`de_id`),
  CONSTRAINT `FK1A58BB97C9234F0A` FOREIGN KEY (`de_id`) REFERENCES `deposit` (`de_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deposit_clall
-- ----------------------------
INSERT INTO `deposit_clall` VALUES ('402881ea5cdaf176015cdaf189a40000', '111');
INSERT INTO `deposit_clall` VALUES ('402881ea5cdcd866015cdcd9ae340000', '40');
INSERT INTO `deposit_clall` VALUES ('402881ea5cdce327015cdce993a00002', '100');
INSERT INTO `deposit_clall` VALUES ('402881ea5cdd00a8015cdd012cdc0001', '28');
INSERT INTO `deposit_clall` VALUES ('402881ea5cdd00a8015cdd034ee10005', '100');
INSERT INTO `deposit_clall` VALUES ('402881ea5cdd00a8015cdd061f260008', '200');
INSERT INTO `deposit_clall` VALUES ('402881ea5cde0d58015cde17e6150002', '20');
INSERT INTO `deposit_clall` VALUES ('402881ea5cde76e1015cde7938950001', '990');

-- ----------------------------
-- Table structure for draw
-- ----------------------------
DROP TABLE IF EXISTS `draw`;
CREATE TABLE `draw` (
  `dr_id` varchar(255) NOT NULL,
  `ma_id` varchar(255) DEFAULT NULL,
  `cl_id` varchar(255) DEFAULT NULL,
  `dr_date` datetime DEFAULT NULL,
  `dr_money` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`dr_id`),
  KEY `FK2F2D441B223F49` (`cl_id`),
  KEY `FK2F2D449EC24A26` (`ma_id`),
  CONSTRAINT `FK2F2D441B223F49` FOREIGN KEY (`cl_id`) REFERENCES `client` (`cl_id`),
  CONSTRAINT `FK2F2D449EC24A26` FOREIGN KEY (`ma_id`) REFERENCES `manager` (`mg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of draw
-- ----------------------------
INSERT INTO `draw` VALUES ('402881ea5cd8bc06015cd8bc18dd0000', '123', '10100000', '2017-06-24 14:13:44', '10');
INSERT INTO `draw` VALUES ('402881ea5cd8bc06015cd8bc6d5f0001', '123', '10100000', '2017-06-24 14:14:06', '2');
INSERT INTO `draw` VALUES ('402881ea5cd8bc06015cd8bcb79f0002', '123', '10100000', '2017-06-24 14:14:25', '5');
INSERT INTO `draw` VALUES ('402881ea5cda8ef2015cda8f7c8f0000', '123', '10100000', '2017-06-24 22:44:15', '10');
INSERT INTO `draw` VALUES ('402881ea5cdace46015cdace5ba90000', '123', '10100000', '2017-06-24 23:52:55', '30');
INSERT INTO `draw` VALUES ('402881ea5cdad1bb015cdad1cbc60000', '123', '10100000', '2017-06-24 23:56:41', '30');
INSERT INTO `draw` VALUES ('402881ea5cdad5ca015cdad5eb140000', '123', '10100000', '2017-06-25 00:01:11', '30');
INSERT INTO `draw` VALUES ('402881ea5cdae298015cdae2d6590000', '123', '10100000', '2017-06-25 00:15:18', '9');
INSERT INTO `draw` VALUES ('402881ea5cdaea54015cdaee4a090001', '123', '10100000', '2017-06-25 00:27:48', '10');
INSERT INTO `draw` VALUES ('402881ea5cdcd866015cdcd9e55b0001', '123', '10100000', '2017-06-25 09:24:46', '10');
INSERT INTO `draw` VALUES ('402881ea5cdce327015cdce5daea0000', '123', '10100202', '2017-06-25 09:37:50', '100');
INSERT INTO `draw` VALUES ('402881ea5cdce327015cdce8baf10001', '123', '10100202', '2017-06-25 09:40:58', '10');
INSERT INTO `draw` VALUES ('402881ea5cdce327015cdce9d93c0003', '123', '10100202', '2017-06-25 09:42:12', '10');
INSERT INTO `draw` VALUES ('402881ea5cdd00a8015cdd010e350000', '123', '10100000', '2017-06-25 10:07:32', '1');
INSERT INTO `draw` VALUES ('402881ea5cdd00a8015cdd031a590004', '123', '10100303', '2017-06-25 10:09:47', '10');
INSERT INTO `draw` VALUES ('402881ea5cdd00a8015cdd05f86a0007', '123', '10100304', '2017-06-25 10:12:55', '29');
INSERT INTO `draw` VALUES ('402881ea5cde0d58015cde1736180000', '123', '10100000', '2017-06-25 15:11:22', '8');
INSERT INTO `draw` VALUES ('402881ea5cde0d58015cde17c8a20001', '123', '10100000', '2017-06-25 15:11:59', '3');
INSERT INTO `draw` VALUES ('402881ea5cde76e1015cde78894e0000', '123', '10100000', '2017-06-25 16:57:40', '20');

-- ----------------------------
-- Table structure for draw_clall
-- ----------------------------
DROP TABLE IF EXISTS `draw_clall`;
CREATE TABLE `draw_clall` (
  `dr_id` varchar(255) NOT NULL,
  `dr_clAll` varchar(255) DEFAULT NULL,
  KEY `FKE42BDBDC6599BD` (`dr_id`),
  CONSTRAINT `FKE42BDBDC6599BD` FOREIGN KEY (`dr_id`) REFERENCES `draw` (`dr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of draw_clall
-- ----------------------------
INSERT INTO `draw_clall` VALUES ('402881ea5cd8bc06015cd8bc18dd0000', '20');
INSERT INTO `draw_clall` VALUES ('402881ea5cd8bc06015cd8bc6d5f0001', '18');
INSERT INTO `draw_clall` VALUES ('402881ea5cd8bc06015cd8bcb79f0002', '13');
INSERT INTO `draw_clall` VALUES ('402881ea5cda8ef2015cda8f7c8f0000', '60');
INSERT INTO `draw_clall` VALUES ('402881ea5cdace46015cdace5ba90000', '70');
INSERT INTO `draw_clall` VALUES ('402881ea5cdad1bb015cdad1cbc60000', '70');
INSERT INTO `draw_clall` VALUES ('402881ea5cdad5ca015cdad5eb140000', '70');
INSERT INTO `draw_clall` VALUES ('402881ea5cdae298015cdae2d6590000', '100');
INSERT INTO `draw_clall` VALUES ('402881ea5cdaea54015cdaee4a090001', '110');
INSERT INTO `draw_clall` VALUES ('402881ea5cdcd866015cdcd9e55b0001', '30');
INSERT INTO `draw_clall` VALUES ('402881ea5cdce327015cdce5daea0000', '100');
INSERT INTO `draw_clall` VALUES ('402881ea5cdce327015cdce8baf10001', '90');
INSERT INTO `draw_clall` VALUES ('402881ea5cdce327015cdce9d93c0003', '90');
INSERT INTO `draw_clall` VALUES ('402881ea5cdd00a8015cdd010e350000', '10');
INSERT INTO `draw_clall` VALUES ('402881ea5cdd00a8015cdd031a590004', '90');
INSERT INTO `draw_clall` VALUES ('402881ea5cdd00a8015cdd05f86a0007', '171');
INSERT INTO `draw_clall` VALUES ('402881ea5cde0d58015cde1736180000', '10');
INSERT INTO `draw_clall` VALUES ('402881ea5cde0d58015cde17c8a20001', '7');
INSERT INTO `draw_clall` VALUES ('402881ea5cde76e1015cde78894e0000', '-10');

-- ----------------------------
-- Table structure for hibernate_hilo
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_hilo`;
CREATE TABLE `hibernate_hilo` (
  `next_hi` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_hilo
-- ----------------------------
INSERT INTO `hibernate_hilo` VALUES ('100008');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `mg_id` varchar(255) NOT NULL,
  `mg_pswd` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`mg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('123', '123');
INSERT INTO `manager` VALUES ('admin', 'admin');
INSERT INTO `manager` VALUES ('root', 'root');

-- ----------------------------
-- Table structure for transfer
-- ----------------------------
DROP TABLE IF EXISTS `transfer`;
CREATE TABLE `transfer` (
  `tr_id` varchar(255) NOT NULL,
  `manager_id` varchar(255) DEFAULT NULL,
  `cl_id` varchar(255) DEFAULT NULL,
  `trCl_id` varchar(255) DEFAULT NULL,
  `tr_date` datetime DEFAULT NULL,
  `tr_money` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`tr_id`),
  KEY `FK4C58B7EBD5FD8F8B` (`trCl_id`),
  KEY `FK4C58B7EB1B223F49` (`cl_id`),
  KEY `FK4C58B7EB2D4D656D` (`manager_id`),
  CONSTRAINT `FK4C58B7EB1B223F49` FOREIGN KEY (`cl_id`) REFERENCES `client` (`cl_id`),
  CONSTRAINT `FK4C58B7EB2D4D656D` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`mg_id`),
  CONSTRAINT `FK4C58B7EBD5FD8F8B` FOREIGN KEY (`trCl_id`) REFERENCES `client` (`cl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transfer
-- ----------------------------
INSERT INTO `transfer` VALUES ('402881ea5cdcd866015cdcda52df0002', '123', '10100000', '10100001', '2017-06-25 09:25:14', '10');
INSERT INTO `transfer` VALUES ('402881ea5cdcd866015cdcdadf740003', '123', '10100000', '10100001', '2017-06-25 09:25:50', '9');
INSERT INTO `transfer` VALUES ('402881ea5cdd00a8015cdd01654c0002', '123', '10100000', '10100001', '2017-06-25 10:07:55', '8');
INSERT INTO `transfer` VALUES ('402881ea5cdd00a8015cdd01c6f10003', '123', '10100000', '10100202', '2017-06-25 10:08:20', '2');
INSERT INTO `transfer` VALUES ('402881ea5cdd00a8015cdd037e750006', '123', '10100303', '10100001', '2017-06-25 10:10:12', '10');
INSERT INTO `transfer` VALUES ('402881ea5cdd00a8015cdd067dbc0009', '123', '10100304', '10100001', '2017-06-25 10:13:29', '20');
INSERT INTO `transfer` VALUES ('402881ea5cdda7ed015cddaaffe70000', '123', '10100202', '10100001', '2017-06-25 13:13:10', '2');
INSERT INTO `transfer` VALUES ('402881ea5cde0d58015cde1821650003', '123', '10100000', '10100001', '2017-06-25 15:12:22', '10');
INSERT INTO `transfer` VALUES ('402881ea5cde76e1015cde79eddf0002', '123', '10100000', '10100202', '2017-06-25 16:59:11', '20');

-- ----------------------------
-- Table structure for transfer_clall
-- ----------------------------
DROP TABLE IF EXISTS `transfer_clall`;
CREATE TABLE `transfer_clall` (
  `tr_id` varchar(255) NOT NULL,
  `tr_clAll` varchar(255) DEFAULT NULL,
  KEY `FK75CD6F24C59ACDF4` (`tr_id`),
  CONSTRAINT `FK75CD6F24C59ACDF4` FOREIGN KEY (`tr_id`) REFERENCES `transfer` (`tr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transfer_clall
-- ----------------------------
INSERT INTO `transfer_clall` VALUES ('402881ea5cdcd866015cdcda52df0002', '20');
INSERT INTO `transfer_clall` VALUES ('402881ea5cdcd866015cdcdadf740003', '11');
INSERT INTO `transfer_clall` VALUES ('402881ea5cdd00a8015cdd01654c0002', '20');
INSERT INTO `transfer_clall` VALUES ('402881ea5cdd00a8015cdd01c6f10003', '18');
INSERT INTO `transfer_clall` VALUES ('402881ea5cdd00a8015cdd037e750006', '90');
INSERT INTO `transfer_clall` VALUES ('402881ea5cdd00a8015cdd067dbc0009', '180');
INSERT INTO `transfer_clall` VALUES ('402881ea5cdda7ed015cddaaffe70000', '100');
INSERT INTO `transfer_clall` VALUES ('402881ea5cde0d58015cde1821650003', '10');
INSERT INTO `transfer_clall` VALUES ('402881ea5cde76e1015cde79eddf0002', '970');
