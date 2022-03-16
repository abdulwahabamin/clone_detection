    public final void openForView() {
        int pos = getSelection( true );
        if( pos < 0 ) return;
        String name = null;
        try {
            CommanderAdapter ca = getListAdapter( true );
            Uri uri = ca.getItemUri( pos );
            if( uri == null ) return;
            CommanderAdapter.Item item = (CommanderAdapter.Item)((ListAdapter)ca).getItem( pos );
            if( item.dir ) {
                showSizes();
                return;
            }
            String mime = Utils.getMimeByExt( Utils.getFileExt( item.name ) );
            if( mime == null ) mime = "application/octet-stream";                
            Intent i = new Intent( c, mime.startsWith( "image/" ) ? 
                    PictureViewer.class : TextViewer.class );
            i.setDataAndType( uri, mime );
            Credentials crd = ca.getCredentials();
            if( crd != null )
                i.putExtra( Credentials.KEY, crd );
            c.startActivity( i );
        }
        catch( Exception e ) {
            Log.e( TAG, "Can't view the file " + name, e );
        }
    }

