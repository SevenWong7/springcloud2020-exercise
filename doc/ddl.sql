
-- 支付表 (Author: SevenWong; Date: 2021-01-07 16:38:28)
create table payment(
    id bigint(20) not null auto_increment,
    serial varchar(200) default '',
    primary key (id)
) comment '支付表';