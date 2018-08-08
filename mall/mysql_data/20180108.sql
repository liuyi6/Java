-- MySQL dump 10.13  Distrib 5.7.13, for Win64 (x86_64)
--
-- Host: localhost    Database: mall
-- ------------------------------------------------------
-- Server version	5.7.13-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_admin`
--

DROP TABLE IF EXISTS `tb_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_admin` (
  `admin_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `password` varchar(1024) NOT NULL,
  `enable_status` int(2) DEFAULT '1' COMMENT '1代表允许使用商城，0代表禁止使用商城',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `admin_name_unique` (`name`) COMMENT '用户名必须唯一'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_admin`
--

LOCK TABLES `tb_admin` WRITE;
/*!40000 ALTER TABLE `tb_admin` DISABLE KEYS */;
INSERT INTO `tb_admin` VALUES (1,'xiaolinzi','123456',1,NULL,NULL);
/*!40000 ALTER TABLE `tb_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_advertisement_product`
--

DROP TABLE IF EXISTS `tb_advertisement_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_advertisement_product` (
  `advertisement_product_id` int(10) NOT NULL AUTO_INCREMENT,
  `product_id` int(10) NOT NULL,
  `image_url` varchar(1024) NOT NULL COMMENT '产品图片',
  `product_url` varchar(1024) DEFAULT NULL COMMENT '用户访问产品的URL',
  `enable_status` int(2) DEFAULT '0' COMMENT '0代表审核，1代表同意申请，-1代表拒绝',
  `price` decimal(20,2) NOT NULL COMMENT '申请店铺所出的价格',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `shop_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`advertisement_product_id`),
  KEY `fk_cart_product` (`product_id`),
  CONSTRAINT `fk_cart_product` FOREIGN KEY (`product_id`) REFERENCES `tb_product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_advertisement_product`
--

