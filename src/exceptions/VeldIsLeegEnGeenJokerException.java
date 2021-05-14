package exceptions;

public class VeldIsLeegEnGeenJokerException extends Exception{
	public VeldIsLeegEnGeenJokerException(){
		super("De cel bevat geen steen!");
	}

	public VeldIsLeegEnGeenJokerException(String msg){  
		super(msg);   }

	public VeldIsLeegEnGeenJokerException(Throwable cause){  
		super(cause);    }

	public VeldIsLeegEnGeenJokerException(String message, Throwable cause){  
		super(message, cause);   }

}
