USE sansam;
INSERT INTO `tbl_major` (`major_university`, `major_department`, `major_department_code`, `reg_date`)
VALUES
    ('Seoul University', 'Computer Science', 'CS101', NOW()),
    ('Korea University', 'Electrical Engineering', 'EE202', NOW());


-- 프로젝트 1의 사용자 (user_seq: 1-10)
INSERT INTO `tbl_user` (`major_seq`, `user_id`, `user_name`, `user_nickname`, `user_password`, `user_auth`, `user_phone`, `user_email`, `user_birth_date`, `user_gender`, `user_github_id`, `user_profile_img`, `user_status`, `reg_date`)
VALUES
    (1, 'user1_p1', 'User One', 'UOne', 'password1', 'MEMBER', '01012345678', 'user1_p1@example.com', '900101', 'Male', 'person76', NULL, 'active', NOW()),
    (1, 'user2_p1', 'User Two', 'UTwo', 'password2', 'MEMBER', '01023456789', 'user2_p1@example.com', '900202', 'Female', 'person76', NULL, 'active', NOW()),
    (1, 'user3_p1', 'User Three', 'UThree', 'password3', 'MEMBER', '01034567890', 'user3_p1@example.com', '900303', 'Male', 'person76', NULL, 'active', NOW()),
    (1, 'user4_p1', 'User Four', 'UFour', 'password4', 'MEMBER', '01045678901', 'user4_p1@example.com', '900404', 'Female', 'person76', NULL, 'active', NOW()),
    (1, 'user5_p1', 'User Five', 'UFive', 'password5', 'MEMBER', '01056789012', 'user5_p1@example.com', '900505', 'Male', 'person76', NULL, 'active', NOW()),
    (1, 'user6_p1', 'User Six', 'USix', 'password6', 'MEMBER', '01067890123', 'user6_p1@example.com', '900606', 'Female', 'person76', NULL, 'active', NOW()),
    (1, 'user7_p1', 'User Seven', 'USeven', 'password7', 'MEMBER', '01078901234', 'user7_p1@example.com', '900707', 'Male', 'person76', NULL, 'active', NOW()),
    (1, 'user8_p1', 'User Eight', 'UEight', 'password8', 'MEMBER', '01089012345', 'user8_p1@example.com', '900808', 'Female', 'person76', NULL, 'active', NOW()),
    (1, 'user9_p1', 'User Nine', 'UNine', 'password9', 'MEMBER', '01090123456', 'user9_p1@example.com', '900909', 'Male', 'person76', NULL, 'active', NOW()),
    (1, 'user10_p1', 'User Ten', 'UTen', 'password10', 'MEMBER', '01001234567', 'user10_p1@example.com', '901010', 'Female', 'person76', NULL, 'active', NOW()),

-- 프로젝트 2의 사용자 (user_seq: 11-20)
    (2, 'user1_p2', 'User Eleven', 'UEleven', 'password11', 'MEMBER', '01011234567', 'user1_p2@example.com', '901111', 'Male', 'person76', NULL, 'active', NOW()),
    (2, 'user2_p2', 'User Twelve', 'UTwelve', 'password12', 'MEMBER', '01022345678', 'user2_p2@example.com', '901222', 'Female', 'person76', NULL, 'active', NOW()),
    (2, 'user3_p2', 'User Thirteen', 'UThirteen', 'password13', 'MEMBER', '01033456789', 'user3_p2@example.com', '901333', 'Male', 'person76', NULL, 'active', NOW()),
    (2, 'user4_p2', 'User Fourteen', 'UFourteen', 'password14', 'MEMBER', '01044567890', 'user4_p2@example.com', '901444', 'Female', 'person76', NULL, 'active', NOW()),
    (2, 'user5_p2', 'User Fifteen', 'UFifteen', 'password15', 'MEMBER', '01055678901', 'user5_p2@example.com', '901555', 'Male', 'person76', NULL, 'active', NOW()),
    (2, 'user6_p2', 'User Sixteen', 'USixteen', 'password16', 'MEMBER', '01066789012', 'user6_p2@example.com', '901666', 'Female', 'person76', NULL, 'active', NOW()),
    (2, 'user7_p2', 'User Seventeen', 'USeventeen', 'password17', 'MEMBER', '01077890123', 'user7_p2@example.com', '901777', 'Male', 'person76', NULL, 'active', NOW()),
    (2, 'user8_p2', 'User Eighteen', 'UEighteen', 'password18', 'MEMBER', '01088901234', 'user8_p2@example.com', '901888', 'Female', 'person76', NULL, 'active', NOW()),
    (2, 'user9_p2', 'User Nineteen', 'UNineteen', 'password19', 'MEMBER', '01099012345', 'user9_p2@example.com', '901999', 'Male', 'person76', NULL, 'active', NOW()),
    (2, 'user10_p2', 'User Twenty', 'UTwenty', 'password20', 'MEMBER', '01010123456', 'user10_p2@example.com', '902010', 'Female', 'person76', NULL, 'active', NOW());

INSERT INTO `tbl_building_rule` (`rule_team_count`, `rule_major_weight`, `rule_career_weight`, `rule_github_weight`, `rule_team_review_weight`, `rule_mentor_review_weight`, `rule_tech_stack_yn`, `reg_date`)
VALUES
    (2, 10, 8, 7, 5, 5, 'Y', NOW());

