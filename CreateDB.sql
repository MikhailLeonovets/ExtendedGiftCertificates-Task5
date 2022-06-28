CREATE DATABASE gift_certificates_task5;
CREATE SCHEMA gift_certificates_task5;
CREATE TABLE "gift_certificates_task5".gift_certificate
(
    id                   SERIAL PRIMARY KEY,
    name                 VARCHAR(255) NOT NULL UNIQUE,
    description          TEXT         NOT NULL,
    price                NUMERIC(8)   NOT NULL,
    date_of_creation     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    date_of_modification TIMESTAMP,
    duration             INTERVAL
);

CREATE TABLE "gift_certificates_task5".tag
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE "gift_certificates_task5".gift_certificate_tag
(
    id                  SERIAL PRIMARY KEY,
    gift_certificate_id BIGINT NOT NULL,
    tag_id              BIGINT NOT NULL,
    CONSTRAINT fk_gift_certificate_id FOREIGN KEY (gift_certificate_id) REFERENCES "gift_certificates_task5".gift_certificate (id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_tag_id FOREIGN KEY (tag_id) REFERENCES "gift_certificates_task5".tag (id) ON UPDATE CASCADE ON DELETE CASCADE
)