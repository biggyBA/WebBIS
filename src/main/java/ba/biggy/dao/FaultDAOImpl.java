package ba.biggy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
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
	        String sql = "UPDATE serviceaddnewfaults SET ident=?, Buyer=? WHERE ID=?";
	        jdbcTemplate.update(sql, fault.getIdent(), fault.getClient(), fault.getId());
	    } else {
	        // insert
	        String sql = "INSERT INTO serviceaddnewfaults (ident, serialnumber, Buyer, address, Placefault, PhoneNumber, Phonenumber1, DescFaults, NotesInfo, Responsibleforfailure, OrderIssued, TypeOfService)"
	                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        jdbcTemplate.update(sql, fault.getIdent(), fault.getSerialNumber(), fault.getClient(), fault.getStreet(), fault.getPlace(), fault.getPhoneOne(), fault.getPhoneTwo(), 
	        			fault.getFaultDescription(), fault.getNote(), fault.getServiceman(), fault.getOrderBy(), fault.getTypeOfService());
	    }	
	}



	@Override
	public List<Fault> list() {
		String sql = "SELECT * FROM serviceaddnewfaults";
	    List<Fault> listFault = jdbcTemplate.query(sql, new RowMapper<Fault>() {
	 
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
	 
	    return listFault;
	}



	@Override
	public void delete(int faultId) {
		String sql = "DELETE FROM serviceaddnewfaults WHERE ID=?";
	    jdbcTemplate.update(sql, faultId);
	}

	
	
}
