create table actor
(
    actor_id    int unsigned auto_increment
        primary key,
    first_name  varchar(45)                         not null,
    last_name   varchar(45)                         not null,
    last_update timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
)
    charset = utf8;

create index idx_actor_last_name
    on actor (last_name);

create table category
(
    category_id int unsigned auto_increment
        primary key,
    name        varchar(25)                         not null,
    last_update timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
)
    charset = utf8;

create table country
(
    country_id  int unsigned auto_increment
        primary key,
    country     varchar(50)                         not null,
    last_update timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
)
    charset = utf8;

create table city
(
    city_id     int unsigned auto_increment
        primary key,
    city        varchar(50)                         not null,
    country_id  int unsigned                        not null,
    last_update timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    constraint fk_city_country
        foreign key (country_id) references country (country_id)
            on update cascade
)
    charset = utf8;

create table address
(
    address_id  int unsigned auto_increment
        primary key,
    address     varchar(50)                         not null,
    address2    varchar(50)                         null,
    district    varchar(20)                         not null,
    city_id     int unsigned                        not null,
    postal_code varchar(10)                         null,
    phone       varchar(20)                         not null,
    last_update timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    constraint fk_address_city
        foreign key (city_id) references city (city_id)
            on update cascade
)
    charset = utf8;

create index idx_fk_city_id
    on address (city_id);

create index idx_fk_country_id
    on city (country_id);

create table film_text
(
    film_id     int          not null
        primary key,
    title       varchar(255) not null,
    description text         null
)
    engine = MyISAM
    charset = utf8;

create fulltext index idx_title_description
    on film_text (title, description);

create table language
(
    language_id int unsigned auto_increment
        primary key,
    name        char(20)                            not null,
    last_update timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
)
    charset = utf8;

create table film
(
    film_id              int unsigned auto_increment
        primary key,
    title                varchar(255)                                                            not null,
    description          text                                                                    null,
    release_year         year                                                                    null,
    language_id          int unsigned                                                            not null,
    original_language_id int unsigned                                                            null,
    rental_duration      tinyint unsigned                        default '3'                     not null,
    rental_rate          decimal(4, 2)                           default 4.99                    not null,
    length               smallint unsigned                                                       null,
    replacement_cost     decimal(5, 2)                           default 19.99                   not null,
    rating               enum ('G', 'PG', 'PG-13', 'R', 'NC-17') default 'G'                     null,
    special_features     set ('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes') null,
    last_update          timestamp                               default CURRENT_TIMESTAMP       not null on update CURRENT_TIMESTAMP,
    constraint fk_film_language
        foreign key (language_id) references language (language_id)
            on update cascade,
    constraint fk_film_language_original
        foreign key (original_language_id) references language (language_id)
            on update cascade
)
    charset = utf8;

create index idx_fk_language_id
    on film (language_id);

create index idx_fk_original_language_id
    on film (original_language_id);

create index idx_title
    on film (title);

create table film_actor
(
    actor_id    int unsigned                        not null,
    film_id     int unsigned                        not null,
    last_update timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    primary key (actor_id, film_id),
    constraint fk_film_actor_actor
        foreign key (actor_id) references actor (actor_id)
            on update cascade,
    constraint fk_film_actor_film
        foreign key (film_id) references film (film_id)
            on update cascade
)
    charset = utf8;

create index idx_fk_film_id
    on film_actor (film_id);

create table film_category
(
    film_id     int unsigned                        not null,
    category_id int unsigned                        not null,
    last_update timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    primary key (film_id, category_id),
    constraint fk_film_category_category
        foreign key (category_id) references category (category_id)
            on update cascade,
    constraint fk_film_category_film
        foreign key (film_id) references film (film_id)
            on update cascade
)
    charset = utf8;

create table staff
(
    staff_id    int unsigned auto_increment
        primary key,
    first_name  varchar(45)                          not null,
    last_name   varchar(45)                          not null,
    address_id  int unsigned                         not null,
    picture     mediumblob                           null,
    email       varchar(50)                          null,
    store_id    int unsigned                         not null,
    active      tinyint(1) default 1                 not null,
    username    varchar(16)                          not null,
    password    varchar(40) collate utf8_bin         null,
    last_update timestamp  default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    constraint fk_staff_address
        foreign key (address_id) references address (address_id)
            on update cascade
)
    charset = utf8;

create index idx_fk_address_id
    on staff (address_id);

create index idx_fk_store_id
    on staff (store_id);

