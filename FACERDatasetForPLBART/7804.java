    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        
        layout = (LinearLayout)findViewById( R.id.sel_zone_setup );
        
        r_cb = (CheckBox)findViewById( R.id.sel_onright );
        if( r_cb != null ) {
            r_cb.setOnCheckedChangeListener( this );
            r_cb.setChecked( atRight );
        }
        width_seek = (SeekBar)findViewById( R.id.sel_width );
        if( width_seek != null ) {
            width_seek.setProgressDrawable( createSeekBarDrawable( sel_color ) );
            width_seek.setOnSeekBarChangeListener( this );
            width_seek.setProgress( width );
        }
    }

