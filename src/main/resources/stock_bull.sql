/*
Navicat MySQL Data Transfer

Source Server         : 1
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : spider

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-09-18 22:27:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock_bull`;
CREATE TABLE `stock_bull` (
  `pkid` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `newPrice` varchar(255) DEFAULT NULL,
  `increase` varchar(255) DEFAULT NULL,
  `dataStr` varchar(255) DEFAULT NULL,
  `keystr` varchar(255) DEFAULT NULL,
  `realIndexName` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `days` int(11) DEFAULT 0,
  `times` int(11) DEFAULT 0,
  `createTime` datetime DEFAULT NULL,
  `modifyTime` datetime DEFAULT NULL,
  `isDelete` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pkid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
