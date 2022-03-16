    @Override
    public void onClick( DialogInterface idialog, int whichButton ) {
        if( whichButton == DialogInterface.BUTTON_POSITIVE ) {
            try {
                f.setComment( ce.getText().toString() );
                String path = pe.getText().toString().trim();
                if( se != null ) {
                    String serv = se.getText().toString().trim();
                    f.setUri( uri.buildUpon().encodedAuthority( Utils.encodeToAuthority( serv ) ).
                                                   encodedPath( Utils.escapePath( path ) ).build() );
                    Log.i( TAG, "Uri:" + f.getUri() );
                    String domain = de != null ? de.getText().toString().trim() : "";
                    String usernm = ue.getText().toString().trim();
                    f.setCredentials( domain.length() > 0 ? domain + ";" + usernm : usernm, we.getText().toString().trim() );
                }
                else {
                    f.setUri( uri.buildUpon().encodedPath( Utils.escapePath( path ) ).build() );
                }
                owner.invalidate();
            } catch( Exception e ) {
                Log.e( TAG, null, e );
            }
        }
    }

