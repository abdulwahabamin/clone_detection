    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final Context context = inflater.getContext();

        final View view = inflater.inflate(R.layout.fragment_directory, container, false);

        mEmptyView = view.findViewById(android.R.id.empty);

        mListView = (ListView) view.findViewById(R.id.list);
        mListView.setOnItemClickListener(mItemListener);

        mAdapter = new DocumentStackAdapter();
        mListView.setAdapter(mAdapter);

        final RootsCache roots = DocumentsApplication.getRootsCache(context);
        final State state = ((DocumentsActivity) getActivity()).getDisplayState();

        mCallbacks = new LoaderCallbacks<List<DocumentStack>>() {
            @Override
            public Loader<List<DocumentStack>> onCreateLoader(int id, Bundle args) {
                return new RecentsCreateLoader(context, roots, state);
            }

            @Override
            public void onLoadFinished(
                    Loader<List<DocumentStack>> loader, List<DocumentStack> data) {
                mAdapter.swapStacks(data);

                // When launched into empty recents, show drawer
                if (mAdapter.isEmpty() && !state.stackTouched) {
                    ((DocumentsActivity) context).setRootsDrawerOpen(true);
                }
            }

            @Override
            public void onLoaderReset(Loader<List<DocumentStack>> loader) {
                mAdapter.swapStacks(null);
            }
        };

        return view;
    }

