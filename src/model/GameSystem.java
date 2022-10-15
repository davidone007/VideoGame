package model;

import java.util.concurrent.ThreadLocalRandom;

public class GameSystem {

	/**
	 * The size of the array of levels in the game
	 */
	public static final int GAME_LEVELS_SIZE = 10;

	/**
	 * The size of the max players in the game
	 */
	public static final int SIZE_OF_PLAYERS_GAME = 20;

	/**
	 * The size of the max treasures in the game
	 */
	public static final int SIZE_OF_TREASURES_GAME = 50;

	/**
	 * The size of the max enemies in the game
	 */
	public static final int SIZE_OF_ENEMIES_GAME = 25;

	/**
	 * The resolution x of the game
	 */
	public static final int GAME_RESOLUTION_X = 1280;

	/**
	 * The resolution y of the game
	 */
	public static final int GAME_RESOLUTION_Y = 720;

	/**
	 * The size of the top of players
	 */
	public static final int TOP = 5;

	private String gameName;
	private Player[] playersGame;
	private Treasure[] treasuresGame;
	private Enemy[] enemiesGame;
	private Level[] levelsGame;
	private int gameResolutionX = GAME_RESOLUTION_X;
	private int gameResolutionY = GAME_RESOLUTION_Y;

	/**
	 * GameSystem: Constructor of GameSystem Class
	 */
	public GameSystem() {
		enemiesGame = new Enemy[SIZE_OF_ENEMIES_GAME];
		treasuresGame = new Treasure[SIZE_OF_TREASURES_GAME];
		playersGame = new Player[SIZE_OF_PLAYERS_GAME];
		levelsGame = new Level[GAME_LEVELS_SIZE];
		levelsGame[0] = new Level(1, 10);
		levelsGame[1] = new Level(2, 20);
		levelsGame[2] = new Level(3, 30);
		levelsGame[3] = new Level(4, 40);
		levelsGame[4] = new Level(5, 50);
		levelsGame[5] = new Level(6, 60);
		levelsGame[6] = new Level(7, 70);
		levelsGame[7] = new Level(8, 80);
		levelsGame[8] = new Level(9, 90);
		levelsGame[9] = new Level(10, 100);

	}

	/**
	 * generateRandomNumberOfARange: This method calculates a random integer between
	 * two values.
	 * 
	 * @param minValue int: The minimum value of the range to calculate the number
	 * @param maxValue int: The max value of the range to calculate the number
	 * 
	 * @return random - int: The generate random number
	 */
	public int generateRandomNumberOfARange(int minValue, int maxValue) {
		ThreadLocalRandom tlr = ThreadLocalRandom.current();
		int random = tlr.nextInt(minValue, maxValue + 1);
		return random;
	}

	/**
	 * initGame: This method creates players, enemies and treasures in the levels
	 * (initializes the levels)
	 */
	public void initGame() {
		initEnemies();
		initPlayers();
		initTreasures();
	}

	/**
	 * initPlayers: This method creates players in the game
	 */
	public void initPlayers() {
		for (int i = 0; i < (SIZE_OF_PLAYERS_GAME - 5); i++) {
			String nicknamePlayer = "Nickname" + i;
			String namePlayer = "Jugador" + i;
			addPlayerToGameSystem(nicknamePlayer, namePlayer);
			calculatePlayerLevel(nicknamePlayer, nicknamePlayer);
		}

	}

	/**
	 * initTreasures: This method creates players in the game
	 */
	public void initTreasures() {
		for (int i = 0; i < (SIZE_OF_TREASURES_GAME - 5); i++) {
			String nameTreasure = "Tesoro" + i;
			String imageTreasure = "www.url" + i + ".com";
			int pointsTreasure = generateRandomNumberOfARange(1, 1000);
			int amountTreasure = 1;
			int idNum = generateRandomNumberOfARange(1, 10);
			addTreasureToGameSystem(nameTreasure, imageTreasure, pointsTreasure, amountTreasure, idNum);
		}

	}

	/**
	 * initEnemies: This method creates enemies in the game
	 */
	public void initEnemies() {
		for (int i = 0; i < (SIZE_OF_ENEMIES_GAME - 5); i++) {
			String nameEnemy = "Enemigo" + i;
			int typeEnemy = generateRandomNumberOfARange(0, 3);
			int damagePoints = generateRandomNumberOfARange(1, 1000);
			int pointsEnemy = generateRandomNumberOfARange(1, 1000);
			int idNum = generateRandomNumberOfARange(1, 10);
			addEnemyToGameSystem(nameEnemy, typeEnemy, damagePoints, pointsEnemy, idNum);
		}

	}

