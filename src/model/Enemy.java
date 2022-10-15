package model;

public class Enemy {

    private String nameE;
    private TypeEnemy typeE;
    private int damagePoints;
    private int pointsE;
    private int positionX;
    private int positionY;

    /**
     * Enemy: The constructor of Enemy class
     * 
     * @param nameE        String: Represent the name of the enemy
     * @param optionEnemy  int: Represent the option type of the Enemy
     * @param damagePoints int: Represent the damage points of the enemy
     * @param pointsE      int: Represent the points that the enemy gives
     * @param positionX    int: Represent the positionX of the enemy
     * @param positionY    int: Represent the positionY of the enemy
     */
    public Enemy(String nameE, int optionEnemy, int damagePoints, int pointsE) {
        this.nameE = nameE;
        this.damagePoints = damagePoints;
        this.pointsE = pointsE;
        this.positionX = 0;
        this.positionY = 0;
        this.typeE = TypeEnemy.values()[optionEnemy];

    }

    /*
     * toString: This method displays enemy information
     * 
     * @return String: Information of the enemy
     */
    public String toString() {
        return "Nombre del enemigo: " + nameE + "\n" +
                "Tipo de enemigo: " + this.typeE + "\n" +
                "Daño del enemigo: " + damagePoints + "\n" +
                "Puntos que otorga el enemigo: " + pointsE + "\n" +
                "Posicion X del enemigo:  " + this.positionX + "\n" +
                "Posicion Y del enemigo:  " + this.positionY + "\n";
    }

    /**
     * @return String return the nameE
     */
    public String getNameE() {
        return nameE;
    }

    /**
     * @param nameE the nameE to set
     */
    public void setNameE(String nameE) {
        this.nameE = nameE;
    }

    /**
     * @return String return the typeE
     */
    public TypeEnemy getTypeE() {
        return typeE;
    }

    /**
     * @return int return the damagePoints
     */
    public int getDamagePoints() {
        return damagePoints;
    }

    /**
     * @param damagePoints the damagePoints to set
     */
    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    /**
     * @return int return the pointsE
     */
    public int getPointsE() {
        return pointsE;
    }

    /**
     * @param pointsE the pointsE to set
     */
    public void setPointsE(int pointsE) {
        this.pointsE = pointsE;
    }

    /**
     * @return int return the positionX
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * @param positionX the positionX to set
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
     * @return int return the positionY
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * @param positionY the positionY to set
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

}