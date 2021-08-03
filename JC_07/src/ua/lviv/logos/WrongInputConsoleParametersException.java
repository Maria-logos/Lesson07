package ua.lviv.logos;

public class WrongInputConsoleParametersException extends Exception{
	
	public WrongInputConsoleParametersException(String inputMonth) {
		super(inputMonth);
		this.inputMonth = inputMonth;
	}

	private String inputMonth;

	private String getInputMonth() {
		return inputMonth;
	}

	private void setInputMonth(String inputMonth) {
		this.inputMonth = inputMonth;
	}
	

}
