    @Override
    public void onBindViewHolder(Presenter.ViewHolder vh, Object o) {
        ViewHolder viewHolder = (ViewHolder)vh;
        SongItem item = (SongItem)o;

        viewHolder.title.setText(item.title);
        viewHolder.artist.setText(item.artist);
        viewHolder.duration.setText(MusicUtils.formatDuration(viewHolder.view.getContext(), item.duration));
    }

