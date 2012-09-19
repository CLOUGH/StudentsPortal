# Initialize all the database tabels
CREATE TABLE course
(
        id INT NOT NULL AUTO_INCREMENT,
        course_name VARCHAR(30) NOT NULL,
        course_type VARCHAR(30) NOT NULL,
        course_name VARCHAR(30) NOT,
        course_code INT NOT NULL,
        crn INT NOT NULL AUTO_INCREMENT,
        lecture_id INT NOT NULL,
        capacity INT,
                            
        UNIQUE(crn),
		PRIMARY KEY (id)
);

#schedule is related to a course by the course_id
CREATE TABLE schedule
(		
		id INT NOT NULL AUTO_INCREMENT,
		course_id NOT NULL,
		day VARCHAR(20),
		time TIME NOT NULL,
		room VARCHAR(30) NOT NULL,
		
		PRIMARY KEY (id)
);

 CREATE TABLE prerequisite
 (		
 		id INT NOT NULL AUTO_INCREMENT,
 		course_name VARCHAR(30) NOT NULL,		
 		grade VARCHAR(10) NOT NULL,
 		
 		PRIMARY KEY(id)
 );
 
 #prerequisite_map is a mapping table that relates multiple prerequisites to a course 
 #by the course_id 
 CREATE TABLE prerequisite_map
 (
 		id INT NOT NULL AUTO_INCREMENT,
 		course_id NOT NULL,
 		prerequisite_id NOT NULL,
 		
 		PRIMARY KEY(id)
 );