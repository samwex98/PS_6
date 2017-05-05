package base;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {

	private static PersonDomainModel per1 = new PersonDomainModel();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		per1.setBirthday(new Date(0));
		per1.setCity("Townsend");
		per1.setFirstName("Bert");
		per1.setLastName("Gibbons");
		per1.setPostalCode(19734);
		per1.setStreet("214 Labrador Lane");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void AddPerson() {
		PersonDomainModel per2 = new PersonDomainModel();
		per2.setBirthday(new Date(0));
		per2.setCity("Cairo");
		per2.setFirstName("Star");
		per2.setLastName("Platinum");
		per2.setPostalCode(19734);
		per2.setStreet("8675 Electric Avenue");
		
		PersonDAL.addPerson(per2);
		
		PersonDomainModel per3 = PersonDAL.getPerson(per2.getPersonID());
		assertNotNull(per3);
		
		
	}
	
	@Test
	public void DeletePerson(){
		PersonDomainModel per2 = per1;
		PersonDAL.deletePerson(per2.getPersonID());
		PersonDomainModel per3 = per2;
		
		assertNull(per3);
		
		
	}
	
	@Test
	public void UpdatePerson(){	
		PersonDomainModel per2 = PersonDAL.getPerson(per1.getPersonID());
		assertEquals(per1.getPersonID(), per2.getPersonID());
		per2.setLastName("Lundgrin");
		PersonDAL.updatePerson(per2);
		PersonDomainModel per3 = PersonDAL.getPerson(per2.getPersonID());
		assertEquals(per2.getLastName(), per3.getLastName());
		assertNotEquals(per1.getLastName(), per2.getLastName());
	}
	
}