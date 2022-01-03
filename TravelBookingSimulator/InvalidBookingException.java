/** Creates a specific exception.
 * @author Parth Thakur
 * @version 1
 */
public class InvalidBookingException extends Exception {
/** Creates a constructor that takes in a String.
 * @param message Represents the exception's outputted message.
 */
    public InvalidBookingException(String message) {
        super(message);
    }
/** Creates a constructor that has a default message.
 */
    public InvalidBookingException() {
        super("Invalid booking type");
    }
}
