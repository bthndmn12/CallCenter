package callcenter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CallGenerator
    implements Runnable
{
// ------------------------------ FIELDS ------------------------------

    private SimpleDateFormat formatter;

    private Random random;

    private boolean running;

// --------------------------- CONSTRUCTORS ---------------------------

    public CallGenerator()
    {
        random = new Random();
        formatter = new SimpleDateFormat( "HH:mm:ss" );
    }

// ------------------------ INTERFACE METHODS ------------------------

// --------------------- Interface Runnable ---------------------
        //ARAMAYI ÜRETEN
    @Override
    public void run()
    {
        for (int i = 0; i < 20; i++){
            int duration = random.nextInt( 5 );
            if ( duration > 0 )
            {
                log( "Creating a call with a duration of " + duration + " minute" );
                CallQueue.queueCall( duration );
                sleep();
            }
        }
    }

// -------------------------- OTHER METHODS --------------------------


    public void start()
    {
        running = true;
        new Thread( this ).start();
    }

    public void stop()
    {
        running = false;
    }

    private void log( String s )
    {
        System.out.println( "[" + formatter.format( new Date() ) + "][CallGenerator] " + s );
    }

    private void sleep()
    {
        try
        {
            int sleep = random.nextInt( 2 * 60 );
            //log( "going to sleep " + sleep + " seconds" );
            Thread.sleep( sleep * 100 );
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
    }
}
