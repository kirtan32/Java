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

public class HTMLMail 
{
	String to;
	String event;
	String faculty;
	String path="/home/kirtan/eclipse-workspace/MSU_AD_Sense/Faculty/";
	String postname;
	String finalimgurl;
	String desctxt,content;
	String exten;
	HTMLMail(String to,String faculty,String event,String postname,String exten,String desctxt)
	{
		this.to=to;
		this.event=event;
		this.faculty=faculty;
		this.postname=postname;
		this.exten=exten;
		this.desctxt=desctxt;
		String s[]=desctxt.split("\n");
		content="";
		for(int i=0;i<s.length;i++)
		{
			s[i]="<h3>"+s[i]+"</h3>";
			content=content+s[i];
		}
	}
	public void sendMail()
	{
		finalimgurl=path+faculty+"/"+event+"/"+postname+"/Imagemain."+exten;
		System.out.println(finalimgurl);
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
			msg.setSubject("New Post Out");
			//msg.setContent("<h1><i> This is mail</i></h1>","text/html");
			String htmlText="<html>"+
					"	<head>"+	
					"        <style>\n" + 
					"            body{\n" + 
					"                \n" +            
					"            }\n" + 
					"            h1{\n" + 
					"                color: black;\n" + 
					"                text-align: center;\n" + 
					"            }\n" + 
					"            h2{\n" + 
					"                color: darkmagenta;\n" + 
					"                text-align: center;\n" + 
					"            }\n" +
					"            h4{\n" + 
					"                color: black;\n" + 
					"                text-align: center;\n" + 
					"            }\n" +
					"            img{\n" + 
					"                width: auto ;\n" + 
					"                max-width: 100% ;\n" + 
					"                height: auto ;\n" + 
					"                border: none;\n" + 
					"                align-content: center;\n" + 
					"            }\n" + 
					"            h3{\n" + 
					"                color: black;\n" + 
					"                text-align: center;\n" + 
					"            }\n" + 
					"		</style>\n" + 
					"	</head>\n" + 
					"	<body>\n" + 
					"        <h2> Updation From "+event+"</h2>\n" + 
					"        <h4> "+faculty+"</h4>\n" + 
					"        <h2> "+postname+"</h2>\n"+
					"<img src=\"cid:image\">"+ 
					"               \n"+content+"" + 
					"	</body>\n" + 
					"</html>\n" + 
					"\n";
			MimeMultipart multipart = new MimeMultipart("related");
	         BodyPart messageBodyPart = new MimeBodyPart();
	         messageBodyPart.setContent(htmlText, "text/html");
	         multipart.addBodyPart(messageBodyPart);
	         messageBodyPart = new MimeBodyPart();
	         DataSource fds = new FileDataSource(
	            finalimgurl);

	         messageBodyPart.setDataHandler(new DataHandler(fds));
	         messageBodyPart.setHeader("Content-ID", "<image>");
	         multipart.addBodyPart(messageBodyPart);
	         msg.setContent(multipart);
			Transport.send(msg);
			System.out.println("Send Success"+"");
		}
		catch(Exception e)
		{
			
		}
	}
}
