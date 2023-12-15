SELECT a.CAR_ID, a.CAR_TYPE,ROUND((a.DAILY_FEE *((100-c.DISCOUNT_RATE)*0.01))*30) as FEE
from CAR_RENTAL_COMPANY_CAR a
left join CAR_RENTAL_COMPANY_RENTAL_HISTORY b on a.CAR_ID=b.CAR_ID
left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN c on a.CAR_TYPE=c.CAR_TYPE
where a.CAR_TYPE in ("세단","SUV")
and c.DURATION_TYPE like "%30일%"
group by a.CAR_ID
having max(b.end_date)<="2022-11-01"
and FEE between 500000 and 2000000
order by FEE desc, CAR_TYPE, CAR_ID