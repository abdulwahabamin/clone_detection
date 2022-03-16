    public int getColor( String key ) {
        if( BGR_COLORS.equals( key ) ) return bgrColor;
        if( FGR_COLORS.equals( key ) ) return fgrColor;
        if( SEL_COLORS.equals( key ) ) return selColor;
        if( SFG_COLORS.equals( key ) ) return sfgColor;
        if( CUR_COLORS.equals( key ) ) return curColor;
        if( TTL_COLORS.equals( key ) ) return ttlColor;
        if( BTN_COLORS.equals( key ) ) return btnColor;
        return 0;
    }

