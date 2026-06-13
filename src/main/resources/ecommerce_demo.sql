-- SQL helper for adjusting promotions.status column to accept new enum values
-- Backup existing promotions table (optional but recommended):
-- CREATE TABLE promotions_backup AS SELECT * FROM promotions;

-- Option A: Change the column to VARCHAR to avoid ENUM truncation issues
ALTER TABLE promotions
	MODIFY COLUMN status VARCHAR(20) NOT NULL;

-- Option B: If you prefer ENUM, include the new value explicitly:
-- ALTER TABLE promotions
--   MODIFY COLUMN status ENUM('ACTIVE','EXPIRED','SCHEDULED') NOT NULL;

-- Run one of the statements above against the ecommerce_demo database.

