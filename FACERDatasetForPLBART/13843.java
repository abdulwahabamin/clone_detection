    public void loadListData() {
        dataAdapter = new DownloadedItemAdapter(getActivity(), R.layout.downloaded_song_item, musicList);
        mListView.setAdapter(dataAdapter);
        dataAdapter.setCallback(onNavigationListener);
        dataAdapter.sort(new MusicAlphabeticComparator());
    }

