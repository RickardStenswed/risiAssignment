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
    
    //Method for addying the names of the columns
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

	//Method for addying resultset i default table
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
	// Method for getting the employees qualifications
		public ResultSet getQualification() throws SQLException {
			String sqlstring = "SELECT [Employee No_], [Line No_], [Qualification Code], [timestamp], [Employee Status] FROM [CRONUS Sverige AB$Employee Qualification]";
			ResultSet rs = runExecuteQuery(sqlstring);
			return rs;
		}

		//Method for getting the relatives for the employees
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

		// Method for getting the data about employee absence
		public ResultSet getAbsence() throws SQLException {
			String sqlString = "SELECT [timestamp], [Entry No_], [From Date], [To Date], [Description] FROM [CRONUS Sverige AB$Employee Absence]";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}

		// Method for getting portal setup
		public ResultSet getPortalSetup() throws SQLException {
			String sqlString = "SELECT [timestamp], [Search Limit], [Temp_ Key Index], [Temp_ Table No_], [Temp_ Option Value] FROM  [CRONUS Sverige AB$Employee Portal Setup]";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}

		// Method for gettinbg data about the employees
		public ResultSet getEmployee() throws SQLException {
			String sqlString = "SELECT [timestamp], [No_], [First Name], [Last Name], [Job Title] FROM [CRONUS Sverige AB$Employee]";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}
		
		//___________________________________________________________________________________________________
		
		
		//Method for getting metadata about the employeetable
		public ResultSet getEmployeeMetaData(DefaultTableModel dtm, String table) throws SQLException {
			String sqlString = "SELECT [TABLE_CATALOG], [TABLE_SCHEMA], [TABLE_NAME],[ORDINAL_POSITION],[DATA_TYPE] FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'CRONUS Sverige AB$Employee "
					+ table + "'";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}
			

		public ResultSet getColumns() throws SQLException {
			String sqlString = "SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE table_name = 'CRONUS Sverige AB$Employee'";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;

		}

		
		public ResultSet getColumnsTwo() throws SQLException {
			String sqlString = "SELECT * FROM sys.columns WHERE object_id = object_id('CRONUS Sverige AB$Employee')";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}

		
		public ResultSet getIndex() throws SQLException {
			String sqlString = "SELECT * FROM sys.indexes";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}

		
		public ResultSet getTables() throws SQLException {
			String sqlString = "SELECT * FROM INFORMATION_SCHEMA.TABLES";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}

	
		public ResultSet getTablesTwo() throws SQLException {
			String sqlString = "SELECT * FROM sys.tables";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}

	
		public ResultSet getConstraints() throws SQLException {
			String sqlString = "SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}

		
		public ResultSet getTableNameMostRows() throws SQLException {
			String sqlString = "SELECT top 1 [TableName] = so.name, [RowCount] = max(si.rows) FROM sysobjects so, sysindexes si WHERE so.xtype = 'U' AND si.id = object_id(so.name) GROUP BY so.name ORDER BY 2 desc;";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}

		
		public ResultSet getAllKeys() throws SQLException {
			String sqlString = "SELECT * FROM sys.key_constraints";
			ResultSet rs = runExecuteQuery(sqlString);
			return rs;
		}
	}

	
