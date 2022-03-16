    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        requestWindowFeature( Window.FEATURE_LEFT_ICON );
        setContentView( R.layout.perms );
        getWindow().setFeatureDrawableResource( Window.FEATURE_LEFT_ICON, android.R.drawable.ic_dialog_dialer );
        Intent i = getIntent();
        String perm = i.getStringExtra( "perm" );
        file_path = i.getStringExtra( "path" );
        if( perm == null || file_path == null ) {
            finish();
            return;
        }
        p = new Permissions( perm );
        populateControls();
    }

