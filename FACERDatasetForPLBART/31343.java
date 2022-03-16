    public void getCandidates(String keyWord) {
        if (mCities != null) {
            mCandidates.clear();
            for (CityEntity entity : mCities) {
                if (entity.getCity().contains(keyWord) || entity.getProvince().contains(keyWord)) {
                    mCandidates.add(entity);
                }
            }
            mView.refreshCandidatesList(mCandidates);
        }
    }

