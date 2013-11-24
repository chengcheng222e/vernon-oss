/*
SQLyog Ultimate v9.20 
MySQL - 5.6.11 : Database - oss
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`oss` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `oss`;

/*Table structure for table `oss_group` */

DROP TABLE IF EXISTS `oss_group`;

CREATE TABLE `oss_group` (
  `group_id` int(3) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `group_name` varchar(50) NOT NULL COMMENT '组名',
  `hide` tinyint(1) NOT NULL COMMENT '是否隐藏',
  `read_only` tinyint(1) NOT NULL COMMENT '是否只读',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `oss_group` */

insert  into `oss_group`(`group_id`,`group_name`,`hide`,`read_only`,`remark`) values (1,'系统管理中心',0,0,'系统管理'),(2,'用户管理中心',0,0,'用户模块'),(3,'活动管理中心',0,0,'活动模块'),(4,'分享管理中心',0,0,'分享管理'),(5,'问答管理中心',0,0,'问答管理');

/*Table structure for table `oss_op` */

DROP TABLE IF EXISTS `oss_op`;

CREATE TABLE `oss_op` (
  `op_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间',
  `user_id` int(10) NOT NULL COMMENT '用户ID',
  `title` varchar(200) NOT NULL COMMENT '标题',
  `content` varchar(200) NOT NULL COMMENT '内容',
  `IP` varchar(100) NOT NULL COMMENT '电脑IP',
  `class_name` varchar(50) NOT NULL COMMENT '类名',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oss_op` */

insert  into `oss_op`(`op_time`,`user_id`,`title`,`content`,`IP`,`class_name`,`remark`) values ('2013-06-21 11:27:26',10000,'OSS-编辑角色','roleId:0,remark:asdfsafs','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 11:27:31',10000,'OSS-编辑角色','roleId:0,remark:asdfsafs','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 11:42:26',10000,'OSS-编辑角色','roleId:6,remark:asdfsafs','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 12:14:43',10000,'OSS-编辑角色','roleId:0,remark:12312313','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 12:48:12',10000,'OSS-编辑角色','roleId:7,remark:12312313','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 12:48:36',10000,'OSS-编辑角色','roleId:7,remark:12312313','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 12:49:41',10000,'OSS-编辑角色','roleId:7,remark:12312313','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 12:50:57',10000,'OSS-编辑角色','roleId:7,remark:12312313','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 12:51:13',10000,'OSS-编辑角色','roleId:7,remark:12312313','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 12:52:16',10000,'OSS-编辑角色','roleId:7,remark:12312313','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 12:52:40',10000,'OSS-编辑角色','roleId:7,remark:12312313','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 12:53:46',10000,'OSS-编辑角色','roleId:7,remark:奇葩啊奇葩啊奇葩啊','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 12:55:07',10000,'OSS-编辑角色','roleId:7,remark:奇葩啊奇葩啊奇葩啊','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 12:55:49',10000,'OSS-编辑角色','roleId:7,remark:奇葩啊奇葩啊奇葩啊','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 12:56:33',10000,'OSS-编辑角色','roleId:5,remark:asdfsafs','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 12:57:17',10000,'OSS-编辑角色','roleId:6,remark:asdfsafs','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 12:58:30',10000,'OSS-编辑角色','roleId:7,remark:奇葩啊奇葩啊奇葩啊','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 12:58:40',10000,'OSS-编辑角色','roleId:6,remark:asdfsafs','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 12:58:54',10000,'OSS-编辑角色','roleId:0,remark:1231321312321','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 13:25:58',10000,'OSS-编辑角色','roleId:8,remark:1231321312321','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 13:26:41',10000,'OSS-编辑角色','roleId:8,remark:1231321312321','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 13:27:46',10000,'OSS-编辑角色','roleId:8,remark:1231321312321','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 13:28:19',10000,'OSS-编辑角色','roleId:8,remark:1231321312321','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 13:28:35',10000,'OSS-编辑角色','roleId:8,remark:1231321312321','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 13:29:28',10000,'OSS-编辑角色','roleId:8,remark:1231321312321','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 13:31:57',10000,'OSS-删除角色','roleId:5','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 13:35:30',10000,'OSS-删除角色','roleId:8','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 13:40:28',10000,'OSS-删除角色','roleId:6','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 14:01:31',10000,'OSS-锁定角色','roleId:4','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 14:01:46',10000,'OSS-解锁角色','roleId:4','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 16:22:41',10000,'OSS-修改角色对应的权限','roleId:7','127.0.0.1','com.vernon.oss.web.action.RolePopedomAction',''),('2013-06-21 16:29:37',10000,'OSS-修改角色对应的权限','roleId:1','127.0.0.1','com.vernon.oss.web.action.RolePopedomAction',''),('2013-06-21 16:29:59',10000,'OSS-修改角色对应的权限','roleId:1','127.0.0.1','com.vernon.oss.web.action.RolePopedomAction',''),('2013-06-21 16:31:22',10000,'OSS-修改角色对应的权限','roleId:7','127.0.0.1','com.vernon.oss.web.action.RolePopedomAction',''),('2013-06-21 16:31:41',10000,'OSS-修改角色对应的权限','roleId:7','127.0.0.1','com.vernon.oss.web.action.RolePopedomAction',''),('2013-06-21 16:32:01',10000,'OSS-修改角色对应的权限','roleId:3','127.0.0.1','com.vernon.oss.web.action.RolePopedomAction',''),('2013-06-21 17:53:02',10000,'OSS-修改/增加权限','popedomId:3,popedomName:cccccc','127.0.0.1','com.vernon.oss.web.action.PopedomAction',''),('2013-06-21 17:53:38',10000,'OSS-修改/增加权限','popedomId:3,popedomName:cccccc','127.0.0.1','com.vernon.oss.web.action.PopedomAction',''),('2013-06-21 17:55:15',10000,'OSS-修改/增加权限','popedomId:3,popedomName:cccccc11','127.0.0.1','com.vernon.oss.web.action.PopedomAction',''),('2013-06-21 17:58:33',10000,'OSS-修改/增加权限','popedomId:11,popedomName:gggggggg','127.0.0.1','com.vernon.oss.web.action.PopedomAction',''),('2013-06-21 17:59:33',10000,'OSS-修改/增加权限','popedomId:1,popedomName:用户角色管理','127.0.0.1','com.vernon.oss.web.action.PopedomAction',''),('2013-06-21 18:00:35',10000,'OSS-修改/增加权限','popedomId:11,popedomName:后台用户管理','127.0.0.1','com.vernon.oss.web.action.PopedomAction',''),('2013-06-21 18:01:11',10000,'OSS-修改/增加权限','popedomId:3,popedomName:实名认证','127.0.0.1','com.vernon.oss.web.action.PopedomAction',''),('2013-06-21 18:01:47',10000,'OSS-修改/增加权限','popedomId:4,popedomName:黑名单','127.0.0.1','com.vernon.oss.web.action.PopedomAction',''),('2013-06-21 18:02:19',10000,'OSS-修改/增加权限','popedomId:5,popedomName:活动审核','127.0.0.1','com.vernon.oss.web.action.PopedomAction',''),('2013-06-21 18:03:14',10000,'OSS-修改/增加权限','popedomId:9,popedomName:问答查询','127.0.0.1','com.vernon.oss.web.action.PopedomAction',''),('2013-06-21 18:03:35',10000,'OSS-修改/增加权限','popedomId:10,popedomName:审核问题','127.0.0.1','com.vernon.oss.web.action.PopedomAction',''),('2013-06-21 18:04:06',10000,'OSS-修改/增加权限','popedomId:7,popedomName:分享列表','127.0.0.1','com.vernon.oss.web.action.PopedomAction',''),('2013-06-21 18:44:14',10000,'OSS-删除权限','popedomId:4,popedomName:null','127.0.0.1','com.vernon.oss.web.action.PopedomAction',''),('2013-06-21 18:53:54',10000,'OSS-删除权限','popedomId:10,popedomName:null','127.0.0.1','com.vernon.oss.web.action.PopedomAction',''),('2013-06-21 19:05:24',10000,'OSS-修改角色对应的权限','roleId:1','127.0.0.1','com.vernon.oss.web.action.RolePopedomAction',''),('2013-06-21 19:07:53',10000,'OSS-锁定角色','popedomId:2','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 19:08:45',10000,'OSS-锁定角色','popedomId:3','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 19:08:53',10000,'OSS-解锁权限','popedomId:3','127.0.0.1','com.vernon.oss.web.action.PopedomAction',''),('2013-06-21 19:09:28',10000,'OSS-修改/增加权限','popedomId:0,popedomName:问答检查','127.0.0.1','com.vernon.oss.web.action.PopedomAction',''),('2013-06-21 19:11:13',10000,'OSS-修改/增加权限','popedomId:0,popedomName:sadfsda','127.0.0.1','com.vernon.oss.web.action.PopedomAction',''),('2013-06-21 19:12:22',10000,'OSS-修改/增加权限','popedomId:0,popedomName:fsafsdafsdaff','127.0.0.1','com.vernon.oss.web.action.PopedomAction',''),('2013-06-21 19:18:24',10000,'OSS-锁定角色','popedomId:11','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 19:18:49',10000,'OSS-解锁权限','popedomId:11','127.0.0.1','com.vernon.oss.web.action.PopedomAction',''),('2013-06-21 19:20:28',10000,'OSS-锁定角色','roleId:4','127.0.0.1','com.vernon.oss.web.action.RoleAction',''),('2013-06-21 20:06:42',10000,'OSS-修改用户','userId:10002,email:lufeng@vernon.com','127.0.0.1','com.vernon.oss.web.action.UserAction',''),('2013-06-21 20:28:23',10000,'OSS-修改用户','userId:0,email:sadfsafsdaf','127.0.0.1','com.vernon.oss.web.action.UserAction',''),('2013-06-21 20:29:21',10000,'OSS-修改用户','userId:0,email:asdfas','127.0.0.1','com.vernon.oss.web.action.UserAction','');

/*Table structure for table `oss_popedom` */

DROP TABLE IF EXISTS `oss_popedom`;

CREATE TABLE `oss_popedom` (
  `popedom_id` int(10) NOT NULL COMMENT '主键',
  `group_id` int(3) NOT NULL COMMENT '组名',
  `popedom_name` varchar(100) NOT NULL COMMENT '管辖区名字',
  `locked` tinyint(1) NOT NULL COMMENT '是否被锁',
  `hide` tinyint(1) NOT NULL COMMENT '是否隐藏',
  `read_only` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否可读',
  `URI` varchar(100) NOT NULL COMMENT '链接',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`popedom_id`,`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oss_popedom` */

insert  into `oss_popedom`(`popedom_id`,`group_id`,`popedom_name`,`locked`,`hide`,`read_only`,`URI`,`remark`) values (1,1,'用户角色管理',0,0,0,'/role.do','用户角色管理'),(2,1,'界面管理',0,0,0,'/popedom.do',''),(3,2,'实名认证',0,0,0,'/auth.do','实名认证'),(5,3,'活动审核',0,0,0,'/check.do','活动审核'),(7,4,'分享列表',0,0,0,'/share/list.do','分享列表'),(9,5,'问答查询',0,0,0,'/list.do','问答查询'),(10,5,'sadfsda',0,0,0,'sadfsda','sadfsda'),(11,1,'后台用户管理',0,0,0,'/user.do','后台用户管理'),(19,5,'问答检查',0,0,0,'/wenda/check.do','问答检查'),(20,2,'fsafsdafsdaff',0,0,0,'sadfsafsdafsd','safsafsadfa');

/*Table structure for table `oss_role` */

DROP TABLE IF EXISTS `oss_role`;

CREATE TABLE `oss_role` (
  `role_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(50) NOT NULL COMMENT '角色名字',
  `locked` tinyint(1) NOT NULL COMMENT '是否被锁',
  `read_only` tinyint(1) NOT NULL COMMENT '是否可读',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `oss_role` */

insert  into `oss_role`(`role_id`,`role_name`,`locked`,`read_only`,`remark`) values (1,'超级管理员',0,0,'超级管理员'),(2,'技术人员',0,0,'技术人员'),(3,'运营人员',0,0,'运营人员'),(4,'编辑人员',1,0,'编辑人员'),(7,'奇葩啊',1,1,'奇葩啊奇葩啊奇葩啊');

/*Table structure for table `oss_role_popedom` */

DROP TABLE IF EXISTS `oss_role_popedom`;

CREATE TABLE `oss_role_popedom` (
  `role_id` int(10) NOT NULL COMMENT '主键',
  `popedom_id` int(10) NOT NULL COMMENT '管辖区ID',
  `read_only` tinyint(1) DEFAULT NULL COMMENT '是否可读',
  PRIMARY KEY (`role_id`,`popedom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oss_role_popedom` */

insert  into `oss_role_popedom`(`role_id`,`popedom_id`,`read_only`) values (1,1,0),(1,2,0),(1,3,0),(1,5,0),(1,7,0),(1,9,0),(1,11,0),(2,1,0),(2,3,0),(3,2,0),(7,1,0),(7,2,0),(7,3,0),(7,11,0);

/*Table structure for table `oss_user` */

DROP TABLE IF EXISTS `oss_user`;

CREATE TABLE `oss_user` (
  `user_id` int(10) NOT NULL COMMENT '主键',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `real_name` varchar(50) NOT NULL COMMENT '真实姓名',
  `locked` tinyint(1) NOT NULL COMMENT '是否被锁',
  `read_only` tinyint(1) NOT NULL COMMENT '是否可读',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oss_user` */

insert  into `oss_user`(`user_id`,`email`,`password`,`real_name`,`locked`,`read_only`,`remark`,`create_time`) values (10000,'chengcheng222e@sina.com','123456','陈袁',0,0,'','2013-06-20 12:17:23'),(10001,'chy@vernon.com','123456','常焕友',0,0,'','2013-06-20 15:19:56'),(10002,'lufeng@vernon.com','326103a18f','卢峰',0,0,'11111','2013-06-20 15:20:40'),(100021,'sadfsafsdaf','3eb4a66195','sadfsafsdf',0,0,'safdsfsa','2013-06-21 20:28:23'),(100022,'asdfas','be9d11e67a','safsdf',0,0,'sfsdafsd','2013-06-21 20:29:21');

/*Table structure for table `oss_user_role` */

DROP TABLE IF EXISTS `oss_user_role`;

CREATE TABLE `oss_user_role` (
  `user_id` int(10) NOT NULL COMMENT '主键',
  `role_id` int(3) NOT NULL COMMENT '角色',
  `read_only` tinyint(1) NOT NULL COMMENT '是否可读',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oss_user_role` */

insert  into `oss_user_role`(`user_id`,`role_id`,`read_only`) values (10000,1,0),(10000,2,0),(10001,3,0),(10002,4,0);

/*Table structure for table `sequence` */

DROP TABLE IF EXISTS `sequence`;

CREATE TABLE `sequence` (
  `sequence_name` varchar(50) NOT NULL,
  `next_value` int(11) NOT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sequence` */

insert  into `sequence`(`sequence_name`,`next_value`) values ('oss_group',1),('oss_op',1),('oss_popedom',21),('oss_role',9),('oss_role_popedom',1),('oss_user',100023),('oss_user_role',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
