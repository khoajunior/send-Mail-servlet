package javaMailServlet.javamail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtil {
	public static void sendMail(String recepient) throws MessagingException {
		System.out.println("chuẩn bị gửi");
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port","587");
		
		String myAccount= "phamminhkhoaiuh@gmail.com";
		String password = "A963852741";
		
		Session session = Session.getInstance(properties,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(myAccount, password);
			}
		});
		
		Message message = preparMessage(session,myAccount,recepient);
		
		Transport.send(message);
		System.out.println("gửi thành công");
	}

	private static Message preparMessage(Session session, String myAccount, String recepient) {
		// TODO Auto-generated method stub
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccount));
			message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
			message.setSubject("LẦN ĐẦU GỬI EMAIL");
			message.setText("chào bạn , \n nhìn mail của t đi");
			return message;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
