create database my_Game_of_life;
drop database my_Game_of_life;
use my_Game_of_life ;
DROP DATABASE Game_of_life;



CREATE TABLE SAVED_STATE
(
	GAME_ID INT,
    X_COOR INT,
    Y_COOR INT, 
	IS_ALIVE BIT,
    PRIMARY KEY(GAME_ID,X_COOR,Y_COOR,IS_ALIVE),
    FOREIGN KEY (GAME_ID) REFERENCES GAME_DETAILS(GAME_ID)
);

INSERT INTO SAVED_STATE VALUES (20,30,30,3,9,1);
INSERT INTO SAVED_STATE VALUES (23,30,30,3,9,1);
INSERT INTO SAVED_STATE VALUES (22,30,30,3,9,1);
INSERT INTO SAVED_STATE VALUES (21,30,30,3,9,1);
INSERT INTO SAVED_STATE VALUES (25,30,30,3,9,1);

SELECT* FROM SAVED_STATE;
DROP TABLE SAVED_STATE;

CREATE TABLE GAME_DETAILS
(
	GAME_ID INT,
	SPEED INT, 
	ZOOM INT, 
	BOARD_ROWS INT, 
    BOARD_COLS INT,
    PRIMARY KEY(GAME_ID)
);


INSERT INTO GAME_DETAILS VALUES (1,"AHMAD",20,30,30,30);
SELECT * FROM GAME_DETAILS;


#Procedure to Load SavedState
DELIMITER %%
CREATE PROCEDURE LOAD_SAVED_STATE
(
	GAME_ID INT
)
BEGIN
	SELECT *
    FROM SAVED_STATE
    WHERE SAVED_STATE.GAME_ID= GAME_ID;
END %% 
DELIMITER ;






SELECT *FROM GAME_DETAILS;

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
	INSERT INTO GAME_RECORD VALUES(GAME_ID, SPEED,ZOOM, BOARD_ROWS, BOARD_COLS);
END %%

DELIMITER %%
#Procedure to insert a new data into game record details and save it
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
SELECT * FROM SAVED_STATE;
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
	STATE_ID_ INT
 )
 BEGIN
	DELETE
    FROM SAVED_STATE
    WHERE SAVED_STATE.STATE_ID=STATE_ID_;
 END %%
 
 DROP PROCEDURE DELETE_SAVED_STATE;
 DELIMITER ;






