drop database if exists dsdatabase;
create database dsdatabase;
use dsdatabase;
/*管理员*/
create table administrator(
	id int primary key auto_increment,-- （用于唯一标识的）自增编号
	account varchar(32) not null,-- 账号
	password varchar(32) not null,-- 密码
	remark varchar(256)-- 备注
);
/*用户*/
create table user(
	id int primary key auto_increment,-- 自增编号
	username varchar(32) not null,-- 用户名
	password varchar(32) not null,-- 密码
	email varchar(64) not null,-- 邮箱
	phone varchar(16) not null,-- 手机
	remark varchar(256)-- 备注
);
/*购物车*/
create table cart(
	id int primary key auto_increment,-- 自增编号
	user int not null,-- 用户
	product int not null,-- 产品
	price double not null,-- 价格
	buyNumber int not null-- 购买数量
);
/*商家*/
create table store(
	id int primary key auto_increment,-- 商店编号
	account varchar(32) not null,-- 账号
	name varchar(32) not null,-- 商店名称
	password varchar(32) not null,-- 密码
	email varchar(64) not null,-- 邮箱
	phone varchar(16) not null,-- 手机
	remark varchar(256)-- 备注
);
/*商品*/
create table product(
	id int primary key auto_increment,-- 产品编号
	name varchar(32) not null,-- 产品名称
	productClass int not null,-- 产品大类别
	productType int not null,-- 产别具体种类
	remainingNumber int not null,-- 库存数量
	price double not null,-- 产品价格
	introduction varchar(128),-- 产品介绍
	picture varchar(256),-- 产品图片（名称）
	belongStore int,-- 卖家
	state enum('checking','selling','canceled'),-- 产品状态（审核中，售卖中，已下架）
	remark varchar(256)-- 备注
);
/*商品分类（大）*/
create table productClass(
	id int primary key auto_increment,-- 自增编号
	className varchar(32) not null,-- 类名
	remark varchar(256)-- 备注
);
/*商品分类（小）*/
create table productType(
	id int primary key auto_increment,-- 自增编号
	typeName varchar(32) not null,-- 种名
	class int not null,-- 所属类
	remark varchar(256)-- 备注
);
/*订单*/
create table orderForm(
	id int(128) primary key auto_increment,-- 订单编号
	buyer int not null,-- 买家
	seller int not null,-- 卖家
	product int not null,-- 购买产品
	buyNumber int not null,-- 购买数量
	moneyAmount double not null,-- 订单金额
	state enum('pending','confirm','finish','canceled','complain') not null,-- 订单状态（待付款，待发货，已完成，被取消，投诉中）
	remark varchar(256)-- 备注
);
alter table cart add foreign key user_cart_fk(user) references user(id);
alter table cart add foreign key product_cart_fk(product) references product(id);
alter table product add foreign key productClass_product_fk(productClass) references productClass(id);
alter table product add foreign key productType_product_fk(productType) references productType(id);
alter table product add foreign key store_product_fk(belongStore) references store(id);
alter table productType add foreign key productClass_productType_fk(class) references productClass(id);
alter table orderForm add foreign key user_ordeForm_fk(buyer) references user(id);
alter table orderForm add foreign key store_orderForm_fk(seller) references store(id);
alter table orderForm add foreign key product_orderForm_fk(product) references product(id);

insert into administrator(account,password) values('administratorA','aaa');

insert into user(username,password,email,phone) values('userB','aaa','111@123.com','11111111111');

insert into store(account,name,password,email,phone) values('storeC','鸽子店','111','111@qq.com','12345678910');

insert into productClass(className) values
	("animal"),
	("plant"),
	("goods");

insert into productType(typeName,class) values
	("cat",1),
	("dog",1),
	("bird",1),
	("flower",2),
	("grass",2),
	("tree",2),
	("food",3),
	("toy",3),
	("clothes",3);

insert into product(name,productClass,productType,remainingNumber,price,introduction,picture,belongStore,state) values
	("猫 ",1,1,3,1,"一只猫","m.jpg",1,"selling"),
	("狮",1,1,3,2,"这也是猫","s.jpg",1,"selling"),
	("虎",1,1,3,4,"这就是猫","h.jpg",1,"selling"),
	("哈士奇",1,2,3,8,"不是狼","hsq.jpg",1,"selling"),
	("狼",1,2,3,16,"也算狗","l.jpg",1,"selling"),
	("狐狸",1,2,3,32,"猫狗","hl.jpg",1,"selling"),
	("蜂虎",1,3,3,64,"漂亮的国二","fh.jpg",1,"selling"),
	("翠鸟",1,3,3,128,"漂漂亮亮的也是国二","cn.jpg",1,"selling"),
	("喜鹊",1,3,3,256,"喳喳喳","xq.jpg",1,"selling"),
	("桃花",2,4,3,512,"是桃花","th.jpg",1,"selling"),
	("菊花",2,4,3,1024,"是菊花","jh.jpg",1,"selling"),
	("百合",2,4,3,2048,"是百合","bh,jpg",1,"selling"),
	("狗尾巴草",2,5,3,4096,"很像狗尾巴","gwbc.jpg",1,"selling"),
	("蒲公英",2,5,3,8192,"很像蒲公英","pgy.jpg",1,"selling"),
	("艾草",2,5,3,16384,"很像艾草","ac.jpg",1,"selling"),
	("银杏树",2,6,3,32768,"可以吃吧","yxs.jpg",1,"selling"),
	("松树",2,6,3,65536,"不可以吃","ss.jpg",1,"selling"),
	("玫瑰树",3,6,3,131072,"很好吃","mgs.jpg",1,"selling"),
	("面",3,7,3,262144,"包","mt.jpg",1,"selling"),
	("面包",3,7,3,524288,"子","mb.jpg",1,"selling"),
	("包子",3,7,3,1048576,"面","bz.jpg",1,"selling"),
	("积木",3,8,3,2097152,"小学生的玩具","jm.jpg",1,"selling"),
	("变形金刚",3,8,3,4194304,"初中生的玩具","bxjg.jpg",1,"selling"),
	("玩具",3,8,3,8388608,"玩高中生的玩具","wj.jpg",1,"selling"),
	("衬衫",3,9,3,16777216,"？？？","cs.jpg",1,"selling"),
	("裤子",3,9,3,33554432,"九磅","kz.jpg",1,"selling"),
	("裙子",3,9,3,67108864,"十五便士","qz.jpg",1,"checking");
	

insert into cart(user,product,price,buyNumber) values
	(1,1,1,1),
	(1,4,8,2),
	(1,9,256,3),
	(1,16,32768,4),
	(1,25,16777216,5);

insert into orderForm(buyer,seller,product,buyNumber,moneyAmount,state) values
	(1,1,1,1,1,"pending"),
	(1,1,2,3,6,"confirm"),
	(1,1,3,9,36,"finish"),
	(1,1,4,27,216,"canceled"),
	(1,1,5,81,1296,"complain");