INSERT INTO `tbl_project` (`project_admin_seq`, `project_title`, `project_content`, `project_status`, `project_head_count`, `project_img_url`, `project_start_date`, `project_end_date`, `reg_date`)
VALUES
    (1, 'Project Alpha', 'Content for Project Alpha', 'PROGRESS', 10, 'http://example.com/alpha.png', '2024-01-01 00:00:00', '2024-12-31 23:59:59', NOW()),
    (11, 'Project Beta', 'Content for Project Beta', 'PROGRESS', 10, 'http://example.com/beta.png', '2024-02-01 00:00:00', '2024-11-30 23:59:59', NOW());

-- 프로젝트 Alpha (project_seq: 1)
INSERT INTO `tbl_team` (`project_seq`, `rule_seq`, `team_name`, `team_status`, `reg_date`, `end_date`)
VALUES
    (1, 1, 'Alpha Team A', 'CLOSE', NOW(), '2024-09-16 14:58:01'),
    (1, 1, 'Alpha Team B', 'CLOSE', NOW(), '2024-09-10 14:58:01'),

-- 프로젝트 Beta (project_seq: 2)
    (2, 1, 'Beta Team A','OPEN', NOW(), NULL),
    (2, 1, 'Beta Team B','OPEN', NOW(),NULL);

-- 프로젝트 Alpha (project_seq: 1, user_seq: 1-10)
INSERT INTO `tbl_project_member` (`project_seq`, `user_seq`, `project_member_del_yn`, `project_mentor_yn`, `project_member_major_yn`, `project_member_interest_type`,`project_member_commit_score`,`reg_date`)
VALUES
    (1, 1, 'N', 'Y', 'Y','BACKEND', NULL,NOW()),  -- 관리자
    (1, 2, 'N', 'N', 'Y','FRONTEND', NULL,NOW()),
    (1, 3, 'N', 'N', 'Y','BACKEND', NULL,NOW()),
    (1, 4, 'N', 'N', 'N','FRONTEND', NULL,NOW()),
    (1, 5, 'N', 'N', 'N','BACKEND', NULL,NOW()),
    (1, 6, 'N', 'N', 'N','BACKEND', NULL,NOW()),
    (1, 7, 'N', 'N', 'N','FRONTEND',NULL, NOW()),
    (1, 8, 'N', 'N', 'N','BACKEND', NULL,NOW()),
    (1, 9, 'N', 'N', 'Y','BACKEND', NULL,NOW()),
    (1, 10, 'N', 'N', 'Y','FRONTEND', NULL,NOW()),

-- 프로젝트 Beta (project_seq: 2, user_seq: 11-20)
    (2, 11, 'N', 'Y', NULL,NULL,NULL,NOW()),  -- 관리자
    (2, 12, 'N', 'N', 'Y','FRONTEND',NULL,NOW()),
    (2, 13, 'N', 'N', 'Y','BACKEND',NULL,NOW()),
    (2, 14, 'N', 'N', 'N','BACKEND',NULL,NOW()),
    (2, 15, 'N', 'N', 'Y','FRONTEND',NULL,NOW()),
    (2, 16, 'N', 'N', 'Y','BACKEND',NULL,NOW()),
    (2, 17, 'N', 'N', 'N','FRONTEND',NULL,NOW()),
    (2, 18, 'N', 'N', 'Y','BACKEND',NULL,NOW()),
    (2, 19, 'N', 'N', 'N','FRONTEND',NULL,NOW()),
    (2, 20, 'N', 'N', 'Y','BACKEND',NULL,NOW());

-- Alpha Team A (team_seq: 1, user_seq: 1-5)
INSERT INTO `tbl_team_member` (`team_seq`, `user_seq`, `reg_date`)
VALUES
    (1, 1,  NOW()),
    (1, 2,  NOW()),
    (1, 3,  NOW()),
    (1, 4,  NOW()),
    (1, 5,  NOW()),

-- Alpha Team B (team_seq: 2, user_seq: 6-10)
    (2, 6,  NOW()),
    (2, 7,  NOW()),
    (2, 8,  NOW()),
    (2, 9,  NOW()),
    (2, 10,  NOW()),

-- Beta Team A (team_seq: 3, user_seq: 11-15)
    (3, 11,  NOW()),
    (3, 12,  NOW()),
    (3, 13,  NOW()),
    (3, 14,  NOW()),
    (3, 15,  NOW()),

-- Beta Team B (team_seq: 4, user_seq: 16-20)
    (4, 16,  NOW()),
    (4, 17,  NOW()),
    (4, 18,  NOW()),
    (4, 19,  NOW()),
    (4, 20,  NOW());

-- 팀 스케줄 예시
INSERT INTO `tbl_team_schedule` (`team_seq`, `team_schedule_content`, `team_schedule_start_date`, `team_schedule_end_date`)
VALUES
    (1, 'Alpha Team A Kickoff Meeting', '2024-01-05 10:00:00', '2024-01-05 12:00:00'),
    (2, 'Alpha Team B Design Review', '2024-01-10 14:00:00', '2024-01-10 16:00:00'),
    (3, 'Beta Team A Sprint Planning', '2024-02-05 09:00:00', '2024-02-05 11:00:00'),
    (4, 'Beta Team B Retrospective', '2024-02-15 15:00:00', '2024-02-15 17:00:00');

INSERT INTO tbl_building_rule ( rule_team_count
                              , rule_major_weight
                              , rule_career_weight
                              , rule_github_weight
                              , rule_team_review_weight
                              , rule_mentor_review_weight
                              , rule_tech_stack_yn
                              , reg_date
                              , mod_date
)
VALUES (
           1,
           10,
           4,
           3,
           2,
           5,
           4,
           'Y',
           NOW(),
           NOW()
       );