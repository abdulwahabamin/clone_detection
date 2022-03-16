    protected final static int getIconId( String file ) {
        if( file.indexOf( " -> " ) > 0 )
            return R.drawable.link;
        String ext = Utils.getFileExt( file );
        if( ".apk".equalsIgnoreCase( ext ) || ".dex".equalsIgnoreCase( ext ) )
            return R.drawable.and;
        if( ".zip".equalsIgnoreCase( ext ) || ".jar".equalsIgnoreCase( ext ) )
            return R.drawable.zip;
        if( ".pdf".equalsIgnoreCase( ext ) )
            return R.drawable.pdf;
        if( ".vcf".equalsIgnoreCase( ext ) )
            return R.drawable.book;
        if( ".xml".equalsIgnoreCase( ext ) || ".html".equalsIgnoreCase( ext ) || ".htm".equalsIgnoreCase( ext ) )
            return R.drawable.xml;
        String mime = Utils.getMimeByExt( ext );
        String type = mime.substring( 0, mime.indexOf( '/' ) );
        if( type.compareTo( "text" ) == 0 )
            return R.drawable.text;
        if( type.compareTo( "image" ) == 0 )
            return R.drawable.image;
        if( type.compareTo( "audio" ) == 0 )
            return R.drawable.audio;
        if( type.compareTo( "video" ) == 0 )
            return R.drawable.video;
        if( type.compareTo( "application" ) == 0 )
            return R.drawable.application;
        return R.drawable.unkn;
    }

