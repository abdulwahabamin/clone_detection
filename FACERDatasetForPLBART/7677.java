    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sliders = findViewById( R.id.rgb_sliders ); 
        r_seek = (SeekBar)findViewById( R.id.r_seek );
        r_seek = (SeekBar)findViewById( R.id.r_seek );
        g_seek = (SeekBar)findViewById( R.id.g_seek );
        b_seek = (SeekBar)findViewById( R.id.b_seek );
        if( r_seek != null ) {
            r_seek.setOnSeekBarChangeListener( this );
            r_seek.setProgress( Color.red( curColor ) );
        }
        if( g_seek != null ) {
            g_seek.setOnSeekBarChangeListener( this );
            g_seek.setProgress( Color.green( curColor ) );
        }
        if( b_seek != null ) {
            b_seek.setOnSeekBarChangeListener( this );
            b_seek.setProgress( Color.blue( curColor ) );
        }
        preview = findViewById(R.id.preview);
        if( preview != null )
            preview.setBackgroundColor( curColor );

        if( defColor != 0 ) {
            View dcv = findViewById( R.id.default_color );
            if( dcv != null ) {
                dcv.setVisibility( View.VISIBLE );
                dccb = (CheckBox)dcv;
                dccb.setOnCheckedChangeListener( this );
                dccb.setChecked( curColor == 0 );
            }
        }
    }

