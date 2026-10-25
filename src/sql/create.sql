CREATE TABLE IF NOT EXISTS client_account (
    id BIGINT,
    full_name TEXT,
    gender VARCHAR(1),
    status VARCHAR(20),
    create_dttm TIMESTAMPTZ,
    modify_dttm TIMESTAMPTZ
);

ALTER TABLE client_account
    ADD CONSTRAINT pk_client_account PRIMARY KEY (id);

ALTER TABLE client_account
    ALTER COLUMN full_name SET NOT NULL,
    ALTER COLUMN create_dttm SET NOT NULL,
    ALTER COLUMN modify_dttm SET NOT NULL;