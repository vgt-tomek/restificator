package pl.vgtworld.restificator.stats;

import java.util.ArrayList;
import java.util.List;

public class ExecutionStatistics {
	
	List<ExecutedRequest> executedRequests = new ArrayList<>();
	
	public void addExecutedRequest(String name, String request, String response, long startTime, long endTime) {
		ExecutedRequest executedRequest = new ExecutedRequest(name, request, response, startTime, endTime);
		executedRequests.add(executedRequest);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (ExecutedRequest request : executedRequests) {
			builder.append(request).append("\n");
		}
		return builder.toString();
	}
	
}
