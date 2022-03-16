	private int myPointToPosition(int x, int y) {
        Rect frame = mTempRect;
        final int count = getChildCount();
        for( int i = count - 1; i >= 0; i-- ) {
            final View child = getChildAt( i );
            child.getHitRect( frame );
            if( frame.contains( x, y ) ) {
                return getFirstVisiblePosition() + i;
            }
        }
        return INVALID_POSITION;
	}

