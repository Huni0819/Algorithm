SELECT YEAR(O.SALES_DATE), MONTH(O.SALES_DATE), COUNT(DISTINCT O.USER_ID) AS PUCHASED_USERS, ROUND(COUNT(DISTINCT O.USER_ID) / (SELECT COUNT(USER_ID)
                                                                                                      FROM USER_INFO
                                                                                                      WHERE YEAR(JOINED) = 2021), 1) AS PUCHASED_RATIO
FROM USER_INFO AS U INNER JOIN ONLINE_SALE AS O ON U.USER_ID = O.USER_ID
WHERE YEAR(U.JOINED) = 2021
GROUP BY YEAR(O.SALES_DATE), MONTH (O.SALES_DATE)
ORDER BY YEAR(O.SALES_DATE) ASC, MONTH(O.SALES_DATE) ASC