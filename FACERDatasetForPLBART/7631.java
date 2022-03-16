    @Override
	public boolean onKey( View v, int keyCode, KeyEvent event ) {
    	if( event.getAction() != KeyEvent.ACTION_DOWN ) return false;
    	
    	//Log.v( TAG, "panel key:" + keyCode + ", uchar:" + event.getUnicodeChar() + ", shift: " + event.isShiftPressed() );
    	
	    if( v instanceof ListView ) {
	    	locationBar.closeGoPanel();
	    	char ch = (char)event.getUnicodeChar();
	    	if( ch >= 'A' && ch <= 'z' || ch == '.' ) {
	    		quickSearch( ch );
	    		return true;
	    	}
	    	resetQuickSearch();
	        switch( ch ) {
	        case '(':
	        case ')': {
		        	int which = ch == '(' ? LEFT : RIGHT;
		            locationBar.openGoPanel( which, getFolderUriWithAuth( isCurrent( which ) ) );
		        }
	        	return true;
            case '*':
                addCurrentToFavorites();
                return true;
	        case '{':
            case '}':
                setPanelCurrent( ch == '{' ? Panels.LEFT : Panels.RIGHT );
                return true;
            case '#':
                setLayoutMode( !sxs );
                return true;
	        case '+':
	        case '-':
	            c.showDialog( ch == '+' ? Dialogs.SELECT_DIALOG :  Dialogs.UNSELECT_DIALOG );
	            return true;
	        case '"':
	        	showSizes();
	            return true;
	        case '2':
	            c.showDialog( R.id.F2 );
	            return true;
	        case '3':
	            openForView();
	        	return true;
	        case '4':
	            openForEdit( null );
	            return true;
	        case '5':
	        	c.showDialog( R.id.F5 );
	        	return true;
	        case '6':
	        	c.showDialog( R.id.F6 );
	        	return true;
	        case '7':
	        	c.showDialog( R.id.F7 );
	        	return true;
            case '8':
                c.showDialog( R.id.F8 );
                return true;
            case ' ':
                list[current].checkItem( true );
                return true;
	        }
	    	switch( keyCode ) {
            case KeyEvent.KEYCODE_BACK:
            case KeyEvent.KEYCODE_DEL:
                if( !c.backExit() )
                    goUp();
                return true;
	        case KeyEvent.KEYCODE_DPAD_UP:
	        case KeyEvent.KEYCODE_DPAD_DOWN:	
		    	resetQuickSearch();
		    	if( event.isShiftPressed() ) {
                   list[current].checkItem(false);
                   // ListView will not move to next item on Shift+DPAD, so let's remove the Shift
                   // bit from meta state and re-dispatch the event.
                   KeyEvent shiftStrippedEvent = new KeyEvent(event.getDownTime(), event.getEventTime(),
                           KeyEvent.ACTION_DOWN, keyCode, event.getRepeatCount(),
                           event.getMetaState() & ~(KeyEvent.META_SHIFT_ON | KeyEvent.META_SHIFT_LEFT_ON | KeyEvent.META_SHIFT_RIGHT_ON)); 
                   return v.onKeyDown(keyCode, shiftStrippedEvent);		    	
		    	}
		    	return false;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if( arrowsLegacy ) {
                    list[current].checkItem( true );
                    return true;
                }
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                if( volumeLegacy ) {
    	            list[current].checkItem( true );
    	            return true;
                }
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
	            if( arrowsLegacy ) { 
	                togglePanels( false );
	                return true;    
	            }
	        default:
	        	return false;
	    	}
	    }
	    return false;
	}

