    public void setFingerFriendly( boolean finger_friendly, int font_size ) {
        fingerFriendly = finger_friendly;
        try {
            for( int p = LEFT; p <= RIGHT; p++ ) {
                TextView title = (TextView)c.findViewById( titlesIds[p] );
                if( title != null ) {
                    title.setTextSize( font_size );
                    if( finger_friendly )
                        title.setPadding( 8, 10, 8, 10 );
                    else
                        title.setPadding( 8, 4, 8, 4 );
                }
                if( list[p] != null )
                    list[p].setFingerFriendly( finger_friendly );
            }
            locationBar.setFingerFriendly( finger_friendly, font_size );
        }
        catch( Exception e ) {
            Log.e( TAG, null, e );
        }
    }

