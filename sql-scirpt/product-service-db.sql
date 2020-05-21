-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 21, 2020 at 12:29 AM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `product-service-db`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `id` bigint(20) NOT NULL,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `department_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt9tj2hob3b2lb8y24lpl53sm4` (`department_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `created_date`, `last_modified_date`, `description`, `name`, `department_id`) VALUES
(8, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Men clothing category', 'Men clothing', 1),
(9, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Women clothing category', 'Women clothing', 1),
(10, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Boys clothing category', 'Boys clothing', 1),
(11, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Girls clothing category', 'Girls clothing', 1),
(12, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Girls clothing category', 'Girls clothing', 1),
(17, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Phones category', 'Phones', 2),
(18, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Drones category', 'Drones', 2),
(19, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Footbal category', 'Football', 4),
(20, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Handball category', 'Handball', 4),
(21, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Camping category', 'Camping', 4),
(22, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Ping Pong', 'Ping Pong', 4),
(23, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Hiking category', 'Hiking', 4),
(7, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Laptops category', 'Laptops', 2);

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `id` bigint(20) NOT NULL,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `department_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `image` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`id`, `created_date`, `last_modified_date`, `department_name`, `description`, `image`) VALUES
(1, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Clothes', 'Clothing department', 'https://cdn.pixabay.com/photo/2015/11/07/11/46/fashion-1031469_960_720.jpg'),
(2, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Electronics', 'Electronics department', 'https://cdn.pixabay.com/photo/2015/06/24/15/45/ipad-820272_960_720.jpg'),
(3, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Tv and movies', 'Tv and movies department', 'https://cdn.pixabay.com/photo/2015/09/02/12/45/movie-918655_960_720.jpg'),
(4, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Sport', 'Sport department', 'https://cdn.pixabay.com/photo/2017/04/27/08/29/sport-2264825_960_720.jpg'),
(5, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Video games', 'Video games department', 'https://cdn.pixabay.com/photo/2014/05/03/00/50/video-controller-336657_960_720.jpg'),
(6, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Software', 'Software department', 'https://cdn.pixabay.com/photo/2016/11/19/14/00/code-1839406_960_720.jpg'),
(7, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Art and craft', 'Art and craft department', 'https://cdn.pixabay.com/photo/2017/08/30/12/45/girl-2696947_960_720.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(141);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` bigint(20) NOT NULL,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin NOT NULL,
  `discount` int(11) DEFAULT NULL,
  `image1` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `image2` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `image3` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `image4` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `price_before_discount` decimal(10,2) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `sales_counter` int(11) DEFAULT NULL,
  `status` varchar(255) COLLATE utf8_bin NOT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `rating_average` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `created_date`, `last_modified_date`, `description`, `discount`, `image1`, `image2`, `image3`, `image4`, `name`, `price`, `price_before_discount`, `quantity`, `sales_counter`, `status`, `category_id`, `rating_average`) VALUES
(24, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Taille : XS|S|X \nColors: black', 4, 'Clothes_Men clothing--Men\'s Bershka T-Shirt--1.jpg', 'Clothes_Men clothing--Men\'s Bershka T-Shirt--2.jpg', '', '', 'Men\'s T-shirt 1', '38.40', '40.00', 17, 1, 'DISCONTINUED', 8, NULL),
(25, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Taille : S|M|X|XL \nColors: Blue,red and black \nBrand: ZARA', 10, 'Clothes_Men clothing--Men\'s Zara T-Shirt--1.jpg', 'Clothes_Men clothing--Men\'s Zara T-Shirt--2.jpg', '', '', 'Men\'s T-shirt 2', '22.50', '25.00', 45, 1, 'AVAILABLE', 8, NULL),
(26, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Taille : X|XL \nColors: Blue and black', 0, 'Clothes_Men clothing--Men\'s Pull and bear T-Shirt--1.jpg', 'Clothes_Men clothing--Men\'s Pull and bear T-Shirt--2.jpg', '', '', 'Men\'s T-shirt 3', '20.00', '20.00', 60, 1, 'AVAILABLE', 8, NULL),
(27, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Taille : XS|S|X \nColors: black', 4, 'Clothes_Women clothing--Women\'s Bershka pant--1.jpg', 'Clothes_Women clothing--Women\'s Bershka pant--2.jpg', '', '', 'Women\'s Pant 1', '48.00', '50.00', 17, 1, 'DISCONTINUED', 9, NULL),
(28, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Taille : S|M|X|XL \nColors: Blue,red and black \nBrand: ZARA', 2, 'Clothes_Women clothing--Women\'s Zara pant--1.jpg', 'Clothes_Women clothing--Women\'s Zara pant--2.jpg', '', '', 'Women\'s Pant 2', '39.20', '40.00', 45, 1, 'AVAILABLE', 9, NULL),
(29, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Taille : X|XL \nColors: Blue and black', 50, 'Clothes_Women clothing--Women\'s P&B pant--1.jpg', 'Clothes_Women clothing--Women\'s P&B pant--2.jpg', '', '', 'Women\'s Pant 3', '45.00', '90.00', 60, 1, 'AVAILABLE', 9, NULL),
(30, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Released 2018, March\n163g, 8.5mm thickness', 20, 'Electronics_Phones_Samsung-galaxy-S9--1.jpg', 'Electronics_Phones_Samsung-galaxy-S9--2.jpg', '', '', 'Samsung galaxy s9', '399.20', '499.00', 32, 1, 'DISCONTINUED', 17, NULL),
(31, '2020-04-07 13:41:46', '2020-04-07 13:41:46', '\"Released 2020, March\\n\" +\n140, 8.5mm thickness\\n\" +\n', 10, 'Electronics_Phones_Samsung-galaxy-S11--1.jpg', 'Electronics_Phones_Samsung-galaxy-S11--2.jpg', '', '', 'Samsung galaxy s11', '899.10', '999.00', 25, 1, 'DISCONTINUED', 17, NULL),
(32, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'At a Glance. The iPhone X was Apple\'s flagship 10th anniversary iPhone \nfeaturing a 5.8-inch OLED display, facial recognition and 3D camera \n', 20, 'Electronics_Phones-IphoneX--1.jpg', 'Electronics_Phones-IphoneX--2.jpg', '', '', 'Iphone X', '360.00', '450.00', 20, 1, 'AVAILABLE', 17, NULL),
(33, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'The iPhone 11 is a smartphone designed, developed, and marketed by Apple Inc.\n It is the thirteenth generation lower-priced iPhone', 0, 'Electronics_Phones-iphone11--1.jpg', 'Electronics_Phones-iphone11--2.jpg', '', '', 'Iphone 11', '1499.00', '1499.00', 11, 1, 'AVAILABLE', 17, NULL),
(113, '2020-05-09 18:56:11', '2020-05-09 18:56:11', 'ordinateur portable de 15 pouces convertible à 360 ° avec processeur Intel® Core™ i7 et écran tactile NanoEdge Full HD', 10, 'Electronics_Laptops_Asus ZenBook Flip 15 ux534fa--1.jpg', 'Electronics_Laptops_Asus ZenBook Flip 15 ux534fa--2.jpg', '', '', 'Asus ZenBook Flip 15 UX561UA', '899.10', '999.00', 20, 1, 'AVAILABLE', 7, NULL),
(114, '2020-05-09 18:56:11', '2020-05-09 18:56:11', 'Le PC portable de 15\'\' le plus compact avec ScreenPad™ 2.0*', 0, 'Electronics_Laptops_MacBook Pro--1.jpg', 'Electronics_Laptops_MacBook Pro--2.jpg', '', '', 'MacBook Pro', '750.00', '750.00', 25, 1, 'AVAILABLE', 7, NULL),
(115, '2020-05-09 18:56:11', '2020-05-09 18:56:11', 'Razer Blade Pro (17\" Ecran IPS Full-HD) Portable PC Gaming (Intel i7-7700HQ, 16 Go RAM, 256 Go', 10, 'Electronics_Laptops_Razer Blade 17--1.jpg', 'Electronics_Laptops_Razer Blade 17--2.jpg', '', '', 'Razer Blade Pro 17Inch', '1800.00', '2000.00', 5, 1, 'AVAILABLE', 7, NULL),
(116, '2020-05-09 18:56:11', '2020-05-09 18:56:11', 'Pc Portable LENOVO ThinkPad E580 i5 8é Gén 8Go 1To (20KS0007FE)', 5, 'Electronics_Laptops_Lenovo thinkpad e580--1.jpg', 'Electronics_Laptops_Lenovo thinkpad e580--2.jpg', '', '', 'LENOVO ThinkPad', '1520.00', '1600.00', 5, 1, 'DISCONTINUED', 7, NULL),
(117, '2020-05-09 18:56:11', '2020-05-09 18:56:11', 'Alienware 17 R5 VR Ready 17.3\" LCD Gaming Notebook - Intel Core i7 (8th Gen) i7-8750H Hexa-core (6 Core)', 10, 'Electronics_MacBook Air --1.jpg', 'Electronics_MacBook Air --2.jpg', '', '', 'MacBook Air', '899.10', '999.00', 20, 1, 'AVAILABLE', 7, NULL),
(118, '2020-05-09 18:56:11', '2020-05-09 18:56:11', 'LE MEILLEURDES DEUX MONDES', 30, 'Electronics_Laptops_Asus ZenBook Flip 15 ux534fa--2.jpg', 'Electronics_Laptops_Asus ZenBook Flip 15 ux534fa--1.jpg', '', '', 'Asus Laptop\r\n', '1190.00', '1700.00', 20, 1, 'AVAILABLE', 7, NULL),
(119, '2020-05-09 18:58:37', '2020-05-09 18:58:37', 'Hubsan X4 h502s Desire Drone Quadcopter avec GPS – Retour à la Maison', 10, 'Electronics_Drones-DJI Phantom 3 --1.jpg', 'Electronics_Drones-DJI Phantom 3 --2.jpg', '', '', 'DJI Phantom 3', '98.10', '109.00', 20, 1, 'AVAILABLE', 18, NULL),
(120, '2020-05-09 18:58:37', '2020-05-09 18:58:37', 'Potensic Drone GPS T18 Hélicoptère FPV Caméra 120° Grand Angle Réglable HD 1080P ', 0, 'Electronics_Drones-Potensic Drone GPS T18--1.jpg', 'Electronics_Drones-Potensic Drone GPS T18--2.jpg', '', '', 'Drone 1', '119.00', '119.00', 26, 1, 'AVAILABLE', 18, NULL),
(121, '2020-05-09 18:58:37', '2020-05-09 18:58:37', 'Mavic Air 2 takes power and portability to the next level, offering advanced features in a compact form factor.', 10, 'Electronics_Drones_DJI Mavic Air 2 --1.jpg', 'Electronics_Drones_DJI Mavic Air 2 --2.jpg', '', '', 'DJI mavic air 2', '630.00', '700.00', 20, 1, 'AVAILABLE', 18, NULL),
(122, '2020-05-09 18:58:37', '2020-05-09 18:58:37', '1” 20 MP CMOS Sensor | 30-min Flight Time Obstacle Sensing in Five Directions', 10, 'Electronics_Drones_DJI Phantom 4 PRO V2--1.jpg', 'Electronics_Drones_DJI Phantom 4 PRO V2--2.jpg', '', '', 'DJI Phantom 4 PRO V2', '809.10', '899.00', 20, 1, 'AVAILABLE', 18, NULL),
(123, '2020-05-09 19:00:02', '2020-05-09 19:00:02', ' INCL. BALL PUMP and SPARE BATTERIES - Inside LED lights up when kicked - Glow in the Dark Soccer Ball - Size 5 - Official Size & Weight black/orange', 0, 'Sport_Football-used Football 1--1.jpg', 'Sport_Football-used Football 1--2.jpg', '', '', 'Used football 1', '9.00', '9.00', 20, 1, 'AVAILABLE', 19, NULL),
(124, '2020-05-09 19:00:02', '2020-05-09 19:00:02', 'UEFA Champions League Football Size 5 Blue White', 10, 'Sport_Football-championsLeaugue ball--1.jpg', 'Sport_Football-championsLeaugue ball--2.jpg', '', '', 'UEFA Champions League Football Size 5 Blue White', '13.50', '15.00', 0, 1, 'DISCONTINUED', 19, NULL),
(125, '2020-05-09 19:00:02', '2020-05-09 19:00:02', 'Barceloa Signature Football', 5, 'Sport_Football-barcelona Football --1.jpg', 'Sport_Football-barcelona Football --2.jpg', '', '', 'Barceloa Signature Football', '13.30', '14.00', 20, 1, 'AVAILABLE', 19, NULL),
(127, '2020-05-09 19:01:05', '2020-05-09 19:01:05', '25 Litre Plastic Water Container - Drum - JERRICAN - 25L Containers - Anti-glug System', 0, '', '', '', '', '25 Litre Plastic Water Container', '11.00', '11.00', 20, 1, 'DISCONTINUED', 21, NULL),
(128, '2020-05-09 19:01:05', '2020-05-09 19:01:05', 'BOTTLED JOY Water Bottle with Straw 1 Litre Tritan BPA Free Leak proof Durable Gym Sports 1000ML Flip Straw School Bottle Dustproof with Marking', 0, '', '', '', '', 'BOTTLED JOY Water Bottle with Straw 1 Litre Tritan', '14.00', '14.00', 20, 1, 'AVAILABLE', 21, NULL),
(129, '2020-05-09 19:01:05', '2020-05-09 19:01:05', 'Active Era® V2 Waterproof 2 Person Pop-Up Tent – 100% Storm Tested with', 10, '', '', '', '', 'Active Era® V2 Waterproof 2', '48.60', '54.00', 20, 1, 'AVAILABLE', 21, NULL),
(130, '2020-05-09 19:01:05', '2020-05-09 19:01:05', 'Dome-style, free-standing tent accommodates up to 4 people; works well for 3-season camping', 0, '', '', '', '', 'AmazonBasicsTent', '59.00', '59.00', 25, 1, 'AVAILABLE', 21, NULL),
(131, '2020-05-09 19:01:05', '2020-05-09 19:01:05', 'Double airbed: Ideal for camping in comfort', 0, '', '', '', '', 'Pavillo Airbed Quick Inflation Outdoor Camping Air Mattress', '15.00', '15.00', 20, 1, 'AVAILABLE', 21, NULL),
(132, '2020-05-09 19:01:05', '2020-05-09 19:01:05', 'G&X Tactical Backpack, Military Backpack 25L Army Rucksack MOLLE', 0, '', '', '', '', 'G&X Tactical Backpack', '18.00', '18.00', 20, 1, 'AVAILABLE', 21, NULL),
(133, '2020-05-09 19:01:05', '2020-05-09 19:01:05', 'AmazonBasics Internal Frame Hiking Backpack with Rainfly', 0, '', '', '', '', 'AmazonBasics Internal Frame Hiking Backpack', '11.00', '11.00', 20, 1, 'AVAILABLE', 21, NULL),
(134, '2020-05-09 19:01:05', '2020-05-09 19:01:05', 'Pocket Chainsaw with Paracord Handle (24inch-11teeth) / (36inch-16teeth) Folding Chain Hand Saw Fast Wood & Tree Cutting Emergency Outdoor Survival Gear Best for Camping Backpacking Hiking Hunting', 0, '', '', '', '', 'Pocket Chainsaw with Paracord Handle', '60.00', '60.00', 20, 1, 'AVAILABLE', 21, NULL),
(135, '2020-05-09 19:01:05', '2020-05-09 19:01:05', 'Camillus Ravenous Tomahawk, with Sheath, 2.75\" / 7 cm Titanium', 0, '', '', '', '', 'Camillus Ravenous', '34.00', '34.00', 20, 1, 'AVAILABLE', 21, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
CREATE TABLE IF NOT EXISTS `review` (
  `id` bigint(20) NOT NULL,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin NOT NULL,
  `rating` bigint(20) NOT NULL,
  `title` varchar(255) COLLATE utf8_bin NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiyof1sindb9qiqr9o8npj8klt` (`product_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `review`
--

INSERT INTO `review` (`id`, `created_date`, `last_modified_date`, `description`, `rating`, `title`, `product_id`) VALUES
(112, '2020-05-08 01:39:09', '2020-05-08 01:39:09', 'Fac', 1, 'One', 31),
(111, '2020-05-08 01:38:54', '2020-05-08 01:38:54', 'Five marks', 5, '5', 31),
(109, '2020-05-08 01:35:57', '2020-05-08 01:35:57', 'FGa', 3, 'Third', 31),
(108, '2020-05-08 01:14:14', '2020-05-08 01:14:14', 'Da', 2, 'Second review', 30),
(107, '2020-05-08 01:13:49', '2020-05-08 01:13:49', 'Test', 3, 'Third', 30),
(136, '2020-05-14 02:23:16', '2020-05-14 02:23:16', 'I like the feeling of it.', 4, 'Very good t-shirt', 24),
(137, '2020-05-14 02:23:46', '2020-05-14 02:23:46', 'Good looking product but I don\'t like its portions.', 2, 'Good, but', 24),
(138, '2020-05-14 02:23:56', '2020-05-14 02:23:56', 'Perfect t-shirt.', 5, 'Perfect', 24),
(139, '2020-05-14 02:29:27', '2020-05-14 02:29:27', 'I don\'t like the product.', 0, 'Bad Product', 24),
(140, '2020-05-18 23:30:02', '2020-05-18 23:30:02', 'DASc', 2, 'Good, but', 32);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
