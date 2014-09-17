package pl.vgtworld.restificator.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class NetworkConnector {
	
	private String host;
	
	private int port;
	
	public NetworkConnector(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	public String makeRequest(String request) throws IOException {
		Socket socket = null;
		StringBuilder builder = new StringBuilder();
		try {
			socket = new Socket(host, port);
			PrintWriter writer = null;
			Scanner scanner = null;
			writer = new PrintWriter(socket.getOutputStream());
			writer.write(request);
			writer.flush();
			scanner = new Scanner(socket.getInputStream());
			while (scanner.hasNextLine()) {
				builder.append(scanner.nextLine()).append("\n");
			}
			writer.close();
			scanner.close();
		} finally {
			if (socket != null) {
				socket.close();
			}
		}
		return builder.toString();
	}
	
}
