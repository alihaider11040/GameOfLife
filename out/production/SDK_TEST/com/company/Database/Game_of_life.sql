drop database my_Game_of_life;
create database my_Game_of_life;
use my_Game_of_life ;

CREATE TABLE GAME_DETAILS
(
	GAME_ID INT AUTO_INCREMENT,
	SPEED INT,
	ZOOM INT,
	BOARD_ROWS INT,
    BOARD_COLS INT,
    PRIMARY KEY(GAME_ID)
);
CREATE TABLE SAVED_STATE
(
	GAME_ID INT AUTO_INCREMENT,
    X_COOR INT,
    Y_COOR INT,
	IS_ALIVE BIT,
    PRIMARY KEY(GAME_ID,X_COOR,Y_COOR,IS_ALIVE),
    FOREIGN KEY (GAME_ID) REFERENCES GAME_DETAILS(GAME_ID)
);
#create procedure to view all saved states
DELIMITER %%
CREATE PROCEDURE LOAD_ALL_SAVED_STATES
(

)
BEGIN
	SELECT *
    FROM SAVED_STATE
    GROUP BY GAME_ID;
END %%

#Procedure to Load SavedState
DELIMITER %%
CREATE PROCEDURE LOAD_SAVED_STATE
(
	IN GAME_ID INT
)
BEGIN
	SELECT *
    FROM SAVED_STATE
    WHERE SAVED_STATE.GAME_ID= GAME_ID;
END %%
DELIMITER ;

#Procedure to Load Game Details
DELIMITER %%
CREATE PROCEDURE GET_GAME_DETAILS
(
	GAME_ID INT
)
BEGIN
	SELECT *
	FROM GAME_DETAILS
	WHERE GAME_DETAILS.GAME_ID=GAME_ID;
END %%

DELIMITER ;

 #Procedure to Insert a new data into game details and save it
 DELIMITER %%
CREATE PROCEDURE SAVE_INTO_GAME_DETAILS
(
	GAME_ID INT,
	SPEED INT,
	ZOOM INT,
	BOARD_ROWS INT,
    BOARD_COLS INT
)
BEGIN
	INSERT INTO GAME_DETAILS VALUES(GAME_ID, SPEED,ZOOM, BOARD_ROWS, BOARD_COLS);
END %%

DROP PROCEDURE SAVE_INTO_GAME_DETAILS;

#Procedure to insert a new data into game record details and save it
DELIMITER %%
CREATE PROCEDURE SAVED_STATE_VALUES
(
	GAME_ID INT ,
    X_COOR INT,
    Y_COOR INT,
	IS_ALIVE BIT
)
BEGIN
	INSERT INTO SAVED_STATE
	VALUES(GAME_ID,X_COOR,Y_COOR,IS_ALIVE);
END %%

DROP PROCEDURE SAVED_STATE_VALUES;
CALL SAVED_STATE_VALUES (1,30,30,15,15,1);
TRUNCATE TABLE SAVED_STATE;

 DELIMITER %%
 #PROCEDURE TO DELETE GAME DETAILS
 CREATE PROCEDURE DELETE_GAME_DETAILS
 (
	USER_ID_ INT
 )
 BEGIN
	DELETE FROM GAME_DETAILS WHERE USER_ID=USER_ID_;
 END %%

 DELIMITER ;

 DELIMITER %%
 CREATE PROCEDURE DELETE_SAVED_STATE
 (
	GAME_ID_ INT
 )
 BEGIN
	DELETE
    FROM SAVED_STATE
    WHERE SAVED_STATE.GAME_ID=GAME_ID_;
 END %%
 DROP PROCEDURE DELETE_SAVED_STATE;
 DELIMITER ;

 insert into GAME_DETAILS values (90,20,20,5,5);
  insert into GAME_DETAILS values (10,20,20,5,5);

select *from GAME_DETAILS;
SELECT* FROM SAVED_STATE;