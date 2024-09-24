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

INSERT INTO tbl_project (
                          user_seq
                        , project_title
                        , project_content
                        , project_status
                        , project_head_count
                        , project_img_url
                        , project_start_date
                        , project_end_date
                        , reg_date
) VALUES (
            1
         , "프로젝트 제목 테스트"
         , "프로젝트 내용 테스트"
         , "PROGRESS"
         , 30
         , "url test"
         ,  date_add(now(), interval -1 day)
         ,  date_add(now(), INTERVAL +70 day)
         , NOW()
         );
