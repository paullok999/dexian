/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50711 (5.7.11-log)
 Source Host           : localhost:3306
 Source Schema         : dexian

 Target Server Type    : MySQL
 Target Server Version : 50711 (5.7.11-log)
 File Encoding         : 65001

 Date: 07/04/2023 23:16:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chat_personal_message
-- ----------------------------
DROP TABLE IF EXISTS `chat_personal_message`;
CREATE TABLE `chat_personal_message`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sender_id` bigint(20) NOT NULL COMMENT '发送者ID',
  `receiver_id` bigint(20) NOT NULL COMMENT '接收者ID',
  `message_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送的消息内容',
  `message_type` int(1) NULL DEFAULT NULL COMMENT '消息类型:0->文字,1->表情,2->图片,3->视频,',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '个人消息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chat_personal_message
-- ----------------------------

-- ----------------------------
-- Table structure for chat_system_message
-- ----------------------------
DROP TABLE IF EXISTS `chat_system_message`;
CREATE TABLE `chat_system_message`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `message_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统消息内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统消息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chat_system_message
-- ----------------------------

-- ----------------------------
-- Table structure for forum_post
-- ----------------------------
DROP TABLE IF EXISTS `forum_post`;
CREATE TABLE `forum_post`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `post_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '帖子内容',
  `browse_count` bigint(20) NULL DEFAULT 0 COMMENT '浏览数统计',
  `collect_count` bigint(20) NULL DEFAULT 0 COMMENT '收藏数统计',
  `like_count` bigint(20) NULL DEFAULT 0 COMMENT '点赞数统计',
  `comment_count` bigint(20) NULL DEFAULT 0 COMMENT '评论数统计',
  `release_time` datetime NULL DEFAULT NULL COMMENT '帖子发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '论坛帖子信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of forum_post
-- ----------------------------
INSERT INTO `forum_post` VALUES (1, 3, '我跟你们说，现在考研真的太卷了，22408考到400分都不一定有书读，大家还是要谨慎报学校呀', 0, 0, 3, 0, '2023-04-05 16:08:09');

-- ----------------------------
-- Table structure for forum_post_comment
-- ----------------------------
DROP TABLE IF EXISTS `forum_post_comment`;
CREATE TABLE `forum_post_comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `post_id` bigint(20) NOT NULL COMMENT '所属文章的ID',
  `parent_comment_id` bigint(20) NULL DEFAULT NULL COMMENT '所属父评论ID',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '关联的用户ID',
  `comment_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `like_count` bigint(20) NULL DEFAULT 0 COMMENT '点赞数统计',
  `release_time` datetime NULL DEFAULT NULL COMMENT '评论发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '帖子评论信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of forum_post_comment
-- ----------------------------
INSERT INTO `forum_post_comment` VALUES (5, 1, 0, 3, '兄弟，我也同意你的观点', 0, '2023-04-05 18:51:55');
INSERT INTO `forum_post_comment` VALUES (6, 1, 0, 3, 'sodayo', 0, '2023-04-05 18:52:24');
INSERT INTO `forum_post_comment` VALUES (7, 1, 5, 3, '就是啊', 0, '2023-04-05 18:53:31');
INSERT INTO `forum_post_comment` VALUES (8, 1, 6, 3, '救世啊', 0, '2023-04-05 18:54:18');

-- ----------------------------
-- Table structure for forum_post_reply
-- ----------------------------
DROP TABLE IF EXISTS `forum_post_reply`;
CREATE TABLE `forum_post_reply`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment_id` bigint(20) NULL DEFAULT NULL COMMENT '所回复的评论ID',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '关联的用户ID',
  `reply_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `like_count` bigint(20) NULL DEFAULT NULL COMMENT '点赞数统计',
  `release_time` datetime NULL DEFAULT NULL COMMENT '回复发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '回复评论信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of forum_post_reply
-- ----------------------------

-- ----------------------------
-- Table structure for idle_item
-- ----------------------------
DROP TABLE IF EXISTS `idle_item`;
CREATE TABLE `idle_item`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '闲置物品描述',
  `is_new` int(1) NULL DEFAULT 0 COMMENT '是否全新:0->否,1->是',
  `browse_count` bigint(20) NULL DEFAULT 0 COMMENT '浏览数统计',
  `favorite_count` bigint(20) NULL DEFAULT 0 COMMENT '想要数统计',
  `item_status` int(1) NULL DEFAULT NULL COMMENT '闲置物品状态:0->下架,1->上架',
  `delivery_method` int(1) NULL DEFAULT NULL COMMENT '发货方式:0->包邮,1->自提',
  `release_time` datetime NULL DEFAULT NULL COMMENT '闲置物品发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '闲置物品信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of idle_item
