import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;

/**
 * Michelle Lin, Nadia Ardekani & Olivia You
 * May 7th, 2018
 * Minesweeper Assignment
 * Main program to define the mine class 
 **/

public class WinMines extends JFrame implements ActionListener {
    private Container pane; //define pane
    private JPanel board = new JPanel();; //define the panel
    final int CELL_SIZE = 30; //define the size of each cell
    
    //define the number of mines in each level
    final static int EASY_MINES_NUM = 10;
    final static int MEDIUM_MINES_NUM = 40;
    final static int HARD_MINES_NUM = 99;
   
    //define the number of cells in each level
    final static int EASY_SIZE_ROW = 9;
    final static int EASY_SIZE_COL = 9;
    final static int MEDIUM_SIZE_ROW = 16;
    final static int MEDIUM_SIZE_COL = 16;
    final static int HARD_SIZE_ROW = 16;
    final static int HARD_SIZE_COL = 30;
    
    //initialize number of rows as the number of rows in easy level
    static int SIZE_ROW = EASY_SIZE_ROW; 
    static int SIZE_COL = EASY_SIZE_COL;
    static int MINES_NUM = EASY_MINES_NUM;
   
    private JPanel minesBoard; //define panel
    private final JLabel timer = new JLabel(""); //define timer
    private static Mine[][] mines = new Mine[HARD_SIZE_ROW][HARD_SIZE_COL]; //define maximum size of board
    private int secondsLapsed; //define variable to store time elapsed
   
    //declare possible states of the game
    public enum enumGameStatus {READY, STARTED, GAMEOVER, NONE, COMPLETED};
    public static enumGameStatus gameStatus;
    
    public static int minesOpened; //number of mines opened
    static JFrame frame = new JFrame("Minesweeper"); //create main window for the game
    
    //global variable to store whether mine is clicked
    public static int mineOpenedRow;
    public static int mineOpenedCol;
   
    //default constructor
    public WinMines() {
        createMines();
        secondsLapsed = 0;
        gameStatus = enumGameStatus.NONE;
    }
   
    //initialize and create the mines
    public void createMines() {
        for (int row = 0; row < HARD_SIZE_ROW;  row++) {
            for (int col = 0; col < HARD_SIZE_COL; col++) {
                mines[row][col] = new Mine(row, col);
            }
        }
    }
   
    //resets all mines when user starts the game
    public static void initMines(){
        for (int row = 0; row < HARD_SIZE_ROW;  row++) {
            for (int col = 0; col < HARD_SIZE_COL; col++) {
                mines[row][col].Reset();
            }
        }  
    }
       
    //this method generates and randomly distributes mines throughout the board
    // passes row and column of the cell the user clicks
    public static void generateRandomMines(int r, int c){ 
        int minesNum = 0;
        Random rand = new Random();
       
        int counter = 0;
        //generates mines up to 10000 times to distribute all mines to prevent an infinite loop
        while (minesNum < MINES_NUM && counter <= 10000) {
            int n = rand.nextInt(SIZE_ROW * SIZE_COL);
            int row = n / SIZE_COL;
            int col = n - row * SIZE_COL;
            
            //ensure that user clicks on a cell that does not have a mine surrounding it
            //to ensure that the first click opens an large area of cells
            if (row < r-1 || row > r+1 || col < c-1 || col > c+1) {
                if (mines[row][col].SetIsMine()) {
                    //increment the mine count by one to achieve the desired number of mines according to level
                    minesNum ++;
                }
            }
            counter ++; //prevent infinite loop
        }
        if (minesNum != MINES_NUM) {
            JOptionPane.showMessageDialog(frame, "Error, only " + minesNum + " mines are generated.");
        }
       
        //calculate nearby mines for all mines once the game begins
        //go through each mine to calculate number displayed in cell
        for (int row = 0; row < SIZE_ROW;  row++) {
            for (int col = 0; col < SIZE_COL; col++){
                int mineNum = 0;
                if (IsMine(row-1, col-1) == true)
                    mineNum ++;
                if (IsMine(row-1, col) == true)
                    mineNum ++;
                if (IsMine(row-1, col+1) == true)
                    mineNum ++;
                if (IsMine(row, col-1) == true)
                    mineNum ++;
                if (IsMine(row, col+1) == true)
                    mineNum ++;
                if (IsMine(row+1, col-1) == true)
                    mineNum ++;
                if (IsMine(row+1, col) == true)
                    mineNum ++;
                if (IsMine(row+1, col+1) == true)
                    mineNum ++;
                mines[row][col].SetMinesNearBy(mineNum);
            }
        }
    }

