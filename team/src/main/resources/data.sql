INSERT INTO
    tbl_user (
                user_id
              , user_name
              , user_nickname
              , user_password
              , user_auth
              , user_phone
              , user_email
              , user_birth_date
              , user_gender
              , user_github_id
              , user_status
            )
    values (
            'test'
              , '테스트이름'
              , '테스트닉네임'
              , '$2a$10$1xMzXBNe8P5gxLP1Tqpxk.q1fnxuiDCxHoABhGqRbN0/Dfub1NYae'  /* 테스트2 */
              , 'MEMBER'
              , '01011112222'
              , 'test@gmail.com'
              , '001122'
              , 'M'
              , 'Test-git'
              , 'ACTIVE'
           );
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
