/* 1. 날짜 표시 */
-- 1) dayofweek(date) : 날짜를 한 주의 몇 번째 요일인지를 나타내는 숫자로 리턴한다.
-- (1 = 일요일, 2 = 월요일, ... 7 = 토요일)
select dayofweek('2021-06-30') as '요일'; -- 4

-- 2) weekday(date) : 날짜를 한 주의 몇 번째 요일인지를 나타내는 숫자로 리턴한다. 
-- (0 = 월요일, 1=화요일 ... 6 = 일요일)
select weekday('2021-06-30') as '요일'; -- 2

-- 3) dayofmonth(date) : 그 달의 몇 번째 날인지를 알려준다. 리턴 값은 1에서 31 사이이다.
select dayofmonth('2021-06-29') as '일';

-- 4) dayofyear(date) : 한 해의 몇 번째 날인지를 알려준다. 리턴 값은 1에서 366 사이이다.
select dayofyear('2021-01-12');
select dayofyear('2021-07-30');

-- 5) month(date) : 해당 날짜가 몇 월인지 알려준다. 리턴 값은 1에서 12 사이이다.
select month('2021-02-03');

-- 6) dayname(date) : 해당 날짜의 영어식 요일이름을 리턴한다.
select dayname('2021-12-25');

-- 7) monthname(date) : 해당 날짜의 영어식 월 이름을 리턴한다.
select monthname('2021-02-05');

-- 8) quarter(date) : 분기를 리턴한다 (1~ 4)
select quarter('2021-04-01') as '분기';

-- 9) week(date) : 해달 날짜가 몇 번째 주일인지(0 ~ 52)를 리턴
select week('1998-02-20');
select week('1998-02-20',0); -- 을 한 주의 시작요일(0:일요일, 1:월요일)
select week('1998-02-20',1);



/* 2. 날짜 계산 */
-- 1) period_add(p,n) : yymm 또는 yyyymm 형식으로 주어진 달에 n개월을 더한다. 리턴 값은 yyyymm의 형식이다.
select period_add(2109,36); -- 202409

-- 2) period_diff(p1,p2) : yymm 또는 yyyymm 형식으로 주어진 두 기간사이의 개월을 구한다
select period_diff(2104,202109); -- -5
select period_diff(202104,202109);

-- 3) date_add(date,interval expr type) or adddate(date,interval expr type)
-- 특정한 단위를 더한다.
-- seconds, minutes, hours, days, months, years
select date_add("2021-12-31 23:59:59",interval 1 second); -- 1초 더하기
select date_add("2021-12-31 23:59:59",interval 30 day); -- 30일 더하기
select date_add("2021-12-31 23:59:59",interval 1 month); -- 1개월 더하기
select date_add("2021-12-31 23:59:59",interval "10:1" minute_second); -- 10분:1초 더하기
select date_add("2021-12-31 23:59:59",interval "1:30" hour_minute); -- 1시간:30분 더하기


-- 4) date_sub(date,interval expr type) or subdate(date,interval expr type)
-- 특정한 단위를 뺀다.
-- seconds, minutes, hours, days, months, years
select date_sub("2022-01-01 00:00:00",interval "1 1" day_hour); 		-- 1일 1시간
select date_sub("2022-01-01 00:00:00",interval "1-1" year_month); 		-- 1년-1개월
select date_sub("2022-01-01 00:00:00",interval "1:1:1" hour_second);	-- 1시간:1분:1초 빼기
select date_sub("2022-01-01 00:00:00",interval "1 1:1" day_minute);		-- 1일 1시간:1분 빼기
select date_sub("2022-01-01 00:00:00",interval "1 1:1:1" day_second);	-- 1일 1시간:1분:1초 빼기


-- 5) to_days(date) : 주어진 날짜를 0000년-00월-00일 부터의 일수로 바꾼다.
select to_days(210629); -- 0000년-00월-00일 부터 2021년-06월29일 까지의 일 수
select to_days('2021-06-29');
 
-- 6) from_days(n) : 주어진 일수로부터 날짜를 구한다(to_days 반대 개념)
select from_days(738335);


