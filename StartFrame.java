package Page1;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPlayerX;
	private JTextField txtPlayerO;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartFrame frame = new StartFrame();
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
	public StartFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		//setSize(550,400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tic-Tac-Toe");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(150, 28, 200, 23);
		contentPane.add(lblNewLabel);
		
		txtPlayerX = new JTextField();
		txtPlayerX.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtPlayerX.setText("Player X");
		txtPlayerX.setBounds(261, 108, 86, 34);
		contentPane.add(txtPlayerX);
		txtPlayerX.setColumns(10);
		
		txtPlayerO = new JTextField();
		txtPlayerO.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtPlayerO.setText("Player O");
		txtPlayerO.setBounds(63, 108, 86, 34);
		contentPane.add(txtPlayerO);
		txtPlayerO.setColumns(10);
		
		JLabel errorlabel = new JLabel();
		errorlabel.setBounds(45, 215, 350, 25);
		errorlabel.setForeground(Color.RED);
		contentPane.add(errorlabel);
		JButton btnNewButton = new JButton("Start Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
			     System.out.println("Button clicked!");

			        JOptionPane.showMessageDialog(null, "Button works!");
			        */
		
			String playerX=	txtPlayerX.getText().trim();
			String playerO = txtPlayerO.getText().trim();
		
			//StartFrame.this.dispose();
			
		
				if (playerX.isEmpty() || playerO.isEmpty()
			            || playerX.equals("Player X")
			            || playerO.equals("Player O")) {

			        errorlabel.setForeground(Color.RED);
			        errorlabel.setText("Error: Enter both players names");

			    } 
				else {

			        errorlabel.setText("");
			        JOptionPane.showMessageDialog(null, "Welcome to the game!");
			        
			        Game game = new Game(playerX, playerO);
			        GameFrame frame = new GameFrame(game);
			        frame.setVisible(true);
			        StartFrame.this.dispose();
			}}
		  });
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(159, 174, 113, 40);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.GREEN);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(46, 74, 113, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter your Name :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBackground(Color.DARK_GRAY);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(261, 74, 113, 34);
		contentPane.add(lblNewLabel_2);

	}
}
