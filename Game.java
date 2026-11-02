package Page1;



public class Game {
	private String player1;
	private String player2;
	private int score1;
	private int score2;
	private int draws;
	
	//Player1 
	public void setPlayer1( String player1) {
		this.player1=player1;
	}
	public String getPlayer1() {
		return player1;
	}
	
	//Player2
	
	public void setPlayer2( String player2) {
		this.player2=player2;
	}
	public String getPlayer2() {
		return player2;
	}
	
	
	//Score1
	public void setScore1(int score1) {
		this.score1=score1;
		
	}
	
	public int getScore1() {
		return score1;
	}
	
	
	//Score2
	public void setScore2(int score2) {
		this.score2=score2;
		
	}
	
	public int getScore2() {
		return score2;
	}
	
	
	//Draw
	public void setDraws(int draws) {
		this.draws=draws;
		
	}
	
	public int getDraws() {
		return draws;
	}
	
	//constructor 
	public Game(String player1, String player2 ) {
		this.player1=player1;
		this.player2=player2;
		score1=0;
		score2=0;
		draws=0;
		
	}
	
	//Method addwin()
	public void addWin(int player) {
		if(player==1) {
			score1++;
		} 
		else if (player==2) {
			score2++;
		}
	}
	
	//Method resetScore
	public void resetScore() {
		score1=0;
		score2=0;
		draws=0;
		
	}
	
	//Method addDraw
	public void  addDraw() {
		//void addDraw(JButton tiel) {
			//tiel.setForeground(Color.YELLOW);
			//tiel.setBackground(Color.GRAY);
			//frame.textLabel.setText("Draw");
			 draws++;
		}
		
	}

