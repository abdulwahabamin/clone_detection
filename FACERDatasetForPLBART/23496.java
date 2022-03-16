    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        
        int sortMode = TRACK_MENU;
        if (icicle == null) {
            mSelectedUri = getIntent().getParcelableExtra(
                    RingtoneManager.EXTRA_RINGTONE_EXISTING_URI);
        } else {
            mSelectedUri = (Uri)icicle.getParcelable(
                    RingtoneManager.EXTRA_RINGTONE_EXISTING_URI);
            // Retrieve list state. This will be applied after the
            // QueryHandler has run
            mListState = icicle.getParcelable(LIST_STATE_KEY);
            mListHasFocus = icicle.getBoolean(FOCUS_KEY);
            sortMode = icicle.getInt(SORT_MODE_KEY, sortMode);
        }
        if (Intent.ACTION_GET_CONTENT.equals(getIntent().getAction())) {
            mBaseUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        } else {
            mBaseUri = getIntent().getData();
            if (mBaseUri == null) {
                Log.w("MusicPicker", "No data URI given to PICK action");
                finish();
                return;
            }
        }
        
        setContentView(R.layout.music_picker);

        mSortOrder = MediaStore.Audio.Media.TITLE_KEY;

        final ListView listView = getListView();

        listView.setItemsCanFocus(false);
        
        mAdapter = new TrackListAdapter(this, listView,
                R.layout.music_picker_item, new String[] {},
                new int[] {});

        setListAdapter(mAdapter);
        
        listView.setTextFilterEnabled(true);
        
        // We manually save/restore the listview state
        listView.setSaveEnabled(false);

        mQueryHandler = new QueryHandler(this);
        
        mProgressContainer = findViewById(R.id.progressContainer);
        mListContainer = findViewById(R.id.listContainer);
        
        mOkayButton = findViewById(R.id.okayButton);
        mOkayButton.setOnClickListener(this);
        mCancelButton = findViewById(R.id.cancelButton);
        mCancelButton.setOnClickListener(this);
        
        // If there is a currently selected Uri, then try to determine who
        // it is.
        if (mSelectedUri != null) {
            Uri.Builder builder = mSelectedUri.buildUpon();
            String path = mSelectedUri.getEncodedPath();
            int idx = path.lastIndexOf('/');
            if (idx >= 0) {
                path = path.substring(0, idx);
            }
            builder.encodedPath(path);
            Uri baseSelectedUri = builder.build();
            if (DBG) Log.v(TAG, "Selected Uri: " + mSelectedUri);
            if (DBG) Log.v(TAG, "Selected base Uri: " + baseSelectedUri);
            if (DBG) Log.v(TAG, "Base Uri: " + mBaseUri);
            if (baseSelectedUri.equals(mBaseUri)) {
                // If the base Uri of the selected Uri is the same as our
                // content's base Uri, then use the selection!
                mSelectedId = ContentUris.parseId(mSelectedUri);
            }
        }
        
        setSortMode(sortMode);
    }

