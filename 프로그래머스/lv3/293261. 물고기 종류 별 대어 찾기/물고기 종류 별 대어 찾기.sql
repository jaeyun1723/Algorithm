SELECT id, fish_name, length
FROM FISH_INFO a JOIN FISH_NAME_INFO b ON a.fish_type = b.fish_type
WHERE (a.fish_type, length) IN (SELECT fish_type, max(length)
                                FROM FISH_INFO
                                GROUP BY fish_type)