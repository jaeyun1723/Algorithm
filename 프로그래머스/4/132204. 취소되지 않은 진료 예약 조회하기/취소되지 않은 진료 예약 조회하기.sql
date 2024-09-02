-- 2022.4.13 취소되지 않은 CS 진료 예약 내역 조회
SELECT apnt_no, pt_name, pt_no, mcdp_cd, dr_name, apnt_ymd
FROM patient NATURAL JOIN  (SELECT apnt_no, pt_no, doctor.mcdp_cd, dr_name, apnt_ymd
                    FROM doctor JOIN appointment
                    ON dr_id = mddr_id
                    AND doctor.mcdp_cd='cs' AND apnt_cncl_yn = 'N'
                    WHERE date(apnt_ymd)='2022-04-13') AS csapt
ORDER BY apnt_ymd