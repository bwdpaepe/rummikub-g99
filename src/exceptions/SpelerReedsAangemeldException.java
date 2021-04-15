package exceptions;

public class SpelerReedsAangemeldException extends Exception{

	public SpelerReedsAangemeldException(){
		super("Geef een speler die nog niet is aangemeld!");
	}

	public SpelerReedsAangemeldException(String msg){  
		super(msg);   }

	public SpelerReedsAangemeldException(Throwable cause){  
		super(cause);    }

	public SpelerReedsAangemeldException(String message, Throwable cause){  
		super(message, cause);   }

}