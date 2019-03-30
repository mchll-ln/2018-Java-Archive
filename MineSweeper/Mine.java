import sun.audio.*;

import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * Michelle Lin, Nadia Ardekani & Olivia You
 * May 7th, 2018
 * Minesweeper Assignment
 * Mine class defines mine behaviour using object oriented programming
 **/

public class Mine {
    
    //define possible statuses of a cell
    public enum enumStatus { NONE, OPEN, MARKED };
    //define possible clicks as left and right click
    public enum enumClick { LEFT, RIGHT };
 
    public JButton button; //define a button
    public enumStatus status; //define the status of the game
    private boolean isMine; //define boolean as to whether or not a cell is a mine
    private int row; //define variable to store number of rows
    private int col; //define variable to store number of columns
    private int minesNearBy; //define variable to store the number of adjacent mines
    private boolean isExploded; //define the state of the game (whether or not the game is over)

    //describe position of mine using row and column
    public Mine(int r, int c){
        row = r;
        col = c;
        Reset(); //call function to reset status of mine for a new game
        InitMine(); //initialize/create the mines
    }
   public Mine(){
   }
    //reset the status of the game
    public void Reset(){
        status = enumStatus.NONE; //set the status of the game to none (not started)
        isMine = false; //set all cells to not be a mine
        isExploded = false; //reset the game so no mines are opened
        minesNearBy = 0; // reset the value of mines in adjacent cells to be zero
    }
    
    //set the colours of the number displayed on the cell to be the following
    public Color getColor(int minesAround){
      //if 1 is displayed, make it magenta
      if(minesAround==1){ 
          return Color.magenta;
      }
      //if 2 is displayed, make it blue
      else if(minesAround==2){
          return Color.blue;
      }
      //if 3 is displayed, make it red
      else if(minesAround==3){
          return Color.red;
      }
      //if 4 is displayed, make it pink
      else if(minesAround==4){
          return Color.pink;
      }
      //else make the number black
      else{
          return Color.black;
      }
    }
   
    //method to redraw all mines
    public void Redraw() {
        switch (WinMines.gameStatus) {
            //if game status is none (just started)
            case NONE: 
                button.setText(""); //clear text
                button.setIcon(null); //clear icon
                button.setForeground(null); //clear foreground
                button.setBackground(null); //clear background
                break;

            //if game has started or completed:
            case READY:
            case STARTED:
            case COMPLETED:
                switch (status) {
                    //if game has not started, clear all texts
                    case NONE:
                        button.setText("");
                        button.setIcon(null);
                        button.setForeground(null);
                        button.setBackground(null);
                        break;
                    //if the cell is marked, display flag icon and clear the background and foreground    
                    case MARKED:
                        button.setIcon(iconFlag);
                        button.setForeground(null);
                        button.setBackground(null);
                        break;
                    //if the cell is open:
                    case OPEN:
                        //if there are no mines nearby, set the cell to be blank
                        if (minesNearBy == 0) {
                            button.setText("");
                        }
                        //if there are mines nearby, display the number inside the cell
                        else {
                            button.setText(Integer.toString(minesNearBy));
                        }
                        button.setIcon(null); //don't display an icon
                        button.setForeground(getColor(minesNearBy)); //display selected colour of the number
                        button.setBackground(Color.green); //a blank cell is displayed as green
                        break;
                }
                break;
                
            //if the game is over, show all mines   
            case GAMEOVER:
                if (isMine == true) {
                    button.setIcon(iconMine);
                    button.setForeground(Color.black);
                    button.setBackground(null);
                }
                break;
        }
        button.revalidate();
        button.repaint();
    }
    
    //check if cell is a mine. if not a mine, set it to true
    public boolean SetIsMine() {
      if (isMine != true) {
            isMine = true; //if it is a mine, return true
            return true;
        }
        return false;
    }
    
    //method to check if the cell is a mine
    public boolean GetIsMine() {
        return isMine;
    }

    //method to open the cell is the game has started
    public void OpenMine() {
        if (WinMines.gameStatus != WinMines.enumGameStatus.STARTED && WinMines.gameStatus != WinMines.enumGameStatus.READY) {
            return;
        }
        switch (status) {
            case OPEN:
            case MARKED:
                break;
            case NONE:
                status = enumStatus.OPEN;
                //if a mine is clicked, it is exploded and the game is over
                if (isMine == true){
                    isExploded = true;
                    WinMines.gameStatus = WinMines.enumGameStatus.GAMEOVER;
                    Redraw(); 
                }
                else{
                    //if mine is not clicked, increment number of cells opened by one
                    WinMines.minesOpened ++;
                    Redraw(); 
                }
                break;
        }
    }
    
