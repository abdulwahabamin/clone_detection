    private final void flushReply() {
        try {
            while( inputStream.available() > 0 )
                inputStream.read();
        }
        catch( IOException e ) {
            Log.e( TAG, "", e );
        }
    }

