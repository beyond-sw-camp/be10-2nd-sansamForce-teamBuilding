DROP TABLE IF EXISTS tbl_user;

CREATE TABLE tbl_user (
    user_seq BIGINT NOT NULL AUTO_INCREMENT,
    user_id VARCHAR(30) NOT NULL,
    user_name VARCHAR(30),
    user_nickname VARCHAR(50),
    user_password VARCHAR(15) NOT NULL,
    user_auth VARCHAR(15),
    user_phone VARCHAR(11),
    user_email VARCHAR(30),
    user_birth_date CHAR(6),
    user_gender CHAR(1),
    user_github_id VARCHAR(30),
    user_propile_img VARCHAR(255),
    user_status VARCHAR(20),
    reg_date TIMESTAMP DEFAULT current_timestamp(),
    mod_date TIMESTAMP NULL DEFAULT NULL,
    del_date TIMESTAMP NULL DEFAULT NULL,
    user_pwd_mod_date TIMESTAMP NULL DEFAULT NULL,
    user_ban_date TIMESTAMP NULL DEFAULT NULL,
    CONSTRAINT tbl_user_PK PRIMARY KEY(user_seq)
    );