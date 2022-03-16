    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_music_layout, container, false);

        fragmentCommunicator = (FragmentCommunicator) getActivity();
        listView = (ListView) view.findViewById(R.id.listView);

        songList = fragmentCommunicator.loadAllSongs();
        formattedSongList = new ArrayList<>();
        for(File f : songList){
            formattedSongList.add(f.getName());
        }

        listAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, formattedSongList);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                fragmentCommunicator.setSongList(songList);
                fragmentCommunicator.playSong(i);
            }
        });

        return view;
    }

