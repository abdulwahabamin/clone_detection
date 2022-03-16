    @Override
    public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item,
                              RowPresenter.ViewHolder rowViewHolder, Row row) {
        SongItem song = (SongItem)item;

        MusicUtils.playSong(this, song.id);
        startActivity(new Intent(this, PlaybackActivity.class));
    }

