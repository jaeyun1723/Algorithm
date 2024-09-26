SELECT a.item_id, item_name, rarity
FROM item_info as a JOIN (SELECT item_id
                            FROM item_tree
                            WHERE item_id NOT IN (SELECT parent_item_id
                            FROM item_tree WHERE parent_item_id IS NOT NULL)) as b
ON a.item_id=b.item_id
ORDER BY a.item_id DESC