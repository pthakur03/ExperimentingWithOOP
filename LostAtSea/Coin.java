/** Creates a class Coin which represents a type of Loot.
 * @author Parth Thakur
 * @version 1
 */
public class Coin extends Loot {
    private boolean heads;
    private int yearMade;
    private String material;
/** Creates a contructor that initiates Coin.
 * @param value Represents the monetary value of an item.
 * @param heads Represents whether or not the coin is heads up or tails up.
 * @param yearMade Represents the year the coin was manufactured in; tests that year integer is valid or defaulted.
 * @param material Represents the material the coin is made of, such as gold, silver, etc.
 */
    public Coin(double value, boolean heads, int yearMade, String material) {
        super(value);
        this.heads = heads;
        if (yearMade >= 0 && yearMade <= 1700) {
            this.yearMade = yearMade;
        } else {
            this.yearMade = 1700;
        }
        this.material = material;
    }
/**Creates a contructor that initiates Coin.
 * @param heads Represents whether or not the coin is heads up or tails up.
 * @param yearMade Represents the year the coin was manufactured in.
 */
    public Coin(boolean heads, int yearMade) {
        this((double) (3000 - yearMade) / 100, heads, yearMade, "Gold");
    }
/**Creates a toString() method that overrides Object’s and Loot’s toString() methods.
 * @return Returns the String output.
 */
    public String toString() {
        return ("A" + this.material + " coin made in " + this.yearMade + ". Heads side is up: " + this.heads);
    }
/**Creates an equals() method that overrides Object’s equals() method.
 * @param other Represents the object we pass in for comparison.
 * @return Returns boolean value after undergoing conditions.
  */
    public boolean equals(Object other) {
        boolean comparison;
        boolean sameValue = super.equals(other);
        if (other != null && other instanceof Coin) {
            comparison = this.yearMade == ((Coin) other).yearMade && this.material.equals(((Coin) other).material);
        } else {
            return false;
        }
        return comparison && sameValue;
    }
}