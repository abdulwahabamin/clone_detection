  private void setViews() {
    ibSort = (ImageButton) findViewById(R.id.ibSort);
    ibSort.setOnClickListener((v) -> {
      AlertDialog.Builder builder = new AlertDialog.Builder(SearchActivity.this);
      builder.setTitle("Sort by")
          .setIcon(R.drawable.sort)
          .setItems(sortVariants, (dialog, which) -> {
            if (which == 0) {
              comparator = new DirectoryItem.CompSize();
            }
            if (which == 1) {
              comparator = new DirectoryItem.CompDate();
            }
            if (which == 2) {
              comparator = new DirectoryItem.CompName();
            }
            Toast.makeText(getApplicationContext(), sortVariants[which], Toast.LENGTH_LONG)
                .show();
            Collections.sort(items, comparator);
            directoryItemAdapter.updateList(items);
          });
      builder.create();
      builder.show();
    });
    ibHome = (ImageButton) findViewById(R.id.ibHome);
    ibHome.setOnClickListener((v) -> finish());
    etSearch = (EditText) findViewById(R.id.etSearch);
    ibSearch = (ImageButton) findViewById(R.id.ibSearch);
    ibSearch.setOnClickListener((v) -> {
      SearchTask searchTask = new SearchTask();
      if (etSearch.getText().toString() != "") {
        searchTask.execute(etSearch.getText().toString());
      }
      try {
        items = searchTask.get();
        Collections.sort(items, comparator);
        directoryItemAdapter.updateList(items);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    });
    listView = (ListView) findViewById(R.id.listView);
    llButtons = (LinearLayout) findViewById(R.id.llButtons);
    llAddToFavorites = (LinearLayout) findViewById(R.id.llAddToFavorites);
    llAddToFavorites.setOnClickListener(v -> {
      List<DirectoryItem> list = directoryItemAdapter.getList();
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getSelected()) {
          write(list.get(i).getFilepath());
        }
      }
      directoryItemAdapter.isCheckBoxVisibility = false;
      llButtons.setVisibility(View.GONE);
      directoryItemAdapter.updateList(items);
    });
    llShare = (LinearLayout) findViewById(R.id.llShare);
    llShare.setOnClickListener((v) -> {
      List<DirectoryItem> list = directoryItemAdapter.getList();
      ArrayList<Uri> filesToShare = new ArrayList<Uri>();
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getSelected()) {
          filesToShare.add(Uri.fromFile(new File(list.get(i).getFilepath())));
        }
      }
      shareMultiple(filesToShare, SearchActivity.this);
      directoryItemAdapter.isCheckBoxVisibility = false;
      llButtons.setVisibility(View.GONE);
    });
    llDelete = (LinearLayout) findViewById(R.id.llDelete);
    llDelete.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(SearchActivity.this);
        builder.setTitle("Delete " + getCountOfSelectedItems() + " items?")
            .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                    List<DirectoryItem> list = directoryItemAdapter.getList();
                    for (int i = 0; i < list.size(); i++) {
                      if (list.get(i).getSelected()) {
                        DirectoryItem di = (DirectoryItem) list.get(i);
                        delete(list.get(i).getFilepath());
                        items.remove(i);
                      }
                    }
                    directoryItemAdapter.updateList(items);
                  }
                }
            )
            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
              }
            });
        AlertDialog alert = builder.create();
        alert.show();
        directoryItemAdapter.isCheckBoxVisibility = false;
        llButtons.setVisibility(View.GONE);
      }
    });
    llCopy = (LinearLayout) findViewById(R.id.llCopy);
    llCopy.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (getCountOfSelectedItems() > 0) {
          directoryItemAdapter.isCheckBoxVisibility = false;
          Intent intent = new Intent(SearchActivity.this, CopyMoveActivity.class);
          intent.putExtra(PATH, "/");
          startActivityForResult(intent, INTENT_COPY);
        }
      }
    });
    bMove = (LinearLayout) findViewById(R.id.llMove);
    bMove.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (getCountOfSelectedItems() > 0) {
          directoryItemAdapter.isCheckBoxVisibility = false;
          Intent intent = new Intent(SearchActivity.this, CopyMoveActivity.class);
          intent.putExtra(PATH, "/");
          startActivityForResult(intent, INTENT_MOVE);
        }
      }
    });
    listView.setOnItemClickListener((parent, view, position, id) -> {
      DirectoryItem file = (DirectoryItem) items.get(position);
      String filename = file.getFilepath();
      File intentFile = new File(filename);
      if (intentFile.isDirectory()) {
        Intent directoryIntent = new Intent(SearchActivity.this, MainActivity.class);
        directoryIntent.putExtra(PATH, filename);
        startActivityForResult(directoryIntent, INTENT_MAIN);
      }
      if (intentFile.isFile()) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(intentFile), file.getIntentType());
        startActivity(intent);
      }
    }
    );

    listView.setOnItemLongClickListener((parent, view, position, id) -> {
      llButtons.setVisibility(View.VISIBLE);
      directoryItemAdapter.isCheckBoxVisibility = true;
      DirectoryItem di = (DirectoryItem) items.get(position);
      di.setSelected(true);
      items.remove(position);
      items.add(position, di);
      directoryItemAdapter.updateList(items);
      return false;
    }
    );
  }

