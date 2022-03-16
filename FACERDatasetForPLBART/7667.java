    @Override
    public void colorChanged( int color ) {
        if( pref_key != null ) {
            ck.setColor( pref_key, color );
            pref_key = null;
        }
    }

