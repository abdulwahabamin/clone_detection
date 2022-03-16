    @Override
    public boolean onKeyDown( int keyCode, KeyEvent event ) {
        char c = (char)event.getUnicodeChar();
        switch( c ) {
        case 'q':
            finish();
            return true;
        case 'g':
            return dispatchCommand( VIEW_TOP );
        case 'G':
            return dispatchCommand( VIEW_BOT );
        }
        return super.onKeyDown( keyCode, event );
    }

