-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: eventrecorderserver
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `endTime` bigint(20) DEFAULT NULL,
  `instant` bit(1) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `noInTrial` int(11) DEFAULT NULL,
  `startTime` bigint(20) DEFAULT NULL,
  `Trial_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgtxx25v2jj52hak64m6kxpaqf` (`Trial_id`),
  CONSTRAINT `FKgtxx25v2jj52hak64m6kxpaqf` FOREIGN KEY (`Trial_id`) REFERENCES `trial` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experiment`
--

DROP TABLE IF EXISTS `experiment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `experiment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Eventmode` varchar(10) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `Triallength` bigint(20) DEFAULT NULL,
  `Keyset_id` int(11) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK71BBB81DCD85F859` (`Keyset_id`),
  CONSTRAINT `FK1n3qbnoystebqgdyvth1e35f1` FOREIGN KEY (`Keyset_id`) REFERENCES `keyset` (`id`),
  CONSTRAINT `FK71BBB81DCD85F859` FOREIGN KEY (`Keyset_id`) REFERENCES `keyset` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experiment`
--

LOCK TABLES `experiment` WRITE;
/*!40000 ALTER TABLE `experiment` DISABLE KEYS */;
INSERT INTO `experiment` VALUES (1,'ATEND','Social interaction PRMT8KO',10000,1,'Valamit írok ide, hogy legyen itt valami'),(2,'ATEND','Elevated Plus Maze EPE3',10000,2,''),(4,'ATEND','Próba kísérlet',600000,1,'Leírást is adok hozzá');
/*!40000 ALTER TABLE `experiment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experiment_trial`
--

DROP TABLE IF EXISTS `experiment_trial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `experiment_trial` (
  `Experiment_id` int(11) NOT NULL,
  `trials_id` int(11) NOT NULL,
  UNIQUE KEY `UK_istgwr8pecrcd1k7c3x55vy1h` (`trials_id`),
  KEY `FKmhgov8w18y0lfhgmew6dula23` (`Experiment_id`),
  CONSTRAINT `FK7g57sl3bjcbv7tgg6t2lj9iv3` FOREIGN KEY (`trials_id`) REFERENCES `trial` (`id`),
  CONSTRAINT `FKmhgov8w18y0lfhgmew6dula23` FOREIGN KEY (`Experiment_id`) REFERENCES `experiment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experiment_trial`
--

LOCK TABLES `experiment_trial` WRITE;
/*!40000 ALTER TABLE `experiment_trial` DISABLE KEYS */;
INSERT INTO `experiment_trial` VALUES (1,1),(1,2),(1,3),(2,4),(2,5);
/*!40000 ALTER TABLE `experiment_trial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keyevent`
--

DROP TABLE IF EXISTS `keyevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `keyevent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `EventName` varchar(20) DEFAULT NULL,
  `instantaneous` bit(1) DEFAULT NULL,
  `keystroke` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keyevent`
--

LOCK TABLES `keyevent` WRITE;
/*!40000 ALTER TABLE `keyevent` DISABLE KEYS */;
INSERT INTO `keyevent` VALUES (1,'exploration','\0','s'),(2,'sniffing','\0','d'),(3,'resting','\0','f'),(4,'jump','','j'),(5,'submissive','\0','k'),(6,'dominant','\0','l'),(7,'closed','\0','d'),(8,'centrum','\0','f'),(9,'open','\0','j'),(10,'headdip_prot','','k'),(11,'left_cage_sniff','\0','d'),(12,'left_chamber','\0','f'),(13,'central_chamber','\0','g'),(14,'central_chamber','\0','h'),(15,'right_chamber','\0','j'),(16,'right_cage_sniff','\0','k');
/*!40000 ALTER TABLE `keyevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keyset`
--

DROP TABLE IF EXISTS `keyset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `keyset` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keyset`
--

LOCK TABLES `keyset` WRITE;
/*!40000 ALTER TABLE `keyset` DISABLE KEYS */;
INSERT INTO `keyset` VALUES (1,'Social interaction Aron'),(2,'EPM Aron'),(3,'Sociabilty');
/*!40000 ALTER TABLE `keyset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keyset_keyevent`
--

DROP TABLE IF EXISTS `keyset_keyevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `keyset_keyevent` (
  `Keyset_id` int(11) NOT NULL,
  `keyEvents_id` int(11) NOT NULL,
  UNIQUE KEY `UK_kp02pd82nbdbe1419md80slyk` (`keyEvents_id`),
  KEY `FKjna0lkpyknk3vyh9gf1s8ywfx` (`Keyset_id`),
  CONSTRAINT `FKdf3nvpru0rg97duvfy27eluid` FOREIGN KEY (`keyEvents_id`) REFERENCES `eventrecorder`.`keyevent` (`id`),
  CONSTRAINT `FKjna0lkpyknk3vyh9gf1s8ywfx` FOREIGN KEY (`Keyset_id`) REFERENCES `eventrecorder`.`keyset` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keyset_keyevent`
--

LOCK TABLES `keyset_keyevent` WRITE;
/*!40000 ALTER TABLE `keyset_keyevent` DISABLE KEYS */;
INSERT INTO `keyset_keyevent` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(2,7),(2,8),(2,9),(2,10),(3,11),(3,12),(3,13),(3,14),(3,15),(3,16);
/*!40000 ALTER TABLE `keyset_keyevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trial`
--

DROP TABLE IF EXISTS `trial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `comment` varchar(100) DEFAULT NULL,
  `experiment_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trial`
--

LOCK TABLES `trial` WRITE;
/*!40000 ALTER TABLE `trial` DISABLE KEYS */;
INSERT INTO `trial` VALUES (1,'Trial 1',NULL,0),(2,'Trial 2','Újraelemezni!!!!',0),(3,'Trial 3',NULL,0),(4,'anim01','Naggyon dúúúrva!!!',0),(5,'anim02',NULL,0);
/*!40000 ALTER TABLE `trial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Tulogdi Áron'),(2,'Test User');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_experiment`
--

DROP TABLE IF EXISTS `user_experiment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_experiment` (
  `User_id` int(11) NOT NULL,
  `experiments_id` int(11) NOT NULL,
  UNIQUE KEY `UK_jew0r4fbvrsa16plkrg3guc3d` (`experiments_id`),
  KEY `FK12gr8x0h35gcw2pcqbfs5gv1e` (`User_id`),
  CONSTRAINT `FK12gr8x0h35gcw2pcqbfs5gv1e` FOREIGN KEY (`User_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKd8i8lqqrvvjh3pjm9h18351pj` FOREIGN KEY (`experiments_id`) REFERENCES `experiment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_experiment`
--

LOCK TABLES `user_experiment` WRITE;
/*!40000 ALTER TABLE `user_experiment` DISABLE KEYS */;
INSERT INTO `user_experiment` VALUES (1,1),(1,2),(2,4);
/*!40000 ALTER TABLE `user_experiment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_keyset`
--

DROP TABLE IF EXISTS `user_keyset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_keyset` (
  `User_id` int(11) NOT NULL,
  `keysets_id` int(11) NOT NULL,
  UNIQUE KEY `UK_sxyqcdxg1kf9p8ra5gevnhf81` (`keysets_id`),
  KEY `FK17yi18x0w1i049mxgef5pdwqx` (`User_id`),
  CONSTRAINT `FK17yi18x0w1i049mxgef5pdwqx` FOREIGN KEY (`User_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKtmyofs3x9rdcnolsei455qqy5` FOREIGN KEY (`keysets_id`) REFERENCES `keyset` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_keyset`
--

LOCK TABLES `user_keyset` WRITE;
/*!40000 ALTER TABLE `user_keyset` DISABLE KEYS */;
INSERT INTO `user_keyset` VALUES (1,1),(1,2),(2,3);
/*!40000 ALTER TABLE `user_keyset` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-04 14:58:19
