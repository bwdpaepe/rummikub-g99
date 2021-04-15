package exceptions;

public class SpelerNietInDBException extends Exception {
		public SpelerNietInDBException()
		{
		super("Geef een correcte spelersnaam paswoord combinatie!");
		}

		public SpelerNietInDBException(String msg)
		{  super(msg);   }

		public SpelerNietInDBException(Throwable cause)
		{  super(cause);    }

		public SpelerNietInDBException(String message, Throwable cause)
		{  super(message, cause);   }
		}
