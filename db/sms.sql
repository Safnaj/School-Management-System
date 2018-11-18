-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 14, 2018 at 05:56 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sms`
--

-- --------------------------------------------------------

--
-- Table structure for table `grades`
--

DROP TABLE IF EXISTS `grades`;
CREATE TABLE IF NOT EXISTS `grades` (
  `gradeId` int(10) NOT NULL,
  `grade` varchar(30) NOT NULL,
  `noOfStudents` int(100) DEFAULT NULL,
  PRIMARY KEY (`gradeId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grades`
--

INSERT INTO `grades` (`gradeId`, `grade`, `noOfStudents`) VALUES
(1, 'Grade 1', NULL),
(2, 'Grade 2', NULL),
(3, 'Grade 3', NULL),
(4, 'Grade 4', NULL),
(5, 'Grade 5', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `leftstudents`
--

DROP TABLE IF EXISTS `leftstudents`;
CREATE TABLE IF NOT EXISTS `leftstudents` (
  `adNo` int(11) NOT NULL,
  `fullName` varchar(100) NOT NULL,
  `name` varchar(50) NOT NULL,
  `dob` date NOT NULL,
  `doa` date NOT NULL,
  `gender` varchar(15) NOT NULL,
  `grade` varchar(15) DEFAULT NULL,
  `parentName` varchar(60) NOT NULL,
  `nic` char(10) NOT NULL,
  `phone` varchar(13) NOT NULL,
  `address` varchar(150) NOT NULL,
  PRIMARY KEY (`adNo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `leftstudents`
--

INSERT INTO `leftstudents` (`adNo`, `fullName`, `name`, `dob`, `doa`, `gender`, `grade`, `parentName`, `nic`, `phone`, `address`) VALUES
(1919, 'Mohamed Hanan', 'Hanan', '1996-10-12', '2002-08-23', 'Male', 'Grade 3', 'Shareef', '897335342v', '0756009284', 'Pandiruppu');

-- --------------------------------------------------------

--
-- Table structure for table `oldstaffs`
--

