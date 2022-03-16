    @Override
    public boolean onLongClick(View v) {
        final ItemInfo ii = infoForChild(v);

        if (ii != null && mOnItemLongClickListener != null) {
            return mOnItemLongClickListener.onItemLongClick(ii.object, v, ii.position);
        }

        return false;
    }