	/**
	 * comparisonPoints: TThis method gets the largest number of an array
	 * 
	 * @param arrayPoints: The player point arrangement
	 * @return higher - int[]: The major points
	 */
	public int[] comparisonPoints(int[] arrayPoints) {

		int higher[] = new int[2];

		for (int i = 0; i < SIZE_OF_PLAYERS_GAME; i++) {

			if (arrayPoints[i] > higher[0]) {
				higher[0] = arrayPoints[i];
				higher[1] = i;
			}

		}

		return higher;

	}

	/**
	 * getTop5Players: This method creates the top 5 array of points
	 * 
	 * @return ordenedPoints - int[]: The arrangement where the top 5 players by
	 *         points are
	 */
	public int[] getTop5Players() {

		int[] arrayPointsPlayer = getArrayScorePlayers();

		int[] ordenedPoints = new int[TOP];

		for (int i = 0; i < TOP; i++) {

			int[] result = comparisonPoints(arrayPointsPlayer);
			ordenedPoints[i] = result[0];
			arrayPointsPlayer[result[1]] = -1;

		}

		return ordenedPoints;

	}

	/**
	 * showTop5: This method creates a String where it shows the top 5 players
	 * 
	 * @return msj + msj1 - String: Shows the top 5 players with their name
	 */
	public String showTop5() {

		String msj = "";
		String msj1 = "";
		int[] orderedArray = getTop5Players();


		for (int i = 0; i < orderedArray.length; i++) {
			msj += "Jugador top " + (i + 1) + " PUNTOS: " + orderedArray[i] + "\n";

		}

		for (int i = 0; i < orderedArray.length; i++) {
			msj1 += showNicknameTopPlayer(i);
		}

		return msj + msj1;

	}

	/**
	 * showNicknameTopPlayer: Search the name of a player using the points
	 * 
	 * @param posTop int: The position of the top
	 * @return msj - String: A message with the name of the player
	 */
	public String showNicknameTopPlayer(int posTop) {
		String msj = "";
		int[] orderedArray = getTop5Players();
		boolean isFound = false;
		for (int i = 0; i < SIZE_OF_PLAYERS_GAME && !isFound; i++) {
			if (playersGame[i] != null) {
				if (orderedArray[posTop] == playersGame[i].getPoints()) {
					msj = "Nickname del jugador top " + (posTop + 1) + ": " + playersGame[i].getNickname() + "\n";
					isFound = true;
				}
			}
		}

		return msj;
	}

	/**
	 * getArrayScorePlayers: Create an array with each player's points
	 * 
	 * @return scorePlayers - int[]: It is the arrangement with the points of the
	 *         players
	 */
	public int[] getArrayScorePlayers() {
		int[] scorePlayers = new int[SIZE_OF_PLAYERS_GAME];
		for (int i = 0; i < SIZE_OF_PLAYERS_GAME; i++) {
			if (playersGame[i] != null) {
				scorePlayers[i] = playersGame[i].getPoints();

			}

		}

		return scorePlayers;
	}

	/**
	 * countConsonantsGameSystem: This method calculates the number of consonants of
	 * all enemies
	 * 
	 * @return msj - String: Shows the amount of consonants of all enemies
	 */
	public String countConsonantsGameSystem() {

		int consonants = 0;
		String nameEnemy = "";
		String msj = "";
		if (countEnemiesFreeSpace() != 25) {
			for (int i = 0; i < SIZE_OF_ENEMIES_GAME; i++) {
				if (enemiesGame[i] != null) {
					nameEnemy = enemiesGame[i].getNameE();
					for (int j = 0; j < nameEnemy.length(); j++) {
						char letter = nameEnemy.charAt(j);
						if (isConsonant(letter)) {
							consonants++;
						}
					}
				}
			}

			msj = "Los nombres de los enemigos de todo el juego, cuentan con un total de: " + consonants
					+ " consonantes";

		} else {
			msj = "No hay enemigos en el juego, no se pueden contar las consonantes";
		}

		return msj;

	}

	/**
	 * @param letter: The letter that is received to see if it is a consonant
	 * @return boolean: If the letter is a consonant, the boolean value returned is
	 *         true, otherwise it is false.
	 */
	public static boolean isConsonant(char letter) {
		return "bcdfghjklmnñpqrstvwxyz".contains(String.valueOf(letter).toLowerCase());
	}

