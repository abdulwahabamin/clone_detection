    @Override
    protected void onStart() {
        try {
            super.onStart();
            SharedPreferences prefs = getPreferences( MODE_PRIVATE );
            server_edit.setText( prefs.getString( "SERV", "" ) );            
            path_edit.setText( prefs.getString( "PATH", "/" ) );            
            domain_edit.setText( prefs.getString( "DOMAIN", "" ) );            
            name_edit.setText( prefs.getString( "USER", "" ) );            
            active_ftp_cb.setChecked( prefs.getBoolean( "ACTIVE", false ) );            
        }
        catch( Exception e ) {
            Log.e( TAG, "onStart() Exception: ", e );
        }
    }

