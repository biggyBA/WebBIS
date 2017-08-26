package ba.biggy.dao;

import java.util.List;

import ba.biggy.model.Fault;

public interface FaultDAO {
	
	public void saveOrUpdate (Fault fault);
	
	public List<Fault> list();
	
	public void delete(int faultId);

}
