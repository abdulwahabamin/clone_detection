    private final void highlightTitle( int which, boolean on ) {
        TextView title = (TextView)mainView.findViewById( titlesIds[which] );
        if( title != null ) {
            if( on ) {
                Drawable d = Utils.getShading( ck.selColor );
                if( d != null )
                    title.setBackgroundDrawable( d );
                else
                    title.setBackgroundColor( ck.selColor );
                title.setTextColor( ck.sfgColor );
            }
            else {
                title.setBackgroundColor( ck.selColor & 0x0FFFFFFF );
                float[] fgr_hsv = new float[3];
                Color.colorToHSV( ck.fgrColor, fgr_hsv );
                float[] ttl_hsv = new float[3];
                Color.colorToHSV( ck.ttlColor, ttl_hsv );
                fgr_hsv[1] *= 0.5;
                fgr_hsv[2] = ( fgr_hsv[2] + ttl_hsv[2] ) / 2;
                title.setTextColor( Color.HSVToColor( fgr_hsv ) );
            }
        }
        else
            Log.e( TAG, "title view was not found!" );
    }

