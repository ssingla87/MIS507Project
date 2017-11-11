package com.eller.mis507.entities;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.eller.mis507.observers.MovieRatingObserver;
import com.eller.mis507.searchcriteria.UserType;

public abstract class User implements MovieRatingObserver {

	private String firstName;

	private String lastName;

	private String email;

	private UserType usertype;

	protected Movie movie;

	protected User(String firstName, String lastName, String email, UserType usertype) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.usertype = usertype;
	}

	/**
	 * @return the firstName
	 */
	protected String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	protected String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	protected String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	protected void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the usertype
	 */
	public UserType getUsertype() {
		return usertype;
	}

	/**
	 * @param usertype
	 *            the usertype to set
	 */
	public void setUsertype(UserType usertype) {
		this.usertype = usertype;
	}

	@Override
	public void setMovieToObserve(Movie movie) {
		// TODO Auto-generated method stub
		this.movie = movie;
	}

	@Override
	public void updateObserver() {
		// TODO Auto-generated method stub
		sendEmail(this.getEmail());

	}

	private void sendEmail(String recieverEmail) {
		// Get the session object
		final String username = "mis507teamproject@gmail.com";
		final String password = "mis507teamprojectpassword";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
//		Session session = Session.getDefaultInstance(props);
		
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });

		try {
			String senderEmail = username;
			MimeMessage message = constructMessage(session, senderEmail, recieverEmail);

			// Send message
			Transport.send(message);
			System.out.println("message sent successfully....");

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	private MimeMessage constructMessage(Session session, String senderEmail, String recieverEmail)
			throws MessagingException, AddressException {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(senderEmail));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(recieverEmail));
		message.setSubject("List of movies updated");
		message.setText(this.movie.toString());
		return message;
	}

}
