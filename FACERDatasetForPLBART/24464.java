    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ListView listView;

        if (isEditMode()) {
            listView = new TouchInterceptor(getActivity(), null);
            ((TouchInterceptor) listView).setDropListener((from, to) ->
                    MediaStore.Audio.Playlists.Members.moveItem(getActivity().getContentResolver(), playlist, from, to));
            ((TouchInterceptor) listView).setRemoveListener(this::removePlaylistItem);
            listView.setDivider(null);
            listView.setSelector(R.drawable.list_selector_background);
        } else {
            listView = new ListView(getActivity());
            listView.setTextFilterEnabled(true);
        }

        listView.setId(android.R.id.list);
        listView.setFastScrollEnabled(true);

        registerForContextMenu(listView);

        return listView;
    }

