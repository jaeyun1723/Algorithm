SELECT category, sum(sales)
FROM BOOK as a JOIN BOOK_SALES as b ON a.book_id=b.book_id
WHERE DATE_FORMAT(sales_date,'%Y-%m') = '2022-01'
GROUP BY category
ORDER BY category