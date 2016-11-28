package controllers.responses;


public class SuccessResponse extends EndpointResponse {

	public SuccessResponse(Object jsonNode) {
		super("ok", jsonNode, null);
	}
}
