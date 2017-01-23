DROP DATABASE blogdb;

CREATE DATABASE blogdb;

USE blogdb;

-- 用户表
CREATE TABLE sys_user (
	-- 主键、自增、用于 用户信息的唯一标识
	user_id INT(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
	-- 用户登录和密码
	user_login_name VARCHAR (100) NOT NULL COMMENT '登录名',
	user_password VARCHAR (100) NOT NULL COMMENT '密码',
	-- 用户信息
	user_name VARCHAR (100) COMMENT '网名',
	user_career VARCHAR (100) COMMENT '职业',
	user_email VARCHAR (200) COMMENT '邮箱',
	user_phone VARCHAR (200) COMMENT '电话',
	user_mobile VARCHAR (200) COMMENT '手机',
	user_type VARCHAR (64) COMMENT '用户类型',
	user_photo VARCHAR (1000) COMMENT '用户头像',
	-- 用户登录信息
	user_login_ip VARCHAR (100) COMMENT '最后登陆IP',
	user_login_date datetime COMMENT '最后登陆时间',
	user_login_flag VARCHAR (64) COMMENT '是否可登录',
	-- 系统默认信息，每张表都保持
	create_by INT(11) COMMENT '创建者',
	create_date datetime COMMENT '创建时间',
	update_by INT(11) COMMENT '更新者',
	update_date datetime COMMENT '更新时间',
	remarks VARCHAR (255) COMMENT '备注信息',
	PRIMARY KEY (user_id)
) COMMENT = '用户表';

-- 关注我常用的网站信息
CREATE TABLE sys_attention (
	attention_id INT (11) AUTO_INCREMENT COMMENT '编号',
	attention_name VARCHAR (100) NOT NULL COMMENT '名称',
	attention_href VARCHAR (2000) COMMENT '链接',
	create_by INT(11) COMMENT '创建者',
	create_date datetime COMMENT '创建时间',
	update_by INT(11) COMMENT '更新者',
	update_date datetime COMMENT '更新时间',
	remarks VARCHAR (255) COMMENT '备注信息',
	PRIMARY KEY (attention_id)
) COMMENT = '关注我';

--  菜单栏
CREATE TABLE sys_menu (
	menu_id INT (11) AUTO_INCREMENT COMMENT '编号',
	menu_parent_id VARCHAR (64) NOT NULL COMMENT '父级编号',
	menu_name VARCHAR (100) NOT NULL COMMENT '名称',
	menu_sort INT (1) NOT NULL COMMENT '排序',
	menu_href VARCHAR (2000) COMMENT '链接',
	menu_target VARCHAR (20) COMMENT '目标',
	menu_icon VARCHAR (100) COMMENT '图标',
	is_show CHAR (1) NOT NULL COMMENT '是否在菜单中显示',
	create_by INT(11) COMMENT '创建者',
	create_date datetime NOT NULL COMMENT '创建时间',
	update_by INT(11) COMMENT '更新者',
	update_date datetime  COMMENT '更新时间',
	remarks VARCHAR (255) COMMENT '备注信息',
	PRIMARY KEY (menu_id)
) COMMENT = '菜单表';

--  标签云
--  将标签云提取出来，随机显示标签或者显示权重最高的标签等等
CREATE TABLE sys_label (
	label_id INT (11) AUTO_INCREMENT COMMENT '编号',
	label_name VARCHAR (100) NOT NULL COMMENT '名称',
	label_sort INT (1) NOT NULL COMMENT '排序',
	label_color VARCHAR (2000) COMMENT '颜色',
	is_show CHAR (1) NOT NULL COMMENT '是否显示',
	create_by INT(11) COMMENT '创建者',
	create_date datetime  COMMENT '创建时间',
	update_by INT(11) COMMENT '更新者',
	update_date datetime  COMMENT '更新时间',
	remarks VARCHAR (255) COMMENT '备注信息',
	PRIMARY KEY (label_id)
) COMMENT = '标签云';

-- 技术分类
CREATE TABLE cms_category (
	category_id INT (11) AUTO_INCREMENT COMMENT '编号',
	category_name VARCHAR (100) NOT NULL COMMENT '栏目名称',
	category_description VARCHAR (255) COMMENT '描述',
	category_allow_comment CHAR (1) COMMENT '是否允许评论',
	create_by INT(11) COMMENT '创建者',
	create_date datetime COMMENT '创建时间',
	update_by INT(11) COMMENT '更新者',
	update_date datetime COMMENT '更新时间',
	remarks VARCHAR (255) COMMENT '备注信息',
	PRIMARY KEY (category_id)
) COMMENT = '栏目表';

-- 文章
CREATE TABLE cms_article (
	article_id INT (11) AUTO_INCREMENT COMMENT '编号',
	category_id INT (11) NOT NULL COMMENT '分类编号',
	-- 外键关联cms_category
	article_title VARCHAR (255) NOT NULL COMMENT '标题',
	article_link VARCHAR (255) COMMENT '文章链接',
	article_color VARCHAR (50) COMMENT '标题颜色',
	article_image VARCHAR (255) COMMENT '文章图片',
	article_keywords VARCHAR (255) COMMENT '关键字',
	article_desc VARCHAR (255) COMMENT '描述、摘要',
	article_weight INT DEFAULT 0 COMMENT '权重，越大越靠前',
	article_weight_date datetime COMMENT '权重期限',
	comments INT DEFAULT 0 COMMENT '评论数',
	hits INT DEFAULT 0 COMMENT '点击数',
	create_by INT(11) COMMENT '创建者',
	create_date datetime COMMENT '创建时间',
	update_by INT(11) COMMENT '更新者',
	update_date datetime COMMENT '更新时间',
	remarks VARCHAR (255) COMMENT '备注信息',
	PRIMARY KEY (article_id)
) COMMENT = '文章表';

-- 文章详表
CREATE TABLE cms_article_data (
	content_id INT (11) AUTO_INCREMENT COMMENT '编号',
	article_id INT (11) NOT NULL COMMENT '文章id',
	content_data text COMMENT '文章内容',
	content_copyfrom VARCHAR (255) COMMENT '文章来源',
	content_relation VARCHAR (255) COMMENT '相关文章',
	allow_comment CHAR (1) COMMENT '是否允许评论',
	PRIMARY KEY (content_id)
) COMMENT = '文章详表';

-- 评论表
CREATE TABLE cms_comment (
	comment_id INT (11) AUTO_INCREMENT COMMENT '编号',
	category_id INT (11) NOT NULL COMMENT '栏目编号',
	content_id INT (11) NOT NULL COMMENT '栏目内容的编号',
	comment_title VARCHAR (255) COMMENT '栏目内容的标题',
	comment_content VARCHAR (255) COMMENT '评论内容',
	comment_name VARCHAR (100) COMMENT '评论姓名',
	-- 评论人姓名，可以匿名
	comment_ip VARCHAR (100) COMMENT '评论IP',
	create_date datetime  COMMENT '评论时间',
	PRIMARY KEY (comment_id)
) COMMENT = '评论表';

-- 留言板  ----暂时空缺，待补
CREATE TABLE cms_guestbook (
	id INT (11) AUTO_INCREMENT COMMENT '编号',
	type CHAR (1) NOT NULL COMMENT '留言分类',
	content VARCHAR (255) NOT NULL COMMENT '留言内容',
	NAME VARCHAR (100) NOT NULL COMMENT '姓名',
	email VARCHAR (100) NOT NULL COMMENT '邮箱',
	phone VARCHAR (100) NOT NULL COMMENT '电话',
	workunit VARCHAR (100) NOT NULL COMMENT '单位',
	ip VARCHAR (100) NOT NULL COMMENT 'IP',
	create_date datetime  COMMENT '留言时间',
	re_user_id VARCHAR (64) COMMENT '回复人',
	re_date datetime COMMENT '回复时间',
	re_content VARCHAR (100) COMMENT '回复内容',
	PRIMARY KEY (id)
) COMMENT = '留言板';