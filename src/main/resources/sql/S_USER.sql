/*
 Navicat Premium Data Transfer

 Source Server         : vm-192.168.72.128
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 192.168.72.128:3306
 Source Schema         : ssdemo

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 27/02/2019 18:23:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for S_USER
-- ----------------------------
DROP TABLE IF EXISTS `S_USER`;
CREATE TABLE `S_USER`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT '' COMMENT '昵称',
  `roles` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '身份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of S_USER
-- ----------------------------
INSERT INTO `S_USER` VALUES (1, 'anoy', '123456', 'anoy', 'ROLE_USER');
INSERT INTO `S_USER` VALUES (4, 'admin', '$2a$10$iNXzpGBhfh1bUuqXIyrUwOboQ.VVIKTsz9nh3wrA4PvpdWlScLyXa', '12.', 'ROLE_USER');

SET FOREIGN_KEY_CHECKS = 1;
