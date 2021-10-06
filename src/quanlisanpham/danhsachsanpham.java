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

		JButton btnChinhsua = new JButton("Chỉnh sửa");
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

		JButton btnThongke = new JButton("Thống kê");
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
						" DANH SÁCH SẢN PHẨM", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
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

		JButton btnTimkiem = new JButton("Tìm kiếm");
		Image img12 = new ImageIcon(this.getClass().getResource("/timkiem.png")).getImage();

		btnTimkiem.setIcon(new ImageIcon(img12));
		btnTimkiem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				String text = textTimkiem.getText();
				Connection connect = conn.getConnect();

				if (textTimkiem.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nhập thông tin sản phẩm muốn tìm kiếm!");
				}
				int x = 0;

				if (isNumeric(text)) {

					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Mã sản phẩm");
					model.addColumn("Tên sản phẩm");
					model.addColumn("Xuất xứ");
					model.addColumn("Số lượng (Kg)");
					model.addColumn("Giá tiền (Vnd)");
					try {
						String query = "select * from dbo.QLSP where maSP = " + text;

						Statement st = connect.createStatement();
						ResultSet rs = st.executeQuery(query);
//						if (!textTimkiem.getText().isEmpty()) {
//							if (!rs.next()) {
//								JOptionPane.showMessageDialog(null, "Mã hóa đơn không tồn tại!");
////							} else {
////								// Bỏ code tìm kiếm ở đây
////								model.addRow(new Object[] {
////
////										rs.getString("MaSP"), rs.getString("TenSP"), rs.getString("XuatXu"),
////										rs.getString("Soluong"), rs.getString("Giatien"), });
//							}
//						}

						while (rs.next()) {

							model.addRow(new Object[] {

									rs.getString("MaSP"), rs.getString("TenSP"), rs.getString("XuatXu"),
									rs.getString("Soluong"), rs.getString("Giatien"), });
							x++;
						}

						rs.close();
						st.close();
						connect.close();
						table.setModel(model);
						table.setAutoResizeMode(1);
					} catch (Exception e) {

						System.out.println("Lỗi " + e);
					}

				} else {

					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Mã sản phẩm");
					model.addColumn("Tên sản phẩm");
					model.addColumn("Xuất xứ");
					model.addColumn("Số lượng (Kg)");
					model.addColumn("Giá tiền (Vnd)");
					try {
//						String query = "select * from dbo.QLSP where XuatXu = \'" + text + "\' OR TenSP = \'" + text
//								+ "\'";
						String query = "select * from dbo.QLSP where (XuatXu like \'%" + text + "%\' OR TenSP like \'%" + text + "%\')";

						Statement st = connect.createStatement();
						ResultSet rs = st.executeQuery(query);


						while (rs.next()) {

							model.addRow(new Object[] {

									rs.getString("MaSP"), rs.getString("TenSP"), rs.getString("XuatXu"),
									rs.getString("Soluong"), rs.getString("Giatien"), });
							x++;
						}
						if(x == 0) {
							JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin sản phẩm!");
						}	

						rs.close();
						st.close();
						connect.close();
						table.setModel(model);
						table.setAutoResizeMode(1);
					} catch (Exception e) {

						System.out.println("Lỗi " + e);
					}

				}

			}
		});
		btnTimkiem.setBounds(516, 78, 108, 23);
		frame.getContentPane().add(btnTimkiem);

		JLabel lblNewLabel = new JLabel("DANH SÁCH SẢN PHẨM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 25, 634, 32);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nhập Mã sản phẩm/ Tên sản phẩm/ Xuất xứ muốn tìm kiếm:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setBounds(10, 78, 346, 23);
		frame.getContentPane().add(lblNewLabel_1);

	}

	protected void dispose() {
		// TODO Auto-generated method stub

	}

	public void Showdata() {

		try {

			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Mã sản phẩm");
			model.addColumn("Tên sản phẩm");
			model.addColumn("Xuất xứ");
			model.addColumn("Số lượng (Kg)");
			model.addColumn("Giá tiền (Vnd)");
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

				System.out.println("Lỗi " + e);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
