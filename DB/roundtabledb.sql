-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema roundtabledb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `roundtabledb` ;

-- -----------------------------------------------------
-- Schema roundtabledb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `roundtabledb` DEFAULT CHARACTER SET utf8 ;
USE `roundtabledb` ;

-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street1` VARCHAR(200) NULL,
  `street2` VARCHAR(200) NULL,
  `city` VARCHAR(100) NULL,
  `state` VARCHAR(100) NULL,
  `zip_code` VARCHAR(10) NOT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `address_id` INT NOT NULL,
  `username` VARCHAR(75) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `role` VARCHAR(45) NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `avatar_url` VARCHAR(5000) NULL DEFAULT 'images/default-avatar.jpg',
  `create_date` DATETIME NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  `admin` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_user_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_user_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category` ;

CREATE TABLE IF NOT EXISTS `category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event` ;

CREATE TABLE IF NOT EXISTS `event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `organizer_id` INT NOT NULL,
  `address_id` INT NOT NULL,
  `title` VARCHAR(200) NOT NULL,
  `description` TEXT NULL,
  `event_date` DATE NULL,
  `start_time` TIME NULL,
  `capacity` INT NULL,
  `img_url` VARCHAR(5000) NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_event_organizer_idx` (`organizer_id` ASC),
  INDEX `fk_event_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_event_organizer`
    FOREIGN KEY (`organizer_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `game` ;

CREATE TABLE IF NOT EXISTS `game` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category_id` INT NOT NULL,
  `creator_id` INT NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `min_players` INT NULL,
  `max_players` INT NULL,
  `description` TEXT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_game_category_idx` (`category_id` ASC),
  INDEX `fk_game_user1_idx` (`creator_id` ASC),
  CONSTRAINT `fk_game_category`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_game_user1`
    FOREIGN KEY (`creator_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `guild`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `guild` ;

CREATE TABLE IF NOT EXISTS `guild` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `description` TEXT NULL,
  `logo_url` VARCHAR(5000) NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event_game`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event_game` ;

CREATE TABLE IF NOT EXISTS `event_game` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `event_id` INT NOT NULL,
  `game_id` INT NOT NULL,
  `description` TEXT NULL,
  `min_players` INT NULL,
  `max_players` INT NULL,
  `start_time` TIME NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_event_game_event1_idx` (`event_id` ASC),
  INDEX `fk_event_game_game1_idx` (`game_id` ASC),
  CONSTRAINT `fk_event_game_event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_game_game1`
    FOREIGN KEY (`game_id`)
    REFERENCES `game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `attendee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `attendee` ;

CREATE TABLE IF NOT EXISTS `attendee` (
  `user_id` INT NOT NULL,
  `event_game_id` INT NOT NULL,
  `event_rating` INT NULL,
  `comment_by_attendee` TEXT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`user_id`, `event_game_id`),
  INDEX `fk_attendee_event_game1_idx` (`event_game_id` ASC),
  CONSTRAINT `fk_attendee_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_attendee_event_game1`
    FOREIGN KEY (`event_game_id`)
    REFERENCES `event_game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `guild_member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `guild_member` ;

CREATE TABLE IF NOT EXISTS `guild_member` (
  `guild_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`guild_id`, `user_id`),
  INDEX `fk_group_has_user_user1_idx` (`user_id` ASC),
  INDEX `fk_group_has_user_group1_idx` (`guild_id` ASC),
  CONSTRAINT `fk_group_has_user_group1`
    FOREIGN KEY (`guild_id`)
    REFERENCES `guild` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_group_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event_comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event_comment` ;

CREATE TABLE IF NOT EXISTS `event_comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `event_id` INT NOT NULL,
  `content` TEXT NULL,
  `comment_date` DATETIME NULL,
  `last_updated` DATETIME NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_event_comment_user1_idx` (`user_id` ASC),
  INDEX `fk_event_comment_event1_idx` (`event_id` ASC),
  CONSTRAINT `fk_event_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_comment_event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS gamer@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'gamer'@'localhost' IDENTIFIED BY 'roundtable';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'gamer'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `roundtabledb`;
INSERT INTO `address` (`id`, `street1`, `street2`, `city`, `state`, `zip_code`, `enabled`) VALUES (1, '123 admin st', '', 'Silverton', 'Oregon', '97381', 1);
INSERT INTO `address` (`id`, `street1`, `street2`, `city`, `state`, `zip_code`, `enabled`) VALUES (2, '808 Noisia Ave', 'Apt# 303', 'Bassdrop', 'Oregon', '97381', 1);
INSERT INTO `address` (`id`, `street1`, `street2`, `city`, `state`, `zip_code`, `enabled`) VALUES (3, '45 Ecksdee Ave', '', 'Springfield', 'Kentucky', '41631', 1);
INSERT INTO `address` (`id`, `street1`, `street2`, `city`, `state`, `zip_code`, `enabled`) VALUES (4, '555 Frontend Dr', '', 'Colorado Springs', 'Colorado', '80907', 1);
INSERT INTO `address` (`id`, `street1`, `street2`, `city`, `state`, `zip_code`, `enabled`) VALUES (5, '9751 Sunnyside St', '#3010', 'Fayetteville', 'North Carolina', '28301', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `roundtabledb`;
INSERT INTO `user` (`id`, `address_id`, `username`, `password`, `role`, `first_name`, `last_name`, `email`, `avatar_url`, `create_date`, `enabled`, `admin`) VALUES (1, 1, 'admin', 'admin', '', 'admin', 'admin', 'admin@stenchcarnival.com', NULL, '2020-05-22 13:00:00', 1, 1);
INSERT INTO `user` (`id`, `address_id`, `username`, `password`, `role`, `first_name`, `last_name`, `email`, `avatar_url`, `create_date`, `enabled`, `admin`) VALUES (2, 2, 'serg', 'lol', '', 'Sergio', 'Samoiloff', 'serg@stenchcarnival.com', 'https://i.pinimg.com/originals/86/18/65/861865b83d52f3659241cf5c7113cb75.jpg', '2020-05-24 12:30:00', 1, 0);
INSERT INTO `user` (`id`, `address_id`, `username`, `password`, `role`, `first_name`, `last_name`, `email`, `avatar_url`, `create_date`, `enabled`, `admin`) VALUES (3, 3, 'shane', 'cereal', '', 'Shane', 'Duncan', 'shane@stenchcarnival.com', NULL, '2020-05-24 12:33:00', 1, 0);
INSERT INTO `user` (`id`, `address_id`, `username`, `password`, `role`, `first_name`, `last_name`, `email`, `avatar_url`, `create_date`, `enabled`, `admin`) VALUES (4, 4, 'jacob', 'hatred', '', 'Jacob', 'Zieleniewski', 'jacob@stenchcarnival.com', NULL, '2020-05-24 12:35:00', 1, 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `category`
-- -----------------------------------------------------
START TRANSACTION;
USE `roundtabledb`;
INSERT INTO `category` (`id`, `name`, `description`) VALUES (1, 'Tabletop RPG', 'A form of role-playing game (RPG) in which the participants describe their characters\' actions through speech. Participants determine the actions of their characters based on their characterization, and the actions succeed or fail according to a set formal system of rules and guidelines. Within the rules, players have the freedom to improvise; their choices shape the direction and outcome of the game.');
INSERT INTO `category` (`id`, `name`, `description`) VALUES (2, 'Trading Card Games', 'A type of card game that mixes strategic deck building elements with features of trading cards.');
INSERT INTO `category` (`id`, `name`, `description`) VALUES (3, 'Miniatures', 'A form of wargaming in which players enact battles between opposing military forces that are represented by miniature physical models.');

COMMIT;


-- -----------------------------------------------------
-- Data for table `event`
-- -----------------------------------------------------
START TRANSACTION;
USE `roundtabledb`;
INSERT INTO `event` (`id`, `organizer_id`, `address_id`, `title`, `description`, `event_date`, `start_time`, `capacity`, `img_url`, `create_date`, `last_update`, `enabled`) VALUES (1, 4, 1, 'Sprint Party', 'Just a weeklong grueling test of patience.', '2020-05-22', '08:00:00', 3, 'someimage.png', '2020-05-22 17:14:00', '2020-05-22 17:14:00', 1);
INSERT INTO `event` (`id`, `organizer_id`, `address_id`, `title`, `description`, `event_date`, `start_time`, `capacity`, `img_url`, `create_date`, `last_update`, `enabled`) VALUES (2, 2, 2, 'PDXLAN', 'Normally a the West Coast\'s largest LAN party, but this time we\'re going analog!', '2020-07-05', '13:00:00', 550, 'https://www.pdxlan.net/LAN/wp-content/uploads/2018/04/pdxlan_text-2-300x100.png', '2020-05-24 12:24:00', '2020-05-24 12:24:00', 1);
INSERT INTO `event` (`id`, `organizer_id`, `address_id`, `title`, `description`, `event_date`, `start_time`, `capacity`, `img_url`, `create_date`, `last_update`, `enabled`) VALUES (3, 3, 3, 'Blizzcon', 'Against all government laws and regulations, Shane has decided to throw this year\'s Blizzcon at his house!', '2020-05-30', '08:00:00', 1000, 'https://upload.wikimedia.org/wikipedia/en/thumb/5/51/BlizzCon_logo.svg/1200px-BlizzCon_logo.svg.png', '2020-05-24 12:34:00', '2020-05-24 12:34:00', 1);
INSERT INTO `event` (`id`, `organizer_id`, `address_id`, `title`, `description`, `event_date`, `start_time`, `capacity`, `img_url`, `create_date`, `last_update`, `enabled`) VALUES (4, 3, 4, 'Let\'s Play', 'Everything at the same time', '2020-06-06', '15:30:00', 75, 'stockimage.png', '2020-05-24 12:38:00', '2020-05-24 12:38:00', 1);
INSERT INTO `event` (`id`, `organizer_id`, `address_id`, `title`, `description`, `event_date`, `start_time`, `capacity`, `img_url`, `create_date`, `last_update`, `enabled`) VALUES (5, 4, 5, 'Squarecon', 'Final Fantasy games only!', '2020-03-14', '10:00:00', 1200, 'https://gh.cdn.sewest.net/assets/ident/news/message-square-enix-ceo/en_US/Square-Enix-logo.jpg?quality=65', '2020-05-26 22:10:00', NULL, 1);
INSERT INTO `event` (`id`, `organizer_id`, `address_id`, `title`, `description`, `event_date`, `start_time`, `capacity`, `img_url`, `create_date`, `last_update`, `enabled`) VALUES (6, 2, 3, 'Trading Night', 'Come show off your cards and trade with others.', '2020-06-17', '21:00:00', 12, 'https://upload.wikimedia.org/wikipedia/en/thumb/2/24/CCG_card_back_image_assortment.jpg/220px-CCG_card_back_image_assortment.jpg', '2020-05-26 22:25:00', NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `game`
-- -----------------------------------------------------
START TRANSACTION;
USE `roundtabledb`;
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (1, 1, 1, 'Blades In The Dark', 3, 10, 'Blades in the Dark is a tabletop role-playing game about a crew of daring scoundrels seeking their fortunes on the haunted streets of an industrial-fantasy city. There are heists, chases, occult mysteries, dangerous bargains, bloody skirmishes, and, above all, riches to be had — if you’re bold enough to seize them.\n\nYou and your fledgling crew must thrive amidst the threats of rival gangs, powerful noble families, vengeful ghosts, the Bluecoats of the city watch, and the siren song of your scoundrel’s own vices. Will you rise to power in the criminal underworld? What are you willing to do to get to the top?', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (2, 1, 1, 'Call of Cthulhu', 2, 10, 'CALL OF CTHULHU is Chaosium\'s classic roleplaying game of Lovecraftian horror in which ordinary people are confronted by the terrifying and alien forces of the Cthulhu Mythos. CALL OF CTHULHU uses Chaosium\'s Basic Roleplaying System, easy to learn and quick to play. This bestseller has won dozens of game-industry awards and is a member of the Academy of Adventure Game Design Hall of Fame.', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (3, 1, 1, 'Carbon 2185', 3, 10, 'Carbon 2185 is a cyberpunk RPG created by Robert Marriner-Dodds released in 2019. Carbon 2185 is all about telling stories in a dark dystopian future influenced by franchises such as Blade Runner, Ghost in the Shell, and Deus Ex.\n\n​\n\nThe core mechanics and rules of Carbon 2185 are built using, and developed from the OGL, so anybody who has experience with this game system has a unique advantage in learning these new rules. That being said, experience is not necessary, and most new players pick up the streamlined rules by the end of their first session.', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (4, 1, 1, 'Cyberpunk 2020', 3, 10, 'WELCOME TO THE DARK FUTURE\n\nThe Corporations control the world from their skyscraper fortresses, enforcing their rule with armies of cyborg assassins. On the Street, Boostergangs roam a shattered urban wilderness, killing and looting. The rest of the world is a perpetual party, as fashion-model beautiful techies rub biosculpt jobs with battle armored roadwarriors in the hottest clubs, sleaziest bars and meanest streets this side of the Postholocaust. The Future never looked so bad.\n\nBut you can change it. You\'ve got interface plugs in your wrists, weapons in your arms, lasers in your eyes, bio-chip programs screaming in your brain. You\'re wired in, cyberenhanced and solid state as you can take it to the fatal Edge where only the toughest and coolest can go. Because you\'re CYBERPUNK.\n\nCyberpunk: the original roleplaying game of the dark future; a world of corporate assassins, heavy-metal heroes and brain burning cyberhackers, packed with cutting edge technology and intense urban action. Within this book, you\'ll find everything you need to tackle the mean streets of the 2000\'s -- in a game system that combines the best in realistic action and playability.', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (5, 1, 1, 'Dungeons & Dragons', 3, 10, 'The Dungeons & Dragons roleplaying game is about storytelling in worlds of sword and sorcery. It shares elements with childhood games of make-believe. Like those games, D&D is driven by imagination. It’s about picturing the towering castle beneath the stormy night sky and imagining how a fantasy adventurer might react to the challenges that scene presents.\n\nUnlike a game of make-believe, D&D gives structure to the stories, a way of determining the consequences of the adventurers’ action. Players roll dice to resolve whether their attacks hit or miss or whether their adventurers can scale a cliff, roll away from the strike of a magical lightning bolt, or pull off some other dangerous task. Anything is possible, but the dice make some outcomes more probable than others.\n\nIn the Dungeons & Dragons game, each player creates an adventurer (also called a character) and teams up with other adventurers (played by friends). Working together, the group might explore a dark dungeon, a ruined city, a haunted castle, a lost temple deep in a jungle, or a lava-filled cavern beneath a mysterious mountain. The adventurers can solve puzzles, talk with other characters, battle fantastic monsters, and discover fabulous magic items and other treasure.', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (6, 1, 1, 'Pathfinder', 3, 10, 'The Pathfinder Roleplaying Game (PFRPG) puts you in the role of a brave adventurer fighting to survive in a world beset by magic and evil. Will you cut your way through monster-filled ruins and cities rife with political intrigue to emerge as a famous hero laden with fabulous treasure, or will you fall victim to treacherous traps and fiendish monsters in a forgotten dungeon? Your fate is yours to decide with this giant Core Rulebook that provides everything a player needs to set out on a life of adventure and excitement!\nThis imaginative tabletop game builds upon more than 10 years of system development and an open playtest involving more than 50,000 gamers to create a cutting-edge RPG experience that brings the all-time best-selling set of fantasy rules into the new millennium.', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (7, 1, 1, 'Rifts', 3, 10, 'Rifts® is a multi-genre role-playing game that captures the imagination unlike any other. Elements of magic, horror, and the supernatural co-exist with science, high technology and the ordinary. The game spans countless dimensions, making anything and everything possible. Players are truly limited only by their imaginations!', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (8, 1, 1, 'Shadowrun', 3, 10, 'Shadowrun is a science fantasy tabletop role-playing game set in a near-future fictional universe in which cybernetics, magic and fantasy creatures co-exist. It combines genres of cyberpunk, urban fantasy and crime, with occasional elements of conspiracy, horror and detective fiction. From its inception in 1989, Shadowrun has remained among the most popular role-playing games. It has spawned a vast franchise that includes a series of novels, a collectible card game, two miniature-based tabletop wargames, and multiple video games.', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (9, 1, 1, 'Star Wars Roleplaying', 3, 10, 'The Star Wars Roleplaying Game is a tabletop role-playing game set in the Star Wars universe first published by Fantasy Flight Games in August 2012.', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (10, 1, 1, 'WarHammer', 3, 10, 'Warhammer Fantasy Roleplay is a new, exciting way to experience the popular Warhammer Fantasy setting. It is a grim world, constantly at war. As a hero, you will take up weapon, spell, or prayer and do your best to combat the might of enemies terrifying to behold.', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (11, 2, 1, 'Final Fantasy', 2, 2, 'Final Fantasy trading card game is a trading card game by Square Enix and Hobby Japan. Each player uses a deck of 50 cards, with no more than 3 copies of the same card. Players play cards by spending Crystal Points, earned by \"dulling\" (turning from vertical to horizontal) Backup cards, or by discarding cards. The game features a wide range of Characters from games in the Final Fantasy series.', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (12, 2, 1, 'KeyForge', 2, 2, 'Enter a world where anything is possible in KeyForge! In the center of the universe hangs the Crucible, an artificial world built from the pieces of countless planets. Here, in the world’s first Unique Deck Game, created by legendary designer Richard Garfield, two players step into the roles of mighty Archons, racing to forge keys that unlock the Crucible’s hidden Vaults.\n\nLeading their diverse teams, filled with followers from three of the Crucible’s great Houses, the Archons must gather Æmber, stave off their opponent’s progress, and ultimately be the first to open a Vault and gain its incredible knowledge. With a vast array of creatures, artifacts, and abilities and over 104 quadrillion possible decks, every deck is completely one-of-a-kind, and no two battles will ever be the same!', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (13, 2, 1, 'Legend of the Five Rings', 2, 2, 'Enter the vibrant world of Rokugan with Legend of the Five Rings: The Card Game, a Living Card Game® of honor and conflict for two players! Drawing on the legacy of AEG’s original Legend of the Five Rings collectible card game, and now reimagined with new mechanics, story, and the Living Card Game distribution model, you are invited to join the Great Clans, uphold the tenets of Bushidō, and fulfill your duty to your daimyō and the Emperor in a world shaped and changed by a dynamic, player-influenced story.\n\nDuring the game, you take on the leadership of one of the Great Clans which define Rokugani society, and you are cast into conflict against another clan. Your conflicts will decide the future of Rokugan, whether you’re battling with a katana or with cutting words, but the samurai of your clan cannot remain by your side indefinitely—when their destinies are fulfilled, you must find new allies to continue your conflicts. Ultimately, it’s your choice whether you will fight with honor or use unsavory means, but in every game, it is your role to lead your clan to victory.', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (14, 2, 1, 'Magic: The Gathering', 2, 5, 'Magic: The Gathering is a card game in which wizards cast spells, summon creatures, and exploit magic objects to defeat their opponents. In the game, two or more players each assemble a deck of 60 cards with varying powers. They choose these decks from a pool of some 20,000 cards created as the game evolved.', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (15, 2, 1, 'Pokemon', 2, 2, 'The Pokémon Trading Card Game, often abbreviated as Pokémon TCG or just TCG, is a tabletop game that involves collecting, trading and playing with Pokémon themed playing cards. It has its own set of rules but uses many motifs and ideas derived from the video games. There are Pokémon cards for every species of Pokémon, as well as Trainer cards featuring characters, items and other themes of the franchise (each with a different use) and Energy cards to power various actions. The artwork for the cards is provided by numerous artists.', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (16, 2, 1, 'Star Wars Trading Card Game', 2, 2, 'The Star Wars: TCG focuses on gaining control of in-game arenas. In this two-player game, each player controls units which battle in the arenas. The main way to win is to take control of two of the three arenas. Some cards also add new win conditions for the game.', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (17, 2, 1, 'Yu-Gi-Oh', 2, 2, 'In this game, two players Duel each other using a variety of Monster, Spell, and Trap Cards to defeat their opponent\'s monsters and be the first to drop the other\'s Life Points to 0.', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (18, 3, 1, 'A Song of Ice and Fire', 2, 4, 'A Song of Ice & Fire: Tabletop Miniatures Game is a competitive miniatures game for two or more players. Each player controls one of the Great Houses of Westeros, commanding battlefield units, recruiting legendary Heroes, and manipulating the political stage, in the attempt to claim the greatest prize of all: The Iron Throne.', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (19, 3, 1, 'Guild Ball', 2, 6, 'Guild Ball is a fast-paced mob football skirmish game that takes place in the Empire of the Free Cities.  Victory comes with carefully constructed plays and counter plays with emphasis on positioning and resource management. Anybody can pick up the ball and give it a kick, but only the most experienced coach can earn the title of Guild Ball World Champion - decided each year at SFGs own convention SteamCon.', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (20, 3, 1, 'Malifaux', 2, 2, 'Welcome to Malifaux, a twisted mirror of an alternate Earth in the 1900s; a world of gothic horror, Victorian structures, steampunk constructs, and wild west gunslingers. Rife with undead amalgamations, monstrous vengeful apparitions, and other creatures that bump in the night, these near-lawless lands are still worth treading for some, as the Soulstones deep within the cavernous catacombs are worth more than the sweat and blood it takes to obtain them.\n\nMalifaux Third Edition is a story-driven skirmish game that carries the events from the lore directly into the characters’ mechanics. With a streamlined hiring system, straightforward and updated rules that don’t get in the way of the fun, and enough strategic depth to keep those mental gears turning for years to come, it’s never been a better time to dive into the world of Malifaux.\n\nSeek your fortune, test your luck, and stake your claim in this fast-paced and brutal tabletop miniature skirmish game.  \n\nNo longer do you have to trust the fickle fate of a dice roll. In Malifaux, you use cards called a Fate Deck to lead your crew to victory. If strategy, tactics, and resource management can’t help you achieve your goals, don’t worry, as you can always Cheat Fate.', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (21, 3, 1, 'Monsterpocalypse', 2, 2, 'Monsterpocalypse is a fast-moving, action-packed battle miniatures game played with detailed hobby miniatures that players assemble and paint to portray the most fearsome giant monsters on earth!', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (22, 3, 1, 'Star Wars: Legion', 2, 2, 'Warfare is an inescapable part of the Star Wars universe, from the blow dealt to the Rebel Alliance in the Battle of Hoth to a few Rebel strike teams taking on a legion of stormtroopers stationed on Endor. Seize your chance to get your boots on the ground and lead your troops to victory with Star Wars™: Legion, a miniatures game of thrilling infantry battles in the Star Wars universe!\n\nStar Wars: Legion invites you to join the unsung battles of the Galactic Civil War as the commander of a unique army filled with troopers, powerful ground or repulsor vehicles, and iconic characters like Darth Vader or Luke Skywalker. While innovative mechanics simulate the fog of war and the chaos of battle, the unpainted, easily assembled miniatures give you a canvas to create the Star Wars army you’ve always wanted to lead into battle—whether you fight for the monolithic, oppressive Galactic Empire or the ragtag Rebel Alliance.', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (23, 3, 1, 'The Walking Dead: All Out War', 2, 2, 'All Out War is a game of fast-paced, head-to-head skirmishes in the world of the Walking Dead. Assemble a group of your favorite characters and then battle it out over scarce resources and weapons.', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (24, 3, 1, 'WarHammer 40K/Age of Sigmar', 2, 4, 'Warhammer 40,000 is set in the distant future, where a stagnant human civilization is beset by hostile aliens and malevolent supernatural creatures. The models in the game are a mixture of humans, aliens, and supernatural monsters, wielding futuristic weaponry and magical powers.', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (25, 3, 1, 'WarMachine/Hordes', 2, 2, 'Warmachine is a tabletop wargame set in a semi-industralised fantasy world. A player\'s army is centred around a powerful warcaster who controls a group of giant robots called warjacks, backed up by a few combat units and support solos. Hordes represents the untamed wilds of the same fantasy world.', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (26, 3, 1, 'Wings of Glory', 2, 8, 'Year 1917. All across Europe, while men face a last-ditch battle in the mud of the trenches, colorful biplanes fly in the foggy sky, gallantly fighting each other as true \"knights of the air.\"  Take the commands of one of the early flying machines to shoot down your enemy, complete recon missions, and become an ace, following in the steps of men like Manfred von Richthofen, Eddie Rickenbacker, Georges Guynemer and Francesco Baracca!', 1);
INSERT INTO `game` (`id`, `category_id`, `creator_id`, `title`, `min_players`, `max_players`, `description`, `enabled`) VALUES (27, 3, 1, 'X-Wing', 2, 4, 'Star Wars: X-Wing Miniatures Game is a tactical ship-to-ship combat game in which players take control of powerful Rebel X-wings and nimble Imperial TIE fighters, facing them against each other in fast-paced space combat.', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `guild`
-- -----------------------------------------------------
START TRANSACTION;
USE `roundtabledb`;
INSERT INTO `guild` (`id`, `name`, `description`, `logo_url`, `enabled`) VALUES (1, 'Guild of Mecha Admins', 'DBA Life', 'anon.jpg', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `event_game`
-- -----------------------------------------------------
START TRANSACTION;
USE `roundtabledb`;
INSERT INTO `event_game` (`id`, `event_id`, `game_id`, `description`, `min_players`, `max_players`, `start_time`, `enabled`) VALUES (1, 1, 1, 'Spectator', 1, 1, '00:00:00', 1);
INSERT INTO `event_game` (`id`, `event_id`, `game_id`, `description`, `min_players`, `max_players`, `start_time`, `enabled`) VALUES (2, 2, 11, 'Card game', 2, 2, '22:00:00', 1);
INSERT INTO `event_game` (`id`, `event_id`, `game_id`, `description`, `min_players`, `max_players`, `start_time`, `enabled`) VALUES (3, 3, 18, 'Miniature game', 2, 2, '21:30:00', 1);
INSERT INTO `event_game` (`id`, `event_id`, `game_id`, `description`, `min_players`, `max_players`, `start_time`, `enabled`) VALUES (4, 4, 3, 'RPG', 3, 10, '13:45:00', 1);
INSERT INTO `event_game` (`id`, `event_id`, `game_id`, `description`, `min_players`, `max_players`, `start_time`, `enabled`) VALUES (5, 4, 14, 'Minis', 2, 2, '15:00:00', 1);
INSERT INTO `event_game` (`id`, `event_id`, `game_id`, `description`, `min_players`, `max_players`, `start_time`, `enabled`) VALUES (6, 4, 20, 'Card trading', 2, 12, '21:00:00', 1);
INSERT INTO `event_game` (`id`, `event_id`, `game_id`, `description`, `min_players`, `max_players`, `start_time`, `enabled`) VALUES (7, 5, 11, 'Card match', 2, 2, '15:00:00', 1);
INSERT INTO `event_game` (`id`, `event_id`, `game_id`, `description`, `min_players`, `max_players`, `start_time`, `enabled`) VALUES (8, 6, 20, 'Trading', 2, 20, '12:00:00', 1);
INSERT INTO `event_game` (`id`, `event_id`, `game_id`, `description`, `min_players`, `max_players`, `start_time`, `enabled`) VALUES (9, 6, 12, 'Trading', 2, 20, '12:00:00', 1);
INSERT INTO `event_game` (`id`, `event_id`, `game_id`, `description`, `min_players`, `max_players`, `start_time`, `enabled`) VALUES (10, 6, 13, 'Trading', 2, 20, '12:00:00', 1);
INSERT INTO `event_game` (`id`, `event_id`, `game_id`, `description`, `min_players`, `max_players`, `start_time`, `enabled`) VALUES (11, 6, 14, 'Trading', 2, 20, '12:00:00', 1);
INSERT INTO `event_game` (`id`, `event_id`, `game_id`, `description`, `min_players`, `max_players`, `start_time`, `enabled`) VALUES (12, 6, 17, 'Trading', 2, 20, '12:00:00', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `attendee`
-- -----------------------------------------------------
START TRANSACTION;
USE `roundtabledb`;
INSERT INTO `attendee` (`user_id`, `event_game_id`, `event_rating`, `comment_by_attendee`, `enabled`) VALUES (1, 1, 5, 'admin test', 1);
INSERT INTO `attendee` (`user_id`, `event_game_id`, `event_rating`, `comment_by_attendee`, `enabled`) VALUES (2, 2, 4, 'I was confused the whole time', 1);
INSERT INTO `attendee` (`user_id`, `event_game_id`, `event_rating`, `comment_by_attendee`, `enabled`) VALUES (3, 3, 4, 'Fantastic', 1);
INSERT INTO `attendee` (`user_id`, `event_game_id`, `event_rating`, `comment_by_attendee`, `enabled`) VALUES (4, 4, 2, 'I feel cheated!', 1);
INSERT INTO `attendee` (`user_id`, `event_game_id`, `event_rating`, `comment_by_attendee`, `enabled`) VALUES (3, 5, 5, 'GG <3', 1);
INSERT INTO `attendee` (`user_id`, `event_game_id`, `event_rating`, `comment_by_attendee`, `enabled`) VALUES (4, 6, 2, 'I disagree with this format. I lost everything I brought.', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `guild_member`
-- -----------------------------------------------------
START TRANSACTION;
USE `roundtabledb`;
INSERT INTO `guild_member` (`guild_id`, `user_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `event_comment`
-- -----------------------------------------------------
START TRANSACTION;
USE `roundtabledb`;
INSERT INTO `event_comment` (`id`, `user_id`, `event_id`, `content`, `comment_date`, `last_updated`, `enabled`) VALUES (1, 1, 1, 'Incredible event. Holy smokes.', '2020-05-22 17:14:00', NULL, 1);
INSERT INTO `event_comment` (`id`, `user_id`, `event_id`, `content`, `comment_date`, `last_updated`, `enabled`) VALUES (2, 2, 2, 'What a massive turnout!', '2020-05-26 22:33:00', NULL, 1);
INSERT INTO `event_comment` (`id`, `user_id`, `event_id`, `content`, `comment_date`, `last_updated`, `enabled`) VALUES (3, 3, 3, 'Had a great time!', '2020-05-26 22:33:00', NULL, 1);
INSERT INTO `event_comment` (`id`, `user_id`, `event_id`, `content`, `comment_date`, `last_updated`, `enabled`) VALUES (4, 3, 4, 'I wish I brought my friends. This was awesome.', '2020-05-26 22:33:00', NULL, 1);
INSERT INTO `event_comment` (`id`, `user_id`, `event_id`, `content`, `comment_date`, `last_updated`, `enabled`) VALUES (5, 4, 5, 'I\'ve been to better events.', '2020-05-26 22:33:00', NULL, 1);
INSERT INTO `event_comment` (`id`, `user_id`, `event_id`, `content`, `comment_date`, `last_updated`, `enabled`) VALUES (6, 4, 6, 'My only complaint is that there were no vegan hot dogs.', '2020-05-26 22:33:00', NULL, 1);

COMMIT;

