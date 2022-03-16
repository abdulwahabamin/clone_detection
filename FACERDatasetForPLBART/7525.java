    private final boolean addView( int i, ColorsKeeper.FileTypeColor ftc ) {
        try {
            RelativeLayout tl = (RelativeLayout)infl.inflate( R.layout.type, ctr, false );
            View b = tl.findViewById( R.id.b );
            Integer idx = new Integer( i );
            b.setTag( idx );
            b.setOnClickListener( this );
            TextView s = (TextView)tl.findViewById( R.id.s );
            s.setTag( idx );
            s.setTextColor( ftc.color );
            s.setBackgroundColor( ck.bgrColor );
            EditText t = (EditText)tl.findViewById( R.id.types );
            t.setText( ftc.masks );
            ctr.addView( tl );
            return true;
        } catch( Exception e ) {
            Log.e( TAG, ftc.masks, e );
        }
        return false;
    }

