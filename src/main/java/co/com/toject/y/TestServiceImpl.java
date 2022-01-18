package co.com.toject.y;

import co.com.toject.x.ITestRepo;
import co.com.toject.x.TestRepoImpl;

//@Service
public class TestServiceImpl implements ITestService {

	// @Autowired //instancia
	private ITestRepo testRepo;

	@Override
	public void showInfo(String name) {
		// TODO Auto-generated method stub
		testRepo = new TestRepoImpl(); // stereotype
		testRepo.showInfo(name);

	}

}
