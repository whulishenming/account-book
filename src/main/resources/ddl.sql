CREATE DATABASE IF NOT EXISTS `accountbookdb`;
USE `accountbookdb`;

CREATE TABLE IF NOT EXISTS `t_account_book` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `account_book_id` int(10) unsigned NOT NULL COMMENT '账本id',
  `account_book_name` varchar(50) NOT NULL COMMENT '账本名',
  `is_delete` tinyint(4) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` varchar(100) NOT NULL COMMENT '创建人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user` varchar(100) NOT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  KEY `idx_account_book_id` (`account_book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账本表';

CREATE TABLE IF NOT EXISTS `t_account_record` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `account_book_id` int(10) NOT NULL,
  `record_type` tinyint(4) NOT NULL COMMENT '账目类型，1：支出，2：收入',
  `record_category_id` int(10) NOT NULL COMMENT '所属分类',
  `amount` decimal(19,2) NOT NULL COMMENT '金额',
  `record_year` int(10) NOT NULL COMMENT '账目所属年份',
  `record_month` int(10) NOT NULL COMMENT '账目所属月份',
  `record_day` int(10) NOT NULL COMMENT '账目所属日',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `is_deleted` tinyint(4) NOT NULL,
  `create_user` varchar(100) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(100) NOT NULL COMMENT '更新人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_account_book_id` (`account_book_id`),
  KEY `idx_account_book_id_record_year_month_day` (`account_book_id`,`record_year`,`record_month`,`record_day`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账本账目表';

CREATE TABLE IF NOT EXISTS `t_record_category` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `record_type` tinyint(4) NOT NULL COMMENT '1:支出 2：收入',
  `category_name` varchar(50) NOT NULL COMMENT '分类名',
  `category_seq` int(10) NOT NULL COMMENT '展示顺序',
  `is_delete` tinyint(4) NOT NULL,
  `create_user` varchar(100) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(100) NOT NULL COMMENT '更新人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_create_user` (`create_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账目所属分类';

CREATE TABLE IF NOT EXISTS `t_user_account_book` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_open_id` int(10) NOT NULL DEFAULT '0' COMMENT '用户openid',
  `account_book_id` int(10) NOT NULL DEFAULT '0' COMMENT '账本id',
  `is_default` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否默认账本',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否被删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户账本表';

CREATE TABLE IF NOT EXISTS `t_user_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `open_id` varchar(100) NOT NULL DEFAULT '0' COMMENT '用户openid',
  `nick_name` varchar(100) DEFAULT NULL COMMENT '用户昵称',
  `avatar_url` varchar(100) DEFAULT NULL COMMENT '用户头像',
  `inviter_open_id` varchar(100) DEFAULT NULL COMMENT '邀请人openid',
  `registration_time` datetime NOT NULL COMMENT '注册时间',
  `last_login_time` datetime NOT NULL COMMENT '最近登录时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_open_id` (`open_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

