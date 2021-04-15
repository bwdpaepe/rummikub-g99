package exceptions;

public class AlleSpelersReedsAangemeldException extends Exception{



	public AlleSpelersReedsAangemeldException(){
		super("Het aantal spelers werd reeds aangemeld!");
	}

	public AlleSpelersReedsAangemeldException(String msg){  
		super(msg);   }

	public AlleSpelersReedsAangemeldException(Throwable cause){  
		super(cause);    }

	public AlleSpelersReedsAangemeldException(String message, Throwable cause){  
		super(message, cause);   }

}