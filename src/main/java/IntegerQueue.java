/**
 * A queue of IntegerMessage objects
 */
public class IntegerQueue extends Queue {
    /**
     * Create a new IntegerQueue
     */
    public IntegerQueue(){
        super();
    }

    /**
     * Append an entry to the queue
     * @param value the IntegerMessage to append
     */
    public void newEntry(IntegerMessage value){
        super.newEntry(value);
    }

    /**
     * Get the active object
     * @return IntegerMessage the IntegerMessage at the top of the stack
     */
    public IntegerMessage getActive(){
        try{
            return (IntegerMessage) super.getActive();
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
