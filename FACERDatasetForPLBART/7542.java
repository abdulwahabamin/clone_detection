    public final void setSelection( int i, int y_ ) {
        final ListView flv$ = flv;
        final int position$ = i, y$ = y_;
        flv$.post( new Runnable() {
            public void run() {
                flv$.setSelectionFromTop( position$, y$ > 0 ? y$ : flv$.getHeight() / 2 );
            }
        } );
        currentPosition = i;
    }

