    @Override
    public void onBindViewHolder(final FolderAdapter.ItemHolder itemHolder, int i) {
        File localItem = mFileSet.get(i);
        Song song = mSongs.get(i);
        itemHolder.title.setText(localItem.getName());
        if (localItem.isDirectory()) {
            itemHolder.albumArt.setImageDrawable("..".equals(localItem.getName()) ? mIcons[1] : mIcons[0]);
        } else {
            ImageLoader.getInstance().displayImage(TimberUtils.getAlbumArtUri(song.albumId).toString(),
                    itemHolder.albumArt,
                    new DisplayImageOptions.Builder().
                            cacheInMemory(true).showImageOnFail(mIcons[2])
                            .resetViewBeforeLoading(true).build());
        }
    }

