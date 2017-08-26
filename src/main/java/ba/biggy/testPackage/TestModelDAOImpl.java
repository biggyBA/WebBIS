package ba.biggy.testPackage;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import ba.biggy.testPackage.TestModel;
import ba.biggy.testPackage.TestModelDAO;

public class TestModelDAOImpl implements TestModelDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public TestModelDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public void saveOrUpdate(TestModel testModel) {
		if (testModel.getId() > 0) {
	        // update
	        String sql = "UPDATE testtable SET valueOne=?, valueTwo=? WHERE id=?";
	        jdbcTemplate.update(sql, testModel.getValueOne(), testModel.getValueTwo(), testModel.getId());
	    } else {
	        // insert
	        String sql = "INSERT INTO testtable (valueOne, valueTwo)"
	                    + " VALUES (?, ?)";
	        jdbcTemplate.update(sql, testModel.getValueOne(), testModel.getValueTwo());
	    }
	}

	@Override
	public void deleteTestModel(int testModelId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TestModel get(int testModelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TestModel> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
