-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.15 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  10.1.0.5515
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 bookstore 的数据库结构
CREATE DATABASE IF NOT EXISTS `bookstore` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bookstore`;

-- 导出  表 bookstore. shoppingcart 结构
CREATE TABLE IF NOT EXISTS ` shoppingcart` (
  `cart_id` bigint(111) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(111) NOT NULL,
  `book_id` bigint(111) NOT NULL,
  `count` bigint(111) NOT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  bookstore. shoppingcart 的数据：~0 rows (大约)
/*!40000 ALTER TABLE ` shoppingcart` DISABLE KEYS */;
/*!40000 ALTER TABLE ` shoppingcart` ENABLE KEYS */;

-- 导出  表 bookstore.address 结构
CREATE TABLE IF NOT EXISTS `address` (
  `address_id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '地址Id',
  `user_id` bigint(255) NOT NULL COMMENT '用户Id',
  `content` varchar(50) NOT NULL COMMENT '详细地址',
  `area` varchar(50) NOT NULL COMMENT '区域',
  `postcode` int(11) NOT NULL COMMENT '邮编',
  `default_address` char(1) NOT NULL DEFAULT 'F' COMMENT '是否为默认地址',
  `phone` int(11) NOT NULL COMMENT '手机号',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  bookstore.address 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;

-- 导出  表 bookstore.administrator 结构
CREATE TABLE IF NOT EXISTS `administrator` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '管理员Id',
  `login_name` varchar(50) NOT NULL COMMENT '登陆账号',
  `password` varchar(50) NOT NULL COMMENT '登录密码',
  `name` varchar(50) NOT NULL COMMENT '真实姓名',
  `identity_card` varchar(18) NOT NULL COMMENT '身份证号',
  `phone` int(11) NOT NULL COMMENT '联系电话',
  `department` varchar(50) NOT NULL COMMENT '所属部门',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  bookstore.administrator 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;

-- 导出  表 bookstore.book 结构
CREATE TABLE IF NOT EXISTS `book` (
  `book_id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '书籍Id',
  `book_name` varchar(100) NOT NULL COMMENT '书名',
  `book_price` decimal(20,2) NOT NULL COMMENT '单价',
  `author` varchar(100) NOT NULL COMMENT '作者',
  `publishing` varchar(100) NOT NULL COMMENT '出版社',
  `sell_store` varchar(100) NOT NULL COMMENT '卖家店铺',
  `sales` bigint(255) NOT NULL COMMENT '销量',
  `publication_date` date NOT NULL COMMENT '出版日期',
  `count` int(11) NOT NULL COMMENT '余量',
  `score` decimal(1,1) NOT NULL COMMENT '评分',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  bookstore.book 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
/*!40000 ALTER TABLE `book` ENABLE KEYS */;

-- 导出  表 bookstore.bookmark 结构
CREATE TABLE IF NOT EXISTS `bookmark` (
  `mark_id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '收藏Id',
  `user_id` bigint(255) NOT NULL COMMENT '用户Id',
  `book_id` bigint(255) NOT NULL COMMENT '书籍Id',
  `mark_date` timestamp NOT NULL COMMENT '收藏日期',
  PRIMARY KEY (`mark_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  bookstore.bookmark 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `bookmark` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookmark` ENABLE KEYS */;

-- 导出  表 bookstore.categories 结构
CREATE TABLE IF NOT EXISTS `categories` (
  `categories_id` bigint(111) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `one_categories` varchar(50) NOT NULL COMMENT '一级分类名',
  `two_categories` varchar(50) NOT NULL COMMENT '二级分类名',
  `book_id` varchar(50) NOT NULL COMMENT '书的Id',
  PRIMARY KEY (`categories_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  bookstore.categories 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;

-- 导出  表 bookstore.comment 结构
CREATE TABLE IF NOT EXISTS `comment` (
  ` comment_id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '评论Id',
  `user_id` bigint(255) NOT NULL COMMENT '用户Id',
  `book_id` bigint(255) NOT NULL COMMENT '书籍Id',
  `order_id` bigint(255) NOT NULL COMMENT '订单Id',
  `content` varchar(255) NOT NULL COMMENT '评论内容',
  `comment_date` timestamp NOT NULL COMMENT '评论日期',
  `level` int(1) NOT NULL DEFAULT '0' COMMENT '评论级别（0：好评，1：中评，2：差评，3：卖家回复）',
  PRIMARY KEY (` comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  bookstore.comment 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;

-- 导出  表 bookstore.news 结构
CREATE TABLE IF NOT EXISTS `news` (
  `news_id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '新闻Id',
  `news_content` varchar(255) NOT NULL COMMENT '新闻内容',
  `news_date` timestamp NOT NULL COMMENT '新闻日期',
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  bookstore.news 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
/*!40000 ALTER TABLE `news` ENABLE KEYS */;

-- 导出  表 bookstore.order 结构
CREATE TABLE IF NOT EXISTS `order` (
  `order_id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '订单Id',
  `order_date` timestamp NOT NULL COMMENT '下单日期',
  `order_price` decimal(20,2) NOT NULL COMMENT '订单价格',
  `order_content` varchar(255) NOT NULL COMMENT '订单商品',
  `order_count` int(100) NOT NULL COMMENT '订单数量',
  `user_id` bigint(255) NOT NULL COMMENT '下单用户Id',
  `user_address` varchar(255) NOT NULL COMMENT '用户地址',
  `state` varchar(50) NOT NULL COMMENT '订单状态',
  `store_id` bigint(111) NOT NULL COMMENT '店铺Id',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  bookstore.order 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;

-- 导出  表 bookstore.picture 结构
CREATE TABLE IF NOT EXISTS `picture` (
  `picture_id` int(111) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `picture_content` varchar(50) NOT NULL COMMENT '图片内容（地址）',
  `book_id` varchar(50) NOT NULL COMMENT '书的Id',
  PRIMARY KEY (`picture_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  bookstore.picture 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;

-- 导出  表 bookstore.store 结构
CREATE TABLE IF NOT EXISTS `store` (
  `store_id` int(100) NOT NULL AUTO_INCREMENT COMMENT '店铺Id',
  `store_name` varchar(255) NOT NULL COMMENT '店铺名',
  `store_address` varchar(255) NOT NULL COMMENT '开店区域',
  `store_level` varchar(255) NOT NULL COMMENT '普通，黄金，砖石，皇冠等',
  `store_age` varchar(50) NOT NULL COMMENT '开店时长',
  `store_score` decimal(1,1) NOT NULL COMMENT '店铺评分',
  `totle_sales` bigint(255) NOT NULL COMMENT '总销量',
  `state` char(1) NOT NULL DEFAULT '1' COMMENT '0：正常。1：审核中。2：冻结',
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  bookstore.store 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
/*!40000 ALTER TABLE `store` ENABLE KEYS */;

-- 导出  表 bookstore.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `phone` int(11) NOT NULL COMMENT '手机',
  `sex` char(1) NOT NULL DEFAULT 'M' COMMENT '性别M/F',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `identity_card` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `state` char(1) NOT NULL DEFAULT '0' COMMENT '0：正常。1：审核中。2：冻结',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  bookstore.user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- 导出  表 bookstore.verification 结构
CREATE TABLE IF NOT EXISTS `verification` (
  `verification_id` int(11) NOT NULL AUTO_INCREMENT,
  `verification_content` int(6) NOT NULL,
  `user_id` int(6) NOT NULL,
  `date` timestamp NOT NULL,
  PRIMARY KEY (`verification_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  bookstore.verification 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `verification` DISABLE KEYS */;
/*!40000 ALTER TABLE `verification` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