DROP TABLE IF EXISTS `oldstaffs`;
CREATE TABLE IF NOT EXISTS `oldstaffs` (
  `empNo` varchar(10) NOT NULL,
  `teacherName` varchar(60) DEFAULT NULL,
  `nic` char(10) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `doa` date DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT '-',
  `assumpOfDuties` date DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `incDate` date DEFAULT NULL,
  `prsntGrade` varchar(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `oldstaffs`
--

INSERT INTO `oldstaffs` (`empNo`, `teacherName`, `nic`, `dob`, `doa`, `gender`, `email`, `assumpOfDuties`, `phone`, `address`, `incDate`, `prsntGrade`) VALUES
('2', 'Jahan', '781234578v', '1974-03-02', '2001-10-12', 'Female', NULL, '2015-03-05', '0767878654', 'Makkamady Road Maruthamunai', '2000-12-14', '2'),
('1122', 'Sithy Raajiya', '702016602v', '1970-05-15', '1980-05-12', 'Female', '', '1996-10-12', '0772185850', 'Maruthamunai3', '2001-03-16', '2');

-- --------------------------------------------------------

--
-- Table structure for table `paststudents`
--

DROP TABLE IF EXISTS `paststudents`;
CREATE TABLE IF NOT EXISTS `paststudents` (
  `adNo` int(11) NOT NULL,
  `fullName` varchar(100) NOT NULL,
  `name` varchar(50) NOT NULL,
  `dob` date NOT NULL,
  `doa` date NOT NULL,
  `gender` varchar(15) NOT NULL,
  `year` varchar(15) DEFAULT NULL,
  `parentName` varchar(60) NOT NULL,
  `nic` char(10) NOT NULL,
  `phone` varchar(13) NOT NULL,
  `address` varchar(150) NOT NULL,
  PRIMARY KEY (`adNo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paststudents`
--

INSERT INTO `paststudents` (`adNo`, `fullName`, `name`, `dob`, `doa`, `gender`, `year`, `parentName`, `nic`, `phone`, `address`) VALUES
(4545, 'Aflaj Ismail', 'MI Aflah', '1997-08-07', '2002-12-05', 'Male', '2019', 'Ismail', '876756852v', '0772168234', 'Zam Zam Road Maruthamunai 03'),
(3333, 'Zaamin Shara', 'Shara', '2001-12-12', '2006-12-10', 'Female', '2018', 'Mahroof', '', '0772185830', ''),
(1535, 'Kavishka Kumara', 'Kavishka KLA', '1995-10-08', '2002-08-25', 'Male', '2018', 'Kumarathunga', '123886967v', '0719867545', 'Avisavella');

-- --------------------------------------------------------

--
-- Table structure for table `schoolinfo`
--

DROP TABLE IF EXISTS `schoolinfo`;
CREATE TABLE IF NOT EXISTS `schoolinfo` (
  `SchoolName` varchar(80) DEFAULT NULL,
  `SchoolAddress` varchar(80) DEFAULT NULL,
  `classAvailable` varchar(20) DEFAULT NULL,
  `schoolType` varchar(50) DEFAULT NULL,
  `deoDivision` varchar(50) DEFAULT NULL,
  `municpalCouncil` varchar(50) DEFAULT NULL,
  `policeArea` varchar(50) NOT NULL,
  `postalCode` varchar(10) NOT NULL,
  `gsDivision` varchar(50) NOT NULL,
  `eduZone` varchar(50) NOT NULL,
  `eduDistrict` varchar(50) NOT NULL,
  `adminDistrict` varchar(50) NOT NULL,
  `electorate` varchar(30) NOT NULL,
  `dateOfEstd` date DEFAULT NULL,
  `schoolID` varchar(30) NOT NULL,
  `schoolCensus` varchar(40) NOT NULL,
  `schoolExamId` varchar(30) NOT NULL,
  `totalLandArea` varchar(30) NOT NULL,
  `province` varchar(30) NOT NULL,
  `nameOfPrincipal` varchar(30) NOT NULL,
  `pricipalNo` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `schoolinfo`
--

INSERT INTO `schoolinfo` (`SchoolName`, `SchoolAddress`, `classAvailable`, `schoolType`, `deoDivision`, `municpalCouncil`, `policeArea`, `postalCode`, `gsDivision`, `eduZone`, `eduDistrict`, `adminDistrict`, `electorate`, `dateOfEstd`, `schoolID`, `schoolCensus`, `schoolExamId`, `totalLandArea`, `province`, `nameOfPrincipal`, `pricipalNo`) VALUES
('Al-Hikma Junior School, Maruthamunai', 'Maruthamunai', '12', 'AB', 'Kalmunai', 'Kalmunai', 'Kalmunai', '32314', 'Kalmunai', 'Kalmunai', 'Ampara', 'Ampara', '120', '1996-10-13', '12313', '43525', '34142', '4 Acres', 'Eastern', 'Mohamed Mahroof', '0777974207');

-- --------------------------------------------------------

--
-- Table structure for table `staffs`
--

DROP TABLE IF EXISTS `staffs`;
CREATE TABLE IF NOT EXISTS `staffs` (
  `empNo` varchar(10) NOT NULL,
  `teacherName` varchar(60) DEFAULT NULL,
  `nic` char(10) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `doa` date DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT '-',
  `assumpOfDuties` date DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `incDate` date DEFAULT NULL,
  `prsntGrade` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`empNo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staffs`
--

INSERT INTO `staffs` (`empNo`, `teacherName`, `nic`, `dob`, `doa`, `gender`, `email`, `assumpOfDuties`, `phone`, `address`, `incDate`, `prsntGrade`) VALUES
('1234', 'Mohamed Mahroof', '651232988v', '1965-06-22', '1998-02-04', 'Male', 'mahroof@gmail.com', '2014-03-01', '0779557571', '490,Zam Zam Road, Maruthamunai 03', '2002-05-15', '2'),
('1', 'Amjath Ismail', '651232986v', '1992-10-14', '2003-10-23', 'Male', '', '2014-03-05', '0775959867', 'Magbooliya Road, Maruthamunai', '2002-04-06', '3'),
('1122', 'Manfoosa', '681356344v', '1970-04-12', '2000-07-12', 'Female', 'info@manhahandlooms.lk', '2016-05-13', '0789878675', 'Mashoor Moulana Road Maruthanumai', '2008-12-08', 'A1');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
CREATE TABLE IF NOT EXISTS `students` (
  `adNo` int(11) NOT NULL,
  `fullName` varchar(100) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `dob` date DEFAULT NULL,
  `doa` date DEFAULT NULL,
  `gender` varchar(15) DEFAULT NULL,
  `grade` varchar(15) DEFAULT NULL,
  `parentName` varchar(60) DEFAULT NULL,
  `nic` char(10) DEFAULT NULL,
  `phone` varchar(13) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`adNo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`adNo`, `fullName`, `name`, `dob`, `doa`, `gender`, `grade`, `parentName`, `nic`, `phone`, `address`) VALUES
(5750, 'Stanley Lampert', 'Stanley', '1996-05-12', '2001-07-08', 'Male', 'Grade 1', 'Joseph', '123456789v', '0772187334', 'Mannar, Sri Lanka'),
(5751, 'Shashikala Weerasinghe', 'Shashikala WKS', '1995-02-16', '2001-10-24', 'Female', 'Grade 4', 'Weerasinghe', '123421415v', '0773434567', 'Matara'),
(1456, 'Safnaj', 'Safnaj. MMA', '1996-10-13', '2001-08-13', 'Male', 'Grade 3', 'Dad', '962872352v', '0777974207', 'Maruthamunai'),
(1212, 'Ridmal', 'Ridmal sds', '1996-12-08', '2002-12-13', 'Male', 'Grade 1', 'ddvv', '', '1234567891', ''),
(5555, 'Ashen Chamli Sudaraka', 'Sudaraka. HGAC', '1991-05-12', '2000-06-03', 'Male', 'Grade 3', 'Upali Gamage', '925013480v', '0710101234', 'Thissamaharama'),
(4455, 'Bhanuka Sandeepa', 'Bhanuka SWK', '1997-12-03', '2002-02-15', 'Male', 'Grade 1', 'Sandeepa', '641237864v', '0710124457', 'Galle'),
(3232, 'Dulmini Hettiarachi', 'Dulmini HAC', '1995-03-15', '2002-05-18', 'Female', 'Grade 1', 'Hettiarachi', '687612673v', '0655662599', 'Kandy'),
(1567, 'Ashini Sugandika', 'Sugandika AWS', '1997-10-14', '2001-07-08', 'Female', 'Grade 3', 'Wariyapparema', '601234459v', '0786753123', 'Colombo'),
(5740, 'Amanda Shaneli', 'Shaneli AS', '1996-07-04', '2001-04-15', 'Female', 'Grade 1', 'Praveenth', '872315439v', '0765566432', 'Negombo'),
(5755, 'Thameej Ahamed', 'AW. Thameej', '1996-12-12', '2002-05-15', 'Male', 'Grade 3', 'Wahab', '678791394v', '0757249492', 'Maruthamunai');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`) VALUES
('admin', 'admin123'),
('teacher', 'teacher123');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
