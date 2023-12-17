-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 17, 2023 at 12:34 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penjualanrokok`
--

-- --------------------------------------------------------

--
-- Table structure for table `grosir_rokok`
--

CREATE TABLE `grosir_rokok` (
  `id` int(11) NOT NULL,
  `namaRokok` varchar(15) NOT NULL,
  `diskon` double NOT NULL,
  `hargarokok` int(11) NOT NULL,
  `jumlahBeli` int(11) NOT NULL,
  `totalHargagrosir` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `grosir_rokok`
--

INSERT INTO `grosir_rokok` (`id`, `namaRokok`, `diskon`, `hargarokok`, `jumlahBeli`, `totalHargagrosir`) VALUES
(4, 'magnum', 0.1, 450000, 15, 6075000),
(5, 'Marlboro', 0.1, 250000, 10, 2250000),
(6, 'Soempoerna', 0.1, 255000, 17, 3901500),
(7, 'Surya', 0.1, 150000, 20, 2700000);

-- --------------------------------------------------------

--
-- Table structure for table `penjualanrokok_murah`
--

CREATE TABLE `penjualanrokok_murah` (
  `id` int(11) NOT NULL,
  `namaRokok` varchar(15) NOT NULL,
  `hargaRokok` int(11) NOT NULL,
  `jumlahBeli` int(11) NOT NULL,
  `jumlahTotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penjualanrokok_murah`
--

INSERT INTO `penjualanrokok_murah` (`id`, `namaRokok`, `hargaRokok`, `jumlahBeli`, `jumlahTotal`) VALUES
(17, 'Soempoerna', 2000, 2, 4000),
(18, 'Surya', 2000, 8, 16000),
(19, 'Marlboro', 2000, 3, 6000),
(23, 'magnum', 2000, 3, 6000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `grosir_rokok`
--
ALTER TABLE `grosir_rokok`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `penjualanrokok_murah`
--
ALTER TABLE `penjualanrokok_murah`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `grosir_rokok`
--
ALTER TABLE `grosir_rokok`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `penjualanrokok_murah`
--
ALTER TABLE `penjualanrokok_murah`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
