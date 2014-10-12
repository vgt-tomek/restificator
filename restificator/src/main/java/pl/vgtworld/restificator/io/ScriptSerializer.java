package pl.vgtworld.restificator.io;

import pl.vgtworld.restificator.data.RestificatorExecutionData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class ScriptSerializer {

	public void save(RestificatorExecutionData data, String filepath) throws SaveException {
		save(data, new File(filepath));
	}

	public void save(RestificatorExecutionData data, File file) throws SaveException {
		try {
			JAXBContext context = JAXBContext.newInstance(RestificatorExecutionData.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(data, file);
		} catch (JAXBException e) {
			throw new SaveException("Unable to serialize data.", e);
		}
	}

}
