package ui;

import java.util.Scanner;
import model.GameSystem;

public class Main {

	private Scanner reader;
	private GameSystem gameSystem;

	/**
	 * Main: constructor of Main class
	 */
	public Main() {
		reader = new Scanner(System.in);
		gameSystem = new GameSystem();
		gameSystem.initGame();

	}

	/**
	 * @param reader the reader to set
	 */
	public void setReader(Scanner reader) {
		this.reader = reader;
	}

	/**
	 * @return GameSystem return the gameSystem
	 */
	public GameSystem getGameSystem() {
		return gameSystem;
	}

	/**
	 * @param gameSystem the gameSystem to set
	 */
	public void setGameSystem(GameSystem gameSystem) {
		this.gameSystem = gameSystem;
	}

	/**
	 * @return Scanner return the reader
	 */
	public Scanner getReader() {
		return reader;
	}

	public static void main(String[] args) {
		Main main = new Main();
		int option = 0;

		do {

			option = main.getOptionShowMenu();
			main.executeOption(option);

		} while (option != 0);

		main.getReader().close();
	}

	/**
	 * getOptionShoeMenu: Show the menu and get the option
	 * 
	 * @return option - int: The option chosen by the user
	 */
	public int getOptionShowMenu() {
		int option = 0;
		System.out.println("<<<<< Bienvenido al juego >>>>>");
		System.out.println(
				"1. Crear jugador\n" +
						"2. Añadir tesoros\n" +
						"3. Añadir enemigo\n" +
						"4. Modificar puntaje del jugador\n" +
						"5. Incrementar jugador de nivel\n" +
						"6. Informar los tesoros y enemigos de un nivel\n" +
						"7. Informar la cantidad de un tesoro en todos los niveles\n" +
						"8. Informar la cantidad de un tipo de enemigo en todos los niveles\n" +
						"9. Informar el tesoro mas repetido en todos los niveles\n" +
						"10. Informar el enemigo con mayor puntaje y el nivel donde se ubica\n" +
						"11. Informar cantidad de consonantes encontradas en los nombres de los enemigos del juego\n" +
						"12. Informar el top 5 de jugadores del juego\n" +
						"0. Salir ");

		option = validateIntegerOption();

		return option;
	}

	/**
	 * validateIntegerOption: This method checks if a number is an integer
	 * 
	 * @return option - int: Returns the entered number if it is an integer or
	 *         returns -1 if it is not an integer
	 */
	public int validateIntegerOption() {
		int option = 0;

		if (reader.hasNextInt()) {
			option = reader.nextInt();
		} else {
			reader.nextLine();
			option = -1;
		}

		return option;
	}

	/**
	 * executeOption: Execute the option
	 * 
	 * @param option int. The choosen option
	 */
	public void executeOption(int option) {

		switch (option) {
			case 1:
				uiAddPlayer();

				break;

			case 2:
				uiAddTreasure();

				break;

			case 3:
				uiAddEnemy();

				break;

			case 4:
				uiModifyPointsPlayer();

				break;

			case 5:
				uiIncreasePlayerLevel();

				break;

			case 6:
				uiListObjectsOfALevel();

				break;

			case 7:
				uiListAmountOfATreasureGameSystem();

				break;

			case 8:
				uiListAmountOfAEnemyGameSystem();

				break;

			case 9:
				uiMostRepeatedTreasure();

				break;

			case 10:
				uiEnemyWithMostPointsE();

				break;

			case 11:
				uiCountConsonantsEnemies();

				break;

			case 12:
				uiTop5Players();

				break;

			case 0:
				System.out.println("Gracias por jugar");
				break;

			default:
				System.out.println("Opcion invalida");
				break;
		}
	}

	/**
	 * UI METHOD
	 * Request the information and add a player to the game
	 */
	public void uiAddPlayer() {
		String namePlayer = "";
		String nicknamePlayer = "";
		String msj = "";
		String msj1 = "";
		int pos = 0;
		boolean emptyPos = false;
		System.out.println("Se procedera a crear el jugador. Recuerde que el jugador inicia con un puntaje de 10 puntos"
				+ "\n" +
				"El nivel donde se encuentra el jugador se calculara automaticamente, el jugador se pondra en el nivel maximo que pueda estar segun su puntaje");
		System.out.println("Escribe tu nombre");
		namePlayer = reader.next();
		System.out.println("Escribe el nickname que deseas usar");
		nicknamePlayer = reader.next();
		pos = gameSystem.searchPlayerByNickname(nicknamePlayer);
		emptyPos = gameSystem.hasEmptyPosPlayerGameSystem();
		if (pos == -1) {
			msj = gameSystem.addPlayerToGameSystem(nicknamePlayer, namePlayer);
			System.out.println(msj);
			if (emptyPos) {
				msj1 = gameSystem.calculatePlayerLevel(nicknamePlayer, nicknamePlayer);
				System.out.println(msj1);
			}
		} else {
			System.out.println("El nickname ya esta en uso, por favor elija uno diferente");
		}

	}

