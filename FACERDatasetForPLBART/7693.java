    protected void outCmd( boolean use_bb, String cmd, OutputStreamWriter os ) 
              throws IOException, InterruptedException { 
        String to_exec = ( use_bb ? bb : "" ) + cmd + "\n";
        Log.v( TAG, "executing: " + to_exec );
        os.write( to_exec ); // execute the command
        os.flush();

        final int swait = 10;
        final int tries = wait_timeout / swait; 
        for( int i = 0; i < tries; i++ ) {
            if( is.ready() ) break;
            Thread.sleep( swait );
        }
     }    