/* 3. 날짜 형식 */
-- 1) date_format(date,format) format 의 정의에 따라 날자 혹은 시간을 출력한다. 

-- %y : 2자리 년도 - %Y 는 4자리 년도
-- %m : 월(01~12) - %M 은 월 이름
-- %d 일(00~31)
select date_format('2021-07-01 13:54:00', '%y년 %m월 %d일');
select date_format('2021-07-01 13:54:00', '%M %Y');

-- %b : 짧은 월이름 (jan..dec)
-- %D : 영어식 접미사를 붙인 일(1st, 2nd, 3rd, etc.)
-- %a : 짧은 요일명(sun~sat)
select date_format('2021-07-01 13:54:00', '%b %D (%a)');
-- %W : 요일명, %w : 일주일의 몇 번째 요일인가(0=sunday~6=saturday) 
select date_format('2021-07-01 13:54:00', '%b %D (%W)');

-- %c : 월(1~12), %e : 일(0~31), %H : 24시 형식의 시간 (00~23), %i : 분, %s : 초(00~59)
select date_format('2021-07-01 13:54:00', '%c-%e %H:%i:%s');

-- %h : 12시 형식의 시간 (01~12), %p : am 또는 pm 문자
select date_format('2021-07-01 13:54:00', '%h:%i:%s %p');

-- %r : 시분초12시 형식 (hh:mm:ss [ap]m)
select date_format(NOW(), '%r');

-- %T : 시분초 24시 형식 (hh:mm:ss)
select date_format(NOW(), '%T');

-- %U : 한해의 몇 번째 주인가(0~52) 일요일이 시작일
-- %u : 한해의 몇 번째 주인가(0~52) 월요일이 시작일
select date_format(NOW(), '%U');


-- 2) time_format(time,format) : date_format()와 비슷한 역할을 하지만 단지 시,분,초 만을 나타낼 수 있다.
select date_format('2021-07-01 13:54:00', '%h:%i:%s %p') 
	union all
select time_format('2021-07-01 13:54:00', '%h:%i:%s %p');
 
-- 3) curdate() : 오늘 날짜를 오늘 날짜를 'yyyy-mm-dd' 형식으로 리턴
select curdate(); -- yyyy-mm-dd
select curdate() + 0; -- yyyymmdd

-- 4) curtime() : 'hh:mm:ss' 형식으로 현재시간을 나타낸다.
select curtime();		-- hh:mm:ss
select curtime() + 0;	-- hhmmss

-- 5) now() | sysdate() | current_timestamp() : 오늘 날자와 현재 시간을 'yyyy-mm-dd hh:mm:ss' 형식으로 반환
select now();
select now() + 0;

 
-- 6) unix_timestamp(date)
-- 인수가 없이 사용될 경우 현재 시간의 유닉스 타임스탬프, 
-- 날짜형식의 date 가 인수로 주어진 경우에는 주어진 날짜의 유닉스 타임스탬프를 반환
-- 유닉스 타임스탬프 : 그리니치 표준시로 1970 년 1월 1일 00:00:00 이 후의 시간경과를 초단위로 나타낸 것
select unix_timestamp();
select unix_timestamp(now());


-- 7) from_unixtime(unix_timestamp) : 주어진 유닉스 타임스탬프 값으로부터 'yyyy-mm-dd hh:mm:ss' 형식의 날짜로 반환
select from_unixtime(1625031063);
select from_unixtime(1625031063) + 0;

-- 8) from_unixtime(unix_timestamp,format) : 주어진 유닉스 타임스탬프 값을 주어진 날짜 형식에 맞게 바꿔서 보여준다. 
select from_unixtime(unix_timestamp(),'%Y-%m-%d %h:%i:%s');

-- 9) sec_to_time(seconds) : 주어진 초를 'hh:mm:ss' 형식으로 반환
select sec_to_time(2378);
select sec_to_time(2378) + 0;

-- 10) time_to_sec(time) : 주어진 시간을 초 단위로 바꿔준다.
select time_to_sec('22:23:00');