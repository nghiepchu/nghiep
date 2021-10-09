package quanlisanpham;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ketnoicsdl.ketnoicsdl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class them extends JFrame {

	private JPanel contentPane;
	private JTextField textmsp;
	private JTextField texttsp;
	private JTextField textxx;
	private JTextField textsl;
	private JTextField textgt;

	ketnoicsdl conn = new ketnoicsdl();
	Connection connect = conn.getConnect();
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					them frame = new them();
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
	public them() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 180, 650, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblThem = new JLabel("TH\u00CAM TH\u00D4NG TIN S\u1EA2N PH\u1EA8M");
		lblThem.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThem.setHorizontalAlignment(SwingConstants.CENTER);
		lblThem.setBounds(0, 24, 634, 36);
		contentPane.add(lblThem);

		JLabel lblmsp = new JLabel("M\u00E3 s\u1EA3n ph\u1EA9m");
		lblmsp.setBounds(158, 86, 82, 20);
		contentPane.add(lblmsp);

		textmsp = new JTextField();
		textmsp.setBounds(285, 86, 158, 20);
		contentPane.add(textmsp);
		textmsp.setColumns(10);

		texttsp = new JTextField();
		texttsp.setColumns(10);
		texttsp.setBounds(285, 117, 158, 20);
		contentPane.add(texttsp);

		JLabel lbltsp = new JLabel("T\u00EAn s\u1EA3n ph\u1EA9m");
		lbltsp.setBounds(158, 117, 82, 20);
		contentPane.add(lbltsp);

		textxx = new JTextField();
		textxx.setColumns(10);
		textxx.setBounds(285, 148, 158, 20);
		contentPane.add(textxx);

		JLabel lblxx = new JLabel("Xu\u1EA5t X\u1EE9");
		lblxx.setBounds(158, 148, 82, 20);
		contentPane.add(lblxx);

		textsl = new JTextField();
		textsl.setColumns(10);
		textsl.setBounds(285, 179, 158, 20);
		contentPane.add(textsl);

		JLabel lblsl = new JLabel("S\u1ED1 l\u01B0\u1EE3ng (Kg)");
		lblsl.setBounds(158, 179, 82, 20);
		contentPane.add(lblsl);

		textgt = new JTextField();
		textgt.setColumns(10);
		textgt.setBounds(285, 210, 158, 20);
		contentPane.add(textgt);

		JLabel lblgt = new JLabel("Gi\u00E1 ti\u1EC1n (Vnd)");
		lblgt.setBounds(158, 210, 82, 20);
		contentPane.add(lblgt);

		JButton btnNewButton = new JButton("Th\u00EAm");
		Image img2 = new ImageIcon(this.getClass().getResource("/them.png")).getImage();

		btnNewButton.setIcon(new ImageIcon(img2));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connect = conn.getConnect();
				try {

					String query1 = "select * from dbo.QLSP";
					Statement st = connect.createStatement();
					ResultSet rs1 = st.executeQuery(query1);

					if (textmsp.getText().isEmpty() || texttsp.getText().isEmpty() || textxx.getText().isEmpty()
							|| textsl.getText().isEmpty() || textgt.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Nhập thông tin muốn thêm !");
					} else {
						int x = 0;
						while (rs1.next()) {
							if (rs1.getString("MaSP").equals(textmsp.getText().toString())) {
								x++;
							}
						}
						if (x != 0) {
							JOptionPane.showMessageDialog(null, "Mã sản phẩm đã tồn tại! Vui lòng nhập lại");
						} else if (x == 0) {
							String query = "insert into dbo.QLSP (MaSP,TenSP,XuatXu,Soluong,Giatien) values (?,?,?,?,?)  ";
							PreparedStatement pst = connect.prepareStatement(query);
							pst.setString(1, textmsp.getText());
							pst.setString(2, texttsp.getText());
							pst.setString(3, textxx.getText());
							pst.setString(4, textsl.getText());
							pst.setString(5, textgt.getText());
							int rs = pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Thêm thành công!");
							pst.close();
							connect.close();
						}

					}
				}

				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(277, 272, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnBack = new JButton("Back");
		Image img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();

		btnBack.setIcon(new ImageIcon(img));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				danhsachsanpham info = new danhsachsanpham();
				danhsachsanpham.main(null);
				dispose();
			}
		});
		btnBack.setBounds(80, 272, 89, 23);
		contentPane.add(btnBack);

		JButton btnExit = new JButton("Exit");
		Image img1 = new ImageIcon(this.getClass().getResource("/thoat.png")).getImage();

		btnExit.setIcon(new ImageIcon(img1));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmsua = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmsua, "Confirm if you want to exit", " THÊM",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(463, 272, 89, 23);
		contentPane.add(btnExit);
	}
}
