/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : localhost:3306
 Source Schema         : mybatisplus_db

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 10/12/2022 17:52:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `age` int NOT NULL,
  `tel` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `name`, `password`, `age`, `tel`) VALUES (1, 'Tom', 'tom', 3, '18866668888');
INSERT INTO `user` (`id`, `name`, `password`, `age`, `tel`) VALUES (2, 'Jerry', 'jerry', 4, '16688886666');
INSERT INTO `user` (`id`, `name`, `password`, `age`, `tel`) VALUES (3, 'Jock', '12345', 41, '18812345678');
INSERT INTO `user` (`id`, `name`, `password`, `age`, `tel`) VALUES (4, '传智播客', 'itcast', 15, '4006184000');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
