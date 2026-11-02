package Page1;
import javax.swing.*;
import java.awt.*;

import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String player1;
	private String player2;
	
	public Game game;
	public Board b;
	String currentPlayer;
	boolean gameover=false;
	int turns=0;
	boolean vsComputer = true;//comp
	JButton board[][];
	
	//default constructor
GameFrame(){
}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game game = new Game("Player X","Player O");
					GameFrame frame = new GameFrame(game);
					frame.setTitle("Tic-Tac-Toe");
					frame.setLocationRelativeTo(null);
				frame.setSize(550,400);
				StartFrame f = new StartFrame(); 
					f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	JLabel textLabel;
	JButton btnReset;
	JButton restart;
	JLabel pointPlayer1;
	JLabel pointPlayer2;
	JLabel draw;
	JLabel title;
	JLabel time;
	Timer timer;
	int second = 30;

	/**
	 * Create the frame.
	 */
	public GameFrame(Game game) {
		//Connect
	    this.game = game;
	    this.b = new Board();
	    player1 = game.getPlayer1();
	    player2 = game.getPlayer2();
	    currentPlayer = "X";
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setBackground(Color.DARK_GRAY);
		contentPane.setBackground(Color.DARK_GRAY);
		
		//show whose turn it is
		textLabel = new JLabel("");
		textLabel.setOpaque(true);
		textLabel.setBounds(0, 0, 434, 52);
		textLabel.setBackground(Color.DARK_GRAY);
		textLabel.setForeground(Color.WHITE);
		textLabel.setFont(new Font("Arial",Font.BOLD,20));
		contentPane.add(textLabel);
		
		//point player1
		pointPlayer1= new JLabel(player1 + " : "+ game.getScore1());
		pointPlayer1.setBounds(20, 35, 180, 30);
		pointPlayer1.setBackground(Color.PINK);
		pointPlayer1.setForeground(Color.pink);
		pointPlayer1.setFont(new Font("Arial",Font.BOLD,12));
		contentPane.add(pointPlayer1);
		
		//point player2
		pointPlayer2= new JLabel(player2 + " : "+ game.getScore2());
		pointPlayer2.setBounds(300, 35, 120, 30);
		pointPlayer2.setBackground(Color.PINK);
		pointPlayer2.setForeground(Color.PINK);
		pointPlayer2.setFont(new Font("Arial",Font.BOLD,12));
		contentPane.add(pointPlayer2);
		
		//draw
		draw=new JLabel("Draws :"+ game.getDraws());
		draw.setBounds(150, 32, 150, 30);
		draw.setBackground(Color.PINK);
		draw.setForeground(Color.PINK);
		contentPane.add(draw);
		
		//title
		title= new JLabel("Tic-Tac-Toe");
		title.setBounds(0, 0, 434, 35);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setBackground(Color.GRAY);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(title);
		
		
		//Timer (label)
		time= new JLabel("Timer : ");
		time.setBounds(10, 0, 150, 35);//
		time.setBackground(Color.GRAY);
		time.setForeground(Color.GREEN);
		time.setFont(new Font("Arial", Font.BOLD,12));
		contentPane.add(time);
		
		//panels
		JPanel textPanel = new JPanel();
		textPanel.setBounds(0, 0, 434, 45);
		textPanel.setBackground(Color.DARK_GRAY);
		textPanel.setLayout(new BorderLayout());
		textPanel.add(textLabel,BorderLayout.EAST);
		contentPane.setLayout(null);
		contentPane.add(textPanel,BorderLayout.NORTH);
	
		JPanel boardpanel = new JPanel();
		boardpanel.setBounds(70, 60, 290, 190);
		boardpanel.setLayout(new GridLayout(3, 3, 5, 5));
		boardpanel.setBackground(Color.DARK_GRAY);
		contentPane.add(boardpanel);
		
		
		
		//Reset Button
		btnReset = new JButton("Reset");
		btnReset.setBounds(220, 260, 80, 30);
		btnReset.setBackground(Color.DARK_GRAY);
		btnReset.setForeground(Color.GREEN);
		contentPane.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		     //  b.reset();
		    	b.resetBoard(board);
		    	gameover=false;
		    	turns=0;
		    	currentPlayer="X";
		    	textLabel.setText("");//<<<<<>>>>>>
		    }
		});
		
		//Restart Button
	
		restart=new JButton("Restart");
		restart.setBounds(100, 260, 80, 30);
		restart.setBackground(Color.DARK_GRAY);
		restart.setForeground(Color.PINK);
		contentPane.add(restart);
		restart.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				b.reset();
				b.resetBoard(board);
				StartFrame s = new StartFrame();
				  s.setLocationRelativeTo(null);
				  s.setVisible(true);
				  dispose();
			  }
		});

		board = new JButton[3][3];
		for(int r =0;r<board.length;r++) {
		for(int c=0;c<board[r].length;c++) {
			
			board[r][c]=  new JButton("");
			board[r][c].setFont(new Font("Arial",Font.BOLD,30));
			board[r][c].setBackground(Color.DARK_GRAY);
			board[r][c].setForeground(Color.WHITE);
			board[r][c].setFocusable(false);
			boardpanel.add(board[r][c]);
			//board[r][c].setText(CurrentPlayer);
		
			board[r][c].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e ) {
					if(gameover) return;
					JButton tile = (JButton) e.getSource();
					if(tile.getText().isEmpty()) {
						tile.setText(currentPlayer);
						textLabel.setText(currentPlayer+ " 's turn");
						//change color
						if(currentPlayer.equals("X")) {
							textLabel.setForeground(Color.RED);
						}else {
							textLabel.setForeground(Color.BLUE);
						}

						if (currentPlayer.equals("X")) {
						    tile.setForeground(Color.RED);
						} else {
						    tile.setForeground(Color.BLUE);
						}
						turns++;
						checkWinner();
					
						if(!gameover) {
							currentPlayer= currentPlayer.equals("X") ? "O" : "X";
							if (vsComputer && currentPlayer.equals("O")) {
							computer();
						    } else {
						        changeTimer();
						    }
						//	textLabel.setText(CurrentPlayer+ "'s turn");
							changeTimer();
							
						} 
					}
				
				}
				
			});
	}

}
		
		changeTimer();

}
public void changeTimer() {
		second=30;
		if(timer!=null) {
			timer.stop();
		}
		timer = new Timer(880, new ActionListener() {
			public void  actionPerformed(ActionEvent e ) {
				second--;
				time.setText("Timer :" + second);
				if(second<=0) {
					timer.stop();
					gameover= true;
				}
			}
		});
		timer.start();
	}
