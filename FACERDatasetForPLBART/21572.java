    @Override
    public void onBindViewHolder(ItemHolder itemHolder, int i) {

//        setAnimation(itemHolder.itemView, i);
        Song localItem = arraylist.get(i);

        ImageLoader.getInstance().displayImage(TimberUtils.getAlbumArtUri(localItem.albumId).toString(),
                itemHolder.albumArt, new DisplayImageOptions.Builder().cacheInMemory(true)
                        .showImageOnLoading(R.drawable.ic_empty_music2).resetViewBeforeLoading(true).build());

    }

