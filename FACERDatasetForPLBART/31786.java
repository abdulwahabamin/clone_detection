    @Override
    public void onResume(){
        super.onResume();
        List<Location> allLocations = locationsDbHelper.getAllRows();
        updateAddLocationButton(allLocations);
        locationsAdapter = new LocationsAdapter(allLocations);
        recyclerView.setAdapter(locationsAdapter);
    }

