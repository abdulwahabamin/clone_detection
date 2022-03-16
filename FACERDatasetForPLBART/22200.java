    private void setupSlidingQueue() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        adapter = new SlidingQueueAdapter((AppCompatActivity) getActivity(), QueueLoader.getQueueSongs(getActivity()));
        recyclerView.setAdapter(adapter);
        recyclerView.scrollToPosition(MusicPlayer.getQueuePosition() - 3);
    }

