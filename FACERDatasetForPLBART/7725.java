        public String getMode() {
            if( opts != null ) {
                try {
                    String[] flds = opts.split( "," );
                    for( String f : flds )
                        if( f.equals( "rw" ) || f.equals( "ro" ) ) return f;
                } catch( Exception e ) {
                    Log.e( TAG, "opts=" + opts, e );
                }
            }
            return null;
        }

