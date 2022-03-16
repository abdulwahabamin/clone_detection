    private final String fixName( ZipEntry entry ) {
        try {
            String entry_name = entry.getName();
            
            if( android.os.Build.VERSION.SDK_INT >= 10 )
                return entry_name; // already fixed?
            
            byte[] ex = entry.getExtra();
            if( ex != null && ex.length == 2 && ex[0] == 1 && ex[1] == 2 ) 
                return entry_name;
            byte bytes[];
/*            
            bytes = EncodingUtils.getAsciiBytes( entry_name );
            bytes = EncodingUtils.getBytes( entry_name, "windows-1250" );
*/            
            bytes = EncodingUtils.getBytes( entry_name, "iso-8859-1" );
            return new String( bytes );
        } catch( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

