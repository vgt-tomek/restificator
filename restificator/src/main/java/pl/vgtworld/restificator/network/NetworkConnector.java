package pl.vgtworld.restificator.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NetworkConnector {
	
	private Socket socket;
	
	public NetworkConnector(String host, int port) throws UnknownHostException, IOException {
		socket = new Socket(host, port);
	}
	
	public String makeRequest(String request) throws IOException {
		PrintWriter writer = null;
		Scanner scanner = null;
		writer = new PrintWriter(socket.getOutputStream());
		writer.write(request);
		writer.flush();
		scanner = new Scanner(socket.getInputStream());
		StringBuilder builder = new StringBuilder();
		while (scanner.hasNextLine()) {
			builder.append(scanner.nextLine()).append("\n");
		}
		writer.close();
		scanner.close();
		return builder.toString();
	}
	
}
