CREATE TABLE `tb_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '��Ȩ��',
  `name` varchar(64) NOT NULL COMMENT 'Ȩ������',
  `enname` varchar(64) NOT NULL COMMENT 'Ȩ��Ӣ������',
  `url` varchar(255) NOT NULL COMMENT '��Ȩ·��',
  `description` varchar(200) DEFAULT NULL COMMENT '��ע',
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COMMENT='Ȩ�ޱ�';
insert  into `tb_permission`(`id`,`parent_id`,`name`,`enname`,`url`,`description`,`created`,`updated`) values
(37,0,'ϵͳ����','System','/',NULL,'2019-04-04 23:22:54','2019-04-04 23:22:56'),
(38,37,'�û�����','SystemUser','/users/',NULL,'2019-04-04 23:25:31','2019-04-04 23:25:33'),
(39,38,'�鿴�û�','SystemUserView','',NULL,'2019-04-04 15:30:30','2019-04-04 15:30:43'),
(40,38,'�����û�','SystemUserInsert','',NULL,'2019-04-04 15:30:31','2019-04-04 15:30:44'),
(41,38,'�༭�û�','SystemUserUpdate','',NULL,'2019-04-04 15:30:32','2019-04-04 15:30:45'),
(42,38,'ɾ���û�','SystemUserDelete','',NULL,'2019-04-04 15:30:48','2019-04-04 15:30:45');

CREATE TABLE `tb_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '����ɫ',
  `name` varchar(64) NOT NULL COMMENT '��ɫ����',
  `enname` varchar(64) NOT NULL COMMENT '��ɫӢ������',
  `description` varchar(200) DEFAULT NULL COMMENT '��ע',
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='��ɫ��';
insert  into `tb_role`(`id`,`parent_id`,`name`,`enname`,`description`,`created`,`updated`) values
(37,0,'��������Ա','admin',NULL,'2019-04-04 23:22:03','2019-04-04 23:22:05');

CREATE TABLE `tb_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL COMMENT '��ɫ ID',
  `permission_id` bigint(20) NOT NULL COMMENT 'Ȩ�� ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='��ɫȨ�ޱ�';
insert  into `tb_role_permission`(`id`,`role_id`,`permission_id`) values
(37,37,37),
(38,37,38),
(39,37,39),
(40,37,40),
(41,37,41),
(42,37,42);

CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '�û���',
  `password` varchar(64) NOT NULL COMMENT '���룬���ܴ洢',
  `phone` varchar(20) DEFAULT NULL COMMENT 'ע���ֻ���',
  `email` varchar(50) DEFAULT NULL COMMENT 'ע������',
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE,
  UNIQUE KEY `phone` (`phone`) USING BTREE,
  UNIQUE KEY `email` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='�û���';
insert  into `tb_user`(`id`,`username`,`password`,`phone`,`email`,`created`,`updated`) values
(37,'admin','$2a$10$9ZhDOBp.sRKat4l14ygu/.LscxrMUcDAfeVOEPiYwbcRkoB09gCmi','15888888888','lee.lusifer@gmail.com','2019-04-04 23:21:27','2019-04-04 23:21:29');

CREATE TABLE `tb_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '�û� ID',
  `role_id` bigint(20) NOT NULL COMMENT '��ɫ ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='�û���ɫ��';
insert  into `tb_user_role`(`id`,`user_id`,`role_id`) values
(37,37,37);