    //restart timer after the round
    public void StartTimer() {
        gameStatus = enumGameStatus.STARTED;
        secondsLapsed = 0;
    }
   
    //hide the timer when game finishes
    public void StopTimer() {
        timer.setText("");
    }

    //timer to show time elapsed; automatically called every second
    public void Timer() {
        if (gameStatus == enumGameStatus.STARTED) {
            secondsLapsed ++; //increment timer by one every second
            //show time in minutes : seconds
            timer.setText( secondsLapsed / 60 + ":" + String.format("%02d", secondsLapsed % 60) ); 
        }
    }
   
    //over-riding method for action listener
    public void actionPerformed(ActionEvent event) {
    };
 
    //checks if cell (the row and column) is located on the board
    public static boolean IsInBoard(int row, int col){
        if (row < 0 || row >= SIZE_ROW || col < 0 || col >= SIZE_COL) {
            return false;
        }
        return true;
    }
    
    //checks if cell is a mine
    public static boolean IsMine(int row, int col){
        //ensure that cell (row and column) is in the board
        if (IsInBoard(row, col) == false) {
            return false;
        }
        //if cell exists, check if it's a mine
        return mines[row][col].GetIsMine();
    }
   
    //add the mine gui to the board
    public void AddMinesToBoard(){
        //create the panel
        minesBoard = new JPanel(new GridLayout(0, SIZE_COL));
       
        minesBoard.setBorder(new LineBorder(Color.BLACK)); //set border of the panel to be black
        minesBoard.setPreferredSize(new Dimension(CELL_SIZE * SIZE_COL, CELL_SIZE * SIZE_ROW)); //set size of the panel depending on number of cells and size per cell

        board.add(minesBoard, BorderLayout.CENTER); //add board to the board
        pane.add(board, BorderLayout.CENTER); //add board to the content pane

        //add cell buttons to the board
        for (int row = 0; row < SIZE_ROW;  row++) {
            for (int col = 0; col < SIZE_COL; col++) {
                minesBoard.add(mines[row][col].button);
            }
        }
       
        //add mouse listener to detect clicking events
        minesBoard.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                
                if(e.getButton() == MouseEvent.BUTTON1) { //left click
                  
                    //start timer when game starts
                    if (gameStatus == enumGameStatus.READY) { 
                        StartTimer();
                    }
                    //when user opens a cell without a cell with mines around it, open all nearby cells
                    if (mineOpenedRow > -1 && mineOpenedCol > -1) {
                        TryOpenEmptyMines(mineOpenedRow, mineOpenedCol);
                    }
                    //checks game status
                    CheckGameStatus();
                }
            }
        } );
        
        //redraw mines when new game begins
        RedrawMines();
    }

    //reset and initialize mines when new game starts
    public void NewGame(){
        gameStatus = enumGameStatus.READY; // reset status of the game to ready
        initMines(); //initialize/reset all mines
        board.removeAll(); //remove board elements
        AddMinesToBoard(); //reset and readd board elements
        minesOpened = 0; //reset number of opened mines to 0
        timer.setText(""); //hide time timer
        frame.repaint();
        frame.revalidate();
    } 
   
    //recursively open the mines when there are no adjacent mines
    public void TryOpenMine(int row, int col){
        //check if cell is on the board
        if (IsInBoard(row, col) == false) {
            return;
        }
        //only try to open mine when it's not marked or opened
        if (mines[row][col].status == Mine.enumStatus.NONE) {
            mines[row][col].OpenMine();
            if (mines[row][col].GetMinesNearBy() == 0 && mines[row][col].status == Mine.enumStatus.OPEN) {
                TryOpenEmptyMines(row, col);
            }
        }
    }
   
    //method to recursively find all the nearby cells that have no mines around it
    public void TryOpenEmptyMines(int row, int col){
        //when its not a mine and no adjacent mines, open all cells
        if (mines[row][col].GetIsMine() == false && mines[row][col].GetMinesNearBy() == 0) { 
            //checks if cell is a mine
            TryOpenMine(row-1, col-1);
            TryOpenMine(row-1, col);
            TryOpenMine(row-1, col+1);
            TryOpenMine(row, col-1);
            TryOpenMine(row, col+1);
            TryOpenMine(row+1, col-1);
            TryOpenMine(row+1, col);
            TryOpenMine(row+1, col+1);
        }
    }
   
    //opens the cell
    private static void OpenMine(int row, int col) {
      
        //check if cell is on the board
        //if not, no nothing
        if (IsInBoard(row, col) == false) {
            return;
        }
        //if it is on the board, open the cell
        mines[row][col].OpenMine();
    }
    
    //checked is the row and column is marked
    public static boolean isMarked(int row, int col) {
        //check if cell is on the board
        if (IsInBoard(row, col) == false) {
            return false;
        }
        //check if mine is marked
        if (mines[row][col].status == Mine.enumStatus.MARKED) {
            return true;
        }
        else {
            return false;
        }
    }
    
    //calculates the number of flagged cells nearby
    public static int getMarksNearby(int row, int col) {
        int num = 0;
        if (isMarked(row -1, col-1) == true) {
            num ++;
        }
        if (isMarked(row -1, col) == true) {
            num ++;
        }
        if (isMarked(row -1, col+1) == true) {
            num ++;
        }
        if (isMarked(row, col-1) == true) {
            num ++;
        }
        if (isMarked(row, col+1) == true) {
            num ++;
        }
        if (isMarked(row +1, col-1) == true) {
            num ++;
        }
        if (isMarked(row +1, col) == true) {
            num ++;
        }
        if (isMarked(row +1, col+1) == true) {
            num ++;
        }
        //return the number of marked cells
        return num; 
    }
    
    //opens all nearby cells when user left and right clicks at the same time
    //only occurs if enough mines are marked/opened around the cell
    public static void openNearBy(int row, int col) {
        OpenMine(row-1, col-1);
        OpenMine(row-1, col);
        OpenMine(row-1, col+1);
        OpenMine(row, col-1);
        OpenMine(row, col+1);
        OpenMine(row+1, col-1);
        OpenMine(row+1, col);
        OpenMine(row+1, col+1);
    }
    
    //checks the game status to output the status of the game
    public void CheckGameStatus(){
        if (gameStatus == enumGameStatus.STARTED || gameStatus == enumGameStatus.READY) {
            //start the game status to start the timer
            if (minesOpened > 0) {
                gameStatus = enumGameStatus.STARTED;
            }
            //when the game is completed, with all cells that are not mines opened,  output a 'congratulations' message
            if (minesOpened == SIZE_ROW * SIZE_COL - MINES_NUM) {
                gameStatus = enumGameStatus.COMPLETED;
                JOptionPane.showMessageDialog(frame, "Congratulations, you win!"); //output message to the user
            }
        }
        //if user clicks on a mine, stop the timer and output a 'game over' message
        if (gameStatus == enumGameStatus.GAMEOVER) {
            StopTimer();
            JOptionPane.showMessageDialog(frame, "Game over, you hit the mine"); //output message to the user
        }
    }
   
    //checks the game status to output the status of the game
	public void CheckGameStatus(){
	    if (gameStatus == enumGameStatus.STARTED || gameStatus == enumGameStatus.READY) {
	        //start the game status to start the timer
	        if (minesOpened > 0) {
	            gameStatus = enumGameStatus.STARTED;
	        }
	        //when the game is completed, with all cells that are not mines opened,  output a 'congratulations' message
	        if (minesOpened == SIZE_ROW * SIZE_COL - MINES_NUM) {
	            gameStatus = enumGameStatus.COMPLETED;
	            JOptionPane.showMessageDialog(frame, "Congratulations, you win!"); //output message to the user
	        }
	    }
	    //if user clicks on a mine, stop the timer and output a 'game over' message
	    if (gameStatus == enumGameStatus.GAMEOVER) {
	        StopTimer();
	        JOptionPane.showMessageDialog(frame, "Game over, you hit the mine"); //output message to the user
	    }
	}

	//redistributes mines across the board
    public void RedrawMines(){
        //go through each cell of the board
        for (int row = 0; row < SIZE_ROW;  row++) {
            for (int col = 0; col < SIZE_COL; col++)  {
                mines[row][col].Redraw();
            }
        }     
    }

    //add board to the centre of the pane
    public void addBoardToPane(){
        addMenuToBoard();
        pane.add(board, BorderLayout.CENTER);
    }
   
    //add top bar to the board, including the levels and timer
    public void addMenuToBoard(){
        JToolBar tools = new JToolBar();
        pane.add(tools, BorderLayout.PAGE_START); //add tools and border to the panel
       
        //add easy button to the panel
        final ButtonGroup  group = new ButtonGroup();
        JToggleButton easyBtn = new JToggleButton("Easy"); //define easy button as a toggled button
        easyBtn.addActionListener(new ActionListener() { //add action listener so the button can respond to clicks
            //describe what to do when the easy button is clicked using an overriding method
            @Override
            public void actionPerformed(ActionEvent e) {
                SIZE_ROW = EASY_SIZE_ROW;
                SIZE_COL = EASY_SIZE_COL;
                MINES_NUM = EASY_MINES_NUM;
                NewGame();
            }
        });
        group.add(easyBtn); //add easy button to the toggle group so only one button can be toggled
        easyBtn.setSelected(true); //set the easy button to be toggled
        tools.add(easyBtn); //add easy button to the toolbar
       
        //define properties of a medium level game
        JToggleButton mediumBtn = new JToggleButton("Medium"); //define medium button as a toggled button
        mediumBtn.addActionListener(new ActionListener() { //add action listener so the button can respond to clicks
            //describe what to do when the medium button is clicked using an overriding method            
            @Override
            public void actionPerformed(ActionEvent e) {
                //define number of cells
                SIZE_ROW = MEDIUM_SIZE_ROW;
                SIZE_COL = MEDIUM_SIZE_COL;
                //declare number of mines
                MINES_NUM = MEDIUM_MINES_NUM;
                //call method to reset the game
                NewGame();
            }
        });
        group.add(mediumBtn); //set the medium button to be toggled
        tools.add(mediumBtn); //add medium button to the toolbar

        //define properties of a medium level game
        JToggleButton hardBtn = new JToggleButton("Hard"); //define hard button as a toggled button
        hardBtn.addActionListener(new ActionListener() { //add action listener so the button can respond to clicks
            //describe what to do when the hard button is clicked using an overriding method
            @Override
            public void actionPerformed(ActionEvent e) {
                //define number of cells                
                SIZE_ROW = HARD_SIZE_ROW;
                SIZE_COL = HARD_SIZE_COL;
                //define number of mines
                MINES_NUM = HARD_MINES_NUM;
                //call method to reset the game
                NewGame();
            }
        });
        group.add(hardBtn); //set the hard button to be toggled
        tools.add(hardBtn);  //add hard button to the toolbar
        
        Mine mn = new Mine(); 
        JToggleButton loadBtn = new JToggleButton("Load");
        loadBtn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e){
        	mn.load();
        	frame.repaint();
        	frame.revalidate();
            }
        });

        group.add(loadBtn); //set the load button to be toggled
        tools.add(loadBtn);  //add load button to the toolbar
        
        JToggleButton saveBtn = new JToggleButton("Save");
        saveBtn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e){
        	mn.save();
        	//NewGame();
            }
        });

        group.add(saveBtn); //set the save button to be toggled
        tools.add(saveBtn);  //add save button to the toolbar

        tools.add(Box.createHorizontalGlue()); //add a horizontal tool bar
        tools.add(timer); //add timer to the tool bar
        tools.addSeparator(); //seperate the level buttons from the timer
    }
   
    //define the application that runs the static instance of the WinMines class
    static WinMines app;
    
    public static void main(String[] args) {
        app = new WinMines();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the app when user clicks the "x"
        frame.setLocationByPlatform(true); //add the panel to the screen in a cascading manner

        app.pane = frame.getContentPane(); //get the contents of the pane
        app.addBoardToPane(); //add the board to the pane
         
        frame.pack(); 
        frame.setSize(1024, 640); //set size of the panel
        frame.setVisible(true); //make the frame visible
     
        //create the timer task
        TimerTask repeatedTask = new TimerTask() {
            //define what to do when the timer is triggered
            public void run() { 
                app.Timer();
            }
        };
        //create the timer
        java.util.Timer timer = new java.util.Timer("Timer");
   
        long delay  = 1000L; //delay timer by one second for the task execution
        long period = 1000L; //increment by one second every second
        timer.scheduleAtFixedRate(repeatedTask, delay, period); //set parameters as task for scheduling, delay and how often the timer is triggered
       
        //start the new game
        app.NewGame();
    }
   
} 