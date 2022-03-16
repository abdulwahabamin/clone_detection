    @Override
    public int getItemViewType(int position) {
        if (mediaItemWrappers.get(position).getCategory() == Category.TRACK)
            return Category.TRACK;
        if (mediaItemWrappers.get(position).getCategory() == Category.ALBUM)
            return Category.ALBUM;
        if (mediaItemWrappers.get(position).getCategory() == Category.ARTIST)
            return Category.ARTIST;
        return Category.NONE;
    }

