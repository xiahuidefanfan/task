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

/*Table structure for table `act_evt_log` */

DROP TABLE IF EXISTS `act_evt_log`;

CREATE TABLE `act_evt_log` (
  `LOG_NR_` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TIME_STAMP_` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DATA_` longblob DEFAULT NULL,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LOCK_TIME_` timestamp NULL DEFAULT NULL,
  `IS_PROCESSED_` tinyint(4) DEFAULT 0,
  PRIMARY KEY (`LOG_NR_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_evt_log` */

/*Table structure for table `act_ge_bytearray` */

DROP TABLE IF EXISTS `act_ge_bytearray`;

CREATE TABLE `act_ge_bytearray` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTES_` longblob DEFAULT NULL,
  `GENERATED_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_BYTEARR_DEPL` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_BYTEARR_DEPL` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ge_bytearray` */

insert  into `act_ge_bytearray`(`ID_`,`REV_`,`NAME_`,`DEPLOYMENT_ID_`,`BYTES_`,`GENERATED_`) values 
('2',1,'processes/mission.bpmn20.xml','1','<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:flowable=\"http://flowable.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\" expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://www.flowable.org/processdef\">\n  <process id=\"task\" name=\"项目任务流程定义\" isExecutable=\"true\">\n    <startEvent id=\"mession_start\" name=\"任务开始节点\">\n      <documentation>任务开始</documentation>\n    </startEvent>\n    <userTask id=\"mission_allocation\" name=\"任务分配\" flowable:assignee=\"${missionDeveloper}\">\n      <documentation>任务分配</documentation>\n      <extensionElements>\n        <modeler:initiator-can-complete xmlns:modeler=\"http://flowable.org/modeler\"><![CDATA[false]]></modeler:initiator-can-complete>\n      </extensionElements>\n    </userTask>\n    <sequenceFlow id=\"sid-AE746DB6-0B44-46F4-B571-E5ABB8CAF5E6\" sourceRef=\"mession_start\" targetRef=\"mission_allocation\"></sequenceFlow>\n    <userTask id=\"mission_confirmed\" name=\"任务确认\">\n      <documentation>任务确认</documentation>\n    </userTask>\n    <sequenceFlow id=\"sid-01D360A5-7AE1-4EFE-B1B0-341701EF1A49\" sourceRef=\"mission_allocation\" targetRef=\"mission_confirmed\"></sequenceFlow>\n    <userTask id=\"mission_coding\" name=\"任务编码\">\n      <documentation>任务编码</documentation>\n    </userTask>\n    <sequenceFlow id=\"sid-ADB3F2E9-50F7-4862-ADF1-EBE4039E5D53\" sourceRef=\"mission_confirmed\" targetRef=\"mission_coding\"></sequenceFlow>\n    <userTask id=\"sid-8FF75F3E-298C-4B4E-960A-7A1E38B4E86C\" name=\"任务自测\">\n      <documentation>任务自测</documentation>\n    </userTask>\n    <sequenceFlow id=\"sid-47615674-BB0C-49E2-8FB9-FEA1A0AADC9D\" sourceRef=\"mission_coding\" targetRef=\"sid-8FF75F3E-298C-4B4E-960A-7A1E38B4E86C\"></sequenceFlow>\n    <userTask id=\"misssion_tester_testing\" name=\"任务转测\">\n      <documentation>任务转测</documentation>\n    </userTask>\n    <sequenceFlow id=\"sid-A3AE29A3-0B54-40BC-836A-6246CAA5BC79\" sourceRef=\"sid-8FF75F3E-298C-4B4E-960A-7A1E38B4E86C\" targetRef=\"misssion_tester_testing\"></sequenceFlow>\n    <userTask id=\"mission_waiting_online\" name=\"等待发布\">\n      <documentation>等待发布</documentation>\n    </userTask>\n    <sequenceFlow id=\"sid-3442F465-F6B6-417C-8569-C5D48576DDE8\" sourceRef=\"misssion_tester_testing\" targetRef=\"mission_waiting_online\"></sequenceFlow>\n    <endEvent id=\"mission_end\" name=\"结束\"></endEvent>\n    <sequenceFlow id=\"sid-4DA6219C-71B9-46C0-B966-48F0CB5CC044\" sourceRef=\"mission_waiting_online\" targetRef=\"mission_end\"></sequenceFlow>\n  </process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_task\">\n    <bpmndi:BPMNPlane bpmnElement=\"task\" id=\"BPMNPlane_task\">\n      <bpmndi:BPMNShape bpmnElement=\"mession_start\" id=\"BPMNShape_mession_start\">\n        <omgdc:Bounds height=\"30.0\" width=\"30.0\" x=\"90.0\" y=\"150.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"mission_allocation\" id=\"BPMNShape_mission_allocation\">\n        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"165.0\" y=\"125.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"mission_confirmed\" id=\"BPMNShape_mission_confirmed\">\n        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"300.0\" y=\"125.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"mission_coding\" id=\"BPMNShape_mission_coding\">\n        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"445.0\" y=\"125.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"sid-8FF75F3E-298C-4B4E-960A-7A1E38B4E86C\" id=\"BPMNShape_sid-8FF75F3E-298C-4B4E-960A-7A1E38B4E86C\">\n        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"590.0\" y=\"125.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"misssion_tester_testing\" id=\"BPMNShape_misssion_tester_testing\">\n        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"735.0\" y=\"125.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"mission_waiting_online\" id=\"BPMNShape_mission_waiting_online\">\n        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"735.0\" y=\"255.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape bpmnElement=\"mission_end\" id=\"BPMNShape_mission_end\">\n        <omgdc:Bounds height=\"28.0\" width=\"28.0\" x=\"626.0\" y=\"281.0\"></omgdc:Bounds>\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNEdge bpmnElement=\"sid-ADB3F2E9-50F7-4862-ADF1-EBE4039E5D53\" id=\"BPMNEdge_sid-ADB3F2E9-50F7-4862-ADF1-EBE4039E5D53\">\n        <omgdi:waypoint x=\"399.95000000000005\" y=\"165.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"445.0\" y=\"165.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"sid-3442F465-F6B6-417C-8569-C5D48576DDE8\" id=\"BPMNEdge_sid-3442F465-F6B6-417C-8569-C5D48576DDE8\">\n        <omgdi:waypoint x=\"785.0\" y=\"204.95\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"785.0\" y=\"255.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"sid-A3AE29A3-0B54-40BC-836A-6246CAA5BC79\" id=\"BPMNEdge_sid-A3AE29A3-0B54-40BC-836A-6246CAA5BC79\">\n        <omgdi:waypoint x=\"689.9499999999907\" y=\"165.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"734.9999999999807\" y=\"165.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"sid-4DA6219C-71B9-46C0-B966-48F0CB5CC044\" id=\"BPMNEdge_sid-4DA6219C-71B9-46C0-B966-48F0CB5CC044\">\n        <omgdi:waypoint x=\"735.0\" y=\"295.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"653.9499273251088\" y=\"295.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"sid-AE746DB6-0B44-46F4-B571-E5ABB8CAF5E6\" id=\"BPMNEdge_sid-AE746DB6-0B44-46F4-B571-E5ABB8CAF5E6\">\n        <omgdi:waypoint x=\"119.94999848995758\" y=\"165.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"165.0\" y=\"165.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"sid-47615674-BB0C-49E2-8FB9-FEA1A0AADC9D\" id=\"BPMNEdge_sid-47615674-BB0C-49E2-8FB9-FEA1A0AADC9D\">\n        <omgdi:waypoint x=\"544.9499999999907\" y=\"165.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"589.9999999999807\" y=\"165.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge bpmnElement=\"sid-01D360A5-7AE1-4EFE-B1B0-341701EF1A49\" id=\"BPMNEdge_sid-01D360A5-7AE1-4EFE-B1B0-341701EF1A49\">\n        <omgdi:waypoint x=\"264.95000000000005\" y=\"165.0\"></omgdi:waypoint>\n        <omgdi:waypoint x=\"300.0\" y=\"165.0\"></omgdi:waypoint>\n      </bpmndi:BPMNEdge>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</definitions>',0),
('3',1,'processes/mission.task.png','1','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0M\0\0Y\0\0\0D�Ĉ\0\0�IDATx����o�u�p.��?������s�Ź����N�JS	U���UR�AcH�M6&&�	��nG`�ZZ���B��9��0,[m���~��������>�W�	�S�<�����<�̂\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0� I�������vvv&�b��x:::�����i�\rSِ!�!�!�����Hz{{�r������9��ׯ\'G���2�0iφɐɐ��d�ş�X$�Y(��b�l��gC�dH�dH�LV2��j_�陰L�dä=2$C2$C2d��!�5�E��e�ȆI{6dH�dH�d�d%C�H��o��$g:��O���1@i�\rO42$C2$C2d�&2_�n\r��Ӈ�$�l��ď��,��&��D#C2$C2$CFiBi\ns��_X$��|���pi�\rO42$C2$C2d�&��0g?�9�2��Y�-M��F�dH�dH��҄��tq��$>f	d�4Ɇ\'\Z�!�!2JJ�e�4ɆlȐɐ�!�4�4M�x���I|��ni�\rO42$C2$C2d�&��0��q�e��[�d��ɐɐ�	�)̍Rr�pۃ�����c�@vK�lx��!�!�!�4�4ݛ���e?fxs[��D#C2$C2$CFiBi�};9�O����Y.M��F�dH�dH���D�KS|\'�sG�0嵾�1��$�hdH�dH�d�(Md�4ݾ���J�v��S.���ω��1)M��F�dH�dH���D�K�����Oc�[�dC6dH�dH�dH�&��0�S��~\Zc)���$�!C2$C2$C��4�4�y�ERKa��&ِ\r�!�!��	��X&�!2$C2dd��X&��lȆɐ22��e\"�!CF�����!�L,ِ\r��Ȑ�!�!fE�$����oݽ{��;v�\\�v�Xsss��А455���/����;w���ߕ&�4ِ!�!�!�4e�,}��G����c�֭K�{､��/)�J���H�_��rr���$����_��W^��jժ�J�Q��\'\Z�!�!2JӼ�Q�o�q{ӦM��Ν;�����/�͛7�imm=�|��_+MFi2�hdH�dH�d�(M�����O>���^H����,Mt������ex��u�L,ِ\r�!22ddHaZ�����k֬IΝ;�̄�/&��\r�\\��wJ�Q��\'\Z�!�!2JS]�g�ba��Q�I��[�jխ|>ߤ4��x��!�!�!�4ե�\Z�xI�L�a���s�=7��J�Q��\'\Z�!�!2JS�]���m۶���0ͦ\n��J�Q��\'\Z�!�!2JS]ٿ�Ż�����l{饗���ez��e\"�!C2$CF��e�,S|�x[�Z8u��h��m�L,ِ\r�!22dd(����[��~ɭ�UKK�Ն���i9�|��?,�D6dC��22�v��}����Oji׮]_�Ҵ1-� �]�8q��r��,�D6dC�dH���;v����ii:v�����۞�eR5�N��$��I6dC�dH���)�֮];688X��t���r�����er�\'2�K�2Q�dC6dH�d�ȐQ�2���9�ii�����:��eR��x:�2Q�dC6dH�d�ȐQ�2(~�̅��N�X&�\Z�0��\r�!�!2J�<�bŊk}�ixx�j��i:���.Y�d����4ɆlȐɐ�!�4eԚ5kFk���+W��=�i��I뵾�4����&ِ\r�!�!�!�)k�l�r��w�;t������y������H���t���3V�dC6dH�dH�dH����z��߯��4���H��4M���2�\rِ!�!�!R�X��k����ի�޹s�f7�kll�����ގ�eb�ȆlȐɐɐ�PF�_���N�<Y�K�����[���2�LdC6dH�dH�dH�d(�����6l��٦����/��|��d�(M��F�dH�dH�dHi�+�������ژ���Y�����2�L�&��͊ɐɐ��_c���2|�ܹY)L�������`>��^��[q��lȆɐɐɐe\\SSS�����r�<�����˟766~U���u�x�7���f�Ȑɐ�s�P(��Z���L�q�g�ba��r����X&��lȆɐ22ĸPp\Z���n~�������C���;�K��4χ�b�X&�!2$C2dd�����8566v���^��/��}�>�7�����\Z&��2�\rِ!�!#CF�x��,������;�|���_�J������4<<|�ʕ+�����[�~Z(bY�g���.y��e\"�!C2$CF����BZ���ׅ2�/̅0#a�{�^\n�fc<C5_��eb�ȆlȐɐ�!#C`�X&�!2$C2dd��X&��lȆ�bd�Ȑ�X&��lȆ�bd�Ȑ�X&��l߬�!�!��(M�7+F�dH�dH��21J��͊�!�!2JJ�Q��\'\Z�!�!2JJ�Q��lȐɐɐQ�P��e\"�!C2$CF���eb�ȆlȐɐ�!#C`�X&�!2dd�Ȑ;��2�\rٰ_��!��2�\r�#CF�dH��21J��͊�!�!�!�L��d|�bdH�dH�d,�4O42$C2$C2d�&�&�4O42$C2$C2d�&�&�4�7�\r�!22d�&�&_Ė�lȆɐ22��e\"�!C2$CF���eb�Ȇl�/F��ɐ������E��	�dL6Lڳ!C2$C2$C&+�q===��r�r\n�T*�9,���aҞ\r�!�!2Y������mww�7׮]�=w?y������0�dä=2$C2$C2d��!�/xih�\'�)�x������~6��D6dC�dH�dH��~\Z\Z\Zd\0\0`*�49\n\0\0\0J\0\0��\0\0�4\0\0(M\0\0\0J\0\0��\0\0�4\0\0(M\0\0\0J\0\0\0J\0\0��\0\0�4\0\0(M\0\0\0J\0\0��\0\0�4\0\0(M\0\0\0J\0\0��\0\0��\0\0�4\0\0(M\0\0\0J\0\0��\0\0�4\0\0(M\0\0\0J\0\0��\0\0��\0\0�4\0\0(M\0\0\0J\0\0��\0\0�4\0\0(M\0\0\0J\0\0��\0\0�4\0\0(H�$�̜p�\0\0����\'ÌMW�r��RG\n\0\0�rq�t��t|ɒ%%\0\0 ˥�ɩJS>��\0\0��_�t�Y&\0\0�����k�\0\0\0�����Y&\0\0��K�SU�e��#\0\00A�M�2\0\0L^����H\0\0\03.I�������vvv&�b��x:::�����i�H\0\0H�X�z{{�r������9��ׯ\'G��\n�2�\0��g�����b�xV*\0 E�%y\nKz&��1�\0����QVRU���\0\0�4}��`2p��LǶ��?��(M\0\0���tk���>�%9u`�O&~,>��(M\0\0���t��_(L��|�]�Q�\0\0 ۥ��g;�,M�1eGi\0�L���ŭS������4\0�Ҥ4)M\0\0�4M>�nyS������4\0@�K�����4�ǔ�	\0\02]�n���Ӈ��4/|,>��(M\0\0�����_?|�4ŏ):J\0\0(M�o\'����K����cʎ�\0\0�-M��Jɹ���5M��9\n��\0\0�*M�o\'�绒������2�s��:�4\0@&J�ϝ]r�Ii\0�L���9�4�Y\'�Gi\0�y]��0UF�Q�\0\0`^�&�4\0\0J��\0\0(MJ\0\0�4)M\0\0�\'�BaQ.�[��а/��0��$aF�\\���n���h)MJ\0\0����S3z�$=�|>���S��&\0\0�P|��s���dӻ|��_;�J��\0�����\Z\Z�Y]�\n�B��o&]]]��_�|��I����\'�R)9z�h�k׮��g��X�n9�4)M\0\0̧´4��;�eiϞ=I�\\N��������W]����U��&\0\0�05T���׏�Uz��mڴibqr�IiR�\0\0�O�5L՗䵵�ݿ�q�K��o�>�R�\'m�Ii\0����Q}�����4�S���4)M\0\0ԕx[���0=�%y�]�W�\Z\'��)MJ\0\0�V���Bo�0����l�Ҥ4\0P\n�¢���٠7n�Ji�w՛p;��S���cO�r���u�&�	\0�9���J�y뭷���ǩ�4m��,�i3?ǿ�Ҥ4\00�B9�W)2��ݳZ���V�����Re��(MJ\0\0i(M�+%e�o\01Q�T�.M�r��S�2��eIiR��&\0\0�T�nUJ�L�f|�ۏW���S�%�IiR�\0\0HSi�_Rja��dm��	\0�ڔ��:�4��3��g���3M�Ι&�	\0�ڕ�9{MS����߻Ii����J�N�W�\0\0���4�wϫ�w�Wi���4��f�q�	\0�Y���i��w���Ii\0`�\n�E��؅�Nnܸ1+�ihh(ijj���4-v��&�	\0����狕2�gϞY)M{��>���+MJ\0\0�T����x�i�o������g�����QW��&\0\0�J(3�UJ����g����6�6l�S}�iɒ%q�Ii\0��J��0�+妭���X��o�^�:�[�|�	G{~��n9\0�|���\Z*7���qz�K���p��ey�4ys[�	\0 3B�i�.N�5N����w{��xӇ��0�	�l���4)M\0\0��S�����S|����,R�ҽx	^�T\Z��w�}7Y�b����/ɋE�QU��&\0\0��\Z��[�?��z\r�Ҥ4\00��Ӳ{�i�Q�R<��.yJ��\0@f\n�E�<�eh_�aF����0�a6�3T��Ҥ4\0\0J�Q�\0\0@i2J\0\0(MFi\0\0��(M\0\0�4�	\0\0P��&\0\0@iR�\0\0\0�Ii\0\0�&�	\0\0P��&\0\0@i2J\0\0(MFi\0\0��(M\0\0�4�	\0\0�&�4\0\0J��\0\0(MJ\0\0�4)M\0\0�Ҥ4\0\0J�Q�\0\0@i2J\0\0ԛ��Ne%=3JӘT\0@������e�%S*��J�Y�\0�����mww�7׮]V\\��S,L_�Y&�\0\0�2����b�D�4,����|�q?�0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\00����AJ�Hc\0\0\0\0IEND�B`�',1);

/*Table structure for table `act_ge_property` */

DROP TABLE IF EXISTS `act_ge_property`;

CREATE TABLE `act_ge_property` (
  `NAME_` varchar(64) COLLATE utf8_bin NOT NULL,
  `VALUE_` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  PRIMARY KEY (`NAME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ge_property` */

insert  into `act_ge_property`(`NAME_`,`VALUE_`,`REV_`) values 
('cfg.execution-related-entities-count','false',1),
('cfg.task-related-entities-count','false',1),
('common.schema.version','6.2.0.0',1),
('identitylink.schema.version','6.2.0.0',1),
('job.schema.version','6.2.0.0',1),
('next.dbid','2501',2),
('schema.history','create(6.2.0.0)',1),
('schema.version','6.2.0.0',1),
('task.schema.version','6.2.0.0',1),
('variable.schema.version','6.2.0.0',1);

/*Table structure for table `act_hi_actinst` */

DROP TABLE IF EXISTS `act_hi_actinst`;

CREATE TABLE `act_hi_actinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT 1,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin NOT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CALL_PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ACT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime NOT NULL,
  `END_TIME_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_ACT_INST_START` (`START_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_PROCINST` (`PROC_INST_ID_`,`ACT_ID_`),
  KEY `ACT_IDX_HI_ACT_INST_EXEC` (`EXECUTION_ID_`,`ACT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_actinst` */

/*Table structure for table `act_hi_attachment` */

DROP TABLE IF EXISTS `act_hi_attachment`;

CREATE TABLE `act_hi_attachment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `URL_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CONTENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_attachment` */

/*Table structure for table `act_hi_comment` */

DROP TABLE IF EXISTS `act_hi_comment`;

CREATE TABLE `act_hi_comment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime NOT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `MESSAGE_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `FULL_MSG_` longblob DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_comment` */

/*Table structure for table `act_hi_detail` */

DROP TABLE IF EXISTS `act_hi_detail`;

CREATE TABLE `act_hi_detail` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TIME_` datetime NOT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_DETAIL_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_ACT_INST` (`ACT_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_TIME` (`TIME_`),
  KEY `ACT_IDX_HI_DETAIL_NAME` (`NAME_`),
  KEY `ACT_IDX_HI_DETAIL_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_detail` */

/*Table structure for table `act_hi_identitylink` */

DROP TABLE IF EXISTS `act_hi_identitylink`;

CREATE TABLE `act_hi_identitylink` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` datetime DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_TASK` (`TASK_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_identitylink` */

/*Table structure for table `act_hi_procinst` */

DROP TABLE IF EXISTS `act_hi_procinst`;

CREATE TABLE `act_hi_procinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT 1,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `START_TIME_` datetime NOT NULL,
  `END_TIME_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `END_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CALLBACK_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CALLBACK_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `PROC_INST_ID_` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PRO_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_PRO_I_BUSKEY` (`BUSINESS_KEY_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_procinst` */

/*Table structure for table `act_hi_taskinst` */

DROP TABLE IF EXISTS `act_hi_taskinst`;

CREATE TABLE `act_hi_taskinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT 1,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `SCOPE_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUB_SCOPE_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SCOPE_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SCOPE_DEFINITION_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime NOT NULL,
  `CLAIM_TIME_` datetime DEFAULT NULL,
  `END_TIME_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `DUE_DATE_` datetime DEFAULT NULL,
  `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `LAST_UPDATED_TIME_` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_TASK_SCOPE` (`SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_HI_TASK_SUB_SCOPE` (`SUB_SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_HI_TASK_SCOPE_DEF` (`SCOPE_DEFINITION_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_HI_TASK_INST_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_taskinst` */

/*Table structure for table `act_hi_varinst` */

DROP TABLE IF EXISTS `act_hi_varinst`;

CREATE TABLE `act_hi_varinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT 1,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `SCOPE_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUB_SCOPE_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SCOPE_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` datetime DEFAULT NULL,
  `LAST_UPDATED_TIME_` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_PROCVAR_NAME_TYPE` (`NAME_`,`VAR_TYPE_`),
  KEY `ACT_IDX_HI_VAR_SCOPE_ID_TYPE` (`SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_HI_VAR_SUB_ID_TYPE` (`SUB_SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_HI_PROCVAR_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PROCVAR_TASK_ID` (`TASK_ID_`),
  KEY `ACT_IDX_HI_PROCVAR_EXE` (`EXECUTION_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_varinst` */

/*Table structure for table `act_id_bytearray` */

DROP TABLE IF EXISTS `act_id_bytearray`;

CREATE TABLE `act_id_bytearray` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `BYTES_` longblob DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_id_bytearray` */

/*Table structure for table `act_id_group` */

DROP TABLE IF EXISTS `act_id_group`;

CREATE TABLE `act_id_group` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_id_group` */

/*Table structure for table `act_id_info` */

DROP TABLE IF EXISTS `act_id_info`;

CREATE TABLE `act_id_info` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `VALUE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PASSWORD_` longblob DEFAULT NULL,
  `PARENT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_id_info` */

/*Table structure for table `act_id_membership` */

DROP TABLE IF EXISTS `act_id_membership`;

CREATE TABLE `act_id_membership` (
  `USER_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `GROUP_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`USER_ID_`,`GROUP_ID_`),
  KEY `ACT_FK_MEMB_GROUP` (`GROUP_ID_`),
  CONSTRAINT `ACT_FK_MEMB_GROUP` FOREIGN KEY (`GROUP_ID_`) REFERENCES `act_id_group` (`ID_`),
  CONSTRAINT `ACT_FK_MEMB_USER` FOREIGN KEY (`USER_ID_`) REFERENCES `act_id_user` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_id_membership` */

/*Table structure for table `act_id_priv` */

DROP TABLE IF EXISTS `act_id_priv`;

CREATE TABLE `act_id_priv` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_id_priv` */

/*Table structure for table `act_id_priv_mapping` */

DROP TABLE IF EXISTS `act_id_priv_mapping`;

CREATE TABLE `act_id_priv_mapping` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PRIV_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_PRIV_MAPPING` (`PRIV_ID_`),
  KEY `ACT_IDX_PRIV_USER` (`USER_ID_`),
  KEY `ACT_IDX_PRIV_GROUP` (`GROUP_ID_`),
  CONSTRAINT `ACT_FK_PRIV_MAPPING` FOREIGN KEY (`PRIV_ID_`) REFERENCES `act_id_priv` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_id_priv_mapping` */

/*Table structure for table `act_id_property` */

DROP TABLE IF EXISTS `act_id_property`;

CREATE TABLE `act_id_property` (
  `NAME_` varchar(64) COLLATE utf8_bin NOT NULL,
  `VALUE_` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  PRIMARY KEY (`NAME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_id_property` */

insert  into `act_id_property`(`NAME_`,`VALUE_`,`REV_`) values 
('schema.version','6.2.0.0',1);

/*Table structure for table `act_id_token` */

DROP TABLE IF EXISTS `act_id_token`;

CREATE TABLE `act_id_token` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TOKEN_VALUE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TOKEN_DATE_` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `IP_ADDRESS_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_AGENT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TOKEN_DATA_` varchar(2000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_id_token` */

/*Table structure for table `act_id_user` */

DROP TABLE IF EXISTS `act_id_user`;

CREATE TABLE `act_id_user` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `FIRST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LAST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EMAIL_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PWD_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PICTURE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_id_user` */

/*Table structure for table `act_procdef_info` */

DROP TABLE IF EXISTS `act_procdef_info`;

CREATE TABLE `act_procdef_info` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `INFO_JSON_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_INFO_PROCDEF` (`PROC_DEF_ID_`),
  KEY `ACT_IDX_INFO_PROCDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_INFO_JSON_BA` (`INFO_JSON_ID_`),
  CONSTRAINT `ACT_FK_INFO_JSON_BA` FOREIGN KEY (`INFO_JSON_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_INFO_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_procdef_info` */

/*Table structure for table `act_re_deployment` */

DROP TABLE IF EXISTS `act_re_deployment`;

CREATE TABLE `act_re_deployment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `DEPLOY_TIME_` timestamp NULL DEFAULT NULL,
  `ENGINE_VERSION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_re_deployment` */

insert  into `act_re_deployment`(`ID_`,`NAME_`,`CATEGORY_`,`KEY_`,`TENANT_ID_`,`DEPLOY_TIME_`,`ENGINE_VERSION_`) values 
('1','任务流程',NULL,NULL,'','2018-12-13 20:36:52',NULL);

/*Table structure for table `act_re_model` */

DROP TABLE IF EXISTS `act_re_model`;

CREATE TABLE `act_re_model` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_TIME_` timestamp NULL DEFAULT NULL,
  `VERSION_` int(11) DEFAULT NULL,
  `META_INFO_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_EXTRA_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_MODEL_SOURCE` (`EDITOR_SOURCE_VALUE_ID_`),
  KEY `ACT_FK_MODEL_SOURCE_EXTRA` (`EDITOR_SOURCE_EXTRA_VALUE_ID_`),
  KEY `ACT_FK_MODEL_DEPLOYMENT` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_MODEL_DEPLOYMENT` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE` FOREIGN KEY (`EDITOR_SOURCE_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE_EXTRA` FOREIGN KEY (`EDITOR_SOURCE_EXTRA_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_re_model` */

/*Table structure for table `act_re_procdef` */

DROP TABLE IF EXISTS `act_re_procdef`;

CREATE TABLE `act_re_procdef` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VERSION_` int(11) NOT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DGRM_RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `HAS_START_FORM_KEY_` tinyint(4) DEFAULT NULL,
  `HAS_GRAPHICAL_NOTATION_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `ENGINE_VERSION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_PROCDEF` (`KEY_`,`VERSION_`,`TENANT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_re_procdef` */

insert  into `act_re_procdef`(`ID_`,`REV_`,`CATEGORY_`,`NAME_`,`KEY_`,`VERSION_`,`DEPLOYMENT_ID_`,`RESOURCE_NAME_`,`DGRM_RESOURCE_NAME_`,`DESCRIPTION_`,`HAS_START_FORM_KEY_`,`HAS_GRAPHICAL_NOTATION_`,`SUSPENSION_STATE_`,`TENANT_ID_`,`ENGINE_VERSION_`) values 
('task:1:4',1,'http://www.flowable.org/processdef','项目任务流程定义','task',1,'1','processes/mission.bpmn20.xml','processes/mission.task.png',NULL,0,1,1,'',NULL);

/*Table structure for table `act_ru_deadletter_job` */

DROP TABLE IF EXISTS `act_ru_deadletter_job`;

CREATE TABLE `act_ru_deadletter_job` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp NULL DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_DEADLETTER_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  KEY `ACT_FK_DEADLETTER_JOB_EXECUTION` (`EXECUTION_ID_`),
  KEY `ACT_FK_DEADLETTER_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
  KEY `ACT_FK_DEADLETTER_JOB_PROC_DEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_DEADLETTER_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_DEADLETTER_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_DEADLETTER_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_DEADLETTER_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_deadletter_job` */

/*Table structure for table `act_ru_event_subscr` */

DROP TABLE IF EXISTS `act_ru_event_subscr`;

CREATE TABLE `act_ru_event_subscr` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `EVENT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EVENT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTIVITY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CONFIGURATION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATED_` timestamp NOT NULL DEFAULT current_timestamp(),
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EVENT_SUBSCR_CONFIG_` (`CONFIGURATION_`),
  KEY `ACT_FK_EVENT_EXEC` (`EXECUTION_ID_`),
  CONSTRAINT `ACT_FK_EVENT_EXEC` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_event_subscr` */

/*Table structure for table `act_ru_execution` */

DROP TABLE IF EXISTS `act_ru_execution`;

CREATE TABLE `act_ru_execution` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_EXEC_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ROOT_PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `IS_ACTIVE_` tinyint(4) DEFAULT NULL,
  `IS_CONCURRENT_` tinyint(4) DEFAULT NULL,
  `IS_SCOPE_` tinyint(4) DEFAULT NULL,
  `IS_EVENT_SCOPE_` tinyint(4) DEFAULT NULL,
  `IS_MI_ROOT_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `CACHED_ENT_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LOCK_TIME_` timestamp NULL DEFAULT NULL,
  `IS_COUNT_ENABLED_` tinyint(4) DEFAULT NULL,
  `EVT_SUBSCR_COUNT_` int(11) DEFAULT NULL,
  `TASK_COUNT_` int(11) DEFAULT NULL,
  `JOB_COUNT_` int(11) DEFAULT NULL,
  `TIMER_JOB_COUNT_` int(11) DEFAULT NULL,
  `SUSP_JOB_COUNT_` int(11) DEFAULT NULL,
  `DEADLETTER_JOB_COUNT_` int(11) DEFAULT NULL,
  `VAR_COUNT_` int(11) DEFAULT NULL,
  `ID_LINK_COUNT_` int(11) DEFAULT NULL,
  `CALLBACK_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CALLBACK_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EXEC_BUSKEY` (`BUSINESS_KEY_`),
  KEY `ACT_IDC_EXEC_ROOT` (`ROOT_PROC_INST_ID_`),
  KEY `ACT_FK_EXE_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_EXE_PARENT` (`PARENT_ID_`),
  KEY `ACT_FK_EXE_SUPER` (`SUPER_EXEC_`),
  KEY `ACT_FK_EXE_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_EXE_PARENT` FOREIGN KEY (`PARENT_ID_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE,
  CONSTRAINT `ACT_FK_EXE_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_EXE_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ACT_FK_EXE_SUPER` FOREIGN KEY (`SUPER_EXEC_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_execution` */

/*Table structure for table `act_ru_history_job` */

DROP TABLE IF EXISTS `act_ru_history_job`;

CREATE TABLE `act_ru_history_job` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `LOCK_EXP_TIME_` timestamp NULL DEFAULT NULL,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `ADV_HANDLER_CFG_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp NULL DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_history_job` */

/*Table structure for table `act_ru_identitylink` */

DROP TABLE IF EXISTS `act_ru_identitylink`;

CREATE TABLE `act_ru_identitylink` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_IDENT_LNK_GROUP` (`GROUP_ID_`),
  KEY `ACT_IDX_ATHRZ_PROCEDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_TSKASS_TASK` (`TASK_ID_`),
  KEY `ACT_FK_IDL_PROCINST` (`PROC_INST_ID_`),
  CONSTRAINT `ACT_FK_ATHRZ_PROCEDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_IDL_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TSKASS_TASK` FOREIGN KEY (`TASK_ID_`) REFERENCES `act_ru_task` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_identitylink` */

/*Table structure for table `act_ru_job` */

DROP TABLE IF EXISTS `act_ru_job`;

CREATE TABLE `act_ru_job` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `LOCK_EXP_TIME_` timestamp NULL DEFAULT NULL,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp NULL DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  KEY `ACT_FK_JOB_EXECUTION` (`EXECUTION_ID_`),
  KEY `ACT_FK_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
  KEY `ACT_FK_JOB_PROC_DEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_job` */

/*Table structure for table `act_ru_suspended_job` */

DROP TABLE IF EXISTS `act_ru_suspended_job`;

CREATE TABLE `act_ru_suspended_job` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp NULL DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_SUSPENDED_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  KEY `ACT_FK_SUSPENDED_JOB_EXECUTION` (`EXECUTION_ID_`),
  KEY `ACT_FK_SUSPENDED_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
  KEY `ACT_FK_SUSPENDED_JOB_PROC_DEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_SUSPENDED_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_SUSPENDED_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_SUSPENDED_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_SUSPENDED_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_suspended_job` */

/*Table structure for table `act_ru_task` */

DROP TABLE IF EXISTS `act_ru_task`;

CREATE TABLE `act_ru_task` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `SCOPE_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUB_SCOPE_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SCOPE_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SCOPE_DEFINITION_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DELEGATION_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `CREATE_TIME_` timestamp NULL DEFAULT NULL,
  `DUE_DATE_` datetime DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CLAIM_TIME_` datetime DEFAULT NULL,
  `IS_COUNT_ENABLED_` tinyint(4) DEFAULT NULL,
  `VAR_COUNT_` int(11) DEFAULT NULL,
  `ID_LINK_COUNT_` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_TASK_CREATE` (`CREATE_TIME_`),
  KEY `ACT_IDX_TASK_SCOPE` (`SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_TASK_SUB_SCOPE` (`SUB_SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_TASK_SCOPE_DEF` (`SCOPE_DEFINITION_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_FK_TASK_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_TASK_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_TASK_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_TASK_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_task` */

/*Table structure for table `act_ru_timer_job` */

DROP TABLE IF EXISTS `act_ru_timer_job`;

CREATE TABLE `act_ru_timer_job` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `LOCK_EXP_TIME_` timestamp NULL DEFAULT NULL,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp NULL DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_TIMER_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  KEY `ACT_FK_TIMER_JOB_EXECUTION` (`EXECUTION_ID_`),
  KEY `ACT_FK_TIMER_JOB_PROCESS_INSTANCE` (`PROCESS_INSTANCE_ID_`),
  KEY `ACT_FK_TIMER_JOB_PROC_DEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_TIMER_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_TIMER_JOB_EXECUTION` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TIMER_JOB_PROCESS_INSTANCE` FOREIGN KEY (`PROCESS_INSTANCE_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TIMER_JOB_PROC_DEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_timer_job` */

/*Table structure for table `act_ru_variable` */

DROP TABLE IF EXISTS `act_ru_variable`;

CREATE TABLE `act_ru_variable` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `SCOPE_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUB_SCOPE_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SCOPE_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_RU_VAR_SCOPE_ID_TYPE` (`SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_IDX_RU_VAR_SUB_ID_TYPE` (`SUB_SCOPE_ID_`,`SCOPE_TYPE_`),
  KEY `ACT_FK_VAR_BYTEARRAY` (`BYTEARRAY_ID_`),
  KEY `ACT_IDX_VARIABLE_TASK_ID` (`TASK_ID_`),
  KEY `ACT_FK_VAR_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_VAR_PROCINST` (`PROC_INST_ID_`),
  CONSTRAINT `ACT_FK_VAR_BYTEARRAY` FOREIGN KEY (`BYTEARRAY_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_variable` */

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
) ENGINE=InnoDB AUTO_INCREMENT=1327 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='字典表';

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
(117,114,'需求评审','demand_audit',2,'2018-12-03 16:19:33','2018-12-13 10:32:49',58,58),
(118,114,'需求设计','demand_design',3,'2018-12-03 16:20:15','2018-12-13 10:30:26',58,58),
(119,114,'需求开发','demand_development',4,'2018-12-03 16:21:12','2018-12-13 10:30:30',58,58),
(120,114,'需求测试','demand_test',5,'2018-12-03 16:21:38','2018-12-13 10:30:40',58,58),
(121,114,'需求验收','demand_check_accept',6,'2018-12-13 10:43:17','2018-12-13 10:44:03',1,1),
(122,114,'需求上线','demand_online',7,'2018-12-03 16:22:51','2018-12-13 10:43:58',58,58),
(123,0,'任务阶段','mission_stage',1,'2018-12-06 15:50:38','2018-12-06 15:50:38',58,58),
(124,123,'任务创建','mission_created',0,'2018-12-06 15:54:47','2018-12-13 13:59:05',58,58),
(126,123,'任务分配','mission_allocation',2,'2018-12-06 15:53:41','2018-12-13 20:59:27',58,58),
(127,123,'任务确认','mission_confirmed',3,'2018-12-06 15:58:03','2018-12-13 20:59:29',58,58),
(128,123,'任务编码','mission_coding',4,'2018-12-06 16:00:34','2018-12-13 20:59:31',58,58),
(129,123,'任务自测','mission_developer_testing',5,'2018-12-06 16:03:25','2018-12-13 20:59:36',58,58),
(130,123,'任务转测','misssion_tester_testing',6,'2018-12-06 16:04:42','2018-12-13 20:59:38',58,58),
(131,123,'等待发布','mission_waiting_online',7,'2018-12-06 16:05:46','2018-12-13 20:59:40',58,58),
(132,0,'服务组件','service_group',2,'2018-12-06 16:08:52','2018-12-13 20:59:42',58,58),
(133,132,'金融','service_crms',0,'2018-12-06 16:10:53','2018-12-14 19:12:46',58,58),
(1323,0,'节点类型','workflow_node_type',4,'2018-12-15 16:09:11','2018-12-15 16:12:59',58,58),
(1324,1323,'串行节点','serial_node',1,'2018-12-15 16:10:05','2018-12-15 16:10:05',58,58),
(1325,1323,'并行节点','parallel_node',2,'2018-12-15 16:10:21','2018-12-15 16:10:21',58,58),
(1326,1323,'网关节点','gateway',3,'2018-12-15 16:10:44','2018-12-15 16:10:44',58,58);

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
) ENGINE=InnoDB AUTO_INCREMENT=254 DEFAULT CHARSET=utf8 COMMENT='菜单表';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`menu_id`,`menu_code`,`menu_pcode`,`menu_pcodes`,`menu_name`,`menu_icon`,`menu_path`,`menu_order`,`menu_is_menu`,`menu_status`,`create_time`,`update_time`,`creator`,`updator`) values 
(1,'system','0','[0],','系统管理','xitong','/system',1,'1','1','2018-11-15 22:54:35','2018-11-28 14:42:23',58,58),
(2,'user','system','[0],[system],','用户管理','user','/system/user',2,'1','1','2018-11-15 22:54:38','2018-11-15 22:54:45',58,58),
(3,'role','system','[0],[0],','角色管理','user','/system/role',1,'1','1','2018-11-15 22:54:40','2018-11-28 14:25:15',58,58),
(4,'menu','system','[0],[system],','菜单管理','form','/system/menu',3,'1','1','2018-11-15 22:54:41','2018-11-15 22:54:49',58,58),
(248,'dict','system','[0],[0],','字典管理','form','/system/dict',4,'1','1','2018-12-01 15:00:32','2018-12-01 15:00:32',58,58),
(249,'task','0','[0],','任务管理','international','/task',1,'1','1','2018-12-03 19:38:14','2018-12-03 19:47:19',58,58),
(250,'demand','task','[0],[0],','需求管理','form','/task/demand',1,'1','1','2018-12-03 19:39:29','2018-12-03 19:47:21',58,58),
(251,'mission','task','[0],[0],','我的待办','form','/task/mission',2,'1','1','2018-12-06 14:06:18','2018-12-06 14:32:17',58,58),
(252,'workflow','0','[0],','流程管理','form','/workflow',3,'1','1','2018-12-14 20:26:07','2018-12-15 09:51:37',58,58),
(253,'workflowNode','workflow','[0],[0],','节点管理','list','/workflow/workflowNode',1,'1','1','2018-12-14 20:27:17','2018-12-14 20:27:17',58,58);

/*Table structure for table `sys_relation` */

DROP TABLE IF EXISTS `sys_relation`;

CREATE TABLE `sys_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4975 DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

/*Data for the table `sys_relation` */

insert  into `sys_relation`(`id`,`menu_id`,`role_id`) values 
(4932,3,6),
(4933,4,6),
(4934,1,6),
(4966,249,1),
(4967,250,1),
(4968,251,1),
(4969,3,1),
(4970,4,1),
(4971,248,1),
(4972,252,1),
(4973,253,1),
(4974,1,1);

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
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 COMMENT='管理员表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`user_avatar`,`user_name`,`user_password`,`user_realName`,`user_birthday`,`user_sex`,`user_email`,`user_phone`,`user_role_id`,`user_dept_id`,`user_status`,`create_time`,`update_time`,`creator`,`updator`) values 
(1,'3f650a31-f0bf-4aab-962d-455157230e36.jpg','admin','ecfadcde9305f8891bcfe5a1e28c253e','管理员','2017-05-04 16:00:00',1,'18751907450@163.com','18200000000',1,24,1,'2016-01-29 08:49:53','2018-10-11 20:16:22',58,58),
(58,NULL,'xiahui','$2a$10$oTYrvK3T8CptNsv/5P..k.PhvdFPWopHEPGJ6MuMFRNnBH1qwWfTa','夏辉','2018-11-13 14:11:06',1,'18751907450@163.com','18200000000',1,24,1,'2018-12-06 21:57:17','2018-12-06 21:57:20',58,58),
(59,NULL,'yuanlinbing','$2a$10$oTYrvK3T8CptNsv/5P..k.PhvdFPWopHEPGJ6MuMFRNnBH1qwWfTa','袁林兵','2018-12-06 21:57:08',1,'18751907450@163.com','18200000000',23,28,1,'2018-12-06 21:58:20','2018-12-06 21:58:22',58,58),
(60,NULL,'hepei','$2a$10$oTYrvK3T8CptNsv/5P..k.PhvdFPWopHEPGJ6MuMFRNnBH1qwWfTa','何沛','2018-12-06 21:58:14',1,'18751907450@163.com','18200000000',11,25,1,'2018-12-06 21:58:18','2018-12-06 21:58:24',58,58),
(61,NULL,'zhangtiejun','$2a$10$oTYrvK3T8CptNsv/5P..k.PhvdFPWopHEPGJ6MuMFRNnBH1qwWfTa','张铁军','2018-12-08 17:33:37',1,'18751907450@163.com','18200000000',24,29,1,'2018-12-08 17:38:12','2018-12-08 17:38:14',58,58),
(62,NULL,'liukuan','$2a$10$oTYrvK3T8CptNsv/5P..k.PhvdFPWopHEPGJ6MuMFRNnBH1qwWfTa','刘宽','2018-12-08 17:33:37',1,'18751907450@163.com','18200000000',11,25,1,'2018-12-13 10:34:53','2018-12-13 10:34:55',1,1);

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='任务表';

/*Data for the table `task_mission` */

insert  into `task_mission`(`mission_id`,`mission_name`,`mission_demand_id`,`mission_group`,`mission_developer`,`mission_tester`,`mission_workdays`,`mission_stage`,`mission_start_date`,`mission_end_date`,`mission_desc`,`create_time`,`update_time`,`creator`,`updator`) values 
(1,'测试',1,'service_crms',60,59,1.5,'mission_allocation','2018-12-05 00:00:00','2018-12-05 00:00:00','测试11','2018-12-06 17:05:24','2018-12-13 19:09:56',58,58),
(2,'测试3',1,'service_crms',60,59,3,'mission_created','2018-12-12 00:00:00','2018-12-14 00:00:00','333','2018-12-12 17:44:11','2018-12-12 19:14:02',58,58),
(3,'测试3-任务一',3,'service_crms',60,59,4,'mission_created','2018-12-12 00:00:00','2018-12-14 00:00:00','测试333','2018-12-12 21:06:08','2018-12-12 21:06:08',58,58),
(4,'测试2-任务1',2,'service_crms',60,59,5,'mission_created','2018-12-13 00:00:00','2018-12-18 00:00:00','测试2-任务1','2018-12-13 10:29:15','2018-12-13 10:29:15',58,58);

/*Table structure for table `workflow_node` */

DROP TABLE IF EXISTS `workflow_node`;

CREATE TABLE `workflow_node` (
  `node_id` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `node_name` varchar(30) NOT NULL COMMENT '节点名称',
  `node_code` varchar(20) NOT NULL COMMENT '节点编码',
  `node_proc_def_id` varchar(30) NOT NULL COMMENT '流程定义id',
  `node_version` varchar(128) DEFAULT NULL COMMENT '节点版本：和流程保持一致',
  `node_order` tinyint(4) NOT NULL COMMENT '节点顺序，越小越靠前',
  `node_can_back_to` char(1) NOT NULL COMMENT '后续节点是否可以回退到该节点',
  `node_can_roll_back` char(1) NOT NULL COMMENT '当前节点是否可以做回退操作 1：可以 0：不可以',
  `node_type` varchar(48) NOT NULL COMMENT '1：串行节点 2：并行节点 3：网关分支',
  `node_desc` varchar(216) DEFAULT NULL COMMENT '节点描述',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp() COMMENT '修改时间',
  `creator` int(11) DEFAULT NULL COMMENT '创建者',
  `updator` int(11) DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`node_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `workflow_node` */

insert  into `workflow_node`(`node_id`,`node_name`,`node_code`,`node_proc_def_id`,`node_version`,`node_order`,`node_can_back_to`,`node_can_roll_back`,`node_type`,`node_desc`,`create_time`,`update_time`,`creator`,`updator`) values 
(1,'测试','test','1','1',1,'1','1','serial_node','测试','2018-12-15 10:49:40','2018-12-15 16:20:45',58,58);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
