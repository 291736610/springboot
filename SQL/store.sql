#建表前指定数据库，如果要覆盖重名或删除，创建前要先删除。
#DROP DATABASE IF EXISTS `db1`;
#CREATE DATABASE `db1`;

USE `store1`;

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`(
`id` INT AUTO_INCREMENT ,
`username` VARCHAR(50) UNIQUE COMMENT '用户名',
`password` VARCHAR(50) NOT NULL COMMENT '密码',
`phone` VARCHAR(32) NOT NULL COMMENT '手机号码',
`email` VARCHAR(50) NOT NULL COMMENT '邮箱',
`image` VARCHAR(100) COMMENT '邮箱',
`gender` INT(1) COMMENT '邮箱',
`created_user` VARCHAR(50) COMMENT '邮箱', 
`created_time` DATE COMMENT '邮箱',
`modified_user` VARCHAR(50) COMMENT '邮箱',
`modified_time` DATE COMMENT '邮箱',
PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


