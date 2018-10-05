package errorhandling;

public class errorResponse {
	
	public static String getMessageForErrorCode(int errorCode, String prefix) {
		String code = "Ett annat fel inträffade";
		
		//Duplicated Primary Key
		if (errorCode == 2627) {
			code = prefix + " finns redan registrerad";
		}
		//Om personen/kursen ej finns och man försöker lägga till den i Studied/Studies
		if(errorCode == 547) {
			if(prefix == "add course") {
				code = "Kursen får max ha 45 poäng";
			}else {
				code = prefix + " finns inte";
			}
		}
		//Login failed
		if(errorCode == 18456) {
			code = "Inloggning till databasen misslyckades";
		}
		//Too long variable
		if(errorCode == 8152) {
			code = "För lång variabel";
		}
		if(errorCode  == 0) {
			code = prefix + " har redan läst kursen";
		}
		return code;
	}
}