	/**
	 * mostRepeatedTreasure: This method list the name of the most repeated Treasure
	 * 
	 * @return msj - String: The name of the most repeated treasure
	 */
	public String mostRepeatedTreasure() {

		int maxCounterAmount = 0;
		String mostRepeatedTreasure = "";
		String msj = "";
		int freeSpace = countTreasuresFreeSpace();

		if (freeSpace == SIZE_OF_TREASURES_GAME) {
			msj = "No hay tesoros en el juego, asi no se puede calcular cual es el mas repetido";
		}

		for (int i = 0; i < SIZE_OF_TREASURES_GAME; i++) {
			int counterAmount = 0;
			for (int j = 0; j < SIZE_OF_TREASURES_GAME; j++) {
				if (treasuresGame[i] != null && treasuresGame[j] != null) {
					if (treasuresGame[i].getNameT() == treasuresGame[j].getNameT()) {
						counterAmount++;
					}
					if (counterAmount > maxCounterAmount) {
						mostRepeatedTreasure = treasuresGame[i].getNameT();
						maxCounterAmount = counterAmount;
						msj = "El tesoro mas repetido es: " + mostRepeatedTreasure + " con " + maxCounterAmount
								+ " veces";

					}
				}
			}
		}

		return msj;

	}

	/**
	 * enemyWithMostPointsE: This method list the names of the of the enemies with
	 * the
	 * highest points
	 * 
	 * 
	 * @return msj - String: The names of the enemies with the highest score
	 */
	public String enemyWithMostPointsE() {
		int highPoints = 0;
		String msj = "";
		String msj1 = "";

		int freeSpace = countEnemiesFreeSpace();

		if (freeSpace == SIZE_OF_ENEMIES_GAME) {
			msj = "No hay enemigos en el juego, asi no se puede calcular cual es el mas que otorga mas puntos";

		} else {

			for (int i = 0; i < SIZE_OF_ENEMIES_GAME; i++) {
				if (enemiesGame[i] != null) {
					if (enemiesGame[i].getPointsE() > highPoints)
						highPoints = enemiesGame[i].getPointsE();
				}
			}

			for (int j = 0; j < SIZE_OF_ENEMIES_GAME; j++) {
				if (enemiesGame[j] != null) {
					if (enemiesGame[j].getPointsE() == highPoints) {
						String nameE = enemiesGame[j].getNameE();
						int pos = actualLevelEnemy(nameE);
						int idNumActualLevel = levelsGame[pos].getIdNum();

						msj += "<" + nameE + ">" + " se encuentra en el nivel: " + idNumActualLevel + "\n";
					}

				}

			}
			msj1 = "El mayor puntaje que causa un enemigo es: " + highPoints + "\n" +
					"Este puntaje lo causa/n lo/s enemigo/s:" + "\n" + "\n";
		}

		return msj1 + msj;

	}

	/**
	 * actualLevelEnemy: This method calculates the level where the enemy is
	 * currently
	 * 
	 * @param nameE String: Represent the name of the enemy to search in the level
	 * @return pos - int: The position of the GameSystem level array where the enemy
	 *         is located (the position represents the level)
	 */
	public int actualLevelEnemy(String nameE) {
		boolean isFound = false;
		int pos = -1;
		for (int i = 0; i < GAME_LEVELS_SIZE && !isFound; i++) {
			if (levelsGame[i].searchEnemyByNameLevel(nameE) != -1) {
				pos = i;
				isFound = true;
			}

		}

		return pos;
	}

	/**
	 * listAmountOfATreasureGameSystem: This method calculates the number of times a
	 * treasure appears in the game
	 * 
	 * @param nameT String: Represent the name of the treasure to search in the game
	 * @return msj - String: Confirmation message
	 */
	public String listAmountOfATreasureGameSystem(String nameT) {
		int pos = searchTreasureByName(nameT);
		String msj = "";
		int counter = 0;
		if (pos != -1) {
			for (int i = 0; i < SIZE_OF_TREASURES_GAME; i++) {
				if (treasuresGame[i] != null && treasuresGame[i].getNameT().equals(nameT)) {
					counter += 1;

					msj = "El tesoro aparece " + counter + " veces en el juego";
				}
			}

		} else {
			msj = "El nombre del tesoro no existe en el juego. Asegurese de escribirlo bien";
		}

		return msj;

	}

