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
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父部门id',
  `pids` varchar(255) DEFAULT NULL COMMENT '父级ids',
  `simplename` varchar(45) DEFAULT NULL COMMENT '简称',
  `fullname` varchar(255) DEFAULT NULL COMMENT '全称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 COMMENT='部门表';

/*Data for the table `sys_dept` */

insert  into `sys_dept`(`id`,`num`,`pid`,`pids`,`simplename`,`fullname`,`tips`,`version`) values 
(24,1,0,'[0],[24],','总公司','总公司','总公司就是好啊',NULL),
(25,1,24,'[0],[24],[24],','开发部','开发部','程序开发部',NULL),
(28,2,24,'[0],[24],[24],','运维部','开发技术运维部','主要维护现网稳定的',NULL),
(75,3,25,'[0],[24],[24],[25],','C语言开发部','C语言开发部','C语言开发部',NULL),
(76,3,25,'[0],[24],[24],[25],','JAVA开发部','JAVA开发部','JAVA开发部',NULL),
(77,2,24,'[0],[24],[24],','财务部','采购部','负责财务结算',NULL),
(78,2,24,'[0],[24],[24],','采购部','采购部','采购部',NULL);

/*Table structure for table `sys_dict` */

DROP TABLE IF EXISTS `sys_dict`;

CREATE TABLE `sys_dict` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT 0 COMMENT '父级字典',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `code` varchar(255) DEFAULT NULL COMMENT '值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='字典表';

/*Data for the table `sys_dict` */

insert  into `sys_dict`(`id`,`num`,`pid`,`name`,`tips`,`code`) values 
(50,2,0,'性别','字典：性别','sys_sex'),
(51,1,50,'男','性别：男','1'),
(52,2,50,'女','性别：女','2'),
(53,1,0,'状态','字典：状态','sys_state'),
(54,1,53,'启用',NULL,'1'),
(55,2,53,'禁用',NULL,'2'),
(56,3,0,'账号状态','字典：账号状态','account_state'),
(57,1,56,'启用',NULL,'1'),
(58,2,56,'冻结',NULL,'2'),
(59,3,56,'已删除',NULL,'3'),
(60,4,0,'支出类型','支出类型：公司常见支出类型','expend_type'),
(61,1,60,'员工薪资',NULL,'1'),
(62,2,60,'出差报销',NULL,'2'),
(69,5,0,'资金类型','资金类型：差旅，公关','capital_type'),
(70,1,69,'差旅',NULL,'1'),
(71,2,69,'公关',NULL,'2'),
(72,3,60,'团建报销',NULL,'3'),
(73,4,60,'打车报销',NULL,'4'),
(74,6,0,'材料单位','材料单位','material_unit'),
(75,1,74,'米',NULL,'1'),
(76,2,74,'吨',NULL,'2'),
(77,3,74,'千克',NULL,'3'),
(78,4,74,'袋',NULL,'4'),
(79,7,0,'项目收款类型','字典：项目收款类型','amount_type'),
(80,1,79,'首付款',NULL,'1'),
(81,2,79,'中付款',NULL,'2'),
(82,3,79,'尾付款',NULL,'3'),
(83,8,0,'项目阶段','字典：项目阶段','project_stage'),
(84,1,83,'新建','项目阶段：新建','1'),
(85,2,83,'开工','项目阶段：开工','2'),
(86,3,83,'停工',NULL,'3'),
(87,9,0,'在职状态','是否离职：0在职，1离职','quit_status'),
(88,0,87,'离职',NULL,'0'),
(89,1,87,'在职',NULL,'1'),
(90,4,83,'终止',NULL,'4'),
(91,5,83,'完工',NULL,'5'),
(92,5,60,'员工借款',NULL,'5'),
(106,6,60,'材料款','材料款','6');

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `menu_code` varchar(255) DEFAULT NULL COMMENT '菜单编号',
  `menu_pcode` varchar(255) DEFAULT NULL COMMENT '菜单父编号',
  `menu_pcodes` varchar(255) DEFAULT NULL COMMENT '当前菜单的所有父菜单编号',
  `menu_name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `menu_icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `menu_path` varchar(255) DEFAULT NULL COMMENT '路由地址',
  `menu_order` int(11) DEFAULT NULL COMMENT '菜单排序号',
  `menu_is_menu` int(11) DEFAULT NULL COMMENT '是否是菜单（1：是  0：不是）',
  `menu_status` int(11) DEFAULT NULL COMMENT '菜单状态 :  1:启用   0:不启用',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `creator` int(11) DEFAULT NULL COMMENT '创建者',
  `updator` int(11) DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=225 DEFAULT CHARSET=utf8 COMMENT='菜单表';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`menu_id`,`menu_code`,`menu_pcode`,`menu_pcodes`,`menu_name`,`menu_icon`,`menu_path`,`menu_order`,`menu_is_menu`,`menu_status`,`create_time`,`update_time`,`creator`,`updator`) values 
