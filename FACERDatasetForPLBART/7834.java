    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences prefs = getPreferences( MODE_PRIVATE );
        if( prefs != null )
            encoding = prefs.getString( SP_ENC, "" );
        uri = getIntent().getData();
        if( !loadData() )
            finish();
        TextView file_name_tv = (TextView)findViewById( R.id.file_name );
        if( uri != null ) {
            String path = uri.getPath();
            if( file_name_tv != null && path != null && path.length() > 0 )
                file_name_tv.setText( " - " + path );
        }
    }

