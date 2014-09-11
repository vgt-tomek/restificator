package pl.vgtworld.restificator.loader;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.vgtworld.restificator.data.RestificatorExecutionData;

public class ScriptLoader {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ScriptLoader.class);
	
	public RestificatorExecutionData load(String path) throws LoadException {
		return load(new File(path));
	}
	
	public RestificatorExecutionData load(File file) throws LoadException {
		try {
			if (!file.exists() || !file.isFile()) {
				throw new LoadException("File not found.");
			}
			JAXBContext context = JAXBContext.newInstance(RestificatorExecutionData.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			RestificatorExecutionData scriptData = (RestificatorExecutionData) unmarshaller.unmarshal(file);
			if (scriptData == null) {
				throw new LoadException("Null result from parsing script file.");
			}
			return scriptData;
		} catch (JAXBException e) {
			LOGGER.debug("JAXBException throwed while loading script file.", e);
			throw new LoadException(e.getMessage(), e);
		}
	}
	
}