(166,'sysmanage','0','[0],','系统管理','xitong','/sysmanage',12,1,1,NULL,NULL,NULL,NULL),
(168,'usermanagement','sysmanage','[0],[sysmanage],','用户管理','user','/sysmanage/usermanagement',2,1,1,NULL,NULL,NULL,NULL),
(169,'rolemanagement','sysmanage','[0],[sysmanage],','角色管理','list','/sysmanage/rolemanagement',1,1,1,NULL,NULL,NULL,NULL),
(170,'menumanagement','sysmanage','[0],[sysmanage],','菜单管理','form','/sysmanage/menumanagement',3,1,1,NULL,NULL,NULL,NULL),
(171,'project','0','[0],','项目管理','international','/project',3,1,1,NULL,NULL,NULL,NULL),
(172,'shouldIncome','finance','[0],[finance],','应收管理','money','/finance/shouldIncome',1,1,1,NULL,NULL,NULL,NULL),
(173,'realIncome','finance','[0],[finance],','实收管理','money','/finance/realIncome',2,1,1,NULL,NULL,NULL,NULL),
(174,'invoice','finance','[0],[finance],','发票管理','form','/finance/invoice',3,1,1,NULL,NULL,NULL,NULL),
(175,'expend','finance','[0],[finance],','支出管理','money','/finance/expend',4,1,1,NULL,NULL,NULL,NULL),
(177,'userInfoLeave','employee','[0],[employee],','请假管理','user','/employee/userleavemanagement',2,1,0,NULL,NULL,NULL,NULL),
(179,'projectpre','project','[0],[project],','项目前期','money','/project/projectpre',1,1,1,NULL,NULL,NULL,NULL),
(180,'material','0','[0],','材料管理','form','/material',4,1,1,NULL,NULL,NULL,NULL),
(181,'mbaseinfo','material','[0],[material],','材料信息','form','/material/baseinfo',2,1,1,NULL,NULL,NULL,NULL),
(182,'apply','material','[0],[material],','材料申请','form','/material/apply',8,1,1,NULL,NULL,NULL,NULL),
(191,'projectinfo','project','[0],[project],','项目信息','money','/project/projectinfo',3,1,1,NULL,NULL,NULL,NULL),
(192,'finance','0','[0],','财务管理','money','/finance',8,1,1,NULL,NULL,NULL,NULL),
(193,'areaManagement','baseinfo','[0],[sysmanage],','地区管理','user','/sysmanage/areamanagement',7,1,1,NULL,NULL,NULL,NULL),
(194,'baseinfo','0','[0],','基本信息','form','/baseinfo',10,1,1,NULL,NULL,NULL,NULL),
(195,'supplier','baseinfo','[0],[baseinfo],','厂商管理','form','/baseinfo/supplier',2,1,1,NULL,NULL,NULL,NULL),
(196,'dept','baseinfo','[0],[sysmanage],','部门管理','form','/sysmanage/dept',5,1,1,NULL,NULL,NULL,NULL),
(197,'product','baseinfo','[0],[baseinfo],','产品信息','form','/baseinfo/product',2,1,1,NULL,NULL,NULL,NULL),
(199,'workbench','0','[0],','我的工作台','form','/workbench',1,1,1,NULL,NULL,NULL,NULL),
(200,'todolist','workbench','[0],[workbench]','待办任务','form','/workbench/todolist',1,1,1,NULL,NULL,NULL,NULL),
(201,'havedone','workbench','[0],[workbench]','已办任务','form','/workbench/donelist',2,1,1,NULL,NULL,NULL,NULL),
(202,'employee','0','[0],','人员管理','user','/employee',5,1,1,NULL,NULL,NULL,NULL),
(203,'emplinfo','employee','[0],[employee]','人员信息','user','/employee/employeeInfo',1,1,1,NULL,NULL,NULL,NULL),
(204,'salarymanage','0','[0],','薪资管理','form','/salarymanage',6,1,1,NULL,NULL,NULL,NULL),
(205,'salarystandard','salarymanage','[0],[salarymanage]','薪资标准','form','/salarymanage/salarystandard',1,1,1,NULL,NULL,NULL,NULL),
(206,'salarypayroll','salarymanage','[0],[salarymanage]','薪资发放','form','/salarymanage/salarypayroll',2,1,1,NULL,NULL,NULL,NULL),
(207,'fundapply','salarymanage','[0],[salarymanage],','资金申请','form','/salarymanage/fundapply',3,1,1,NULL,NULL,NULL,NULL),
(208,'insurancemanage','0','[0],','保险管理','form','/insurancemanage',7,1,1,NULL,NULL,NULL,NULL),
(209,'insuranceinfo','insurancemanage','[0],[insurancemanage]','参保信息','form','/insurancemanage/insuranceinfo',1,1,1,NULL,NULL,NULL,NULL),
(210,'contractinfo','project','[0],[project],','合同信息','form','/project/contractinfo',2,1,1,NULL,NULL,NULL,NULL),
(212,'dictmanage','baseinfo','[0],[baseinfo],','数据字典','form','/baseinfo/dictmanage',5,1,1,NULL,NULL,NULL,NULL),
(213,'mymessage','workbench','[0],[workbench],','我的消息','message','/workbench/mymessage',3,1,1,NULL,NULL,NULL,NULL),
(214,'repayment','finance','[0],[finance],','还款管理','form','/finance/repayment',5,1,1,NULL,NULL,NULL,NULL),
(215,'workflowconfig','baseinfo','[0],[baseinfo],','工作流配置','form','/baseinfo/workflowconfig',6,1,1,NULL,NULL,NULL,NULL),
(216,'attendance','employee','[0],[employee],','考勤记录','form','/employee/attendance',2,1,1,NULL,NULL,NULL,NULL),
(217,'reportform','0','[0],','报表管理','form','/reportform',9,1,1,NULL,NULL,NULL,NULL),
(218,'projectreport','reportform','[0],[reportform],','项目报表','form','/reportform/projectreport',1,1,1,NULL,NULL,NULL,NULL),
(220,'attendanceshow','employee','[0],[employee],','考勤查看','form','/employee/attendanceshow',3,1,1,NULL,NULL,NULL,NULL),
(223,'archfile','0','[0],','文档管理','form','/archfile',12,1,1,NULL,NULL,NULL,NULL),
(224,'fileinfo','archfile','[0],[archfile],','文档信息','form','/archfile/fileinfo',1,1,1,NULL,NULL,NULL,NULL);

