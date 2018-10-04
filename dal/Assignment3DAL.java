package dal;

import java.awt.Desktop;
import java.io.File;

public class Assignment3DAL {

	public Assignment3DAL() {
	}
		public void openFile(String fileName) throws Exception {
			String path = "C:\\Users\\Administrator\\";
			File filePath = new File(path + fileName);
			Desktop.getDesktop().open(filePath);
			
		}
	}




