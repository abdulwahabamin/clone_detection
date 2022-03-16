    @Override
    public void closeStream( Closeable is ) {
        if( zip != null ) {
            try {
                zip.close();
            } catch( IOException e ) {
                e.printStackTrace();
            }
            zip = null;
        }
    }

