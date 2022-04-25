package callcenter;
// ----------------------------------------------------------
// AUTHORS
/*
Ali Osman BEKER
180315010
*/

/*
Mehmet Batuhan DUMAN
180315036
*/
// ----------------------------------------------------------

public class CallCenterSimulator
{
// --------------------------- main() method ---------------------------

    public static void main( String[] args )
    {

        for ( int i = 0; i < 2; i++ )
        {
            new ServiceAgent( i + 1 ).start();
        }
        new CallGenerator().start();
    }
}
