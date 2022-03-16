    @Override
    public void onStart() {
        super.onStart();
        IntentFilter f = new IntentFilter();
        f.addAction(ApolloService.PLAYSTATE_CHANGED);
        f.addAction(ApolloService.META_CHANGED);
        getActivity().registerReceiver(mStatusListener, new IntentFilter(f));

        long next = refreshNow();
        queueNextRefresh(next);
        
        WeakReference<VisualizerView> mView = new WeakReference<VisualizerView>((VisualizerView)root.findViewById(R.id.visualizerView));
        VisualizerUtils.updateVisualizerView(mView);

    }

