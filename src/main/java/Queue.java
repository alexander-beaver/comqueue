import java.util.ArrayList;

public class Queue {
    public ArrayList<BaseMessage> messages = new ArrayList<>();
    public ArrayList<BaseMessage> messageHistory = new ArrayList<>();
    public Queue(){
        messages = new ArrayList<>();
        messageHistory = new ArrayList<>();
    }
    public void newEntry(BaseMessage message){

        messages.add(message);
        messages.get(messages.size()-1).onCreate();
        messageHistory.add(messages.get(messages.size()-1));
        onUpdate();

    }
    public void pop(){
        if(messages.size() > 0){
            messages.get(0).onPop();
            messageHistory.add(messages.get(0));
            messages.remove(0);
        }
        onUpdate();

    }
    public void clear(){
        for(int i = 0; i < messages.size(); i++){
            messages.get(0).onPop();
            messageHistory.add(messages.get(0));
            messages.remove(0);
        }
        onUpdate();
    }
    public void forceClear(){
        for(int i = 0; i < messages.size(); i++){
            messages.get(0).onForcePop();
            messageHistory.add(messages.get(0));
            messages.remove(0);
        }
        onUpdate();
    }
    public BaseMessage getActive(){

        try{
            return messages.get(0);

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    private void onUpdate(){
        if(messages.size() > 0 && messages.get(0).getStatus() != MessageStatus.IN_PROGRESS){
            messages.get(0).onTop();

        }
    }
}
