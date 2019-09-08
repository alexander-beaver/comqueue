/**
 * A queue specifically for integer positions. Integer Positions will have a maximum of one entry exist in the stack
 * after a loop.
 */
public class IntegerPositionQueue extends Queue {

    /**
     * Create a new queue
     */
    public IntegerPositionQueue(){
        super();
    }

    /**
     * Add a new position to the stack
     * @param pos a PositionMessage to append
     */
    public void newEntry(IntegerMessage pos){
        super.clear(); //Position Queue only contains one position
        super.newEntry(pos);
    }

    /**
     * Get the current active PositionMessage
     * @return the top PositionMessage
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
