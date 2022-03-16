    private final void restPrefs( File f, File sp_dir ) {
        try {
            ZipFile zf = new ZipFile( f );
            for( int i = 0; i < prefFileNames.length; i++ ) {
                ZipEntry ze = zf.getEntry( prefFileNames[i] );
                if( ze != null ) {
                    InputStream is = zf.getInputStream( ze );
                    OutputStream os = new FileOutputStream( new File( sp_dir, prefFileNames[i] ) );
                    Utils.copyBytes( is, os );
                    is.close();
                    os.close();
                }
            }
            showMessage( getString( R.string.prefs_restr ) );
        } catch( Throwable e ) {
            e.printStackTrace();
        }
    }

