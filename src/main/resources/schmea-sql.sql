-- Table: public."user"

-- DROP TABLE public."user";

CREATE TABLE public."user"
(
    "user_id" serial NOT NULL UNIQUE,
    "user_name" character varying(255) COLLATE pg_catalog."default",
    "user_email" character varying(100) COLLATE pg_catalog."default",
    "password" character varying(100) COLLATE pg_catalog."default",
    insd_time timestamp with time zone DEFAULT now(),
    upd_time timestamp with time zone DEFAULT now(),
    active_flag boolean DEFAULT true,
    CONSTRAINT user_pkey PRIMARY KEY ("user_id")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."user"
    OWNER to postgres;
    
-- Table: public.cart

-- DROP TABLE public.cart;

CREATE TABLE public.cart
(
    "cart_id" serial NOT NULL UNIQUE,
    "user_id" bigint NOT NULL,
    "product_id" bigint NOT NULL,
    "product_qty" bigint DEFAULT 1,
    "product_price" double precision,
    "insd_time" timestamp with time zone DEFAULT now(),
    "upd_time" timestamp with time zone DEFAULT now(),
    "active_flag" boolean DEFAULT true,
    CONSTRAINT cart_pkey PRIMARY KEY ("cart_id")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.cart
    OWNER to postgres;
    
    -- Table: public.product

-- DROP TABLE public.product;

CREATE TABLE public.product
(
    "product_id" serial NOT NULL UNIQUE,
    "product_name" character varying(255) COLLATE pg_catalog."default",
    "product_price" double precision,
    "active_flag" boolean DEFAULT true,
    CONSTRAINT product_pkey PRIMARY KEY ("product_id")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.product
    OWNER to postgres;

-- Table: public.book

-- DROP TABLE public.book;

CREATE TABLE public.book
(
    "product_id" serial NOT NULL UNIQUE,
    genre character varying(100) COLLATE pg_catalog."default",
    author character varying(255) COLLATE pg_catalog."default",
    publications character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT product_book FOREIGN KEY ("product_id")
        REFERENCES public.product ("product_id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.book
    OWNER to postgres;
    
    -- Table: public.apparal

-- DROP TABLE public.apparal;

CREATE TABLE public.apparal
(
    "product_id" serial NOT NULL UNIQUE,
    type character varying(50) COLLATE pg_catalog."default",
    brand character varying(50) COLLATE pg_catalog."default",
    design character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT product_app_id FOREIGN KEY ("product_id")
        REFERENCES public.product ("product_id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.apparal
    OWNER to postgres;