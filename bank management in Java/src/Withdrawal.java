import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import hu.bme.model.Customer;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Withdrawal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Withdrawal dialog = new Withdrawal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Withdrawal() {
		setTitle("Withdrawal");
		setBounds(100, 100, 725, 513);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 709, 441);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setToolTipText("");
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 709, 37);
		contentPanel.add(panel);

		JLabel label = new JLabel("Welcome to ABC bank ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(60, 179, 113));
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		label.setBounds(147, 11, 399, 17);
		panel.add(label);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Enter ID,Name and click check",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 48, 689, 141);
		contentPanel.add(panel_1);

		JLabel label_1 = new JLabel("ID:");
		label_1.setBounds(54, 21, 20, 14);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel(" Name: ");
		label_2.setBounds(54, 52, 37, 14);
		panel_1.add(label_2);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(184, 18, 225, 20);
		panel_1.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(184, 49, 225, 20);
		panel_1.add(textField_1);
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(522, 18, 114, 109);
		panel_1.add(panel_2);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 114, 109);
		panel_2.add(lblNewLabel);

		JButton button = new JButton("Check");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Name = null;
				String id_Number = null;
				String Password = null;
				/*
				 * String Account_number = null; String Image = null; int
				 * BALANCE = 0; String Address = null; String Account_Type =
				 * null; String Sex = new String(); String ID_type = null;
				 * String DOB = null;
				 */
				Name = textField_1.getText();
				id_Number = textField.getText();
				Password = passwordField.getText();
				try {
					List<Customer> customers = DatabaseConnection.getConnectionDATA(Name, id_Number, Password);
					Customer c = customers.get(0);
					
					  textField_2.setText(c.getName());
					  textField_3.setText(c.getAccountNumber());
					  textField_4.setText(Integer.toString(c.getBalance()));
					 // textField_5.setText(c.getAddress());
					 
					File file = new File(c.getImage());
					Image dimg = ImageIO.read(file);
					Image dimg2 = dimg.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),
							Image.SCALE_SMOOTH);
					lblNewLabel.setIcon(new ImageIcon(dimg2));

				}

				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button.setBounds(185, 107, 89, 23);
		panel_1.add(button);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(54, 82, 79, 14);
		panel_1.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(184, 80, 225, 20);
		panel_1.add(passwordField);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(10, 188, 689, 253);
		contentPanel.add(panel_3);

		JLabel label_3 = new JLabel("Name:");
		label_3.setBounds(59, 14, 37, 14);
		panel_3.add(label_3);

		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(185, 11, 225, 20);
		panel_3.add(textField_2);

		JLabel label_4 = new JLabel("Account Number:");
		label_4.setBounds(10, 45, 123, 14);
		panel_3.add(label_4);

		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(185, 42, 225, 20);
		panel_3.add(textField_3);

		JLabel label_5 = new JLabel("Balance :");
		label_5.setBounds(48, 73, 85, 14);
		panel_3.add(label_5);

		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(185, 70, 225, 20);
		panel_3.add(textField_4);

		JLabel lblWithdrawalAmount = new JLabel("Withdrawal amount :");
		lblWithdrawalAmount.setBounds(10, 104, 123, 14);
		panel_3.add(lblWithdrawalAmount);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(185, 101, 225, 20);
		panel_3.add(textField_5);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 441, 709, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("Update");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Integer balance = Integer.valueOf(textField_4.getText());
						Integer withdrawn = Integer.valueOf(textField_5.getText());
						if (balance-withdrawn>=0)
						{
							balance =balance-withdrawn;
						}
						else 
						{
				 System.out.println("there is no enough money");
					setVisible(false);
						}
						
				try {
					DatabaseConnection.getConnectionupdatebalance(Integer.toString(balance),textField.getText());
					setVisible(false);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}

			JButton btnClear = new JButton("Clear");
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);

				}
			});
			buttonPane.add(btnClear);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
