package Model;

public class Enums {
	public enum ActionName{
		
		SEARCH("search"), 
		ADD("add"), 
		UPDATE("update"), 
		DELETE("delete"),
		CLEAR("clear");
		 
		private String actionName;
	 
		private ActionName(String s) {
			actionName = s;
		}
	 
		public String getActionName() {
			return actionName;
		}
	}
	
	public enum ErrorsManage{
		
		BOOKID_EXISTS(-5),
		BOOKID_NOTFOUND(-6),
		
		INSERT_SUCCESSFULL(1),
		INSERT_FAIL(-1),
		
		UPDATE_SUCCESSFULL(2),
		UPDATE_FAIL(-2),
		
		DELETE_SUCCESSFULL(3),
		DELETE_FAIL(-3),
		
		DB_ERROR(-4);
		
		private int errorNumber;
	 
		private ErrorsManage(int numErr) {
			errorNumber = numErr;
		}
	 
		public int getErrorNumber() {
			return errorNumber;
		}
	}
}
