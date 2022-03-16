    public final int restoreTypeColors() {
        try {
            colorPref = ctx.getSharedPreferences( Prefs.COLORS_PREFS, Activity.MODE_PRIVATE );
            if( ftColors == null  )
                ftColors = new ArrayList<FileTypeColor>( 5 );
            else
                ftColors.clear();
            for( int i = 1; i < 999; i++ ) {
                FileTypeColor ftc = new FileTypeColor();
                if( !ftc.restore( ctx, colorPref, i ) ) break;
                ftColors.add( ftc );
            }
            return ftColors.size();
        } catch( Exception e ) {
            e.printStackTrace();
        }
        return 0;
    }

