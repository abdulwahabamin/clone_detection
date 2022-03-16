	private void unExpandViews(boolean deletion) {
        for( int i = 0;; i++ ) {
            View v = getChildAt( i );
            if( v == null ) {
                if( deletion ) {
                    // HACK force update of mItemCount
                    int position = getFirstVisiblePosition();
                    int y = getChildAt( 0 ).getTop();
                    setAdapter( getAdapter() );
                    setSelectionFromTop( position, y );
                    // end hack
                }
                layoutChildren(); // force children to be recreated where needed
                v = getChildAt( i );
                if( v == null ) {
                    break;
                }
            }

            if( isDraggableRow( v ) ) {
                ViewGroup.LayoutParams params = v.getLayoutParams();
                params.height = mItemHeightNormal;
                v.setLayoutParams( params );
                v.setVisibility( View.VISIBLE );
            }
        }
	}

