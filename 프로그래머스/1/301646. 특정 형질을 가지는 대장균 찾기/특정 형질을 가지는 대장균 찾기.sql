SELECT count(*) as count
FROM ECOLI_DATA
WHERE genotype & 2 = 0 AND genotype & 5 > 0