/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 10.2.18-MariaDB : Database - task
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`task` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `task`;

/*Table structure for table `sys_dept` */

DROP TABLE IF EXISTS `sys_dept`;

CREATE TABLE `sys_dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dept_code` varchar(48) DEFAULT NULL COMMENT '部门编码',
  `dept_name` varchar(45) DEFAULT NULL COMMENT '简称',
  `dept_pid` int(11) DEFAULT NULL COMMENT '父部门id',
  `dept_pids` varchar(255) DEFAULT NULL COMMENT '父级ids',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `creator` int(11) DEFAULT NULL COMMENT '创建者',
  `updator` int(11) DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 COMMENT='部门表';

/*Data for the table `sys_dept` */

insert  into `sys_dept`(`dept_id`,`dept_code`,`dept_name`,`dept_pid`,`dept_pids`,`create_time`,`update_time`,`creator`,`updator`) values 
(24,'company','总公司',0,'[0],[24]','2018-12-08 17:37:39','2018-12-08 17:37:46',58,58),
(25,'department_development','开发部',24,'[0],[24]','2018-12-08 17:37:42','2018-12-08 17:37:47',58,58),
(28,'department_test','测试部',24,'[0],[24]','2018-12-08 17:37:41','2018-12-08 17:37:50',58,58),
(29,'department_product','业务部',24,'[0],[24]','2018-12-08 17:37:44','2018-12-08 17:37:49',58,58);

/*Table structure for table `sys_dict` */

DROP TABLE IF EXISTS `sys_dict`;

