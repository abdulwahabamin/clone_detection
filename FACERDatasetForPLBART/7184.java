        private final void addIfMatched( File f ) {
            if( f == null ) return;
            try {
                boolean dir = f.isDirectory();
                if( dir ) { 
                    if( !dirs  ) return;
                } else {
                    if( !files ) return;
                }
                long modified = f.lastModified();
                if(  after_date != null && modified <  after_date.getTime() ) return;  
                if( before_date != null && modified > before_date.getTime() ) return;  

                long size = f.length();
                if( size < larger_than || size > smaller_than ) 
                    return;
                
                if( cards != null && !Utils.match( f.getName(), cards ) ) 
                    return;
                if( match != null && !f.getName().toLowerCase().contains( match ) )
                    return;
                if( content != null && !dir && !searchInsideFile( f, content ) )
                    return;
                result.add( f );
            }
            catch( Exception e ) {
                Log.e( TAG, f.getName(), e );
            }
        }

