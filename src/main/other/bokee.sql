/*
Navicat MySQL Data Transfer

Source Server         : TripMode
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : bokee

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-06-16 15:13:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) COLLATE utf8_bin NOT NULL,
  `password` varchar(40) COLLATE utf8_bin NOT NULL,
  `sex` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `creat_time` date NOT NULL,
  `soccer` int(10) DEFAULT NULL,
  `user_type` int(1) NOT NULL,
  `email` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `videos`
-- ----------------------------
DROP TABLE IF EXISTS `videos`;
CREATE TABLE `videos` (
  `video_id` int(20) NOT NULL,
  `video_name` varchar(40) COLLATE utf8_bin NOT NULL,
  `creat_time` date NOT NULL,
  `upload_user` int(11) NOT NULL,
  `type` varchar(5) COLLATE utf8_bin NOT NULL,
  `rank` int(20) NOT NULL,
  `lable` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(40) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`video_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of videos
-- ----------------------------
