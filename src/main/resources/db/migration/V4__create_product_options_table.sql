CREATE TABLE product_options(
    id          BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    product_id  BIGINT         NOT NULL, -- FK: 어떤 상품에 속하는지
    name        VARCHAR(255)   NOT NULL, -- 옵션 이름 (예: "색상", "사이즈")
    value       VARCHAR(255)   NOT NULL, -- 옵션 값 (예: "빨강", "L")
    extra_price DECIMAL(10, 2) NOT NULL, -- 옵션 가격 (기본 상품 가격에 추가되는 금액)
    status      VARCHAR(20)    NOT NULL DEFAULT 'REGULAR',
    created_at  TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE -- 외래키 설정 및 상품이 삭제될 때 옵션도 함께 삭제
)