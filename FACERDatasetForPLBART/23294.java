    public void init() {

        setContentView(R.layout.media_picker_activity);

        MakeCursor();
        if (null == mCursor || 0 == mCursor.getCount()) {
            return;
        }

        PickListAdapter adapter = new PickListAdapter(
                this,
                R.layout.track_list_item,
                mCursor,
                new String[] {},
                new int[] {});

        setListAdapter(adapter);
    }

