    @Override
    public void onClick( View v ) {
        try{
            if( v.getId() == R.id.browse ) {
                if( type == Type.SMB )
                    setResult( RESULT_OK, new Intent( Commander.NAVIGATE_ACTION, Uri.parse( "smb://" ) ) );
            }
            else if( v.getId() == R.id.connect ) {
                EditText pass_edit = (EditText)findViewById( R.id.password_edit );
                String user = name_edit.getText().toString().trim();
                String pass = pass_edit.getText().toString().trim();
                Credentials crd = null;
                if( user.length() > 0 ) {
                    if( type == Type.SMB ) {
                        EditText domain_edit = (EditText)findViewById( R.id.domain_edit );
                        String domain = domain_edit.getText().toString().trim();
                        if( domain.length() > 0 )
                            user = domain + ";" + user;
                    }
                    crd = new Credentials( user, pass ); 
                }
                Uri.Builder uri_b = new Uri.Builder()
                    .scheme( schema )
                    .authority( server_edit.getText().toString().trim() )
                    .path( path_edit.getText().toString().trim() );
                if( type == Type.FTP && active_ftp_cb.isChecked() )
                    uri_b.appendQueryParameter( "a", "true" );
                
                Intent in = new Intent( Commander.NAVIGATE_ACTION, uri_b.build() );
                if( crd != null )
                    in.putExtra( Credentials.KEY, crd );
                setResult( RESULT_OK, in );
            }
            else
                setResult( RESULT_CANCELED );
            finish();
        }
        catch( Exception e ) {
            Log.e( TAG, "onClick() Exception: ", e );
        }       
    }

