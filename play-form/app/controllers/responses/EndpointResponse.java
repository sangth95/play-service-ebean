package controllers.responses;


class EndpointResponse {

	private final String result;

	private final Object response;
	
	private final ErrorResult error;

	public String getResult() {
		return result;
	}

	public Object getResponse() {
		return response;
	}

	public ErrorResult getError() {
		return error;
	}

	public EndpointResponse(String result, Object response, ErrorResult error) {
		super();
		this.result = result;
		this.response = response;
		this.error = error;
	}
}
