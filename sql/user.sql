/*
Navicat MySQL Data Transfer

Source Server         : local-mysql
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : ourschool

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-06-18 11:50:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `version` int(11) DEFAULT NULL COMMENT '乐观锁',
  `deleted` int(11) DEFAULT 0 COMMENT '逻辑删除',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '密码',
  `perms` varchar(100) NOT NULL,
  `roles` varchar(100) NOT NULL COMMENT '角色信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1262050682745253890 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '李四', '18', 'mg123@qq.com', '2020-05-17 23:37:48', '2020-05-17 17:43:25', '2', '0', '', 'user:add', '');
INSERT INTO `user` VALUES ('2', '张自忠', '20', 'helloworld@gmail.com', '2020-05-17 23:37:48', '2020-05-17 23:37:48', '1', '0', '', 'user:read', '');
INSERT INTO `user` VALUES ('3', '李四111', '28', 'mg123@qq.com', '2020-05-17 23:37:48', '2020-05-17 18:00:40', '4', '0', '', 'user:update', '');
INSERT INTO `user` VALUES ('4', 'Amy', '21', 'test4@baomidou.com', '2020-05-17 23:37:48', '2020-05-17 23:37:48', '1', '0', '', '', 'role:admin');
INSERT INTO `user` VALUES ('5', 'MG', '24', 'test5@baomidou.com', '2020-05-17 23:37:48', '2020-05-17 23:37:48', '1', '0', '', 'user:money', '');
INSERT INTO `user` VALUES ('1262037913186697217', '张三', '3', '2246890834578@qq.com', '2020-05-17 23:37:48', '2020-05-17 23:37:48', '1', '0', '', '', '');
INSERT INTO `user` VALUES ('1262037913186697218', '张三', '3', '2246890834578@qq.com', '2020-05-17 23:37:48', '2020-05-17 23:37:48', '1', '0', '', '', '');
INSERT INTO `user` VALUES ('1262041503661940738', '张三', '3', '2246890834578@qq.com', '2020-05-17 23:37:48', '2020-05-17 23:37:48', '1', '1', '', '', '');
INSERT INTO `user` VALUES ('1262043073220792322', '张三', '3', '2246890834578@qq.com', '2020-05-17 23:37:48', '2020-05-17 23:37:48', '1', '1', '', '', '');
INSERT INTO `user` VALUES ('1262050682745253889', 'Kings !', '3', '2246890834578@qq.com', '2020-05-17 16:01:45', '2020-05-17 16:01:45', '1', '0', '', '', '');
