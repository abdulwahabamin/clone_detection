    @Override
    public void putPlaylist(String id, String playlist) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(id, playlist);
        editor.commit();
    }

