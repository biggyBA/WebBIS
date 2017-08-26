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
	            Fault aFaults = new Fault();
	 
	            aFaults.setId(rs.getInt("ID"));
	            aFaults.setIdent(rs.getString("ident"));
	            //aFaults.setEmail(rs.getString("email"));
	            //aFaults.setAddress(rs.getString("address"));
	            //aFaults.setTelephone(rs.getString("telephone"));
	 
	            return aFaults;
	        }
	 
	    });
	 
	    return listFault;
	}

	
	
}
