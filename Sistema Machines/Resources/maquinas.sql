-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-07-2018 a las 12:15:47
-- Versión del servidor: 10.1.30-MariaDB
-- Versión de PHP: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `maquinas`
--
CREATE DATABASE IF NOT EXISTS `maquinas` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `maquinas`;

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `DevolucionesCerrados`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `DevolucionesCerrados` (IN `idCaja` INT, IN `tipoDev` TINYINT)  BEGIN
	select dev.*, cte.totaldevolucion, cte.totaldevolucion5 from devolucion as dev, caja as c, corte as cte where c.id=idCaja and c.corte=1 and cte.caja=idCaja and dev.caja=idCaja and dev.tipo=tipoDev and dev.status=1;
END$$

DROP PROCEDURE IF EXISTS `GastosCerrados`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GastosCerrados` (IN `idCaja` INT)  BEGIN
select g.*, tg.nombre, cte.totalgastos from gasto as g, tipo_g as tg, caja as c, corte as cte where c.id=idCaja and c.corte=1 and cte.caja=idCaja and g.caja=idCaja and g.status=1 and g.tipo_gasto=tg.id and tg.status=1 ORDER BY g.id ASC;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caja`
--

DROP TABLE IF EXISTS `caja`;
CREATE TABLE `caja` (
  `id` int(11) NOT NULL,
  `monto1` int(11) NOT NULL,
  `monto5` int(11) DEFAULT NULL,
  `fecha` date NOT NULL,
  `corte` tinyint(1) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- RELACIONES PARA LA TABLA `caja`:
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `corte`
--

DROP TABLE IF EXISTS `corte`;
CREATE TABLE `corte` (
  `id` int(11) NOT NULL,
  `caja` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `totaldevolucion` int(11) NOT NULL,
  `totaldevolucion5` int(11) NOT NULL,
  `totalgastos` double NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- RELACIONES PARA LA TABLA `corte`:
--   `caja`
--       `caja` -> `id`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `devolucion`
--

DROP TABLE IF EXISTS `devolucion`;
CREATE TABLE `devolucion` (
  `id` int(11) NOT NULL,
  `caja` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `tipo` tinyint(1) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- RELACIONES PARA LA TABLA `devolucion`:
--   `caja`
--       `caja` -> `id`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gasto`
--

DROP TABLE IF EXISTS `gasto`;
CREATE TABLE `gasto` (
  `id` int(11) NOT NULL,
  `otro_g` varchar(100) DEFAULT NULL,
  `fecha` date NOT NULL,
  `gasto` double NOT NULL,
  `status` tinyint(1) NOT NULL,
  `tipo_gasto` int(11) NOT NULL,
  `caja` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- RELACIONES PARA LA TABLA `gasto`:
--   `tipo_gasto`
--       `tipo_g` -> `id`
--   `caja`
--       `caja` -> `id`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_g`
--

DROP TABLE IF EXISTS `tipo_g`;
CREATE TABLE `tipo_g` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- RELACIONES PARA LA TABLA `tipo_g`:
--

--
-- Volcado de datos para la tabla `tipo_g`
--

INSERT INTO `tipo_g` (`id`, `nombre`, `descripcion`, `status`) VALUES
(1, 'Otro', 'Otro tipo de gasto', 1),
(2, 'Pago de Internet', 'Pago de internet', 1),
(3, 'Pago de luz', 'Pago de Luz', 1),
(4, 'Pago de renta', 'Pago de renta', 1),
(5, 'Pago de sueldo', 'Sueldo trabajador', 1);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vistacajaclose`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `vistacajaclose`;
CREATE TABLE `vistacajaclose` (
`id` int(11)
,`monto1` int(11)
,`monto5` int(11)
,`fecha` date
,`corte` tinyint(1)
,`status` tinyint(1)
,`idCorte` int(11)
,`fechaCorte` date
,`totaldevolucion` int(11)
,`totaldevolucion5` int(11)
,`totalgastos` double
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vistacajaopen`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `vistacajaopen`;
CREATE TABLE `vistacajaopen` (
`id` int(11)
,`monto1` int(11)
,`monto5` int(11)
,`fecha` date
,`corte` tinyint(1)
,`status` tinyint(1)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vistadevoluciones`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `vistadevoluciones`;
CREATE TABLE `vistadevoluciones` (
`id` int(11)
,`caja` int(11)
,`fecha` date
,`tipo` tinyint(1)
,`cantidad` int(11)
,`status` tinyint(1)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vistadevoluciones1`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `vistadevoluciones1`;
CREATE TABLE `vistadevoluciones1` (
`id` int(11)
,`caja` int(11)
,`fecha` date
,`tipo` tinyint(1)
,`cantidad` int(11)
,`status` tinyint(1)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vistadevoluciones5`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `vistadevoluciones5`;
CREATE TABLE `vistadevoluciones5` (
`id` int(11)
,`caja` int(11)
,`fecha` date
,`tipo` tinyint(1)
,`cantidad` int(11)
,`status` tinyint(1)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vistagastos`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `vistagastos`;
CREATE TABLE `vistagastos` (
`id` int(11)
,`otro_g` varchar(100)
,`fecha` date
,`gasto` double
,`status` tinyint(1)
,`tipo_gasto` int(11)
,`caja` int(11)
,`nombre` varchar(50)
,`descripcion` varchar(100)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `vistacajaclose`
--
DROP TABLE IF EXISTS `vistacajaclose`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vistacajaclose`  AS  select `caja`.`id` AS `id`,`caja`.`monto1` AS `monto1`,`caja`.`monto5` AS `monto5`,`caja`.`fecha` AS `fecha`,`caja`.`corte` AS `corte`,`caja`.`status` AS `status`,`corte`.`id` AS `idCorte`,`corte`.`fecha` AS `fechaCorte`,`corte`.`totaldevolucion` AS `totaldevolucion`,`corte`.`totaldevolucion5` AS `totaldevolucion5`,`corte`.`totalgastos` AS `totalgastos` from (`caja` join `corte`) where ((`caja`.`corte` = 1) and (`caja`.`status` = 1) and (`corte`.`status` = 1) and (`caja`.`id` = `corte`.`caja`)) order by `caja`.`id` desc ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vistacajaopen`
--
DROP TABLE IF EXISTS `vistacajaopen`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vistacajaopen`  AS  select `caja`.`id` AS `id`,`caja`.`monto1` AS `monto1`,`caja`.`monto5` AS `monto5`,`caja`.`fecha` AS `fecha`,`caja`.`corte` AS `corte`,`caja`.`status` AS `status` from `caja` where ((`caja`.`corte` = 0) and (`caja`.`status` = 1)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vistadevoluciones`
--
DROP TABLE IF EXISTS `vistadevoluciones`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vistadevoluciones`  AS  select `devolucion`.`id` AS `id`,`devolucion`.`caja` AS `caja`,`devolucion`.`fecha` AS `fecha`,`devolucion`.`tipo` AS `tipo`,`devolucion`.`cantidad` AS `cantidad`,`devolucion`.`status` AS `status` from (`devolucion` join `caja`) where ((`caja`.`corte` = 0) and (`caja`.`status` = 1) and (`caja`.`id` = `devolucion`.`caja`) and (`devolucion`.`status` = 1)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vistadevoluciones1`
--
DROP TABLE IF EXISTS `vistadevoluciones1`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vistadevoluciones1`  AS  select `devolucion`.`id` AS `id`,`devolucion`.`caja` AS `caja`,`devolucion`.`fecha` AS `fecha`,`devolucion`.`tipo` AS `tipo`,`devolucion`.`cantidad` AS `cantidad`,`devolucion`.`status` AS `status` from (`devolucion` join `caja`) where ((`devolucion`.`tipo` = 0) and (`caja`.`corte` = 0) and (`caja`.`status` = 1) and (`caja`.`id` = `devolucion`.`caja`) and (`devolucion`.`status` = 1)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vistadevoluciones5`
--
DROP TABLE IF EXISTS `vistadevoluciones5`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vistadevoluciones5`  AS  select `devolucion`.`id` AS `id`,`devolucion`.`caja` AS `caja`,`devolucion`.`fecha` AS `fecha`,`devolucion`.`tipo` AS `tipo`,`devolucion`.`cantidad` AS `cantidad`,`devolucion`.`status` AS `status` from (`devolucion` join `caja`) where ((`devolucion`.`tipo` = 1) and (`caja`.`corte` = 0) and (`caja`.`status` = 1) and (`caja`.`id` = `devolucion`.`caja`) and (`devolucion`.`status` = 1)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vistagastos`
--
DROP TABLE IF EXISTS `vistagastos`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vistagastos`  AS  select `gasto`.`id` AS `id`,`gasto`.`otro_g` AS `otro_g`,`gasto`.`fecha` AS `fecha`,`gasto`.`gasto` AS `gasto`,`gasto`.`status` AS `status`,`gasto`.`tipo_gasto` AS `tipo_gasto`,`gasto`.`caja` AS `caja`,`g`.`nombre` AS `nombre`,`g`.`descripcion` AS `descripcion` from ((`tipo_g` `g` join `gasto`) join `caja`) where ((`caja`.`corte` = 0) and (`caja`.`id` = `gasto`.`caja`) and (`g`.`id` = `gasto`.`tipo_gasto`) and (`gasto`.`status` = 1) and (`g`.`status` = 1)) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `caja`
--
ALTER TABLE `caja`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `corte`
--
ALTER TABLE `corte`
  ADD PRIMARY KEY (`id`),
  ADD KEY `caja` (`caja`);

--
-- Indices de la tabla `devolucion`
--
ALTER TABLE `devolucion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `caja` (`caja`);

--
-- Indices de la tabla `gasto`
--
ALTER TABLE `gasto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tipo_gasto` (`tipo_gasto`),
  ADD KEY `caja` (`caja`);

--
-- Indices de la tabla `tipo_g`
--
ALTER TABLE `tipo_g`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `caja`
--
ALTER TABLE `caja`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `corte`
--
ALTER TABLE `corte`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `devolucion`
--
ALTER TABLE `devolucion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `gasto`
--
ALTER TABLE `gasto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_g`
--
ALTER TABLE `tipo_g`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `corte`
--
ALTER TABLE `corte`
  ADD CONSTRAINT `corte_ibfk_1` FOREIGN KEY (`caja`) REFERENCES `caja` (`id`);

--
-- Filtros para la tabla `devolucion`
--
ALTER TABLE `devolucion`
  ADD CONSTRAINT `devolucion_ibfk_1` FOREIGN KEY (`caja`) REFERENCES `caja` (`id`);

--
-- Filtros para la tabla `gasto`
--
ALTER TABLE `gasto`
  ADD CONSTRAINT `gasto_ibfk_1` FOREIGN KEY (`tipo_gasto`) REFERENCES `tipo_g` (`id`),
  ADD CONSTRAINT `gasto_ibfk_2` FOREIGN KEY (`caja`) REFERENCES `caja` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