LOCK TABLES `tb_advertisement_product` WRITE;
/*!40000 ALTER TABLE `tb_advertisement_product` DISABLE KEYS */;
INSERT INTO `tb_advertisement_product` VALUES (8,13,'/upload/f86d045ef90a4e9f8912975cabfea3a6.jpeg','/prourl.do',1,800.00,'2018-01-07 21:54:32',NULL,'ff',2),(9,23,'/upload/b51925fa37d845c8a69164467e945b78.jpeg','/prourl.do',1,12344.00,'2018-01-07 15:52:19',NULL,'haha3',15),(10,12,'/upload/54461f88de0c4c2a99a1b93d8df1c23b.jpeg','/prourl.do',-1,5555.00,'2018-01-07 19:17:19',NULL,'1',2);
/*!40000 ALTER TABLE `tb_advertisement_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_advertisement_shop`
--

DROP TABLE IF EXISTS `tb_advertisement_shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_advertisement_shop` (
  `advertisement_shop_id` int(10) NOT NULL AUTO_INCREMENT,
  `shop_id` int(10) NOT NULL,
  `head_url` varchar(1024) NOT NULL COMMENT '店铺头像',
  `shop_url` varchar(1024) DEFAULT NULL COMMENT '用户访问店铺的URL',
  `enable_status` int(2) DEFAULT '0' COMMENT '0代表审核，1代表同意申请，-1代表拒绝',
  `price` decimal(20,2) NOT NULL COMMENT '店铺所出的价格',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  `shop_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`advertisement_shop_id`),
  KEY `fk_advertisement_shop` (`shop_id`),
  CONSTRAINT `fk_advertisement_shop` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_advertisement_shop`
--

LOCK TABLES `tb_advertisement_shop` WRITE;
/*!40000 ALTER TABLE `tb_advertisement_shop` DISABLE KEYS */;
INSERT INTO `tb_advertisement_shop` VALUES (11,2,'/upload/e50a13ba2b2b486aaa1cfcd5f0c57956.jpeg','/shopurl.do',1,100.00,'2018-01-07 21:53:34',NULL,'Tom'),(12,13,'/upload/72f79bc1b8a54b94bc8340d8d819efad.jpeg','/shopurl.do',1,1231.00,'2018-01-07 16:23:19',NULL,'ewrq'),(13,15,'/upload/873fad99112d446bbb224e711f864894.jpeg','/shopurl.do',-1,123455.00,'2017-12-30 15:51:44',NULL,'haha'),(14,2,'/upload/af2d9a7913ba49899bb2544f9cdc46d7.jpeg','/shopurl.do',-1,10000.00,'2018-01-07 19:17:00',NULL,'haha'),(15,2,'/upload/7ac5c4a12cc743a587d982c6b5c1793b.jpeg','/shopurl.do',1,10000.00,'2018-01-08 15:51:39',NULL,'jingdong');
/*!40000 ALTER TABLE `tb_advertisement_shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cart`
--

DROP TABLE IF EXISTS `tb_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_cart` (
  `cart_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `product_id` int(10) NOT NULL,
  `product_amount` int(10) NOT NULL COMMENT '商品数量',
  `product_price` decimal(20,2) NOT NULL,
  `checked` int(2) DEFAULT '0' COMMENT '是否勾选，1代表已勾选，0代表未勾选',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cart`
--

LOCK TABLES `tb_cart` WRITE;
/*!40000 ALTER TABLE `tb_cart` DISABLE KEYS */;
INSERT INTO `tb_cart` VALUES (14,2,3,1,3456.00,0,'2017-12-25 21:30:13','2017-12-25 21:30:13'),(15,2,3,1,3456.00,0,'2017-12-25 21:43:29','2017-12-25 21:43:29'),(16,3,3,1,3456.00,0,'2018-01-07 16:07:59','2018-01-07 16:07:59'),(17,2,5,1,22222.00,0,'2018-01-07 16:17:03','2018-01-07 16:17:03'),(18,4,3,1,3456.00,0,'2018-01-08 13:35:31','2018-01-08 13:35:31'),(19,4,3,1,3456.00,0,'2018-01-08 13:35:47','2018-01-08 13:35:47');
/*!40000 ALTER TABLE `tb_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_collect`
--

DROP TABLE IF EXISTS `tb_collect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_collect` (
  `collect_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `shop_id` int(10) NOT NULL,
  `shop_name` varchar(100) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`collect_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_collect`
--

LOCK TABLES `tb_collect` WRITE;
/*!40000 ALTER TABLE `tb_collect` DISABLE KEYS */;
INSERT INTO `tb_collect` VALUES (1,2,2,'jingdong','2018-01-08 14:13:22','2018-01-08 14:13:22');
/*!40000 ALTER TABLE `tb_collect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_comment`
--

DROP TABLE IF EXISTS `tb_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_comment` (
  `comment_id` int(10) NOT NULL AUTO_INCREMENT,
  `comment_content` text NOT NULL,
  `user_id` int(10) NOT NULL,
  `order_product_id` int(10) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_comment`
--

LOCK TABLES `tb_comment` WRITE;
/*!40000 ALTER TABLE `tb_comment` DISABLE KEYS */;
INSERT INTO `tb_comment` VALUES (1,'good!',2,2,'2017-12-25 19:56:06','2017-12-25 19:56:06'),(2,'fghfghfgh',2,3,'2017-12-25 19:57:01','2017-12-25 19:57:01'),(3,'ddfsdfds',2,4,'2017-12-25 21:29:14','2017-12-25 21:29:14'),(4,'123',2,7,'2017-12-25 21:44:28','2017-12-25 21:44:28');
/*!40000 ALTER TABLE `tb_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_customer`
--

DROP TABLE IF EXISTS `tb_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_customer` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL,
  `password` varchar(1024) NOT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `address` varchar(1024) DEFAULT NULL,
  `enable_status` int(2) DEFAULT '1' COMMENT '1代表允许使用商城，0代表禁止使用商城',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name_unique` (`user_name`) COMMENT '用户名必须唯一'
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_customer`
--

LOCK TABLES `tb_customer` WRITE;
/*!40000 ALTER TABLE `tb_customer` DISABLE KEYS */;
INSERT INTO `tb_customer` VALUES (1,'xx2','xx','111','1111',0,'2017-12-17 17:27:10',NULL),(2,'haha','123a','1','1',1,'2017-12-25 14:33:11','2017-12-25 14:33:11'),(3,'shazi','123a','10086','china',1,'2018-01-07 15:51:00','2018-01-07 15:51:00'),(4,'cc','123a','1233','11222',1,'2018-01-08 13:33:25','2018-01-08 13:33:25'),(10,'cc1','123a','15091288215','11222',1,'2018-01-08 13:35:03','2018-01-08 13:35:03');
/*!40000 ALTER TABLE `tb_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_order_detail`
--

DROP TABLE IF EXISTS `tb_order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_order_detail` (
  `order_detail_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL COMMENT '买家id',
  `user_name` varchar(100) NOT NULL,
  `user_phone` varchar(100) NOT NULL,
  `user_address` varchar(100) NOT NULL,
  `all_amount` int(10) DEFAULT NULL COMMENT '商品总数量',
  `all_price` decimal(20,2) DEFAULT NULL COMMENT '商品总价格',
  `enable_status` int(2) NOT NULL DEFAULT '1' COMMENT '0代表已取消，1代表已支付，2代表未发货，3代表已发货，4代表已签收',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  `return_status` int(2) DEFAULT '0' COMMENT '默认为0，表示不用退货，1表示提出退货申请，2表示退货申请成功，-1表示退货申请失败',
  `return_reason` varchar(1024) DEFAULT NULL COMMENT '退货理由',
  PRIMARY KEY (`order_detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_order_detail`
--

LOCK TABLES `tb_order_detail` WRITE;
/*!40000 ALTER TABLE `tb_order_detail` DISABLE KEYS */;
INSERT INTO `tb_order_detail` VALUES (1,2,'haha','12','1',1,1.00,4,'2017-12-25 19:46:06','2017-12-25 19:46:09',1,'fake '),(2,2,'haha','1','1',1,3456.00,4,'2017-12-25 19:47:55','2017-12-25 19:47:55',-1,'fake'),(3,2,'haha','1','1',1,1.00,4,'2017-12-25 19:50:09','2017-12-25 19:50:09',2,'haha'),(4,2,'haha','1','1',1,111.00,4,'2017-12-25 19:50:40','2017-12-25 19:50:40',1,'dislike'),(5,2,'haha','1','1',1,311.00,0,'2017-12-25 19:50:40','2017-12-25 19:50:40',0,NULL),(6,2,'haha','1','1',1,1.00,2,'2017-12-25 19:50:40','2017-12-25 19:50:40',0,NULL),(7,2,'haha','1','1',1,111.00,4,'2017-12-25 19:52:07','2017-12-25 19:52:07',0,NULL),(8,2,'haha','1','1',1,123.00,3,'2017-12-25 20:51:07','2017-12-25 20:51:07',0,NULL),(9,2,'haha','1','1',1,1.00,1,'2017-12-25 21:05:30','2017-12-25 21:05:30',0,NULL),(10,2,'haha','1','1',1,1.00,1,'2017-12-25 21:28:30','2017-12-25 21:28:30',0,NULL),(11,2,'haha','1','1',1,3456.00,1,'2017-12-25 21:30:22','2017-12-25 21:30:22',0,NULL),(12,2,'haha','1','1',1,123.00,1,'2017-12-25 21:43:48','2017-12-25 21:43:48',0,NULL),(13,2,'haha','1','1',1,111.00,1,'2018-01-07 16:18:24','2018-01-07 16:18:24',-1,NULL),(14,2,'haha','1','1',1,3456.00,1,'2018-01-08 12:52:16','2018-01-08 12:52:16',0,NULL),(15,4,'cc','1233','11222',1,3456.00,1,'2018-01-08 13:35:57','2018-01-08 13:35:57',2,'fake'),(16,2,'haha','1','1',1,3456.00,1,'2018-01-08 14:14:14','2018-01-08 14:14:14',0,NULL);
/*!40000 ALTER TABLE `tb_order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_order_product`
--

DROP TABLE IF EXISTS `tb_order_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_order_product` (
  `order_product_id` int(10) NOT NULL AUTO_INCREMENT,
  `order_detail_id` int(10) NOT NULL,
  `product_id` int(10) NOT NULL,
  `shop_id` int(10) NOT NULL COMMENT '卖家id',
  `shop_name` varchar(100) NOT NULL,
  `product_amount` int(10) NOT NULL COMMENT '商品数量',
  `product_price` decimal(20,2) NOT NULL,
  `all_price` decimal(20,2) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`order_product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_order_product`
--

LOCK TABLES `tb_order_product` WRITE;
/*!40000 ALTER TABLE `tb_order_product` DISABLE KEYS */;
INSERT INTO `tb_order_product` VALUES (1,1,1,1,'cc',1,20.00,20.00,'2017-12-25 19:46:40','2017-12-25 19:46:42'),(2,2,3,2,'jingdong',1,3456.00,3456.00,'2017-12-25 19:47:56','2017-12-25 19:47:56'),(3,3,4,2,'jingdong',1,1.00,1.00,'2017-12-25 19:50:10','2017-12-25 19:50:10'),(4,4,6,2,'jingdong',1,111.00,111.00,'2017-12-25 19:50:40','2017-12-25 19:50:40'),(5,5,8,2,'jingdong',1,311.00,311.00,'2017-12-25 19:50:40','2017-12-25 19:50:40'),(6,6,4,2,'jingdong',1,1.00,1.00,'2017-12-25 19:50:41','2017-12-25 19:50:41'),(7,7,6,2,'jingdong',1,111.00,111.00,'2017-12-25 19:52:07','2017-12-25 19:52:07'),(8,8,7,2,'jingdong',1,123.00,123.00,'2017-12-25 20:51:07','2017-12-25 20:51:07'),(9,9,4,2,'jingdong',1,1.00,1.00,'2017-12-25 21:05:30','2017-12-25 21:05:30'),(10,10,4,2,'jingdong',1,1.00,1.00,'2017-12-25 21:28:30','2017-12-25 21:28:30'),(11,11,3,2,'jingdong',1,3456.00,3456.00,'2017-12-25 21:30:22','2017-12-25 21:30:22'),(12,12,7,2,'jingdong',1,123.00,123.00,'2017-12-25 21:43:48','2017-12-25 21:43:48'),(13,13,6,15,'1234tt',1,111.00,111.00,'2018-01-07 16:18:24','2018-01-07 16:18:24'),(14,14,3,3,'ee',1,3456.00,3456.00,'2018-01-08 12:52:16','2018-01-08 12:52:16'),(15,15,3,3,'ee',1,3456.00,3456.00,'2018-01-08 13:35:57','2018-01-08 13:35:57'),(16,16,3,16,'jingxi',1,3456.00,3456.00,'2018-01-08 14:14:14','2018-01-08 14:14:14');
/*!40000 ALTER TABLE `tb_order_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_product`
--

DROP TABLE IF EXISTS `tb_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_product` (
  `product_id` int(10) NOT NULL AUTO_INCREMENT,
  `shop_id` int(10) NOT NULL COMMENT '商品属于哪个店铺',
  `product_name` varchar(100) NOT NULL,
  `product_desc` varchar(1024) DEFAULT NULL COMMENT '商品描述',
  `shop_category_name` varchar(100) DEFAULT NULL,
  `product_price` decimal(20,2) NOT NULL,
  `product_count` int(10) NOT NULL COMMENT '商品库存',
  `img_addr` varchar(1024) NOT NULL,
  `comment_num` int(10) DEFAULT '0' COMMENT '评论数量',
  `purchase_num` int(10) DEFAULT '0' COMMENT '购买数量',
  `enable_status` int(2) DEFAULT '1' COMMENT '1代表允许商品上架，0代笔商品已下架',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_product`
--

LOCK TABLES `tb_product` WRITE;
/*!40000 ALTER TABLE `tb_product` DISABLE KEYS */;
INSERT INTO `tb_product` VALUES (1,1,'cc','gg','gg',7777.00,77,'/upload/fa0e30927e95429a9d25e7df0880ac1d.jpeg',0,0,1,'2017-12-21 19:19:07','2017-12-21 19:19:10'),(2,1,'cc','ff','ff',444.00,44,'/upload/fa0e30927e95429a9d25e7df0880ac1d.jpeg',0,0,1,'2017-12-21 19:19:45','2017-12-21 19:19:48'),(3,9,'11',NULL,'ddd',3456.00,333,'/upload/c32530f66d1a49d686156bf820cc8713.jpeg',0,0,1,NULL,NULL),(4,10,'1',NULL,'1',1.00,1,'/upload/fa0e30927e95429a9d25e7df0880ac1d.jpeg',0,0,1,NULL,NULL),(5,10,'22',NULL,'222',22222.00,22,'/upload/85d5e3a7313d4b64b60ed89c3852841a.jpeg',0,0,1,NULL,NULL),(6,10,'223',NULL,'1',111.00,11,'/upload/d6b3a6cd844146c0809eae07baa3ca1b.jpeg',0,0,1,NULL,NULL),(7,10,'34',NULL,'2',123.00,111,'/upload/c39f9b4f76b64d07a7717fb153fa3091.jpeg',0,0,1,NULL,NULL),(8,10,'3367',NULL,'111',311.00,234,'/upload/9418632ac6b94350bcf0b3c6531e8f56.jpeg',0,0,1,NULL,NULL),(10,10,'haha','gssfdgfddgdgd','phone',3456.00,1234,'/upload/ee487f411b054c09897aa8d018954f11.jpeg',0,0,1,NULL,NULL),(12,2,'1',NULL,'1',1.00,1,'/upload/54461f88de0c4c2a99a1b93d8df1c23b.jpeg',0,0,1,NULL,NULL),(13,2,'ff',NULL,'22',2222.00,123,'/upload/f86d045ef90a4e9f8912975cabfea3a6.jpeg',0,0,1,NULL,NULL),(14,14,'hah',NULL,'hh',333.00,444,'/upload/aec758a0fcc243deb26b3167f0d046e5.jpeg',0,0,1,NULL,NULL),(15,14,'tr',NULL,'1g',11.00,333,'/upload/4722e21fd89b4abd8e338683019e53c9.jpeg',0,0,1,NULL,NULL),(16,14,'t2',NULL,'2',22.00,22,'/upload/aee91e0d557840dcb489e483235d2c8d.jpeg',0,0,1,NULL,NULL),(17,14,'32',NULL,'222',222.00,2,'/upload/b9f1eb1e77ad4b5ea80c24140784cae0.jpeg',0,0,1,NULL,NULL),(20,13,'haha',NULL,'33',123.00,3333,'/upload/5f1a36b17e594bc8bcf88b3e471352c5.jpeg',0,0,1,NULL,NULL),(21,13,'fds',NULL,'11',121.00,11,'/upload/7bd0e4165ae1442ea061b9d0ae10f9b3.jpeg',0,0,1,NULL,NULL),(22,13,'fds',NULL,'11',121.00,11,'/upload/632e0f76f59e49fd93cba517081316ad.jpeg',0,0,1,NULL,NULL),(23,15,'haha3',NULL,'444',1234.00,4432,'/upload/b51925fa37d845c8a69164467e945b78.jpeg',0,0,1,NULL,NULL),(24,15,'zz',NULL,'332',1234.00,444444,'/upload/810f33aa3c3e4c9ebaa9dd709cda7434.jpeg',0,0,1,NULL,NULL),(25,16,'food','hhhh','333',2000.00,10,'/upload/0653f489790f40649c8fdc653bcfbf66.jpeg',0,0,1,NULL,NULL);
/*!40000 ALTER TABLE `tb_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_product_img`
--

DROP TABLE IF EXISTS `tb_product_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_product_img` (
  `product_img_id` int(10) NOT NULL AUTO_INCREMENT,
  `img_addr` varchar(1024) NOT NULL,
  `img_desc` varchar(1024) NOT NULL,
  `product_id` int(10) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`product_img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_product_img`
--

LOCK TABLES `tb_product_img` WRITE;
/*!40000 ALTER TABLE `tb_product_img` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_product_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_shop`
--

DROP TABLE IF EXISTS `tb_shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_shop` (
  `shop_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL COMMENT '卖家名字',
  `password` varchar(100) NOT NULL,
  `shop_name` varchar(100) NOT NULL COMMENT '商铺名字',
  `shop_address` varchar(100) NOT NULL,
  `shop_phone` varchar(100) NOT NULL,
  `shop_email` varchar(100) NOT NULL,
  `enable_status` int(2) DEFAULT '0' COMMENT '0代表审核中，1代表允许经营，-1代表停止经营',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`shop_id`),
  UNIQUE KEY `uk_shop_name` (`shop_name`) COMMENT '店铺的名字是唯一的',
  UNIQUE KEY `uk_user_name` (`user_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_shop`
--

LOCK TABLES `tb_shop` WRITE;
/*!40000 ALTER TABLE `tb_shop` DISABLE KEYS */;
INSERT INTO `tb_shop` VALUES (2,'xxx','1234','jingdong','dddd','11111','222222',1,'2017-12-17 17:05:33','2017-12-17 17:05:14'),(3,'44','ee','ee','dd','d','ff',1,'2017-12-17 17:07:07',NULL),(4,'x3','ee','ee1','dd','d','ff',1,'2017-12-17 17:07:07',NULL),(5,'x5','ee','ee2','dd','d','ff',1,'2017-12-17 17:07:07',NULL),(6,'x6','ee','ee3','dd','d','ff',1,'2017-12-17 17:07:07',NULL),(7,'x7','ee','ee4','dd','d','ff',1,'2017-12-17 17:07:07',NULL),(8,'x8','ee','xx1','33','3','33',1,NULL,NULL),(9,'123','123','kun','kun','111','111',1,NULL,NULL),(10,'1','1','1','1','1','1',1,NULL,NULL),(11,'12','12','12','12','12','12',1,NULL,NULL),(12,'13','13','13','13','13','13',1,NULL,NULL),(13,'kuner','123','taobao','11','111','11',1,NULL,NULL),(14,'Eul','111','111','111','1111','111',1,NULL,NULL),(15,'haha','123','1234tt','11','11','1',-1,NULL,NULL),(16,'ps','123','jingxi','aaa','139888888','pens@163.com',1,NULL,NULL);
/*!40000 ALTER TABLE `tb_shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_shop_category`
--

DROP TABLE IF EXISTS `tb_shop_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_shop_category` (
  `shop_category_id` int(10) NOT NULL AUTO_INCREMENT,
  `shop_category_name` varchar(100) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`shop_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_shop_category`
--

LOCK TABLES `tb_shop_category` WRITE;
/*!40000 ALTER TABLE `tb_shop_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_shop_category` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-08 16:10:15
