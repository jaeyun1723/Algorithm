SELECT item_id, item_name,rarity
FROM ITEM_INFO
WHERE item_id NOT IN (SELECT parent_item_id 
                      FROM ITEM_TREE 
                      WHERE parent_item_id is NOT NULL)
ORDER BY item_id DESC