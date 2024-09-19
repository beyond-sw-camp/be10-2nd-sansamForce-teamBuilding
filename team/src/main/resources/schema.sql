CREATE TABLE `tbl_major`
(
    `major_seq`bigint	NOT NULL,
    `major_university` varchar(30)	NULL,
    `major_department` varchar(30)	NULL,
    `major_department_code`char(10) NULL
);

ALTER TABLE `tbl_major` ADD CONSTRAINT `PK_TBL_MAJOR` PRIMARY KEY (`major_seq`);

CREATE TABLE `tbl_user`
(
    `user_seq` bigint NOT NULL,
    `major_seq` bigint NOT NULL,
    `user_id` varchar(30) NOT NULL,
    `user_name` varchar(30) NOT NULL,
    `user_nickname` varchar(50) NOT NULL,
    `user_password` varchar(100)	NOT NULL,
    `user_auth` varchar(15) NOT NULL,
    `user_phone` char(11) NULL,
    `user_email` varchar(30) NOT NULL,
    `user_brith_date` char(6) NULL,
    `user_gender` char(1) NOT NULL,
    `user_github_id` varchar(30)	NULL,
    `user_profile_img` varchar(255) NULL,
    `user_status` varchar(20) NULL,
    `user_pwd_mod_date` timestamp NULL,
    `user_ban_date` timestamp NULL,
    `reg_date` timestamp	NOT NULL,
    `del_date` timestamp	NULL,
    `mod_date` timestamp	NULL
);

ALTER TABLE `tbl_user` ADD CONSTRAINT `PK_TBL_USER` PRIMARY KEY (`user_seq`);

CREATE TABLE `tbl_login_log`
(
    `login_log_seq`	bigint NOT NULL,
    `user_seq`bigint NOT NULL,
    `login_log_code`varchar(30)	NOT NULL,
    `login_log_reg_date`timestamp NOT NULL,
    `login_log_ip`varchar(15) NOT NULL,
    `login_log_agent`varchar(255) NOT NULL
);
ALTER TABLE `tbl_login_log` ADD CONSTRAINT `PK_TBL_LOGIN_LOG` PRIMARY KEY (`login_log_seq`);

CREATE TABLE `tbl_project`
(
    `project_seq` bigint NOT NULL,
    `user_seq`	bigint NOT NULL,
    `project_title` varchar(50) NOT NULL,
    `project_content` longtext	NOT NULL,
    `project_status` varchar(10) NOT NULL,
    `project_head_count` int NOT NULL,
    `project_img_url` varchar(100)	NULL,
    `project_start_date` timestamp NOT NULL,
    `project_end_date` timestamp NOT NULL,
    `reg_date`	timestamp NOT NULL,
    `mod_date`	timestamp NULL,
    `del_date`	timestamp NULL
);

ALTER TABLE `tbl_project` ADD CONSTRAINT `PK_TBL_PROJECT` PRIMARY KEY (`project_seq`);

CREATE TABLE `tbl_project_board`
(
    `project_board_seq` bigint NOT NULL,
    `user_seq`	bigint NOT NULL,
    `project_board_title` varchar(50) NOT NULL,
    `project_board_content`	longtext NOT NULL,
    `project_board_head_count` int NOT NULL,
    `project_board_img_url`	varchar(30)	NULL,
    `project_board_start_date` timestamp NOT NULL,
    `project_board_end_date` timestamp NOT NULL,
    `project_board_status` char(1)	NULL,
    `reg_date`	timestamp NULL,
    `mod_date`	timestamp NULL,
    `del_date`	timestamp NULL,
    `project_start_date` timestamp tbl_project_boardNULL,
    `project_end_date` timestamp NULL
);

ALTER TABLE `tbl_project_board` ADD CONSTRAINT `PK_TBL_PROJECT_BOARD` PRIMARY KEY (`project_board_seq`);

CREATE TABLE `tbl_project_member`
(
    `project_member_seq` bigint NOT NULL,
    `project_seq` bigint NOT NULL,
    `user_seq`	bigint NOT NULL,
    `project_member_del_yn` char(1) NOT NULL,
    `project_mentor_yn` char(1) NOT NULL
);
ALTER TABLE `tbl_project_member` ADD CONSTRAINT `PK_TBL_PROJECT_MEMBER` PRIMARY KEY (`project_member_seq`);

CREATE TABLE `tbl_project_apply_member`
(
    `project_apply_member_seq` bigint NOT NULL,
    `project_seq` bigint	NOT NULL,
    `user_seq` bigint NOT NULL,
    `project_apply_member_status` varchar(10) NOT NULL,
    `reg_date` timestamp	NOT NULL,
    `mod_date` timestamp	NULL,
    `del_date` timestamp	NULL
);

ALTER TABLE `tbl_project_apply_member` ADD CONSTRAINT `PK_TBL_PROJECT_APPLY_MEMBER` PRIMARY KEY (`project_apply_member_seq`);

CREATE TABLE `tbl_team`
(
    `team_seq` bigint NOT NULL,
    `pro_seq` bigint NOT NULL,
    `rule_seq` bigint NOT NULL,
    `team_name` varchar(255)	NOT NULL,
    `reg_date` timestamp	NOT NULL
);

