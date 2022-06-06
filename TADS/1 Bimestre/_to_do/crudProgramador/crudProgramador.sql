-- --------------------------------------------------------
-- Servidor:                     localhost
-- Versão do servidor:           5.7.24 - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para tads
CREATE DATABASE IF NOT EXISTS `tads` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_general_ci */;
USE `tads`;

-- Copiando estrutura para tabela tads.programador
CREATE TABLE IF NOT EXISTS `programador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `email` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `endereco` varchar(300) COLLATE latin1_general_ci DEFAULT NULL,
  `profissao` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `genero` varchar(3000) COLLATE latin1_general_ci DEFAULT NULL,
  `area` varchar(450) COLLATE latin1_general_ci DEFAULT NULL,
  `recado` varchar(450) COLLATE latin1_general_ci DEFAULT NULL,
  `promocoes` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `senha` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- Copiando dados para a tabela tads.programador: ~0 rows (aproximadamente)
DELETE FROM `programador`;
/*!40000 ALTER TABLE `programador` DISABLE KEYS */;
INSERT INTO `programador` (`id`, `nome`, `email`, `endereco`, `profissao`, `genero`, `area`, `recado`, `promocoes`, `senha`) VALUES
	(68, 'Gustavo', 'gustavo.botti@hotmail.com', 'Rua Jose Bello', 'Desenvolvedor', 'Masculino', ' Banco de dados Engenharia de software Redes de computadores Desenvolvimento de jogos ProgramaÃ§Ã£o back-end ProgramaÃ§Ã£o front-end MineraÃ§Ã£o de dados', 'Testando a variavel $recado', 'Sim', '12345');
/*!40000 ALTER TABLE `programador` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