//Method checkwinner
	public String checkWinner() {
	for(int r =0;r<3;r++) {
		if(board[r][0].getText()=="") continue;
		if(board[r][0].getText()==board[r][1].getText() && board[r][1].getText()== board[r][2].getText()) {
			  for (int i = 0; i < 3; i++) {
			        setWinner(board[r][i]);
			    }
			  if (currentPlayer.equals("X")) {
				    game.addWin(1);
				} else {
				    game.addWin(2);
				}
			  pointPlayer1.setText(player1 + ": " + game.getScore1());
			  pointPlayer2.setText(player2 + ": " + game.getScore2());
			    JOptionPane.showMessageDialog(this, currentPlayer + " is the winner");
			    if (timer != null) {
			        timer.stop();
			    }
			    gameover = true;
			    return currentPlayer;
			}
		}

	//vertical
	for(int c=0;c<3;c++) {
		if(board[0][c].getText()=="") continue;
		if(board[0][c].getText()==board[1][c].getText()&&board[1][c].getText()==board[2][c].getText()) {
			for(int i =0;i<3;i++) {
				setWinner(board[i][c]);				
			}
			 if (currentPlayer.equals("X")) {
				    game.addWin(1);
				} else {
				    game.addWin(2);
				}
			 pointPlayer1.setText(player1 + ": " + game.getScore1());
			 pointPlayer2.setText(player2 + ": " + game.getScore2());
			JOptionPane.showMessageDialog(this, currentPlayer + " is the winner");
			gameover=true;
			return currentPlayer;
		}
	}
	//diagonal
	if (!board[0][0].getText().equals("")
	        && board[0][0].getText().equals(board[1][1].getText())
	        && board[1][1].getText().equals(board[2][2].getText())) {
		for(int i =0;i<3;i++) {
			setWinner(board[i][i]);
		
		}
		 if (currentPlayer.equals("X")) {
			    game.addWin(1);
			} else {
			    game.addWin(2);
			}
		 pointPlayer1.setText(player1 + ": " + game.getScore1());
		 pointPlayer2.setText(player2 + ": " + game.getScore2());
		  JOptionPane.showMessageDialog(this, currentPlayer + " is the winner");
		    gameover = true;
		    return currentPlayer;
		    }
	
	//anti-diagonally
	if (!board[0][2].getText().equals("")
	        && board[0][2].getText().equals(board[1][1].getText())
	        && board[1][1].getText().equals(board[2][0].getText())) {
		setWinner( board[0][2]);
		setWinner( board[1][1]);
		setWinner( board[2][0]);
		 if (currentPlayer.equals("X")) {
			    game.addWin(1);
			} else {
			    game.addWin(2);
			}
		 pointPlayer1.setText(player1 + ": " + game.getScore1());
		 pointPlayer2.setText(player2 + ": " + game.getScore2());
		 JOptionPane.showMessageDialog(this, currentPlayer + " is the winner");
		gameover=true;
		return currentPlayer;
	}
	
	//Draw
	if(turns==9 && !gameover) {
		game.addDraw();
		for(int r =0;r<3;r++) {
			for(int c=0; c<3 ; c++) {
				board[r][c].setForeground(Color.YELLOW);
				board[r][c].setBackground(Color.GRAY);
				}
		}
		draw.setText("Draws : " + game.getDraws());
		JOptionPane.showMessageDialog(this,  " is the draw");
		gameover=true;
	return "draw";
	}
	if(!gameover) {
	 ;
	}
	return currentPlayer ;
	}
public void setWinner(JButton tile) {
		tile.setForeground(Color.YELLOW);
		tile.setBackground(Color.GRAY);
		//textLabel.setText(CurrentPlayer + " is the winner");
		//JOptionPane.showMessageDialog(null, " x is the winner");
	}
public void computer() {
    Random random = new Random();
    int r, c;
    do {
        r = random.nextInt(3);
        c = random.nextInt(3);
    } while (!board[r][c].getText().isEmpty());
    JButton tile = board[r][c];
    tile.setText("O");
    tile.setForeground(Color.BLUE);
    turns++;
    textLabel.setText("O's turn");
    checkWinner();
    if (!gameover) {
        currentPlayer = "X";
        changeTimer();
    }}
}