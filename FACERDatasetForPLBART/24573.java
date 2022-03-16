    @Override
    public void onUnbind(ItemBridgeAdapter.ViewHolder viewHolder) {
        if (clickedListener != null) {
            viewHolder.getViewHolder().view.setOnClickListener(null);
        }
    }

