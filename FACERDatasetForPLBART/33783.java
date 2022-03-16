    private int getItemHeight(int position) {
        View v = getChildAt(position - getFirstVisiblePosition());

        if (v != null) {
            // item is onscreen, just get the height of the View
            return v.getHeight();
        } else {
            // item is offscreen. get child height and calculate
            // item height based on current shuffle state
            return calcItemHeight(position, getChildHeight(position));
        }
    }

