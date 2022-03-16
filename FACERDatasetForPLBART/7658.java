        @Override
        public void run() {
            try {
                final int BUF_SIZE = 100*1024; 
                buf = new byte[BUF_SIZE];
                String scheme = u.getScheme();
                if( ContentResolver.SCHEME_CONTENT.equals( scheme ) ) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inTempStorage = buf;
                    InputStream is = null;
                    for( int b = 1; b < 0x80000; b <<= 1 ) {
                        try {
                            options.inSampleSize = b;
                            is = getContentResolver().openInputStream( u );
                            if( is == null ) {
                                Log.e( TAG, "Failed to get the content stream for: " + u );
                                return;
                            }
                            bmp = BitmapFactory.decodeStream( is, null, options );
                            if( bmp != null )
                                return;
                        } catch( Throwable e ) {
                        } finally {
                            if( is != null )
                                is.close();
                        }
                        Log.w( TAG, "Cant decode stream to bitmap. b=" + b );
                    }
                } else {
                    File f = null;
                    setPriority( Thread.MAX_PRIORITY );
                    boolean local = CA.isLocal( scheme );
                    if( local ) {   // pre-cache in a file
                        f = new File( u.getPath() );
                    } else {
                        CommanderAdapter ca = CA.CreateAdapterInstance( CA.GetAdapterTypeId( scheme ), ctx );            
                        if( ca == null ) return;
                        Credentials crd = null; 
                        try {
                            crd = (Credentials)getIntent().getParcelableExtra( Credentials.KEY );
                        } catch( Exception e ) {
                            Log.e( TAG, "on taking credentials from parcel", e );
                        }
                        ca.setCredentials( crd );
                        
                        // output - temporary file
                        File pictvw_f = ctx.getDir( "pictvw", Context.MODE_PRIVATE );
                        if( pictvw_f == null ) return;
                        f = new File( pictvw_f, "file.tmp" );
                        FileOutputStream fos = new FileOutputStream( f );
                        // input - the content from adapter
                        InputStream is = ca.getContent( u );
                        if( is == null ) return;
                        int n;
                        boolean available_supported = is.available() > 0;
                        while( ( n = is.read( buf ) ) != -1 ) {
                            //Log.v( "readStreamToBuffer", "Read " + n + " bytes" );
                            //sendProgress( tot += n );
                            Thread.sleep( 1 );
                            fos.write( buf, 0, n );
                            if( available_supported ) {
                                for( int i = 0; i < 10; i++ ) {
                                    if( is.available() > 0 ) break;
                                    //Log.v( "readStreamToBuffer", "Waiting the rest " + i );
                                    Thread.sleep( 20 );
                                }
                                if( is.available() == 0 ) {
                                    //Log.v( "readStreamToBuffer", "No more data!" );
                                    break;
                                }
                            }
                        }
                        ca.closeStream( is );
                        fos.close();
                    }
                    if( f != null ) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inTempStorage = buf;
                        for( int b = 1; b < 0x80000; b <<= 1 ) {
                            try {
                                options.inSampleSize = b;
                                bmp = BitmapFactory.decodeFile( f.getAbsolutePath(), options );
                            } catch( Throwable e ) {}
                            if( bmp != null ) {
                                if( !local )
                                    f.delete();
                                return;
                            }
                        }
                    }
                }
            } catch( Throwable e ) {
                Log.e( TAG, u != null ? u.toString() : null, e );
                msgText = e.getLocalizedMessage();
            } finally {
                sendProgress( -1 );
            }
        }

