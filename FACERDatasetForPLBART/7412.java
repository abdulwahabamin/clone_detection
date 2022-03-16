    private final boolean _loadData() {
        if( uri != null ) { 
            try {
                int type_id = CA.GetAdapterTypeId( uri.getScheme() );
                ca = CA.CreateAdapterInstance( type_id, this );
                if( ca != null ) {
                    InputStream is = ca.getContent( uri );
                    if( is != null ) {
                        CharSequence cs = Utils.readStreamToBuffer( is, encoding );
                        ca.closeStream( is );
                        te.setText( cs );
                        dirty = false; 
                        return true;
                    }
                }
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

