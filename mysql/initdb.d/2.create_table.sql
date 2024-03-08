create table yoonpage.`member` (
  `id` int primary key,
  `name` varchar(255) not null,
  `pw` varchar(255) not null,
  `phone` varchar(255),
  `created_at` datetime not null default (now()),
  `created_by` int,
  `updated_at` datetime on update now(),
  `updated_by` int,
  `expired_at` datetime
);

create table yoonpage.`product_option` (
  `id` int primary key,
  `product_id` int not null,
  `option_id` int not null,
  `created_at` datetime not null default (now())
);

create table yoonpage.`product` (
  `id` int primary key,
  `name` varchar(255) not null,
  `price` int not null,
  `discount_type` varchar(255),
  `category_id` int not null,
  `created_at` datetime not null default (now()),
  `created_by` int,
  `updated_at` datetime on update now(),
  `updated_by` int
);

create table yoonpage.`discount` (
  `id` int primary key,
  `type` varchar(255) not null,
  `price` int,
  `rate` int,
  `start` datetime,
  `end` datetime,
  `product_id` int not null,
  `created_at` datetime not null default (now()),
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
  `created_at` datetime not null default (now()),
  `created_by` int,
  `updated_at` datetime on update now(),
  `updated_by` int
);

create table yoonpage.`option` (
  `id` int primary key,
  `name` varchar(255) not null,
  `price` int,
  `stock_id` int not null,
  `created_at` datetime not null default (now()),
  `created_by` int,
  `updated_at` datetime on update now(),
  `updated_by` int
);

create table yoonpage.`category` (
  `id` int primary key,
  `name` varchar(255) not null,
  `target` varchar(255) not null,
  `used` varchar(255) not null,
  `created_at` datetime not null default (now()),
  `created_by` int,
  `updated_at` datetime on update now(),
  `updated_by` int
);

alter table `option` add foreign key (`stock_id`) references `stock` (`id`);

alter table `product_option` add foreign key (`option_id`) references `option` (`id`);

alter table `product_option` add foreign key (`product_id`) references `product` (`id`);

alter table `discount` add foreign key (`product_id`) references `product` (`id`);

alter table `product` add foreign key (`category_id`) references `category` (`id`);
