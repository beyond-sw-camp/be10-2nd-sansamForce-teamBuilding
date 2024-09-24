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
              , 'MANAGER'
              , '01011112222'
              , 'test@gmail.com'
              , '001122'
              , 'M'
              , 'Test-git'
              , 'ACTIVE'
           );