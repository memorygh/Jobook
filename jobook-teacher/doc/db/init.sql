# 创建数据库，并创建权限用户
CREATE DATABASE `jobook` CHARACTER SET utf8;
# CREATE USER 'root'@'%' IDENTIFIED BY 'root';
# GRANT ALL PRIVILEGES ON root.* TO 'root'@'%';
# FLUSH PRIVILEGES;


# 创建表
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名',
  `user_pwd` varchar(32) DEFAULT NULL COMMENT '密码',
  `sex` varchar(1) DEFAULT NULL COMMENT '性别',
  `phone` varchar(12) DEFAULT NULL COMMENT '手机',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# 创建表数据

insert  into `sys_user`(`id`,`user_name`,`user_pwd`,`sex`) values (1,'admin','e10adc3949ba59abbe56e057f20f883e','0','15101045301');
insert  into `sys_user`(`id`,`user_name`,`user_pwd`,`sex`) values (2,'zhangsan','e10adc3949ba59abbe56e057f20f883e','0','15101045301');


