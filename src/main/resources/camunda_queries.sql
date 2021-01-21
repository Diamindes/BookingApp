select * from dual;

--To check deployment:
--select * from ACT_RE_DEPLOYMENT;

--To check running process:
-- select * from ACT_RE_PROCDEF;

-- To check running task:
-- select * from ACT_RU_TASK;

-- To check the completed process:
-- SELECT * FROM ACT_HI_PROCINST;

-- To check the completed task:
-- select * from ACT_HI_TASKINST;

--Orders total summary
--select ord.date, ord.order_type as "Order type", pay.payment_type as "Payment type",
--u.fullname as "Visitor Name", res.date_create_reservation as "Reservation date",
--rest.name as Restaurant, sum(cast(di.price as int)) as Total
--from orders ord
--join payments pay on pay.id = ord.payment_id
--join users u on u.id = ord.user_id
--join reservations res on res.order_id = ord.id
--join restaurants rest on rest.id = res.RESTAURANT_ID
--join orders_dishes od on od.order_id = ord.id
--join dishes di on di.id = od.dishes_id
--where u.id = 55;