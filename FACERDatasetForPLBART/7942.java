    public final Drawable extractIcon() {
        try {
            if( apk_path == null ) return null;
            ZipFile  zip = new ZipFile( apk_path );
            ZipEntry entry = zip.getEntry( "res/drawable/icon.png" );   
            if( entry != null ) {
                InputStream is = zip.getInputStream( entry );
                return is != null ? new BitmapDrawable( is ) : null;
            }
            Enumeration<? extends ZipEntry> entries = zip.entries();
            if( entries != null ) {
                while( entries.hasMoreElements() ) {
                    entry = entries.nextElement();
                    if( entry == null ) continue;
                    String efn = entry.getName();
                    if( efn == null || !efn.startsWith( "res/drawable" ) ) continue;
                    if( efn.contains( "icon" ) ) {
                        InputStream is = zip.getInputStream( entry );
                        return is != null ? new BitmapDrawable( is ) : null;
                    }
                }
            }
            // TODO: find icon from the manifest
        } catch( Throwable e ) {
            Log.e( TAG, "Can't get icon for " + apk_path, e );
        }
        return null;
    }

