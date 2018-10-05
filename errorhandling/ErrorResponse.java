package errorhandling;

public class ErrorResponse {
	
	public static String getMessageForErrorCode(int errorCode, String prefix) {
		String code = "System failure";
		
		//Duplicated Primary Key
		if (errorCode == 2627) {
			code = prefix + " is already registred";
		}
		//Om personen/kursen ej finns och man försöker lägga till den i Studied/Studies
		if(errorCode == 547) {
			if(prefix == "add course") {
				code = "Kursen får max ha 45 poäng";
			}else {
				code = prefix + " can not be deleted. " + prefix + " is existing in another table";
			}
		}
		//Login failed
		if(errorCode == 18456) {
			code = "Login to database failed";
		}
		//Too long variable
		if(errorCode == 8152) {
			code = "För lång variabel";
		}
		if(errorCode  == 0) {
			code = prefix + " have already studied the course";
		}
		return code;
	}
}

