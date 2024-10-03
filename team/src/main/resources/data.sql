USE sansam;

-- 프로젝트 1의 사용자 (user_seq: 1-10)

INSERT INTO `tbl_user` (user_major, user_id, user_name, user_nickname, user_password, user_auth, user_phone, user_email, user_birth_date, user_gender, user_github_id, user_profile_img, user_status, reg_date, user_career_years, user_career_months)
VALUES
    ('전공학과', 'admin', '관리자', '관리자1', 'admin', 'MANAGER', NULL, 'manager@example.com', NULL, 'FEMALE', 'githubid', NULL, 'ACTIVE', NOW(), 0, 0),

    ('전공학과', 'kookong2', '구대윤', '구대윤', 'password1', 'MEMBER', NULL, 'kookong2@example.com', NULL, 'MALE', 'kookong2', NULL, 'ACTIVE', NOW(), 1, 6),
    ('전공학과', 'hyomee2', '권형미', '권형미', 'password2', 'MEMBER', NULL, 'hyomee2@example.com', NULL, 'FEMALE', 'hyomee2', NULL, 'ACTIVE', NOW(), 0, 10),
    ('전공학과', 'minju0224', '김민주', '김민주', 'password3', 'MEMBER', NULL, 'minju0224@example.com', NULL, 'FEMALE', 'minju0224', NULL, 'ACTIVE', NOW(), 1, 6),
    ('전공학과', 'we4sley', '김영기', '김영기', 'password4', 'MEMBER', NULL, 'we4sley@example.com', NULL, 'MALE', 'we4sley', NULL, 'ACTIVE', NOW(), 1, 6),
    ('비전공학과', 'WhooGeek', '김윤후', '김윤후', 'password5', 'MEMBER', NULL, 'rlarjswn0303@naver.com', NULL, 'MALE', 'WhooGeek', NULL, 'ACTIVE', NOW(), 0, 0),
    ('전공학과', 'kimjm9911', '김지민', '김지민', 'password6', 'MEMBER', NULL, 'kimjm9911@example.com', NULL, 'FEMALE', 'kimjm9911', NULL, 'ACTIVE', NOW(), 0, 10),
    ('비전공학과', 'wildcat222', '김태영', '김태영', 'password7', 'MEMBER', NULL, 'wildcat222@example.com', NULL, 'MALE', 'wildcat222', NULL, 'ACTIVE', NOW(), 0, 0),
    ('비전공학과', 'catnine11', '남가람', '남가람', 'password8', 'MEMBER', NULL, 'catnine11@example.com', NULL, 'FEMALE', 'catnine11', NULL, 'ACTIVE', NOW(), 0, 10),
    ('비전공학과', 'SANGHYUN0519', '박상현', '박상현', 'password9', 'MEMBER', NULL, 'SANGHYUN0519@example.com', NULL, 'MALE', 'SANGHYUN0519', NULL, 'ACTIVE', NOW(), 0, 0),

    ('전공학과', 'seolbin01', '박설빈', '박설빈', 'password10', 'MEMBER', NULL, 'seolbin01@example.com', NULL, 'FEMALE', 'seolbin01', NULL, 'ACTIVE', NOW(), 1, 6),
    ('전공학과', 'dispear', '박지훈', '박지훈', 'password11', 'MEMBER', NULL, 'dispear@example.com', NULL, 'MALE', 'dispear', NULL, 'ACTIVE', NOW(), 0, 0),
    ('전공학과', 'hcbak', '박희찬', '박희찬', 'password12', 'MEMBER', NULL, 'hcbak@example.com', NULL, 'MALE', 'hcbak', NULL, 'ACTIVE', NOW(), 1, 6),
    ('전공학과', 'SHINMIN7', '신민철', '신민철', 'password13', 'MEMBER', NULL, 'SHINMIN7@example.com', NULL, 'MALE', 'SHINMIN7', NULL, 'ACTIVE', NOW(), 3, 0),
    ('비전공학과', 'SaeRyung', '안세령', '안세령', 'password14', 'MEMBER', NULL, 'SaeRyung@example.com', NULL, 'FEMALE', 'SaeRyung', NULL, 'ACTIVE', NOW(), 0, 0),
    ('전공학과', 'ygc1994', '연건창', '연건창', 'password15', 'MEMBER', NULL, 'ygc1994@example.com', NULL, 'MALE', 'ygc1994', NULL, 'ACTIVE', NOW(), 0, 0),
    ('전공학과', 'beanteacher', '오민성', '오민성', 'password16', 'MEMBER', NULL, 'beanteacher@example.com', NULL, 'MALE', 'beanteacher', NULL, 'ACTIVE', NOW(), 1, 6),
    ('비전공학과', 'JIYOUNG-22', '윤지영', '윤지영', 'password17', 'MEMBER', NULL, 'JIYOUNG-22@example.com', NULL, 'FEMALE', 'JIYOUNG-22', NULL, 'ACTIVE', NOW(), 0, 0),
    ('전공학과', 'sungmini9755', '이성민', '이성민', 'password18', 'MEMBER', NULL, 'sungmini9755@example.com', NULL, 'MALE', 'sungmini9755', NULL, 'ACTIVE', NOW(), 0, 10),
    ('전공학과', 'eunseo-76', '이은서', '이은서', 'password19', 'MEMBER', NULL, 'eunseo-76@example.com', NULL, 'FEMALE', 'eunseo-76', NULL, 'ACTIVE', NOW(), 0, 10),

    ('비전공학과', 'leebackcoding', '이창윤', '이창윤', 'password20', 'MEMBER', NULL, 'leebackcoding@example.com', NULL, 'MALE', 'leebackcoding', NULL, 'ACTIVE', NOW(), 1, 6),
    ('전공학과', 'Pangtaek', '임광택', '임광택', 'password21', 'MEMBER', NULL, 'Pangtaek@example.com', NULL, 'MALE', 'Pangtaek', NULL, 'ACTIVE', NOW(), 0, 10),
    ('전공학과', 'person76', '임서연', '임서연', 'password22', 'MEMBER', NULL, 'person76@example.com', NULL, 'FEMALE', 'person76', NULL, 'ACTIVE', NOW(), 0, 10),
    ('전공학과', 'pbem22', '임채륜', '임채륜', 'password23', 'MEMBER', NULL, 'pbem22@example.com', NULL, 'MALE', 'pbem22', NULL, 'ACTIVE', NOW(), 0, 10),
    ('비전공학과', 'AYeong-Jeon', '전아영', '전아영', 'password24', 'MEMBER', NULL, 'AYeong-Jeon@example.com', NULL, 'FEMALE', 'AYeong-Jeon', NULL, 'ACTIVE', NOW(), 1, 6),
    ('전공학과', 'JungUiJin', '정의진', '정의진', 'password25', 'MEMBER', NULL, 'JungUiJin@example.com', NULL, 'MALE', 'JungUiJin', NULL, 'ACTIVE', NOW(), 1, 6),
    ('전공학과', 'enking', '최두혁', '최두혁', 'password26', 'MEMBER', NULL, 'enking@example.com', NULL, 'MALE', 'enking', NULL, 'ACTIVE', NOW(), 0, 0),
    ('전공학과', 'HanDJ00', '한동주', '한동주', 'password27', 'MEMBER', NULL, 'HanDJ00@example.com', NULL, 'MALE', 'HanDJ00', NULL, 'ACTIVE', NOW(), 3, 0),
    ('전공학과', 'aosskfdlrla', '황희순', '황희순', 'password28', 'MEMBER', NULL, 'aosskfdlrla@example.com', NULL, 'FEMALE', 'aosskfdlrla', NULL, 'ACTIVE', NOW(), 1, 6);



