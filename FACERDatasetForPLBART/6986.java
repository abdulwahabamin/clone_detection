	private void dragView(int x, int y) {
        float alpha = 1.0f;
        int width = mDragView.getWidth();

        if( mRemoveMode == SLIDE_RIGHT ) {
            if( x > width / 2 ) {
                alpha = ( (float)( width - x ) ) / ( width / 2 );
            }
            mWindowParams.alpha = alpha;
        } else if( mRemoveMode == SLIDE_LEFT ) {
            if( x < width / 2 ) {
                alpha = ( (float)x ) / ( width / 2 );
            }
            mWindowParams.alpha = alpha;
        }
        mWindowParams.y = y - mDragPoint + mCoordOffset;
        mWindowManager.updateViewLayout( mDragView, mWindowParams );
	}

