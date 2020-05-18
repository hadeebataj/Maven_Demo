package com_DemoActiTime_Tests;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class mailConfigur extends Authenticator
{
	public PasswordAuthentication getPasswordAuthentication()
	{
		String userName = "hadeebataj";
		String password = "Alohomora1!";
		PasswordAuthentication p = new PasswordAuthentication(userName, password);
		return p ;
	}
}