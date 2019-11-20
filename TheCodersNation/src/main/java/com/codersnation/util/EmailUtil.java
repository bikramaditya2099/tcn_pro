package com.codersnation.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	
	static String fromEmail = "admin@thecodersnation.com";
	static Session mysession=inititateSession();
	static Session   inititateSession() {
		final String fromEmail = "admin@thecodersnation.com"; //requires valid gmail id
		final String password = "admin@123"; // correct password for gmail id
		final String toEmail = "bikram.aditya2099@gmail.com"; // can be any email id 
		
		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "mail.thecodersnation.com"); //SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); //SMTP Port
		
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		
		Session session = Session.getDefaultInstance(props, auth);
		mysession=session;
		System.out.println("Session created");
		return session;
	}
	
	public static String createRegistrationTemplate (String name, String pin) {
		
		char[] dgitPin=pin.toCharArray();
		 String registration_pin="<td class=\"esd-stripe\" align=\"center\">\r\n" + 
				"    <table class=\"es-content-body\" style=\"background-color: transparent;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
				"        <tbody>\r\n" + 
				"            <tr>\r\n" + 
				"                <td class=\"esd-structure\" align=\"left\">\r\n" + 
				"                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
				"                        <tbody>\r\n" + 
				"                            <tr>\r\n" + 
				"                                <td class=\"esd-container-frame\" width=\"600\" valign=\"top\" align=\"center\">\r\n" + 
				"                                    <table style=\"border-radius: 3px; border-collapse: separate; background-color: rgb(252, 252, 252);\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#fcfcfc\">\r\n" + 
				"                                        <tbody>\r\n" + 
				"                                            <tr>\r\n" + 
				"                                                <td class=\"esd-block-text es-m-txt-l es-p30t es-p20r es-p20l\" align=\"left\">\r\n" + 
				"                                                    <h2 style=\"color: #0088e8;\">Welcome "+name+" to thecodersnation family</h2>\r\n" + 
				"                                                </td>\r\n" + 
				"                                            </tr>\r\n" + 
				"                                            <tr>\r\n" + 
				"                                                <td class=\"esd-block-text es-p10t es-p20r es-p20l\" bgcolor=\"#fcfcfc\" align=\"left\">\r\n" + 
				"                                                    <p>Please use the below pin to confirm your registration. The pin is valid for 5 minutes.&nbsp; Do not share your pin with any one!</p>\r\n" + 
				"                                                </td>\r\n" + 
				"                                            </tr>\r\n" + 
				"                                        </tbody>\r\n" + 
				"                                    </table>\r\n" + 
				"                                </td>\r\n" + 
				"                            </tr>\r\n" + 
				"                        </tbody>\r\n" + 
				"                    </table>\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            <tr>\r\n" + 
				"                <td class=\"esd-structure es-p30t es-p20r es-p20l\" style=\"background-color: rgb(252, 252, 252);\" esd-custom-block-id=\"15791\" bgcolor=\"#fcfcfc\" align=\"left\">\r\n" + 
				"                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
				"                        <tbody>\r\n" + 
				"                            <tr>\r\n" + 
				"                                <td class=\"esd-container-frame\" width=\"560\" valign=\"top\" align=\"center\">\r\n" + 
				"                                    <table style=\"border-color: rgb(239, 239, 239); border-style: solid; border-width: 1px; border-radius: 3px; border-collapse: separate; background-color: rgb(255, 255, 255);\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\">\r\n" + 
				"                                        <tbody>\r\n" + 
				"                                            <tr>\r\n" + 
				"                                                <td class=\"esd-block-text\" align=\"center\">\r\n" + 
				"                                                    <p style=\"color: #0088e8; font-size: 30px; line-height: 100%;\"><br></p>\r\n" + 
				"                                                    <table border=\"1\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\" style=\"width:500px;\" class=\"cke_show_border\">\r\n" + 
				"                                                        <tbody>\r\n" + 
				"                                                            <tr>\r\n" + 
				"                                                                <td style=\"font-size: 70px; text-align: center;\">"+dgitPin[0]+"</td>\r\n" + 
				"                                                                <td style=\"font-size: 70px; text-align: center;\">"+dgitPin[1]+"</td>\r\n" + 
				"                                                                <td style=\"font-size: 70px; text-align: center;\">"+dgitPin[2]+"</td>\r\n" + 
				"                                                                <td style=\"font-size: 70px; text-align: center;\">"+dgitPin[3]+"</td>\r\n" + 
				"                                                            </tr>\r\n" + 
				"                                                        </tbody>\r\n" + 
				"                                                    </table>\r\n" + 
				"                                                    <p style=\"color: #0088e8; line-height: 100%;\"><br><br></p>\r\n" + 
				"                                                </td>\r\n" + 
				"                                            </tr>\r\n" + 
				"                                        </tbody>\r\n" + 
				"                                    </table>\r\n" + 
				"                                </td>\r\n" + 
				"                            </tr>\r\n" + 
				"                        </tbody>\r\n" + 
				"                    </table>\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"        </tbody>\r\n" + 
				"    </table>\r\n" + 
				"</td>";
		 
		 return registration_pin;
	}
	
	public static String generatePIN() 
	   {

	        //generate a 4 digit integer 1000 <10000
	        int randomPIN = (int)(Math.random()*9000)+1000;

	        //Store integer in a string
	        String PINString = String.valueOf(randomPIN);
	        return PINString;
	    }

