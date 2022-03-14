CREATE SCHEMA IF NOT EXISTS bingoDB DEFAULT CHARACTER SET utf8 ;
USE bingoDB ;

-- -----------------------------------------------------
-- Table `mydb`.`lobby_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS lobby_list (
  id INT NOT NULL AUTO_INCREMENT,
  gamer_id VARCHAR(60) NOT NULL,
  gamer_name VARCHAR(45) NOT NULL,
  time_await TIME NULL,
  inprogress BIT(1) NULL DEFAULT 0,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`gamer_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS gamer_list (
  id_gamer_list INT NOT NULL,
  lobby_list_id INT NOT NULL,
  gamer_board JSON NOT NULL,
  validation_board JSON NULL,
  ballot INT NULL,
  is_playing BIT(1) NULL DEFAULT 0,
  is_bingo BIT(1) NULL DEFAULT 0,
  PRIMARY KEY (id_gamer_list),
  INDEX fk_gamer_list_lobby_list_idx (lobby_list_id ASC) VISIBLE,
  CONSTRAINT fk_gamer_list_lobby_list
    FOREIGN KEY (lobby_list_id)
    REFERENCES bingoDB.lobby_list (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;