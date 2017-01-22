-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 22, 2017 at 02:29 PM
-- Server version: 5.5.34
-- PHP Version: 5.4.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `app_permissions`
--

-- --------------------------------------------------------

--
-- Table structure for table `app_perm_data`
--

CREATE TABLE IF NOT EXISTS `app_perm_data` (
  `app` text NOT NULL,
  `permission` text NOT NULL,
  `is_peer_given` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `app_perm_data`
--

INSERT INTO `app_perm_data` (`app`, `permission`, `is_peer_given`) VALUES
('Facebook', 'Device & app history', 1),
('Facebook', 'Identity', 1),
('Facebook', 'Calendar', 1),
('Facebook', 'Contacts', 1),
('Facebook', 'Location', 0),
('Facebook', 'SMS', 0),
('Facebook', 'Phone', 1),
('Facebook', 'Photos/Media/Files', 1),
('Facebook', 'Storage', 1),
('Facebook', 'Camera', 1),
('Facebook', 'Microphone', 1),
('Facebook', 'Wi-Fi connection information', 1),
('Facebook', 'Device ID & call information', 0),
('Whatsapp', 'Device & app history', 1),
('Whatsapp', 'Identity', 1),
('Whatsapp', 'Calendar', 0),
('Whatsapp', 'Contacts', 1),
('Whatsapp', 'Location', 0),
('Whatsapp', 'SMS', 0),
('Whatsapp', 'Phone', 1),
('Whatsapp', 'Photos/Media/Files', 1),
('Whatsapp', 'Storage', 1),
('Whatsapp', 'Camera', 1),
('Whatsapp', 'Microphone', 1),
('Whatsapp', 'Wi-Fi connection information', 1),
('Whatsapp', 'Device ID & call information', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
