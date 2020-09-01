-- MySQL dump 10.13  Distrib 5.7.29, for Win64 (x86_64)
--
-- Host: localhost    Database: king
-- ------------------------------------------------------
-- Server version	5.7.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `id` varchar(45) NOT NULL COMMENT 'id',
  `name` varchar(45) NOT NULL COMMENT '菜单或权限名',
  `pid` varchar(45) NOT NULL DEFAULT '' COMMENT '父菜单id',
  `href` varchar(1024) NOT NULL DEFAULT '' COMMENT '超链接',
  `remark` varchar(100) NOT NULL DEFAULT '' COMMENT '备注',
  `icon` varchar(45) NOT NULL DEFAULT 'fa fa-circle' COMMENT '图标',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序码',
  `target` varchar(45) NOT NULL DEFAULT '_self' COMMENT '打开方式 _self:当前页面打开;_blank:新窗口打开',
  `type` varchar(10) NOT NULL DEFAULT 'M' COMMENT '菜单类型 M:菜单;D:目录;B:按钮',
  `permission` varchar(45) NOT NULL DEFAULT '' COMMENT '权限',
  `createUserId` varchar(45) NOT NULL DEFAULT '' COMMENT '创建者id',
  `updateUserId` varchar(45) NOT NULL DEFAULT '' COMMENT '更新者id',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleteFlag` tinyint(2) NOT NULL DEFAULT '0' COMMENT '删除标识符',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统菜单和权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES ('1','系统设置','','','系统设置','',0,'_self','D','','','','2020-08-30 10:27:36','2020-08-30 17:55:58',0),('11','系统管理员','1','admin/system/user','系统管理员','fa fa-user',1,'_self','M','','','','2020-08-30 10:27:36','2020-08-30 17:56:44',0),('12','菜单管理','1','admin/system/menu/to/menu/mng','菜单管理','fa fa-folder-open',2,'_self','M','','','','2020-08-30 10:27:36','2020-08-30 17:56:44',0),('121','菜单添加','12','','菜单添加','',1,'_self','B','sys:menu:add','','','2020-08-30 10:27:36','2020-08-30 17:58:02',0),('13','角色管理','1','admin/system/role','角色管理','fa fa-group',3,'_self','M','sys:role:list','','','2020-08-30 10:27:36','2020-08-30 18:00:06',0),('14','代码生成','1','admin/system/generator','','fa fa-gears',4,'_self','M','','','','2020-08-30 17:56:35','2020-08-30 18:09:26',0),('2','数学社区','','','数专考研','',2,'_self','D','','','','2020-08-30 10:27:36','2020-08-30 18:02:45',0),('21','基础信息管理','2','','基础信息管理','fa fa-info',1,'_self','D','','','','2020-08-30 10:27:36','2020-08-30 17:57:14',0),('211','科目管理','21','','科目管理','fa fa-navicon',2,'_self','M','','','','2020-08-30 10:27:36','2020-08-30 17:57:14',0),('212','书籍管理','21','','书籍管理','fa fa-book',3,'_self','M','','','','2020-08-30 10:27:36','2020-08-30 17:57:14',0),('3','大学一条龙','','','大学一条龙','',2,'_self','D','','','','2020-08-30 17:50:01','2020-08-30 18:05:03',0),('4','防丢卡套','','','防丢卡套','',4,'_self','D','','','','2020-08-30 17:52:20','2020-08-30 18:05:03',0);
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` varchar(45) NOT NULL COMMENT 'id',
  `name` varchar(45) NOT NULL COMMENT '角色名',
  `createUserId` varchar(45) NOT NULL DEFAULT '' COMMENT '创建者id',
  `updateUserId` varchar(45) NOT NULL DEFAULT '' COMMENT '更新者id',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleteFlag` tinyint(2) NOT NULL DEFAULT '0' COMMENT '删除标识符',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES ('1','超级管理员','','','2020-08-30 10:31:40','2020-08-30 10:31:40',0),('2','数专考研管理员','','','2020-08-30 10:31:40','2020-08-30 10:32:31',0),('3','数专考研用户','','','2020-08-30 10:31:40','2020-08-30 10:32:31',0),('4','卡套用户','','','2020-08-30 10:31:40','2020-08-30 10:31:40',0),('5','毕设管理员','','','2020-08-30 10:31:40','2020-08-30 10:31:40',0),('6','毕设用户','','','2020-08-30 10:31:40','2020-08-30 10:31:40',0);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menu` (
  `roleId` varchar(45) NOT NULL COMMENT '角色id',
  `menuId` varchar(45) NOT NULL COMMENT '菜单id',
  `createUserId` varchar(45) NOT NULL DEFAULT '' COMMENT '创建者id',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`roleId`,`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统角色菜单关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` varchar(45) NOT NULL COMMENT 'id',
  `loginName` varchar(45) NOT NULL COMMENT '登录名',
  `realName` varchar(45) NOT NULL DEFAULT '' COMMENT '姓名',
  `passwordText` varchar(45) NOT NULL DEFAULT '' COMMENT '明文密码（仅为开发者测试用，不参与系统）',
  `passwordEncrypt` varchar(1024) NOT NULL DEFAULT '' COMMENT '密文密码',
  `salt` varchar(45) NOT NULL DEFAULT '' COMMENT '盐加密',
  `tel` varchar(45) NOT NULL DEFAULT '' COMMENT '电话',
  `birthday` varchar(45) NOT NULL DEFAULT '' COMMENT '出生日期',
  `gender` tinyint(2) NOT NULL DEFAULT '1' COMMENT '性别',
  `signature` varchar(1024) NOT NULL DEFAULT '' COMMENT '个性签名',
  `qq` varchar(45) NOT NULL DEFAULT '' COMMENT 'qq',
  `createUserId` varchar(45) NOT NULL DEFAULT '' COMMENT '创建者id',
  `updateUserId` varchar(45) NOT NULL DEFAULT '' COMMENT '更新者id',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleteFlag` tinyint(2) NOT NULL DEFAULT '0' COMMENT '删除标识符',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES ('5ce398b2-9b89-47e9-a17c-09f266fd0d47','admin','蔡金航','admin','957164817ba41c91b9061bbfe893e02f','75147','13188075476','1998-08-05',1,'不爱数学的coder不是好cuber','1904192877','5ce398b2-9b89-47e9-a17c-09f266fd0d47','5ce398b2-9b89-47e9-a17c-09f266fd0d47','2020-08-30 10:10:12','2020-08-30 10:40:50',0);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `userId` varchar(45) NOT NULL COMMENT '用户id',
  `roleId` varchar(45) NOT NULL COMMENT '角色id',
  `createUserId` varchar(45) NOT NULL DEFAULT '' COMMENT '创建者id',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`roleId`,`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统用户和角色关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES ('5ce398b2-9b89-47e9-a17c-09f266fd0d47','1','','2020-08-30 10:33:21');
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-01 10:01:25
