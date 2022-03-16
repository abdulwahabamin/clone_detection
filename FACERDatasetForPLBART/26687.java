    private void addCities(List<GeoCity> list) {
        if (mAdapter != null) {
              mAdapter.clear();
              mAdapter.addCities(list);
        }
    }

