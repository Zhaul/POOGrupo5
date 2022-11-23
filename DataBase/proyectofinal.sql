-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 23-11-2022 a las 08:48:31
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectofinal`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `areas`
--

CREATE TABLE `areas` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `status` char(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `areas`
--

INSERT INTO `areas` (`id`, `name`, `description`, `status`) VALUES
(1, 'Recursos Humanos', 'qqq', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargosPersonal`
--

CREATE TABLE `cargosPersonal` (
  `id` int(11) NOT NULL,
  `idArea` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `status` char(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `employees`
--

CREATE TABLE `employees` (
  `id` int(11) NOT NULL,
  `names` varchar(60) NOT NULL,
  `lastNames` varchar(60) NOT NULL,
  `typeDocument` varchar(1) NOT NULL,
  `numberDocument` varchar(15) NOT NULL,
  `idCargo` int(11) NOT NULL,
  `idRol` int(11) NOT NULL,
  `status` char(1) NOT NULL DEFAULT '1',
  `email` varchar(100) DEFAULT NULL,
  `sex` char(1) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `dateBirth` date DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `dateStart` date DEFAULT NULL,
  `password` varchar(150) DEFAULT NULL,
  `flagAccess` char(1) DEFAULT NULL,
  `codeEmployee` varchar(45) NOT NULL,
  `user` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `justifications`
--

CREATE TABLE `justifications` (
  `id` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `file` varchar(150) DEFAULT NULL,
  `reason` varchar(100) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `idShedule` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisoRol`
--

CREATE TABLE `permisoRol` (
  `idPermiso` char(3) NOT NULL,
  `idRol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisos`
--

CREATE TABLE `permisos` (
  `id` char(3) NOT NULL,
  `name` varchar(100) NOT NULL,
  `orden` int(11) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `status` char(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `status` char(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `schedules`
--

CREATE TABLE `schedules` (
  `id` int(11) NOT NULL,
  `hourStart` time DEFAULT NULL,
  `dateStart` date DEFAULT NULL,
  `idEmploye` int(11) NOT NULL,
  `hourEntry` time DEFAULT NULL,
  `status` char(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `areas`
--
ALTER TABLE `areas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `NameUnique` (`name`);

--
-- Indices de la tabla `cargosPersonal`
--
ALTER TABLE `cargosPersonal`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `FK_CargoAreas` (`idArea`);

--
-- Indices de la tabla `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codeEmployee` (`codeEmployee`),
  ADD KEY `FKEmpleadoCargo` (`idCargo`),
  ADD KEY `FKEmpleadoRol` (`idRol`);

--
-- Indices de la tabla `justifications`
--
ALTER TABLE `justifications`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKJustificationShedule` (`idShedule`);

--
-- Indices de la tabla `permisoRol`
--
ALTER TABLE `permisoRol`
  ADD KEY `FK_PermisoRol` (`idPermiso`),
  ADD KEY `FK_RolPermiso` (`idRol`);

--
-- Indices de la tabla `permisos`
--
ALTER TABLE `permisos`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indices de la tabla `schedules`
--
ALTER TABLE `schedules`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKEmployeSchedule` (`idEmploye`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `areas`
--
ALTER TABLE `areas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `cargosPersonal`
--
ALTER TABLE `cargosPersonal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `employees`
--
ALTER TABLE `employees`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `justifications`
--
ALTER TABLE `justifications`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `schedules`
--
ALTER TABLE `schedules`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cargosPersonal`
--
ALTER TABLE `cargosPersonal`
  ADD CONSTRAINT `FK_CargoAreas` FOREIGN KEY (`idArea`) REFERENCES `areas` (`id`);

--
-- Filtros para la tabla `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `FKEmpleadoCargo` FOREIGN KEY (`idCargo`) REFERENCES `cargosPersonal` (`id`),
  ADD CONSTRAINT `FKEmpleadoRol` FOREIGN KEY (`idRol`) REFERENCES `roles` (`id`);

--
-- Filtros para la tabla `justifications`
--
ALTER TABLE `justifications`
  ADD CONSTRAINT `FKJustificationShedule` FOREIGN KEY (`idShedule`) REFERENCES `schedules` (`id`);

--
-- Filtros para la tabla `permisoRol`
--
ALTER TABLE `permisoRol`
  ADD CONSTRAINT `FK_PermisoRol` FOREIGN KEY (`idPermiso`) REFERENCES `permisos` (`id`),
  ADD CONSTRAINT `FK_RolPermiso` FOREIGN KEY (`idRol`) REFERENCES `roles` (`id`);

--
-- Filtros para la tabla `schedules`
--
ALTER TABLE `schedules`
  ADD CONSTRAINT `FKEmployeSchedule` FOREIGN KEY (`idEmploye`) REFERENCES `employees` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
