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

--
-- Table structure for table `hibernate_sequence`
--

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
