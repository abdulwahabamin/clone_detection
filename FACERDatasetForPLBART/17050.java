    public AppPrefsHelper(Context context) {
        this.mContext = context;
        sharedPref = this.mContext
                .getSharedPreferences(
                        this.mContext.getString(app.sonu.com.musicplayer.R.string.preference_file_key),
                        Context.MODE_PRIVATE
                );
    }

