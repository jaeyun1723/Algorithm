set @hour=-1;

SELECT (@hour := @hour + 1) as num, (SELECT count(*) 
                                     FROM animal_outs
                                     WHERE hour(datetime) = @hour) as count
FROM animal_outs
WHERE @hour < 23
