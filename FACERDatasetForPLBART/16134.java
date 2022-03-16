    /** Initializes play queue from cursor and sets the initially pointed song as the current*/
    public PlayQueue(Cursor cursor) {
        queue = new ArrayList<>();
        currentPlaying = cursor.getPosition();
        cursor.moveToFirst();
        do {
            queue.add(Song.toSong(cursor));
        } while (cursor.moveToNext());
    }

