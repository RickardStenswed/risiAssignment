package controller;

import dal.Assignment3DAL;

public class Controller3 {

	Assignment3DAL dal3 = new Assignment3DAL();
	
	public void openFile(String fileName) throws Exception {
		dal3.openFile(fileName);
	}
}
