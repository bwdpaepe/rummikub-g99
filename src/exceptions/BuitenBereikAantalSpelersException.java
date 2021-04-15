package exceptions;

public class BuitenBereikAantalSpelersException extends IllegalArgumentException
{
public BuitenBereikAantalSpelersException()
{
super("Aantal Spelers moet binnen zijn range liggen!");
}

public BuitenBereikAantalSpelersException(String msg)
{  super(msg);   }

public BuitenBereikAantalSpelersException(Throwable cause)
{  super(cause);    }

public BuitenBereikAantalSpelersException(String message, Throwable cause)
{  super(message, cause);   }
}


