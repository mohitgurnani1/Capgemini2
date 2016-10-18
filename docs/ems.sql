-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 12, 2016 at 07:12 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.5.37

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ems`
--

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `deptId` varchar(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `description` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`deptId`, `name`, `description`) VALUES
('d1', 'BAPI', 'Good'),
('d2', 'CCD', 'Good'),
('d3', 'APPLY', 'Good'),
('d4', 'ETL', 'Good'),
('d5', 'MOBILE', 'Good');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `empId` varchar(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `kinId` varchar(20) NOT NULL,
  `emailId` varchar(30) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `dob` date NOT NULL,
  `doj` date NOT NULL,
  `address` varchar(100) NOT NULL,
  `deptId` varchar(10) NOT NULL,
  `projId` varchar(10) NOT NULL,
  `roleId` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`empId`, `name`, `kinId`, `emailId`, `phone`, `dob`, `doj`, `address`, `deptId`, `projId`, `roleId`) VALUES
('G03390494', 'Roshita', 'ES123456789976', 'Roshita191@barclays.com', '1234567899', '2016-10-13', '2016-10-14', 'ABC', 'd1', 'p4', 'r3'),
('G07609313', 'Mohit', 'ES121261', 'Mohit181@barclays.com', '8149396710', '1994-01-26', '2016-01-01', 'Anil Park Shantinagar', 'd1', 'p4', 'r3');

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `projId` varchar(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `description` varchar(100) NOT NULL,
  `deptId` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`projId`, `name`, `description`, `deptId`) VALUES
('p1', '.NET', 'Good', 'd2'),
('p2', 'camel', 'Good', 'd1'),
('p3', 'platform', 'Good', 'd1'),
('p4', 'api', 'Good', 'd1'),
('p5', 'acquisition', 'Good', 'd3'),
('p6', 'hadoop', 'Good', 'd4');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `roleId` varchar(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `description` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`roleId`, `name`, `description`) VALUES
('r1', 'Manager', 'Good'),
('r2', 'Business Analyst', 'Good'),
('r3', 'Developer', 'Good'),
('r4', 'Tech Lead', 'Good'),
('r5', 'Product Owner', 'Good'),
('r6', 'Client', 'Good');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`deptId`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`empId`),
  ADD UNIQUE KEY `kinId` (`kinId`),
  ADD UNIQUE KEY `emailId` (`emailId`),
  ADD KEY `fk_deptId2` (`deptId`),
  ADD KEY `fk_projId` (`projId`),
  ADD KEY `fk_roleId2` (`roleId`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`projId`),
  ADD KEY `fk_deptId` (`deptId`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`roleId`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `fk_deptId2` FOREIGN KEY (`deptId`) REFERENCES `department` (`deptId`),
  ADD CONSTRAINT `fk_projId` FOREIGN KEY (`projId`) REFERENCES `project` (`projId`),
  ADD CONSTRAINT `fk_roleId2` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`);

--
-- Constraints for table `project`
--
ALTER TABLE `project`
  ADD CONSTRAINT `fk_deptId` FOREIGN KEY (`deptId`) REFERENCES `department` (`deptId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
