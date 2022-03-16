    public final void applyColors( ColorsKeeper ck ) {
        if( flv == null ) return;
        flv.setBackgroundColor( ck.bgrColor );
        flv.setCacheColorHint( ck.bgrColor );
        if( ck.curColor != 0 ) {
            Drawable d = Utils.getShadingEx( ck.curColor, 0.9f );
            if( d != null )
                flv.setSelector( d );
        }
/*        
        CommanderAdapter ca = (CommanderAdapter)flv.getAdapter();
        if( ca != null ) {
            ca.setMode( CommanderAdapter.SET_TXT_COLOR, ck.fgrColor );
            ca.setMode( CommanderAdapter.SET_SEL_COLOR, ck.selColor );
        }
*/
    }

