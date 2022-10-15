package model;

public class Player {

    private String nickname;
    private String name;
    private int points;
    private int numLifes;

    /**
     * Player: Constructor of Player class
     * 
     * @param nickname String: Represent the nickname of the player. This attribute
     *                 is unique per player
     * @param name     String: Represent the name of the player
     */
    public Player(String nickname, String name) {
        this.nickname = nickname;
        this.name = name;
        numLifes = 5;
        points = 10;

    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return int return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * @return int return the numLifes
     */
    public int getNumLifes() {
        return numLifes;
    }

    /**
     * @param numLifes the numLifes to set
     */
    public void setNumLifes(int numLifes) {
        this.numLifes = numLifes;
    }

    /**
     * @return String return the nickname
     */
    public String getNickname() {
        return nickname;
    }

}
