--liquibase formatted sql
--changeset julia:202502271927
--comment: tb_boards table create

CREATE TABLE IF NOT EXISTS tb_boards(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
) ENGINE=InnoDB;

--rollback DROP TABLE IF EXISTS tb_boards;