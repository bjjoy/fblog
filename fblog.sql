/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : fblog

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-09-16 23:13:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `blog_uuid` varchar(32) NOT NULL,
  `blog_head` varchar(32) NOT NULL COMMENT '博客标题',
  `blog_brief` varchar(255) DEFAULT NULL COMMENT '博客简介',
  `read_count` int(11) NOT NULL DEFAULT '0' COMMENT '被阅读次数',
  `blogger_uuid` varchar(32) NOT NULL COMMENT '博主uuid',
  `blogger_name` varchar(20) DEFAULT NULL COMMENT '博主名称',
  `category_uuid` varchar(32) DEFAULT NULL COMMENT '类别uuid',
  `category_name` varchar(20) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`blog_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------

-- ----------------------------
-- Table structure for `blogger`
-- ----------------------------
DROP TABLE IF EXISTS `blogger`;
CREATE TABLE `blogger` (
  `blogger_uuid` varchar(32) NOT NULL COMMENT '博主uuid',
  `blogger_name` varchar(20) DEFAULT NULL COMMENT '博主昵称',
  `profession` varchar(20) DEFAULT NULL COMMENT '职业',
  `blogger_sex` tinyint(4) DEFAULT NULL COMMENT '性别(0男 1女)',
  `region_code` char(6) DEFAULT NULL COMMENT '地区编码',
  `blogger_brief` varchar(255) DEFAULT NULL COMMENT '博主简介',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`blogger_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blogger
-- ----------------------------

-- ----------------------------
-- Table structure for `blog_category`
-- ----------------------------
DROP TABLE IF EXISTS `blog_category`;
CREATE TABLE `blog_category` (
  `category_uuid` varchar(32) NOT NULL COMMENT '类别id',
  `categroy_name` varchar(20) DEFAULT NULL COMMENT '类别名称',
  `blogger_uuid` varchar(32) DEFAULT NULL COMMENT '博主uuid',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`category_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_category
-- ----------------------------

-- ----------------------------
-- Table structure for `blog_content`
-- ----------------------------
DROP TABLE IF EXISTS `blog_content`;
CREATE TABLE `blog_content` (
  `content_uuid` varchar(32) NOT NULL COMMENT '博客内容uuid',
  `content` text COMMENT '博客内容',
  `blog_uuid` varchar(32) DEFAULT NULL COMMENT '博客uuid',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`content_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_content
-- ----------------------------
