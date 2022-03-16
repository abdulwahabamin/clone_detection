	private void doExpansion() {
        int childnum = mDragPos - getFirstVisiblePosition();
        if( mDragPos > mFirstDragPos ) {
            childnum++;
        }

        View first = getChildAt( mFirstDragPos - getFirstVisiblePosition() );

        for( int i = 0;; i++ ) {
            View vv = getChildAt( i );
            if( vv == null ) {
                break;
            }
            int height = mItemHeightNormal;
            int visibility = View.VISIBLE;
            if( vv.equals( first ) ) {
                // processing the item that is being dragged
                if( mDragPos == mFirstDragPos ) {
                    // hovering over the original location
                    visibility = View.INVISIBLE;
                } else {
                    // not hovering over it
                    height = 1;
                }
            } else if( i == childnum ) {
                if( mDragPos < getCount() - 1 ) {
                    height = mItemHeightExpanded;
                }
            }

            if( isDraggableRow( vv ) ) {
                ViewGroup.LayoutParams params = vv.getLayoutParams();
                params.height = height;
                vv.setLayoutParams( params );
                vv.setVisibility( visibility );
            }
        }
	}

