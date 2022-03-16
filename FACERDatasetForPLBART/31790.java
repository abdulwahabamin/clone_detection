    private void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.search_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(org.thosp.yourlocalweather.LocationsActivity.this));

        final LocationsSwipeController swipeController = new LocationsSwipeController(new LocationsSwipeControllerActions() {
            @Override
            public void onRightClicked(int position) {
                if (position == 0) {
                    Location location = locationsAdapter.locations.get(0);
                    if (addLocationDisabled && !location.isEnabled()) {
                        notifyUserAboutMaxAllowedLocations();
                    } else {
                        disableEnableLocation();
                    }
                } else {
                    deleteLocation(position);
                }
            }
        }, this);

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });

        itemTouchhelper.attachToRecyclerView(recyclerView);
    }