-- ----------------------------
INSERT INTO `idle_item` VALUES (1, 3, 1999.00, '贼好用的ipad,但是99新', 0, 4, 0, 1, 0, '2023-04-02 16:22:46');
INSERT INTO `idle_item` VALUES (6, 3, 3999.00, '贼好用的iphone14 Pro', 1, 0, 0, 1, 0, '2023-03-28 22:43:08');
INSERT INTO `idle_item` VALUES (7, 3, 1998.00, '贼好穿的Nike跑鞋', 0, 0, 0, 1, 0, '2023-04-01 18:14:46');
INSERT INTO `idle_item` VALUES (8, 3, 2998.00, '贼好穿的Jordan跑鞋', 0, 0, 0, 1, 0, '2023-04-01 18:16:19');

-- ----------------------------
-- Table structure for idle_item_images
-- ----------------------------
DROP TABLE IF EXISTS `idle_item_images`;
CREATE TABLE `idle_item_images`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idle_item_id` bigint(20) NULL DEFAULT NULL COMMENT '闲置物品ID',
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片URL',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '闲置物品关联的图片' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of idle_item_images
-- ----------------------------
INSERT INTO `idle_item_images` VALUES (1, 1, 'http://www.123.com');
INSERT INTO `idle_item_images` VALUES (2, 1, 'http://www.456.com');
INSERT INTO `idle_item_images` VALUES (3, 6, 'http://www.790.com');
INSERT INTO `idle_item_images` VALUES (4, 6, 'http://www.234.com');
INSERT INTO `idle_item_images` VALUES (5, 7, 'http://www.12345.com');
INSERT INTO `idle_item_images` VALUES (6, 7, 'http://www.12356.com');
INSERT INTO `idle_item_images` VALUES (7, 8, 'http://www.54321.com');
INSERT INTO `idle_item_images` VALUES (8, 8, 'http://www.09876.com');

-- ----------------------------
-- Table structure for idle_item_order
-- ----------------------------
DROP TABLE IF EXISTS `idle_item_order`;
CREATE TABLE `idle_item_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idle_item_id` bigint(20) NULL DEFAULT NULL COMMENT '闲置物品ID',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '订单相关用户的ID',
  `address_id` bigint(20) NULL DEFAULT NULL COMMENT '地址ID',
  `order_type` int(1) NULL DEFAULT 0 COMMENT '订单类型:0->买入,1->卖出',
  `order_status` int(1) NULL DEFAULT 0 COMMENT '订单状态:0->已拍下,1->已付款,2->交易完成',
  `create_time` datetime NULL DEFAULT NULL COMMENT '订单创建时间',
  `last_update_time` datetime NULL DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '闲置物品订单信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of idle_item_order
-- ----------------------------

-- ----------------------------
-- Table structure for idle_item_videos
-- ----------------------------
DROP TABLE IF EXISTS `idle_item_videos`;
CREATE TABLE `idle_item_videos`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idle_item_id` bigint(20) NULL DEFAULT NULL COMMENT '闲置物品ID',
  `video_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频URL',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '闲置物品关联的视频' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of idle_item_videos
-- ----------------------------
INSERT INTO `idle_item_videos` VALUES (1, 1, 'http://www.789.com');
INSERT INTO `idle_item_videos` VALUES (2, 1, 'http://www.150.com');
INSERT INTO `idle_item_videos` VALUES (3, 6, 'http://www.345.com');
INSERT INTO `idle_item_videos` VALUES (4, 6, 'http://www.098.com');
INSERT INTO `idle_item_videos` VALUES (5, 7, 'http://www.78901.com');
INSERT INTO `idle_item_videos` VALUES (6, 7, 'http://www.35690.com');
INSERT INTO `idle_item_videos` VALUES (7, 8, 'http://www.43786.com');
INSERT INTO `idle_item_videos` VALUES (8, 8, 'http://www.54982.com');

-- ----------------------------
-- Table structure for post_images
-- ----------------------------
DROP TABLE IF EXISTS `post_images`;
CREATE TABLE `post_images`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `post_id` bigint(20) NULL DEFAULT NULL COMMENT '帖子ID',
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片URL',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '闲置物品关联的图片' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post_images
-- ----------------------------
INSERT INTO `post_images` VALUES (5, 2, 'http://www.129.com');
INSERT INTO `post_images` VALUES (6, 2, 'http://www.347.com');
INSERT INTO `post_images` VALUES (7, 1, 'http://www.129.com');
INSERT INTO `post_images` VALUES (8, 1, 'http://www.347.com');

-- ----------------------------
-- Table structure for post_videos
-- ----------------------------
DROP TABLE IF EXISTS `post_videos`;
CREATE TABLE `post_videos`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `post_id` bigint(20) NULL DEFAULT NULL COMMENT '帖子ID',
  `video_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频URL',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '闲置物品关联的视频' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post_videos
