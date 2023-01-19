package converter;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Converter extends JFrame {

	private JFrame frmSmartconverter;
	private JTextField textField;
	private JTextField txtHexadecimal;
	private JTextField txtBinary;
	private JTextField txtDecimal;
	private JLabel lblHexadecimal;
	private JLabel lblBinary;
	private JLabel lblDecimal;
	
	
	public void konvertuj(JComboBox cb) throws Exception{
		
		if(cb.getSelectedItem()=="Decimal")
		{
		{
		try {

			int decimal = Integer.parseInt(textField.getText());
		    
		    if(decimal<0)
		    {
		    String hexadecimal = Integer.toHexString(-decimal);
		    String binary = Integer.toBinaryString(-decimal);
		    txtHexadecimal.setText("-"+hexadecimal);
		    txtBinary.setText("-"+binary);
		    txtDecimal.setText(Integer.toString(decimal));
		    }
		    else {
		    String hexadecimal = Integer.toHexString(decimal);
		    String binary = Integer.toBinaryString(decimal);
			txtHexadecimal.setText(hexadecimal);
			txtBinary.setText(binary);
			txtDecimal.setText(Integer.toString(decimal));
		    }
			}
		catch(NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(frmSmartconverter,"GRESKA!\nUnesite dekadni broj!\n" + ex.getMessage(), "Greska",JOptionPane.ERROR_MESSAGE);
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(frmSmartconverter,"Pogresan unos!\n" + ex.getMessage(), "Greska",JOptionPane.ERROR_MESSAGE);
		}
		}
		}
		else if(cb.getSelectedItem()=="Binary")
		{
		try {
			
			String binary = textField.getText();
			int decimal = Integer.parseInt(binary, 2);
			if(decimal<0)
			{
			
				 String hexadecimal = Integer.toHexString(-decimal);
				 
				 txtHexadecimal.setText("-"+hexadecimal);
				 txtBinary.setText(binary);
				 txtDecimal.setText(Integer.toString(decimal));
			}
		    else {
				 String hexadecimal = Integer.toHexString(decimal);
			     txtHexadecimal.setText(hexadecimal);
				 txtBinary.setText(binary);
				 txtDecimal.setText(Integer.toString(decimal));
			}
		}
		catch(NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(frmSmartconverter,"GRESKA!\nUnesite binarni broj!\n" + ex.getMessage(), "Greska",JOptionPane.ERROR_MESSAGE);
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(frmSmartconverter,"Pogresan unos!\n" + ex.getMessage(), "Greska",JOptionPane.ERROR_MESSAGE);
		}
		}
		else if(cb.getSelectedItem()=="Hexadecimal")
		{
		try {
			
			String hexadecimal = textField.getText();
			int decimal = Integer.parseInt(hexadecimal,16);
			if(decimal<0)
			{
			
				 String binary = Integer.toBinaryString(-decimal);
				 
				 txtHexadecimal.setText(hexadecimal);
				 txtBinary.setText("-"+binary);
				 txtDecimal.setText(Integer.toString(decimal));
			}
		    else {
		    	String binary = Integer.toBinaryString(decimal);
			     txtHexadecimal.setText(hexadecimal);
				 txtBinary.setText(binary);
				 txtDecimal.setText(Integer.toString(decimal));
				 
		    }
			}
		catch(NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(frmSmartconverter,"GRESKA!\nUnesite heksadecimalni broj!\n" + ex.getMessage(), "Greska",JOptionPane.ERROR_MESSAGE);
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(frmSmartconverter,"Pogresan unos!\n" + ex.getMessage(), "Greska",JOptionPane.ERROR_MESSAGE);
		}
		}
		
	}
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Converter window = new Converter();
					window.frmSmartconverter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Converter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSmartconverter = new JFrame();
		frmSmartconverter.setTitle("Smart Converter");
		frmSmartconverter.setBounds(100, 100, 350, 228);
		frmSmartconverter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSmartconverter.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmSmartconverter.getContentPane().add(panel, BorderLayout.CENTER);
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Decimal", "Binary", "Hexadecimal"}));
		
		JLabel label1 = new JLabel("Enter number for conversion:");
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					try {
						konvertuj(comboBox);
					} catch (Exception e1) {
						
						JOptionPane.showMessageDialog(frmSmartconverter, e1.getMessage(), "Greska",JOptionPane.WARNING_MESSAGE);
					}
					
				}
			}
		});
		textField.setColumns(10);
		
		txtHexadecimal = new JTextField();
		txtHexadecimal.setEditable(false);
		txtHexadecimal.setText("Hexadecimal");
		txtHexadecimal.setColumns(10);
		
		
		txtBinary = new JTextField();
		txtBinary.setText("Binary");
		txtBinary.setEditable(false);
		txtBinary.setColumns(10);
		
		txtDecimal = new JTextField();
		txtDecimal.setText("Decimal");
		txtDecimal.setEditable(false);
		txtDecimal.setColumns(10);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					konvertuj(comboBox);
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(frmSmartconverter, e1.getMessage(), "Greska",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});

		lblHexadecimal = new JLabel("Hexadecimal:");
		
		lblBinary = new JLabel("Binary:");
		
		lblDecimal = new JLabel("Decimal:");
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(114)
							.addComponent(btnConvert, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addComponent(label1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblHexadecimal)
										.addComponent(lblBinary)
										.addComponent(lblDecimal))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtBinary, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
										.addComponent(txtDecimal, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
										.addComponent(txtHexadecimal, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))))))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHexadecimal)
						.addComponent(txtHexadecimal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtBinary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBinary))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDecimal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDecimal))
					.addGap(11)
					.addComponent(btnConvert, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		

	}
}
