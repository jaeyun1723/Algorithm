SELECT ins.animal_id, ins.name
FROM animal_ins as ins RIGHT OUTER JOIN animal_outs as outs
ON ins.animal_id=outs.animal_id
ORDER BY datediff(outs.datetime,ins.datetime) DESC
LIMIT 2