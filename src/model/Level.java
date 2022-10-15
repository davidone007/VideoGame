package model;

import java.util.Arrays;

public class Level {

    /**
     * The size of the max players in a level
     */
    public static final int SIZE_OF_PLAYERS_LEVELS = 20;

    /**
     * The size of the max treasures in a level
     */
    public static final int SIZE_OF_TREASURES_LEVELS = 50;

    /**
     * The size of the max enemies in a level
     */
    public static final int SIZE_OF_ENEMIES_LEVELS = 25;

    private int idNum;
    private int pointToNextLevel;
    private DificultyLevel dificulty;
    private Player[] playersLevel;
    private Treasure[] treasuresLevel;
    private Enemy[] enemiesLevel;

    /**
     * Level: Constructor of Level class
     * 
     * @param idNum            int: Represent the id of the level
     * @param pointToNextLevel int: Represent the points for pass to the next level
     */
    public Level(int idNum, int pointToNextLevel) {
        this.idNum = idNum;
        this.pointToNextLevel = pointToNextLevel;
        enemiesLevel = new Enemy[SIZE_OF_ENEMIES_LEVELS];
        treasuresLevel = new Treasure[SIZE_OF_TREASURES_LEVELS];
        playersLevel = new Player[SIZE_OF_PLAYERS_LEVELS];
    }

    /**
     * listPositionTreasuresLevel: This method list the positions of all the
     * treasures of the level
     * 
     * @return msj - String: The positions of the treasures
     */
    public String listPositionTreasuresLevel() {
        boolean isEmpty = false;
        String msj = "";
        for (int i = 0; i < SIZE_OF_TREASURES_LEVELS && !isEmpty; i++) {
            if (treasuresLevel[i] != null) {
                msj += "Tesoro #" + (i + 1) + " del nivel" + "\n" +
                    "Nombre: " +treasuresLevel[i].getNameT() + "\n" +
                        treasuresLevel[i].toStringPosition();
            }
        }
        return msj;

    }

    /**
     * hasEmptyPosPlayer: This method is used to find out if there is an empty
     * position in the Player array of a level
     * 
     * @return isEmpty - boolean: If true, it indicates that there is an empty
     *         position
     */
    public boolean hasEmptyPosPlayer() {
        boolean isEmpty = false;
        for (int i = 0; i < SIZE_OF_PLAYERS_LEVELS && !isEmpty; i++) {
            if (playersLevel[i] == null) {
                isEmpty = true;
            }
        }
        return isEmpty;
    }

    /**
     * listEnemies: This method list the names of all the
     * enemies of the level
     * 
     * @return msj - String: The names of the enemies
     */
    public String listEnemies() {
        String msj = "";
        int sizeNames = 0;
        String[] listNames = new String[SIZE_OF_ENEMIES_LEVELS];
        for (int i = 0; i < SIZE_OF_ENEMIES_LEVELS; i++) {
            if (enemiesLevel[i] != null) {
                sizeNames++;
                listNames[i] = enemiesLevel[i].getNameE();

            }
        }

        String[] listNamesWithoutNull = new String[sizeNames];

        for (int i = 0; i < sizeNames; i++) {
            if (listNames[i] != null) {
                listNamesWithoutNull[i] = listNames[i];

            }
        }

        msj = Arrays.toString(listNamesWithoutNull);

        return msj;
    }

    /**
     * listTreasures: This method list the names of all the
     * treasures of the level
     * 
     * @return msj - String: The names of the treasures
     */
    public String listTreasures() {
        String msj = "";
        int sizeNames = 0;
        String[] listNames = new String[SIZE_OF_TREASURES_LEVELS];
        for (int i = 0; i < SIZE_OF_TREASURES_LEVELS; i++) {
            if (treasuresLevel[i] != null) {
                sizeNames++;
                listNames[i] = treasuresLevel[i].getNameT();

            }
        }

        String[] listNamesWithoutNull = new String[sizeNames];

        for (int i = 0; i < sizeNames; i++) {
            if (listNames[i] != null) {
                listNamesWithoutNull[i] = listNames[i];

            }
        }

        msj = Arrays.toString(listNamesWithoutNull);

        return msj;
    }

    /**
     * addPlayerWithObject: This method adds a object type Player to an empty
     * position in the player array that has the level
     * 
     * @param newPlayer Player: Represents the object type Player to add
     * @return msj - String: A confirmation message
     */
    public String addPlayerWithObject(Player newPlayer) {

        String msj = "Capacidad maxima alcanzada, no se pueden agregar mas jugadores";
        boolean isEmpty = false;
        for (int i = 0; i < SIZE_OF_PLAYERS_LEVELS && !isEmpty; i++) {
            if (playersLevel[i] == null) {
                playersLevel[i] = newPlayer;
                isEmpty = true;
                msj = "Nuevo jugador agregado";
            }
        }

        return msj;
    }

    /**
     * addEnemyWithObject: This method adds a object type Enemy to an empty
     * position in the enemy array that has the level
     * 
     * @param newEnemy Enemy: Represents the object type Enemy to add
     * @return msj - String: A confirmation message
     */
    public String addEnemyWithObject(Enemy newEnemy) {
        String msj = "Capacidad maxima alcanzada, no se pueden agregar mas enemigos";
        boolean isEmpty = false;
        for (int i = 0; i < SIZE_OF_ENEMIES_LEVELS && !isEmpty; i++) {
            if (enemiesLevel[i] == null) {
                enemiesLevel[i] = newEnemy;
                isEmpty = true;
                msj = "Nuevo enemigo agregado";
            }
        }

        return msj;
    }

