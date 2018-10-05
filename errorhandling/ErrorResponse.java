package errorhandling;

public class ErrorResponse {
	
	public static String getMessageForErrorCode(int errorCode, String prefix) {
		String code = "Ett annat fel intr�ffade";
		
		//Duplicated Primary Key
		if (errorCode == 2627) {
			code = prefix + " is already registred";
		}
		//Om personen/kursen ej finns och man f�rs�ker l�gga till den i Studied/Studies
		if(errorCode == 547) {
			if(prefix == "add course") {
				code = "Kursen f�r max ha 45 po�ng";
			}else {
				code = prefix + " does not exist";
			}
		}
		//Login failed
		if(errorCode == 18456) {
			code = "Inloggning till databasen misslyckades";
		}
		//Too long variable
		if(errorCode == 8152) {
			code = "F�r l�ng variabel";
		}
		if(errorCode  == 0) {
			code = prefix + " har redan l�st kursen";
		}
		return code;
	}
}

