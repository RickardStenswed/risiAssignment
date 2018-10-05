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
	
	public void updateAllKeys(DefaultTableModel dtm) throws SQLException {
		ResultSet rs = ass2DAL.getAllKeys();
		ass2DAL.mapMetaArrayVector(rs, dtm);
	}
	
	public void updateIndexes(DefaultTableModel dtm) throws SQLException {
		ResultSet rs = ass2DAL.getIndex();
		ass2DAL.mapMetaArrayVector(rs, dtm);
	}
	
	public void updateConstraints(DefaultTableModel dtm) throws SQLException {
		ResultSet rs = ass2DAL.getConstraints();
		ass2DAL.mapMetaArrayVector(rs, dtm);
	}
	
	public void updateTables(DefaultTableModel dtm) throws SQLException {
		ResultSet rs = ass2DAL.getTables();
		ass2DAL.mapMetaArrayVector(rs, dtm);
	}
	
	public void updateTablesTwo(DefaultTableModel dtm) throws SQLException {
		ResultSet rs = ass2DAL.getTablesTwo();
		ass2DAL.mapMetaArrayVector(rs, dtm);
	}
	
	public void updateColumns(DefaultTableModel dtm) throws SQLException {
		ResultSet rs = ass2DAL.getColumns();
		ass2DAL.mapMetaArrayVector(rs, dtm);
	}

	public void updateColumnsTwo(DefaultTableModel dtm) throws SQLException {
		ResultSet rs = ass2DAL.getColumnsTwo();
		ass2DAL.mapMetaArrayVector(rs, dtm);
	}
	
	public void updateTableNameMostRows(DefaultTableModel dtm) throws SQLException {
		ResultSet rs = ass2DAL.getTableNameMostRows();
		ass2DAL.mapMetaArrayVector(rs, dtm);
	}

	

	


	public void updateEmployeeMetaData(DefaultTableModel dtm, String table) throws SQLException {
		ResultSet rs = ass2DAL.getEmployeeMetaData(dtm, table);
		ass2DAL.mapMetaArrayVector(rs, dtm);
	}
}