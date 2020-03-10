//import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;    
class Mailer{  
    public static void send(String from,String password,String to,String sub,String msg){  
          //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setText(msg);    
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    }  
}  
public class SendMailSSL{   
	static String name,mail;
	public SendMailSSL(String s,String m) {
		name=s;
		mail=m;
	}
   //from,password,to,subject,message  
	void SendMSG()
	{
     Mailer.send("AdExBaseInf@gmail.com","AdExbaseinfynity",mail,"Greetings From AdEx","Dear "+name+",\n" + 
     		"\n" + 
     		"Greetings from\n" + 
     		"AdEx!\n" + 
     		"\n" + 
     		"Thanks for subscribing. You'll now get an email each time when we publish new new post. You will regularly informed by mail.\n" + 
     		"\n" + 
     		"Thanks for the being part of MSU AdEx Family\n" + 
     		"\n" + 
     		"Thank You,\n" + 
     		"MSU AdEx"); 
	}
}    