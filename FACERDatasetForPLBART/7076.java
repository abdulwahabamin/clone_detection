    public static void setTypeMaskColors( ColorsKeeper ck_ ) {
        try {
            ck = ck_;
            int n = ck.ftColors.size();
            typeColors   = new int[n];
            filePatterns = new Pattern[n][];
            for( int i = 0; i < n; i++ ) {
                ColorsKeeper.FileTypeColor ftc = ck.ftColors.get( i );
                if( ftc == null ) break;
                int    color = ftc.color;
                String smask = ftc.masks;
                if( smask == null ) break;
                typeColors[i] = color;
                String[] masks = smask.split( ";" );
                int m = masks.length;
                filePatterns[i] = new Pattern[m];
                for( int j = 0; j < m; j++ ) {
                    String re = masks[j].replace( ".", "\\." ).replace( "*", ".*" );
                    filePatterns[i][j] = Pattern.compile( re, Pattern.CASE_INSENSITIVE );
                }
            }
        } catch( Exception e ) {
        }
    }

