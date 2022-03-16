    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.gridItemTitle.setText(albums.get(position).getAlbumTitle());
        if (albums.get(position).getCoverPath() != null && !albums.get(position).getCoverPath().isEmpty()) {
            if (LRUCache.getInstance().get(albums.get(position).getCoverPath()) != null) {
                holder.gridItemImage.setImageBitmap(LRUCache.getInstance()
                        .get(albums.get(position).getCoverPath()));
            } else {
                byte[] imageData = MusicDataUtility.getImageData(albums.get(position).getCoverPath());
                if (imageData != null) {
                    final Bitmap bmp = BitmapUtils.decodeSampledBitmapFromResource(imageData, 200, 200);
                    holder.gridItemImage.setImageBitmap(bmp);
                    LRUCache.getInstance().put(albums.get(position).getCoverPath(), bmp);
                }
            }
        } else {
            holder.gridItemImage.setImageResource(R.drawable.ic_vinyl_white_50dp);
        }
    }

