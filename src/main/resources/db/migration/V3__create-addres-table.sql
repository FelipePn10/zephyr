CREATE TABLE address (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY ,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(30) NOT NULL,
    zip VARCHAR(15) NOT NULL,
    country VARCHAR(90) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(255) NOT NULL,

    event_id UUID,
    FOREIGN KEY (event_id) REFERENCES event(id) ON DELETE  CASCADE
)