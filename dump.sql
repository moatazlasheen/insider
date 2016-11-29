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
-- Table structure for table `gener`
--

DROP TABLE IF EXISTS `gener`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gener` (
  `gener_id` int(8) NOT NULL AUTO_INCREMENT,
  `gener_code` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gener_desc` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`gener_id`),
  UNIQUE KEY `gener_id` (`gener_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gener`
--

LOCK TABLES `gener` WRITE;
/*!40000 ALTER TABLE `gener` DISABLE KEYS */;
INSERT INTO `gener` VALUES (3,'GE01','FIXED ASSET'),(4,'GE02','CURRENT ASSET');
/*!40000 ALTER TABLE `gener` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gener_materials`
--

DROP TABLE IF EXISTS `gener_materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gener_materials` (
  `gener_id` int(11) NOT NULL DEFAULT '0',
  `material_id` int(11) NOT NULL DEFAULT '0',
  `description` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`gener_id`,`material_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gener_materials`
--

LOCK TABLES `gener_materials` WRITE;
/*!40000 ALTER TABLE `gener_materials` DISABLE KEYS */;
/*!40000 ALTER TABLE `gener_materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_description`
--

DROP TABLE IF EXISTS `item_description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_description` (
  `item_id` int(8) NOT NULL AUTO_INCREMENT,
  `item_code` int(8) NOT NULL DEFAULT '0',
  `item_desc` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `item_type_id` int(8) NOT NULL DEFAULT '0',
  `unit_id` int(8) unsigned NOT NULL DEFAULT '0',
  `upload` blob,
  `udf_1` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `udf_2` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `udf_3` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `udf_4` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `udf_5` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gener_id` int(8) unsigned NOT NULL DEFAULT '0',
  `upload_file_name` varchar(150) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  UNIQUE KEY `item_id` (`item_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_description`
--

LOCK TABLES `item_description` WRITE;
/*!40000 ALTER TABLE `item_description` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_description` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_description_type`
--

DROP TABLE IF EXISTS `item_description_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_description_type` (
  `item_type_id` int(8) NOT NULL AUTO_INCREMENT,
  `material_type_id` int(8) unsigned NOT NULL DEFAULT '0',
  `material_category_id` int(8) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`item_type_id`),
  UNIQUE KEY `item_type_id` (`item_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_description_type`
--

LOCK TABLES `item_description_type` WRITE;
/*!40000 ALTER TABLE `item_description_type` DISABLE KEYS */;
INSERT INTO `item_description_type` VALUES (1,3,0);
/*!40000 ALTER TABLE `item_description_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material_type`
--

DROP TABLE IF EXISTS `material_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `material_type` (
  `material_type_id` int(8) NOT NULL AUTO_INCREMENT,
  `item_type_desc` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`material_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material_type`
--

LOCK TABLES `material_type` WRITE;
/*!40000 ALTER TABLE `material_type` DISABLE KEYS */;
INSERT INTO `material_type` VALUES (2,'BRICK WORK'),(3,'GYPSUM BOARD - WALL BOARD'),(4,'GYPSUM BOARD - CEILING BOARD'),(5,'GYPSUM BOARD - CEILING METAL FRAMING SYSTEM'),(6,'GYPSUM BOARD - WALL METAL FRAMING SYSTEM'),(7,'INTERNAL NORMAL PAINT'),(8,'EXTERNAL NORMAL PAINT'),(9,'INTERNAL EPOXY PAINT'),(10,'EXTERNAL EPOXY PAINT'),(11,'CONCRETE REPAIR'),(12,'CONCRETE ENHANCEMENT'),(13,'ELECTRICAL CABLES'),(14,'BLACK CEMENT'),(15,'WHITE CEMENT'),(16,'CEMENT BOARD'),(17,'MARBLE'),(18,'GRANITE');
/*!40000 ALTER TABLE `material_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `units`
--

DROP TABLE IF EXISTS `units`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `units` (
  `unit_id` int(8) NOT NULL AUTO_INCREMENT,
  `unit_desc` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`unit_id`),
  UNIQUE KEY `unit_id` (`unit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `units`
--

LOCK TABLES `units` WRITE;
/*!40000 ALTER TABLE `units` DISABLE KEYS */;
INSERT INTO `units` VALUES (6,'PCS'),(7,'BAG'),(8,'SQUARE METER / M2'),(9,'CUBIC METER / M3'),(10,'LINEAR METER / LM'),(11,'BOX'),(12,'PACK'),(13,'CARTON / CRTN'),(14,'CM'),(15,'CM2'),(16,'CM3'),(17,'KG'),(18,'GRAM'),(19,'TON'),(20,'PAIL'),(21,'BUCKET'),(22,'SHEET'),(23,'ROLL'),(24,'TIME'),(25,'CAN'),(26,'DRUM'),(27,'FEET'),(28,'INCH'),(29,'GALLON'),(30,'LITER'),(31,'PAIR'),(32,'POUND'),(33,'SET'),(34,'ONE UNIT'),(35,'TRUCK'),(36,'TUBE'),(37,'YARD'),(38,'MILE'),(39,'KM'),(41,'MM'),(42,'OZ'),(43,'SEC'),(44,'PART'),(45,'CUBIC INCH'),(46,'CUBIC FEET'),(47,'HOUR'),(48,'DAY'),(49,'MONTH'),(50,'YEAR'),(51,'BOTTLE'),(52,'JAR'),(53,'BAR');
/*!40000 ALTER TABLE `units` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-29 10:20:35
