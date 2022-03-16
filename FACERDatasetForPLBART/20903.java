    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        if (mOnItemLongClickListener != onItemLongClickListener) {
            mOnItemLongClickListener = onItemLongClickListener;
            updateViewOnLongClickListeners();
        }
    }

