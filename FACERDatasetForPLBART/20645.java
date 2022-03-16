    @SuppressLint("NewApi")
    protected void scroll(final float height) {
        if (type == TYPE_INDICATOR || type == TYPE_INDICATOR_WITH_HANDLE) {
            float move = height - (scrollIndicator.getHeight() / 2);

            if (move < 0)
                move = 0;
            else if (move > getHeight() - scrollIndicator.getHeight())
                move = getHeight() - scrollIndicator.getHeight();

            // scrollIndicator.setTranslationY(move);
            ViewHelper.setTranslationY(scrollIndicator, move);
        }

        if (type == TYPE_INDICATOR_WITH_HANDLE || type == TYPE_POPUP_WITH_HANDLE) {
            handleBar.setSelected(true);
            moveHandlebar(height - (handleBar.getHeight() / 2));
        }

        int position = (int) ((height / getHeight()) * itemCount);
/*        if (gridView instanceof ExpandableListView) {
            final int groupPosition = ExpandableListView.getPackedPositionGroup(((ExpandableListView) listView).getExpandableListPosition(position));
            if (groupPosition != -1)
                this.groupPosition = groupPosition;
        }*/

        if (position < 0)
            position = 0;
        else if (position >= itemCount)
            position = itemCount - 1;
        
        try {
        	scrollIndicatorTextView.setText(scrollable.getIndicatorForPosition(position, groupPosition));
            gridView.setSelection(scrollable.getScrollPosition(position, groupPosition));
        } catch (NullPointerException e) {
        	e.printStackTrace();
        }
        
    }

