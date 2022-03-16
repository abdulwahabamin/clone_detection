    /**
     * Find the new position by scanning through the items on
     * screen and finding the positional relationship.
     * This *seems* to work, another method would be to use
     * getItemOffsets, but I think that could miss items?..
     */
    private int getNewPostion(RecyclerView rv) {
        int itemsOnScreen = rv.getLayoutManager().getChildCount();

        float floatMiddleY = floatingItemBounds.top + floatingItemBounds.height() / 2;

        int above = 0;
        int below = Integer.MAX_VALUE;
        for (int n = 0; n < itemsOnScreen; n++) //Scan though items on screen, however they may not
        {                                   // be in order!

            View view = rv.getLayoutManager().getChildAt(n);

            if (view.getVisibility() != View.VISIBLE)
                continue;

            int itemPos = rv.getChildLayoutPosition(view);

            if (itemPos == selectedDragItemPos) //Don't check against itself!
                continue;

            float viewMiddleY = view.getTop() + view.getHeight() / 2;
            if (floatMiddleY > viewMiddleY) //Is above this item
            {
                if (itemPos > above)
                    above = itemPos;
            } else if (floatMiddleY <= viewMiddleY) //Is below this item
            {
                if (itemPos < below)
                    below = itemPos;
            }
        }
        debugLog("above = " + above + " below = " + below);

        if (below != Integer.MAX_VALUE) {
            if (below < selectedDragItemPos) //Need to count itself
                below++;
            return below - 1;
        } else {
            if (above < selectedDragItemPos)
                above++;

            return above;
        }
    }