create table store
(
    store_id         int unsigned auto_increment
        primary key,
    manager_staff_id int unsigned                        not null,
    address_id       int unsigned                        not null,
    last_update      timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    constraint idx_unique_manager
        unique (manager_staff_id),
    constraint fk_store_address
        foreign key (address_id) references address (address_id)
            on update cascade,
    constraint fk_store_staff
        foreign key (manager_staff_id) references staff (staff_id)
            on update cascade
)
    charset = utf8;

create table customer
(
    customer_id int unsigned auto_increment
        primary key,
    store_id    int unsigned                         not null,
    first_name  varchar(45)                          not null,
    last_name   varchar(45)                          not null,
    email       varchar(50)                          null,
    address_id  int unsigned                         not null,
    active      tinyint(1) default 1                 not null,
    create_date datetime                             not null,
    last_update timestamp  default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint fk_customer_address
        foreign key (address_id) references address (address_id)
            on update cascade,
    constraint fk_customer_store
        foreign key (store_id) references store (store_id)
            on update cascade
)
    charset = utf8;

create index idx_fk_address_id
    on customer (address_id);

create index idx_fk_store_id
    on customer (store_id);

create index idx_last_name
    on customer (last_name);

create table inventory
(
    inventory_id int unsigned auto_increment
        primary key,
    film_id      int unsigned                        not null,
    store_id     int unsigned                        not null,
    last_update  timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    constraint fk_inventory_film
        foreign key (film_id) references film (film_id)
            on update cascade,
    constraint fk_inventory_store
        foreign key (store_id) references store (store_id)
            on update cascade
)
    charset = utf8;

create index idx_fk_film_id
    on inventory (film_id);

create index idx_store_id_film_id
    on inventory (store_id, film_id);

create table rental
(
    rental_id    int auto_increment
        primary key,
    rental_date  datetime                            not null,
    inventory_id int unsigned                        not null,
    customer_id  int unsigned                        not null,
    return_date  datetime                            null,
    staff_id     int unsigned                        not null,
    last_update  timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    constraint rental_date
        unique (rental_date, inventory_id, customer_id),
    constraint fk_rental_customer
        foreign key (customer_id) references customer (customer_id)
            on update cascade,
    constraint fk_rental_inventory
        foreign key (inventory_id) references inventory (inventory_id)
            on update cascade,
    constraint fk_rental_staff
        foreign key (staff_id) references staff (staff_id)
            on update cascade
)
    charset = utf8;

create table payment
(
    payment_id   int unsigned auto_increment
        primary key,
    customer_id  int unsigned                        not null,
    staff_id     int unsigned                        not null,
    rental_id    int                                 null,
    amount       decimal(5, 2)                       not null,
    payment_date datetime                            not null,
    last_update  timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint fk_payment_customer
        foreign key (customer_id) references customer (customer_id)
            on update cascade,
    constraint fk_payment_rental
        foreign key (rental_id) references rental (rental_id)
            on update cascade on delete set null,
    constraint fk_payment_staff
        foreign key (staff_id) references staff (staff_id)
            on update cascade
)
    charset = utf8;

create index idx_fk_customer_id
    on payment (customer_id);

create index idx_fk_staff_id
    on payment (staff_id);

create index idx_fk_customer_id
    on rental (customer_id);

create index idx_fk_inventory_id
    on rental (inventory_id);

create index idx_fk_staff_id
    on rental (staff_id);

alter table staff
    add constraint fk_staff_store
        foreign key (store_id) references store (store_id)
            on update cascade;

create index idx_fk_address_id
    on store (address_id);

create definer = root@`%` view actor_info as
select `a`.`actor_id`                              AS `actor_id`,
       `a`.`first_name`                            AS `first_name`,
       `a`.`last_name`                             AS `last_name`,
       group_concat(distinct concat(`c`.`name`, ': ',
                                    (select group_concat(`f`.`title` order by `f`.`title` ASC
                                                         separator ', ')
                                     from ((`sakila`.`film` `f` join `sakila`.`film_category` `fc`
                                            on ((`f`.`film_id` = `fc`.`film_id`))) join `sakila`.`film_actor` `fa`
                                           on ((`f`.`film_id` = `fa`.`film_id`)))
                                     where ((`fc`.`category_id` = `c`.`category_id`) and
                                            (`fa`.`actor_id` = `a`.`actor_id`)))) order by
                    `c`.`name` ASC separator '; ') AS `film_info`
from (((`sakila`.`actor` `a` left join `sakila`.`film_actor` `fa`
        on ((`a`.`actor_id` = `fa`.`actor_id`))) left join `sakila`.`film_category` `fc`
       on ((`fa`.`film_id` = `fc`.`film_id`))) left join `sakila`.`category` `c`
      on ((`fc`.`category_id` = `c`.`category_id`)))
