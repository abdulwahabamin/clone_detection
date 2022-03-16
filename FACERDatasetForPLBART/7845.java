     private final boolean loadData() {
        if( uri != null ) { 
            try {
                final String   scheme = uri.getScheme();
                if( STRKEY.equals( scheme ) ) {
                    Intent i = getIntent();
                    String str = i.getStringExtra( STRKEY );
                    if( str != null ) {
                        text_view.setText( str );
                        return true;
                    }
                    return false;
                }
                new DataLoadTask().execute();
                return true;
            } catch( OutOfMemoryError e ) {
                Log.e( TAG, uri.toString(), e );
                Toast.makeText(this, getString( R.string.too_big_file, uri.getPath() ), Toast.LENGTH_LONG).show();
            } catch( Throwable e ) {
                Log.e( TAG, uri.toString(), e );
                Toast.makeText(this, getString( R.string.failed ) + e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        }
        return false;
    }

