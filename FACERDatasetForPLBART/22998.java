    private void addSong(File file) {
        try {
            HashMap<String, String> song = new HashMap<String, String>();
            song.put(mSongTitle, file.getName().substring(0, (file.getName().lastIndexOf("."))));
            song.put(mSongPath, file.getPath());
            songsList.add(song);
        } catch (Exception e) {
            Log.d("",e.getLocalizedMessage());
        }
    }

