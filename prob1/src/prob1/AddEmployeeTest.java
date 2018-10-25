package prob1;

import org.junit.*;

public class AddEmployeeTest {
	String[] names = {"Joanne", "KD", "Bob", "Jane"};
	

	
	@Test
	public void test1() {
		Store store = new Store();
		store.addEmp(new Employee(names[rand11()],rand2()));
		int prevNumEmps = store.getNumEmps();
		store.addEmp(new Employee(names[rand11()],rand2()));
		
		Assert.assertEquals(store.getNumEmps(), prevNumEmps+1);
		
		
	}
	
	@Test
	public void test2() {
		Store store = new Store();
		store.addEmp(new Employee(names[rand11()],rand2()));
		int prevNumEmps = store.getNumEmps();
		store.addEmp(null);
		
		Assert.assertEquals(store.getNumEmps(), prevNumEmps);
	}
	
	@Test
	public void test3() {
		Store store = new Store();
		for(int i = 0; i < 19; i++)
			store.addEmp(new Employee(names[rand11()],rand2() ));
		
		Employee e = null;
		
		store.addEmp(e);
		Assert.assertEquals(store.getNumEmps(), 20);
		Assert.assertEquals(store.getEmp(19), null);

		
	}
	
	@Test
	public void test4() {
		Store store = new Store();
		for(int i = 0; i < 19; i++)
			store.addEmp(new Employee(names[rand11()],rand2() ));
		
		Employee e = new Employee(names[rand11()],rand2());
		
		store.addEmp(e);
		Assert.assertEquals(store.getNumEmps(), 20);
		Assert.assertEquals(store.getEmp(19), e);
	}
	
	
	int rand11() {
		return (int)(Math.random()*4);
	}
	
	int rand2() {
		return (int)(Math.random()*20);
	}
	
}