    //method to mark the cell with a flag
    private void MarkMine() {
        switch (status){
            //if it is already open, you cannot flag the cell
            case OPEN:
                break;
            //if it is already marked, reset it to unmarked
            case MARKED:
                status = enumStatus.NONE;
                Redraw();
                break;
            //if the cell is not marked, mark it with a flag
            case NONE:
                status = enumStatus.MARKED;
                Redraw();
                break;
        }   
    }

    Icon iconFlag = new ImageIcon("flag.jpg"); //set image of the flag 
    Icon iconMine = new ImageIcon("mine.png"); //set the image of the mine
    
    //initialize the mine
    private void InitMine() {
        button = new JButton(); //define the mine as a button
        button.setOpaque(true); //make the mine visible
        button.setHorizontalTextPosition(SwingConstants.CENTER); //center the mine on the cell
        button.setFont(new Font("Arial", Font.BOLD, 16)); //set the font to be size 16, bold and of arial font
        //set the border of the cells to be bold and dark grey
        button.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.darkGray, 1), BorderFactory.createLineBorder(Color.darkGray, 1)));

        //add mouse action listener
        button.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                //no return value if the game is over
                if (WinMines.gameStatus == WinMines.enumGameStatus.GAMEOVER) {
                    return;
                }
                //no return if the button cannot be clicked
                if (button.isEnabled() == false){
                    return;
                }
                WinMines.mineOpenedRow = -1;
                WinMines.mineOpenedCol = -1;

                //if user left and right clicks, and all mines are located correctly, then open all cells nearby
                if (SwingUtilities.isLeftMouseButton(e) && SwingUtilities.isRightMouseButton(e)){
                    if (WinMines.getMarksNearby(row, col) == minesNearBy) {
                        WinMines.openNearBy(row, col);
                    }
                }
                //if the user left clicks, initiate the following:
                else if(e.getButton() == MouseEvent.BUTTON1) {
                    // if no mine is open, then open the cell
                    if (WinMines.minesOpened == 0) {
                        WinMines.generateRandomMines(row, col);
                    }
                    OpenMine();
                    //if the game has not ended,then track row and column of opened mine
                    if (isExploded == false) {
                        WinMines.mineOpenedRow = row;
                        WinMines.mineOpenedCol = col;
                    }
                    //sent this event to the parent class, WinMines
                    e.getComponent().getParent().dispatchEvent(e); 
                }
                //if the user right clicks, then mark the cell with a flag
                else if(e.getButton() == MouseEvent.BUTTON3) {
                    MarkMine();
                    //sent this event to the parent class, WinMines
                    e.getComponent().getParent().dispatchEvent(e);
                }
                
            }
        });
    }
   
    //method to return the number of mines nearby
    public int GetMinesNearBy() {
        return minesNearBy;
    }
 
    //method to set the number of mines nearby to number passed into the parameters
    public void SetMinesNearBy(int num) {
        minesNearBy = num;
    }
    public void save() {
    try (FileOutputStream output = new FileOutputStream("MinesweeperData.txt");
            ObjectOutput outStream = new ObjectOutputStream(output)) {
        
    	outStream.writeObject(isMine);
        outStream.writeObject(isExploded);
        outStream.writeObject(status);

        outStream.writeInt(row);
        outStream.writeInt(col);
        outStream.writeInt(minesNearBy);
        
        outStream.close();
        output.close();
        //notify the user the game is saved
        JOptionPane.showMessageDialog(null, "Current game successfully saved", "Notification",
                JOptionPane.INFORMATION_MESSAGE);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
    public void load() {
		try (FileInputStream input = new FileInputStream("MinesweeperData.txt");
				ObjectInputStream inStream = new ObjectInputStream(input)) {
			
			isMine = (boolean) inStream.readObject();
			isExploded = (boolean) inStream.readObject();
	       status = (enumStatus) inStream.readObject();

			row = (Integer) inStream.readInt();
			col = (Integer) inStream.readInt();
			minesNearBy = (Integer) inStream.readInt();

			//close the input stream
			inStream.close();
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

} 
}/**
    public static void music() 
    {       
        //AudioPlayer MGP = AudioPlayer.player;AudioStream BGM;AudioData MD;

        ContinuousAudioDataStream loop = null;

        try
        {
        	InputStream test = new FileInputStream("Music.wmv");
            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);
            //MD = BGM.getData();
            //loop = new ContinuousAudioDataStream(MD);

        }
        catch(FileNotFoundException e){
            System.out.print(e.toString());
        }
        catch(IOException error)
        {
            System.out.print(error.toString());
        }
        MGP.start(loop);
    }
}  
    **/
}