package ba.biggy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import ba.biggy.model.Fault;

public class FaultDAOImpl implements FaultDAO {
	
	
	
	private JdbcTemplate jdbcTemplate;
	
	public FaultDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

	
	
	@Override
	public void saveOrUpdate(Fault fault) {
		if (fault.getId() > 0) {
	        // update
	        String sql = "UPDATE serviceaddnewfaults SET ident=?, serialnumber=?, Buyer=?, address=?, Placefault=?, PhoneNumber=?, Phonenumber1=?, DescFaults=?, NotesInfo=?, Responsibleforfailure=?, "
	        		+ " OrderIssued=?, TypeOfService=? WHERE ID=?";
	        jdbcTemplate.update(sql, fault.getIdent(), fault.getSerialNumber(), fault.getClient(), fault.getStreet(), fault.getPlace(), fault.getPhoneOne(), fault.getPhoneTwo(), 
        			fault.getFaultDescription(), fault.getNote(), fault.getServiceman(), fault.getOrderBy(), fault.getTypeOfService(), fault.getId());
	    } else {
	        // insert
	        String sql = "INSERT INTO serviceaddnewfaults ("
	        		+ "datefault, "
	        		+ "timefault, "
	        		+ "ident, "
	        		+ "serialnumber, "
	        		+ "Buyer, "
	        		+ "address, "
	        		+ "Placefault, "
	        		+ "PhoneNumber, "
	        		+ "Phonenumber1, "
	        		+ "DescFaults, "
	        		+ "NotesInfo, "
	        		+ "Responsibleforfailure, "
	        		+ "Status, "
	        		+ "priorities, "
	        		+ "OrderIssued, "
	        		+ "TypeOfService)"
	                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        jdbcTemplate.update(sql,
	        		fault.getDate(),
	        		fault.getTime(),
	        		fault.getIdent(), 
	        		fault.getSerialNumber(), 
	        		fault.getClient(), 
	        		fault.getStreet(), 
	        		fault.getPlace(), 
	        		fault.getPhoneOne(), 
	        		fault.getPhoneTwo(), 
	        		fault.getFaultDescription(), 
	        		fault.getNote(), 
	        		fault.getServiceman(), 
	        		fault.getStatus(), 
	        		fault.getPriority(),
	        		fault.getOrderBy(), 
	        		fault.getTypeOfService());
	    }	
	}
	
	



	@Override
	public List<Fault> listToDoFaults() {
		String sql = "SELECT * FROM serviceaddnewfaults WHERE Status='UrgentToDo'";
	    List<Fault> faultsToDo = jdbcTemplate.query(sql, new RowMapper<Fault>() {
	 
	        @Override
	        public Fault mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Fault faults = new Fault();
	 
	            faults.setId(rs.getInt("ID"));
	            faults.setDate(rs.getString("datefault"));
	            faults.setTime(rs.getString("timefault"));
	            faults.setIdent(rs.getString("ident"));
	            faults.setClient(rs.getString("Buyer"));
	            faults.setStreet(rs.getString("address"));
	            faults.setPlace(rs.getString("Placefault"));
	            faults.setPhoneOne(rs.getString("PhoneNumber"));
	            faults.setPhoneTwo(rs.getString("PhoneNumber1"));
	            faults.setFaultDescription(rs.getString("DescFaults"));
	            faults.setNote(rs.getString("NotesInfo"));
	            faults.setServiceman(rs.getString("Responsibleforfailure"));
	            faults.setTypeOfService(rs.getString("TypeOfService"));
	     
	 
	            return faults;
	        }
	 
	    });
	 
	    return faultsToDo;
	}



	@Override
	public void delete(int faultId) {
		String sql = "DELETE FROM serviceaddnewfaults WHERE ID=?";
	    jdbcTemplate.update(sql, faultId);
	}



	@Override
	public Fault getFaultById(int faultId) {
		String sql = "SELECT * FROM serviceaddnewfaults WHERE ID=" + faultId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Fault>() {

			@Override
			public Fault extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Fault fault = new Fault();
					
					fault.setId(rs.getInt("ID"));
					fault.setDate(rs.getString("datefault"));
		            fault.setTime(rs.getString("timefault"));
		            fault.setIdent(rs.getString("ident"));
		            fault.setClient(rs.getString("Buyer"));
		            fault.setStreet(rs.getString("address"));
		            fault.setPlace(rs.getString("Placefault"));
		            fault.setPhoneOne(rs.getString("PhoneNumber"));
		            fault.setPhoneTwo(rs.getString("PhoneNumber1"));
		            fault.setFaultDescription(rs.getString("DescFaults"));
		            fault.setNote(rs.getString("NotesInfo"));
		            fault.setServiceman(rs.getString("Responsibleforfailure"));
		            fault.setTypeOfService(rs.getString("TypeOfService"));
		            
					return fault;
				}
				return null;
			}
			
		});
	}

	

	
	
	
	
	
}
