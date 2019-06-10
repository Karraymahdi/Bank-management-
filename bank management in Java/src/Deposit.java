import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import hu.bme.model.Customer;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Deposit extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Deposit dialog = new Deposit();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Deposit() {
		setTitle("Deposit");
		setBounds(100, 100, 725, 513);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 709, 37);
			getContentPane().add(panel);
			panel.setLayout(null);
			panel.setToolTipText("");
			panel.setBackground(new Color(176, 224, 230));
			{
				JLabel label = new JLabel("Welcome to ABC bank ");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setForeground(new Color(60, 179, 113));
				label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
				label.setBounds(147, 11, 399, 17);
				panel.add(label);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 441, 709, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Integer balance = Integer.valueOf(textField_4.getText());
						balance=balance+Integer.valueOf(textField_5.getText());
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
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
					"Enter ID,Name and click check", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 48, 689, 80);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("ID:");
				lblNewLabel.setBounds(71, 21, 56, 14);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblName = new JLabel(" Name: ");
				lblName.setBounds(54, 52, 100, 14);
				panel.add(lblName);
			}
			{
				textField = new JTextField();
				textField.setBounds(184, 18, 225, 20);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(184, 49, 225, 20);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				JButton btnCheck = new JButton("Check");
				btnCheck.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String Name = null;
						String id_Number = null;
						id_Number = textField.getText();
						Name = textField_1.getText();
				
						try {
							List<Customer> customers = DatabaseConnection.getConnectionDATAaccount(Name, id_Number);
							Customer c = customers.get(0);
							textField_2.setText(c.getName());
							textField_3.setText(c.getAccountNumber());
							textField_4.setText(Integer.toString(c.getBalance()));
						
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnCheck.setBounds(530, 17, 89, 23);
				panel.add(btnCheck);
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
			btnClear.setBounds(530, 48, 89, 23);
			panel.add(btnClear);
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 139, 689, 291);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JLabel lblName_1 = new JLabel("Name:");
				lblName_1.setBounds(59, 14, 74, 14);
				panel.add(lblName_1);
			}
			{
				textField_2 = new JTextField();
				textField_2.setEnabled(false);
				textField_2.setColumns(10);
				textField_2.setBounds(185, 11, 225, 20);
				panel.add(textField_2);
			}
			{
				JLabel lblAccountNumber = new JLabel("Account Number:");
				lblAccountNumber.setBounds(10, 45, 123, 14);
				panel.add(lblAccountNumber);
			}
			{
				textField_3 = new JTextField();
				textField_3.setEnabled(false);
				textField_3.setColumns(10);
				textField_3.setBounds(185, 42, 225, 20);
				panel.add(textField_3);
			}
			{
				JLabel lblBalance = new JLabel("Balance :");
				lblBalance.setBounds(48, 73, 85, 14);
				panel.add(lblBalance);
			}
			{
				textField_4 = new JTextField();
				textField_4.setEnabled(false);
				textField_4.setColumns(10);
				textField_4.setBounds(185, 70, 225, 20);
				panel.add(textField_4);
			}
			{
				JLabel lblDepositAmount = new JLabel("Deposit amount :");
				lblDepositAmount.setBounds(10, 104, 137, 14);
				panel.add(lblDepositAmount);
			}
			{
				textField_5 = new JTextField();
				textField_5.setColumns(10);
				textField_5.setBounds(185, 101, 225, 20);
				panel.add(textField_5);
			}
		}
	}
}
