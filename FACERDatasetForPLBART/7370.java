    public final void storeTypeColors() {
        colorPref = ctx.getSharedPreferences( Prefs.COLORS_PREFS, Activity.MODE_PRIVATE );
        SharedPreferences.Editor editor = colorPref.edit();
        for( int i = 1; i <= ftColors.size(); i++ ) {
            FileTypeColor ftc = ftColors.get( i - 1 );
            ftc.store( editor, i );
        }
        editor.commit();
    }

