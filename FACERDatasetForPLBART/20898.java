    @Override
    public void onClick(View v) {
        final ItemInfo ii = infoForChild(v);

        if (ii != null && mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(ii.object, v, ii.position);
        }
    }

