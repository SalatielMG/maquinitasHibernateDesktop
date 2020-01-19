DROP DATABASE IF EXISTS `machine`;
CREATE DATABASE IF NOT EXISTS `machine` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
-- USE `montezco_machine`;
USE `machine`;

DROP TABLE IF EXISTS `caja`;
CREATE TABLE `caja` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `monto1` int(11) NOT NULL,
  `monto5` int(11) NOT NULL,
  `fechaAbierto` date NOT NULL,
  `corte` tinyint(1) NOT NULL,
  `fechaCorte` date NULL,
  `totaldevolucion1` int(11) DEFAULT 0,
  `totaldevolucion5` int(11) DEFAULT 0,
  `totalgastos` double DEFAULT 0.0,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `devolucion`;
CREATE TABLE `devolucion` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `caja` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `tipo` tinyint(1) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL,
  FOREIGN KEY (`caja`) REFERENCES `caja` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tipogasto`;
CREATE TABLE `tipogasto` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `gasto`;
CREATE TABLE `gasto` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `caja` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `gasto` double NOT NULL,  
  `tipo` int(11) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  FOREIGN KEY (`caja`) REFERENCES `caja` (`id`),
  FOREIGN KEY (`tipo`) REFERENCES `tipogasto` (`id`)   
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `tipogasto` (`id`, `nombre`, `descripcion`, `status`) VALUES
(1, 'Otro', 'Otro tipo de gasto', 1),
(2, 'Pago de Internet', 'Pago de internet', 1),
(3, 'Pago de luz', 'Pago de Luz', 1),
(4, 'Pago de renta', 'Pago de renta', 1),
(5, 'Pago de sueldo', 'Sueldo trabajador', 1);


CREATE VIEW
  `vistacajaclose` AS  
select * from `caja` where `corte` = 1 and `status` = 1  order by `id` desc ;

CREATE VIEW
  `vistacajaopen` AS  
select * from `caja` where `corte` = 0 and `status` = 1  order by `id` desc ;

CREATE VIEW 
  `vistadevoluciones`  AS    
select dev.* from devolucion AS dev, vistacajaopen AS vco where vco.id = dev.caja and dev.status = 1;

CREATE VIEW
  `vistadevoluciones1`  AS  
select vd.* from vistadevoluciones AS vd, vistacajaopen AS vco where vd.tipo = 0 and vco.id = vd.caja and vd.status = 1;

CREATE VIEW
  `vistadevoluciones5`  AS  
select vd.* from vistadevoluciones AS vd, vistacajaopen AS vco where vd.tipo = 1 and vco.id = vd.caja and vd.status = 1;

CREATE VIEW
  `vistagastos`  AS  
select g.*, tp.id as idTipo, tp.nombre, tp.descripcion as descripciontipogasto from gasto AS g, tipogasto as tp, vistacajaopen AS vco where vco.id = g.caja and g.status = 1 and tp.id = g.tipo and tp.status = 1;

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `DevolucionesCerrados`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `DevolucionesCerrados` (IN `idCaja` INT, IN `tipoDev` TINYINT)  BEGIN
	select dev.*, vcc.totaldevolucion1, vcc.totaldevolucion5 
	from devolucion as dev, vistacajaclose as vcc
	where 
	vcc.id = idCaja 
	and dev.caja = idCaja 
	and dev.tipo = tipoDev 
	and dev.status = 1;
END$$

DROP PROCEDURE IF EXISTS `GastosCerrados`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GastosCerrados` (IN `idCaja` INT)  BEGIN
select g.*, tg.nombre, vcc.totalgastos 
from vistacajaclose as vcc, gasto as g, tipogasto as tg
where 
vcc.id = idCaja
and g.caja = idCaja 
and g.status = 1 
and g.tipo = tg.id 
and tg.status = 1 
ORDER BY g.id ASC;
END$$

DELIMITER ;