group by `a`.`actor_id`, `a`.`first_name`, `a`.`last_name`;

create definer = root@`%` view customer_list as
select `cu`.`customer_id`                               AS `ID`,
       concat(`cu`.`first_name`, ' ', `cu`.`last_name`) AS `name`,
       `a`.`address`                                    AS `address`,
       `a`.`postal_code`                                AS `zip code`,
       `a`.`phone`                                      AS `phone`,
       `sakila`.`city`.`city`                           AS `city`,
       `sakila`.`country`.`country`                     AS `country`,
       if(`cu`.`active`, 'active', '')                  AS `notes`,
       `cu`.`store_id`                                  AS `SID`
from (((`sakila`.`customer` `cu` join `sakila`.`address` `a`
        on ((`cu`.`address_id` = `a`.`address_id`))) join `sakila`.`city`
       on ((`a`.`city_id` = `sakila`.`city`.`city_id`))) join `sakila`.`country`
      on ((`sakila`.`city`.`country_id` = `sakila`.`country`.`country_id`)));

create definer = root@`%` view film_list as
select `sakila`.`film`.`film_id`     AS `FID`,
       `sakila`.`film`.`title`       AS `title`,
       `sakila`.`film`.`description` AS `description`,
       `sakila`.`category`.`name`    AS `category`,
       `sakila`.`film`.`rental_rate` AS `price`,
       `sakila`.`film`.`length`      AS `length`,
       `sakila`.`film`.`rating`      AS `rating`,
       group_concat(concat(`sakila`.`actor`.`first_name`, ' ', `sakila`.`actor`.`last_name`)
                    separator ', ')  AS `actors`
from ((((`sakila`.`category` left join `sakila`.`film_category`
         on ((`sakila`.`category`.`category_id` =
              `sakila`.`film_category`.`category_id`))) left join `sakila`.`film`
        on ((`sakila`.`film_category`.`film_id` =
             `sakila`.`film`.`film_id`))) join `sakila`.`film_actor`
       on ((`sakila`.`film`.`film_id` = `sakila`.`film_actor`.`film_id`))) join `sakila`.`actor`
      on ((`sakila`.`film_actor`.`actor_id` = `sakila`.`actor`.`actor_id`)))
group by `sakila`.`film`.`film_id`, `sakila`.`film`.`title`, `sakila`.`film`.`description`,
         `sakila`.`film`.`rental_rate`, `sakila`.`film`.`length`, `sakila`.`film`.`rating`,
         `sakila`.`category`.`name`;

create definer = root@`%` view nicer_but_slower_film_list as
select `sakila`.`film`.`film_id`     AS `FID`,
       `sakila`.`film`.`title`       AS `title`,
       `sakila`.`film`.`description` AS `description`,
       `sakila`.`category`.`name`    AS `category`,
       `sakila`.`film`.`rental_rate` AS `price`,
       `sakila`.`film`.`length`      AS `length`,
       `sakila`.`film`.`rating`      AS `rating`,
       group_concat(concat(concat(upper(substr(`sakila`.`actor`.`first_name`, 1, 1)),
                                  lower(substr(`sakila`.`actor`.`first_name`, 2,
                                               length(`sakila`.`actor`.`first_name`))), ' ',
                                  concat(upper(substr(`sakila`.`actor`.`last_name`, 1, 1)),
                                         lower(substr(`sakila`.`actor`.`last_name`, 2,
                                                      length(`sakila`.`actor`.`last_name`))))))
                    separator ', ')  AS `actors`
from ((((`sakila`.`category` left join `sakila`.`film_category`
         on ((`sakila`.`category`.`category_id` =
              `sakila`.`film_category`.`category_id`))) left join `sakila`.`film`
        on ((`sakila`.`film_category`.`film_id` =
             `sakila`.`film`.`film_id`))) join `sakila`.`film_actor`
       on ((`sakila`.`film`.`film_id` = `sakila`.`film_actor`.`film_id`))) join `sakila`.`actor`
      on ((`sakila`.`film_actor`.`actor_id` = `sakila`.`actor`.`actor_id`)))
group by `sakila`.`film`.`film_id`, `sakila`.`film`.`title`, `sakila`.`film`.`description`,
         `sakila`.`film`.`rental_rate`, `sakila`.`film`.`length`, `sakila`.`film`.`rating`,
         `sakila`.`category`.`name`;

