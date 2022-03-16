    public ColorsKeeper( Context ctx_ ) {
        ctx = ctx_;
        Resources  r = ctx.getResources();
        ttlColor = r.getColor( R.color.ttl_def ); 
        bgrColor = r.getColor( R.color.bgr_def );
        fgrColor = r.getColor( R.color.fgr_def );
        selColor = r.getColor( R.color.sel_def );
        sfgColor = r.getColor( R.color.fgr_def );
        btnColor = Prefs.getDefaultColor( ctx, BTN_COLORS, false );
        curColor = 0;
    }

