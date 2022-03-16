    public void onListItemClickListener() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onNavigationListener.onListItemClickedListener(musicList.get(position).getStreamLink(),
                        musicList.get(position).getName());
            }
        });
    }

