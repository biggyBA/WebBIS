package ba.biggy.testPackage;

import java.util.List;

import ba.biggy.testPackage.TestModel;

public interface TestModelDAO {
	
	public void saveOrUpdate(TestModel testModel);
	
	public void deleteTestModel(int testModelId);
	
	public TestModel get(int testModelId);
	
	public List<TestModel> list();

}
