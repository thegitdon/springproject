package co.com.toject.repository;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import co.com.toject.DemotojectApplication;

//@Repository
public class TestRepoImpl extends DemotojectApplication implements ITestRepo {

	@Override
	public void showInfo(String name) {
		// TODO Auto-generated method stub
		lInfo.info("Hi there, " + name + "!");

	}

}