INSERT INTO `tbl_project` (`project_admin_seq`, `project_title`, `project_content`, `project_status`, `project_head_count`, `project_img_url`, `project_start_date`, `project_end_date`, `reg_date`)
VALUES
    (1, 'Project Alpha', 'Content for Project Alpha', 'PROGRESS', 10, 'http://example.com/alpha.png', '2024-01-01 00:00:00', '2024-12-31 23:59:59', NOW()),
    (11, 'Project Beta', 'Content for Project Beta', 'PROGRESS', 10, 'http://example.com/beta.png', '2024-02-01 00:00:00', '2024-11-30 23:59:59', NOW()),
(1, '백엔드 프로젝트', '한화시스템 beyond 캠프 10기', 'PROGRESS', 28, 'http://example.com/alpha.png', '2024-01-01 00:00:00', '2024-12-31 23:59:59', NOW());

INSERT INTO tbl_building_rule ( rule_team_count
                              , rule_major_weight
                              , rule_career_weight
                              , rule_github_weight
                              , rule_team_review_weight
                              , rule_mentor_review_weight
                              , rule_tech_stack_yn
                              , reg_date
)
VALUES
    (5,3 , 4,5, 0,0,'Y',NOW());

-- 프로젝트 Alpha (project_seq: 1)
INSERT INTO `tbl_team` (`project_seq`, `rule_seq`, `team_name`, `team_status`, `reg_date`, `end_date`)
VALUES
    (1, 1, 'Alpha Team A', 'CLOSE', NOW(), '2024-09-16 14:58:01'),
    (1, 1, 'Alpha Team B', 'CLOSE', NOW(), '2024-09-10 14:58:01'),

