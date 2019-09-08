import java.util.Random;

/**
 * The base layer shared between all messages
 * Should be extended into message types
 */
public class BaseMessage {
    /**
     * The current status of the message
     */
    private MessageStatus status;
    /**
     * A unique ID used to make log analysis easier
     */
    private long id;

    /**
     * Create a new BaseMessage with a random ID
     */
    public BaseMessage(){
        this.id = new Random().nextLong();
    }

    /**
     * Set the status of the message
     * @param status The status to be set
     */
    public void setStatus(MessageStatus status){
        this.status = status;
    }

    /**
     * Get the status of the current message
     * @return current status
     */
    public MessageStatus getStatus(){
        return this.status;
    }

    /**
     * Callback for creation of a message to a queue
     */
    public void onCreate(){
        this.status = MessageStatus.QUEUED;
    }

    /**
     * Callback for a message upon reaching the top of the stack
     */
    public void onTop(){
        this.status = MessageStatus.IN_PROGRESS;

    }

    /**
     * Callback for a message upon a safe pop
     */
    public void onPop(){
        this.status = MessageStatus.COMPLETE;

    }

    /**
     * Callback for a message upon a force pop
     */
    public void onForcePop(){
        this.status = MessageStatus.FORCE_POPPED;
    }

    /**
     * Callback for a message upon failing to execute a message
     */
    public void onFail(){
        this.status = MessageStatus.FAILED;
    }
}