ALTER TABLE `tbl_team` ADD CONSTRAINT `PK_TBL_TEAM` PRIMARY KEY (`team_seq`);

CREATE TABLE `tbl_team_chat`
(
    `team_chat_seq` bigint	NOT NULL,
    `team_seq`	bigint NOT NULL,
    `team_chat_name` varchar(50) NOT NULL,
    `team_chat_comment` varchar(255) NULL,
    `team_chat_active` char(1)	NOT NULL,
    `reg_date`	timestamp NOT NULL,
    `mod_date`	timestamp NULL,
    `del_date`	timestamp NULL
);

ALTER TABLE `tbl_team_chat` ADD CONSTRAINT `PK_TBL_TEAM_CHAT` PRIMARY KEY (`team_chat_seq`);

CREATE TABLE `tbl_team_schedule`
(
    `team_schedule_seq` bigint NOT NULL,
    `team_seq`	bigint NOT NULL,
    `team_schedule_contents` varchar(4000) NOT NULL,
    `team_schedule_start_date` timestamp NOT NULL,
    `team_schedule_end_date` timestamp NOT NULL
);

ALTER TABLE `tbl_team_schedule` ADD CONSTRAINT `PK_TBL_TEAM_SCHEDULE` PRIMARY KEY (`team_schedule_seq`);

CREATE TABLE `tbl_team_member`
(
    `team_member_seq` bigint NOT NULL,
    `team_seq` bigint NOT NULL,
    `user_seq` bigint	NOT NULL,
    `team_member_major_yn` char(1) NOT NULL,
    `team_member_intetest` char(2) NULL
);

ALTER TABLE `tbl_team_member` ADD CONSTRAINT `PK_TBL_TEAM_MEMBER` PRIMARY KEY (`team_member_seq`);

CREATE TABLE `tbl_team_member_schedule_progress`
(
    `team_schedule_progress_seq` bigint NOT NULL,
    `team_schedule_seq` bigint	NOT NULL,
    `team_member_seq` bigint	NOT NULL,
    `team_schedule_progress_text` varchar(1000) NOT NULL,
    `team_schedule_progress_reg_date` timestamp NOT NULL,
    `team_schedule_progress_feed_text` varchar(1000) NULL
);

ALTER TABLE `tbl_team_member_schedule_progress` ADD CONSTRAINT `PK_TBL_TEAM_MEMBER_SCHEDULE_PROGRESS` PRIMARY KEY (`team_schedule_progress_seq`);

CREATE TABLE `tbl_notice_alarm`
(
    `notice_alarm_seq`bigint NOT NULL,
    `project_seq`	bigint NOT NULL,
    `user_seq` bigint	NOT NULL,
    `notice_alarm_title` varchar(50)	NOT NULL,
    `notice_alarm_text` longtext	NOT NULL,
    `notice_alarm_delete_yn` char(1)	NULL,
    `reg_date` timestamp	NULL,
    `del_date` timestamp	NULL
);

ALTER TABLE `tbl_notice_alarm` ADD CONSTRAINT `PK_TBL_NOTICE_ALARM` PRIMARY KEY (`notice_alarm_seq`);

CREATE TABLE `tbl_buliding_rule`
(
    `rule_seq` bigint NOT NULL,
    `team_seq` bigint NOT NULL,
    `rule_text` varchar(255) NOT NULL,
    `reg_date` timestamp NOT NULL,
    `mod_date` timestamp NULL,
    `del_date` timestamp NULL
);

ALTER TABLE `tbl_buliding_rule` ADD CONSTRAINT `PK_TBL_BULIDING_RULE` PRIMARY KEY (`rule_seq`);

CREATE TABLE `tbl_user_review`
(
    `user_review_seq` bigint	NOT NULL,
    `team_member_seq` bigint	NOT NULL,
    `user_review_title` varchar(50) NOT NULL,
    `user_review_text` longtext NOT NULL,
    `user_review_rate` float	NOT NULL,
    `reg_date` timestamp	NULL,
    `mod_date` timestamp	NULL,
    `del_date` timestamp	NULL
);

ALTER TABLE `tbl_user_review` ADD CONSTRAINT `PK_TBL_USER_REVIEW` PRIMARY KEY (`user_review_seq`);

CREATE TABLE `tbl_chat_content`
(
    `chat_content_seq` bigint	NOT NULL,
    `team_member_seq` bigint	NOT NULL,
    `chat_content_text` varchar(2000)	NOT NULL,
    `reg_date` timestamp	NOT NULL,
    `mod_date` timestamp	NULL
);
ALTER TABLE `tbl_chat_content` ADD CONSTRAINT `PK_TBL_CHAT_CONTENT` PRIMARY KEY (`chat_content_seq`);

CREATE TABLE `mentor_review`
(
    `mentor_review_seq`	bigint	NOT NULL,
    `project_member_seq` bigint	NOT NULL,
    `mentor_review_title` varchar(50)	NOT NULL,
    `mentor_review_text` longtext	NOT NULL,
    `mentor_review_rate` float	NOT NULL,
    `reg_date`	timestamp	NOT NULL
);

ALTER TABLE `mentor_review` ADD CONSTRAINT `PK_MENTOR_REVIEW` PRIMARY KEY (`mentor_review_seq`);
