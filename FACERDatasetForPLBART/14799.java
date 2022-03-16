    /**
     * Creates the view to be used for the user to see.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return - view for the user to see.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.playlist_music_list_layout, container, false);

        fragmentCommunicator = (FragmentCommunicator) getActivity();
        playlistSongList = new ArrayList();
        playlistMap = new HashMap<>();
        listView = (ListView) view.findViewById(R.id.playlistListView);
        addPlaylistMusicButton = (FloatingActionButton) view.findViewById(R.id.addPlaylistMusicButton);
        listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, formattedSongList);

        listView.setAdapter(listAdapter);

        loadPlaylists();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                fragmentCommunicator.setSongList(playlistMap.get(fragmentCommunicator.getPlaylistTitle()));
                fragmentCommunicator.setCurrentSongIndex(playlistSongList.get(i));
                fragmentCommunicator.playSong(fragmentCommunicator.getCurrentSongIndex());
            }
        });

        addPlaylistMusicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_left, R.anim.slide_right, R.anim.slide_left, R.anim.slide_right);

                fragmentTransaction.replace(R.id.playlistMusicListLayout, addPlaylistMusicFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

