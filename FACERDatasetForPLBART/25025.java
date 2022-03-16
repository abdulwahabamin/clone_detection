    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.gridItemTitle.setText(playlists.get(position).getPlaylistName());
        if (playlists.get(position).getCoverPath() != null && !playlists.get(position).getCoverPath().isEmpty()) {
            if (LRUCache.getInstance().get(playlists.get(position).getCoverPath()) != null) {
                holder.gridItemImage.setImageBitmap(LRUCache.getInstance()
                        .get(playlists.get(position).getCoverPath()));
            } else {
                byte[] imageData = MusicDataUtility.getImageData(playlists.get(position).getCoverPath());
                if (imageData != null) {
                    final Bitmap bmp = BitmapUtils.decodeSampledBitmapFromResource(imageData, 200, 200);
                    holder.gridItemImage.setImageBitmap(bmp);
                    LRUCache.getInstance().put(playlists.get(position).getCoverPath(), bmp);
                }
            }
        } else {
            holder.gridItemImage.setImageResource(R.drawable.ic_vinyl_white_50dp);
        }

        if(isSelected(position)){
            holder.gridItemTitle.setBackgroundResource(R.color.red);
        } else {
            holder.gridItemTitle.setBackgroundResource(R.color.transparent_black);
        }
    }

