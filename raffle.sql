/*
 Navicat Premium Data Transfer

 Source Server         : UniX1037
 Source Server Type    : MySQL
 Source Server Version : 80036
 Source Host           : localhost:3306
 Source Schema         : raffle

 Target Server Type    : MySQL
 Target Server Version : 80036
 File Encoding         : 65001

 Date: 18/01/2025 10:54:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for prize
-- ----------------------------
DROP TABLE IF EXISTS `prize`;
CREATE TABLE `prize`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `stock` int NULL DEFAULT NULL,
  `probability` double NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of prize
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `participated` int NULL DEFAULT 0 COMMENT '0为未参与抽奖，1为参与过',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2046320669 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '郑祺锐', '1', 1);
INSERT INTO `user` VALUES (2, 'wangyuelei', '5807 272341', 0);
INSERT INTO `user` VALUES (3, 'Ishikawa Hikari', '212-629-1017', 0);
INSERT INTO `user` VALUES (4, 'Louis Foster', '80-3097-2328', 0);
INSERT INTO `user` VALUES (5, 'Murakami Hikaru', '(151) 442 3785', 0);
INSERT INTO `user` VALUES (6, 'Koon Wing Fat', '20-533-8966', 0);
INSERT INTO `user` VALUES (7, 'Harada Rena', '74-989-9619', 0);
INSERT INTO `user` VALUES (8, 'Kato Yuna', '(151) 525 5719', 0);
INSERT INTO `user` VALUES (9, 'Sherry Simpson', '5338 329803', 0);
INSERT INTO `user` VALUES (10, 'Tse Tak Wah', '7503 840242', 0);
INSERT INTO `user` VALUES (2046320649, '郑祺锐', '1', 0);
INSERT INTO `user` VALUES (2046320650, 'wangyuelei', '5807 272341', 0);
INSERT INTO `user` VALUES (2046320651, 'Ishikawa Hikari', '212-629-1017', 0);
INSERT INTO `user` VALUES (2046320652, 'Louis Foster', '80-3097-2328', 0);
INSERT INTO `user` VALUES (2046320653, 'Murakami Hikaru', '(151) 442 3785', 0);
INSERT INTO `user` VALUES (2046320654, 'Koon Wing Fat', '20-533-8966', 0);
INSERT INTO `user` VALUES (2046320655, 'Harada Rena', '74-989-9619', 0);
INSERT INTO `user` VALUES (2046320656, 'Kato Yuna', '(151) 525 5719', 0);
INSERT INTO `user` VALUES (2046320657, 'Sherry Simpson', '5338 329803', 0);
INSERT INTO `user` VALUES (2046320658, 'Tse Tak Wah', '7503 840242', 0);
INSERT INTO `user` VALUES (2046320659, '柳芸汐', '13945608063', 0);
INSERT INTO `user` VALUES (2046320660, '郑祺锐', '1', 0);
INSERT INTO `user` VALUES (2046320661, 'wangyuelei', '5807 272341', 0);
INSERT INTO `user` VALUES (2046320662, 'Ishikawa Hikari', '212-629-1017', 0);
INSERT INTO `user` VALUES (2046320663, 'Louis Foster', '80-3097-2328', 0);
INSERT INTO `user` VALUES (2046320664, 'Murakami Hikaru', '(151) 442 3785', 0);
INSERT INTO `user` VALUES (2046320665, 'Koon Wing Fat', '20-533-8966', 0);
INSERT INTO `user` VALUES (2046320666, 'Harada Rena', '74-989-9619', 0);
INSERT INTO `user` VALUES (2046320667, 'Kato Yuna', '(151) 525 5719', 0);
INSERT INTO `user` VALUES (2046320668, 'Sherry Simpson', '5338 329803', 0);
INSERT INTO `user` VALUES (2046320669, 'Tse Tak Wah', '7503 840242', 0);

SET FOREIGN_KEY_CHECKS = 1;
