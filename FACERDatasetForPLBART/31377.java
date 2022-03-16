    @Override
    public void destroy() {
        if (mUseCase != null) {
            mUseCase.clear();
        }
        if (mListCities != null) {
            mListCities.clear();
        }
    }

