package org.example.People;

public class CustomerSupporter extends Staff{
    public void answerUser(User u){
        if(u.getAsksHelp() == true){
            System.out.println("Chat started");
        } else {
            System.out.println("User hasnt asked for Help!");
        }
    }

    public void finishSupport(User u){
        if(u.getAsksHelp() == false){
            System.out.println("There is no ongoing Support");
            return;
        }
        System.out.println("Chat ended");
        u.setAsksHelp(false);
    }


}
