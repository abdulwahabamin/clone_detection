    @Override
    protected void onSaveInstanceState( Bundle outState ) {
        try {
            outState.putString( "SERV", server_edit.getText().toString() );            
            outState.putString( "PATH", path_edit.getText().toString() );            
            outState.putString( "USER", name_edit.getText().toString() );            
            outState.putString( "DOMAIN", domain_edit.getText().toString() );            
            outState.putBoolean( "ACTIVE", active_ftp_cb.isChecked() );            
            super.onSaveInstanceState(outState);
        }
        catch( Exception e ) {
            Log.e( TAG, "onSaveInstanceState() Exception: ", e );
        }
    }

