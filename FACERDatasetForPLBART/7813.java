    @Override
    protected void onPause() {
        try {
            super.onPause();
            SharedPreferences.Editor editor = getPreferences( MODE_PRIVATE ).edit();
            editor.putString( "SERV", server_edit.getText().toString() );            
            editor.putString( "PATH", path_edit.getText().toString() );            
            editor.putString( "DOMAIN", domain_edit.getText().toString() );            
            editor.putString( "USER", name_edit.getText().toString() );            
            editor.putBoolean( "ACTIVE", active_ftp_cb.isChecked() );            
            editor.commit();
        }
        catch( Exception e ) {
            Log.e( TAG, "onPause() Exception: ", e );
        }
    }