CREATE TABLE `sys_dict` (
  `dict_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dict_pid` int(11) DEFAULT 0 COMMENT '父级字典',
  `dict_name` varchar(255) DEFAULT NULL COMMENT '名称',
  `dict_code` varchar(255) DEFAULT NULL COMMENT '值',
  `dict_order` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `creator` int(11) DEFAULT NULL COMMENT '创建者',
  `updator` int(11) DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`dict_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='字典表';

/*Data for the table `sys_dict` */

insert  into `sys_dict`(`dict_id`,`dict_pid`,`dict_name`,`dict_code`,`dict_order`,`create_time`,`update_time`,`creator`,`updator`) values 
(50,0,'性别','sys_sex',2,'2018-11-23 15:15:30','2018-11-23 15:15:59',1,1),
(51,50,'男','1',1,'2018-11-23 15:15:32','2018-11-23 15:15:51',1,1),
(52,50,'女','2',2,'2018-11-23 15:15:35','2018-11-23 15:16:01',1,1),
(53,0,'状态','sys_state',3,'2018-11-23 15:15:36','2018-12-06 15:50:47',1,58),
(54,53,'启用','1',1,'2018-11-23 15:15:38','2018-11-23 15:16:02',1,1),
(55,53,'禁用','2',2,'2018-11-23 15:15:41','2018-11-23 15:16:06',1,1),
(56,0,'账号状态','account_state',3,'2018-11-23 15:15:39','2018-11-23 15:16:04',1,1),
(57,56,'启用','1',1,'2018-11-23 15:15:43','2018-11-23 15:16:12',1,1),
(58,56,'冻结','2',2,'2018-11-23 15:15:49','2018-11-23 15:16:07',1,1),
(59,56,'已删除','3',3,'2018-11-23 15:15:44','2018-11-23 15:16:09',1,1),
(60,0,'是否菜单','is_menu',3,'2018-11-23 17:51:33','2018-12-06 15:50:53',1,58),
(61,60,'是','1',1,'2018-11-23 17:52:29','2018-11-23 17:52:31',1,1),
(62,60,'否','2',3,'2018-11-23 17:52:44','2018-11-23 17:52:46',1,1),
(114,0,'需求阶段','demand_stage',0,'2018-12-03 16:16:36','2018-12-03 17:51:50',58,58),
(115,114,'需求创建','demand_create',0,'2018-12-04 18:15:24','2018-12-04 18:15:27',58,58),
(116,114,'需求启动','demand_start',1,'2018-12-03 16:18:10','2018-12-04 18:14:25',58,58),
(117,114,'需求阶段','demand_demand',2,'2018-12-03 16:19:33','2018-12-04 18:14:23',58,58),
(118,114,'设计阶段','demand_design',3,'2018-12-03 16:20:15','2018-12-04 18:14:21',58,58),
(119,114,'开发阶段','demand_development',4,'2018-12-03 16:21:12','2018-12-04 18:14:19',58,58),
(120,114,'测试阶段','demand_test',5,'2018-12-03 16:21:38','2018-12-04 18:14:16',58,58),
(121,114,'需求上线','demand_online',6,'2018-12-03 16:22:51','2018-12-04 18:14:13',58,58),
(123,0,'任务阶段','mission_stage',1,'2018-12-06 15:50:38','2018-12-06 15:50:38',58,58),
(124,123,'任务分配','mission_received',1,'2018-12-06 15:53:41','2018-12-06 15:56:38',58,58),
(125,123,'任务创建','mission_created',0,'2018-12-06 15:54:47','2018-12-06 15:56:24',58,58),
(126,123,'任务确认','mission_confirmed',2,'2018-12-06 15:58:03','2018-12-06 15:58:32',58,58),
(127,123,'开发编码','mission_coding',3,'2018-12-06 16:00:34','2018-12-06 16:00:34',58,58),
(128,123,'开发自测','mission_developer_testing',4,'2018-12-06 16:03:25','2018-12-06 16:03:25',58,58),
(129,123,'任务转测','misssion_tester_testing',5,'2018-12-06 16:04:42','2018-12-06 16:05:01',58,58),
(130,123,'发布完成','mission_online',6,'2018-12-06 16:05:46','2018-12-06 16:05:46',58,58),
(131,0,'服务组件','service_group',2,'2018-12-06 16:08:52','2018-12-06 21:13:11',58,58),
(132,131,'金融','service_crms',0,'2018-12-06 16:10:53','2018-12-06 17:31:49',58,58);

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `menu_code` varchar(255) DEFAULT NULL COMMENT '菜单编号',
  `menu_pcode` varchar(255) DEFAULT '0' COMMENT '菜单父编号',
  `menu_pcodes` varchar(255) DEFAULT NULL COMMENT '当前菜单的所有父菜单编号',
  `menu_name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `menu_icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `menu_path` varchar(255) DEFAULT NULL COMMENT '路由地址',
  `menu_order` int(11) DEFAULT NULL COMMENT '菜单排序号',
  `menu_is_menu` varchar(1) DEFAULT NULL COMMENT '是否是菜单（1：是  0：不是）',
  `menu_status` varchar(1) DEFAULT NULL COMMENT '菜单状态 :  1:启用   0:不启用',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `creator` int(11) DEFAULT NULL COMMENT '创建者',
  `updator` int(11) DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=252 DEFAULT CHARSET=utf8 COMMENT='菜单表';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`menu_id`,`menu_code`,`menu_pcode`,`menu_pcodes`,`menu_name`,`menu_icon`,`menu_path`,`menu_order`,`menu_is_menu`,`menu_status`,`create_time`,`update_time`,`creator`,`updator`) values 
(1,'system','0','[0],','系统管理','xitong','/system',1,'1','1','2018-11-15 22:54:35','2018-11-28 14:42:23',58,58),
(2,'user','system','[0],[system],','用户管理','user','/system/user',2,'1','1','2018-11-15 22:54:38','2018-11-15 22:54:45',58,58),
(3,'role','system','[0],[0],','角色管理','user','/system/role',1,'1','1','2018-11-15 22:54:40','2018-11-28 14:25:15',58,58),
(4,'menu','system','[0],[system],','菜单管理','form','/system/menu',3,'1','1','2018-11-15 22:54:41','2018-11-15 22:54:49',58,58),
(248,'dict','system','[0],[0],','字典管理','form','/system/dict',4,'1','1','2018-12-01 15:00:32','2018-12-01 15:00:32',58,58),
(249,'task','0','[0],','任务管理','international','/task',1,'1','1','2018-12-03 19:38:14','2018-12-03 19:47:19',58,58),
(250,'demand','task','[0],[0],','需求管理','form','/task/demand',1,'1','1','2018-12-03 19:39:29','2018-12-03 19:47:21',58,58),
(251,'mission','task','[0],[0],','我的待办','form','/task/mission',2,'1','1','2018-12-06 14:06:18','2018-12-06 14:32:17',58,58);

/*Table structure for table `sys_relation` */

DROP TABLE IF EXISTS `sys_relation`;

CREATE TABLE `sys_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4957 DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

/*Data for the table `sys_relation` */

insert  into `sys_relation`(`id`,`menu_id`,`role_id`) values 
(4932,3,6),
(4933,4,6),
(4934,1,6),
(4950,249,1),
(4951,250,1),
(4952,251,1),
(4953,3,1),
(4954,4,1),
(4955,248,1),
(4956,1,1);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(255) DEFAULT NULL COMMENT '提示',
  `role_pid` int(11) DEFAULT NULL COMMENT '父角色id',
  `role_order` int(11) DEFAULT NULL COMMENT '序号',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `creator` int(11) DEFAULT NULL COMMENT '创建者',
  `updator` int(11) DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`role_name`,`role_code`,`role_pid`,`role_order`,`create_time`,`update_time`,`creator`,`updator`) values 
