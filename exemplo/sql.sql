-- SET FOREIGN_KEY_CHECKS = 0; 
-- truncate table cliente;
-- truncate table endereco;
-- SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `cliente` (
	`cliente_id` INT(11) NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR(50) NOT NULL,
	`cpf` VARCHAR(11) NOT NULL,
	`banco` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`cliente_id`),
	UNIQUE INDEX `cpf` (`cpf`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=3
;

CREATE TABLE `endereco` (
	`endereco_id` INT(11) NOT NULL AUTO_INCREMENT,
	`cliente_id` INT(11) NOT NULL DEFAULT '0',
	`rua` VARCHAR(50) NOT NULL DEFAULT '0',
	`numero` VARCHAR(50) NOT NULL DEFAULT '0',
	`complemento` VARCHAR(50) NOT NULL DEFAULT '0',
	`bairro` VARCHAR(50) NOT NULL DEFAULT '0',
	`cidade` VARCHAR(50) NOT NULL DEFAULT '0',
	`cep` VARCHAR(50) NOT NULL DEFAULT '0',
	PRIMARY KEY (`endereco_id`),
	INDEX `fk_cliente` (`cliente_id`),
	CONSTRAINT `fk_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`cliente_id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;
