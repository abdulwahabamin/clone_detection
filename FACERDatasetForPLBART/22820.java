    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        debugLog("onInterceptTouchEvent");

        //if (e.getAction() == MotionEvent.ACTION_DOWN)
        {
            View itemView = rv.findChildViewUnder(e.getX(), e.getY());

            if (itemView == null)
                return false;

            boolean dragging = false;

            if ((dragHandleWidth > 0) && (e.getX() < dragHandleWidth)) {
                dragging = true;
            } else if (viewHandleId != -1) {
                //Find the handle in the list item
                View handleView = itemView.findViewById(viewHandleId);

                if (handleView == null) {
                    Log.e(TAG, "The view ID " + viewHandleId + " was not found in the RecycleView item");
                    return false;
                }

                //View should be visible to drag
                if (handleView.getVisibility() != View.VISIBLE) {
                    return false;
                }

                //We need to find the relative position of the handle to the parent view
                //Then we can work out if the touch is within the handle
                int[] parentItemPos = new int[2];
                itemView.getLocationInWindow(parentItemPos);

                int[] handlePos = new int[2];
                handleView.getLocationInWindow(handlePos);

                int xRel = handlePos[0] - parentItemPos[0];
                int yRel = handlePos[1] - parentItemPos[1];

                Rect touchBounds = new Rect(itemView.getLeft() + xRel, itemView.getTop() + yRel,
                        itemView.getLeft() + xRel + handleView.getWidth(),
                        itemView.getTop() + yRel + handleView.getHeight()
                );

                if (touchBounds.contains((int) e.getX(), (int) e.getY()))
                    dragging = true;

                debugLog("parentItemPos = " + parentItemPos[0] + " " + parentItemPos[1]);
                debugLog("handlePos = " + handlePos[0] + " " + handlePos[1]);
            }


            if (dragging) {
                debugLog("Started Drag");

                setIsDragging(true);

                floatingItem = createFloatingBitmap(itemView);

                fingerAnchorY = (int) e.getY();
                fingerOffsetInViewY = fingerAnchorY - itemView.getTop();
                fingerY = fingerAnchorY;

                selectedDragItemPos = rv.getChildLayoutPosition(itemView);
                debugLog("selectedDragItemPos = " + selectedDragItemPos);

                return true;
            }
        }
        return false;
    }

