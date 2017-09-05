package ba.biggy.global;

public class Constants {
	
	//Table to store faults 
	public static final String TABLE_FAULTS = "serviceaddnewfaults";
	
	//Column names in faults table
	public static final String ID_COLUMN = "ID";
	public static final String DATE_COLUMN = "datefault";
	public static final String TIME_COLUMN = "timefault";
	public static final String IDENT_COLUMN = "ident";
	public static final String SERIAL_NUMBER_COLUMN = "serialnumber";
	public static final String CLIENT_COLUMN = "Buyer";
	public static final String STREET_COLUMN = "address";
	public static final String PLACE_COLUMN = "Placefault";
	public static final String PHONE_ONE_COLUMN = "PhoneNumber";
	public static final String PHONE_TWO_COLUMN = "Phonenumber1";
	public static final String FAULT_DESCRIPTION_COLUMN = "DescFaults";
	public static final String NOTE_COLUMN = "NotesInfo";
	public static final String SERVICEMAN_COLUMN = "Responsibleforfailure";
	public static final String STATUS_COLUMN = "Status";
	public static final String PRIORITY_COLUMN = "priorities";
	public static final String ORDER_BY_COLUMN = "OrderIssued";
	public static final String TYPE_OF_SERVICE_COLUMN = "TypeOfService";
	
	
	public static final String FAULT_STATUS_SERVICE_DONE = "ServiceDone";
	public static final String FAULT_STATUS_TO_DO = "UrgentToDo";

}
