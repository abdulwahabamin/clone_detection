    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle)
    {
        super.onCreate(icicle);

        mFirstYear = getIntent().getStringExtra("firstyear");
        mLastYear = getIntent().getStringExtra("lastyear");

        if (mFirstYear == null) {
            setTitle(R.string.all_title);
        } else if (mFirstYear.equals(mLastYear)) {
            setTitle(mFirstYear);
        } else {
            setTitle(mFirstYear + "-" + mLastYear);
        }
        MusicUtils.bindToService(this);
        init();
    }

