    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ListView listView = new ListView(getActivity());
        listView.setId(android.R.id.list);
        listView.setFastScrollEnabled(true);
        listView.setTextFilterEnabled(true);

        registerForContextMenu(listView);

        return listView;
    }

