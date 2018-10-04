package dal;

import java.sql.*;
import java.util.*;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;


import connection.DBconnection;

public class Assignment2DAL {

	private Connection con = null;
    private PreparedStatement pStmt = null;
   

    // Connecting to database, runs preparedStatement, executing query and collecting resultset.
    
    private ResultSet runExecuteQuery(String sqlString) throws SQLException {
        con = DBconnection.getCronusConnection();
        pStmt = con.prepareStatement(sqlString);
        ResultSet rs = pStmt.executeQuery();
        return rs;
    }    
    
    public Vector<String> getColumnNames(ResultSet rs) throws SQLException {
		Vector<String> colNames = new Vector<String>();
		ResultSetMetaData rsmd = rs.getMetaData();
		int col = rsmd.getColumnCount();
		for (int i = 1; i <= col; i++) {
			String name = rsmd.getColumnName(i);
			colNames.add(name);
		}
		return colNames;
	}

	// Skapar lägger in resultsettet i tablen
	public void mapMetaArrayVector(ResultSet rs, DefaultTableModel dtm) throws SQLException {
		ArrayList<Vector<String>> list = new ArrayList<Vector<String>>();
		Vector<String> columns = getColumnNames(rs);
		dtm.setColumnIdentifiers(columns);
		ResultSetMetaData rsmd = rs.getMetaData();
		int col = rsmd.getColumnCount();

		while (rs.next()) {
			Vector<String> tmp = new Vector<String>();
			for (int i = 1; i <= col; i++) {
				tmp.add(rs.getString(i));
			}
			list.add(tmp);
		}
		for (Vector<String> tmp : list) {
			dtm.addRow(tmp);
		}
		pStmt.close();
		con.close();
		
		
	}
	// 1. hämta Qualification
		public ResultSet getQualification() throws SQLException {
			String sqlstring = "SELECT [Employee No_], [Line No_], [Qualification Code], [timestamp], [Employee Status] FROM [CRONUS Sverige AB$Employee Qualification]";
			ResultSet rs = runExecuteQuery(sqlstring);
			return rs;
		}

		// 2.Hämta relatives
		public ResultSet getRelatives() throws SQLException {
			String sqlstring = "SELECT [timestamp], [Relative Code], [First Name], [Last Name], [Birth Date] FROM [CRONUS Sverige AB$Employee Relative]";
			ResultSet rs = runExecuteQuery(sqlstring);
			return rs;
		}

		// 3.Hämta statistics group
		public ResultSet getStatisticsGroup() throws SQLException {
			String sqlString = "SELECT [timestamp], [Code], [Description] FROM [CRONUS Sverige AB$Employee Statistics Group]";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}

		// 4.Hämta absence
		public ResultSet getAbsence() throws SQLException {
			String sqlString = "SELECT [timestamp], [Entry No_], [From Date], [To Date], [Description] FROM [CRONUS Sverige AB$Employee Absence]";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}

		// 5.Hämta Portal Setup
		public ResultSet getPortalSetup() throws SQLException {
			String sqlString = "SELECT [timestamp], [Search Limit], [Temp_ Key Index], [Temp_ Table No_], [Temp_ Option Value] FROM  [CRONUS Sverige AB$Employee Portal Setup]";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}

		// 6.hämta Employee
		public ResultSet getEmployee() throws SQLException {
			String sqlString = "SELECT [timestamp], [No_], [First Name], [Last Name], [Job Title] FROM [CRONUS Sverige AB$Employee]";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}
		
		//___________________________________________________________________________________________________
		
		public ResultSet getEmployeeMetaData(DefaultTableModel dtm, String table) throws SQLException {
			String sqlString = "SELECT [TABLE_CATALOG], [TABLE_SCHEMA], [TABLE_NAME],[ORDINAL_POSITION],[DATA_TYPE] FROM INFORMATION_SCHEMA.COLUMNS where TABLE_NAME = 'CRONUS Sverige AB$Employee "
					+ table + "'";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}
			

		// HÄMTA ALLA KOLUMNER 1
		public ResultSet getColumns() throws SQLException {
			String sqlString = "SELECT * FROM INFORMATION_SCHEMA.COLUMNS where table_name = 'CRONUS Sverige AB$Employee'";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;

		}

		// HÄMTA KOLUMNER 2
		public ResultSet getColumnsTwo() throws SQLException {
			String sqlString = "SELECT * FROM sys.columns where object_id = object_id('CRONUS Sverige AB$Employee')";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}

		// HÄMTA ALLA INDEX
		public ResultSet getIndex() throws SQLException {
			String sqlString = "SELECT * FROM sys.indexes";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}

		// HÄMTA ALLA TABLES 1
		public ResultSet getTables() throws SQLException {
			String sqlString = "SELECT * FROM INFORMATION_SCHEMA.TABLES";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}

		// HÄMTA ALLA TABLES 2
		public ResultSet getTablesTwo() throws SQLException {
			String sqlString = "SELECT * FROM sys.tables";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}

		// HÄMTA ALLA CONSTRAINTS
		public ResultSet getConstraints() throws SQLException {
			String sqlString = "SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}

		// HÄMTA TABELLNAMN FRÅN TABELL MED FLEST RADER
		public ResultSet getTableNameMostRows() throws SQLException {
			String sqlString = "SELECT top 1 [TableName] = so.name, [RowCount] = max(si.rows) FROM sysobjects so, sysindexes si where so.xtype = 'U' and si.id = object_id(so.name) group by so.name order by 2 desc;";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}

		// HÄMTAR ALLA NYCKLAR
		public ResultSet getAllKeys() throws SQLException {
			String sqlString = "SELECT * from sys.key_constraints";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}
	}

	
