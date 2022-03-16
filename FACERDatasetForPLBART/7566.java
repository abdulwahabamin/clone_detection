    private final void highlightCurrentTitle() {
        if( mainView == null ) return;
        View title_bar = mainView.findViewById( R.id.titles );
        if( title_bar != null ) {
            int h = title_bar.getHeight();
            if( h == 0 ) h = 30;
            Drawable d = Utils.getShading( ck.ttlColor );
            if( d != null )
                title_bar.setBackgroundDrawable( d );
            else
                title_bar.setBackgroundColor( ck.ttlColor );
        }
    	highlightTitle( opposite(), false );
    	highlightTitle( current, true );
    }

