	@Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.gridItemTitle.setText(artists.get(position).getArtistName());
        if (artists.get(position).getCoverPath() != null && !artists.get(position).getCoverPath().isEmpty()) {
            if (LRUCache.getInstance().get(artists.get(position).getCoverPath()) != null) {
                holder.gridItemImage.setImageBitmap(LRUCache.getInstance()
						.get(artists.get(position).getCoverPath()));
            } else {
                byte[] imageData = MusicDataUtility.getImageData(artists.get(position).getCoverPath());
                if (imageData != null) {
                    final Bitmap bmp = BitmapUtils.decodeSampledBitmapFromResource(imageData, 200, 200);
                    holder.gridItemImage.setImageBitmap(bmp);
					LRUCache.getInstance().put(artists.get(position).getCoverPath(), bmp);
                }
            }
        } else {
            holder.gridItemImage.setImageResource(R.drawable.ic_vinyl_white_50dp);
        }
    }

