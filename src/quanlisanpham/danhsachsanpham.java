package quanlisanpham;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ketnoicsdl.ketnoicsdl;

import javax.swing.JScrollPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class danhsachsanpham<PrepareStatement> {

	private JFrame frame;
	private JTable table;
	private JTextField txtTimkiem;

	ketnoicsdl conn = new ketnoicsdl();
	Connection connect = conn.getConnect();
	DefaultTableModel model = new DefaultTableModel();

	private JTextField textTimkiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					danhsachsanpham window = new danhsachsanpham();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public danhsachsanpham() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
//	
	public static boolean isNumeric(String str) {
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}

	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				Showdata();
			}
		});
		frame.setBounds(400, 180, 650, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 614, 150);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnChinhsua = new JButton("Ch???nh s???a");
		Image img = new ImageIcon(this.getClass().getResource("/sua.png")).getImage();

		btnChinhsua.setIcon(new ImageIcon(img));
		btnChinhsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chinhsua info = new chinhsua();
				chinhsua.main(null);

			}
		});
		btnChinhsua.setBounds(259, 296, 118, 23);
		frame.getContentPane().add(btnChinhsua);

		JButton btnThongke = new JButton("Th???ng k??");
		Image img1 = new ImageIcon(this.getClass().getResource("/thongke.png")).getImage();

		btnThongke.setIcon(new ImageIcon(img1));
		btnThongke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thongke info = new thongke();
				thongke.main(null);

			}

		});
		btnThongke.setBounds(57, 296, 118, 23);
		frame.getContentPane().add(btnThongke);

		JButton btnExit = new JButton("Exit");
		Image img11 = new ImageIcon(this.getClass().getResource("/thoat.png")).getImage();

		btnExit.setIcon(new ImageIcon(img11));
		btnExit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFrame frmdanhsachsanpham = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmdanhsachsanpham, "Confirm if you want to exit",
						" DANH S??CH S???N PH???M", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(467, 296, 118, 23);
		frame.getContentPane().add(btnExit);

		textTimkiem = new JTextField();
		textTimkiem.setBounds(356, 78, 152, 23);
		frame.getContentPane().add(textTimkiem);
		textTimkiem.setColumns(10);

		JButton btnTimkiem = new JButton("T??m ki???m");
		Image img12 = new ImageIcon(this.getClass().getResource("/timkiem.png")).getImage();

		btnTimkiem.setIcon(new ImageIcon(img12));
		btnTimkiem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				String text = textTimkiem.getText();
				Connection connect = conn.getConnect();

				if (textTimkiem.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nh???p th??ng tin s???n ph???m mu???n t??m ki???m!");
				}
				int x = 0;

				if (isNumeric(text)) {

					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("M?? s???n ph???m");
					model.addColumn("T??n s???n ph???m");
					model.addColumn("Xu???t x???");
					model.addColumn("S??? l?????ng (Kg)");
					model.addColumn("Gi?? ti???n (Vnd)");
					try {
						String query = "select * from dbo.QLSP where maSP = " + text;

						Statement st = connect.createStatement();
						ResultSet rs = st.executeQuery(query);

						while (rs.next()) {

							model.addRow(new Object[] {

									rs.getString("MaSP"), rs.getString("TenSP"), rs.getString("XuatXu"),
									rs.getString("Soluong"), rs.getString("Giatien"), });
							x++;
						}
						if (x == 0) {
							JOptionPane.showMessageDialog(null, "M?? s???n ph???m kh??ng t???n t???i! Vui l??ng nh???p l???i!");
						}

						rs.close();
						st.close();
						connect.close();
						table.setModel(model);
						table.setAutoResizeMode(1);
					} catch (Exception e) {

						System.out.println("L???i " + e);
					}

				} else {

					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("M?? s???n ph???m");
					model.addColumn("T??n s???n ph???m");
					model.addColumn("Xu???t x???");
					model.addColumn("S??? l?????ng (Kg)");
					model.addColumn("Gi?? ti???n (Vnd)");
					try {
						String query = "select * from dbo.QLSP where (XuatXu like \'%" + text + "%\' OR TenSP like \'%"
								+ text + "%\')";

						Statement st = connect.createStatement();
						ResultSet rs = st.executeQuery(query);

						while (rs.next()) {

							model.addRow(new Object[] {

									rs.getString("MaSP"), rs.getString("TenSP"), rs.getString("XuatXu"),
									rs.getString("Soluong"), rs.getString("Giatien"), });
							x++;
						}
						if (x == 0) {
							JOptionPane.showMessageDialog(null, "Th??ng tin s???n ph???m kh??ng t???n t???i! Vui l??ng nh???p l???i");
						}

						rs.close();
						st.close();
						connect.close();
						table.setModel(model);
						table.setAutoResizeMode(1);
					} catch (Exception e) {

						System.out.println("L???i " + e);
					}

				}

			}
		});
		btnTimkiem.setBounds(516, 78, 108, 23);
		frame.getContentPane().add(btnTimkiem);

		JLabel lblNewLabel = new JLabel("DANH S??CH S???N PH???M");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 25, 634, 32);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nh???p M?? s???n ph???m/ T??n s???n ph???m/ Xu???t x??? mu???n t??m ki???m:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setBounds(10, 78, 346, 23);
		frame.getContentPane().add(lblNewLabel_1);

	}

	public void Showdata() {

		try {

			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("M?? s???n ph???m");
			model.addColumn("T??n s???n ph???m");
			model.addColumn("Xu???t x???");
			model.addColumn("S??? l?????ng (Kg)");
			model.addColumn("Gi?? ti???n (Vnd)");
			try {
				String query = "select * from dbo.QLSP";
				Statement st = connect.createStatement();
				ResultSet rs = st.executeQuery(query);

				while (rs.next()) {

					model.addRow(new Object[] {

							rs.getString("MaSP"), rs.getString("TenSP"), rs.getString("XuatXu"),
							rs.getString("Soluong"), rs.getString("Giatien"), });
				}
				rs.close();
				st.close();
				connect.close();
				table.setModel(model);
				table.setAutoResizeMode(1);
			} catch (Exception e) {

				System.out.println("L???i " + e);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
