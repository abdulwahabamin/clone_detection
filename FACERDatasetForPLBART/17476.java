    public Playlist(long id, String title, int type, int iconDrawableId, int color) {
        mId = id;
        mTitle = title;
        mType = type;
        mTimeCreated = System.currentTimeMillis();
        mMusicMediaIds = new ArrayList<>();
        mIconDrawableId = iconDrawableId;
        mColor = color;
    }

