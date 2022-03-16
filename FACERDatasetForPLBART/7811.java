    @Override
    public void onCreate( Bundle savedInstanceState ) {
        try {
            super.onCreate( savedInstanceState );
            
            schema = getIntent().getStringExtra( "schema" );
            String p_name = "...";
            if( schema.equals( "ftp" ) ) {
                type = Type.FTP;
                p_name = "FTP";
            } else
            if( schema.equals( "smb" ) ) {
                type = Type.SMB;
                p_name = "Windows PC";
            } else
                type = Type.UNKNOWN;

            // "Leave fields blank to see a list of nodes"
            
            setTitle( getString( R.string.connect ) + " " + p_name );
            requestWindowFeature( Window.FEATURE_LEFT_ICON );
            setContentView( R.layout.server );
            getWindow().setLayout(LayoutParams.FILL_PARENT /* width */, LayoutParams.WRAP_CONTENT /* height */);            
            getWindow().setFeatureDrawableResource( Window.FEATURE_LEFT_ICON, 
             type == Type.SMB ? R.drawable.smb : R.drawable.server );
            
            server_edit = (EditText)findViewById( R.id.server_edit );
            path_edit = (EditText)findViewById( R.id.path_edit );
            domain_edit = (EditText)findViewById( R.id.domain_edit );
            name_edit = (EditText)findViewById( R.id.username_edit );
            active_ftp_cb = (CheckBox)findViewById( R.id.active );            

            Button connect_button = (Button)findViewById( R.id.connect );
            connect_button.setOnClickListener( this );
            Button browse_button = (Button)findViewById( R.id.browse );
            browse_button.setOnClickListener( this );
            Button cancel_button = (Button)findViewById( R.id.cancel );
            cancel_button.setOnClickListener( this );

            if( type == Type.FTP ) {
                View domain_block = findViewById( R.id.domain_block );
                domain_block.setVisibility( View.GONE );
                browse_button.setVisibility( View.GONE );
                active_ftp_cb.setVisibility( View.VISIBLE );
            }
        }
        catch( Exception e ) {
            Log.e( TAG, "onCreate() Exception: ", e );
        }       
    }

