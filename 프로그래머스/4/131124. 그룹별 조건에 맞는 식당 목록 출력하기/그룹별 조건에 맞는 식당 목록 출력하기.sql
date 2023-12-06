select m.member_name, review_text, date_format(review_date, '%Y-%m-%d')
from member_profile as m inner join rest_review as r on m.member_id = r.member_id
where m.member_id = (select member_id
                  from rest_review
                  group by member_id
                  order by count(review_id) desc
                    limit 1)
order by review_date, review_text;