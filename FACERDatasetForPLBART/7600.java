    public final void tryToSend() {
        File f = getCurrentFile();
        if( f != null ) {
            String ext = Utils.getFileExt( f.getName() );
            String mime = Utils.getMimeByExt( ext );
            if( mime != null && !mime.startsWith( "image/" )
                             && !mime.startsWith( "audio/" )
                             && !mime.startsWith( "video/" ) )
                mime = null;
            Intent i = new Intent( Intent.ACTION_SEND );
            i.setType( mime == null ? "*/*" : mime );
            i.putExtra( Intent.EXTRA_SUBJECT, f.getName() );
            SharedPreferences shared_pref = PreferenceManager.getDefaultSharedPreferences( c );
            String esc_fn = Utils.escapePath( f.getAbsolutePath() );
            boolean use_content = shared_pref.getBoolean( "send_content", true );
            Uri uri = Uri.parse( use_content ? FileProvider.URI_PREFIX + esc_fn :
                                                             "file://" + esc_fn );  
            i.putExtra( Intent.EXTRA_STREAM, uri );
            c.startActivity( Intent.createChooser( i, c.getString( R.string.send_title ) ) );            
        }        
    }    

