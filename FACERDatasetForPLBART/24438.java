    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TouchInterceptor listView = new TouchInterceptor(getActivity(), null);
        listView.setId(android.R.id.list);
        listView.setFastScrollEnabled(true);
        listView.setDropListener((from, to) -> {
            playQueueCursor.moveItem(from, to);
            listAdapter.notifyDataSetChanged();
            getListView().invalidateViews();
            deletedOneRow = true;
        });
        listView.setRemoveListener(this::removePlaylistItem);
        listView.setDivider(null);
        listView.setSelector(R.drawable.list_selector_background);

        registerForContextMenu(listView);

        listScrolled = false;
        listView.setOnScrollListener(this);

        return listView;
    }

