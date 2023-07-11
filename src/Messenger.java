import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface MessagingService{
    void sendMessage();
}

class SMSMessagingService implements MessagingService{

    @Override
    public void sendMessage() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Number of Reciever : ");
        long number= scanner.nextLong();
        System.out.println("Enter Message Content : ");
        String smsmessage= scanner.next();
        String number_str=String.valueOf(number);
        if(number_str.matches("[6-9]\\d{9}")){
            System.out.println("Sent To : "+number);
            System.out.println("Message : "+smsmessage);
        }
        else{
            System.out.println("Invalid number");
        }
    }
}

class EmailMessagingService implements MessagingService{

    @Override
    public void sendMessage() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Email address of Reciever : ");
        String emailaddress= scanner.next();
        System.out.println("Enter Subject : ");
        String mailSubject= scanner.next();
        System.out.println("Enter Mail Content : ");
        String mailmessage= scanner.next();
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailaddress);
        if(matcher.matches()){
            System.out.println("Sent To : "+emailaddress);
            System.out.println("Subject : "+mailSubject);
            System.out.println("Mail Content : "+mailmessage);
        }
        else{
            System.out.println("Invalid Email address");
        }
    }
}

class WhatsAppMessagingService implements MessagingService{

    @Override
    public void sendMessage() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Number of Reciever : ");
        long number= scanner.nextLong();
        System.out.println("Enter 1 if user exist in Whatsapp else 0");
        int whatsapp_user=scanner.nextInt();
        System.out.println("Enter Message Content : ");
        String whatsapp_message= scanner.next();
        String number_str=String.valueOf(number);
        if(number_str.matches("[6-9]\\d{9}") && whatsapp_user==1){
            System.out.println("Sent To : "+number);
            System.out.println("Message : "+whatsapp_message);
        }
        else if (whatsapp_user==0){
            System.out.println("User does not exist in Whatasapp");
        }
        else{
            System.out.println("Invalid number");
        }
    }
}


public class Messenger {
    public static void main(String[] args) {
        MessagingService smsMessagingService= new SMSMessagingService();
        MessagingService emailMessagingService=new EmailMessagingService();
        MessagingService whatsAppMessagingService = new WhatsAppMessagingService();
        Scanner scanner=new Scanner(System.in);
        int option;
        do{
            System.out.println("Enter 1 to use SMS or 2 to Email or 3 to Whatsapp or 4 to exit : ");
            option=scanner.nextInt();
            if(option==1){
                smsMessagingService.sendMessage();
            }
            else if(option==2){
                emailMessagingService.sendMessage();
            }
            else if(option==3){
                whatsAppMessagingService.sendMessage();
            }
            else if(option==4){
                break;
            }
            else{
                System.out.println("Invalid option");
            }
        }
        while(true);
    }
}
