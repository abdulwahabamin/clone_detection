    @Override
    public void closeStream( Closeable is ) {
        try {
            if( is != null )
                is.close();
        } catch( IOException e ) {
            e.printStackTrace();
        }
    }

