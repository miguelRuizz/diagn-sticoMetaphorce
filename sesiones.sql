-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: sesiones
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asistencia`
--

DROP TABLE IF EXISTS `asistencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asistencia` (
  `id_usuario` int NOT NULL,
  `id_sesion` int NOT NULL,
  `id_estatus` int NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_sesion`),
  KEY `fk_2` (`id_sesion`),
  KEY `fk_3` (`id_estatus`),
  CONSTRAINT `fk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `fk_2` FOREIGN KEY (`id_sesion`) REFERENCES `sesion` (`id_sesion`),
  CONSTRAINT `fk_3` FOREIGN KEY (`id_estatus`) REFERENCES `estatus` (`id_estatus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistencia`
--

LOCK TABLES `asistencia` WRITE;
/*!40000 ALTER TABLE `asistencia` DISABLE KEYS */;
INSERT INTO `asistencia` VALUES (1,1,1),(1,2,1),(1,3,1),(1,5,1),(1,6,1),(1,7,1),(1,8,1),(1,9,1),(1,10,1),(2,2,1),(2,3,1),(1,4,2),(2,1,2);
/*!40000 ALTER TABLE `asistencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estatus`
--

DROP TABLE IF EXISTS `estatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estatus` (
  `id_estatus` int NOT NULL AUTO_INCREMENT,
  `estatus` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_estatus`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estatus`
--

LOCK TABLES `estatus` WRITE;
/*!40000 ALTER TABLE `estatus` DISABLE KEYS */;
INSERT INTO `estatus` VALUES (1,'Asistió'),(2,'No Asistió');
/*!40000 ALTER TABLE `estatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sesion`
--

DROP TABLE IF EXISTS `sesion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sesion` (
  `id_sesion` int NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `tema` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_sesion`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sesion`
--

LOCK TABLES `sesion` WRITE;
/*!40000 ALTER TABLE `sesion` DISABLE KEYS */;
INSERT INTO `sesion` VALUES (1,'2024-01-07','Bienvenida al curso'),(2,'2024-01-14','Introducción al maya yucateco'),(3,'2024-01-21','Pronombres y verbos esenciales'),(4,'2024-01-28','Conjugaciones de los verbos regulares'),(5,'2024-02-04','Alfabeto y pronunciación'),(6,'2024-02-11','Consonantes y vocales mayas'),(7,'2024-02-11','Vocabulario básico'),(8,'2024-02-18','Números mayas'),(9,'2024-02-25','Tiempos verbales y sufijos'),(10,'2024-03-03','Examen de certificación de nivel básico');
/*!40000 ALTER TABLE `sesion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(50) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `contrasenia` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Hallie Abernathy','bechtelar.crystal@hotmail.com','09088760063','123'),(2,'Marianne Wolff','maggio.mariana@hotmail.com','729-725-4900','123'),(3,'Filiberto Hettinger','demario.wunsch@hotmail.com','434.159.9654','123'),(4,'Mary Bartell','ahmad85@hotmail.com','156.904.4800x0038','123'),(5,'Prof. Grady Terry DDS','maeve.turcotte@gmail.com','02830751330','123'),(6,'Isom Satterfield II','cristobal80@yahoo.com','639-655-3655','123'),(7,'Ms. Daniela Bailey','luis.schaden@gmail.com','790.028.3860x516','123'),(8,'Waldo Ruecker','o\'reilly.terrill@gmail.com','+91(0)0216482453','123'),(9,'Dr. Jess Rice DDS','ada.barrows@yahoo.com','737.662.5027','123'),(10,'Eulalia Hills PhD','wyman.sadye@gmail.com','1-656-486-7406','123'),(11,'Hans Monahan PhD','pete.mertz@yahoo.com','525-675-2473x00320','123'),(12,'Maximus King','dahlia.lynch@yahoo.com','(511)119-3960x59971','123'),(13,'Melissa Stamm','jerde.jacklyn@yahoo.com','(996)182-1803','123'),(14,'Dr. Juvenal Mayer II','arnoldo.ritchie@gmail.com','1-904-691-3177','123'),(15,'Kristin Will','mertie38@hotmail.com','1-002-491-4290x723','123'),(18,'Gustavo Melero','gustmel@gmail.com','4612789060','123');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-28 15:46:43
