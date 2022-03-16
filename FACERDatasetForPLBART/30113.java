    @Override
    public boolean onInterceptTouchEvent( MotionEvent event ) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                prevX = MotionEvent.obtain( event ).getX();
                declined = false; // New action
                break;
            case MotionEvent.ACTION_MOVE:
                final float eventX = event.getX();
                float xDiff = Math.abs( eventX - prevX );
                if( declined || xDiff > touchSlop ){
                    declined = true; // Memorize
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent( event );
    }