-- 프로젝트 Beta (project_seq: 2)
    (2, 1, 'Beta Team A','OPEN', NOW(), NULL),
    (2, 1, 'Beta Team B','OPEN', NOW(),NULL);

-- 프로젝트 Alpha (project_seq: 1, user_seq: 1-10)
INSERT INTO `tbl_project_member` (`project_seq`, `user_seq`, `project_member_del_yn`, `project_mentor_yn`, `project_member_major_yn`, `project_member_develop_type`,`project_member_commit_score`,`reg_date`)
VALUES
    (1, 1, 'N', 'Y', 'Y','BACKEND', NULL,NOW()),  -- 관리자
    (1, 2, 'N', 'N', 'Y','BACKEND', NULL,NOW()),
    (1, 3, 'N', 'N', 'Y','BACKEND', NULL,NOW()),
    (1, 4, 'N', 'N', 'Y','BACKEND', NULL,NOW()),
    (1, 5, 'N', 'N', 'Y','BACKEND', NULL,NOW()),
    (1, 6, 'N', 'N', 'N','BACKEND', NULL,NOW()),
    (1, 7, 'N', 'N', 'Y','BACKEND',NULL, NOW()),
    (1, 8, 'N', 'N', 'N','BACKEND', NULL,NOW()),
    (1, 9, 'N', 'N', 'N','BACKEND', NULL,NOW()),
    (1, 10, 'N', 'N', 'N','BACKEND', NULL,NOW()),

    (1, 11, 'N', 'N', 'Y',NULL,NULL,NOW()),  -- 관리자
    (1, 12, 'N', 'N', 'Y','BACKEND',NULL,NOW()),
    (1, 13, 'N', 'N', 'Y','BACKEND',NULL,NOW()),
    (1, 14, 'N', 'N', 'Y','BACKEND',NULL,NOW()),
    (1, 15, 'N', 'N', 'N','BACKEND',NULL,NOW()),
    (1, 16, 'N', 'N', 'Y','BACKEND',NULL,NOW()),
    (1, 17, 'N', 'N', 'Y','BACKEND',NULL,NOW()),
    (1, 18, 'N', 'N', 'N','BACKEND',NULL,NOW()),
    (1, 19, 'N', 'N', 'Y','BACKEND',NULL,NOW()),
    (1, 20, 'N', 'N', 'Y','BACKEND',NULL,NOW()),

    (1, 21, 'N', 'N', 'N','BACKEND',NULL,NOW()),
    (1, 22, 'N', 'N', 'Y','BACKEND',NULL,NOW()),
(1, 23, 'N', 'N', 'Y','BACKEND',NULL,NOW()),
(1, 24, 'N', 'N', 'Y','BACKEND',NULL,NOW()),
(1, 25, 'N', 'N', 'N','BACKEND',NULL,NOW()),
(1, 26, 'N', 'N', 'Y','BACKEND',NULL,NOW()),
(1, 27, 'N', 'N', 'Y','BACKEND',NULL,NOW()),
(1, 28, 'N', 'N', 'Y','BACKEND',NULL,NOW()),
(1, 29, 'N', 'N', 'Y','BACKEND',NULL,NOW());


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
INSERT INTO `tbl_team_schedule` (`team_seq`, `team_schedule_content`, `team_schedule_start_date`, `team_schedule_end_date`, `reg_date`)
VALUES
    (1, 'Alpha Team A Kickoff Meeting', '2024-01-05 10:00:00', '2024-01-05 12:00:00',NOW()),
    (2, 'Alpha Team B Design Review', '2024-01-10 14:00:00', '2024-01-10 16:00:00',NOW()),
    (3, 'Beta Team A Sprint Planning', '2024-02-05 09:00:00', '2024-02-05 11:00:00',NOW()),
    (4, 'Beta Team B Retrospective', '2024-02-15 15:00:00', '2024-02-15 17:00:00',NOW());

