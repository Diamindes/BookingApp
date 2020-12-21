--ID | NAME | PRICE | TYPE
insert into dishes values(1, 'TEA', '50', 'Drinks');

--ID | NAME
insert into ingredients values(1, 'Pocket of tea');

-- DISH_ID | INGREDIENT_ID
insert into dish_ingredient values(1,1);

--ID | NAME | MENU_ID
insert into restaurants values(1, 'Ginza', null);

--ID | RESTAURANT_ID
insert into menus values(1,1);
update restaurants set menu_id = 1 where id = 1;

--MENU_ID | DISHES_LIST_ID
insert into menus_dishes_list values(1,1);

--ID | CHECK_ID | DATE | PAYMENT_TYPE
insert into payments values(1, 1,current_date, 'CARD');

--ID | FULLNAME | LOGIN | PASSWORD | ROLE_TYPE | TELEPHONE | RESTAURANT_ID
insert into users values(55, 'Jung Brutal Gutaussehend', 'user1', 'user1', 'USER', '+1 111 111', 1);
insert into users values(1, 'Mr. Waiter', 'waiter', 'waiter', 'WAITER', '+1 111 222', 1);

--ID | IS_NEAR_THE_WINDOW | EMPLOYEE_ID | NUMBER_NAME | NUMBER_OF_SEATS | RESTAURANT_ID
insert into tables values(1, 1, 1, 1, 3, 1);

--ID | DATE | ORDER_TYPE | PAYMENT_ID | TABLE_ID | USER_ID
insert into orders values (1, current_date, 'HERE', 1, 1, 55);

--ORDER_ID | DISHES_ID
insert into orders_dishes values (1,1);

--ID | DATE_CREATE_RESERVATION | DATE_END_RESERVATION | DATE_START_RESERVATION | ORDER_ID | RESTAURANT_ID | TABLE_ID | USER_ID
insert into reservations values (1, current_timestamp, current_timestamp, current_timestamp, 1, 1, 1, 55);

--USER_ID | DISH_ID
insert into user_dish values (55, 1);
