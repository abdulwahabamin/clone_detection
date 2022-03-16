    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupFragmentData();
        mListView.setOnCreateContextMenuListener(this);
        mListView.setOnItemClickListener(this);
        mListView.setAdapter(mAdapter);
        DragSortController controller = new DragSortController(mListView);
        controller.setDragHandleId(R.id.listview_drag_handle);
        controller.setRemoveEnabled(true);
        controller.setRemoveMode(1);
        mListView.setFloatViewManager(controller);
        mListView.setOnTouchListener(controller);
        getLoaderManager().initLoader(0, null, this);
    }

