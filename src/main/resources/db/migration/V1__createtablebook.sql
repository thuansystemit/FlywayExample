create table book (
  id BIGINT(20)  NOT NULL AUTO_INCREMENT,
  name  VARCHAR(255) NOT NULL,
  type VARCHAR(50) NOT NULL,
  CONSTRAINT pk_book PRIMARY KEY (id)
);