    protected boolean procError( BufferedReader es ) throws IOException {
        while( es.ready() ) {
            String err_str = es.readLine();
            if( err_str.trim().length() > 0 ) {
                error( err_str );
                return true;
            }
        }
        if( isStopReq() ) {
            error( "Canceled" );
            return true;
        }
        return false;
    }

