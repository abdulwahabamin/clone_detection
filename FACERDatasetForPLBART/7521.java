    @Override
    public void onCreate( Bundle bundle ) {
        try {
            super.onCreate( bundle );

            ck = new ColorsKeeper( this );
            ck.restore();
            int n = ck.restoreTypeColors();
            setContentView( R.layout.types );
            View b0 = findViewById( R.id.b0 );
            b0.setOnClickListener( this );
            b0.setTag( new Integer( 0 ) );
            TextView s0 = (TextView)findViewById( R.id.s0 );
            s0.setTextColor( ck.fgrColor );
            s0.setBackgroundColor( ck.bgrColor );
            ctr = (LinearLayout)findViewById( R.id.types_container );
            infl = getLayoutInflater();
            for( int i = 1; i <= n; i++ )
                addView( i, ck.ftColors.get( i - 1 ) );
            View antb = findViewById( R.id.add_new_type );
            antb.setOnClickListener( this );
        } catch( Exception e ) {
            Log.e( TAG, null, e );
        }
    }

