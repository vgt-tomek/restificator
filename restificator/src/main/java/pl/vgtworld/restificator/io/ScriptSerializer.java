package pl.vgtworld.restificator.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.vgtworld.restificator.data.RestificatorExecutionData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class ScriptSerializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScriptSerializer.class);

	public void save(RestificatorExecutionData data, String filepath) throws SaveException {
		save(data, new File(filepath));
	}

	public void save(RestificatorExecutionData data, File file) throws SaveException {
		try {
			JAXBContext context = JAXBContext.newInstance(RestificatorExecutionData.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(data, file);
		} catch (JAXBException e) {
			LOGGER.warn("JAXBException throwed while saving script file.", e);
			throw new SaveException("Erorr while trying to save file.", e);
		}
	}

}
