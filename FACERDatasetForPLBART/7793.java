        @Override
        public void run() {
            setName( "ContentEngine" );
            OutputStreamWriter osw = null;
            BufferedReader     ebr = null;
            try {
                Process process = Runtime.getRuntime().exec( "su" );
                os = process.getOutputStream();
                ebr = new BufferedReader( new InputStreamReader( process.getErrorStream() ) );
                osw = new OutputStreamWriter( os );
                is = process.getInputStream();
                
                osw.write( "cat " + ExecEngine.prepFileName( file_path ) + "\n" );
                osw.flush();
                for( int i = 0; i < 5; i++ ) {
                    Thread.sleep( 10 );
                    if( is.available() > 0 ) break;
                    //Log.v( TAG, "Waiting the stream starts " + i );
                }
                boolean empty = is.available() <= 0; 
                synchronized( this ) {
                    open_done = true;
                }
                for( int i = 0; i < 4; i++ ) {
                    //Log.v( TAG, "Waiting loop " + i );
                    synchronized( this ) {
                        //Log.v( TAG, "Waiting the stream can be closed " + i );
                        wait( 500 );
                        if( empty ) {
                            //Log.v( TAG, "We know the stream is empty, so won't let other thread waste precious time!" );
                            break;
                        }
                        if( may_close ) {
                            //Log.v( TAG, "Reading finished, now may be closed" );
                            break;
                        }
                        /*
                        try {
                            Log.v( TAG, "Checking is there any data " + i );
                            if( is.available() > 0 ) // there still data
                                i = 0;
                        }
                        catch( IOException e ) {
                            Log.e( TAG, "waiting " + i, e );
                        }
                        */
                    }
                }
                osw.write( "exit\n" );
                osw.flush();
                //Log.v( TAG, "Waitng the process exits" );
                process.waitFor();
                //Log.v( TAG, "The process has exited" );
                if( process.exitValue() != 0 ) {
                    Log.e( TAG, "Exit code " + process.exitValue() );
                }
                if( ebr.ready() ) {
                    String err_str = ebr.readLine();
                    if( err_str.trim().length() > 0 ) {
                        Log.e( TAG, "Error:\n" + err_str );
                    }
                }
            }
            catch( Exception e ) {
                Log.e( TAG, null, e );
            }
            finally {
                try {
                    if( osw != null ) osw.close();
                    if( ebr != null ) ebr.close();
                    if( is  != null ) is.close();
                } catch( IOException e ) {
                    e.printStackTrace();
                }
            }
        }

