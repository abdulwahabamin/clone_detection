    public final void applyColors() {
        ck.restore();
        if( sxs ) {
            View div = mainView.findViewById( R.id.divider );
            if( div != null)
                div.setBackgroundColor( ck.ttlColor );
        }
         list[LEFT].applyColors( ck );
        list[RIGHT].applyColors( ck );
        
        ck.restoreTypeColors();
        CommanderAdapterBase.setTypeMaskColors( ck );
        highlightCurrentTitle();
    }

