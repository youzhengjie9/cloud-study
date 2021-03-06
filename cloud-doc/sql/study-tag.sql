/*
 Navicat Premium Data Transfer

 Source Server         : demo-01
 Source Server Type    : MySQL
 Source Server Version : 50711
 Source Host           : localhost:3306
 Source Schema         : study-tag

 Target Server Type    : MySQL
 Target Server Version : 50711
 File Encoding         : 65001

 Date: 11/08/2021 12:57:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` bigint(20) NOT NULL,
  `tagName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (3048820879000581, '1');
INSERT INTO `tag` VALUES (3048822270460933, '1');
INSERT INTO `tag` VALUES (3048822367585285, '1');
INSERT INTO `tag` VALUES (3048822456779781, '2');
INSERT INTO `tag` VALUES (3048823287317509, 'BACK');
INSERT INTO `tag` VALUES (3048824558912517, 'BACK');
INSERT INTO `tag` VALUES (3048825772180485, 'BACK');

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `context` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime(0) NOT NULL,
  `log_modified` datetime(0) NOT NULL,
  `ext` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `ux_undo_log`(`xid`, `branch_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 88 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of undo_log
-- ----------------------------
INSERT INTO `undo_log` VALUES (41, 168705858513932289, '192.168.184.1:8091:168705858203553792', 'serializer=jackson', 0x7B7D, 1, '2021-08-11 12:56:51', '2021-08-11 12:56:51', NULL);
INSERT INTO `undo_log` VALUES (42, 168705858476183553, '192.168.184.1:8091:168705858203553792', 'serializer=jackson', 0x7B7D, 1, '2021-08-11 12:56:51', '2021-08-11 12:56:51', NULL);
INSERT INTO `undo_log` VALUES (46, 168705934544080897, '192.168.184.1:8091:168705934288228352', 'serializer=jackson', 0x7B7D, 1, '2021-08-11 12:57:09', '2021-08-11 12:57:09', NULL);
INSERT INTO `undo_log` VALUES (47, 168705934510526465, '192.168.184.1:8091:168705934288228352', 'serializer=jackson', 0x7B7D, 1, '2021-08-11 12:57:09', '2021-08-11 12:57:09', NULL);
INSERT INTO `undo_log` VALUES (51, 168705935563296769, '192.168.184.1:8091:168705935286472704', 'serializer=jackson', 0x7B7D, 1, '2021-08-11 12:57:09', '2021-08-11 12:57:09', NULL);
INSERT INTO `undo_log` VALUES (52, 168705935525548033, '192.168.184.1:8091:168705935286472704', 'serializer=jackson', 0x7B7D, 1, '2021-08-11 12:57:09', '2021-08-11 12:57:09', NULL);
INSERT INTO `undo_log` VALUES (56, 168705936699953153, '192.168.184.1:8091:168705936431517696', 'serializer=jackson', 0x7B7D, 1, '2021-08-11 12:57:10', '2021-08-11 12:57:10', NULL);
INSERT INTO `undo_log` VALUES (57, 168705936674787329, '192.168.184.1:8091:168705936431517696', 'serializer=jackson', 0x7B7D, 1, '2021-08-11 12:57:10', '2021-08-11 12:57:10', NULL);
INSERT INTO `undo_log` VALUES (61, 168705937744334849, '192.168.184.1:8091:168705937467510784', 'serializer=jackson', 0x7B7D, 1, '2021-08-11 12:57:10', '2021-08-11 12:57:10', NULL);
INSERT INTO `undo_log` VALUES (62, 168705937714974721, '192.168.184.1:8091:168705937467510784', 'serializer=jackson', 0x7B7D, 1, '2021-08-11 12:57:10', '2021-08-11 12:57:10', NULL);
INSERT INTO `undo_log` VALUES (66, 168705938767745025, '192.168.184.1:8091:168705938511892480', 'serializer=jackson', 0x7B7D, 1, '2021-08-11 12:57:10', '2021-08-11 12:57:10', NULL);
INSERT INTO `undo_log` VALUES (67, 168705938742579201, '192.168.184.1:8091:168705938511892480', 'serializer=jackson', 0x7B7D, 1, '2021-08-11 12:57:10', '2021-08-11 12:57:10', NULL);
INSERT INTO `undo_log` VALUES (71, 168705939837292545, '192.168.184.1:8091:168705939552079872', 'serializer=jackson', 0x7B7D, 1, '2021-08-11 12:57:10', '2021-08-11 12:57:10', NULL);
INSERT INTO `undo_log` VALUES (72, 168705939799543809, '192.168.184.1:8091:168705939552079872', 'serializer=jackson', 0x7B7D, 1, '2021-08-11 12:57:10', '2021-08-11 12:57:10', NULL);
INSERT INTO `undo_log` VALUES (76, 168705940906840065, '192.168.184.1:8091:168705940659376128', 'serializer=jackson', 0x7B7D, 1, '2021-08-11 12:57:11', '2021-08-11 12:57:11', NULL);
INSERT INTO `undo_log` VALUES (77, 168705940881674241, '192.168.184.1:8091:168705940659376128', 'serializer=jackson', 0x7B7D, 1, '2021-08-11 12:57:11', '2021-08-11 12:57:11', NULL);
INSERT INTO `undo_log` VALUES (81, 168705942009942017, '192.168.184.1:8091:168705941770866688', 'serializer=jackson', 0x7B7D, 1, '2021-08-11 12:57:11', '2021-08-11 12:57:11', NULL);
INSERT INTO `undo_log` VALUES (82, 168705941980581889, '192.168.184.1:8091:168705941770866688', 'serializer=jackson', 0x7B7D, 1, '2021-08-11 12:57:11', '2021-08-11 12:57:11', NULL);
INSERT INTO `undo_log` VALUES (86, 168705942999797761, '192.168.184.1:8091:168705942773305344', 'serializer=jackson', 0x7B7D, 1, '2021-08-11 12:57:11', '2021-08-11 12:57:11', NULL);
INSERT INTO `undo_log` VALUES (87, 168705942974631937, '192.168.184.1:8091:168705942773305344', 'serializer=jackson', 0x7B7D, 1, '2021-08-11 12:57:11', '2021-08-11 12:57:11', NULL);

SET FOREIGN_KEY_CHECKS = 1;
