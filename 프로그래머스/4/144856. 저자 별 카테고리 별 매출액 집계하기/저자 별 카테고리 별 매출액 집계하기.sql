SELECT author_id, author_name, category, sum(total_sales) as total_sales
FROM ( SELECT a.author_id, a.author_name, category, sum(sales)*price as total_sales
       FROM book b JOIN author a ON b.author_id=a.author_id
       JOIN book_sales c ON b.book_id = c.book_id
       WHERE sales_date BETWEEN '2022-01-01' AND '2022-01-31'
       GROUP BY author_id, author_name, category, price ) as b
GROUP BY author_id, author_name, category
ORDER BY author_id, category DESC