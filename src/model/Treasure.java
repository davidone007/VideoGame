package model;

public class Treasure {

    private String nameT;
    private String image;
    private int pointsT;
    private int positionX;
    private int positionY;

    /**
     * Treasure: Constructor of Treasure class
     * 
     * @param nameT     String: Represent the name of the treasure
     * @param image     String: Represent the URL of the treasure
     * @param pointsT   int: Represent the points that the treasure gives
     * @param positionX int: Represent the positionX of the treasure
     * @param positionY int: Represent the positionY of the treasure
     */
    public Treasure(String nameT, String image, int pointsT) {
        this.nameT = nameT;
        this.image = image;
        this.pointsT = pointsT;
        this.positionX = 0;
        this.positionY = 0;
    }

    /*
     * toString: This method displays treasure information
     * 
     * @return String: Information of the treasure
     */
    public String toString() {
        return "Nombre del tesoro: " + nameT + "\n" +
                "Imagen del tesoro: " + image + "\n" +
                "Puntos del tesoro: " + pointsT + "\n";

    }

    /**
     * toStringPosition: This method displays treasure positions
     * 
     * @return String: Information of the position of a trasure
     */
    public String toStringPosition() {
        return "Posicion X del tesoro: " + this.positionX + "\n" +
                "Posicion Y del tesoro: " + this.positionY + "\n";

    }

    /**
     * @return String return the nameT
     */
    public String getNameT() {
        return nameT;
    }

    /**
     * @param nameT the nameT to set
     */
    public void setNameT(String nameT) {
        this.nameT = nameT;
    }

    /**
     * @return String return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return int return the pointsT
     */
    public int getPointsT() {
        return pointsT;
    }

    /**
     * @param pointsT the pointsT to set
     */
    public void setPointsT(int pointsT) {
        this.pointsT = pointsT;
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