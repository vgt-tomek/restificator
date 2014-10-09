package pl.vgtworld.restificator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
public class CdiTestService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CdiTestService.class);

	public void doSomething() {
		LOGGER.info("Doing something");
	}
}
