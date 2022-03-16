    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (Check.isEmpty(mData) || Check.isNull(mData.get(position))) {
            return;
        }

        if (getItemViewType(position) != holder.getContentViewId()) {
            return;
        }

        holder.updateItem(mData.get(position), position);
    }

