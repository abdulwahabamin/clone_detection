    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // Adapter
        mQuickQueueAdapter = new QuickQueueAdapter(getActivity(), R.layout.quick_queue_items, null,
                new String[] {}, new int[] {}, 0);
        mGridView.setOnCreateContextMenuListener(this);
        mGridView.setOnItemClickListener(this);
        mGridView.setAdapter(mQuickQueueAdapter);

        // Important!
        getLoaderManager().initLoader(0, null, this);
        super.onActivityCreated(savedInstanceState);
    }

