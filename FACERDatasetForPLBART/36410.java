    @Override
    public void onBindViewHolder(LifeIndexAdapter.ViewHolder holder, int position) {
        LifeIndex index = indexList.get(position);
        holder.indexIconImageView.setImageDrawable(getIndexDrawable(context, index.getName()));
        holder.indexLevelTextView.setText(index.getIndex());
        holder.indexNameTextView.setText(index.getName());
    }

