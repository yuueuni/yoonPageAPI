create table yoonpage.`member` (
  `id` int primary key,
  `username` varchar(255) not null,
  `name` varchar(255) not null,
  `password` varchar(255) not null,
  `phone` varchar(255),
  `created_at` datetime not null default now(),
  `created_by` int,
  `updated_at` datetime on update now(),
  `updated_by` int,
  `expired_at` datetime
);

create table yoonpage.`product_option` (
  `id` int primary key,
  `product_id` int not null,
  `option_id` int not null,
  `created_at` datetime not null default now()
);

create table yoonpage.`product` (
  `id` int primary key,
  `name` varchar(255) not null,
  `price` int not null,
  `discount_type` varchar(255),
  `category_id` int not null,
  `created_at` datetime not null default now(),
  `created_by` int,
  `updated_at` datetime on update now(),
  `updated_by` int
);

create table yoonpage.`discount` (
  `id` int primary key,
  `type` varchar(255) not null,
  `price` int not null default 0,
  `rate` int not null default 0,
  `start` datetime,
  `end` datetime,
  `product_id` int not null,
  `created_at` datetime not null default now(),
  `created_by` int,
  `updated_at` datetime on update now(),
  `updated_by` int
);

create table yoonpage.`stock` (
  `id` int primary key,
  `name` varchar(255) not null,
  `code` varchar(255),
  `quantity` int not null,
  `restocked_at` datetime,
  `status` varchar(255) not null,
  `created_at` datetime not null default now(),
  `created_by` int,
  `updated_at` datetime on update now(),
  `updated_by` int
);

create table yoonpage.`option` (
  `id` int primary key,
  `name` varchar(255) not null,
  `price` int not null default 0,
  `stock_id` int not null,
  `created_at` datetime not null default now(),
  `created_by` int,
  `updated_at` datetime on update now(),
  `updated_by` int
);

create table yoonpage.`category` (
  `id` int primary key,
  `name` varchar(255) not null,
  `target` varchar(255) not null,
  `used` varchar(255) not null,
  `created_at` datetime not null default now(),
  `created_by` int,
  `updated_at` datetime on update now(),
  `updated_by` int
);

create table yoonpage.`delivery` (
  `id` int primary key,
  `country` varchar(255) not null,
  `city` varchar(255) not null,
  `address` varchar(255) not null,
  `zipcode` varchar(255) not null,
  `memo` varchar(255),
  `created_at` datetime not null default now(),
  `created_by` int,
  `updated_at` datetime on update now(),
  `updated_by` int
);

create table yoonpage.`order` (
  `id` int primary key,
  `serial_code` varchar(255) not null,
  `delivery_id` int not null,
  `payment_id` int not null,
  `member_id` int not null,
  `created_at` datetime not null default now(),
  `created_by` int,
  `updated_at` datetime on update now(),
  `updated_by` int
);

create table yoonpage.`order_item` (
  `id` int primary key,
  `order_id` int not null,
  `product_id` int not null,
  `option_id` int not null,
  `count` int not null,
  `price` int not null,
  `discount` int not null,
  `memo` varchar(255),
  `status` varchar(255) not null,
  `created_at` datetime not null default now(),
  `created_by` int,
  `updated_at` datetime on update now(),
  `updated_by` int
);

create table yoonpage.`payment` (
  `id` int primary key,
  `product_total_price` int not null,
  `discount` int not null,
  `delivery_price` int not null,
  `pay_price` int not null,
  `cancel_price` int not null,
  `pg_type` varchar(255) not null,
  `created_at` datetime not null default now(),
  `created_by` int,
  `updated_at` datetime on update now(),
  `updated_by` int
);

alter table `option` add foreign key (`stock_id`) references `stock` (`id`);

alter table `product_option` add foreign key (`option_id`) references `option` (`id`);
alter table `product_option` add foreign key (`product_id`) references `product` (`id`);

alter table `discount` add foreign key (`product_id`) references `product` (`id`);

alter table `product` add foreign key (`category_id`) references `category` (`id`);

alter table `order` add foreign key (`member_id`) references `member` (`id`);
alter table `order` add foreign key (`payment_id`) references `payment` (`id`);
alter table `order` add foreign key (`delivery_id`) references `delivery` (`id`);

alter table `order_item` add foreign key (`order_id`) references `order` (`id`);
alter table `order_item` add foreign key (`product_id`) references `product` (`id`);
