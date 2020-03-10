import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendHtmlEmail
{
	public static void main(String st[])
	{
		String to="shahkirtan742@gmail.com";
		String from="AdExBaseInf@gmail.com";
		Properties prop = new Properties();
		prop.put("mail.smtp.auth","true");
		prop.put("mail.smtp.starttls.enable","true");
		prop.put("mail.smtp.host","smtp.gmail.com");
		prop.put("mail.smtp.port", 587);
		
		Session sess= Session.getDefaultInstance(prop,new javax.mail.Authenticator()
				{
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("AdExBaseInf@gmail.com","AdExbaseinfynity");
					}
			
				});
		try
		{
			MimeMessage msg=new MimeMessage(sess);
			msg.setFrom(new InternetAddress(from));
			msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			msg.setSubject("HTML Mail");
			//msg.setContent("<h1><i> This is mail</i></h1>","text/html");
			msg.setContent("<h1> HELLO </h1>","text/html");
			MimeMultipart multipart = new MimeMultipart("related");

	         // first part (the html)
	         BodyPart messageBodyPart = new MimeBodyPart();
	         String htmlText = "<H1>Hello</H1><img src=\"cid:image\">";
	         messageBodyPart.setContent(htmlText, "text/html");
	         // add it
	         multipart.addBodyPart(messageBodyPart);

	         // second part (the image)
	         messageBodyPart = new MimeBodyPart();
	         DataSource fds = new FileDataSource(
	            "/home/kirtan/eclipse-workspace/MSU_AD_Sense/img/ex/1.jpg");

	         messageBodyPart.setDataHandler(new DataHandler(fds));
	         messageBodyPart.setHeader("Content-ID", "<image>");

	         // add image to the multipart
	         multipart.addBodyPart(messageBodyPart);

	         // put everything together
	         msg.setContent(multipart);
			Transport.send(msg);
			System.out.println("Send Success");
		}
		catch(Exception e)
		{
			
		}
	}
}






















