CREATE TABLE IF NOT EXISTS `todo` (
    `UUIDv4` VARCHAR(36) NOT NULL,
    `内容` TEXT NOT NULL,
    `created_at` DATETIME NOT NULL,
    PRIMARY KEY (`UUIDv4`)) ENGINE = InnoDB;