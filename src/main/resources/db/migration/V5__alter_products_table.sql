-- 1. NOT NULL 제약 해제
ALTER TABLE products ALTER COLUMN category_id DROP NOT NULL;

-- 2. 외래키 제약 추가
ALTER TABLE products
    ADD CONSTRAINT fk_products_category
        FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE SET NULL;