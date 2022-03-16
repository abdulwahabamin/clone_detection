    public final static String getFileExt( String file_name ) {
        if( file_name == null )
            return "";
        int dot = file_name.lastIndexOf( "." );
        return dot >= 0 ? file_name.substring( dot ) : "";
    }

