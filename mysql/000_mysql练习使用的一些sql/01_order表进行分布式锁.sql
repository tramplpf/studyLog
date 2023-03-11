create table order (
  id int(11)  not null auto_increment,
  order_no int(11) default null,
  pay_money decimal(10, 2) default null,
  order_status int(4) default null,
  create_date datetime(0) default null,
  delete_flag int(4) default null,
  primary key('id') USING BTREE,
  index 'idx_status' ('status'),
  index 'idx_order' ('order_no')
) ENGINE = InnoDB;


create table 'order' (
  id int(11)  auto_increment,
  order_no int(11),
  order_status int(4),
  create_date datetime(0),
  delete_flag int(4),
  primary key('id') USING BTREE,
  index 'idx_status' ('status'),
  index 'idx_order' ('order_no')
) ENGINE = InnoDB;