    /**
     * searchEnemyByNameLevel: This method search a enemy from the enemy array of
     * the level
     * 
     * @param nameE String - Represents the name of the enemy to search
     * @return int: pos - The position of the enemy in the array of enemy of
     *         the level
     */
    public int searchEnemyByNameLevel(String nameE) {
        int pos = -1;
        boolean isFound = false;
        for (int i = 0; i < SIZE_OF_ENEMIES_LEVELS && !isFound; i++) {
            if (enemiesLevel[i] != null) {
                if (enemiesLevel[i].getNameE().equals(nameE)) {
                    pos = i;
                    isFound = true;
                }
            }
        }

        return pos;
    }

    /**
     * searchPlayerByNicknameLevel: This method search a player from the player
     * array of the level
     *
     * @param nickname String - Represents the nickname of the player to search
     * @return int: pos - The position of the player in the array of player of
     *         the level
     */
    public int searchPlayerByNicknameLevel(String nickname) {
        int pos = -1;
        boolean isFound = false;
        for (int i = 0; i < SIZE_OF_PLAYERS_LEVELS && !isFound; i++) {
            if (playersLevel[i] != null) {
                if (playersLevel[i].getNickname().equals(nickname)) {
                    pos = i;
                    isFound = true;
                }
            }
        }

        return pos;
    }

    /**
     * addTreasureWithObject: This method adds a object Type Treasure to an empty
     * position in the treasure array that has the level
     * 
     * @param newTreasure Treasure: Represents the object type Treasure to add
     * @return msj - String: A confirmation message
     */
    public String addTreasureWithObject(Treasure newTreasure) {

        String msj = "Capacidad maxima alcanzada, no se pueden agregar mas tesoros";
        boolean isEmpty = false;
        for (int i = 0; i < SIZE_OF_TREASURES_LEVELS && !isEmpty; i++) {
            if (treasuresLevel[i] == null) {
                treasuresLevel[i] = newTreasure;
                isEmpty = true;
                msj = "Nuevo tesoro agregado";
            }
        }

        return msj;
    }

    /**
     * calculateDificultyLevel: This method calculates the difficulty of a level,
     * based on the points it has for enemies and treasures
     * 
     * @return msj - String: The message that shows how difficult the level is
     */
    public String calculateDificultyLevel() {
        int totalPointsTreasures = 0;
        int totalPointsEnemies = 0;
        for (int i = 0; i < SIZE_OF_ENEMIES_LEVELS; i++) {
            if (enemiesLevel[i] != null) {
                totalPointsEnemies += enemiesLevel[i].getPointsE();
            }

        }

        for (int i = 0; i < SIZE_OF_TREASURES_LEVELS; i++) {
            if (treasuresLevel[i] != null) {
                totalPointsTreasures += treasuresLevel[i].getPointsT();
            }

        }

        if (totalPointsTreasures > totalPointsEnemies) {
            setDificulty(DificultyLevel.BAJO);
        } else if (totalPointsEnemies == totalPointsTreasures) {
            setDificulty(DificultyLevel.MEDIO);

        } else {
            setDificulty(DificultyLevel.ALTO);
        }

        String msj = "La dificultad del nivel es: " + getDificulty();

        return msj;

    }

    /**
     * @param dificulty the dificulty to set
     */
    public void setDificulty(DificultyLevel dificulty) {
        this.dificulty = dificulty;
    }

    /**
     * @return int return the idNum
     */
    public int getIdNum() {
        return idNum;
    }

    /**
     * @param idNum the idNum to set
     */
    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    /**
     * @return int return the pointToNextLevel
     */
    public int getPointToNextLevel() {
        return pointToNextLevel;
    }

    /**
     * @param pointToNextLevel the pointToNextLevel to set
     */
    public void setPointToNextLevel(int pointToNextLevel) {
        this.pointToNextLevel = pointToNextLevel;
    }

    /**
     * @return Player[] return the playersLevel
     */
    public Player[] getPlayersLevel() {
        return playersLevel;
    }

    /**
     * @param playersLevel the playersLevel to set
     */
    public void setPlayersLevel(Player[] playersLevel) {
        this.playersLevel = playersLevel;
    }

    /**
     * @return Treasure[] return the treasuresLevel
     */
    public Treasure[] getTreasuresLevel() {
        return treasuresLevel;
    }

    /**
     * @param treasuresLevel the treasuresLevel to set
     */
    public void setTreasuresLevel(Treasure[] treasuresLevel) {
        this.treasuresLevel = treasuresLevel;
    }

    /**
     * @return Enemy[] return the enemiesLevel
     */
    public Enemy[] getEnemiesLevel() {
        return enemiesLevel;
    }

    /**
     * @param enemiesLevel the enemiesLevel to set
     */
    public void setEnemiesLevel(Enemy[] enemiesLevel) {
        this.enemiesLevel = enemiesLevel;
    }

    /**
     * @return DificultyLevel return the dificulty
     */
    public DificultyLevel getDificulty() {
        return dificulty;
    }

}
