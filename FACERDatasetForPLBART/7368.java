    public final void store() {
        colorPref = ctx.getSharedPreferences( Prefs.COLORS_PREFS, Activity.MODE_PRIVATE );
        SharedPreferences.Editor editor = colorPref.edit();
        editor.putInt( BGR_COLORS, bgrColor );
        editor.putInt( FGR_COLORS, fgrColor );
        editor.putInt( CUR_COLORS, curColor );
        editor.putInt( SEL_COLORS, selColor );
        editor.putInt( SFG_COLORS, sfgColor );
        editor.putInt( TTL_COLORS, ttlColor );
        editor.putInt( BTN_COLORS, btnColor );
        editor.commit();
    }