//	public static void main(String[] args) {
//		final String fromEmail = "admin@thecodersnation.com"; //requires valid gmail id
//		final String password = "admin@123"; // correct password for gmail id
//		final String toEmail = "bikram.aditya2099@gmail.com"; // can be any email id 
//		
//		System.out.println("SSLEmail Start");
//		Properties props = new Properties();
//		props.put("mail.smtp.host", "mail.thecodersnation.com"); //SMTP Host
//		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
//		props.put("mail.smtp.socketFactory.class",
//				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
//		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
//		props.put("mail.smtp.port", "465"); //SMTP Port
//		
//		Authenticator auth = new Authenticator() {
//			//override the getPasswordAuthentication method
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(fromEmail, password);
//			}
//		};
//		
//		Session session = Session.getDefaultInstance(props, auth);
//		System.out.println("Session created");
//	      //  EmailUtil.sendEmail(session,fromEmail, toEmail,"SSLEmail Testing Subject", createRegistrationTemplate("Bikram",generatePIN()));
//
//	    //    EmailUtil.sendAttachmentEmail(session,fromEmail, toEmail,"SSLEmail Testing Subject with Attachment", "SSLEmail Testing Body with Attachment");
//
//	    //    EmailUtil.sendImageEmail(session,fromEmail, toEmail,"SSLEmail Testing Subject with Image", "SSLEmail Testing Body with Image");
//
//	}
	
	public static void sendEmail( String toEmail, String subject, String body){
		try
	    {
			Session session=null;
			if(mysession==null) {
			 session=inititateSession();
			}
			else
			session=mysession;
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress(fromEmail, "NoReply-TCN"));

	      msg.setReplyTo(InternetAddress.parse(toEmail, false));

	      msg.setSubject(subject, "UTF-8");

	      msg.setContent(body,
	              "text/html");

	      msg.setSentDate(new Date());

	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      System.out.println("Message is ready");
    	  Transport.send(msg);  

	      System.out.println("EMail Sent Successfully!!");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}
	
	public static void sendAttachmentEmail(Session session, String fromEMail, String toEmail, String subject, String body,List<String> files){
		try{
	         MimeMessage msg = new MimeMessage(session);
	         msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
		     msg.addHeader("format", "flowed");
		     msg.addHeader("Content-Transfer-Encoding", "8bit");
		      
		     msg.setFrom(new InternetAddress(fromEMail, "NoReply-TCN"));

		     msg.setReplyTo(InternetAddress.parse(toEmail, false));

		     msg.setSubject(subject, "UTF-8");

		     msg.setSentDate(new Date());

		     msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
		     msg.setContent(body,
		              "text/html");
		      
	         // Create the message body part
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Fill the message
	         messageBodyPart.setContent(body, "text/html");
	         
	         // Create a multipart message for attachment
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Second part is attachment
	         messageBodyPart = new MimeBodyPart();
	         for(String file:files)
	         addAttachements(messageBodyPart, multipart, file);

	         // Send the complete message parts
	         msg.setContent(multipart);

	         // Send message
	         Transport.send(msg);
	         System.out.println("EMail Sent Successfully with attachment!!");
	      }catch (MessagingException e) {
	         e.printStackTrace();
	      } catch (UnsupportedEncodingException e) {
			 e.printStackTrace();
		}
	}

	private static void addAttachements(BodyPart messageBodyPart, Multipart multipart, String filename)
			throws MessagingException {
		DataSource source = new FileDataSource(filename);
		 messageBodyPart.setDataHandler(new DataHandler(source));
		 
		 messageBodyPart.setFileName(filename);
		 multipart.addBodyPart(messageBodyPart);
	}
	
	
	public static void sendImageEmail(Session session,String fromEmail, String toEmail, String subject, String body){
		try{
	         MimeMessage msg = new MimeMessage(session);
	         msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
		     msg.addHeader("format", "flowed");
		     msg.addHeader("Content-Transfer-Encoding", "8bit");
		      
		     msg.setFrom(new InternetAddress(fromEmail, "NoReply-TCN"));

		     msg.setReplyTo(InternetAddress.parse(toEmail, false));

		     msg.setSubject(subject, "UTF-8");

		     msg.setSentDate(new Date());

		     msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
		      
	         // Create the message body part
	         BodyPart messageBodyPart = new MimeBodyPart();

	         messageBodyPart.setText(body);
	         
	         // Create a multipart message for attachment
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Second part is image attachment
	         messageBodyPart = new MimeBodyPart();
	         String filename = "E:\\\\Pictures\\\\_MG_1891.JPG";
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         //Trick is to add the content-id header here
	         messageBodyPart.setHeader("Content-ID", "image_id");
	         multipart.addBodyPart(messageBodyPart);

	         //third part for displaying image in the email body
	         messageBodyPart = new MimeBodyPart();
	         messageBodyPart.setContent("<h1>Attached Image</h1>" +
	        		     "<img src='cid:image_id'>", "text/html");
	         multipart.addBodyPart(messageBodyPart);
	         
	         //Set the multipart message to the email message
	         msg.setContent(multipart);

	         // Send message
	         Transport.send(msg);
	         System.out.println("EMail Sent Successfully with image!!");
	      }catch (MessagingException e) {
	         e.printStackTrace();
	      } catch (UnsupportedEncodingException e) {
			 e.printStackTrace();
		}
	}
}
