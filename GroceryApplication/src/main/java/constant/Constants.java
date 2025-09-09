package constant;

public class Constants {
	//TESTDATAFILE is constant which is always Uppercase
	//System.getProperty is used to point to the Current directory (Project Folder) of workspace. Remaining path is given after +
	public static final String TESTDATAFILE = System.getProperty("user.dir")+ "\\src\\test\\resources\\TestData_Project_Login.xlsx";
	public static final String LOGINSHEET = "LoginPage"; //Sheetname of excel utility is "LoginPage". LOGINSHEET is the static final (to avoid changing it anywhere else) variable.
	public static final String HOMESHEET = "HomePage";
}
