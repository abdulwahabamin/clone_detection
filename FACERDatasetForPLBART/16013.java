    @Override
    public int getItemCount() {
        if(source == Source.CURSOR) {
            return songCursor.getCount();
        } else {
            return songList.size();
        }
    }

