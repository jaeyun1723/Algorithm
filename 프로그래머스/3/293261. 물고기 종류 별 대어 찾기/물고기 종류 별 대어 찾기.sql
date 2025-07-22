SELECT id, fish_name, length
FROM FISH_INFO a JOIN FISH_NAME_INFO b ON a.fish_type=b.fish_type
JOIN (SELECT fish_type, max(length) as len
       FROM FISH_INFO
       GROUP BY fish_type) c ON a.fish_type=c.fish_type
WHERE length=len
ORDER BY id