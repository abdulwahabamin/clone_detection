    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);

        ArrayList<HashMap<String, String>> songsListData = new ArrayList<HashMap<String, String>>();

        SongsManager plm = new SongsManager();
        this.songsList = plm.getPlayList();

        for (HashMap<String, String> song : songsList) {
            songsListData.add(song);
        }

        ListAdapter adapter = new SimpleAdapter(this, songsListData,
                R.layout.playlist_item, new String[]{mSongTitle}, new int[]{
                R.id.songTitle});
        setListAdapter(adapter);

        ListView lv = getListView();
        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                try {
                    Intent in = new Intent(getApplicationContext(),
                            MainActivity.class);
                    in.putExtra(mSongIndex, position);
                    setResult(REQUEST_PLAYLIST, in);
                    finish();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getString(R.string.exception) + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