/*Table structure for table `sys_relation` */

DROP TABLE IF EXISTS `sys_relation`;

CREATE TABLE `sys_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_id` bigint(11) DEFAULT NULL COMMENT '菜单id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4922 DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

/*Data for the table `sys_relation` */

insert  into `sys_relation`(`id`,`menu_id`,`role_id`) values 
(19,177,2),
(46,213,2),
(3923,202,13),
(3924,177,13),
(3925,203,13),
(3926,216,13),
(3927,171,7),
(3928,179,7),
(3929,191,7),
(3930,210,7),
(3931,171,8),
(3932,179,8),
(3933,191,8),
(3934,210,8),
(3935,192,6),
(3936,172,6),
(3937,173,6),
(3938,174,6),
(3939,175,6),
(3940,214,6),
(3941,199,6),
(3942,200,6),
(3943,201,6),
(3944,213,6),
(3945,202,6),
(3946,177,6),
(3947,203,6),
(3948,216,6),
(4587,NULL,11),
(4750,166,5),
(4751,168,5),
(4752,169,5),
(4753,170,5),
(4754,171,5),
(4755,179,5),
(4756,191,5),
(4757,210,5),
(4758,180,5),
(4759,181,5),
(4760,182,5),
(4761,192,5),
(4762,172,5),
(4763,173,5),
(4764,174,5),
(4765,175,5),
(4766,214,5),
(4767,194,5),
(4768,193,5),
(4769,195,5),
(4770,196,5),
(4771,197,5),
(4772,212,5),
(4773,215,5),
(4774,199,5),
(4775,200,5),
(4776,201,5),
(4777,213,5),
(4778,202,5),
(4779,177,5),
(4780,203,5),
(4781,216,5),
(4782,220,5),
(4783,204,5),
(4784,205,5),
(4785,206,5),
(4786,207,5),
(4787,208,5),
(4788,209,5),
(4789,217,5),
(4790,218,5),
(4878,166,1),
(4879,168,1),
(4880,169,1),
(4881,170,1),
(4882,171,1),
(4883,179,1),
(4884,191,1),
(4885,210,1),
(4886,180,1),
(4887,181,1),
(4888,182,1),
(4889,192,1),
(4890,172,1),
(4891,173,1),
(4892,174,1),
(4893,175,1),
(4894,214,1),
(4895,194,1),
(4896,193,1),
(4897,195,1),
(4898,196,1),
(4899,197,1),
(4900,212,1),
(4901,215,1),
(4902,199,1),
(4903,200,1),
(4904,201,1),
(4905,213,1),
(4906,202,1),
(4907,177,1),
(4908,203,1),
(4909,216,1),
(4910,220,1),
(4911,204,1),
(4912,205,1),
(4913,206,1),
(4914,207,1),
(4915,208,1),
(4916,209,1),
(4917,217,1),
(4918,218,1),
(4919,223,1),
(4920,224,1),
(4921,226,1);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_pid` int(11) DEFAULT NULL COMMENT '父角色id',
  `role_order` int(11) DEFAULT NULL COMMENT '序号',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(255) DEFAULT NULL COMMENT '提示',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `creator` int(11) DEFAULT NULL COMMENT '创建者',
  `updator` int(11) DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`role_pid`,`role_order`,`role_name`,`role_desc`,`create_time`,`update_time`,`creator`,`updator`) values 
(1,0,1,'超级管理员','administrator',NULL,NULL,NULL,NULL),
(5,1,2,'临时','TEMP',NULL,NULL,NULL,NULL),
(6,0,0,'董事长','PRESIDENT',NULL,NULL,NULL,NULL),
(7,6,1,'工程部长','ENGINEERING_MINISTER',NULL,NULL,NULL,NULL),
(8,7,2,'工程员','ENGINEER',NULL,NULL,NULL,NULL),
(9,6,NULL,'开发部长','DEVELOPER_MINISTER',NULL,NULL,NULL,NULL),
(10,6,1,'运维部长','OPERATION_MINISTER',NULL,NULL,NULL,NULL),
(11,9,NULL,'JAVA开发','DEVELOPER_JAVA',NULL,NULL,NULL,NULL),
(12,9,NULL,'C++开发','DEVELOPER_C++',NULL,NULL,NULL,NULL),
(13,9,NULL,'PYHTON开发','DEVELOPER_PYTHON',NULL,NULL,NULL,NULL),
(14,10,NULL,'运维工程师','OPERATION_ENGINEER',NULL,NULL,NULL,NULL),
(18,8,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='管理员表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`user_avatar`,`user_name`,`user_password`,`user_realName`,`user_birthday`,`user_sex`,`user_email`,`user_phone`,`user_role_id`,`user_dept_id`,`user_status`,`create_time`,`update_time`,`creator`,`updator`) values 
(1,'3f650a31-f0bf-4aab-962d-455157230e36.jpg','admin','ecfadcde9305f8891bcfe5a1e28c253e','管理员','2017-05-04 16:00:00',1,'18751907450@163.com','18200000000',1,24,1,'2016-01-29 08:49:53','2018-10-11 20:16:22',NULL,NULL),
(45,NULL,'boss','71887a5ad666a18f709e1d4e693d5a35','李四','2017-12-04 00:00:00',1,'18751907450@163.com','18200000000',1,24,1,'2017-12-04 22:24:02','2018-09-06 23:18:25',NULL,NULL),
(46,'','lkp','111111','娄可鹏','2017-12-04 00:00:00',1,'18751907450@163.com','18200000000',1,24,1,'2017-12-04 22:24:24','2018-10-08 21:47:14',NULL,NULL),
(47,'','cxh','111111','陈小欢','1981-07-16 16:00:00',1,'18751907450@163.com','18200000000',1,25,1,'2018-08-09 06:04:32','2018-09-23 22:33:50',NULL,NULL),
(48,'','yhg','7571321923ea17cf8f9fd692f2d4ed09','姚焕果','1981-04-27 16:00:00',1,'18751907450@163.com','18200000000',7,28,1,'2018-08-09 06:13:47','2018-09-24 19:59:44',NULL,NULL),
(49,NULL,'jwk','111111','姜维康','2018-09-13 23:34:02',2,'15895895774@163.com','1589877868',10,26,1,'2018-09-12 01:19:48','2018-09-23 22:54:16',NULL,NULL),
(50,NULL,'test','10bab0a651c651a315b863e997e4df3e','test',NULL,2,'111','11',5,27,3,'2018-09-13 23:33:36','2018-10-08 21:39:51',NULL,NULL),
(51,NULL,'jiduorui','01044a30ed62b7a9cdd33d81aa9c8de4','纪多瑞','2018-09-05 00:00:00',1,'15989894987@163.com','15989894987',5,25,1,'2018-09-23 22:40:55','2018-10-08 21:39:56',NULL,NULL),
(52,NULL,'fanfan','e1571646cd69e3da9fbea0714186ff7f','范范','2018-09-04 00:00:00',2,'15986848959@163.com','15986848959',11,26,1,'2018-09-23 23:12:38','2018-09-24 19:37:41',NULL,NULL),
(56,'','xieliang','49bab56a43779e6707dd2e35d385f5f0','解亮','1988-03-08 00:00:00',1,'','',1,24,1,'2018-10-02 14:30:03','2018-10-08 21:42:39',NULL,NULL),
(58,NULL,'xiaoli','$2a$10$oTYrvK3T8CptNsv/5P..k.PhvdFPWopHEPGJ6MuMFRNnBH1qwWfTa',NULL,'2018-11-13 14:11:06',NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