create definer = root@`%` view sales_by_film_category as
select `c`.`name` AS `category`, sum(`p`.`amount`) AS `total_sales`
from (((((`sakila`.`payment` `p` join `sakila`.`rental` `r`
          on ((`p`.`rental_id` = `r`.`rental_id`))) join `sakila`.`inventory` `i`
         on ((`r`.`inventory_id` = `i`.`inventory_id`))) join `sakila`.`film` `f`
        on ((`i`.`film_id` = `f`.`film_id`))) join `sakila`.`film_category` `fc`
       on ((`f`.`film_id` = `fc`.`film_id`))) join `sakila`.`category` `c`
      on ((`fc`.`category_id` = `c`.`category_id`)))
group by `c`.`name`
order by `total_sales` desc;

create definer = root@`%` view sales_by_store as
select concat(`c`.`city`, ',', `cy`.`country`)        AS `store`,
       concat(`m`.`first_name`, ' ', `m`.`last_name`) AS `manager`,
       sum(`p`.`amount`)                              AS `total_sales`
from (((((((`sakila`.`payment` `p` join `sakila`.`rental` `r`
            on ((`p`.`rental_id` = `r`.`rental_id`))) join `sakila`.`inventory` `i`
           on ((`r`.`inventory_id` = `i`.`inventory_id`))) join `sakila`.`store` `s`
          on ((`i`.`store_id` = `s`.`store_id`))) join `sakila`.`address` `a`
         on ((`s`.`address_id` = `a`.`address_id`))) join `sakila`.`city` `c`
        on ((`a`.`city_id` = `c`.`city_id`))) join `sakila`.`country` `cy`
       on ((`c`.`country_id` = `cy`.`country_id`))) join `sakila`.`staff` `m`
      on ((`s`.`manager_staff_id` = `m`.`staff_id`)))
group by `s`.`store_id`
order by `cy`.`country`, `c`.`city`;

create definer = root@`%` view staff_list as
select `s`.`staff_id`                                 AS `ID`,
       concat(`s`.`first_name`, ' ', `s`.`last_name`) AS `name`,
       `a`.`address`                                  AS `address`,
       `a`.`postal_code`                              AS `zip code`,
       `a`.`phone`                                    AS `phone`,
       `sakila`.`city`.`city`                         AS `city`,
       `sakila`.`country`.`country`                   AS `country`,
       `s`.`store_id`                                 AS `SID`
from (((`sakila`.`staff` `s` join `sakila`.`address` `a`
        on ((`s`.`address_id` = `a`.`address_id`))) join `sakila`.`city`
       on ((`a`.`city_id` = `sakila`.`city`.`city_id`))) join `sakila`.`country`
      on ((`sakila`.`city`.`country_id` = `sakila`.`country`.`country_id`)));

create
    definer = root@`%` procedure film_in_stock(IN p_film_id int, IN p_store_id int, OUT p_film_count int) reads sql data
BEGIN
    SELECT inventory_id
    FROM inventory
    WHERE film_id = p_film_id
      AND store_id = p_store_id
      AND inventory_in_stock(inventory_id);

    SELECT FOUND_ROWS() INTO p_film_count;
END;

create
    definer = root@`%` procedure film_not_in_stock(IN p_film_id int, IN p_store_id int, OUT p_film_count int)
    reads sql data
BEGIN
    SELECT inventory_id
    FROM inventory
    WHERE film_id = p_film_id
      AND store_id = p_store_id
      AND NOT inventory_in_stock(inventory_id);

    SELECT FOUND_ROWS() INTO p_film_count;
END;

create
    definer = root@`%` function get_customer_balance(p_customer_id int, p_effective_date datetime) returns decimal(5, 2)
    deterministic
    reads sql data
BEGIN

    #OK, WE NEED TO CALCULATE THE CURRENT BALANCE GIVEN A CUSTOMER_ID AND A DATE
    #THAT WE WANT THE BALANCE TO BE EFFECTIVE FOR. THE BALANCE IS:
    #   1) RENTAL FEES FOR ALL PREVIOUS RENTALS
    #   2) ONE DOLLAR FOR EVERY DAY THE PREVIOUS RENTALS ARE OVERDUE
    #   3) IF A FILM IS MORE THAN RENTAL_DURATION * 2 OVERDUE, CHARGE THE REPLACEMENT_COST
    #   4) SUBTRACT ALL PAYMENTS MADE BEFORE THE DATE SPECIFIED

    DECLARE v_rentfees DECIMAL(5,2); #FEES PAID TO RENT THE VIDEOS INITIALLY
    DECLARE v_overfees INTEGER;      #LATE FEES FOR PRIOR RENTALS
    DECLARE v_payments DECIMAL(5,2); #SUM OF PAYMENTS MADE PREVIOUSLY

    SELECT IFNULL(SUM(film.rental_rate),0) INTO v_rentfees
    FROM film, inventory, rental
    WHERE film.film_id = inventory.film_id
      AND inventory.inventory_id = rental.inventory_id
      AND rental.rental_date <= p_effective_date
      AND rental.customer_id = p_customer_id;

    SELECT IFNULL(SUM(IF((TO_DAYS(rental.return_date) - TO_DAYS(rental.rental_date)) > film.rental_duration,
                         ((TO_DAYS(rental.return_date) - TO_DAYS(rental.rental_date)) - film.rental_duration),0)),0) INTO v_overfees
    FROM rental, inventory, film
    WHERE film.film_id = inventory.film_id
      AND inventory.inventory_id = rental.inventory_id
      AND rental.rental_date <= p_effective_date
      AND rental.customer_id = p_customer_id;


    SELECT IFNULL(SUM(payment.amount),0) INTO v_payments
    FROM payment

    WHERE payment.payment_date <= p_effective_date
      AND payment.customer_id = p_customer_id;

    RETURN v_rentfees + v_overfees - v_payments;
