package app.data;

/*Owner: Jmmy*/
public class DefaultData {
	public static void load() {
		
		UserData.load();
		EmployeeData.load();
		BranchData.loadData();
		DepartmentData.loadData();
	}
}