-- ----------------------------
INSERT INTO `post_videos` VALUES (5, 2, 'http://www.340.com');
INSERT INTO `post_videos` VALUES (6, 2, 'http://www.102.com');

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货/寄件人名称',
  `type` int(1) NULL DEFAULT 0 COMMENT '地址类型:0->收货,1->寄件,2->退货',
  `phone_number` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货/寄件人电话号码',
  `default_status` int(1) NULL DEFAULT 0 COMMENT '是否为默认地址(1->是,0->不是)',
  `post_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮政编码',
  `province` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份/直辖市',
  `city` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市',
  `region` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区',
  `detail_address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收货/寄件地址表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_address
-- ----------------------------
INSERT INTO `user_address` VALUES (5, 1, 'loklok', 0, '18022392683', 1, '510000', '广东省', '广州市', '越秀区', '文明路');
INSERT INTO `user_address` VALUES (6, 1, 'kalok', 1, '18022392683', 0, '510000', '广东省', '广州市', '越秀区', '文明路');
INSERT INTO `user_address` VALUES (7, 3, '冯家乐', 0, '18022392683', 1, '510000', '广东省', '广州市', '越秀区', '文明路');
INSERT INTO `user_address` VALUES (9, 3, '冯家乐', 1, '18022392683', 1, '510000', '广东省', '广州市', '越秀区', '文明路');
INSERT INTO `user_address` VALUES (10, 3, '冯家乐', 2, '18022392683', 1, '510000', '广东省', '广州市', '越秀区', '文明路');

-- ----------------------------
-- Table structure for user_browse_history
-- ----------------------------
DROP TABLE IF EXISTS `user_browse_history`;
CREATE TABLE `user_browse_history`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `relation_id` bigint(20) NULL DEFAULT NULL COMMENT '浏览记录相关的ID(闲置物品or帖子)',
  `browse_time` datetime NULL DEFAULT NULL COMMENT '浏览时间',
  `history_type` int(1) NULL DEFAULT NULL COMMENT '历史记录的类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '浏览记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_browse_history
-- ----------------------------
INSERT INTO `user_browse_history` VALUES (5, 6, '2023-03-31 21:48:41', 0);
INSERT INTO `user_browse_history` VALUES (6, 7, '2023-03-31 21:48:47', 0);
INSERT INTO `user_browse_history` VALUES (7, 8, '2023-04-01 21:48:49', 0);
INSERT INTO `user_browse_history` VALUES (8, 1, '2023-04-04 22:18:33', 0);

-- ----------------------------
-- Table structure for user_collect
-- ----------------------------
DROP TABLE IF EXISTS `user_collect`;
CREATE TABLE `user_collect`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `relation_id` bigint(20) NULL DEFAULT NULL COMMENT '相关的ID',
  `collect_type` int(1) NULL DEFAULT NULL COMMENT '收藏的类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户收藏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_collect
-- ----------------------------
INSERT INTO `user_collect` VALUES (5, 3, 1, 0);
INSERT INTO `user_collect` VALUES (6, 3, 6, 0);
INSERT INTO `user_collect` VALUES (7, 3, 7, 0);
INSERT INTO `user_collect` VALUES (8, 3, 8, 0);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `icon` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `gender` int(1) NULL DEFAULT 1 COMMENT '性别:男->1,女->0',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime NULL DEFAULT NULL COMMENT '登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'kalokfeng', '990909', '', 1, 'paulvon369@Outlook.com', 'loklok', '2023-03-04 19:37:01', '2023-04-01 22:44:22');
INSERT INTO `user_info` VALUES (3, '冯家乐', '123456', '', 1, '157981973@qq.com', '小冯', '2023-03-04 22:37:01', '2023-04-01 22:44:40');

-- ----------------------------
-- Table structure for user_social_relation
-- ----------------------------
DROP TABLE IF EXISTS `user_social_relation`;
CREATE TABLE `user_social_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `another_user_id` bigint(20) NULL DEFAULT NULL COMMENT '另一ID',
  `relation_type` int(1) NULL DEFAULT 0 COMMENT '关系的类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '两个用户之间的关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_social_relation
-- ----------------------------
INSERT INTO `user_social_relation` VALUES (3, 3, 1, 0);
INSERT INTO `user_social_relation` VALUES (4, 1, 3, 1);

SET FOREIGN_KEY_CHECKS = 1;
