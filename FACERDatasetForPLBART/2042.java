  @OnClick(R.id.ibSort)
  public void ibSortClick(View v) {
    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
    builder.setTitle("Sort by").setIcon(R.drawable.sort).setItems(sortVariants, (dialog, which) -> {
      if (which == 0) {
        comparator = new DirectoryItem.CompSize();
      }
      if (which == 1) {
        comparator = new DirectoryItem.CompDate();
      }
      if (which == 2) {
        comparator = new DirectoryItem.CompName();
      }
      Toast.makeText(MainActivity.this, sortVariants[which], Toast.LENGTH_LONG).show();
      Collections.sort(items, comparator);
      directoryItemAdapter.updateList(items);
    });

    builder.create();
    builder.show();
  }

