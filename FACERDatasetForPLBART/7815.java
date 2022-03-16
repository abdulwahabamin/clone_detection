    @Override
    protected void onRestoreInstanceState( Bundle savedInstanceState ) {
        try {
            server_edit.setText( savedInstanceState.getString( "SERV" ) );            
            path_edit.setText( savedInstanceState.getString( "PATH" ) );            
            name_edit.setText( savedInstanceState.getString( "USER" ) );            
            domain_edit.setText( savedInstanceState.getString( "DOMAIN" ) );            
            active_ftp_cb.setChecked( savedInstanceState.getBoolean( "ACTIVE", false ) );            
            super.onRestoreInstanceState(savedInstanceState);
        }
        catch( Exception e ) {
            Log.e( TAG, "onRestoreInstanceState() Exception: ", e );
        }
    }

