-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 30, 2020 at 11:06 AM
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
(19, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Footbal category', 'Footbal', 4),
(20, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Handball category', 'Handball', 4),
(21, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Camping category', 'Camping', 4),
(22, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Ping Pong', 'Ping Pong', 4),
(23, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Hiking category', 'Hiking', 4),
(42, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Men clothing category', 'Men clothing', 35),
(43, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Women clothing category', 'Women clothing', 35),
(44, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Boys clothing category', 'Boys clothing', 35),
(45, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Girls clothing category', 'Girls clothing', 35),
(46, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Girls clothing category', 'Girls clothing', 35),
(47, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Laptops category', 'Laptops', 36),
(48, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'PC category', 'Pc', 36),
(49, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Pc gamers', 'Pc gamers', 36),
(50, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Consoles category', 'Consoles', 36),
(51, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Phones category', 'Phones', 36),
(52, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Drones category', 'Drones', 36),
(53, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Footbal category', 'Footbal', 38),
(54, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Handball category', 'Handball', 38),
(55, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Camping category', 'Camping', 38),
(56, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Ping Pong', 'Ping Pong', 38),
(57, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Hiking category', 'Hiking', 38),
(76, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Men clothing category', 'Men clothing', 69),
(77, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Women clothing category', 'Women clothing', 69),
(78, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Boys clothing category', 'Boys clothing', 69),
(79, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Girls clothing category', 'Girls clothing', 69),
(80, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Girls clothing category', 'Girls clothing', 69),
(81, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Laptops category', 'Laptops', 70),
(82, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'PC category', 'Pc', 70),
(83, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Pc gamers', 'Pc gamers', 70),
(84, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Consoles category', 'Consoles', 70),
(85, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Phones category', 'Phones', 70),
(86, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Drones category', 'Drones', 70),
(87, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Footbal category', 'Footbal', 72),
(88, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Handball category', 'Handball', 72),
(89, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Camping category', 'Camping', 72),
(90, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Ping Pong', 'Ping Pong', 72),
(91, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Hiking category', 'Hiking', 72);

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
(7, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Art and craft', 'Art and craft department', 'https://cdn.pixabay.com/photo/2017/08/30/12/45/girl-2696947_960_720.jpg'),
(35, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Clothes', 'Clothing department', 'https://cdn.pixabay.com/photo/2015/11/07/11/46/fashion-1031469_960_720.jpg'),
(36, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Electronics', 'Electronics department', 'https://cdn.pixabay.com/photo/2015/06/24/15/45/ipad-820272_960_720.jpg'),
(37, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Tv and movies', 'Tv and movies department', 'https://cdn.pixabay.com/photo/2015/09/02/12/45/movie-918655_960_720.jpg'),
(38, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Sport', 'Sport department', 'https://cdn.pixabay.com/photo/2017/04/27/08/29/sport-2264825_960_720.jpg'),
(39, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Video games', 'Video games department', 'https://cdn.pixabay.com/photo/2014/05/03/00/50/video-controller-336657_960_720.jpg'),
(40, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Software', 'Software department', 'https://cdn.pixabay.com/photo/2016/11/19/14/00/code-1839406_960_720.jpg'),
(41, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Art and craft', 'Art and craft department', 'https://cdn.pixabay.com/photo/2017/08/30/12/45/girl-2696947_960_720.jpg'),
(69, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Clothes', 'Clothing department', 'https://cdn.pixabay.com/photo/2015/11/07/11/46/fashion-1031469_960_720.jpg'),
(70, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Electronics', 'Electronics department', 'https://cdn.pixabay.com/photo/2015/06/24/15/45/ipad-820272_960_720.jpg'),
(71, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Tv and movies', 'Tv and movies department', 'https://cdn.pixabay.com/photo/2015/09/02/12/45/movie-918655_960_720.jpg'),
(72, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Sport', 'Sport department', 'https://cdn.pixabay.com/photo/2017/04/27/08/29/sport-2264825_960_720.jpg'),
(73, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Video games', 'Video games department', 'https://cdn.pixabay.com/photo/2014/05/03/00/50/video-controller-336657_960_720.jpg'),
(74, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Software', 'Software department', 'https://cdn.pixabay.com/photo/2016/11/19/14/00/code-1839406_960_720.jpg'),
(75, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Art and craft', 'Art and craft department', 'https://cdn.pixabay.com/photo/2017/08/30/12/45/girl-2696947_960_720.jpg');

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
(103);

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
(24, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Taille : XS|S|X \nColors: black', 4, '', '', '', '', 'Men\'s Bershka T-shirt', '38.40', '40.00', 17, 1, 'DISCONTINUED', 8, NULL),
(25, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Taille : S|M|X|XL \nColors: Blue,red and black \nBrand: ZARA', 10, '', '', '', '', 'Men\'s Zara T-shirt', '22.50', '25.00', 45, 1, 'AVAILABLE', 8, NULL),
(26, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Taille : X|XL \nColors: Blue and black', 0, '', '', '', '', 'Men\'s Pull and Bear T-shirt', '20.00', '20.00', 60, 1, 'AVAILABLE', 8, NULL),
(27, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Taille : XS|S|X \nColors: black', 4, '', '', '', '', 'Women\'s Bershka Pant', '48.00', '50.00', 17, 1, 'DISCONTINUED', 9, NULL),
(28, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Taille : S|M|X|XL \nColors: Blue,red and black \nBrand: ZARA', 2, '', '', '', '', 'Women\'s Zara Pant', '39.20', '40.00', 45, 1, 'AVAILABLE', 9, NULL),
(29, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Taille : X|XL \nColors: Blue and black', 50, '', '', '', '', 'Women\'s Pull and Bear Pant', '45.00', '90.00', 60, 1, 'AVAILABLE', 9, NULL),
(30, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'Released 2018, March\n163g, 8.5mm thickness', 20, 'pic1.png', 'pic2.jpg', '', '', 'Samsung galaxy s9', '399.20', '499.00', 32, 1, 'DISCONTINUED', 17, NULL),
(31, '2020-04-07 13:41:46', '2020-04-07 13:41:46', '\"Released 2020, March\\n\" +\n140, 8.5mm thickness\\n\" +\n', 10, 'pic1.png', 'pic.jpg', '', '', 'Samsung galaxy s11', '899.10', '999.00', 25, 1, 'DISCONTINUED', 17, NULL),
(32, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'At a Glance. The iPhone X was Apple\'s flagship 10th anniversary iPhone \nfeaturing a 5.8-inch OLED display, facial recognition and 3D camera \n', 20, 'pic1.jpg', 'pic2.jpg', '', '', 'Iphone X', '360.00', '450.00', 20, 1, 'AVAILABLE', 17, NULL),
(33, '2020-04-07 13:41:46', '2020-04-07 13:41:46', 'The iPhone 11 is a smartphone designed, developed, and marketed by Apple Inc.\n It is the thirteenth generation lower-priced iPhone', 0, 'pic1.jpg', 'pic2.png', '', '', 'Iphone 11', '1499.00', '1499.00', 11, 1, 'AVAILABLE', 17, NULL),
(58, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Taille : XS|S|X \nColors: black', 4, '', '', '', '', 'Men\'s Bershka T-shirt', '38.40', '40.00', 17, 1, 'DISCONTINUED', 42, NULL),
(59, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Taille : S|M|X|XL \nColors: Blue,red and black \nBrand: ZARA', 10, '', '', '', '', 'Men\'s Zara T-shirt', '22.50', '25.00', 45, 1, 'AVAILABLE', 42, NULL),
(60, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Taille : X|XL \nColors: Blue and black', 0, '', '', '', '', 'Men\'s Pull and Bear T-shirt', '20.00', '20.00', 60, 1, 'AVAILABLE', 42, NULL),
(61, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Taille : XS|S|X \nColors: black', 4, '', '', '', '', 'Women\'s Bershka Pant', '48.00', '50.00', 17, 1, 'DISCONTINUED', 43, NULL),
(62, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Taille : S|M|X|XL \nColors: Blue,red and black \nBrand: ZARA', 2, '', '', '', '', 'Women\'s Zara Pant', '39.20', '40.00', 45, 1, 'AVAILABLE', 43, NULL),
(63, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Taille : X|XL \nColors: Blue and black', 50, '', '', '', '', 'Women\'s Pull and Bear Pant', '45.00', '90.00', 60, 1, 'AVAILABLE', 43, NULL),
(64, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'Released 2018, March\n163g, 8.5mm thickness', 20, 'pic1.png', 'pic2.jpg', '', '', 'Samsung galaxy s9', '399.20', '499.00', 32, 1, 'DISCONTINUED', 51, NULL),
(65, '2020-04-07 13:44:28', '2020-04-07 13:44:28', '\"Released 2020, March\\n\" +\n140, 8.5mm thickness\\n\" +\n', 10, 'pic1.png', 'pic.jpg', '', '', 'Samsung galaxy s11', '899.10', '999.00', 25, 1, 'DISCONTINUED', 51, NULL),
(66, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'At a Glance. The iPhone X was Apple\'s flagship 10th anniversary iPhone \nfeaturing a 5.8-inch OLED display, facial recognition and 3D camera \n', 20, 'pic1.jpg', 'pic2.jpg', '', '', 'Iphone X', '360.00', '450.00', 20, 1, 'AVAILABLE', 51, NULL),
(67, '2020-04-07 13:44:28', '2020-04-07 13:44:28', 'The iPhone 11 is a smartphone designed, developed, and marketed by Apple Inc.\n It is the thirteenth generation lower-priced iPhone', 0, 'pic1.jpg', 'pic2.png', '', '', 'Iphone 11', '1499.00', '1499.00', 11, 1, 'AVAILABLE', 51, NULL),
(92, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Taille : XS|S|X \nColors: black', 4, '', '', '', '', 'Men\'s Bershka T-shirt', '38.40', '40.00', 17, 1, 'DISCONTINUED', 76, NULL),
(93, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Taille : S|M|X|XL \nColors: Blue,red and black \nBrand: ZARA', 10, '', '', '', '', 'Men\'s Zara T-shirt', '22.50', '25.00', 45, 1, 'AVAILABLE', 76, NULL),
(94, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Taille : X|XL \nColors: Blue and black', 0, '', '', '', '', 'Men\'s Pull and Bear T-shirt', '20.00', '20.00', 60, 1, 'AVAILABLE', 76, NULL),
(95, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Taille : XS|S|X \nColors: black', 4, '', '', '', '', 'Women\'s Bershka Pant', '48.00', '50.00', 17, 1, 'DISCONTINUED', 77, NULL),
(96, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Taille : S|M|X|XL \nColors: Blue,red and black \nBrand: ZARA', 2, '', '', '', '', 'Women\'s Zara Pant', '39.20', '40.00', 45, 1, 'AVAILABLE', 77, NULL),
(97, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Taille : X|XL \nColors: Blue and black', 50, '', '', '', '', 'Women\'s Pull and Bear Pant', '45.00', '90.00', 60, 1, 'AVAILABLE', 77, NULL),
(98, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'Released 2018, March\n163g, 8.5mm thickness', 20, 'pic1.png', 'pic2.jpg', '', '', 'Samsung galaxy s9', '399.20', '499.00', 32, 1, 'DISCONTINUED', 85, NULL),
(99, '2020-04-07 13:49:23', '2020-04-07 13:49:23', '\"Released 2020, March\\n\" +\n140, 8.5mm thickness\\n\" +\n', 10, 'pic1.png', 'pic.jpg', '', '', 'Samsung galaxy s11', '899.10', '999.00', 25, 1, 'DISCONTINUED', 85, NULL),
(100, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'At a Glance. The iPhone X was Apple\'s flagship 10th anniversary iPhone \nfeaturing a 5.8-inch OLED display, facial recognition and 3D camera \n', 20, 'pic1.jpg', 'pic2.jpg', '', '', 'Iphone X', '360.00', '450.00', 20, 1, 'AVAILABLE', 85, NULL),
(101, '2020-04-07 13:49:23', '2020-04-07 13:49:23', 'The iPhone 11 is a smartphone designed, developed, and marketed by Apple Inc.\n It is the thirteenth generation lower-priced iPhone', 0, 'pic1.jpg', 'pic2.png', '', '', 'Iphone 11', '1499.00', '1499.00', 11, 1, 'AVAILABLE', 85, NULL);

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
(68, '2020-04-07 13:44:33', '2020-04-07 13:44:33', 'Description review 2 3', 3, 'Title Review 2', 59),
(102, '2020-04-07 13:49:48', '2020-04-07 13:49:48', 'Description review 2 3', 3, 'Title Review 2', 59);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
