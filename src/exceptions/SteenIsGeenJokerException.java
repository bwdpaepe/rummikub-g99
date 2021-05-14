package exceptions;

public class SteenIsGeenJokerException extends Exception{

	public SteenIsGeenJokerException(){
		super("De geselecteerde steen is geen joker!");
	}

	public SteenIsGeenJokerException(String msg){  
		super(msg);   }

	public SteenIsGeenJokerException(Throwable cause){  
		super(cause);    }

	public SteenIsGeenJokerException(String message, Throwable cause){  
		super(message, cause);   }

}