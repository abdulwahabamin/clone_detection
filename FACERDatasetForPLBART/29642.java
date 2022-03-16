  private void showItemHourlyDB() {
    Query<ItemHourlyDB> query = DbUtil.getItemHourlyDBQuery(itemHourlyDBBox, fiveDayWeather.getId());
    query.subscribe().on(AndroidScheduler.mainThread())
        .observer(new DataObserver<List<ItemHourlyDB>>() {
          @Override
          public void onData(@NonNull List<ItemHourlyDB> data) {
            if (data.size() > 0) {
              mItemAdapter.clear();
              mItemAdapter.add(data);
              setChartValues(data);
            }
          }
        });
  }

