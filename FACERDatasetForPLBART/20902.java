    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        if (mOnItemClickListener != onItemClickListener) {
            mOnItemClickListener = onItemClickListener;
            updateViewOnClickListeners();
        }
    }

