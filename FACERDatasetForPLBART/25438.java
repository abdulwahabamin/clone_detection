    private void initializeData() {
        musicList = new ArrayList<>();
        musicList = mPlayerService.filesQueue;

        rv = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        MusicRVAdapter adapter = new MusicRVAdapter(musicList);
        rv.setAdapter(adapter);
    }

