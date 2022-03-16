    public final void restore() {
        colorPref = ctx.getSharedPreferences( Prefs.COLORS_PREFS, Activity.MODE_PRIVATE );
        bgrColor = colorPref.getInt( BGR_COLORS, bgrColor );
        fgrColor = colorPref.getInt( FGR_COLORS, fgrColor );
        curColor = colorPref.getInt( CUR_COLORS, curColor );
        selColor = colorPref.getInt( SEL_COLORS, selColor );
        sfgColor = colorPref.getInt( SFG_COLORS, sfgColor );
        ttlColor = colorPref.getInt( TTL_COLORS, ttlColor );
        btnColor = colorPref.getInt( BTN_COLORS, btnColor );
    }