	/**
	 * UI METHOD
	 * Request the information and add a treasure to the game
	 */
	public void uiAddTreasure() {
		String nameTreasure = "";
		String imageTreasure = "";
		int pointsTreasure = 0;
		int idNum = 0;
		int amountTreasure = 0;
		String msj = "";

		System.out.println("Escriba el nombre del tesoro:");
		nameTreasure = reader.next();
		System.out.println("Escriba la URL de la imagen del tesoro:");
		imageTreasure = reader.next();
		System.out.println("Escriba los puntos del tesoro:");
		pointsTreasure = validateIntegerOption();

		while (pointsTreasure == -1) {
			reader.next();
			System.out.println("Este apartado no acepta letras, ni numeros decimales. Escriba un dato valido");
			pointsTreasure = validateIntegerOption();
		}
		System.out.println("Escriba el nivel donde quiere añadir el tesoro:");
		idNum = validateIntegerOption();

		while (idNum == -1) {
			reader.next();
			System.out.println("Este apartado no acepta letras, ni numeros decimales. Escriba un dato valido");
			idNum = validateIntegerOption();
		}
		System.out.println("Escriba el numero de cantidad que quiere añadir del tesoro en el nivel:");
		amountTreasure = validateIntegerOption();

		while (amountTreasure == -1) {
			reader.next();
			System.out.println("Este apartado no acepta letras, ni numeros decimales. Escriba un dato valido");
			amountTreasure = validateIntegerOption();
		}

		msj = gameSystem.addTreasureToGameSystem(nameTreasure, imageTreasure, pointsTreasure, amountTreasure, idNum);
		System.out.println(msj);

	}

	/**
	 * UI METHOD
	 * Request the information and add a enemy to the game
	 */
	public void uiAddEnemy() {
		String nameEnemy = "";
		int typeEnemy = 0;
		int pointsEnemy = 0;
		int idNum = 0;
		int damagePoints = 0;
		String msj = "";

		System.out.println("Escriba el nombre de su enemigo:");
		nameEnemy = reader.next();
		System.out.println("Escriba los puntos que otorgara su enemigo:");
		pointsEnemy = validateIntegerOption();
		while (pointsEnemy == -1) {
			reader.next();
			System.out.println("Este apartado no acepta letras, ni numeros decimales. Escriba un dato valido");
			pointsEnemy = validateIntegerOption();
		}
		System.out.println("Escriba el daño de su enemigo:");
		damagePoints = validateIntegerOption();
		while (damagePoints == -1) {
			reader.next();
			System.out.println("Este apartado no acepta letras, ni numeros decimales. Escriba un dato valido");
			damagePoints = validateIntegerOption();
		}

		System.out.println("Inserte el tipo de su enemigo:");
		System.out.println(gameSystem.listTypesEnemies());
		typeEnemy = (validateIntegerOption() - 1);

		while (typeEnemy > 3 || typeEnemy < 0 || typeEnemy == -2) {
			System.out.println("Este apartado no acepta letras, ni numeros decimales. Escriba un dato valido");
			System.out.println("Recuerde que los tipos de enemigos se encuentran entre 1 y 4");
			typeEnemy = (validateIntegerOption() - 1);
		}

		System.out.println("Escriba el nivel donde quiere añadir su enemigo:");
		idNum = validateIntegerOption();
		while (idNum == -1) {
			reader.next();
			System.out.println("Este apartado no acepta letras, ni numeros decimales. Escriba un dato valido");
			idNum = validateIntegerOption();
		}
		msj = gameSystem.addEnemyToGameSystem(nameEnemy, typeEnemy, damagePoints, pointsEnemy, idNum);
		System.out.println(msj);

	}

