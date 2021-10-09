package quanlisanpham;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	private JPasswordField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 180, 650, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0110\u0102NG NH\u1EACP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 27, 634, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(151, 96, 93, 27);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(151, 150, 93, 33);
		contentPane.add(lblPassword);
		
		textUsername = new JTextField();
		textUsername.setBounds(254, 99, 180, 20);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		 Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
			
			btnLogin.setIcon(new ImageIcon(img));
		btnLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String password = textPassword.getText();
				String username = textUsername.getText();
				if (password.contains("admin") && username.contains("admin")) {
					textPassword.setText(null);
					textUsername.setText(null);
					danhsachsanpham info = new danhsachsanpham();
					danhsachsanpham.main(null);
					dispose();
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Đăng nhập không thành công!","Login Error",JOptionPane.ERROR_MESSAGE);
					textPassword.setText(null);
					textUsername.setText(null);
					
				}
				}
			}
		);
		btnLogin.setBounds(100, 233, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnExit = new JButton("Exit");
		Image img1 = new ImageIcon(this.getClass().getResource("/thoat.png")).getImage();
		
		btnExit.setIcon(new ImageIcon(img1));
		btnExit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				JFrame frmLogin = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLogin,"Confirm if you want to exit","Login ",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(443, 233, 89, 23);
		contentPane.add(btnExit);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(254, 156, 180, 20);
		contentPane.add(textPassword);
		
	}
}
