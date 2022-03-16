    private void initView() {
        weatherGrid = (RecyclerView) findViewById(R.id.weather_grid);
        weatherGrid.setHasFixedSize(true);
        weatherAdaper = new WeatherAdaper();
        weatherGrid.setAdapter(weatherAdaper);
        GridLayoutManager gm = new GridLayoutManager(this, 2);

        weatherGrid.setLayoutManager(gm);
        weatherGrid.setItemAnimator(new DefaultItemAnimator());

        ItemTouchHelper touchHelper = new ItemTouchHelper(touchCallback);
        touchHelper.attachToRecyclerView(weatherGrid);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_content);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (!isNetWorkAccess()) {
                    toast("无网络，请�?试�?�网并下拉刷新");
                    swipeRefreshLayout.setRefreshing(false);
                    return;
                }
                initWeather();
            }
        });

    }

