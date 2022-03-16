    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            mSelectedPosition = savedInstanceState.getInt("selectedposition", -1);
            mSelectedId = savedInstanceState.getLong("selectedtrack", -1);
        }
    }

