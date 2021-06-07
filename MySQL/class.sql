-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: classmanagers
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assignment`
--

DROP TABLE IF EXISTS `assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignment` (
  `assignmentid` varchar(16) NOT NULL,
  `assignmentname` varchar(16) DEFAULT NULL,
  `deadline` varchar(32) DEFAULT NULL,
  `explain` varchar(64) DEFAULT NULL,
  `classid` varchar(16) DEFAULT NULL,
  `userupid` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`assignmentid`),
  UNIQUE KEY `assignment_assignmentid_uindex` (`assignmentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignment`
--

LOCK TABLES `assignment` WRITE;
/*!40000 ALTER TABLE `assignment` DISABLE KEYS */;
INSERT INTO `assignment` VALUES ('3344','fragment使用','2021-6-5','好好学习fragment','123456','459799');
/*!40000 ALTER TABLE `assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `classid` varchar(16) NOT NULL,
  `classname` varchar(16) DEFAULT NULL,
  `classtime` varchar(32) DEFAULT NULL,
  `manager` varchar(8) DEFAULT NULL,
  `assignment` varchar(255) DEFAULT NULL,
  `members` varchar(255) DEFAULT NULL,
  `teachtype` varchar(4) DEFAULT NULL,
  `classexplain` varchar(255) DEFAULT NULL,
  `studytime` varchar(8) DEFAULT NULL,
  `teachplace` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`classid`),
  UNIQUE KEY `class_classid_uindex` (`classid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES ('123456','线性代数','2019-2020第二学期','郭珊珊','1、矩阵的定义,2、P112页课后习题1-5,3、P133页课后习题5-8',NULL,NULL,NULL,NULL,NULL),('459799','职业生涯与规划','2021-2022第一学期','姜扬','1、上台自我介绍,2、写简历,3、模拟面试课体会,4、简历撰写小技巧总结',NULL,NULL,NULL,NULL,NULL),('654321','面对对象程序与设计','2019-2020第一学期','龚伟','1、音乐播放器制作,2、简单图片浏览器,3、Linux环境安装,5、Qt+Felgo程序设计',NULL,NULL,NULL,NULL,NULL),('97459','Android移动手机端开发','2021-2022第二学期','朱德利','1、Fragment使用,2、Adpter使用,3、百纳音乐播放器演讲,4、异步类下载图片,5、Activity页面传值,6、用户注册案例撰写',NULL,NULL,NULL,NULL,NULL),('YYZYQ','软件体系结构理论及应用','2020-2021第一学期','徐传运','1、简单工厂方法,2、工厂方法模式,3、命令模式,4、享元模式,5、代理模式',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mywork`
--

DROP TABLE IF EXISTS `mywork`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mywork` (
  `userid` varchar(16) NOT NULL,
  `classnum` varchar(16) DEFAULT NULL,
  `finish` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `mywork_userid_uindex` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mywork`
--

LOCK TABLES `mywork` WRITE;
/*!40000 ALTER TABLE `mywork` DISABLE KEYS */;
/*!40000 ALTER TABLE `mywork` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `username` varchar(8) DEFAULT NULL,
  `number` varchar(16) DEFAULT NULL,
  `school` varchar(16) DEFAULT NULL,
  `court` varchar(16) DEFAULT NULL,
  `speciality` varchar(16) DEFAULT NULL,
  `myclasses` varchar(255) DEFAULT NULL,
  `grade` varchar(16) DEFAULT NULL,
  `ktpnum` varchar(16) DEFAULT NULL,
  `role` varchar(5) DEFAULT NULL,
  `phone` varchar(16) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `wechat` varchar(16) DEFAULT NULL,
  `vip` varchar(4) DEFAULT NULL,
  `admission` varchar(32) DEFAULT NULL,
  `userface` varchar(255) DEFAULT NULL,
  `classnum` varchar(255) DEFAULT NULL,
  `myteach` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('459799','YYZYQ','杨强','2018051604087','重庆师范大学','计算机与信息科学学院','软件工程','3班','1年级','ktp97459799','老师','15922813245','2845290850@qq.com','15922813245','0','2021-06-30','http://192.168.106.130/group1/M00/00/00/wKhqgmCg0xqAK_04AANTyCD5QMI409.jpg','123456,97459,459799','');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-07 16:44:09
