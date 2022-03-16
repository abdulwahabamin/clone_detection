        @Override
        protected CharSequence doInBackground( Void... v ) {
            Uri uri = TextViewer.this.uri;
            try {
                final String   scheme = uri.getScheme();
                CommanderAdapter ca = null;
                InputStream is = null;
                if( ContentResolver.SCHEME_CONTENT.equals( scheme ) ) {
                    is = getContentResolver().openInputStream( uri ); 
                } else {
                    int type_id = CA.GetAdapterTypeId( scheme );
                    ca = CA.CreateAdapterInstance( type_id, TextViewer.this );
                    if( ca != null ) {
                        Credentials crd = null; 
                        try {
                            crd = (Credentials)TextViewer.this.getIntent().getParcelableExtra( Credentials.KEY );
                        } catch( Exception e ) {
                            Log.e( TAG, "on taking credentials from parcel", e );
                        }
                        ca.setCredentials( crd );
                        is = ca.getContent( uri );
                    }
                }
                if( is != null ) {
                    CharSequence cs = Utils.readStreamToBuffer( is, encoding );
                    if( ca != null ) { 
                        ca.closeStream( is );
                        ca.prepareToDestroy();
                    }
                    else
                        is.close();
                    return cs;
                }
            } catch( OutOfMemoryError e ) {
                Log.e( TAG, uri.toString(), e );
                publishProgress( getString( R.string.too_big_file, uri.getPath() ) );
            } catch( Throwable e ) {
                Log.e( TAG, uri.toString(), e );
                publishProgress( getString( R.string.failed ) + e.getLocalizedMessage() );
                
            }
            return null;
        }