	/**
	 * listAmountOfAEnemyGameSystem: This method calculates the number of times a
	 * type of enemy appears in the game
	 * 
	 * @param optionEnemy int: Represent the type of enemy to search in the
	 *                    game
	 * @return msj - String: Confirmation message
	 */
	public String listAmountOfAEnemyGameSystem(int optionEnemy) {
		String msj = "";
		int counter = 0;
		if (optionEnemy <= 3 && optionEnemy >= 0) {
			for (int i = 0; i < SIZE_OF_ENEMIES_GAME; i++) {
				if (enemiesGame[i] != null && enemiesGame[i].getTypeE().equals(TypeEnemy.values()[optionEnemy])) {
					counter += 1;

					msj = "El tipo de enemigo aparece " + counter + " veces en el juego";
				}
			}

		} else {
			msj = "El tipo de enemigo insertado no es valido. Recuerde que el rango de numeros es entre 1 y 4";
		}

		return msj;

	}

	/**
	 * listTreasuresOfALevel: This method list the names of all the
	 * treasures of a level
	 * 
	 * @param idNum int: The id of the level to list treasures
	 * @return msj - String: The names of the treasures
	 */
	public String listTreasuresOfALevel(int idNum) {
		int pos = searchLevelByIdNum(idNum);
		String msj = "";
		if (pos != -1) {
			msj = levelsGame[pos].listTreasures();
		} else {
			msj = "El nivel no fue encontrado";
		}

		if (msj == "[]") {
			msj = "No hay tesoros en este nivel";
		}

		return msj;
	}

	/**
	 * listEnemiesOfALevel: This method list the names of all the
	 * enemies of a level
	 * 
	 * @param idNum int: The id of the level to list enemies
	 * @return msj - String: The names of the enemies
	 */
	public String listEnemiesOfALevel(int idNum) {
		int pos = searchLevelByIdNum(idNum);
		String msj = "";
		if (pos != -1) {
			msj = levelsGame[pos].listEnemies();

		} else {
			msj = "El nivel no fue encontrado";
		}

		if (msj == "[]") {
			msj = "No hay enemigos en este nivel";
		}

		return msj;
	}

	/**
	 * increaseLevelPlayer: This method increases the level of a player
	 * 
	 * @param nickname String: The nickname of the player to increase
	 * @return msj - String: Confirmation message
	 */
	public String increaseLevelPlayer(String nickname) {
		int posGame = searchPlayerByNickname(nickname);
		String msj = "";
		Player playerToIncrease = null;
		if (posGame != -1) {
			if (actualLevelPlayer(nickname) != 9) {
				int level = actualLevelPlayer(nickname);
				int posPlayerLevel = levelsGame[level].searchPlayerByNicknameLevel(nickname);
				int pointsPlayer = levelsGame[level].getPlayersLevel()[posPlayerLevel].getPoints();
				int pointsToPassNextLevel = levelsGame[level].getPointToNextLevel();
				if (pointsPlayer >= pointsToPassNextLevel) {
					if (levelsGame[(level + 1)].hasEmptyPosPlayer()) {
						playerToIncrease = levelsGame[level].getPlayersLevel()[posPlayerLevel];
						levelsGame[level].getPlayersLevel()[posPlayerLevel] = null;
						msj = levelsGame[(level + 1)].addPlayerWithObject(playerToIncrease) + "\n" +
								"Jugador cambiado de nivel exitosamente, el jugador estaba en el nivel: "
								+ levelsGame[level].getIdNum()
								+ " y quedo en el nivel: " + (levelsGame[(level + 1)].getIdNum());
					} else {
						msj = "No hay espacio disponible en el nivel siguiente";
					}
				} else {
					msj = "El jugador no puede incrementar de nivel necesita un puntaje de: " + pointsToPassNextLevel
							+ " para pasar al nivel: " + levelsGame[level + 1].getIdNum()
							+ " y tiene un puntaje de: " + pointsPlayer + " donde esta actualmente en el nivel: "
							+ levelsGame[level].getIdNum();
				}
			} else {
				msj = "El jugador esta en el ultimo nivel no puede avanzar mas de nivel";
			}

		} else {
			msj = "El jugador buscado no existe en el juego";
		}

		return msj;
	}

