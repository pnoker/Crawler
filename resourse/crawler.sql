/*
Navicat MySQL Data Transfer

Source Server         : MySql-Local
Source Server Version : 50546
Source Host           : localhost:3306
Source Database       : crawler

Target Server Type    : MYSQL
Target Server Version : 50546
File Encoding         : 65001

Date: 2016-09-30 11:29:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for america
-- ----------------------------
DROP TABLE IF EXISTS `america`;
CREATE TABLE `america` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id,唯一标示',
  `place_name` varchar(255) DEFAULT NULL COMMENT '地名',
  `longitude` varchar(32) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(32) DEFAULT NULL COMMENT '纬度',
  `mag` float(32,1) DEFAULT NULL COMMENT '震级',
  `depth` varchar(32) DEFAULT NULL,
  `time` datetime DEFAULT NULL COMMENT '地震发生时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for europe
-- ----------------------------
DROP TABLE IF EXISTS `europe`;
CREATE TABLE `europe` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id,唯一标示',
  `place_name` varchar(255) DEFAULT NULL COMMENT '地名',
  `longitude` varchar(32) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(32) DEFAULT NULL COMMENT '纬度',
  `mag` float(32,1) DEFAULT NULL COMMENT '震级',
  `depth` varchar(32) DEFAULT NULL,
  `time` datetime DEFAULT NULL COMMENT '地震发生时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for germany
-- ----------------------------
DROP TABLE IF EXISTS `germany`;
CREATE TABLE `germany` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id,唯一标示',
  `place_name` varchar(255) DEFAULT NULL COMMENT '地名',
  `longitude` varchar(32) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(32) DEFAULT NULL COMMENT '纬度',
  `mag` float(32,1) DEFAULT NULL COMMENT '震级',
  `depth` varchar(32) DEFAULT NULL,
  `time` datetime DEFAULT NULL COMMENT '地震发生时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for japan
-- ----------------------------
DROP TABLE IF EXISTS `japan`;
CREATE TABLE `japan` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id,唯一标示',
  `place_name` varchar(255) DEFAULT NULL COMMENT '地名',
  `longitude` varchar(32) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(32) DEFAULT NULL COMMENT '纬度',
  `mag` float(32,1) DEFAULT NULL COMMENT '震级',
  `depth` varchar(32) DEFAULT NULL,
  `time` datetime DEFAULT NULL COMMENT '地震发生时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for switzerland
-- ----------------------------
DROP TABLE IF EXISTS `switzerland`;
CREATE TABLE `switzerland` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id,唯一标示',
  `place_name` varchar(255) DEFAULT NULL COMMENT '地名',
  `longitude` varchar(32) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(32) DEFAULT NULL COMMENT '纬度',
  `mag` float(32,1) DEFAULT NULL COMMENT '震级',
  `depth` varchar(32) DEFAULT NULL,
  `time` datetime DEFAULT NULL COMMENT '地震发生时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for taiwan
-- ----------------------------
DROP TABLE IF EXISTS `taiwan`;
CREATE TABLE `taiwan` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id,唯一标示',
  `place_name` varchar(255) DEFAULT NULL COMMENT '地名',
  `longitude` varchar(32) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(32) DEFAULT NULL COMMENT '纬度',
  `mag` float(32,1) DEFAULT NULL COMMENT '震级',
  `depth` varchar(32) DEFAULT NULL,
  `time` datetime DEFAULT NULL COMMENT '地震发生时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
