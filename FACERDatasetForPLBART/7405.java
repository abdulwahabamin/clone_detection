        @Override
        protected CharSequence doInBackground( Void... v ) {
            Uri uri = Editor.this.uri;
            try {
                final String   scheme = uri.getScheme();
                InputStream is = null;
                if( Editor.this.ca == null ) {
                    int type_id = CA.GetAdapterTypeId( scheme );
                    Editor.this.ca = CA.CreateAdapterInstance( type_id, Editor.this );
                }
                if( Editor.this.ca != null ) {
                    Credentials crd = null; 
                    try {
                        crd = (Credentials)Editor.this.getIntent().getParcelableExtra( Credentials.KEY );
                    } catch( Exception e ) {
                        Log.e( TAG, "on taking credentials from parcel", e );
                    }
                    Editor.this.ca.setCredentials( crd );
                    is = Editor.this.ca.getContent( uri );
                }
                if( is != null ) {
                    CharSequence cs = Utils.readStreamToBuffer( is, encoding );
                    if( Editor.this.ca != null ) { 
                        Editor.this.ca.closeStream( is );
                    }
                    else
                        is.close();
                    return cs;
                }
                publishProgress( getString( R.string.rtexcept, uri.toString() ) );
            } catch( OutOfMemoryError e ) {
                Log.e( TAG, uri.toString(), e );
                publishProgress( getString( R.string.too_big_file, uri.getPath() ) );
            } catch( Throwable e ) {
                Log.e( TAG, uri.toString(), e );
                publishProgress( getString( R.string.failed ) + e.getLocalizedMessage() );
            }
            return null;
        }

