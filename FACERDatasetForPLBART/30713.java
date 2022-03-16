    @Override
    public void onDestroyView() {
        cityWeatherAdapter.clearListeners();
        presenter.detachView(false);
        super.onDestroyView();
    }

