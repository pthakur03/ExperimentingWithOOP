/** Creates a class Loot which represents the spoils gained from plundering a ship or fort.
 * @author Parth Thakur
 * @version 1
 */
public abstract class Loot {
    private double value;
/** Creates a constructor that initiates Loot with one parameter.
 * @param value Represents the monetary value of an item.
 */
    public Loot(double value) {
        if (value > 0) {
            this.value = value;
        }
    }
/** Creates a contructor that initiates loot without a parameter and sets value to a default of 0. */
    public Loot() {
        this.value = 0;
    }
/**Creates a getter method for value.
     * @return Returns a double which represents the monetary value of an item.
     */
    public double getValue() {
        return this.value;
    }
  /**Creates a setter method for value.
     * @param value Represents the monetary value of an item.
     */
    public void setValue(double value) {
        if (value > 0) {
            this.value = value;
        }
    }
/**Creates a toString() method that overrides Object’s toString() method.
 * @return Returns the String output.
 */
    public String toString() {
        return ("A piece of loot worth " + value);
    }
/**Creates an equals() method that overrides Object’s equals() method.
 * @param other Represents the object we pass in for comparison.
 * @return Returns a boolean value.
  */
    public boolean equals(Object other) {
        if (other != null && other instanceof Loot) {
            return this.value == ((Loot) other).value;
        } else {
            return false;
        }
    }
}