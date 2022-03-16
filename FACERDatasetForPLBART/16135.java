    public PlayQueue(Cursor cursor, ArrayList<Integer> selections){
        currentPlaying = 0;
        queue = new ArrayList<>();
        for(Integer i : selections){
            cursor.moveToPosition(i);
            queue.add(Song.toSong(cursor));
        }
    }

