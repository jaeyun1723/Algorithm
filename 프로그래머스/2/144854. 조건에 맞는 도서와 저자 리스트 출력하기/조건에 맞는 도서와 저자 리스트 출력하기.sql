-- 코드를 입력하세요
SELECT book_id, author_name, date_format(published_date,'%Y-%m-%d') as published_date
FROM book join author ON book.author_id=author.author_id
WHERE category='경제'
ORDER BY published_date
