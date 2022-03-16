    public static int getDefaultColor( Context ctx, String key, boolean alt ) {
        Resources r = ctx.getResources();
        if( key.equals( ColorsKeeper.CUR_COLORS ) ) return alt ? r.getColor( R.color.cur_def ) : 0;
        if( key.equals( ColorsKeeper.BTN_COLORS ) ) {
            final int GINGERBREAD = 9;
            if( android.os.Build.VERSION.SDK_INT >= GINGERBREAD )
                return r.getColor( R.color.btn_def );
            else
                return alt ? r.getColor( R.color.btn_odf ) : 0;
        }
        if( alt ) return 0;
        if( key.equals( ColorsKeeper.BGR_COLORS ) ) return r.getColor( R.color.bgr_def );
        if( key.equals( ColorsKeeper.SEL_COLORS ) ) return r.getColor( R.color.sel_def );
        if( key.equals( ColorsKeeper.SFG_COLORS ) ) return r.getColor( R.color.fgr_def );
        if( key.equals( ColorsKeeper.TTL_COLORS ) ) return r.getColor( R.color.ttl_def );
        if( key.equals( ColorsKeeper.FGR_COLORS ) ) return r.getColor( R.color.fgr_def );
        return 0;
    }

