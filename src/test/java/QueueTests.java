import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTests {


   @Test
    public void position(){
       IntegerPositionQueue pq = new IntegerPositionQueue();
       pq.newEntry(new IntegerMessage(0)); //Action 1
       assertEquals(0, pq.getActive().getValue());
       assertEquals(MessageStatus.IN_PROGRESS, pq.getActive().getStatus());
       pq.newEntry(new IntegerMessage(1)); //Action 2, 3
       assertEquals(1, pq.getActive().getValue());
       pq.forceClear(); //Action 4
       assertEquals(null, pq.getActive());
       pq.pop();
       pq.newEntry(new IntegerMessage(2)); //Action 5
       assertEquals(5,pq.messageHistory.size());
       assertEquals(MessageStatus.COMPLETE, pq.messageHistory.get(0).getStatus());
   }

   @Test
   public void target(){
      IntegerQueue tq = new IntegerQueue();
      tq.newEntry(new IntegerMessage(0));
      assertEquals(0, tq.getActive().getValue());
      assertEquals(MessageStatus.IN_PROGRESS, tq.getActive().getStatus());
      tq.newEntry(new IntegerMessage(1));
      assertEquals(2, tq.messageHistory.size());
      tq.pop();
      assertEquals(3, tq.messageHistory.size());
      assertEquals(1, tq.getActive().getValue());
      assertEquals(MessageStatus.IN_PROGRESS, tq.getActive().getStatus());
      assertEquals(MessageStatus.COMPLETE, tq.messageHistory.get(tq.messageHistory.size()-1).getStatus());

   }
}