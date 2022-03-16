    /** Called when the activity is first created. */
    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        try {
            SharedPreferences prefs = getPreferences( MODE_PRIVATE );
            if( prefs != null )
                encoding = prefs.getString( SP_ENC, "" );
            boolean ct_enabled = requestWindowFeature( Window.FEATURE_CUSTOM_TITLE );
            setContentView(R.layout.editor);
            te = (EditText)findViewById( R.id.editor );
            te.addTextChangedListener( this );
            
            SharedPreferences shared_pref = PreferenceManager.getDefaultSharedPreferences( this );
            int fs = Integer.parseInt( shared_pref != null ? shared_pref.getString( "font_size", "12" ) : "12" );
            te.setTextSize( fs );
            
            ColorsKeeper ck = new ColorsKeeper( this );
            ck.restore();
            te.setBackgroundColor( ck.bgrColor );
            te.setTextColor( ck.fgrColor );
            
            if( ct_enabled ) {
                getWindow().setFeatureInt( Window.FEATURE_CUSTOM_TITLE, R.layout.atitle );
                TextView act_name_tv = (TextView)findViewById( R.id.act_name );
                if( act_name_tv != null )
                    act_name_tv.setText( R.string.editor_label );
            }
            uri = getIntent().getData();
            new DataLoadTask().execute();
            TextView file_name_tv = (TextView)findViewById( R.id.file_name );
            if( file_name_tv!= null )
                file_name_tv.setText( " - " + uri.getPath() );
        }
        catch( Exception e ) {
            Log.e( TAG, "", e );
        }
    }