	/**
	 * modifyPointsPlayer: This method modifies a player's points
	 * 
	 * @param nickname    String: The nickname of the player to set points
	 * @param pointsToSet int: The points to set at the player
	 * @return msj - String: Confirmation message
	 */
	public String modifyPointsPlayer(String nickname, int pointsToSet) {
		int posGame = searchPlayerByNickname(nickname);
		String msj = "";
		if (posGame != -1) {
			playersGame[posGame].setPoints(pointsToSet);
			int level = actualLevelPlayer(nickname);
			int posPlayerLevel = levelsGame[level].searchPlayerByNicknameLevel(nickname);
			levelsGame[level].getPlayersLevel()[posPlayerLevel].setPoints(pointsToSet);
			msj = "El jugador que se encuentra en el nivel: " + levelsGame[level].getIdNum()
					+ " ha quedado con un puntaje de: "
					+ pointsToSet;
		} else {
			msj = "No se encontro el jugador a buscar";
		}

		return msj;

	}

	/**
	 * actualLevePlayer: This method calculates the level where the player is
	 * currently
	 * 
	 * @param nickname String: Represent the nickname of the player to search in the
	 *                 level
	 * @return pos - int: The position of the GameSystem level array where the
	 *         player
	 *         is located (the position represents the level)
	 */
	public int actualLevelPlayer(String nickname) {
		boolean isFound = false;
		int pos = -1;
		for (int i = 0; i < GAME_LEVELS_SIZE && !isFound; i++) {
			if (levelsGame[i].searchPlayerByNicknameLevel(nickname) != -1) {
				pos = i;
				isFound = true;
			}

		}

		return pos;
	}

	/**
	 * addPlayerToGameSystem: What this method does is add a player to the game
	 * system array
	 * 
	 * @param name     String: Represent the name of the player
	 * @param nickname String: Represent the nickname of the player
	 * @return String: msj - Represents a confirmation message where it is confirmed
	 *         if the player could be added
	 */
	public String addPlayerToGameSystem(String nickname, String name) {
		String msj = "No se pudo agregar el jugador, no hay espacio suficiente";

		Player newPlayer = new Player(nickname, name);
		boolean isEmpty = false;
		for (int i = 0; i < SIZE_OF_PLAYERS_GAME && !isEmpty; i++) {
			if (playersGame[i] == null) {
				playersGame[i] = newPlayer;
				isEmpty = true;
				msj = "Jugador agregado correctamente";
			}
		}

		return msj;
	}

	/**
	 * calculatePlayerLevel: This method calculates the level of a player from his
	 * points and adds it to the level
	 * 
	 * @param name     String: Represent the name of the player
	 * @param nickname String: Represent the nickname of the player
	 * @return String: msj - Represents a confirmation message
	 * 
	 */
	public String calculatePlayerLevel(String nickname, String name) {
		String msj;
		Player newPlayer = new Player(nickname, name);
		int maxValue = newPlayer.getPoints();
		int pos = -1;
		for (int i = 0; i < GAME_LEVELS_SIZE - 1; i++) {
			int maxLevel = levelsGame[i].getPointToNextLevel();
			if (levelsGame[i] != null) {
				if (maxValue >= maxLevel) {
					maxLevel = maxValue;
					pos = i + 1;

				}
			}
		}
		if (pos == -1) {
			levelsGame[0].addPlayerWithObject(newPlayer);
			msj = "El jugador no tiene el puntaje suficiente para pasar a ningun nivel, se asignara automaticamente al primer nivel"
					+ "\n" +
					"Jugador: " + newPlayer.getName() + "\n" + "Puntaje del jugador: " + newPlayer.getPoints()
					+ "\n" + "Es asignado al nivel: "
					+ levelsGame[0].getIdNum() + "\n" + "Para pasar al siguiente nivel se necesita un puntaje de: "
					+ levelsGame[0].getPointToNextLevel();
		} else if (pos == 9) {
			msj = "Jugador: " + newPlayer.getName() + "\n" + "Puntaje del jugador: " + newPlayer.getPoints() + "\n"
					+ "Es asignado al nivel: "
					+ levelsGame[pos].getIdNum() + "\n" + "Para pasar a este nivel necesitaba un puntaje de: "
					+ levelsGame[pos - 1].getPointToNextLevel() + "\n"
					+ "El jugador se encuentra en el ultimo nivel, no puede avanzar mas de nivel";
		} else {
			levelsGame[pos].addPlayerWithObject(newPlayer);
			msj = "Jugador: " + newPlayer.getName() + "\n" + "Puntaje del jugador: " + newPlayer.getPoints()
					+ "\n" + "Es asignado al nivel: "
					+ levelsGame[pos].getIdNum() + "\n" + "Para pasar a este nivel necesitaba un puntaje de: "
					+ levelsGame[pos - 1].getPointToNextLevel();
		}

		return msj;
	}

