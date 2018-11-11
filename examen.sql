-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-11-2018 a las 22:28:08
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `examen`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `restaurantes`
--

CREATE TABLE `restaurantes` (
  `idrest` int(10) NOT NULL,
  `nombrerest` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `descrest` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `dirtelrest` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `imagerest` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `evaluacion` varchar(10) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `restaurantes`
--

INSERT INTO `restaurantes` (`idrest`, `nombrerest`, `descrest`, `dirtelrest`, `imagerest`, `evaluacion`) VALUES
(2, 'pan de meza', 'muy rico', 'inft 466777', '@drawable/imagen1', '3'),
(3, 'super papas', 'papotas', 'gftrd 56788', '@drawable/imagen5', '2'),
(4, 'navidad', 'tgffg', 'sffh 44555', '@drawable/imagen6', '1'),
(5, 'el del mar', 'sabroso', 'aldama #4567, tel:4206547', '@drawable/imagen7', '2');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `restaurantes`
--
ALTER TABLE `restaurantes`
  ADD PRIMARY KEY (`idrest`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `restaurantes`
--
ALTER TABLE `restaurantes`
  MODIFY `idrest` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
