package com_DemoActiTime_Tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.sql.DataSource;

import org.testng.annotations.Test;

public class Demo7 
{
	@Test
	public void TestA() throws Exception
	{
			
		//load the properties
		Properties p = new Properties();
		p.load(new FileInputStream(new File("./settings.properties")));
		//create a session
		Session session = Session.getInstance(p, new mailConfigur());
		
		//create a mail
		MimeMessage mail = new MimeMessage(session);
		
		//add recipient
		InternetAddress to = new InternetAddress("hadeebataj@gmail.com");
		mail.addRecipient(RecipientType.TO, to);
		
		//add subject
		mail.setSubject("sending email from Selenium code");
		
		//add body
		mail.setText("my first mail");
		
		//add attachment
/*		MimeMultipart multipart = new MimeMultipart();
		MimeBodyPart bp = new MimeBodyPart();
		DataSource ds = new FileDataSource("D:\\C Data\\Nadeem\\AutomationScripts\\DemoActiTime\\dataDrivenTestng.png");
		bp.setDataHandler(new DataHandler(ds));
		bp.setFileName("my photo");
		multipart.addBodyPart(bp);
		mail.setContent(multipart); */
		
		
		
		//send mail
		Transport.send(mail);
		
		System.out.println("done");
	}
		

}
