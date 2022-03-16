    @Override
    public void refreshCandidatesList(List<CityEntity> candidates) {
        mCandidates.clear();
        mCandidates.addAll(candidates);
        mAdapter.notifyDataSetChanged();
    }

