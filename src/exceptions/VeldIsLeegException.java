package exceptions;

public class VeldIsLeegException extends Exception{
	public VeldIsLeegException(){
		super("De cel bevat geen steen!");
	}

	public VeldIsLeegException(String msg){  
		super(msg);   }

	public VeldIsLeegException(Throwable cause){  
		super(cause);    }

	public VeldIsLeegException(String message, Throwable cause){  
		super(message, cause);   }

}
