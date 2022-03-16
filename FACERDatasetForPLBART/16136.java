    public PlayQueue(File playQueueFile)throws IOException {
        queue = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(playQueueFile)));

        for (String string = reader.readLine(); string != null; string = reader.readLine()) {
            int songId = Integer.parseInt(string);
            Cursor cursor = Library.getSong(null, songId);
            if(cursor.moveToFirst()) {
                Song song = Song.toSong(cursor);
                cursor.close();
                queue.add(song);
            }
        }

        if(queue.size()<1) {
            throw new IOException("Invalid queue");
        }
    }

