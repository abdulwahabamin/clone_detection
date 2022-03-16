	private void stopDragging() {
        if( mDragView != null ) {
            WindowManager wm = (WindowManager)getContext().getSystemService( "window" );
            wm.removeView( mDragView );
            mDragView.setImageDrawable( null );
            mDragView = null;
        }
        if( mDragBitmap != null ) {
            mDragBitmap.recycle();
            mDragBitmap = null;
        }
	}

