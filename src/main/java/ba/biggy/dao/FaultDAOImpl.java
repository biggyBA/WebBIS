package ba.biggy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import ba.biggy.global.Constants;
import ba.biggy.model.Fault;

public class FaultDAOImpl implements FaultDAO {
	
	
	
	private JdbcTemplate jdbcTemplate;
	
	public FaultDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

	
	/**
	 * Inserts or updates a fault
	 */
	@Override
	public void saveOrUpdate(Fault fault) {
		if (fault.getId() > 0) {
	        // update
	        String sql = "UPDATE " + Constants.TABLE_FAULTS + " SET "
	        		+ Constants.IDENT_COLUMN + "=?, "
	        		+ Constants.SERIAL_NUMBER_COLUMN + "=?, "
	        		+ Constants.CLIENT_COLUMN + "=?, "
	        		+ Constants.STREET_COLUMN + "=?, "
	        		+ Constants.PLACE_COLUMN + "=?, "
	        		+ Constants.PHONE_ONE_COLUMN + "=?, "
	        		+ Constants.PHONE_TWO_COLUMN + "=?, "
	        		+ Constants.FAULT_DESCRIPTION_COLUMN + "=?, "
	        		+ Constants.NOTE_COLUMN + "=?, "
	        		+ Constants.SERVICEMAN_COLUMN + "=?, "
	        		+ Constants.ORDER_BY_COLUMN + "=?, "
	        		+ Constants.TYPE_OF_SERVICE_COLUMN + "=? "
	        		+ "WHERE " 
	        		+ Constants.ID_COLUMN + "=?";
	        jdbcTemplate.update(sql, 
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
        			fault.getOrderBy(), 
        			fault.getTypeOfService(), 
        			fault.getId());
	    } else {
	        // insert
	        String sql = "INSERT INTO " + Constants.TABLE_FAULTS + " ("
	        		+ Constants.DATE_COLUMN + ", "
	        		+ Constants.TIME_COLUMN + ", "
	        		+ Constants.IDENT_COLUMN + ", "
	        		+ Constants.SERIAL_NUMBER_COLUMN + ", "
	        		+ Constants.CLIENT_COLUMN + ", "
	        		+ Constants.STREET_COLUMN + ", "
	        		+ Constants.PLACE_COLUMN + ", "
	        		+ Constants.PHONE_ONE_COLUMN + ", "
	        		+ Constants.PHONE_TWO_COLUMN + ", "
	        		+ Constants.FAULT_DESCRIPTION_COLUMN + ", "
	        		+ Constants.NOTE_COLUMN + ", "
	        		+ Constants.SERVICEMAN_COLUMN + ", "
	        		+ Constants.STATUS_COLUMN + ", "
	        		+ Constants.PRIORITY_COLUMN + ", "
	        		+ Constants.ORDER_BY_COLUMN + ", "
	        		+ Constants.TYPE_OF_SERVICE_COLUMN + ")"
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
	
	
	/**
	 * Returns a list of faults with status "UrgentToDo" in Status column
	 */
	@Override
	public List<Fault> listToDoFaults() {
		String sql = "SELECT * FROM " + Constants.TABLE_FAULTS + " WHERE " + Constants.STATUS_COLUMN + " = '"+ Constants.FAULT_STATUS_TO_DO +"'";
	    List<Fault> faultsToDo = jdbcTemplate.query(sql, new RowMapper<Fault>() {
	 
	        @Override
	        public Fault mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Fault faults = new Fault();
	 
	            faults.setId(rs.getInt(Constants.ID_COLUMN));
	            faults.setDate(rs.getString(Constants.DATE_COLUMN));
	            faults.setTime(rs.getString(Constants.TIME_COLUMN));
	            faults.setIdent(rs.getString(Constants.IDENT_COLUMN));
	            faults.setClient(rs.getString(Constants.CLIENT_COLUMN));
	            faults.setStreet(rs.getString(Constants.STREET_COLUMN));
	            faults.setPlace(rs.getString(Constants.PLACE_COLUMN));
	            faults.setPhoneOne(rs.getString(Constants.PHONE_ONE_COLUMN));
	            faults.setPhoneTwo(rs.getString(Constants.PHONE_TWO_COLUMN));
	            faults.setFaultDescription(rs.getString(Constants.FAULT_DESCRIPTION_COLUMN));
	            faults.setNote(rs.getString(Constants.NOTE_COLUMN));
	            faults.setServiceman(rs.getString(Constants.SERVICEMAN_COLUMN));
	            faults.setTypeOfService(rs.getString(Constants.TYPE_OF_SERVICE_COLUMN));
	     
	            return faults;
	        }
	 
	    });
	 
	    return faultsToDo;
	}


	/**
	 * Deletes a fault with a specified id
	 */
	@Override
	public void delete(int faultId) {
		String sql = "DELETE FROM " + Constants.TABLE_FAULTS + " WHERE " + Constants.ID_COLUMN + "=?";
	    jdbcTemplate.update(sql, faultId);
	}


	/**
	 * Returns a fault object with a specific id
	 */
	@Override
	public Fault getFaultById(int faultId) {
		String sql = "SELECT * FROM " + Constants.TABLE_FAULTS + " WHERE " + Constants.ID_COLUMN + "=" + faultId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Fault>() {

			@Override
			public Fault extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Fault fault = new Fault();
					
					fault.setId(rs.getInt(Constants.ID_COLUMN));
					fault.setDate(rs.getString(Constants.DATE_COLUMN));
		            fault.setTime(rs.getString(Constants.TIME_COLUMN));
		            fault.setIdent(rs.getString(Constants.IDENT_COLUMN));
		            fault.setClient(rs.getString(Constants.CLIENT_COLUMN));
		            fault.setStreet(rs.getString(Constants.STREET_COLUMN));
		            fault.setPlace(rs.getString(Constants.PLACE_COLUMN));
		            fault.setPhoneOne(rs.getString(Constants.PHONE_ONE_COLUMN));
		            fault.setPhoneTwo(rs.getString(Constants.PHONE_TWO_COLUMN));
		            fault.setFaultDescription(rs.getString(Constants.FAULT_DESCRIPTION_COLUMN));
		            fault.setNote(rs.getString(Constants.NOTE_COLUMN));
		            fault.setServiceman(rs.getString(Constants.SERVICEMAN_COLUMN));
		            fault.setTypeOfService(rs.getString(Constants.TYPE_OF_SERVICE_COLUMN));
		            
					return fault;
				}
				return null;
			}
			
		});
	}


	/**
	 * Sets a fault status in Status column from "UrgentToDo" to "ServiceDone"
	 */
	@Override
	public void archiveFault(int faultId) {
		String sql = "UPDATE " + Constants.TABLE_FAULTS + " SET " + Constants.STATUS_COLUMN + "=? WHERE " + Constants.ID_COLUMN + "=?";
        jdbcTemplate.update(sql, Constants.FAULT_STATUS_SERVICE_DONE, faultId);
	}


	/**
	 * Returns a list of faults with status "ServiceDone" in Status column
	 */
	@Override
	public List<Fault> listDoneFaults() {
		String sql = "SELECT * FROM " + Constants.TABLE_FAULTS + " WHERE " + Constants.STATUS_COLUMN + " = '"+ Constants.FAULT_STATUS_SERVICE_DONE +"'";
	    List<Fault> faultsDone = jdbcTemplate.query(sql, new RowMapper<Fault>() {
	 
	        @Override
	        public Fault mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Fault faults = new Fault();
	 
	            faults.setId(rs.getInt(Constants.ID_COLUMN));
	            faults.setDate(rs.getString(Constants.DATE_COLUMN));
	            faults.setTime(rs.getString(Constants.TIME_COLUMN));
	            faults.setIdent(rs.getString(Constants.IDENT_COLUMN));
	            faults.setClient(rs.getString(Constants.CLIENT_COLUMN));
	            faults.setStreet(rs.getString(Constants.STREET_COLUMN));
	            faults.setPlace(rs.getString(Constants.PLACE_COLUMN));
	            faults.setPhoneOne(rs.getString(Constants.PHONE_ONE_COLUMN));
	            faults.setPhoneTwo(rs.getString(Constants.PHONE_TWO_COLUMN));
	            faults.setFaultDescription(rs.getString(Constants.FAULT_DESCRIPTION_COLUMN));
	            faults.setNote(rs.getString(Constants.NOTE_COLUMN));
	            faults.setServiceman(rs.getString(Constants.SERVICEMAN_COLUMN));
	            faults.setTypeOfService(rs.getString(Constants.TYPE_OF_SERVICE_COLUMN));
	     
	            return faults;
	        }
	 
	    });
	 
	    return faultsDone;
	}

	
	
	

	
	
	
	
	
}
