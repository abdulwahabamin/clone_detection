    @Override
    public void onBindViewHolder(SongHolder holder, int position) {
        if(source == Source.CURSOR) {
            songCursor.moveToPosition(position);
            holder.bindView(songCursor, position);
        } else {
            holder.bindView(songList.get(position), position);
        }
    }

