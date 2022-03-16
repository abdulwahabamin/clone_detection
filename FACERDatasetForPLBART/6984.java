	@Override
	public boolean onTouchEvent(MotionEvent ev) {
        if( mGestureDetector != null ) {
            mGestureDetector.onTouchEvent( ev );
        }
        if( ( mDragListener != null || mDropListener != null ) && mDragView != null ) {
            int action = ev.getAction();
            switch( action ) {
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                Rect r = mTempRect;
                mDragView.getDrawingRect( r );
                stopDragging();

                if( mRemoveMode == SLIDE_RIGHT && ev.getX() > r.left + ( r.width() * 3 / 4 ) ) {
                    if( mRemoveListener != null ) {
                        mRemoveListener.remove( mFirstDragPos );
                    }
                    unExpandViews( true );
                } else if( mRemoveMode == SLIDE_LEFT && ev.getX() < r.left + ( r.width() / 4 ) ) {
                    if( mRemoveListener != null ) {
                        mRemoveListener.remove( mFirstDragPos );
                    }
                    unExpandViews( true );
                } else {
                    if( mDropListener != null && mDragPos >= 0 && mDragPos < getCount() ) {
                        mDropListener.drop( mFirstDragPos, mDragPos );
                    }
                    unExpandViews( false );
                }
                break;

            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                int x = (int)ev.getX();
                int y = (int)ev.getY();
                dragView( x, y );
                int itemnum = getItemForPosition( y );
                if( itemnum >= 0 ) {
                    if( action == MotionEvent.ACTION_DOWN || itemnum != mDragPos ) {
                        if( mDragListener != null ) {
                            mDragListener.drag( mDragPos, itemnum );
                        }
                        mDragPos = itemnum;
                        doExpansion();
                    }
                    int speed = 0;
                    adjustScrollBounds( y );
                    if( y > mLowerBound ) {
                        // scroll the list up a bit
                        speed = y > ( mHeight + mLowerBound ) / 2 ? 16 : 4;
                    } else if( y < mUpperBound ) {
                        // scroll the list down a bit
                        speed = y < mUpperBound / 2 ? -16 : -4;
                    }
                    if( speed != 0 ) {
                        int ref = pointToPosition( 0, mHeight / 2 );
                        if( ref == AdapterView.INVALID_POSITION ) {
                            // we hit a divider or an invisible view, check
                            // somewhere else
                            ref = pointToPosition( 0, mHeight / 2 + getDividerHeight() + 64 );
                        }
                        View v = getChildAt( ref - getFirstVisiblePosition() );
                        if( v != null ) {
                            int pos = v.getTop();
                            setSelectionFromTop( ref, pos - speed );
                        }
                    }
                }
                break;
            }
            return true;
        }
        return super.onTouchEvent( ev );
	}