	/**
	 * UI METHOD
	 * Request the information and modify points of a player of the game
	 */
	public void uiModifyPointsPlayer() {
		String nickname = "";
		int pointsToSet = 0;
		String msj = "";

		System.out.println("Escriba el nickname del jugador al que le quiere cambiar el puntaje:");
		nickname = reader.next();
		System.out.println("Escriba el puntaje que quiere ponerle a su jugador");
		pointsToSet = validateIntegerOption();
		while (pointsToSet == -1) {
			reader.next();
			System.out.println("Este apartado no acepta letras, ni numeros decimales. Escriba un dato valido");
			pointsToSet = validateIntegerOption();
		}
		msj = gameSystem.modifyPointsPlayer(nickname, pointsToSet);
		System.out.println(msj);
	}

	/**
	 * UI METHOD
	 * Request the information and increase level of a player of the game
	 */
	public void uiIncreasePlayerLevel() {
		String nickname = "";
		String msj = "";

		System.out.println(
				"Escriba el nickname del jugador al que quiere aumentar el nivel (El jugador aumentara al primer nivel en el que sus puntos sean suficientes para pasar):");
		nickname = reader.next();
		msj = gameSystem.increaseLevelPlayer(nickname);
		System.out.println(msj);

	}

	/**
	 * UI METHOD
	 * Request the information and list the treasures and enemies of a level
	 */
	public void uiListObjectsOfALevel() {
		int idNum = 0;
		String msj = "";
		String msj1 = "";

		System.out.println("Escriba el numero del nivel al que quiere listar sus enemigos y tesoros");
		idNum = validateIntegerOption();
		while (idNum == -1) {
			reader.next();
			System.out.println("Este apartado no acepta letras, ni numeros decimales. Escriba un dato valido");
			idNum = validateIntegerOption();
		}
		msj = gameSystem.listEnemiesOfALevel(idNum);
		msj1 = gameSystem.listTreasuresOfALevel(idNum);

		System.out.println("La lista de tesoros separados por coma es: ");
		System.out.println(msj1);
		System.out.println("La lista de enemigos separados por coma es: ");
		System.out.println(msj);

	}

	/**
	 * UI METHOD
	 * Request the information and lis the amount of a treasure in all levels
	 */
	public void uiListAmountOfATreasureGameSystem() {
		String nameT = "";
		String msj = "";

		System.out.println("Escriba el nombre del tesoro que desea buscar la cantidad:");
		nameT = reader.next();
		msj = gameSystem.listAmountOfATreasureGameSystem(nameT);
		System.out.println(msj);

	}

	/**
	 * UI METHOD
	 * Request the information and lis the amount of a type of enemy in all levels
	 */
	public void uiListAmountOfAEnemyGameSystem() {
		String msj = "";
		int typeEnemy = 0;

		System.out.println("Inserte el tipo de su enemigo a contar en los niveles:");
		System.out.println(gameSystem.listTypesEnemies());
		typeEnemy = (validateIntegerOption() - 1);

		while (typeEnemy > 3 || typeEnemy < 0 || typeEnemy == -2) {
			System.out.println("Este apartado no acepta letras, ni numeros decimales. Escriba un dato valido");
			System.out.println("Recuerde que los tipos de enemigos se encuentran entre 1 y 4");
			typeEnemy = (validateIntegerOption() - 1);
		}

		msj = gameSystem.listAmountOfAEnemyGameSystem(typeEnemy);
		System.out.println(msj);
	}

	/**
	 * UI METHOD
	 * Show the most repeated treasure
	 */
	public void uiMostRepeatedTreasure() {
		String msj = gameSystem.mostRepeatedTreasure();
		System.out.println(msj);
	}

	/**
	 * UI METHOD
	 * Show the enemy with highest points
	 */
	public void uiEnemyWithMostPointsE() {
		String msj = gameSystem.enemyWithMostPointsE();
		System.out.println(msj);
	}

	/**
	 * UI METHOD
	 * Show the consonants of the enemies name in the game
	 */
	public void uiCountConsonantsEnemies() {
		String msj = gameSystem.countConsonantsGameSystem();
		System.out.println(msj);
	}

	/**
	 * UI METHOD
	 * Show the top 5 players of the game
	 */
	public void uiTop5Players() {
		String msj = gameSystem.showTop5();
		System.out.println("Si el puntaje lo poseen varios jugadores, se pondra el nickname del primer jugador que haya obtenido el puntaje");
		System.out.println("<<<< TOP 5 JUGADORES >>>>");
		System.out.println(msj);
	}

}
