    @Override
    public String toString() {
        if( uri != null ) {
            if( systemMountMode != null ) {
                String path = uri.getPath();
                try {
                    return uri.buildUpon().fragment( path != null && path.startsWith( SYSTEM_PATH ) ? systemMountMode : null ).build().toString();
                } catch( Exception e ) {}
            }            
            return uri.toString();
        }
        return "";
    }

