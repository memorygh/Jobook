# 创建数据库，并创建权限用户
CREATE DATABASE `jobook` CHARACTER SET utf8;
# CREATE USER 'root'@'%' IDENTIFIED BY 'root';
# GRANT ALL PRIVILEGES ON root.* TO 'root'@'%';
# FLUSH PRIVILEGES;


# 创建表
CREATE TABLE `sys_user` (
  `id` int(20) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_pwd` varchar(50) NOT NULL,
  `sex` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# 创建表数据

insert  into `sys_user`(`id`,`user_name`,`user_pwd`,`sex`) values (1,'admin','e10adc3949ba59abbe56e057f20f883e','0');
insert  into `sys_user`(`id`,`user_name`,`user_pwd`,`sex`) values (1,'zhangsan','e10adc3949ba59abbe56e057f20f883e','0');


