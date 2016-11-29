-- MySQL dump 10.16  Distrib 10.1.19-MariaDB, for Linux (x86_64)
--
-- Host: 50.87.144.43    Database: 50.87.144.43
-- ------------------------------------------------------
-- Server version	5.5.51-38.2

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
-- Table structure for table `GENER`
--

DROP TABLE IF EXISTS `GENER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GENER` (
  `gener_id` int(8) NOT NULL AUTO_INCREMENT,
  `gener_code` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gener_desc` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`gener_id`),
  UNIQUE KEY `gener_id` (`gener_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GENER`
--

LOCK TABLES `GENER` WRITE;
/*!40000 ALTER TABLE `GENER` DISABLE KEYS */;
INSERT INTO `GENER` VALUES (3,'GE01','FIXED ASSET'),(4,'GE02','CURRENT ASSET');
/*!40000 ALTER TABLE `GENER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UNITS`
--

DROP TABLE IF EXISTS `UNITS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UNITS` (
  `unit_id` int(8) NOT NULL AUTO_INCREMENT,
  `unit_desc` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`unit_id`),
  UNIQUE KEY `unit_id` (`unit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UNITS`
--

LOCK TABLES `UNITS` WRITE;
/*!40000 ALTER TABLE `UNITS` DISABLE KEYS */;
INSERT INTO `UNITS` VALUES (6,'PCS'),(7,'BAG'),(8,'SQUARE METER / M2'),(9,'CUBIC METER / M3'),(10,'LINEAR METER / LM'),(11,'BOX'),(12,'PACK'),(13,'CARTON / CRTN'),(14,'CM'),(15,'CM2'),(16,'CM3'),(17,'KG'),(18,'GRAM'),(19,'TON'),(20,'PAIL'),(21,'BUCKET'),(22,'SHEET'),(23,'ROLL'),(24,'TIME'),(25,'CAN'),(26,'DRUM'),(27,'FEET'),(28,'INCH'),(29,'GALLON'),(30,'LITER'),(31,'PAIR'),(32,'POUND'),(33,'SET'),(34,'ONE UNIT'),(35,'TRUCK'),(36,'TUBE'),(37,'YARD'),(38,'MILE'),(39,'KM'),(41,'MM'),(42,'OZ'),(43,'SEC'),(44,'PART'),(45,'CUBIC INCH'),(46,'CUBIC FEET'),(47,'HOUR'),(48,'DAY'),(49,'MONTH'),(50,'YEAR'),(51,'BOTTLE'),(52,'JAR'),(53,'BAR');
