    @Override
    public void onBindViewHolder(PlaceAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Place songs = users.get(position);
        // Set item views based on the data model
        holder.tvName.setText(songs.name);
        holder.tvHometown.setText(songs.author);
        String result = DateUtils.getRelativeTimeSpanString(songs.timerequest, System.currentTimeMillis(), 0).toString();
        holder.tvTime.setText(result);
    }