(1,'超级管理员','ADMINISTRATOR',0,1,'2018-11-30 21:00:09','2018-11-30 21:00:09',58,58),
(5,'临时','TEMP',1,3,'2018-11-30 21:00:09','2018-11-30 21:00:09',58,58),
(6,'董事长','PRESIDENT',0,1,'2018-11-30 21:00:09','2018-11-30 21:00:09',58,58),
(7,'工程部长','ENGINEERING_MINISTER',6,2,'2018-11-30 21:00:09','2018-11-30 21:00:09',58,58),
(9,'开发部长','DEVELOPER_MINISTER',6,1,'2018-11-30 21:00:09','2018-11-30 21:00:09',58,58),
(11,'开发工程师','DEVELOPER_ENGINEER',9,1,'2018-11-30 21:00:09','2018-12-08 13:52:37',58,58),
(22,'测试经理','TEST_MANAGER',6,1,'2018-12-06 22:23:46','2018-12-06 22:23:46',58,58),
(23,'测试工程师','TEST_ENGINEER',22,2,'2018-12-06 22:59:00','2018-12-06 22:59:00',58,58),
(24,'产品经理','PRODUCT_MANAGER',6,2,'2018-12-08 17:36:30','2018-12-08 17:36:30',58,58);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `user_name` varchar(45) DEFAULT NULL COMMENT '账号',
  `user_password` varchar(60) DEFAULT NULL COMMENT '密码',
  `user_realName` varchar(45) DEFAULT NULL COMMENT '名字',
  `user_birthday` timestamp NULL DEFAULT NULL COMMENT '生日',
  `user_sex` int(11) DEFAULT NULL COMMENT '性别（1：男 2：女）',
  `user_email` varchar(45) DEFAULT NULL COMMENT '电子邮件',
  `user_phone` varchar(45) DEFAULT NULL COMMENT '电话',
  `user_role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `user_dept_id` int(11) DEFAULT NULL COMMENT '部门id',
  `user_status` int(11) DEFAULT NULL COMMENT '状态(1：启用  2：冻结  3：删除）',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `creator` int(11) DEFAULT NULL COMMENT '创建者',
  `updator` int(11) DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8 COMMENT='管理员表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`user_avatar`,`user_name`,`user_password`,`user_realName`,`user_birthday`,`user_sex`,`user_email`,`user_phone`,`user_role_id`,`user_dept_id`,`user_status`,`create_time`,`update_time`,`creator`,`updator`) values 
(1,'3f650a31-f0bf-4aab-962d-455157230e36.jpg','admin','ecfadcde9305f8891bcfe5a1e28c253e','管理员','2017-05-04 16:00:00',1,'18751907450@163.com','18200000000',1,24,1,'2016-01-29 08:49:53','2018-10-11 20:16:22',58,58),
(58,NULL,'xiahui','$2a$10$oTYrvK3T8CptNsv/5P..k.PhvdFPWopHEPGJ6MuMFRNnBH1qwWfTa','夏辉','2018-11-13 14:11:06',1,'18751907450@163.com','18200000000',1,24,1,'2018-12-06 21:57:17','2018-12-06 21:57:20',58,58),
(59,NULL,'yuanlinbing','$2a$10$oTYrvK3T8CptNsv/5P..k.PhvdFPWopHEPGJ6MuMFRNnBH1qwWfTa','袁林兵','2018-12-06 21:57:08',1,'18751907450@163.com','18200000000',23,28,1,'2018-12-06 21:58:20','2018-12-06 21:58:22',58,58),
(60,NULL,'hepei','$2a$10$oTYrvK3T8CptNsv/5P..k.PhvdFPWopHEPGJ6MuMFRNnBH1qwWfTa','何沛','2018-12-06 21:58:14',1,'18751907450@163.com','18200000000',11,25,1,'2018-12-06 21:58:18','2018-12-06 21:58:24',58,58),
(61,NULL,'zhangtiejun','$2a$10$oTYrvK3T8CptNsv/5P..k.PhvdFPWopHEPGJ6MuMFRNnBH1qwWfTa','张铁军','2018-12-08 17:33:37',1,'18751907450@163.com','18200000000',24,29,1,'2018-12-08 17:38:12','2018-12-08 17:38:14',58,58);

/*Table structure for table `task_demand` */

DROP TABLE IF EXISTS `task_demand`;

CREATE TABLE `task_demand` (
  `demand_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '需求主键',
  `demand_name` varchar(128) NOT NULL COMMENT '需求名称',
  `demand_jira` varchar(48) NOT NULL COMMENT '需求jira单号',
  `demand_originator` int(11) NOT NULL COMMENT '需求发起人',
  `demand_start_date` timestamp NULL DEFAULT NULL COMMENT '需求开始时间',
  `demand_end_date` timestamp NULL DEFAULT NULL COMMENT '需求结束时间',
  `demand_stage` varchar(48) DEFAULT NULL COMMENT '需求阶段',
  `demand_desc` text DEFAULT NULL COMMENT '需求描述',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `creator` int(11) DEFAULT NULL COMMENT '创建者',
  `updator` int(11) DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`demand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='需求表';

/*Data for the table `task_demand` */

insert  into `task_demand`(`demand_id`,`demand_name`,`demand_jira`,`demand_originator`,`demand_start_date`,`demand_end_date`,`demand_stage`,`demand_desc`,`create_time`,`update_time`,`creator`,`updator`) values 
(1,'测试','CRED-448',58,'2018-12-04 18:44:21','2018-12-27 19:31:44','demand_create','测试','2018-12-04 18:42:06','2018-12-04 18:42:06',58,58),
(2,'测试2','CRED-449',58,'2018-12-12 00:00:00','2018-12-14 00:00:00','demand_create','测试23','2018-12-12 20:36:38','2018-12-12 20:36:38',58,58),
(3,'测试3','CRED-450',58,'2018-12-12 00:00:00','2018-12-13 00:00:00','demand_create','测试3','2018-12-12 20:40:05','2018-12-12 20:40:05',58,58);

/*Table structure for table `task_mission` */

DROP TABLE IF EXISTS `task_mission`;

CREATE TABLE `task_mission` (
  `mission_id` int(15) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `mission_name` varchar(256) NOT NULL COMMENT '任务名称',
  `mission_demand_id` int(11) NOT NULL COMMENT '任务所属需求',
  `mission_group` varchar(56) NOT NULL COMMENT '任务所属模块',
  `mission_developer` int(11) NOT NULL COMMENT '任务开发人',
  `mission_tester` int(11) NOT NULL COMMENT '任务测试人',
  `mission_workdays` float DEFAULT NULL COMMENT '任务工作量',
  `mission_stage` varchar(56) DEFAULT NULL COMMENT '任务阶段',
  `mission_start_date` timestamp NULL DEFAULT NULL COMMENT '任务开始时间',
  `mission_end_date` timestamp NULL DEFAULT NULL COMMENT '任务结束时间',
  `mission_desc` text DEFAULT NULL COMMENT '任务描述',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `creator` int(11) DEFAULT NULL COMMENT '创建者',
  `updator` int(11) DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`mission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='任务表';

/*Data for the table `task_mission` */

insert  into `task_mission`(`mission_id`,`mission_name`,`mission_demand_id`,`mission_group`,`mission_developer`,`mission_tester`,`mission_workdays`,`mission_stage`,`mission_start_date`,`mission_end_date`,`mission_desc`,`create_time`,`update_time`,`creator`,`updator`) values 
(1,'测试',1,'service_crms',60,59,1.5,'mission_received','2018-12-05 00:00:00','2018-12-05 00:00:00','测试11','2018-12-06 17:05:24','2018-12-12 17:40:28',58,58),
(2,'测试3',1,'service_crms',60,59,3,'mission_created','2018-12-12 00:00:00','2018-12-14 00:00:00','333','2018-12-12 17:44:11','2018-12-12 19:14:02',58,58),
(3,'测试3-任务一',3,'service_crms',60,59,4,'mission_created','2018-12-12 00:00:00','2018-12-14 00:00:00','测试333','2018-12-12 21:06:08','2018-12-12 21:06:08',58,58);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
