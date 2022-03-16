        public void run() {
            InputStream  is = null;
            OutputStream os = null;
            try {
                Log.d( TAG, "Thread started" );
                setName( TAG );
                //setPriority( Thread.MAX_PRIORITY );
                setPriority( Thread.NORM_PRIORITY );
                if( data_socket != null && data_socket.isConnected() ) {
                    is = data_socket.getInputStream();
                    InputStreamReader isr = new InputStreamReader( is );
                    BufferedReader br = new BufferedReader( isr );
                    String cmd = br.readLine();
                    if( Utils.str( cmd ) ) {
                        String[] parts = cmd.split( " " );
                        if( parts.length > 1 ) {
                            Uri uri = Uri.parse( Uri.decode( parts[1].substring( 1 ) ) );
                            //Log.d( TAG, "Got URL: " + url );
                            
                            long offset = 0;
                            while( br.ready() ) {
                                String hl = br.readLine();
                                if( hl != null ) {
                                    Log( hl );
                                    if( hl.startsWith( "Range: bytes=" ) ) {
                                        int end = hl.indexOf( '-', 13 );
                                        String range_s = hl.substring( 13, end );
                                        try {
                                            offset = Long.parseLong( range_s );
                                        } catch( NumberFormatException nfe ) {}
                                    }
                                }
                            }
                            os = data_socket.getOutputStream();
                            if( os != null ) {
                                String http = "HTTP/1.1 ";  
                                OutputStreamWriter osw = new OutputStreamWriter( os );
                                if( uri != null ) { 
                                    Log( "Got URI: " + uri.toString() );
                                    String scheme = uri.getScheme();
                                    int ca_type = CA.GetAdapterTypeId( scheme );
                                    String host = uri.getHost();
                                    if( StreamServer.this.ca == null || StreamServer.this.ca.getType() != ca_type ||
                                            ( host != null && !host.equals( last_host ) ) ) 
                                        ca = CA.CreateAdapterInstance( ca_type, ctx );  // a kind of vandalism, but whatever...
                                    if( ca != null ) {
                                        Log( "Adapter is created" );
                                        last_host = host;
                                        if( credentials != null )
                                            ca.setCredentials( credentials );
                                        Item item = ca.getItem( uri );
                                        InputStream cs = ca.getContent( uri, offset );
                                        if( cs != null ) {
                                            if( offset > 0 && item != null ) {
                                                Log( "206" );
                                                osw.write( http + "206 Partial Content" + CRLF );
                                            } else {
                                                Log( "200" );
                                                osw.write( http + "200 OK" + CRLF );
                                            }
                                            String fn = "zip".equals( scheme ) ? uri.getFragment() : uri.getLastPathSegment();
                                            if( fn != null ) {
                                                String ext = Utils.getFileExt( fn );
                                                String mime = Utils.getMimeByExt( ext );
                                                Log( "Content-Type: " + mime );
                                                osw.write( "Content-Type: " + mime + CRLF );
                                            }
                                            else
                                                osw.write( "Content-Type: application/octet-stream" + CRLF );
                                            if( item != null ) {
                                                String content_range = null, content_len = "Content-Length: " + item.size;
                                                if( offset == 0 ) {
                                                    content_range = "Content-Range: bytes 0-" + (item.size-1) + "/" + item.size;
                                                    osw.write( content_len + CRLF );
                                                    osw.write( content_range + CRLF );
                                                } else {
                                                    content_range = "Content-Range: bytes " + offset + "-" + (item.size-1) + "/" + item.size;
                                                    osw.write( content_len + CRLF );
                                                    osw.write( content_range + CRLF );
                                                }
                                                Log( content_range );
                                                Log( content_len );
                                            }
                                            else
                                                Log.w( TAG, "The item is null" );
                                            Date date = new Date();
                                            osw.write( date + CRLF );
                                            osw.write( CRLF );
                                            osw.flush();
                                            
                                            ReaderThread rt = new ReaderThread( cs, num_id );
                                            rt.start();
                                            int count = 0;
                                            while( rt.isAlive() ) {
                                                try {
                                                    if( br.ready() )
                                                        Log( "HTTP additional command arrived!!! " + br.readLine() );
                                                    thread.touch();
                                                    byte[] out_buf = rt.getOutputBuffer();
                                                    if( out_buf == null ) break;
                                                    int n = rt.GetDataSize();
                                                    if( n < 0 )
                                                        break;
                                                    Log( "      W..." );
                                                    os.write( out_buf, 0, n );
                                                    Log( "      ...W " + n + "/" + ( count += n ) );
                                                }
                                                catch( Exception e ) {
                                                    Log( "write exception: " + e.getMessage() );
                                                    break;
                                                }
                                                finally {
                                                    rt.doneOutput();
                                                }
                                            }                                            
                                            ca.closeStream( cs );
                                            rt.interrupt();
                                            Log( "----------- done -------------" );
                                        }
                                        else {
                                            osw.write( http + "404 Not found" + CRLF );
                                            Log.w( TAG, "404" );
                                        }
                                    }
                                    else {
                                        osw.write( http + "500 Server error" + CRLF );
                                        Log.e( TAG, "500" );
                                    }
                                } else {
                                    osw.write( http + "400 Invalid" + CRLF );
                                    Log.w( TAG, "400" );
                                }
                            }
                        }
                    }
                }
            }
            catch( Exception e ) {
                Log.e( TAG, "Exception", e );
            }
            finally {
                try {
                    if( is != null ) is.close();
                    if( os != null ) os.close();
                }
                catch( IOException e ) {
                    Log.e( TAG, "Exception on Closing", e );
                }
            }
        }

