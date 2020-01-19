-- MySQL dump 10.16  Distrib 10.1.30-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: maquinas
-- ------------------------------------------------------
-- Server version	10.1.30-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `maquinas`
--

/*!40000 DROP DATABASE IF EXISTS `maquinas`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `maquinas` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `maquinas`;

--
-- Table structure for table `caja`
--

DROP TABLE IF EXISTS `caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caja` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `monto1` int(11) NOT NULL,
  `monto5` int(11) DEFAULT NULL,
  `fecha` date NOT NULL,
  `corte` tinyint(1) NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caja`
--

LOCK TABLES `caja` WRITE;
/*!40000 ALTER TABLE `caja` DISABLE KEYS */;
INSERT INTO `caja` (`id`, `monto1`, `monto5`, `fecha`, `corte`, `status`) VALUES (1,10000,50000,'2018-09-23',0,1);
/*!40000 ALTER TABLE `caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corte`
--

DROP TABLE IF EXISTS `corte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `corte` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `caja` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `totaldevolucion` int(11) NOT NULL,
  `totaldevolucion5` int(11) NOT NULL,
  `totalgastos` double NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `caja` (`caja`),
  CONSTRAINT `corte_ibfk_1` FOREIGN KEY (`caja`) REFERENCES `caja` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corte`
--

LOCK TABLES `corte` WRITE;
/*!40000 ALTER TABLE `corte` DISABLE KEYS */;
/*!40000 ALTER TABLE `corte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `devolucion`
--

DROP TABLE IF EXISTS `devolucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `devolucion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `caja` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `tipo` tinyint(1) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `caja` (`caja`),
  CONSTRAINT `devolucion_ibfk_1` FOREIGN KEY (`caja`) REFERENCES `caja` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devolucion`
--

LOCK TABLES `devolucion` WRITE;
/*!40000 ALTER TABLE `devolucion` DISABLE KEYS */;
INSERT INTO `devolucion` (`id`, `caja`, `fecha`, `tipo`, `cantidad`, `status`) VALUES (1,1,'2018-09-23',0,5000,1);
/*!40000 ALTER TABLE `devolucion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gasto`
--

DROP TABLE IF EXISTS `gasto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gasto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `otro_g` varchar(100) DEFAULT NULL,
  `fecha` date NOT NULL,
  `gasto` double NOT NULL,
  `status` tinyint(1) NOT NULL,
  `tipo_gasto` int(11) NOT NULL,
  `caja` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tipo_gasto` (`tipo_gasto`),
  KEY `caja` (`caja`),
  CONSTRAINT `gasto_ibfk_1` FOREIGN KEY (`tipo_gasto`) REFERENCES `tipo_g` (`id`),
  CONSTRAINT `gasto_ibfk_2` FOREIGN KEY (`caja`) REFERENCES `caja` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gasto`
--

LOCK TABLES `gasto` WRITE;
/*!40000 ALTER TABLE `gasto` DISABLE KEYS */;
INSERT INTO `gasto` (`id`, `otro_g`, `fecha`, `gasto`, `status`, `tipo_gasto`, `caja`) VALUES (1,'Internet','2018-09-23',500,1,2,1);
/*!40000 ALTER TABLE `gasto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_g`
--

DROP TABLE IF EXISTS `tipo_g`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_g` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_g`
--

LOCK TABLES `tipo_g` WRITE;
/*!40000 ALTER TABLE `tipo_g` DISABLE KEYS */;
INSERT INTO `tipo_g` (`id`, `nombre`, `descripcion`, `status`) VALUES (1,'Otro','Otro tipo de gasto',1),(2,'Pago de Internet','Pago de internet',1),(3,'Pago de luz','Pago de Luz',1),(4,'Pago de renta','Pago de renta',1),(5,'Pago de sueldo','Sueldo trabajador',1);
/*!40000 ALTER TABLE `tipo_g` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `vistacajaclose`
--

DROP TABLE IF EXISTS `vistacajaclose`;
/*!50001 DROP VIEW IF EXISTS `vistacajaclose`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vistacajaclose` (
  `id` tinyint NOT NULL,
  `monto1` tinyint NOT NULL,
  `monto5` tinyint NOT NULL,
  `fecha` tinyint NOT NULL,
  `corte` tinyint NOT NULL,
  `status` tinyint NOT NULL,
  `idCorte` tinyint NOT NULL,
  `fechaCorte` tinyint NOT NULL,
  `totaldevolucion` tinyint NOT NULL,
  `totaldevolucion5` tinyint NOT NULL,
  `totalgastos` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vistacajaopen`
--

DROP TABLE IF EXISTS `vistacajaopen`;
/*!50001 DROP VIEW IF EXISTS `vistacajaopen`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vistacajaopen` (
  `id` tinyint NOT NULL,
  `monto1` tinyint NOT NULL,
  `monto5` tinyint NOT NULL,
  `fecha` tinyint NOT NULL,
  `corte` tinyint NOT NULL,
  `status` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vistadevoluciones`
--

DROP TABLE IF EXISTS `vistadevoluciones`;
/*!50001 DROP VIEW IF EXISTS `vistadevoluciones`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vistadevoluciones` (
  `id` tinyint NOT NULL,
  `caja` tinyint NOT NULL,
  `fecha` tinyint NOT NULL,
  `tipo` tinyint NOT NULL,
  `cantidad` tinyint NOT NULL,
  `status` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vistadevoluciones1`
--

DROP TABLE IF EXISTS `vistadevoluciones1`;
/*!50001 DROP VIEW IF EXISTS `vistadevoluciones1`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vistadevoluciones1` (
  `id` tinyint NOT NULL,
  `caja` tinyint NOT NULL,
  `fecha` tinyint NOT NULL,
  `tipo` tinyint NOT NULL,
  `cantidad` tinyint NOT NULL,
  `status` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vistadevoluciones5`
--

DROP TABLE IF EXISTS `vistadevoluciones5`;
/*!50001 DROP VIEW IF EXISTS `vistadevoluciones5`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vistadevoluciones5` (
  `id` tinyint NOT NULL,
  `caja` tinyint NOT NULL,
  `fecha` tinyint NOT NULL,
  `tipo` tinyint NOT NULL,
  `cantidad` tinyint NOT NULL,
  `status` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vistagastos`
--

DROP TABLE IF EXISTS `vistagastos`;
/*!50001 DROP VIEW IF EXISTS `vistagastos`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vistagastos` (
  `id` tinyint NOT NULL,
  `otro_g` tinyint NOT NULL,
  `fecha` tinyint NOT NULL,
  `gasto` tinyint NOT NULL,
  `status` tinyint NOT NULL,
  `tipo_gasto` tinyint NOT NULL,
  `caja` tinyint NOT NULL,
  `nombre` tinyint NOT NULL,
  `descripcion` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'maquinas'
--
/*!50003 DROP PROCEDURE IF EXISTS `DevolucionesCerrados` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `DevolucionesCerrados`(IN `idCaja` INT, IN `tipoDev` TINYINT)
BEGIN
	select dev.*, cte.totaldevolucion, cte.totaldevolucion5 from devolucion as dev, caja as c, corte as cte where c.id=idCaja and c.corte=1 and cte.caja=idCaja and dev.caja=idCaja and dev.tipo=tipoDev and dev.status=1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GastosCerrados` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GastosCerrados`(IN `idCaja` INT)
BEGIN
select g.*, tg.nombre, cte.totalgastos from gasto as g, tipo_g as tg, caja as c, corte as cte where c.id=idCaja and c.corte=1 and cte.caja=idCaja and g.caja=idCaja and g.status=1 and g.tipo_gasto=tg.id and tg.status=1 ORDER BY g.id ASC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Current Database: `maquinas`
--

USE `maquinas`;

--
-- Final view structure for view `vistacajaclose`
--

/*!50001 DROP TABLE IF EXISTS `vistacajaclose`*/;
/*!50001 DROP VIEW IF EXISTS `vistacajaclose`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vistacajaclose` AS select `caja`.`id` AS `id`,`caja`.`monto1` AS `monto1`,`caja`.`monto5` AS `monto5`,`caja`.`fecha` AS `fecha`,`caja`.`corte` AS `corte`,`caja`.`status` AS `status`,`corte`.`id` AS `idCorte`,`corte`.`fecha` AS `fechaCorte`,`corte`.`totaldevolucion` AS `totaldevolucion`,`corte`.`totaldevolucion5` AS `totaldevolucion5`,`corte`.`totalgastos` AS `totalgastos` from (`caja` join `corte`) where ((`caja`.`corte` = 1) and (`caja`.`status` = 1) and (`corte`.`status` = 1) and (`caja`.`id` = `corte`.`caja`)) order by `caja`.`id` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vistacajaopen`
--

/*!50001 DROP TABLE IF EXISTS `vistacajaopen`*/;
/*!50001 DROP VIEW IF EXISTS `vistacajaopen`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vistacajaopen` AS select `caja`.`id` AS `id`,`caja`.`monto1` AS `monto1`,`caja`.`monto5` AS `monto5`,`caja`.`fecha` AS `fecha`,`caja`.`corte` AS `corte`,`caja`.`status` AS `status` from `caja` where ((`caja`.`corte` = 0) and (`caja`.`status` = 1)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vistadevoluciones`
--

/*!50001 DROP TABLE IF EXISTS `vistadevoluciones`*/;
/*!50001 DROP VIEW IF EXISTS `vistadevoluciones`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vistadevoluciones` AS select `devolucion`.`id` AS `id`,`devolucion`.`caja` AS `caja`,`devolucion`.`fecha` AS `fecha`,`devolucion`.`tipo` AS `tipo`,`devolucion`.`cantidad` AS `cantidad`,`devolucion`.`status` AS `status` from (`devolucion` join `caja`) where ((`caja`.`corte` = 0) and (`caja`.`status` = 1) and (`caja`.`id` = `devolucion`.`caja`) and (`devolucion`.`status` = 1)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vistadevoluciones1`
--

/*!50001 DROP TABLE IF EXISTS `vistadevoluciones1`*/;
/*!50001 DROP VIEW IF EXISTS `vistadevoluciones1`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vistadevoluciones1` AS select `devolucion`.`id` AS `id`,`devolucion`.`caja` AS `caja`,`devolucion`.`fecha` AS `fecha`,`devolucion`.`tipo` AS `tipo`,`devolucion`.`cantidad` AS `cantidad`,`devolucion`.`status` AS `status` from (`devolucion` join `caja`) where ((`devolucion`.`tipo` = 0) and (`caja`.`corte` = 0) and (`caja`.`status` = 1) and (`caja`.`id` = `devolucion`.`caja`) and (`devolucion`.`status` = 1)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vistadevoluciones5`
--

/*!50001 DROP TABLE IF EXISTS `vistadevoluciones5`*/;
/*!50001 DROP VIEW IF EXISTS `vistadevoluciones5`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vistadevoluciones5` AS select `devolucion`.`id` AS `id`,`devolucion`.`caja` AS `caja`,`devolucion`.`fecha` AS `fecha`,`devolucion`.`tipo` AS `tipo`,`devolucion`.`cantidad` AS `cantidad`,`devolucion`.`status` AS `status` from (`devolucion` join `caja`) where ((`devolucion`.`tipo` = 1) and (`caja`.`corte` = 0) and (`caja`.`status` = 1) and (`caja`.`id` = `devolucion`.`caja`) and (`devolucion`.`status` = 1)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vistagastos`
--

/*!50001 DROP TABLE IF EXISTS `vistagastos`*/;
/*!50001 DROP VIEW IF EXISTS `vistagastos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vistagastos` AS select `gasto`.`id` AS `id`,`gasto`.`otro_g` AS `otro_g`,`gasto`.`fecha` AS `fecha`,`gasto`.`gasto` AS `gasto`,`gasto`.`status` AS `status`,`gasto`.`tipo_gasto` AS `tipo_gasto`,`gasto`.`caja` AS `caja`,`g`.`nombre` AS `nombre`,`g`.`descripcion` AS `descripcion` from ((`tipo_g` `g` join `gasto`) join `caja`) where ((`caja`.`corte` = 0) and (`caja`.`id` = `gasto`.`caja`) and (`g`.`id` = `gasto`.`tipo_gasto`) and (`gasto`.`status` = 1) and (`g`.`status` = 1)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-07 19:08:16
