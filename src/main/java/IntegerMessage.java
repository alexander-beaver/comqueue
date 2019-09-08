/**
 * A message consisting of an integer value
 */
public class IntegerMessage extends BaseMessage {
    /**
     * The value stored in the IntegerMessage
     */
    private int value;

    /**
     * Construct an IntegerMessage based on a value
     * @param value the value of the IntegerMessage
     */
    public IntegerMessage(int value){
        super();
        this.value = value;
    }

    /**
     * Get the value of the message
     * @return the value of the message
     */
    public int getValue() {
        return value;
    }
}
