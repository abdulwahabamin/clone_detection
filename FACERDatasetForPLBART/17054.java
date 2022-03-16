    @Override
    public void createPlaylistIdList(String json) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(this.mContext.getString(R.string.playlist_id_list_pref_key), json);
        editor.commit();
    }

