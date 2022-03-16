    @Override
    public void onDestroyView() {
        super.onDestroyView();

        // Cancel any outstanding thumbnail requests
        final ViewGroup target = (mListView.getAdapter() != null) ? mListView : mGridView;
        final int count = target.getChildCount();
        for (int i = 0; i < count; i++) {
            final View view = target.getChildAt(i);
            mRecycleListener.onMovedToScrapHeap(view);
        }

        // Tear down any selection in progress
        mListView.setChoiceMode(AbsListView.CHOICE_MODE_NONE);
        mGridView.setChoiceMode(AbsListView.CHOICE_MODE_NONE);
    }

