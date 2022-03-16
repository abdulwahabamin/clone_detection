    @Override
    public void onBind(final ItemBridgeAdapter.ViewHolder itemViewHolder) {
        itemViewHolder.getViewHolder().view.setOnClickListener(view -> {
            if (clickedListener != null) {
                clickedListener.onItemClicked(itemViewHolder.getViewHolder(), itemViewHolder.getItem(), null, null);
            }
        });
    }

