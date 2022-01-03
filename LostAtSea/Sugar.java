/** Creates a class Sugar which represents a type of Loot.
 * @author Parth Thakur
 * @version 1
 */
public class Sugar extends Loot {
    private double amount;
    private double sweetness;
/** Creates a constructor that initiates Sugar.
 * @param amount Represents the quantity of sugar.
 * @param sweetness Represents the sweetness of sugar.
*/
    public Sugar(double amount, double sweetness) {
        if (amount > 0 && sweetness >= 0 && sweetness <= 100) {
            this.amount = amount;
            this.sweetness = sweetness;
        } else {
            this.amount = 0;
            this.sweetness = 0;
        }
        this.setValue(this.amount * this.sweetness);
    }
/**Creates a toString() method that overrides Object’s toString() method.
 * @return Returns the String output.
 */
    public String toString() {
        return ("A pile of sugar of size " + this.amount + " and sweetness " + this.sweetness + ".");
    }
/**Creates an equals() method that overrides Object’s equals() method.
 * @param other Represents the object we pass in for comparison.
 * @return Returns boolean value after undergoing conditions.
  */
    public boolean equals(Object other) {
        boolean comparison;
        boolean sameValue = super.equals(other);
        if (other != null && other instanceof Sugar) {
            comparison = this.amount == ((Sugar) other).amount && this.sweetness == ((Sugar) other).sweetness;
        } else {
            return false;
        }
        return comparison && sameValue;
    }
}