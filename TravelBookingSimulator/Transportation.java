/** Creates an abstract class Transportation.
 * @author Parth Thakur
 * @version 1
 */
public abstract class Transportation {
    protected String company;
    protected int id;
    protected String departDate;
    protected String departTime;
    protected String arrivalTime;
/**Creates a constructor that initiates Transportation.
 * @param company Represents the name of the transportation company.
 * @param id Represents the transportation vehicle number identifier.
 * @param departDate Represents the departure date.
 * @param departTime Represents the departure time.
 * @param arrivalTime Represents the arrival time.
*/
    public Transportation(String company, int id, String departDate, String departTime, String arrivalTime)
        throws IllegalArgumentException {
        if (company == null || company.equals("")) {
            throw new IllegalArgumentException("Please enter a valid company");
        } else {
            this.company = company;
        }

        if (departDate == null || departDate.equals("")) {
            throw new IllegalArgumentException("Please enter a valid depart date.");
        } else {
            this.departDate = departDate;
        }
        if (departTime == null || departTime.equals("")) {
            throw new IllegalArgumentException("Please enter a valid depart time.");
        } else {
            this.departTime = departTime;
        }
        if (arrivalTime == null || arrivalTime.equals("")) {
            throw new IllegalArgumentException("Please enter valid arrival time.");
        } else {
            this.arrivalTime = arrivalTime;
        }

        if (id < 10000 || id > 99999) {
            throw new IllegalArgumentException("Please enter a valid id.");
        } else {
            this.id = id;
        }
    }
/**Creates a toString() method that properly overrides Object’s toString() method.
 * @return Returns the String output.
 */
    public String toString() {
        return (company + "," + id + "," + departDate + "," + departTime + "," + arrivalTime);
    }
/**Creates an equals() method that properly overrides Object’s equals() method.
 * @param other Represents the other String value to be compared.
 * @return Returns true if the objects are equal and returns false otherwise.
  */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (other instanceof Transportation) {
            return (this.company.equals(((Transportation) other).company)
                && this.id == ((Transportation) other).id
                && this.departDate == ((Transportation) other).departDate
                && this.departTime == ((Transportation) other).departTime
                && this.arrivalTime == ((Transportation) other).arrivalTime);
        } else {
            return false;
        }
    }
}