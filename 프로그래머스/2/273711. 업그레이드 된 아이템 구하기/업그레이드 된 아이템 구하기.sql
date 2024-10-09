SELECT item_id, item_name, rarity
FROM item_info
WHERE item_id IN (SELECT item_id
                  FROM item_tree
                  WHERE parent_item_id IN (SELECT item_id
                                           FROM item_info
                                           WHERE rarity='RARE'))
ORDER BY item_id DESC

