-- phpMyAdmin SQL Dump
-- version 4.4.15.8
-- https://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 27 Mai 2017 à 22:30
-- Version du serveur :  5.6.15-log
-- Version de PHP :  5.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `fiegel_jee_appro_cantine`
--
CREATE DATABASE IF NOT EXISTS `fiegel_jee_appro_cantine` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `fiegel_jee_appro_cantine`;

-- --------------------------------------------------------

--
-- Structure de la table `compo_menu`
--

CREATE TABLE IF NOT EXISTS `compo_menu` (
  `ident_menu` int(11) NOT NULL,
  `ident_produit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `compo_menu`
--

INSERT INTO `compo_menu` (`ident_menu`, `ident_produit`) VALUES
(1, 2),
(2, 2),
(5, 3),
(1, 4),
(5, 4),
(2, 6),
(4, 6),
(1, 8),
(2, 9),
(4, 9),
(2, 10),
(4, 10),
(1, 11),
(5, 12);

-- --------------------------------------------------------

--
-- Structure de la table `menu`
--

CREATE TABLE IF NOT EXISTS `menu` (
  `ident` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `menu`
--

INSERT INTO `menu` (`ident`, `date`) VALUES
(1, '2017-05-27'),
(2, '2017-05-28'),
(4, '2017-05-29'),
(5, '2017-05-30');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE IF NOT EXISTS `produit` (
  `ident` int(11) NOT NULL,
  `libelle` varchar(100) NOT NULL,
  `marque` varchar(100) NOT NULL,
  `conditionnement` varchar(50) NOT NULL,
  `reference` varchar(13) NOT NULL,
  `prix_achat` decimal(10,2) NOT NULL,
  `min_rupture` int(11) NOT NULL DEFAULT '1',
  `date_peremption` date NOT NULL,
  `quantite` int(11) NOT NULL,
  `archive` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`ident`, `libelle`, `marque`, `conditionnement`, `reference`, `prix_achat`, `min_rupture`, `date_peremption`, `quantite`, `archive`) VALUES
(1, 'Conserve haricot', 'Daucy', 'Conserve 10kg', '1000020190531', '10.60', 7, '2019-07-01', 14, 0),
(2, 'Conserve petit pois', 'Daucy', 'Conserve 10kg', '1000020190524', '9.60', 2, '2019-05-24', 10, 0),
(3, 'Sachet de purée', 'Poudre.Inc', 'Sachet 5kg', '4000020180331', '5.99', 10, '2018-03-31', 20, 0),
(4, 'Printanière de légume (surgelée)', 'Géant vert', 'Sachet 5kg', '2000020171118', '15.90', 15, '2017-11-18', 50, 0),
(5, 'Tomates', 'Marché', '1kg', '3000020170525', '7.50', 5, '2017-05-25', 15, 0),
(6, 'Poisson pané', 'Centrale', 'Carton de 5kg', '2000020171231', '20.54', 3, '2017-12-31', 12, 0),
(7, 'Poisson pas frais', 'Centrale', 'Carton de 5kg', '2000020170527', '20.54', 3, '2017-05-26', 2, 0),
(8, 'Test création', 'Bonduelle', '', '1234567890123', '50.50', 10, '2017-10-14', 15, 0),
(9, 'Poisson plus très frais', 'Centrale', 'Carton de 5kg', '2000020170615', '20.54', 3, '2017-06-15', 5, 0),
(10, 'Test crÃ©ation 2', 'Test.Inc', 'Paquet 3kg', '4000020170530', '15.00', 10, '2017-05-30', 1, 0),
(11, 'Test crÃ©ation 3', 'Test.Inc', 'Paquet 3kg', '4000020170531', '5.36', 11, '2017-05-31', 1, 1),
(12, 'Steak hachÃ©', 'Charal', 'Carton de 5kg', '2000020170930', '15.60', 5, '2017-09-30', 15, 0);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `ident` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `role`
--

INSERT INTO `role` (`ident`, `libelle`) VALUES
(1, 'Chef-cuisinier'),
(2, 'Cuisinier'),
(3, 'Gestionnaire');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `ident` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`ident`, `nom`, `prenom`, `email`, `mdp`) VALUES
(1, 'Cuisto', 'Chef', 'chef.cuisto@cantine.fr', 'chef'),
(2, '1', 'Cuisto', 'cuisto.1@cantine.fr', 'cuisto1'),
(3, 'Stock', 'Gestionnaire', 'gest.stock@cantine.fr', 'gest');

-- --------------------------------------------------------

--
-- Structure de la table `user_role`
--

CREATE TABLE IF NOT EXISTS `user_role` (
  `ident_user` int(11) NOT NULL,
  `ident_role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `user_role`
--

INSERT INTO `user_role` (`ident_user`, `ident_role`) VALUES
(1, 1),
(2, 2),
(3, 3);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `compo_menu`
--
ALTER TABLE `compo_menu`
  ADD PRIMARY KEY (`ident_menu`,`ident_produit`),
  ADD KEY `FK_compo_menu-ident_produit*produit-ident` (`ident_produit`);

--
-- Index pour la table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`ident`,`date`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`ident`),
  ADD UNIQUE KEY `reference` (`reference`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`ident`),
  ADD UNIQUE KEY `libelle` (`libelle`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ident`),
  ADD UNIQUE KEY `user_ad_mail` (`email`);

--
-- Index pour la table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`ident_role`,`ident_user`),
  ADD KEY `FK_user_role-ident_user*user-ident` (`ident_user`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `menu`
--
ALTER TABLE `menu`
  MODIFY `ident` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `ident` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `ident` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `ident` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `compo_menu`
--
ALTER TABLE `compo_menu`
  ADD CONSTRAINT `FK_compo_menu-ident_menu*menu-ident` FOREIGN KEY (`ident_menu`) REFERENCES `menu` (`ident`),
  ADD CONSTRAINT `FK_compo_menu-ident_produit*produit-ident` FOREIGN KEY (`ident_produit`) REFERENCES `produit` (`ident`);

--
-- Contraintes pour la table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK_user_role-ident_role*role-ident` FOREIGN KEY (`ident_role`) REFERENCES `role` (`ident`),
  ADD CONSTRAINT `FK_user_role-ident_user*user-ident` FOREIGN KEY (`ident_user`) REFERENCES `user` (`ident`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
