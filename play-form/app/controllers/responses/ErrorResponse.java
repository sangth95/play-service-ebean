package controllers.responses;

public class ErrorResponse extends EndpointResponse {

	public ErrorResponse(int status, String message) {
		super("ko", null, new ErrorResult(status, message));
	}
}