	/**
	 * searchPlayerByNicknameLevel: This method search a player from the enemy array
	 * of the game system
	 * 
	 * @param nickname String - Represents the nickname of the player to search
	 * @return int: pos - The position of the player in the array of player of
	 *         the game system
	 */
	public int searchPlayerByNickname(String nickname) {
		int pos = -1;
		boolean isFound = false;
		for (int i = 0; i < SIZE_OF_PLAYERS_GAME && !isFound; i++) {
			if (playersGame[i] != null) {
				if (playersGame[i].getNickname().equals(nickname)) {
					pos = i;
					isFound = true;
				}
			}
		}

		return pos;
	}

	/**
	 * searchTreasureByName: This method search a treasure from the treasure array
	 * of the game system
	 * 
	 * @param nickname String - Represents the name of the treasure to search
	 * @return int: pos - The position of the treasure in the array of treasure of
	 *         the game system
	 */
	public int searchTreasureByName(String nameT) {
		int pos = -1;
		boolean isFound = false;
		for (int i = 0; i < SIZE_OF_TREASURES_GAME && !isFound; i++) {
			if (treasuresGame[i] != null) {
				if (treasuresGame[i].getNameT().equals(nameT)) {
					pos = i;
					isFound = true;
				}
			}
		}

		return pos;
	}

	/**
	 * addTreasureToGameSystem: What this method does is add a treasure to the game
	 * system array
	 * 
	 * * @param nameT String: Represent the name of the treasure
	 * 
	 * @param image      String: Represent the URL of the treasure
	 * @param pointsT    int: Represent the points that the treasure gives
	 * @param amount     int: The amount of add of the treasure
	 * @param levelIdNum int: The id of the level where the treasure will be added
	 * @return String: msj - Represents a confirmation message
	 */
	public String addTreasureToGameSystem(String nameT, String image, int pointsT, int amount, int levelIdNum) {
		String msj = "";
		int freeSpace = countTreasuresFreeSpace();
		int pos = searchLevelByIdNum(levelIdNum);
		boolean emptyPosLevel = hasEmptyPosTreasureGameSystem();
		if (pos != -1) {
			for (int i = 0; i < amount; i++) {
				if (freeSpace >= amount) {
					Treasure newTreasure = new Treasure(nameT, image, pointsT);
					newTreasure.setPositionX(generateRandomPositionX());
					newTreasure.setPositionY(generateRandomPositionY());
					boolean isEmpty = false;
					for (int j = 0; j < SIZE_OF_TREASURES_GAME && !isEmpty; j++) {
						if (treasuresGame[j] == null) {
							treasuresGame[j] = newTreasure;
							isEmpty = true;
							if (emptyPosLevel) {
								msj = levelsGame[pos].addTreasureWithObject(newTreasure) + "\n" +
										newTreasure.toString() + "\n" + levelsGame[pos].calculateDificultyLevel() + "\n"
										+ "\n" +
										levelsGame[pos].listPositionTreasuresLevel();
							} else {
								msj = "No se pueden añadir mas tesoros, espacio lleno";
							}
						}
					}
				} else {
					msj = ("No se pudo agregar el tesoro, no hay espacio suficiente" + "\n" +
							"El espacio actual disponible para tesoros es: " + freeSpace);
				}
			}

		} else {
			msj = "No se encontro el nivel, por favor revise el dato insertado";
		}
		return msj;

	}

	/**
	 * listPositionTreasures: This method list the position of all treasures in the
	 * level
	 * 
	 * @return msj - String: The positions of the treasures
	 */
	public String listPositionTreasures() {
		boolean isEmpty = false;
		String msj = "";
		for (int i = 0; i < SIZE_OF_TREASURES_GAME && !isEmpty; i++) {
			if (treasuresGame[i] != null) {
				msj += "Tesoro #" + (i + 1) + " del juego" + "\n" +
						treasuresGame[i].toStringPosition();
			}
		}
		return msj;

	}

