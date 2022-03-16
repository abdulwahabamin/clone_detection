    public void toLog() {
        StringBuffer resb = new StringBuffer();
        for( int i = 0; i < array.size(); i++ ) {
            resb.append( array.get( i ).getCaption() );
            resb.append( "-" );
            resb.append( array.get( i ).isVisible() );
            resb.append( ", " );
        }
        Log.v( TAG, resb.toString() );        
    }

