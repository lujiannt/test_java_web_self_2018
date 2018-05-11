/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50631
Source Host           : 127.0.0.1:3306
Source Database       : teststruts

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2018-05-11 22:48:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bc_course
-- ----------------------------
DROP TABLE IF EXISTS `bc_course`;
CREATE TABLE `bc_course` (
  `courseId` int(11) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bc_course
-- ----------------------------
INSERT INTO `bc_course` VALUES ('1', '数学');
INSERT INTO `bc_course` VALUES ('2', '数学');
INSERT INTO `bc_course` VALUES ('3', '数学');

-- ----------------------------
-- Table structure for bc_member
-- ----------------------------
DROP TABLE IF EXISTS `bc_member`;
CREATE TABLE `bc_member` (
  `memberId` int(11) NOT NULL AUTO_INCREMENT,
  `memberName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`memberId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bc_member
-- ----------------------------
INSERT INTO `bc_member` VALUES ('1', '张三');
INSERT INTO `bc_member` VALUES ('2', '张三');
INSERT INTO `bc_member` VALUES ('3', '张三');

-- ----------------------------
-- Table structure for bc_member_course
-- ----------------------------
DROP TABLE IF EXISTS `bc_member_course`;
CREATE TABLE `bc_member_course` (
  `memberId` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  PRIMARY KEY (`memberId`,`courseId`),
  KEY `FK7D54E9E22BE50218` (`memberId`),
  KEY `FK7D54E9E22C2650DA` (`courseId`),
  CONSTRAINT `FK7D54E9E22BE50218` FOREIGN KEY (`memberId`) REFERENCES `bc_member` (`memberId`),
  CONSTRAINT `FK7D54E9E22C2650DA` FOREIGN KEY (`courseId`) REFERENCES `bc_course` (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bc_member_course
-- ----------------------------
INSERT INTO `bc_member_course` VALUES ('2', '2');
INSERT INTO `bc_member_course` VALUES ('3', '3');

-- ----------------------------
-- Table structure for bc_order
-- ----------------------------
DROP TABLE IF EXISTS `bc_order`;
CREATE TABLE `bc_order` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `orderName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bc_order
-- ----------------------------
INSERT INTO `bc_order` VALUES ('1', '订单2');
INSERT INTO `bc_order` VALUES ('2', '订单2');
INSERT INTO `bc_order` VALUES ('3', '订单2');
INSERT INTO `bc_order` VALUES ('4', '订单2');
INSERT INTO `bc_order` VALUES ('7', '订单2');
INSERT INTO `bc_order` VALUES ('8', '订单2');
INSERT INTO `bc_order` VALUES ('9', '订单2');
INSERT INTO `bc_order` VALUES ('10', '订单2');
INSERT INTO `bc_order` VALUES ('11', '订单2');
INSERT INTO `bc_order` VALUES ('12', '订单2');
INSERT INTO `bc_order` VALUES ('14', '订单2');
INSERT INTO `bc_order` VALUES ('15', '订单2');
INSERT INTO `bc_order` VALUES ('16', '订单2');
INSERT INTO `bc_order` VALUES ('17', '订单2');
INSERT INTO `bc_order` VALUES ('18', '订单2');
INSERT INTO `bc_order` VALUES ('19', '订单2');
INSERT INTO `bc_order` VALUES ('20', '订单1');
INSERT INTO `bc_order` VALUES ('21', '订单2');
INSERT INTO `bc_order` VALUES ('22', '订单2');
INSERT INTO `bc_order` VALUES ('23', '订单2');
INSERT INTO `bc_order` VALUES ('24', '订单2');
INSERT INTO `bc_order` VALUES ('25', '订单2');
INSERT INTO `bc_order` VALUES ('26', '订单2');
INSERT INTO `bc_order` VALUES ('27', '订单2');
INSERT INTO `bc_order` VALUES ('28', '曹亮');
INSERT INTO `bc_order` VALUES ('29', '曹亮');
INSERT INTO `bc_order` VALUES ('30', '曹亮');
INSERT INTO `bc_order` VALUES ('31', '曹亮');
INSERT INTO `bc_order` VALUES ('32', '曹亮');
INSERT INTO `bc_order` VALUES ('33', '曹亮');
INSERT INTO `bc_order` VALUES ('34', '订单2');
INSERT INTO `bc_order` VALUES ('35', '订单2');
INSERT INTO `bc_order` VALUES ('36', '订单2');

-- ----------------------------
-- Table structure for bc_product
-- ----------------------------
DROP TABLE IF EXISTS `bc_product`;
CREATE TABLE `bc_product` (
  `productId` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(255) DEFAULT NULL,
  `orderId` int(11) DEFAULT NULL,
  PRIMARY KEY (`productId`),
  KEY `FK54B1AEF1DB649CC9` (`orderId`),
  CONSTRAINT `FK54B1AEF1DB649CC9` FOREIGN KEY (`orderId`) REFERENCES `bc_order` (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bc_product
-- ----------------------------
INSERT INTO `bc_product` VALUES ('1', '优惠券3', '1');
INSERT INTO `bc_product` VALUES ('2', '优惠券3', '8');
INSERT INTO `bc_product` VALUES ('3', '优惠券3', '1');
INSERT INTO `bc_product` VALUES ('4', '优惠券3', '10');
INSERT INTO `bc_product` VALUES ('5', '优惠券3', '11');
INSERT INTO `bc_product` VALUES ('6', '优惠券3', '12');
INSERT INTO `bc_product` VALUES ('7', '优惠券3', '14');
INSERT INTO `bc_product` VALUES ('8', '优惠券3', '15');
INSERT INTO `bc_product` VALUES ('9', '好吃的', '1');
INSERT INTO `bc_product` VALUES ('10', '好吃的', '17');
INSERT INTO `bc_product` VALUES ('12', '好吃的', '18');
INSERT INTO `bc_product` VALUES ('13', '好吃的', '19');
INSERT INTO `bc_product` VALUES ('14', '西瓜1', '20');
INSERT INTO `bc_product` VALUES ('15', '西瓜2', '20');
INSERT INTO `bc_product` VALUES ('16', '西瓜1', '21');
INSERT INTO `bc_product` VALUES ('17', '西瓜2', '21');
INSERT INTO `bc_product` VALUES ('18', '好吃的', '24');
INSERT INTO `bc_product` VALUES ('19', '好吃的', '25');
INSERT INTO `bc_product` VALUES ('20', '好吃的', '26');
INSERT INTO `bc_product` VALUES ('21', 'as1d', '27');
INSERT INTO `bc_product` VALUES ('22', 'as1d', '28');
INSERT INTO `bc_product` VALUES ('23', 'as1d', '29');
INSERT INTO `bc_product` VALUES ('24', '吃香', '30');
INSERT INTO `bc_product` VALUES ('25', '吃香', '31');
INSERT INTO `bc_product` VALUES ('28', '吃香1', '32');
INSERT INTO `bc_product` VALUES ('29', '吃香', '32');
INSERT INTO `bc_product` VALUES ('30', '吃香', null);
INSERT INTO `bc_product` VALUES ('31', '吃香1', null);
INSERT INTO `bc_product` VALUES ('32', '好吃的', '34');
INSERT INTO `bc_product` VALUES ('33', '好吃的', null);
INSERT INTO `bc_product` VALUES ('34', '好吃的', '36');

-- ----------------------------
-- Table structure for bc_ticket
-- ----------------------------
DROP TABLE IF EXISTS `bc_ticket`;
CREATE TABLE `bc_ticket` (
  `ticketId` int(11) NOT NULL AUTO_INCREMENT,
  `ticketName` varchar(255) DEFAULT NULL,
  `orderId` int(11) DEFAULT NULL,
  `p_index` int(11) DEFAULT NULL,
  PRIMARY KEY (`ticketId`),
  KEY `FK5B9F40CADB649CC9` (`orderId`),
  CONSTRAINT `FK5B9F40CADB649CC9` FOREIGN KEY (`orderId`) REFERENCES `bc_order` (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bc_ticket
-- ----------------------------
INSERT INTO `bc_ticket` VALUES ('1', '优惠券3', null, null);
INSERT INTO `bc_ticket` VALUES ('2', '优惠券3', null, null);
INSERT INTO `bc_ticket` VALUES ('3', '优惠券3', null, null);
INSERT INTO `bc_ticket` VALUES ('4', '优惠券3', null, null);
INSERT INTO `bc_ticket` VALUES ('5', '优惠券3', null, null);
INSERT INTO `bc_ticket` VALUES ('9', '优惠券1', '1', null);
INSERT INTO `bc_ticket` VALUES ('10', '优惠券2', '1', null);
INSERT INTO `bc_ticket` VALUES ('11', '优惠券1', '3', null);
INSERT INTO `bc_ticket` VALUES ('12', '优惠券2', '3', null);
INSERT INTO `bc_ticket` VALUES ('13', '优惠券1', '4', null);
INSERT INTO `bc_ticket` VALUES ('14', '优惠券2', '4', null);
INSERT INTO `bc_ticket` VALUES ('15', '优惠券1', '23', '0');
INSERT INTO `bc_ticket` VALUES ('16', '优惠券2', '23', '1');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customerId` int(11) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------

-- ----------------------------
-- Table structure for lj_account
-- ----------------------------
DROP TABLE IF EXISTS `lj_account`;
CREATE TABLE `lj_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `blance` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_account
-- ----------------------------
INSERT INTO `lj_account` VALUES ('1', '30', '1900.00');

-- ----------------------------
-- Table structure for lj_bicardlj
-- ----------------------------
DROP TABLE IF EXISTS `lj_bicardlj`;
CREATE TABLE `lj_bicardlj` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `usersId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2166ED562952CAF5` (`usersId`),
  CONSTRAINT `FK2166ED562952CAF5` FOREIGN KEY (`usersId`) REFERENCES `lj_biuserlj` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_bicardlj
-- ----------------------------

-- ----------------------------
-- Table structure for lj_biuserlj
-- ----------------------------
DROP TABLE IF EXISTS `lj_biuserlj`;
CREATE TABLE `lj_biuserlj` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_biuserlj
-- ----------------------------

-- ----------------------------
-- Table structure for lj_cardlj
-- ----------------------------
DROP TABLE IF EXISTS `lj_cardlj`;
CREATE TABLE `lj_cardlj` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE007668FD22F7551` (`userId`),
  CONSTRAINT `FKE007668FD22F7551` FOREIGN KEY (`userId`) REFERENCES `lj_userlj` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_cardlj
-- ----------------------------

-- ----------------------------
-- Table structure for lj_cc
-- ----------------------------
DROP TABLE IF EXISTS `lj_cc`;
CREATE TABLE `lj_cc` (
  `clientId` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  PRIMARY KEY (`clientId`,`courseId`),
  KEY `FK6238AC1900C292F` (`clientId`),
  KEY `FK6238AC11518C2DE` (`courseId`),
  CONSTRAINT `FK6238AC11518C2DE` FOREIGN KEY (`courseId`) REFERENCES `lj_fitcourse` (`id`),
  CONSTRAINT `FK6238AC1900C292F` FOREIGN KEY (`clientId`) REFERENCES `lj_client` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_cc
-- ----------------------------

-- ----------------------------
-- Table structure for lj_client
-- ----------------------------
DROP TABLE IF EXISTS `lj_client`;
CREATE TABLE `lj_client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_client
-- ----------------------------

-- ----------------------------
-- Table structure for lj_client2
-- ----------------------------
DROP TABLE IF EXISTS `lj_client2`;
CREATE TABLE `lj_client2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_client2
-- ----------------------------

-- ----------------------------
-- Table structure for lj_client2_courses
-- ----------------------------
DROP TABLE IF EXISTS `lj_client2_courses`;
CREATE TABLE `lj_client2_courses` (
  `clientId` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  PRIMARY KEY (`clientId`,`courseId`),
  KEY `FK55D4407F191C2C6F` (`clientId`),
  KEY `FK55D4407F20ABEF40` (`courseId`),
  CONSTRAINT `FK55D4407F191C2C6F` FOREIGN KEY (`clientId`) REFERENCES `lj_client2` (`id`),
  CONSTRAINT `FK55D4407F20ABEF40` FOREIGN KEY (`courseId`) REFERENCES `lj_fitcourse2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_client2_courses
-- ----------------------------

-- ----------------------------
-- Table structure for lj_company
-- ----------------------------
DROP TABLE IF EXISTS `lj_company`;
CREATE TABLE `lj_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_company
-- ----------------------------
INSERT INTO `lj_company` VALUES ('1', '无锡百纯');
INSERT INTO `lj_company` VALUES ('2', '无锡拼起来');
INSERT INTO `lj_company` VALUES ('3', '南通中威科技');
INSERT INTO `lj_company` VALUES ('4', 'aaa');

-- ----------------------------
-- Table structure for lj_dog
-- ----------------------------
DROP TABLE IF EXISTS `lj_dog`;
CREATE TABLE `lj_dog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `ownerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKBE4DD2FBA2364C0D` (`ownerId`),
  CONSTRAINT `FKBE4DD2FBA2364C0D` FOREIGN KEY (`ownerId`) REFERENCES `lj_owner` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_dog
-- ----------------------------
INSERT INTO `lj_dog` VALUES ('1', '小黄', '1');

-- ----------------------------
-- Table structure for lj_employcard
-- ----------------------------
DROP TABLE IF EXISTS `lj_employcard`;
CREATE TABLE `lj_employcard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cardName` varchar(255) DEFAULT NULL,
  `creatTime` date DEFAULT NULL,
  `cardNumber` varchar(255) DEFAULT NULL,
  `line` int(11) NOT NULL,
  `employeeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK19A80B1FA43C1B25` (`employeeId`),
  CONSTRAINT `FK19A80B1FA43C1B25` FOREIGN KEY (`employeeId`) REFERENCES `lj_employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_employcard
-- ----------------------------
INSERT INTO `lj_employcard` VALUES ('1', '信用卡2', null, null, '0', '1');
INSERT INTO `lj_employcard` VALUES ('2', '工社保卡', null, null, '0', '2');
INSERT INTO `lj_employcard` VALUES ('3', '工医保卡', null, null, '0', '3');
INSERT INTO `lj_employcard` VALUES ('4', '信用卡1', null, 'abc11', '0', '1');
INSERT INTO `lj_employcard` VALUES ('5', '工资卡2', null, null, '0', '1');
INSERT INTO `lj_employcard` VALUES ('6', '工资卡0', '2018-05-03', 'abc0', '10000', '4');
INSERT INTO `lj_employcard` VALUES ('7', '工资卡1', '2018-05-03', 'abc1', '13000', '5');
INSERT INTO `lj_employcard` VALUES ('8', '工资卡2', '2018-05-03', 'abc2', '16000', '6');
INSERT INTO `lj_employcard` VALUES ('9', '工资卡3', '2018-05-03', 'abc3', '19000', '7');
INSERT INTO `lj_employcard` VALUES ('10', '工资卡4', '2018-05-03', 'abc4', '22000', '8');
INSERT INTO `lj_employcard` VALUES ('11', '工资卡5', '2018-05-03', 'abc5', '25000', '9');
INSERT INTO `lj_employcard` VALUES ('12', '工资卡6', '2018-05-03', 'abc6', '28000', '10');
INSERT INTO `lj_employcard` VALUES ('13', '工资卡7', '2018-05-03', 'abc7', '31000', '11');
INSERT INTO `lj_employcard` VALUES ('14', '工资卡8', '2018-05-03', 'abc8', '34000', '12');
INSERT INTO `lj_employcard` VALUES ('15', '工资卡9', '2018-05-03', 'abc9', '37000', '13');
INSERT INTO `lj_employcard` VALUES ('16', null, null, null, '12312', '1');

-- ----------------------------
-- Table structure for lj_employee
-- ----------------------------
DROP TABLE IF EXISTS `lj_employee`;
CREATE TABLE `lj_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employeeName` varchar(255) DEFAULT NULL,
  `companyId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK436C584F20EDE8E7` (`companyId`),
  CONSTRAINT `FK436C584F20EDE8E7` FOREIGN KEY (`companyId`) REFERENCES `lj_company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_employee
-- ----------------------------
INSERT INTO `lj_employee` VALUES ('1', '高希', '1');
INSERT INTO `lj_employee` VALUES ('2', '彩玉', '1');
INSERT INTO `lj_employee` VALUES ('3', '梁慧', '2');
INSERT INTO `lj_employee` VALUES ('4', '高希0', '1');
INSERT INTO `lj_employee` VALUES ('5', '高希1', '2');
INSERT INTO `lj_employee` VALUES ('6', '高希2', '3');
INSERT INTO `lj_employee` VALUES ('7', '高希3', '4');
INSERT INTO `lj_employee` VALUES ('8', '高希4', '1');
INSERT INTO `lj_employee` VALUES ('9', '高希5', '1');
INSERT INTO `lj_employee` VALUES ('10', '高希6', '1');
INSERT INTO `lj_employee` VALUES ('11', '高希7', '1');
INSERT INTO `lj_employee` VALUES ('12', '高希8', '1');
INSERT INTO `lj_employee` VALUES ('13', '高希9', '1');

-- ----------------------------
-- Table structure for lj_fitcourse
-- ----------------------------
DROP TABLE IF EXISTS `lj_fitcourse`;
CREATE TABLE `lj_fitcourse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_fitcourse
-- ----------------------------

-- ----------------------------
-- Table structure for lj_fitcourse2
-- ----------------------------
DROP TABLE IF EXISTS `lj_fitcourse2`;
CREATE TABLE `lj_fitcourse2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_fitcourse2
-- ----------------------------

-- ----------------------------
-- Table structure for lj_group
-- ----------------------------
DROP TABLE IF EXISTS `lj_group`;
CREATE TABLE `lj_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_group
-- ----------------------------

-- ----------------------------
-- Table structure for lj_group2
-- ----------------------------
DROP TABLE IF EXISTS `lj_group2`;
CREATE TABLE `lj_group2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_group2
-- ----------------------------

-- ----------------------------
-- Table structure for lj_husband
-- ----------------------------
DROP TABLE IF EXISTS `lj_husband`;
CREATE TABLE `lj_husband` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `husName` varchar(255) DEFAULT NULL,
  `wifeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4B92FE7A45B4E699` (`wifeId`),
  CONSTRAINT `FK4B92FE7A45B4E699` FOREIGN KEY (`wifeId`) REFERENCES `lj_wife` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_husband
-- ----------------------------

-- ----------------------------
-- Table structure for lj_husband2
-- ----------------------------
DROP TABLE IF EXISTS `lj_husband2`;
CREATE TABLE `lj_husband2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `husName` varchar(255) DEFAULT NULL,
  `wifeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `wifeId` (`wifeId`),
  KEY `FK26CCD0F8F1F0E711` (`wifeId`),
  CONSTRAINT `FK26CCD0F8F1F0E711` FOREIGN KEY (`wifeId`) REFERENCES `lj_wife2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_husband2
-- ----------------------------

-- ----------------------------
-- Table structure for lj_order
-- ----------------------------
DROP TABLE IF EXISTS `lj_order`;
CREATE TABLE `lj_order` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `productId` int(11) DEFAULT NULL,
  `productNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_order
-- ----------------------------
INSERT INTO `lj_order` VALUES ('1', '订单1', null, null);
INSERT INTO `lj_order` VALUES ('2', '订单2', null, null);
INSERT INTO `lj_order` VALUES ('3', '订单3', null, null);
INSERT INTO `lj_order` VALUES ('6', '订单测试1', '2', '50');

-- ----------------------------
-- Table structure for lj_order2
-- ----------------------------
DROP TABLE IF EXISTS `lj_order2`;
CREATE TABLE `lj_order2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_order2
-- ----------------------------

-- ----------------------------
-- Table structure for lj_order3
-- ----------------------------
DROP TABLE IF EXISTS `lj_order3`;
CREATE TABLE `lj_order3` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_order3
-- ----------------------------

-- ----------------------------
-- Table structure for lj_order4
-- ----------------------------
DROP TABLE IF EXISTS `lj_order4`;
CREATE TABLE `lj_order4` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_order4
-- ----------------------------

-- ----------------------------
-- Table structure for lj_owner
-- ----------------------------
DROP TABLE IF EXISTS `lj_owner`;
CREATE TABLE `lj_owner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_owner
-- ----------------------------
INSERT INTO `lj_owner` VALUES ('1', '陆建');

-- ----------------------------
-- Table structure for lj_person
-- ----------------------------
DROP TABLE IF EXISTS `lj_person`;
CREATE TABLE `lj_person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `weight1` int(11) DEFAULT NULL,
  `hobby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_person
-- ----------------------------

-- ----------------------------
-- Table structure for lj_person2
-- ----------------------------
DROP TABLE IF EXISTS `lj_person2`;
CREATE TABLE `lj_person2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `ww2` int(11) DEFAULT NULL,
  `hobby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_person2
-- ----------------------------

-- ----------------------------
-- Table structure for lj_product
-- ----------------------------
DROP TABLE IF EXISTS `lj_product`;
CREATE TABLE `lj_product` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `orderId` int(11) DEFAULT NULL,
  `productNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKED6F232EBFBD6792` (`orderId`),
  CONSTRAINT `FKED6F232EBFBD6792` FOREIGN KEY (`orderId`) REFERENCES `lj_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_product
-- ----------------------------
INSERT INTO `lj_product` VALUES ('1', '商品1', '1', '1000');
INSERT INTO `lj_product` VALUES ('2', '商品1', '1', '249');
INSERT INTO `lj_product` VALUES ('3', '商品3', '2', null);
INSERT INTO `lj_product` VALUES ('4', '商品4', null, null);

-- ----------------------------
-- Table structure for lj_product2
-- ----------------------------
DROP TABLE IF EXISTS `lj_product2`;
CREATE TABLE `lj_product2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `orderId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC07542C4A66A5F92` (`orderId`),
  CONSTRAINT `FKC07542C4A66A5F92` FOREIGN KEY (`orderId`) REFERENCES `lj_order2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_product2
-- ----------------------------

-- ----------------------------
-- Table structure for lj_product3
-- ----------------------------
DROP TABLE IF EXISTS `lj_product3`;
CREATE TABLE `lj_product3` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `orderId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC07542C5B37CC9AE` (`orderId`),
  CONSTRAINT `FKC07542C5B37CC9AE` FOREIGN KEY (`orderId`) REFERENCES `lj_order3` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_product3
-- ----------------------------

-- ----------------------------
-- Table structure for lj_product4
-- ----------------------------
DROP TABLE IF EXISTS `lj_product4`;
CREATE TABLE `lj_product4` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `orderId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC07542C6B37CC9AF` (`orderId`),
  CONSTRAINT `FKC07542C6B37CC9AF` FOREIGN KEY (`orderId`) REFERENCES `lj_order4` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_product4
-- ----------------------------

-- ----------------------------
-- Table structure for lj_student
-- ----------------------------
DROP TABLE IF EXISTS `lj_student`;
CREATE TABLE `lj_student` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `birth` datetime DEFAULT NULL,
  `isgood` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_student
-- ----------------------------

-- ----------------------------
-- Table structure for lj_teacher
-- ----------------------------
DROP TABLE IF EXISTS `lj_teacher`;
CREATE TABLE `lj_teacher` (
  `name` varchar(255) NOT NULL,
  `id` int(11) NOT NULL,
  `birth` date DEFAULT NULL,
  `zc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_teacher
-- ----------------------------
INSERT INTO `lj_teacher` VALUES ('tpk2啊', '5', '2018-05-07', 'B');

-- ----------------------------
-- Table structure for lj_user
-- ----------------------------
DROP TABLE IF EXISTS `lj_user`;
CREATE TABLE `lj_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `groupId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB7455EC6B354A9C` (`groupId`),
  CONSTRAINT `FKB7455EC6B354A9C` FOREIGN KEY (`groupId`) REFERENCES `lj_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_user
-- ----------------------------

-- ----------------------------
-- Table structure for lj_user2
-- ----------------------------
DROP TABLE IF EXISTS `lj_user2`;
CREATE TABLE `lj_user2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `groupId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK631667C66B354A9C` (`groupId`),
  CONSTRAINT `FK631667C66B354A9C` FOREIGN KEY (`groupId`) REFERENCES `lj_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_user2
-- ----------------------------

-- ----------------------------
-- Table structure for lj_userlj
-- ----------------------------
DROP TABLE IF EXISTS `lj_userlj`;
CREATE TABLE `lj_userlj` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_userlj
-- ----------------------------

-- ----------------------------
-- Table structure for lj_wife
-- ----------------------------
DROP TABLE IF EXISTS `lj_wife`;
CREATE TABLE `lj_wife` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_wife
-- ----------------------------

-- ----------------------------
-- Table structure for lj_wife2
-- ----------------------------
DROP TABLE IF EXISTS `lj_wife2`;
CREATE TABLE `lj_wife2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lj_wife2
-- ----------------------------

-- ----------------------------
-- Table structure for mathcourse
-- ----------------------------
DROP TABLE IF EXISTS `mathcourse`;
CREATE TABLE `mathcourse` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `mathName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mathcourse
-- ----------------------------

-- ----------------------------
-- Table structure for mb_order
-- ----------------------------
DROP TABLE IF EXISTS `mb_order`;
CREATE TABLE `mb_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderNo` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mb_order
-- ----------------------------
INSERT INTO `mb_order` VALUES ('1', '111', '2018-05-10 15:53:36', '1');
INSERT INTO `mb_order` VALUES ('2', 'asas', '2018-05-02 15:54:04', '2');
INSERT INTO `mb_order` VALUES ('3', 'sas', '2018-05-02 15:57:59', '3');

-- ----------------------------
-- Table structure for mb_orderproduct
-- ----------------------------
DROP TABLE IF EXISTS `mb_orderproduct`;
CREATE TABLE `mb_orderproduct` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) NOT NULL,
  `productName` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id` (`orderId`),
  CONSTRAINT `fk_id` FOREIGN KEY (`orderId`) REFERENCES `mb_order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mb_orderproduct
-- ----------------------------
INSERT INTO `mb_orderproduct` VALUES ('1', '1', '卫龙', '2.00', '1');
INSERT INTO `mb_orderproduct` VALUES ('2', '1', '乐事薯片', '6.00', '2');
INSERT INTO `mb_orderproduct` VALUES ('3', '2', '麻薯', '3.00', '1');
INSERT INTO `mb_orderproduct` VALUES ('4', '2', '干脆面', '1.00', '3');

-- ----------------------------
-- Table structure for mb_user
-- ----------------------------
DROP TABLE IF EXISTS `mb_user`;
CREATE TABLE `mb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mb_user
-- ----------------------------
INSERT INTO `mb_user` VALUES ('1', '张三', '11');
INSERT INTO `mb_user` VALUES ('2', '李四', '12');
INSERT INTO `mb_user` VALUES ('3', '张全蛋', '16');
INSERT INTO `mb_user` VALUES ('7', '周涛', '25');
INSERT INTO `mb_user` VALUES ('8', '周涛', '25');
INSERT INTO `mb_user` VALUES ('9', '周涛', '25');
INSERT INTO `mb_user` VALUES ('10', '周涛', '25');
INSERT INTO `mb_user` VALUES ('11', '周涛', '25');
INSERT INTO `mb_user` VALUES ('12', '周涛1', '25');
INSERT INTO `mb_user` VALUES ('13', '周涛', '25');

-- ----------------------------
-- Table structure for sportcourse
-- ----------------------------
DROP TABLE IF EXISTS `sportcourse`;
CREATE TABLE `sportcourse` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `courseName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sportcourse
-- ----------------------------
INSERT INTO `sportcourse` VALUES ('1', 'math', '前进');

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `logonName` varchar(50) DEFAULT NULL,
  `logonPwd` varchar(50) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `birthday` varchar(50) DEFAULT NULL,
  `education` varchar(20) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `interest` varchar(20) DEFAULT NULL,
  `path` varchar(500) DEFAULT NULL,
  `filename` varchar(100) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('1', 'admin', 'admin', '111111', '男', '1999-1-1', '博士', null, null, null, null, null);
INSERT INTO `s_user` VALUES ('2', '2', '2', '2', '2', null, null, null, null, null, null, null);
INSERT INTO `s_user` VALUES ('6', null, null, null, null, null, null, null, null, 'f://1.jpg', null, null);
INSERT INTO `s_user` VALUES ('7', '阿萨', null, null, null, null, null, null, null, 'f:/upload/1492008855290/5f46bad3fd1f4134221cc5f3251f95cad0c85ee9.jpg', null, null);
INSERT INTO `s_user` VALUES ('8', '啊啊啊', null, null, null, null, null, null, null, 'f:/upload/1492008992406/1.jpg', null, null);
INSERT INTO `s_user` VALUES ('9', null, null, null, null, null, null, null, null, 'f:/upload/1492010742896/安妮对近战.png', null, null);
INSERT INTO `s_user` VALUES ('10', '撒', null, null, null, null, null, null, null, 'f:/upload/1492012136867/6dc09e0a18782a72b0351d49.jpg', null, null);
INSERT INTO `s_user` VALUES ('11', null, null, null, null, null, null, null, null, 'f:/upload/1492012595409/1862.jpg', null, null);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `zhicheng` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- Table structure for wife
-- ----------------------------
DROP TABLE IF EXISTS `wife`;
CREATE TABLE `wife` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wife
-- ----------------------------
INSERT INTO `wife` VALUES ('1', '单星星');
INSERT INTO `wife` VALUES ('2', '单星星');
INSERT INTO `wife` VALUES ('3', '单星星');
INSERT INTO `wife` VALUES ('4', '单星星');

-- ----------------------------
-- Procedure structure for my_pro2
-- ----------------------------
DROP PROCEDURE IF EXISTS `my_pro2`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `my_pro2`()
BEGIN                               
	DECLARE i int default 1;        
	SET @sum = 0;               
	
	WHILE i<100 DO                
		SET @sum= @sum+i;		
		SET i = i+1;	
	end WHILE;

	SELECT @sum;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for my_fun2
-- ----------------------------
DROP FUNCTION IF EXISTS `my_fun2`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `my_fun2`(a1 int, a2 int) RETURNS int(11)
begin
			if a1>a2 then
				return a1;
			else 
				return a2;
			end if;
		end
;;
DELIMITER ;
