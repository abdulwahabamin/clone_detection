    protected boolean execute() {
        os = null;
        is = null;
        es = null;
        try {
            Init( null );
            if( context != null ) {
                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences( context );
                bb = sharedPref.getString( "busybox_path", "busybox" ) + " ";
            }
            else
                bb = "busybox ";
            
            Process p = Runtime.getRuntime().exec( sh );
            
            os = new OutputStreamWriter( p.getOutputStream() );
            is = new BufferedReader( new InputStreamReader( p.getInputStream() ) );
            es = new BufferedReader( new InputStreamReader( p.getErrorStream() ) );
            if( where != null )
                outCmd( false, "cd '" + where + "'", os );
            boolean ok = cmdDialog( os, is, es );
            os.write( "exit\n" );
            os.flush();
            p.waitFor();
            int ev = p.exitValue();
            if( ev != 0 ) {
                Log.e( TAG, "Exit code " + ev );
                procError( es );
                if( errMsg == null || errMsg.length() == 0 )
                    error( "Exit code " + ev );
                return false;
            }
            return ok;
        }
        catch( Exception e ) {
            error( "Exception: " + e );
        }
        finally {
            try {
                if( os != null ) os.close();
                if( is != null ) is.close();
                if( es != null ) es.close();
            } catch( IOException e ) {
                e.printStackTrace();
            }
        }
        return false;
    }

