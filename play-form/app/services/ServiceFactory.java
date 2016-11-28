package services;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ServiceFactory {
	
	private ServiceFake fakeService;
	private ServiceImpl realService;
	
	@Inject 
	public ServiceFactory(ServiceFake fakeService,
			ServiceImpl realService) {
		this.fakeService = fakeService;
		this.realService = realService;
	}
	
	public final MyService getService() {
		return realService;
	}
}
