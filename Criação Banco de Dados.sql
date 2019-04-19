-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.1.34-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              10.1.0.5516
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para geoprocessamento
CREATE DATABASE IF NOT EXISTS `geoprocessamento` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `geoprocessamento`;

-- Copiando estrutura para tabela geoprocessamento.dados
CREATE TABLE IF NOT EXISTS `dados` (
  `OID` int(11) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  `XCoord` decimal(22,15) DEFAULT NULL,
  `YCoord` decimal(22,15) DEFAULT NULL,
  `RASTERVALU` decimal(18,15) DEFAULT NULL,
  `dataRegistro` date DEFAULT NULL,
  `codVariavel` varchar(7) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