END;

create
    definer = root@`%` function inventory_held_by_customer(p_inventory_id int) returns int reads sql data
BEGIN
    DECLARE v_customer_id INT;
    DECLARE EXIT HANDLER FOR NOT FOUND RETURN NULL;

    SELECT customer_id INTO v_customer_id
    FROM rental
    WHERE return_date IS NULL
      AND inventory_id = p_inventory_id;

    RETURN v_customer_id;
END;

create
    definer = root@`%` function inventory_in_stock(p_inventory_id int) returns tinyint(1) reads sql data
BEGIN
    DECLARE v_rentals INT;
    DECLARE v_out     INT;

    #AN ITEM IS IN-STOCK IF THERE ARE EITHER NO ROWS IN THE rental TABLE
    #FOR THE ITEM OR ALL ROWS HAVE return_date POPULATED

    SELECT COUNT(*) INTO v_rentals
    FROM rental
    WHERE inventory_id = p_inventory_id;

    IF v_rentals = 0 THEN
        RETURN TRUE;
    END IF;

    SELECT COUNT(rental_id) INTO v_out
    FROM inventory LEFT JOIN rental USING(inventory_id)
    WHERE inventory.inventory_id = p_inventory_id
      AND rental.return_date IS NULL;

    IF v_out > 0 THEN
        RETURN FALSE;
    ELSE
        RETURN TRUE;
    END IF;
END;

create
    definer = root@`%` procedure rewards_report(IN min_monthly_purchases tinyint unsigned,
                                                IN min_dollar_amount_purchased decimal(10, 2) unsigned,
                                                OUT count_rewardees int)
    comment 'Provides a customizable report on best customers'
    reads sql data
proc: BEGIN

    DECLARE last_month_start DATE;
    DECLARE last_month_end DATE;

    /* Some sanity checks... */
    IF min_monthly_purchases = 0 THEN
        SELECT 'Minimum monthly purchases parameter must be > 0';
        LEAVE proc;
    END IF;
    IF min_dollar_amount_purchased = 0.00 THEN
        SELECT 'Minimum monthly dollar amount purchased parameter must be > $0.00';
        LEAVE proc;
    END IF;

    /* Determine start and end time periods */
    SET last_month_start = DATE_SUB(CURRENT_DATE(), INTERVAL 1 MONTH);
    SET last_month_start = STR_TO_DATE(CONCAT(YEAR(last_month_start),'-',MONTH(last_month_start),'-01'),'%Y-%m-%d');
    SET last_month_end = LAST_DAY(last_month_start);

    /*
        Create a temporary storage area for
        Customer IDs.
    */
    CREATE TEMPORARY TABLE tmpCustomer (customer_id INT UNSIGNED NOT NULL PRIMARY KEY);

    /*
        Find all customers meeting the
        monthly purchase requirements
    */
    INSERT INTO tmpCustomer (customer_id)
    SELECT p.customer_id
    FROM payment AS p
    WHERE DATE(p.payment_date) BETWEEN last_month_start AND last_month_end
    GROUP BY customer_id
    HAVING SUM(p.amount) > min_dollar_amount_purchased
       AND COUNT(customer_id) > min_monthly_purchases;

    /* Populate OUT parameter with count of found customers */
    SELECT COUNT(*) FROM tmpCustomer INTO count_rewardees;

    /*
        Output ALL customer information of matching rewardees.
        Customize output as needed.
    */
    SELECT c.*
    FROM tmpCustomer AS t
             INNER JOIN customer AS c ON t.customer_id = c.customer_id;

    /* Clean up */
    DROP TABLE tmpCustomer;
END;

