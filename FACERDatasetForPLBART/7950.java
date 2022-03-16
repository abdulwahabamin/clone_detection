    public final static String getMimeByExt( String ext ) {
        if( ext == null || ext.length() == 0 || ext.compareTo( "." ) == 0 )
            return "*/*";
        ext = ext.toLowerCase();
        int from = 0, to = mimes.length;
        for( int l = 0; l < mimes.length; l++ ) {
            int idx = ( to - from ) / 2 + from;
            String tmp = mimes[idx][0];
            if( tmp.compareTo( ext ) == 0 )
                return mimes[idx][1];
            int cp;
            for( cp = 1;; cp++ ) {
                if( cp >= ext.length() ) {
                    to = idx;
                    break;
                }
                if( cp >= tmp.length() ) {
                    from = idx;
                    break;
                }
                char c0 = ext.charAt( cp );
                char ct = tmp.charAt( cp );
                if( c0 < ct ) {
                    to = idx;
                    break;
                }
                if( c0 > ct ) {
                    from = idx;
                    break;
                }
            }
        }
        MimeTypeMap mime_map = MimeTypeMap.getSingleton();
        if( mime_map != null ) {
            String mime = mime_map.getMimeTypeFromExtension( ext.substring( 1 ) );
            if( mime != null && mime.length() > 0 )
                return mime;
        }
        return "*/*";
    }

