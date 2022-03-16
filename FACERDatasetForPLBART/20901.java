    private void updateViewOnLongClickListeners() {
        final int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = getChildAt(i);
            final LayoutParams layoutParams = (LayoutParams) child.getLayoutParams();
            if (!layoutParams.isDecor) {
                if (mOnItemLongClickListener != null) {
                    child.setOnLongClickListener(this);
                }
            }
        }
    }

