-- Create hatshop tables

-- Create department table
CREATE TABLE department
(
  id SERIAL        NOT NULL,
  name          VARCHAR(50)   NOT NULL,
  description   VARCHAR(1000),
  CONSTRAINT pk_department_id PRIMARY KEY (id)
);

-- Create category table
CREATE TABLE category
(
  id   SERIAL        NOT NULL,
  department_id INTEGER       NOT NULL,
  name          VARCHAR(50)   NOT NULL,
  description   VARCHAR(1000),
  CONSTRAINT pk_category_id   PRIMARY KEY (id),
  CONSTRAINT fk_category_to_department_id FOREIGN KEY (department_id)
             REFERENCES department (id)
             ON UPDATE RESTRICT ON DELETE RESTRICT
);

-- Create product table
CREATE TABLE product
(
  id       SERIAL         NOT NULL,
  name             VARCHAR(50)    NOT NULL,
  description      VARCHAR(1000)  NOT NULL,
  price            NUMERIC(10, 2) NOT NULL,
  discounted_price NUMERIC(10, 2) NOT NULL DEFAULT 0.00,
  image            VARCHAR(150),
  thumbnail        VARCHAR(150),
  display          SMALLINT       NOT NULL DEFAULT 0,
  search_vector    VARCHAR(1000),
  CONSTRAINT pk_product PRIMARY KEY (id)
);

-- Create product_category table
CREATE TABLE product_category
(
  product_id  INTEGER NOT NULL,
  category_id INTEGER NOT NULL,
  CONSTRAINT pk_product_to_category_id PRIMARY KEY (product_id, category_id),
  CONSTRAINT fk_product_category_to_product_id             FOREIGN KEY (product_id)
             REFERENCES product (id)
             ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_category_id            FOREIGN KEY (category_id)
             REFERENCES category (id)
             ON UPDATE RESTRICT ON DELETE RESTRICT
);

-- Create shopping_cart table
CREATE TABLE shopping_cart
(
  id     CHAR(32)  NOT NULL,
  product_id  INTEGER   NOT NULL,
  quantity    INTEGER   NOT NULL,
  buy_now     BOOLEAN   NOT NULL DEFAULT true,
  added_on    TIMESTAMP NOT NULL,
  CONSTRAINT pk_cart_id_product_id PRIMARY KEY (id, product_id),
  CONSTRAINT fk_cart_to_product_id         FOREIGN KEY (product_id)
             REFERENCES product (id)
             ON UPDATE RESTRICT ON DELETE RESTRICT
);

-- Create shipping_region table
CREATE TABLE shipping_region
(
  id SERIAL       NOT NULL,
  shipping_region    VARCHAR(100) NOT NULL,
  CONSTRAINT pk_shipping_region_id PRIMARY KEY (id)
);

-- Create shipping table
CREATE TABLE shipping
(
  id        SERIAL         NOT NULL,
  shipping_type      VARCHAR(100)   NOT NULL,
  shipping_cost      NUMERIC(10, 2) NOT NULL,
  shipping_region_id INTEGER        NOT NULL,
  CONSTRAINT pk_shipping_id        PRIMARY KEY (id),
  CONSTRAINT fk_shipping_to_shipping_region_id FOREIGN KEY (shipping_region_id)
             REFERENCES shipping_region (id)
             ON UPDATE RESTRICT ON DELETE RESTRICT
);

-- Create tax table
CREATE TABLE tax
(
  id         SERIAL         NOT NULL,
  tax_type       VARCHAR(100)   NOT NULL,
  tax_percentage NUMERIC(10, 2) NOT NULL,
  CONSTRAINT pk_tax_id PRIMARY KEY (id)
);

-- Create customer table
CREATE TABLE customer
(
  id        SERIAL        NOT NULL,
  name               VARCHAR(50)   NOT NULL,
  email              VARCHAR(100)  NOT NULL,
  password           VARCHAR(50)   NOT NULL,
  credit_card        TEXT,
  address_1          VARCHAR(100),
  address_2          VARCHAR(100),
  city               VARCHAR(100),
  region             VARCHAR(100),
  postal_code        VARCHAR(100),
  country            VARCHAR(100),
  shipping_region_id INTEGER       NOT NULL  DEFAULT 1,
  day_phone          VARCHAR(100),
  eve_phone          VARCHAR(100),
  mob_phone          VARCHAR(100),
  CONSTRAINT pk_customer_id        PRIMARY KEY (id),
  CONSTRAINT fk_customer_to_shipping_region_id FOREIGN KEY (shipping_region_id)
             REFERENCES shipping_region (id)
             ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT uk_email              UNIQUE (email)
);

-- Create orders table
CREATE TABLE e_order
(
  id         SERIAL        NOT NULL,
  total_amount     NUMERIC(10,2) NOT NULL DEFAULT 0.00,
  created_on       TIMESTAMP     NOT NULL,
  shipped_on       TIMESTAMP,
  status           INTEGER       NOT NULL DEFAULT 0,
  comments         VARCHAR(255),
  customer_id      INTEGER,
  auth_code        VARCHAR(50),
  reference        VARCHAR(50),
  shipping_id      INTEGER,
  tax_id           INTEGER,
  CONSTRAINT pk_order_id PRIMARY KEY (id),
  CONSTRAINT fk_orders_to_customer_id FOREIGN KEY (customer_id)
             REFERENCES customer (id)
             ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_orders_to_shipping_id FOREIGN KEY (shipping_id)
             REFERENCES shipping (id)
             ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_orders_to_tax_id FOREIGN KEY (tax_id)
             REFERENCES tax (id)
             ON UPDATE RESTRICT ON DELETE RESTRICT
);

-- Create order_detail table
CREATE TABLE order_detail
(
  order_id     INTEGER        NOT NULL,
  product_id   INTEGER        NOT NULL,
  product_name VARCHAR(50)    NOT NULL,
  quantity     INTEGER        NOT NULL,
  unit_cost    NUMERIC(10, 2) NOT NULL,
  CONSTRAINT pk_order_id_product_id PRIMARY KEY (order_id, product_id),
  CONSTRAINT fk_order_id            FOREIGN KEY (order_id)
             REFERENCES e_order (id)
             ON UPDATE RESTRICT ON DELETE RESTRICT
);

-- Create audit table
CREATE TABLE audit
(
  id       SERIAL    NOT NULL,
  order_id       INTEGER   NOT NULL,
  created_on     TIMESTAMP NOT NULL,
  message        TEXT      NOT NULL,
  message_number INTEGER   NOT NULL,
  CONSTRAINT pk_audit_id PRIMARY KEY (id),
  CONSTRAINT fk_audit_to_order_id FOREIGN KEY (order_id)
             REFERENCES e_order (id)
             ON UPDATE RESTRICT ON DELETE RESTRICT
);

-- Create review table
CREATE TABLE review
(
  id   SERIAL    NOT NULL,
  customer_id INTEGER   NOT NULL,
  product_id  INTEGER   NOT NULL,
  review      TEXT      NOT NULL,
  rating      SMALLINT  NOT NULL,
  created_on  TIMESTAMP NOT NULL,
  CONSTRAINT pk_review_id PRIMARY KEY (id),
  CONSTRAINT fk_review_to_customer_id FOREIGN KEY (customer_id)
             REFERENCES customer (id)
             ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_review_to_product_id FOREIGN KEY (product_id)
             REFERENCES product (id)
             ON UPDATE RESTRICT ON DELETE RESTRICT
);