	/**
	 * addEnemyToGameSystem: What this method does is add a enemy to the game
	 * system array
	 * 
	 * 
	 * @param nameE        String: Represent the name of the enemy
	 * @param optionEnemy  int: Represent the option type of the Enemy
	 * @param damagePoints int: Represent the damage points of the enemy
	 * @param pointsE      int: Represent the points that the enemy gives
	 * @param levelIdNum   int: The id of the level where the enemy will be added
	 * @return String: msj - Represents a confirmation message
	 */
	public String addEnemyToGameSystem(String nameE, int optionEnemy, int damagePoints, int pointsE, int levelIdNum) {
		String msj = "";
		int pos = searchLevelByIdNum(levelIdNum);
		boolean emptyPosLevel = hasEmptyPosEnemyGameSystem();
		if (pos != -1) {
			int posEnemy = getLevelsGame()[pos].searchEnemyByNameLevel(nameE);
			if (posEnemy == -1) {
				Enemy newEnemy = new Enemy(nameE, optionEnemy, damagePoints, pointsE);
				newEnemy.setPositionX(generateRandomPositionX());
				newEnemy.setPositionY(generateRandomPositionY());
				boolean isEmpty = false;
				for (int i = 0; i < SIZE_OF_ENEMIES_GAME && !isEmpty; i++) {
					if (enemiesGame[i] == null) {
						enemiesGame[i] = newEnemy;
						isEmpty = true;
						if (emptyPosLevel) {
							msj = levelsGame[pos].addEnemyWithObject(newEnemy) + "\n" +
									newEnemy.toString() + "\n" + levelsGame[pos].calculateDificultyLevel() + "\n";
						} else {
							msj = "No se pueden añadir mas enemigos, espacio lleno";
						}
					} else {
						msj = "No se pueden añadir mas enemigos, espacio lleno";
					}
				}
			} else {
				msj = "El enemigo ya se encuentra en el nivel. Recuerda que no puedes repetir el nombre del enemigo";
			}

		} else {
			msj = "No se encontro el nivel, por favor revise el dato insertado";
		}
		return msj;

	}

	/**
	 * hasEmptyPosPlayerGameSystem: This method is used to find out if there is an
	 * empty
	 * position in the player array of the game system
	 * 
	 * @return isEmpty - boolean: If true, it indicates that there is an empty
	 *         position
	 */
	public boolean hasEmptyPosPlayerGameSystem() {
		boolean isEmpty = false;
		for (int i = 0; i < SIZE_OF_PLAYERS_GAME && !isEmpty; i++) {
			if (playersGame[i] == null) {
				isEmpty = true;
			}
		}
		return isEmpty;
	}

	/**
	 * hasEmptyPosEnemyGameSystem: This method is used to find out if there is an
	 * empty
	 * position in the enemy array of the game system
	 * 
	 * @return isEmpty - boolean: If true, it indicates that there is an empty
	 *         position
	 */
	public boolean hasEmptyPosEnemyGameSystem() {
		boolean isEmpty = false;
		for (int i = 0; i < SIZE_OF_ENEMIES_GAME && !isEmpty; i++) {
			if (enemiesGame[i] == null) {
				isEmpty = true;
			}
		}
		return isEmpty;
	}

	/**
	 * hasEmptyPosTreasureGameSystem: This method is used to find out if there is an
	 * empty
	 * position in the treasure array of the game system
	 * 
	 * @return isEmpty - boolean: If true, it indicates that there is an empty
	 *         position
	 */
	public boolean hasEmptyPosTreasureGameSystem() {
		boolean isEmpty = false;
		for (int i = 0; i < SIZE_OF_TREASURES_GAME && !isEmpty; i++) {
			if (treasuresGame[i] == null) {
				isEmpty = true;
			}
		}
		return isEmpty;
	}

	/**
	 * searchEnemyByName: This method search a enemy from the enemy array
	 * of the game system
	 * 
	 * @param nickname String - Represents the name of the enemy to search
	 * @return int: pos - The position of the enemy in the array of enemy of
	 *         the game system
	 */
	public int searchEnemyByName(String nameE) {
		int pos = -1;
		boolean isFound = false;
		for (int i = 0; i < SIZE_OF_ENEMIES_GAME && !isFound; i++) {
			if (enemiesGame[i] != null) {
				if (enemiesGame[i].getNameE().equals(nameE)) {
					pos = i;
					isFound = true;
				}
			}
		}

		return pos;
	}

