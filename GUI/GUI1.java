import java.util.*;

import javax.swing.*;//Import the 3 libraries

import java.awt.*;
import java.awt.event.*;
/**
 * Author: Michelle Lin
 * File: GUI1.java
 * Date: April 16th, 2018
 * Description: Output a 6x6 grid of randomly placed letters and check if the input exists on the grid (horizontally, vertically, or forwards/backwards)and if it is a valid word. 
 */
public class GUI1 {
//global variables
	Random ran = new Random();
	
	Scanner input = new Scanner(System.in);
	final int row = 6;
	final int col = 6;
	
	public static void main(String[] args){
	//a
	//Declare 2D array of numbers - grid
	String grid[][]=new String[row][col];
		}
	}
	//b
	for(int r=0; r<grid.length; r++){
		for(int c=0; c<grid[r].length; c++){
	System.out.println(grid[r][c]);
		}
	}
	//c
	System.out.println("Please enter a word.");
	String word = input.nextLine();
	}
	for(int r=0; r<grid.length; r++){
		for(int c=0; c<grid[r].length; c++){
			//int num = ran.nextInt(str.length());
			char hold =(char)(ran.nextInt(26)+ 'a');
			//char hold = str.charAt(num);
			grid[r][c] = Character.toString(hold);
}
