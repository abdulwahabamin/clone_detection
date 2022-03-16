    @Override
    public void Open( Uri uri, Credentials crd ) {
        try {
            if( uri == null ) return;
            String scheme = uri.getScheme();
            String path = uri.getPath();
            String ext = Utils.getFileExt( "zip".equals( scheme ) ? uri.getFragment() : path );
            String mime = Utils.getMimeByExt( ext );
            if( scheme == null || scheme.length() == 0 ) { 
                Intent i = new Intent( Intent.ACTION_VIEW );
                Intent op_intent = getIntent();
                if( op_intent != null ) {
                    String action = op_intent.getAction();
                    if( Intent.ACTION_PICK.equals( action ) ) {
                        i.setData( uri );
                        setResult( RESULT_OK, i );
                        finish();
                        return;
                    }
                    if( Intent.ACTION_GET_CONTENT.equals( action ) ) {
                        i.setData( Uri.parse( FileProvider.URI_PREFIX + path ) );
                        setResult( RESULT_OK, i );
                        finish();
                        return;
                    }
                }
                if( ext != null && ext.compareToIgnoreCase( ".zip" ) == 0 ) {
                    Navigate( uri.buildUpon().scheme( "zip" ).build(), null, null );
                    return;
                }
                i.setDataAndType( uri.buildUpon().scheme( "file" ).authority( "" ).build(), mime );
                i.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET  );
                // | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
                startActivity( i );
            } 
            else 
            if( mime != null && ( mime.startsWith( "audio" ) || mime.startsWith( "video" ) ) ) {
                startService( new Intent( this, StreamServer.class ) );
                Intent i = new Intent( Intent.ACTION_VIEW );
                
                String http_url = "http://127.0.0.1:5322/" + Uri.encode( uri.toString() );
                if( crd != null )
                    StreamServer.credentials = crd; 
                //Log.d( TAG, "Stream " + mime + " from: " + http_url );
                i.setDataAndType( Uri.parse( http_url ), mime );
                i.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET  );
                startActivity( i );
                return;
            }

        } catch( ActivityNotFoundException e ) {
            showMessage("Application for open '" + uri.toString() + "' is not available, ");
        } catch( Exception e ) {
            Log.e( TAG, uri.toString(), e );
        }
    }

