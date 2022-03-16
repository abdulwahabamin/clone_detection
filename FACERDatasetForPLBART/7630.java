    /**
     * View.OnTouchListener implementation 
     */
    @Override
    public boolean onTouch( View v, MotionEvent event ) {
    	resetQuickSearch();
        if( v == hsv ) {
            if( x_start < 0. && event.getAction() == MotionEvent.ACTION_MOVE )
                x_start = event.getX();
            else
            if( x_start >= 0. && event.getAction() == MotionEvent.ACTION_UP ) {
                float d = event.getX() - x_start;
                x_start = -1;
                final int to_which;
                if( Math.abs( d ) > scroll_back )
                    to_which = d > 0 ? LEFT : RIGHT;
                else
                    to_which = current ==  LEFT ? LEFT : RIGHT;
                setPanelCurrent( to_which );
                return true;
            }
        }
        else
	    if( v instanceof ListView ) {
            if( v == list[opposite()].flv)
                togglePanels( false );
	        
	    	locationBar.closeGoPanel();
	        switch( event.getAction() ) {
	        case MotionEvent.ACTION_DOWN: {
                    downX = event.getX();
                    downY = event.getY();
                    disableOpenSelectOnly = event.getX() > v.getWidth() * selWidth;
                    if( !selAtRight )
                        disableOpenSelectOnly = !disableOpenSelectOnly;
    	            break;
    	        }
	        case MotionEvent.ACTION_UP: {
                    int deltaX = (int)(event.getX() - downX);
                    int deltaY = (int)(event.getY() - downY);
                    int absDeltaX = Math.abs( deltaX );
                    int absDeltaY = Math.abs( deltaY );
                    
                    if( absDeltaY > 10 || absDeltaX > 10 )
                        disableOpenSelectOnly = false;
                    list[current].focus();
       	            break;
    	        }
	        }
	    }
        return false;
    }

