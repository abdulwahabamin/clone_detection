    public FavDialog( Context c, Favorite f_, FavsAdapter owner_ ) {
        try {
            owner = owner_;
            f = f_;
            uri = f.getUri();
            if( uri == null ) return;
            LayoutInflater factory = LayoutInflater.from( c );
            View fdv = factory.inflate( R.layout.server, null );
            if( fdv == null ) return;
            View bb = fdv.findViewById( R.id.buttons_block );
            bb.setVisibility( View.GONE );
            View cb = fdv.findViewById( R.id.comment_block );
            cb.setVisibility( View.VISIBLE );
            ce = (EditText)cb.findViewById( R.id.comment_edit );
            ce.setText( f.getComment() );
            
            pe = (EditText)fdv.findViewById( R.id.path_edit );
            String path = uri.getPath();
            /*
            String quer = uri.getQuery();
            if( quer != null )
                path += "?" + quer;
            String frag = uri.getFragment();
            if( frag != null )
                path += "#" + frag;
            */
            pe.setText( path );            
            
            String schm = uri.getScheme();
            View sb = fdv.findViewById( R.id.server_block );
            View ib = fdv.findViewById( R.id.credentials_block );
            boolean ftp = "ftp".equals( schm );
            boolean smb = "smb".equals( schm ); 
            if( ftp || smb ) {
                se = (EditText)sb.findViewById( R.id.server_edit );
                String host = uri.getHost();
                if( host != null ) {
                    int port = uri.getPort();
                    if( port > 0 )
                        host += ":" + port;
                    se.setText( host );    
                }
                if( ftp ) {
                    View db = ib.findViewById( R.id.domain_block );
                    db.setVisibility( View.GONE );
                }
                String username = f.getUserName();
                
                if( smb && username != null ) {
                    int sep = username.indexOf( '\\' );
                    if( sep < 0 )
                        sep = username.indexOf( ';' );
                    de = (EditText)ib.findViewById( R.id.domain_edit );
                    if( sep >= 0 ) {
                        de.setText( username.substring( 0, sep ) );
                        username = username.substring( sep+1 );
                    }
                }
                ue = (EditText)ib.findViewById( R.id.username_edit );
                ue.setText( username );
                we = (EditText)ib.findViewById( R.id.password_edit );
                we.setText( f.getPassword() );
            }
            else {
                sb.setVisibility( View.GONE );
                ib.setVisibility( View.GONE );
            }
            
            new AlertDialog.Builder( c )
                .setTitle( c.getString( R.string.fav_dialog ) )
                .setView( fdv )
                .setPositiveButton( R.string.dialog_ok, this )
                .setNegativeButton( R.string.dialog_cancel, this )
                .show();
        } catch( Exception e ) {
            Log.e( TAG, null, e );
        }
    }

