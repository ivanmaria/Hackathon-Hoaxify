-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 11, 2018 at 06:43 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hoax`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `type` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL,
  `hoax_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `comment` varchar(1000) NOT NULL,
  `time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`comment_id`, `hoax_id`, `user_id`, `comment`, `time`) VALUES
(1, 2, 1, 'so good', '2018-03-16 06:00:00'),
(2, 4, 2, 'cartooooon', '2018-03-19 11:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `comment_activity`
--

CREATE TABLE `comment_activity` (
  `comment_activity_id` int(11) NOT NULL,
  `comment_id` int(11) NOT NULL,
  `hoax_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `vote` int(11) NOT NULL DEFAULT '0',
  `flag` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comment_activity`
--

INSERT INTO `comment_activity` (`comment_activity_id`, `comment_id`, `hoax_id`, `user_id`, `vote`, `flag`) VALUES
(1, 1, 2, 1, 7, 8),
(2, 2, 3, 2, 3, 5);

-- --------------------------------------------------------

--
-- Table structure for table `hoax`
--

CREATE TABLE `hoax` (
  `hoax_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `message` varchar(1000) NOT NULL,
  `time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hoax`
--

INSERT INTO `hoax` (`hoax_id`, `user_id`, `category_id`, `message`, `time`) VALUES
(2, 2, 3, 'adssdfsdfsd', '2018-03-11 17:00:00'),
(3, 1, 1, 'power puff', '2018-03-13 07:00:00'),
(4, 2, 3, 'mojojojojojojo', '2018-03-21 11:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `hoax_activity`
--

CREATE TABLE `hoax_activity` (
  `hoax_activity_id` int(11) NOT NULL,
  `hoax_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `vote` int(11) NOT NULL DEFAULT '0',
  `flag` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hoax_activity`
--

INSERT INTO `hoax_activity` (`hoax_activity_id`, `hoax_id`, `user_id`, `vote`, `flag`) VALUES
(2, 2, 2, 4, 9),
(3, 3, 1, 45, 3),
(4, 4, 2, 2, 12);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `designation` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `contact` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `designation`, `email`, `password`, `name`, `contact`) VALUES
(1, 'admin', 'admin', 'admin', 'admin', '999'),
(2, 'manager', 'asd@gmail.com', 'ath', 'atharva', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`comment_id`),
  ADD KEY `hoax_id` (`hoax_id`),
  ADD KEY `hoax_id_2` (`hoax_id`),
  ADD KEY `hoax_id_3` (`hoax_id`),
  ADD KEY `user-comment` (`user_id`);

--
-- Indexes for table `comment_activity`
--
ALTER TABLE `comment_activity`
  ADD PRIMARY KEY (`comment_activity_id`),
  ADD KEY `comment-activity` (`comment_id`),
  ADD KEY `hoax-activity` (`hoax_id`),
  ADD KEY `user-activity` (`user_id`);

--
-- Indexes for table `hoax`
--
ALTER TABLE `hoax`
  ADD PRIMARY KEY (`hoax_id`),
  ADD KEY `category-hoax` (`category_id`),
  ADD KEY `user-hoax` (`user_id`);

--
-- Indexes for table `hoax_activity`
--
ALTER TABLE `hoax_activity`
  ADD PRIMARY KEY (`hoax_activity_id`),
  ADD KEY `hoax-hoaxact` (`hoax_id`),
  ADD KEY `user-hoaxact` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `password` (`password`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `comment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `comment_activity`
--
ALTER TABLE `comment_activity`
  MODIFY `comment_activity_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `hoax`
--
ALTER TABLE `hoax`
  MODIFY `hoax_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `hoax_activity`
--
ALTER TABLE `hoax_activity`
  MODIFY `hoax_activity_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `hoax-comment` FOREIGN KEY (`hoax_id`) REFERENCES `hoax` (`hoax_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user-comment` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `comment_activity`
--
ALTER TABLE `comment_activity`
  ADD CONSTRAINT `comment-activity` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`comment_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `hoax-activity` FOREIGN KEY (`hoax_id`) REFERENCES `hoax` (`hoax_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user-activity` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hoax`
--
ALTER TABLE `hoax`
  ADD CONSTRAINT `category-hoax` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user-hoax` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hoax_activity`
--
ALTER TABLE `hoax_activity`
  ADD CONSTRAINT `hoax-hoaxact` FOREIGN KEY (`hoax_id`) REFERENCES `hoax` (`hoax_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user-hoaxact` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
