SELECT MONTH(START_DATE), CAR_ID, COUNT(HISTORY_ID) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN (SELECT CAR_ID
                FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                WHERE MONTH(START_DATE) BETWEEN 8 AND 10
                GROUP BY CAR_ID
                HAVING COUNT(HISTORY_ID) >= 5) AND YEAR(START_DATE) = 2022 AND MONTH(START_DATE) BETWEEN 8 AND 10
GROUP BY MONTH(START_DATE), CAR_ID
HAVING RECORDS != 0
ORDER BY MONTH(START_DATE) ASC, CAR_ID DESC;