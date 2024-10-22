SELECT category, sum(sales) as total_sales
FROM book as b JOIN (SELECT *
                     FROM book_sales
                     WHERE date_format(sales_date, '%Y-%m') = '2022-01') as c
               ON b.book_id=c.book_id
GROUP BY category
ORDER BY category
