CREATE TABLE user (
  id INT(11) NOT NULL ,
  fname VARCHAR(50) NOT NULL ,
  mname VARCHAR(50) NOT NULL ,
  lname VARCHAR(50) NOT NULL ,
  email VARCHAR(150) NOT NULL ,
  password VARCHAR(150) NOT NULL ,
  phonenumber VARCHAR(150) NOT NULL ,
  createdat TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  profile_pic  VARCHAR(150) NOT NULL ,
  cv_resume  VARCHAR(150) NOT NULL ,
  PRIMARY KEY (email)
)

CREATE TABLE user_perm_address (
  id INT(11) NOT NULL ,
  city VARCHAR(50) NOT NULL ,
  state VARCHAR(50) NOT NULL ,
  pincode VARCHAR(50) NOT NULL ,
  email VARCHAR(150) NOT NULL ,
  address VARCHAR(550) NOT NULL ,
  createdat TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (email) REFERENCES user (email)
)

CREATE TABLE user_corr_address (
  id INT(11) NOT NULL ,
  city VARCHAR(50) NOT NULL ,
  state VARCHAR(50) NOT NULL ,
  pincode VARCHAR(50) NOT NULL ,
  email VARCHAR(150) NOT NULL ,
  address VARCHAR(550) NOT NULL ,
  createdat TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (email) REFERENCES user (email)
)

CREATE TABLE user_education (
  id INT(11) NOT NULL ,
  edu_name  VARCHAR(50) NOT NULL ,
  edu_degree VARCHAR(50) NOT NULL ,
  board_univ VARCHAR(50) NOT NULL ,
  passout_year INT(11) NOT NULL ,
  percentage DOUBLE(10,2) NOT NULL,
  mark_sheet VARCHAR(500) NOT NULL,
  pass_cert VARCHAR(500) NOT NULL,
  email VARCHAR(150) NOT NULL , 
  PRIMARY KEY (id),
  FOREIGN KEY (email) REFERENCES user (email)
)


ALTER TABLE user
ADD COLUMN email_otp VARCHAR(50) ,
ADD COLUMN   email_otp_expiry_time VARCHAR(50)  ,
ADD COLUMN  sms_otp VARCHAR(50)  ,
ADD COLUMN   sms_otp_expiry_time VARCHAR(50) ,
ADD COLUMN email_otp_validated INT(1) DEFAULT 0,
ADD COLUMN   sms_otp_validated INT(1)  DEFAULT 0
      ;