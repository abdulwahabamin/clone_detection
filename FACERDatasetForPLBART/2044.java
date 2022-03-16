  private void setViews() {
    llAddToFavorites.setOnClickListener(v -> {
      List<DirectoryItem> list = directoryItemAdapter.getList();
      ArrayList<String> filesToAdd = new ArrayList<String>();
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getSelected()) {
          write(list.get(i).getFilepath());
        }
      }
      directoryItemAdapter.isCheckBoxVisibility = false;
      llButtons.setVisibility(View.GONE);
      refreshList();
    });
    llCopy.setOnClickListener(v -> {
      if (getCountOfSelectedItems() > 0) {
        directoryItemAdapter.isCheckBoxVisibility = false;
        Intent intent = new Intent(MainActivity.this, CopyMoveActivity.class);
        intent.putExtra(PATH, path);
        startActivityForResult(intent, INTENT_COPY);
      }
    });
    llMove.setOnClickListener(v -> {
      if (getCountOfSelectedItems() > 0) {
        directoryItemAdapter.isCheckBoxVisibility = false;
        Intent intent = new Intent(MainActivity.this, CopyMoveActivity.class);
        intent.putExtra(PATH, path);
        startActivityForResult(intent, INTENT_MOVE);
      }
    });
    llDelete.setOnClickListener(v -> {
      AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
      builder.setTitle("Delete " + getCountOfSelectedItems() + " items?")
          .setPositiveButton("YES", (dialog, which) -> {
            List<DirectoryItem> list = directoryItemAdapter.getList();
            for (int i = 0; i < list.size(); i++) {
              if (list.get(i).getSelected()) {
                DirectoryItem di = (DirectoryItem) list.get(i);
                delete(list.get(i).getFilepath());
              }
            }
            refreshList();
          })
          .setNegativeButton("Cancel", (dialog, id) -> dialog.cancel());
      AlertDialog alert = builder.create();
      alert.show();
      directoryItemAdapter.isCheckBoxVisibility = false;
      llButtons.setVisibility(View.GONE);
    });
    llShare.setOnClickListener((v) -> {
      Toast.makeText(MainActivity.this, "share", Toast.LENGTH_LONG).show();
      List<DirectoryItem> list = directoryItemAdapter.getList();
      ArrayList<Uri> filesToShare = new ArrayList<Uri>();
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getSelected()) {
          filesToShare.add(Uri.fromFile(new File(list.get(i).getFilepath())));
        }
      }
      shareMultiple(filesToShare, MainActivity.this);
      directoryItemAdapter.isCheckBoxVisibility = false;
      refreshList();
      llButtons.setVisibility(View.GONE);
    });
    listView.setOnItemClickListener((parent, view, position, id) -> {
      DirectoryItem file = (DirectoryItem) items.get(position);
      String filename = file.getFilepath();
      File intentFile = new File(filename);
      if (intentFile.isDirectory()) {
        path = filename;
        Log.i("TAG", path);

        refreshList();
      }
      if (intentFile.isFile()) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(intentFile), file.getIntentType());
        startActivity(intent);
      }
    });

    listView.setOnItemLongClickListener((parent, view, position, id) -> {
      llButtons.setVisibility(View.VISIBLE);
      directoryItemAdapter.isCheckBoxVisibility = true;
      DirectoryItem di = (DirectoryItem) items.get(position);
      di.setSelected(true);
      items.remove(position);
      items.add(position, di);
      directoryItemAdapter.updateList(items);
      return false;
    });
  }

