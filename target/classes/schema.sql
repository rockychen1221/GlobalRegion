DROP TABLE IF EXISTS d_area;

CREATE TABLE d_area
(
  vc_area_id varchar(200) DEFAULT NULL COMMENT '省市ID',
  vc_area_name varchar(200) DEFAULT NULL COMMENT '省市名称',
  l_level int(11) DEFAULT NULL COMMENT '层级'
);


DROP TABLE IF EXISTS sys_lang;

CREATE TABLE sys_lang
(
  l_id int(11) NOT NULL auto_increment COMMENT '主键',
  e_lang_type varchar(50) DEFAULT NULL COMMENT '语言环境',
  vc_name varchar(200) DEFAULT NULL COMMENT '名称',
  vc_code varchar(50) DEFAULT NULL COMMENT '编码 用户真正存储的编码',
  e_type varchar(50) DEFAULT NULL COMMENT '类型',
  e_is_edit varchar(50) DEFAULT NULL COMMENT '是否可编辑',
  vc_remark varchar(4000) DEFAULT NULL
);


