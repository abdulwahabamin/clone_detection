    /**
     * Constructor of <code>Bookmark</code>.
     *
     * @param c The cursor with the information of the bookmark
     */
    public Bookmark(Cursor c) {
        super();
        this.mId = c.getInt(Columns.BOOKMARK_ID_INDEX);
        this.mType = BOOKMARK_TYPE.USER_DEFINED;
        this.mPath = c.getString(Columns.BOOKMARK_PATH_INDEX);
        this.mName = new File(this.mPath).getName();
    }