INSERT INTO `tbl_user_review` (`send_team_member_seq`,`receive_team_member_seq`,`team_member_review_star`,`team_member_review_content`,`reg_date`)
VALUES
        (1,2,5,'GREAT',NOW()),
        (2,1,5,'GREAT',NOW()),
        (10,3,5,'GREAT',NOW()),
        (2,3,4,'GREAT',NOW());


INSERT INTO `tbl_mentor_review` (project_member_seq, project_mentor_seq, mentor_review_star, mentor_review_content, reg_date)
VALUES
        (2,1,5,'GREAT',NOW()),
        (3,1,5,'GREAT',NOW()),
        (5,1,5,'GREAT',NOW()),
        (7,1,5,'GREAT',NOW()),
        (9,1,5,'GREAT',NOW());

INSERT INTO `tbl_user_github_repository` (user_repository_url, user_repository_name, develop_type,user_seq)
VALUES
    ('https://github.com/SansamForce/team-building', 'SansamForce', 'BACKEND',1),
    ('https://github.com/SansamForce/team-building', 'SansamForce', 'BACKEND',2),
    ('https://github.com/DaeChamSa/with-the-developer', 'DaeChamSa', 'BACKEND',3),
    ('https://github.com/5MYBAB/itta-bab', '5MYBAB', 'BACKEND',4),
    ('https://github.com/DaeChamSa/with-the-developer', 'DaeChamSa', 'BACKEND',5),
    ('https://github.com/taste-house/mat_zip', 'taste-house','BACKEND', 6),
    ('https://github.com/SW-Pettory/pettory', 'SW-Pettory', 'BACKEND',7),
    ('https://github.com/taste-house/mat_zip', 'taste-house', 'BACKEND',8),
    ('https://github.com/taste-house/mat_zip', 'taste-house', 'BACKEND',9),
    ('https://github.com/SansamForce/team-building', 'SansamForce','BACKEND',10),

    ('https://github.com/5MYBAB/itta-bab', '5MYBAB', 'BACKEND',11),
    ('https://github.com/SW-Pettory/pettory', 'SW-Pettory', 'BACKEND',12),
    ('https://github.com/taste-house/mat_zip', 'taste-house', 'BACKEND',13),
    ('https://github.com/5MYBAB/itta-bab', '5MYBAB', 'BACKEND',14),
    ('https://github.com/DaeChamSa/with-the-developer', 'DaeChamSa', 'BACKEND',15),
    ('https://github.com/SW-Pettory/pettory', 'SW-Pettory','BACKEND', 16),
    ('https://github.com/SansamForce/team-building', 'SansamForce', 'BACKEND',17),
    ('https://github.com/taste-house/mat_zip', 'taste-house', 'BACKEND',18),
    ('https://github.com/5MYBAB/itta-bab', '5MYBAB', 'BACKEND',19),
    ('https://github.com/SW-Pettory/pettory', 'SW-Pettory','BACKEND',20),

    ('https://github.com/taste-house/mat_zip', 'taste-house', 'BACKEND',21),
    ('https://github.com/5MYBAB/itta-bab', '5MYBAB', 'BACKEND',22),
    ('https://github.com/SansamForce/team-building', 'SansamForce', 'BACKEND',23),
    ('https://github.com/DaeChamSa/with-the-developer', 'DaeChamSa', 'BACKEND',24),
    ('https://github.com/SansamForce/team-building', 'SansamForce', 'BACKEND',25),
    ('https://github.com/DaeChamSa/with-the-developer', 'DaeChamSa','BACKEND', 26),
    ('https://github.com/5MYBAB/itta-bab', '5MYBAB', 'BACKEND',27),
    ('https://github.com/SW-Pettory/pettory', 'SW-Pettory', 'BACKEND',28),
    ('https://github.com/SW-Pettory/pettory', 'SW-Pettory', 'BACKEND',29);