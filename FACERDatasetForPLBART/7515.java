    @Override
    public String getType( Uri uri ) {
        String ext  = Utils.getFileExt( uri.getPath() );
        String mime = Utils.getMimeByExt( ext );
        return mime;
    }

