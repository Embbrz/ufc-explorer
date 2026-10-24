CREATE TABLE fighters (
	id BIGSERIAL PRIMARY KEY,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	nickname VARCHAR(50),
	weight_class VARCHAR(60) NOT NULL,
	wins INT DEFAULT 0,
	losses INT DEFAULT 0,
	draws INT DEFAULT 0,
	striking_accuracy DECIMAL(5,2),
	reach_inches DECIMAL(5,2)
);

CREATE TABLE events (
	id BIGSERIAL PRIMARY KEY,
	event_name VARCHAR(50) NOT NULL,
	event_date DATE NOT NULL,
	location VARCHAR(100)
);

CREATE TABLE bouts (
	id BIGSERIAL PRIMARY KEY,
	event_id BIGINT REFERENCES events(id) ON DELETE CASCADE,
	fighter_a_id BIGINT REFERENCES fighters(id) ON DELETE CASCADE,
	fighter_b_id BIGINT REFERENCES fighters(id) ON DELETE CASCADE,
	weight_class VARCHAR(30) NOT NULL,
	is_title_fight BOOLEAN DEFAULT FALSE,
	winner_id BIGINT REFERENCES fighters(id) ON DELETE SET NULL,
	method_of_victory VARCHAR(50)
);