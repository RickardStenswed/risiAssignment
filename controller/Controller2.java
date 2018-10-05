package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.swing.table.DefaultTableModel;

import dal.Assignment2DAL;

public class Controller2 {
	
	Assignment2DAL ass2DAL = new Assignment2DAL();

	//Methods for getting content of Employee and related tables
	
	public void updateEmployee(DefaultTableModel dtm) throws SQLException {
		ResultSet rs = ass2DAL.getEmployee();
		ass2DAL.mapMetaArrayVector(rs, dtm);
	}
	
	public void updateRelatives(DefaultTableModel dtm) throws SQLException {
		ResultSet rs = ass2DAL.getRelatives();
		ass2DAL.mapMetaArrayVector(rs, dtm);
	}
	
	public void updateAbsence (DefaultTableModel dtm) throws SQLException {
		ResultSet rs = ass2DAL.getAbsence();
		ass2DAL.mapMetaArrayVector(rs, dtm);
	}
	
	public void updateQualification(DefaultTableModel dtm) throws SQLException {
		ResultSet rs = ass2DAL.getQualification();
		ass2DAL.mapMetaArrayVector(rs, dtm);
	}
	
	public void updateStatisticsGroup (DefaultTableModel dtm) throws SQLException {
		ResultSet rs = ass2DAL.getStatisticsGroup();
		ass2DAL.mapMetaArrayVector(rs, dtm);
	}
	
	public void updatePortalSetup (DefaultTableModel dtm) throws SQLException {
		ResultSet rs = ass2DAL.getPortalSetup();
		ass2DAL.mapMetaArrayVector(rs, dtm);
	}

	
	//Methods for getting metadata
	public ResultSet getAllKeys() throws SQLException {
		return ass2DAL.getAllKeys();
	}
	
	public ResultSet getIndex() throws SQLException {
		return ass2DAL.getIndex();
	}
	
	public ResultSet getConstraints() throws SQLException {
		return ass2DAL.getConstraints();
	}

	public ResultSet getTables() throws SQLException {
		return ass2DAL.getTables();
	}
	
	public ResultSet getTablesTwo() throws SQLException {
		return ass2DAL.getTablesTwo();
	}
	
	public ResultSet getColumns() throws SQLException {
		return ass2DAL.getColumns();

	}
	
	public ResultSet getColumnsTwo() throws SQLException {
		return ass2DAL.getColumnsTwo();
	}
	
	public ResultSet getTableNameMostRows() throws SQLException {
		return ass2DAL.getTableNameMostRows();
	}
	
	public ResultSet getEmployeeMetaData(DefaultTableModel dtm, String table) throws SQLException {
		return ass2DAL.getEmployeeMetaData(dtm, table);
	}//Inte inlagd i app
		
}
