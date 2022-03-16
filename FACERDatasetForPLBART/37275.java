    @Override
    public void onBindViewHolder(RViewHolder<T> holder, int position) {
        try {
            holder.setPosition(position);
            holder.setData(dataList.get(position));
            holder.refresh();
        } catch (Exception e) {
            Log.e(TAG, "bind view holder error", e);
        }
    }

