/** Creates a class Ship which represents a ship on the high seas with cargo on board.
 * @author Parth Thakur
 * @version 1
 */
public class Ship implements Plunderable {
    private Loot[] cargo;
    private double totalCargoValue;
    private String name;
/** Creates a constructor that initiates Ship.
 * @param name Represents the name of the ship.
 */
    public Ship(String name) {
        cargo = new Loot[10];
        this.name = name;
        totalCargoValue = 0;
    }
/**Creates a contructor that initiates Ship.
 */
    public Ship() {
        this("Black Pearl");
    }
/**Creates a toString() method that overrides Object’s toString() method.
 * @return Returns the String output.
 */
    public String toString() {
        String temp1 = "";
        double temp2 = Math.round(totalCargoValue * 100.0) / 100.0;
        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] != null) {
                temp1 += cargo[i].toString();
            }
        }
        return "A ship called " + this.name + " with cargo "
            + temp1 + "which has a total value of " + temp2 + ".";
    }
/** Creates an addCargo method which tests and if successful adds cargo to a ship.
 * @param newItem Represents the new item being added.
*/
    public void addCargo(Loot newItem) {
        if (newItem != null) {
            if (cargo[cargo.length - 1] != null) {
                Loot[] newCargo = new Loot[cargo.length * 2];
                for (int i = 0; i < cargo.length; i++) {
                    newCargo[i] = cargo[i];
                }
                cargo = newCargo;
            }
            for (int i = 0; i < cargo.length; i++) {
                if (cargo[i] == null) {
                    cargo[i] = newItem;
                    break;
                }
            }
            totalCargoValue += newItem.getValue();
        }
    }
/** Creates a removeCargo method which sets the first filled cargo slot to null.
 * @return Returns the cargo item that was present before the value was set to null.
 */
    public Loot removeCargo() {
        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] != null) {
                Loot temp = cargo[i];
                cargo[i] = null;
                totalCargoValue -= temp.getValue();
                return temp;
            }
        }
        return null;
    }
/** Creates a removeCargo method which checks if the given cargo is on the ship.
 * @param newCargo Represents the item that needs to be checked if it is present or not.
 * @return Returns null if item is not present; otherwise removes the item and returns the item.
 */
    public Loot removeCargo(Loot newCargo) {
        if (newCargo != null) {
            for (int i = 0; i < this.cargo.length; i++) {
                if (this.cargo[i].equals(newCargo)) {
                    Loot temp = this.cargo[i];
                    this.cargo[i] = null;
                    totalCargoValue -= temp.getValue();
                    return temp;
                }
            }
            return null;
        }
        return null;
    }
/** Creates a method named bePlundered() which sets the orginal values to null.
 * @return Returns an array of the Loot objects in the ship’s cargo,
 */
    public Loot[] bePlundered() {
        int arrlength = 0;
        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] != null) {
                arrlength++;
            }
        }
        if (arrlength == 0) {
            return null;
        }
        Loot[] output = new Loot[arrlength];
        int index = 0;
        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] != null) {
                output[index] = cargo[i];
                index++;
                totalCargoValue -= cargo[i].getValue();
                cargo[i] = null;
            }
        }
        return output;
    }
}