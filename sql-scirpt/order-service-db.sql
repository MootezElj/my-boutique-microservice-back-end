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
-- Database: `order-service-db`
--

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
(162),
(162),
(162);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `id` bigint(20) NOT NULL,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `cart_id` bigint(20) DEFAULT NULL,
  `city` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address_1` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address_2` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `country` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `postcode` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `shipped` datetime DEFAULT NULL,
  `status` varchar(255) COLLATE utf8_bin NOT NULL,
  `total_price` decimal(10,2) NOT NULL,
  `payment_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_haujdjk1ohmeixjhnhslchrp1` (`payment_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `created_date`, `last_modified_date`, `cart_id`, `city`, `address_1`, `address_2`, `country`, `postcode`, `shipped`, `status`, `total_price`, `payment_id`) VALUES
(152, '2020-05-21 00:15:38', '2020-05-21 00:15:38', 111, NULL, NULL, NULL, NULL, NULL, NULL, 'CREATION', '0.00', NULL),
(149, '2020-05-21 00:14:32', '2020-05-21 00:14:32', 109, NULL, NULL, NULL, NULL, NULL, NULL, 'CREATION', '0.00', NULL),
(151, '2020-05-21 00:15:06', '2020-05-21 00:15:06', 110, NULL, NULL, NULL, NULL, NULL, NULL, 'CREATION', '0.00', NULL),
(148, '2020-05-21 00:14:04', '2020-05-21 00:14:04', 108, NULL, NULL, NULL, NULL, NULL, NULL, 'CREATION', '0.00', NULL),
(154, '2020-05-21 00:16:53', '2020-05-21 00:16:53', 112, NULL, NULL, NULL, NULL, NULL, NULL, 'CREATION', '0.00', NULL),
(156, '2020-05-21 00:17:27', '2020-05-21 00:17:27', 113, NULL, NULL, NULL, NULL, NULL, NULL, 'CREATION', '0.00', NULL),
(159, '2020-05-21 00:23:36', '2020-05-21 00:23:36', 114, NULL, NULL, NULL, NULL, NULL, NULL, 'CREATION', '0.00', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
CREATE TABLE IF NOT EXISTS `order_item` (
  `id` bigint(20) NOT NULL,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `quantity` bigint(20) NOT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt4dc2r9nbvbujrljv3e23iibt` (`order_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE IF NOT EXISTS `payment` (
  `id` bigint(20) NOT NULL,
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `paypal_payment_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` varchar(255) COLLATE utf8_bin NOT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_mf7n8wo2rwrxsd6f3t9ub2mep` (`order_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
