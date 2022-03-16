    @Override
    public boolean readSource( Uri uri_, String pass_back_on_done ) {
        try {
            if( reader != null ) reader.reqStop();
            if( uri_ != null )
                uri = uri_;
            if( uri == null )
                return false;
            if( uri.getScheme().compareTo( "find" ) == 0 ) {
                String  path   = uri.getPath();
                String match   = uri.getQueryParameter( "q" );
                 
                if( path != null && path.length() > 0 && match != null && match.length() > 0  ) {
                    notify( Commander.OPERATION_STARTED );
                    SearchEngine se = new SearchEngine( readerHandler, match, path, pass_back_on_done );
                    reader = se;
                    String  dirs_s  = uri.getQueryParameter( "d" );
                    String  files_s = uri.getQueryParameter( "f" );
                    boolean dirs  =  dirs_s != null && "1".equals(  dirs_s );
                    boolean files = files_s != null && "1".equals( files_s );
                    if( dirs != files )
                        se.setTypes( files );

                    String olo_s = uri.getQueryParameter( "o" );
                    if( olo_s != null && "1".equals( olo_s ) )
                        se.olo = true;
                    
                    se.content = uri.getQueryParameter( "c" );
                    se.larger_than = Utils.parseHumanSize( uri.getQueryParameter( "l" ) );
                    long st = Utils.parseHumanSize( uri.getQueryParameter( "s" ) );
                    if( st > 0 )
                        se.smaller_than = st;
                    java.text.DateFormat df = DateFormat.getDateFormat( ctx );
                    try {
                        se.after_date  = df.parse( uri.getQueryParameter( "a" ) );
                    } catch( Exception e ) {}
                    try {
                        se.before_date = df.parse( uri.getQueryParameter( "b" ) );
                    } catch( Exception e ) {}
                    
                    reader.start();
                    return true;
                }
            }
        } catch( Exception e ) {
            Log.e( TAG, "FindAdapter.readSource() exception: ", e );
        }
        Log.e( TAG, "FindAdapter unable to read by the URI '" + ( uri == null ? "null" : uri.toString() ) + "'" );
        uri = null;
        return false;
    }

