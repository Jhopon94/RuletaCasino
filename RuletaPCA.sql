-- phpMyAdmin SQL Dump
-- version 4.1.14.3
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 22-08-2023 a las 20:05:48
-- Versión del servidor: 5.1.73
-- Versión de PHP: 5.5.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `RuletaPCA`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apostadores`
--

CREATE TABLE IF NOT EXISTS `apostadores` (
  `id` int(20) NOT NULL,
  `cedula` int(20) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `nacimiento` date NOT NULL,
  `saldo` int(20) NOT NULL,
  PRIMARY KEY (`id`,`cedula`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `apostadores`
--

INSERT INTO `apostadores` (`id`, `cedula`, `nombre`, `nacimiento`, `saldo`) VALUES
(789456, 789456, 'Micaela Hernandez', '1994-11-30', 15615),
(456123, 456123, 'Jesus Adrian', '1997-12-12', 16467),
(654645, 654645, 'Juan Camilo', '1994-11-30', 53755),
(123456, 123456, 'John Hader', '1994-11-30', 15624);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apuesta`
--

CREATE TABLE IF NOT EXISTS `apuesta` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `fechayHora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cantidadApostadores` int(20) NOT NULL,
  `totalApostado` int(50) NOT NULL,
  `gananciasCasino` int(50) NOT NULL,
  `cantidadjuegos` int(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=61 ;

--
-- Volcado de datos para la tabla `apuesta`
--

INSERT INTO `apuesta` (`id`, `fechayHora`, `cantidadApostadores`, `totalApostado`, `gananciasCasino`, `cantidadjuegos`) VALUES
(60, '2023-08-15 16:28:07', 176, 2160216, 187168, 44);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
