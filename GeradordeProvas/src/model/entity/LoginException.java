package model.entity;

import javax.swing.JOptionPane;

public class LoginException extends Exception{
	public LoginException (String mensagemerro) {
		super(mensagemerro);
		JOptionPane.showMessageDialog(null, "Login incorreto");
	}
}
