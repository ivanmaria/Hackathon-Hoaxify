-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 11, 2018 at 08:38 AM
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

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category_id`, `type`) VALUES
(1, 'other');

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
(1, 1, 3, 'hoax', '0000-00-00 00:00:00'),
(2, 1, 3, 'I work at SBI Mumbai.\nThis is a hoax message.\nbanks do not run on this policy.\nI request fellow readers not to forward this message.', '0000-00-00 00:00:00'),
(3, 3, 5, 'I am a Security Analyst hence I can answer this better. There are various flaws in this method. Most of the website mentioned above uses OTP to validate the user. Unless you share the OTP with some unknown person.', '0000-00-00 00:00:00'),
(4, 2, 4, 'Hello I am an IAS officer.\non behalf of government of India I would like to clarify that this news is true and not a hoax.', '0000-00-00 00:00:00'),
(5, 5, 4, 'I am an IAS officer related to MEA.\nThis is a false news.\nwas checked same with UNESCO', '0000-00-00 00:00:00');

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

-- --------------------------------------------------------

--
-- Table structure for table `hoax`
--

CREATE TABLE `hoax` (
  `hoax_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `message` varchar(1000) NOT NULL,
  `date_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hoax`
--

INSERT INTO `hoax` (`hoax_id`, `user_id`, `category_id`, `message`, `date_time`) VALUES
(1, 4, 1, 'Important reminder : Tomorrow & the day after tomorrow please do not....i repeat DO NOT put *500* â‚¹ and *_2000* â‚¹ note on your money bag or purse ...if some how those note get affected with COLOURS bank will never ever going to accept that money and the notes will be a *WASTE* no one will take it ......so please SHARE this message with *ALL*', '0000-00-00 00:00:00'),
(2, 4, 1, 'www.Bharatkeveer.gov.in This is website launched by Ministry of Home Affairs, Government of India and with the help of actor Akshay Kumar. This Website contains details of soldiers who sacrificed their life to protect our nation. You can contribute minimum â‚¹10 (Rupees Ten) to â‚¹15 lakhs (maximum) according to your ability. If any one soldier get â‚¹15 lakhs, then he will be removed from the list. Just think if 50 lacs people out of 125 crore people of india contribute only 10 rupees each. then it will become 5 Crore. You can take out your contribution certificate to show your participation in this initiative. ðŸ™ A humble request that if you cannot contribute, then please forward this message as much as possible.. ðŸ™ Remember freedom is not free, somebody has already paid for it. Hamari har ek sass un shahido ki karzdar hai. Kuch yaad unhe bhi karlo jo laut ke ghar na aaye. Superb initiative. PLEASE SUPPORT', '0000-00-00 00:00:00'),
(3, 4, 1, '*HACKING BANK ACCOUNTS & MORE* *21/11/17, 6:15:27 PM: Pradeep Oracle: ```*How can your bank account with internet banking facility can be hacked? Worth reading... 1. Hacker accesses your name and date of birth from Facebook. 2. With these details he goes to the IncomeTax site and updates them. From there he obtains the pancard and mobile numbers. 3. Then he gets a duplicate pancard made. 4. After this he lodges a mobile theft complaint in a police station. 5. With the duplicate pancard he gets another simcard from the mobile company. 6. Through internet banking he is now ready to access your account. 7. He goes to the site and uses the forgot my password option. 8. Now he easily gets past other options and gets the Internet banking pin on his simcard. This information was issued by the Cyber Cell Police. All those who used Net Banking are requested to edit Facebook profile and delete the birth date and mobile no. as a safety measure. Please share to as many people as possible.. Shared ', '0000-00-00 00:00:00'),
(4, 4, 1, 'https://www.ndtv.com/world-news/thailand-approves-5-5-billion-bullet-train-project-with-china-1723904 ðŸ‘† Thailand will get a bullet train connecting Bangkok with Southern China, a distance of more than 3000 kms for *US$5.5 billion*. India will get a bullet train linking Mumbai with Ahmedabad, a distance of about 500 kms for *US$17 billion* The taxpaying citizens of India have a right to know the reason of this huge difference.', '0000-00-00 00:00:00'),
(5, 4, 1, 'Congratulation to all of us Our national anthem \"Jana Gana Mana... \"is now declared as the BEST ANTHEM OF THE WORLD by UNESCO. Just few minutes ago. Kindly share this. Very proud to be an INDIAN.', '0000-00-00 00:00:00'),
(6, 4, 1, 'New Company recently registered in London by:\n\nLalit Modi, Vijay Mallya  Nirav Modi & Co. \n\n*Name of the company* :: Hindustan Leavers..\n', '0000-00-00 00:00:00');

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
(1, 1, 3, 1, 0),
(2, 3, 5, 2, 0),
(3, 2, 4, 2, 0),
(4, 5, 4, 2, 0),
(5, 1, 4, 1, 0),
(6, 4, 3, 1, 0),
(7, 1, 2, 1, 0),
(8, 6, 4, 2, 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `designation` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `contact` varchar(11) DEFAULT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `designation`, `email`, `name`, `contact`, `password`) VALUES
(1, 'admin', 'admin', 'admin', '1234568790', 'admin'),
(2, 'Student', 'ivanmaria05@gmail.com', 'Ivan Maria', '9920277279', '1234'),
(3, 'Bank Manager', 'atharvaglawe@gmail.com', 'Atharva Aglawe', '123456', '1234'),
(4, 'IAS officer', 'singhshyam473@gmail.com', 'Shyam Singh', '9619077062', '1234'),
(5, 'Security Analyst', 'ameysgorde@gmail.com', 'Amey Gorde', '9869567956', '1234'),
(6, 'MBBS MD', 'steve@gmail.com', 'Steve Fernandes', '9876543210', '1234');

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
  ADD UNIQUE KEY `contact` (`contact`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `comment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `comment_activity`
--
ALTER TABLE `comment_activity`
  MODIFY `comment_activity_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `hoax`
--
ALTER TABLE `hoax`
  MODIFY `hoax_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `hoax_activity`
--
ALTER TABLE `hoax_activity`
  MODIFY `hoax_activity_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
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
