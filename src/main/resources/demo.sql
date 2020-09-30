-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP schema if exists `mydb`;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `userRole` ENUM('user', 'admin') NOT NULL,
  PRIMARY KEY (`iduser`))
ENGINE = InnoDB
AUTO_INCREMENT = 31
DEFAULT CHARACTER SET = utf8 COLLATE utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `mydb`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`book` (
  `idbook` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `author` VARCHAR(100) NOT NULL,
  `publishingHouse` VARCHAR(100) NOT NULL,
  `year` INT NOT NULL,
  `genre` VARCHAR(100) NOT NULL,
  `country` VARCHAR(100) NOT NULL,
  `isbn` LONG NOT NULL,
  `countOgPages` INT NOT NULL,
  `language` VARCHAR(100) NOT NULL,
  `authorOfTranslation` VARCHAR(100) NOT NULL,
  `description` VARCHAR(1000) NOT NULL,
  `price` VARCHAR(100) NOT NULL,
  `delete` VARCHAR(45) NOT NULL DEFAULT '2',
  `image` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idbook`))
ENGINE = InnoDB
AUTO_INCREMENT = 31
DEFAULT CHARACTER SET = utf8 COLLATE utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `mydb`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`order` (
  `idorder` INT(10) NOT NULL AUTO_INCREMENT,
  `user_iduser` INT NOT NULL,
  `book_idbook` INT NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `date_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idorder`),
  INDEX `fk_user_has_book_book1_idx` (`book_idbook` ASC),
  INDEX `fk_user_has_book_user_idx` (`user_iduser` ASC),
  INDEX `idx_book_idbook_user_iduser` (`book_idbook` ASC, `user_iduser` ASC),
  CONSTRAINT `fk_user_has_book_user`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `mydb`.`user` (`iduser`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_user_has_book_book1`
    FOREIGN KEY (`book_idbook`)
    REFERENCES `mydb`.`book` (`idbook`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8 COLLATE utf8_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mydb`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`user` (`iduser`, `login`, `password`, `name`, `email`, `userRole`) VALUES (1, '1', '1', '1', '1', 'user');
INSERT INTO `mydb`.`user` (`iduser`, `login`, `password`, `name`, `email`, `userRole`) VALUES (2, '2', '2', '2', '2', 'admin');
INSERT INTO `mydb`.`user` (`iduser`, `login`, `password`, `name`, `email`, `userRole`) VALUES (3, '3', '3', '3', '3', 'admin');
INSERT INTO `mydb`.`user` (`iduser`, `login`, `password`, `name`, `email`, `userRole`) VALUES (4, '4', '4', '4', '4', 'admin');
INSERT INTO `mydb`.`user` (`iduser`, `login`, `password`, `name`, `email`, `userRole`) VALUES (5, '5', '5', '5', '5', 'admin');
INSERT INTO `mydb`.`user` (`iduser`, `login`, `password`, `name`, `email`, `userRole`) VALUES (6, '6', '6', '6', '6', 'admin');
INSERT INTO `mydb`.`user` (`iduser`, `login`, `password`, `name`, `email`, `userRole`) VALUES (7, '7', '7', '7', '7', 'admin');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`book`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`book` (`idbook`, `title`, `author`, `publishingHouse`, `year`, `genre`, `country`, `isbn`, `countOgPages`, `language`, `authorOfTranslation`, `description`, `price`, `delete`, `image`)
VALUES (1, 'Footprints in the sand', 'Michelle Bussy', 'Phantom Press', 2020, 'detective', 'France', 9785864718537, 253, 'russian', 'Phantom Press', 'June 1944 Private Lucky dies during the landing on the Norman beach. 20 years later, his fiancee Alice finds out about the contract concluded several hours before the bloody massacre. And in her life there is a goal - to find out the truth about what happened to her fiancé on the eve of a historic battle.', '1', '2', 'footprints_in_the_sand.jpg');
INSERT INTO `mydb`.`book` (`idbook`, `title`, `author`, `publishingHouse`, `year`, `genre`, `country`, `isbn`, `countOgPages`, `language`, `authorOfTranslation`, `description`, `price`, `delete`, `image`)
VALUES (2, 'Caesar, or By the will of fate', 'Colin McCullough', 'ABC Atticus', 1997, 'history', 'Australia', 9785389181885, 848, 'russian', 'ABC Atticus', '
54 BC. Guy Julius Caesar marching victorious march through Gaul. They inspire the conservative leaders of the Republic not joy, but fear. The conspiracy is ripening, and Caesar is ready to turn his genius against his country, but Pompey the Great opposes it. Rome is on the verge of a new Civil War. Everything must be decided by the will of fate. But first, Caesar must cross the Rubicon.', '2', '2', 'cesar.jpg');
INSERT INTO `mydb`.`book` (`idbook`, `title`, `author`, `publishingHouse`, `year`, `genre`, `country`, `isbn`, `countOgPages`, `language`, `authorOfTranslation`, `description`, `price`, `delete`, `image`)
VALUES (3, 'Energy is the new currency', 'Leonid Krol', 'Alpina Digital', 2020, 'self development', 'Russia', 9785961436464, 141, 'russian', 'Alpina Digital', 'Human life energy is the currency of our time. Who has more of it, he manages to do more, is charged with positive and good mood, attracts people and interesting projects. Everyone wants to have more energy, to be in a stream that does not dry out.', '3', '3', 'energy.jpg');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`order`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`order` (`idorder`, `user_iduser`, `book_idbook`, `description`, `date_time`) VALUES (1, 1, 1, '1','2020-09-29T13:43:35.000+00:00');
INSERT INTO `mydb`.`order` (`idorder`, `user_iduser`, `book_idbook`, `description`, `date_time`) VALUES (2, 1, 2, '1','2020-09-28T13:43:35.000+00:00');
INSERT INTO `mydb`.`order` (`idorder`, `user_iduser`, `book_idbook`, `description`, `date_time`) VALUES (3, 2, 1, '1','2020-09-27T13:43:35.000+00:00');

COMMIT;

