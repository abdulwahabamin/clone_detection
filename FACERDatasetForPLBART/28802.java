    /**
     * @see android.support.v7.widget.RecyclerView.Adapter#onBindViewHolder(RecyclerView.ViewHolder, int)
     * Sets the content of items.
     */
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.getTvInformation().setText(cities.get(position).getCityName());
        if (cities.get(position).getCityId() == prefManager.getDefaultLocation()) {
            holder.getIsDefault().setVisibility(View.VISIBLE);
        } else {
            holder.getIsDefault().setVisibility(View.GONE);
        }
    }

