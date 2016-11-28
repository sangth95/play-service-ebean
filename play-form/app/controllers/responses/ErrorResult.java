package controllers.responses;

class ErrorResult {

	private final int status;

	private final String message;

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public ErrorResult(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

}