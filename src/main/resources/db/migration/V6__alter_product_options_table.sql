-- 1. NOT NULL 제약 해제
ALTER TABLE product_options ALTER COLUMN status SET DEFAULT 'STOP_SALE';
