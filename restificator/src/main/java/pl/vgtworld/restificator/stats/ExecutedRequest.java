package pl.vgtworld.restificator.stats;

class ExecutedRequest {
	
	private String name;
	
	private String request;
	
	private ResponseData response;
	
	private long startTime;
	
	private long endTime;

	public ExecutedRequest(String name, String request, String response, long startTime, long endTime) {
		this.name = name;
		this.request = request;
		this.response = new ResponseData(response);
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return String.format(
				"%s: Response:%s, Time:%dms",
				name,
				response.getStatusCode(),
				endTime - startTime
				);
	}

}
