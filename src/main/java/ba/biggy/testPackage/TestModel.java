package ba.biggy.testPackage;

public class TestModel {
	
	private int id;
	private String valueOne;
	private String valueTwo;
	
	public TestModel() {
		
	}
	
	public TestModel(String valueOne, String valueTwo) {
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
	}

	public String getValueOne() {
		return valueOne;
	}

	public void setValueOne(String valueOne) {
		this.valueOne = valueOne;
	}

	public String getValueTwo() {
		return valueTwo;
	}

	public void setValueTwo(String valueTwo) {
		this.valueTwo = valueTwo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
