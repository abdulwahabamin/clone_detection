    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        try {
            boolean ct_enabled = requestWindowFeature( Window.FEATURE_CUSTOM_TITLE );
            setContentView( R.layout.textvw );
            SharedPreferences shared_pref = PreferenceManager.getDefaultSharedPreferences( this );
            int fs = Integer.parseInt( shared_pref != null ? shared_pref.getString( "font_size", "12" ) : "12" );
            text_view = (TextView)findViewById( R.id.text_view );
            text_view.setTextSize( fs );
            text_view.setTypeface( Typeface.create( "monospace", Typeface.NORMAL ) );

            ColorsKeeper ck = new ColorsKeeper( this );
            ck.restore();
            text_view.setBackgroundColor( ck.bgrColor );
            text_view.setTextColor( ck.fgrColor );
            
            if( ct_enabled ) {
                getWindow().setFeatureInt( Window.FEATURE_CUSTOM_TITLE, R.layout.atitle );
                TextView act_name_tv = (TextView)findViewById( R.id.act_name );
                if( act_name_tv != null )
                    act_name_tv.setText( R.string.textvw_label );
            }
            scrollView = (ScrollView)findViewById( R.id.scroll_view );
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
    }

