    @Override
    public void closeStream( Closeable s ) {
        try {
            noHeartBeats = false;
            if( s != null )
                s.close();
        } catch( IOException e ) {
            e.printStackTrace();
        }
    }