	/**
	 * listTypesEnemies: List the type of enemies in the game
	 * 
	 * @return msj - String: The types of enemies
	 */
	public String listTypesEnemies() {
		TypeEnemy typeEnemies[] = TypeEnemy.values();
		String msj = "Tipo de enemigos: ";
		for (int i = 0; i < typeEnemies.length; i++) {
			msj += "\n" + (i + 1) + ") " + typeEnemies[i];

		}

		return msj;
	}

	/**
	 * searchLevelByIdNum: This method search a level from the level array
	 * of the game system
	 * 
	 * @param idNum int - Represents the idNum of the level to search
	 * @return int: pos - The position of the level in the array of level of
	 *         the game system
	 */
	public int searchLevelByIdNum(int idNum) {
		int pos = -1;
		boolean isFound = false;
		for (int i = 0; i < GAME_LEVELS_SIZE && !isFound; i++) {
			if (levelsGame[i] != null) {
				if (levelsGame[i].getIdNum() == idNum) {
					pos = i;
					isFound = true;
				}
			}
		}

		return pos;
	}

	/**
	 * countTreasuresFreeSpace: Calculate the number of free spaces in the treasure
	 * array
	 * 
	 * @return amountTreasures - String: The number of free space
	 */
	public int countTreasuresFreeSpace() {
		int amountTreasures = 0;
		for (int i = 0; i < SIZE_OF_TREASURES_GAME; i++) {
			if (treasuresGame[i] == null) {
				amountTreasures += 1;
			}
		}

		return amountTreasures;
	}

	/**
	 * countEnemiesFreeSpace: Calculate the number of free spaces in the enemies
	 * array
	 * 
	 * @return amountTreasures - String: The number of free space
	 */
	public int countEnemiesFreeSpace() {
		int amountEnemies = 0;
		for (int i = 0; i < SIZE_OF_ENEMIES_GAME; i++) {
			if (enemiesGame[i] == null) {
				amountEnemies += 1;
			}
		}

		return amountEnemies;
	}

	/**
	 * @return String return the gameName
	 */
	public String getGameName() {
		return gameName;
	}

	/**
	 * @param gameName the gameName to set
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	/**
	 * @return Player[] return the playersGame
	 */
	public Player[] getPlayersGame() {
		return playersGame;
	}

	/**
	 * @param playersGame the playersGame to set
	 */
	public void setPlayersGame(Player[] playersGame) {
		this.playersGame = playersGame;
	}

	/**
	 * @return Treasure[] return the treasuresGame
	 */
	public Treasure[] getTreasuresGame() {
		return treasuresGame;
	}

	/**
	 * @param treasuresGame the treasuresGame to set
	 */
	public void setTreasuresGame(Treasure[] treasuresGame) {
		this.treasuresGame = treasuresGame;
	}

	/**
	 * @return Enemy[] return the enemiesGame
	 */
	public Enemy[] getEnemiesGame() {
		return enemiesGame;
	}

	/**
	 * @param enemiesGame the enemiesGame to set
	 */
	public void setEnemiesGame(Enemy[] enemiesGame) {
		this.enemiesGame = enemiesGame;
	}

	/**
	 * @return Level[] return the levelsGame
	 */
	public Level[] getLevelsGame() {
		return levelsGame;
	}

	/**
	 * @param levelsGame the levelsGame to set
	 */
	public void setLevelsGame(Level[] levelsGame) {
		this.levelsGame = levelsGame;
	}

	/**
	 * @return the gameResolutionX
	 */
	public int getGameResolutionX() {
		return gameResolutionX;
	}

	/**
	 * @return the gameResolutionY
	 */
	public int getGameResolutionY() {
		return gameResolutionY;
	}

	/**
	 * generateRandomPositionX: Generate a random position based on the X resolution
	 * of the game
	 * 
	 * @return randomPositionX - int: The random positionX
	 */
	public int generateRandomPositionX() {
		int minValue = 1;
		int maxValue = gameResolutionX;
		ThreadLocalRandom tlr = ThreadLocalRandom.current();
		int randomPositionX = tlr.nextInt(minValue, maxValue + 1);
		return randomPositionX;
	}

	/**
	 * generateRandomPositionY: Generate a random position based on the Y resolution
	 * of the game
	 * 
	 * @return randomPositionY - int: The random positionY
	 */
	public int generateRandomPositionY() {
		int minValue = 1;
		int maxValue = gameResolutionY;
		ThreadLocalRandom tlr = ThreadLocalRandom.current();
		int randomPositionY = tlr.nextInt(minValue, maxValue + 1);
		return randomPositionY;
	}

}
