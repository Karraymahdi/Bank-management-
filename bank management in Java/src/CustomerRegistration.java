import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Random;
import java.awt.event.ActionEvent;

/*
import marvin.gui.MarvinImagePanel;
import marvin.image.MarvinImage;
import marvin.video.MarvinJavaCVAdapter;
import marvin.video.MarvinVideoInterface;*/

public class CustomerRegistration extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CustomerRegistration dialog = new CustomerRegistration();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CustomerRegistration() {
		setTitle("New customer");
		setBounds(100, 100, 725, 513);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registration ",
				TitledBorder.LEADING, TitledBorder.BOTTOM, null, new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 709, 37);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblWelcomeToAbc = new JLabel("Welcome to ABC bank ");
		lblWelcomeToAbc.setBounds(147, 11, 399, 17);
		lblWelcomeToAbc.setForeground(new Color(60, 179, 113));
		lblWelcomeToAbc.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToAbc.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		panel.add(lblWelcomeToAbc);
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(0, 47, 709, -10);
			contentPanel.add(separator);
		}

		textField = new JTextField();
		textField.setBounds(145, 60, 281, 20);
		contentPanel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(145, 85, 281, 20);
		contentPanel.add(textField_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Select account type ");
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Junior", "Employer " }));
		comboBox.setBounds(145, 111, 281, 20);
		contentPanel.add(comboBox);
		{
			JLabel lblSex = new JLabel("Sex:");
			lblSex.setBounds(59, 139, 34, 14);
			contentPanel.add(lblSex);
		}
		{
			JLabel lblNewLabel = new JLabel("Name :");
			lblNewLabel.setBounds(47, 63, 61, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblAccountType = new JLabel("Account type :");
			lblAccountType.setBounds(7, 114, 101, 14);
			contentPanel.add(lblAccountType);
		}
		{
			JLabel lblAddress = new JLabel("Address:");
			lblAddress.setBounds(35, 88, 100, 14);
			contentPanel.add(lblAddress);
		}

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(145, 135, 109, 23);
		contentPanel.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(317, 135, 109, 23);
		contentPanel.add(rdbtnNewRadioButton_1);

		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(66, 164, 42, 14);
		contentPanel.add(lblNewLabel_1);

		textField_2 = new JTextField();
		textField_2.setBounds(273, 161, 157, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Day", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31" }));
		comboBox_1.setBounds(145, 186, 61, 20);
		contentPanel.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(
				new String[] { "Month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		comboBox_2.setBounds(226, 186, 61, 20);
		contentPanel.add(comboBox_2);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "Year ", "1960", "1961", "1962", "1963", "1964",
				"1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977",
				"1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990",
				"1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003",
				"2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016",
				"2017" }));
		comboBox_3.setBounds(309, 186, 61, 20);
		contentPanel.add(comboBox_3);

		JLabel label = new JLabel("Password:");
		label.setBounds(31, 214, 77, 14);
		contentPanel.add(label);

		passwordField = new JPasswordField();
		passwordField.setBounds(145, 211, 281, 20);
		contentPanel.add(passwordField);

		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setToolTipText("Select ID type");
		comboBox_4.setModel(
				new DefaultComboBoxModel(new String[] { "Passport ", "Residance permit ", "Identity card " }));
		comboBox_4.setBounds(145, 161, 109, 20);
		contentPanel.add(comboBox_4);

		JLabel lblDob = new JLabel("DOB   :");
		lblDob.setBounds(47, 189, 46, 14);
		contentPanel.add(lblDob);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(557, 74, 95, 104);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 95, 104);
		panel_1.add(lblNewLabel_2);

		JFileChooser file_chooser = new JFileChooser();
		JButton btnBrowse = new JButton("Browse ");

		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int result = file_chooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File file = file_chooser.getSelectedFile();

					try {
						Image dimg = ImageIO.read(file);
						Image dimg2 = dimg.getScaledInstance(lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight(),
								Image.SCALE_SMOOTH);
						lblNewLabel_2.setIcon(new ImageIcon(dimg2));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnBrowse.setBounds(558, 210, 95, 23);
		contentPanel.add(btnBrowse);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Register");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String s = null;
						if (rdbtnNewRadioButton.isSelected())
							s = "male";
						else
							s = "femme";

						try {
							Random generator = new Random(System.currentTimeMillis());
							 int acctNum = generator.nextInt(1000000000) + 999999999;   
							
							String path = file_chooser.getSelectedFile().getPath();
							DatabaseConnection.getConnectioninsert(textField.getText(), textField_1.getText(),
									(String) comboBox.getSelectedItem(), s, (String) comboBox_4.getSelectedItem(),
									textField_2.getText(),
									(String) comboBox_1.getSelectedItem() + "/" + (String) comboBox_2.getSelectedItem()
											+ "/" + (String) comboBox_3.getSelectedItem(),
									passwordField.getText(), Integer.toString(acctNum), path);
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
					passwordField.setText(null);
					textField_2.setText(null);
					comboBox.setSelectedIndex(0);
					comboBox_1.setSelectedIndex(0);
					comboBox_2.setSelectedIndex(0);
					comboBox_3.setSelectedIndex(0);
					comboBox_4.setSelectedIndex(0);
					buttonGroup.clearSelection();

				}
			});
			buttonPane.add(btnClear);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
