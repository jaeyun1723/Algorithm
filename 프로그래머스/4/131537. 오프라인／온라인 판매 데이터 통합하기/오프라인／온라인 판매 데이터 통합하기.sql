SELECT date_format(sales_date,'%Y-%m-%d') as sales_date, product_id, user_id, sales_amount
      FROM ONLINE_SALE
      WHERE date_format(sales_date,'%Y-%m')='2022-03'
      UNION ALL
      SELECT  date_format(sales_date,'%Y-%m-%d') as sales_date, product_id, null, sales_amount
      FROM OFFLINE_SALE
      WHERE date_format(sales_date,'%Y-%m')='2022-03'
ORDER BY sales_date, product_id, user_id