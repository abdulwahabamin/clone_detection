  private void setViews() {
    horizontal_recycler_view = (RecyclerView) findViewById(R.id.horizontal_recycler_view2);
    listView = (ListView) findViewById(R.id.listView2);
    ibRootDirectory = (ImageButton) findViewById(R.id.ibRootDirectory);
    ibRootDirectory.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        path = "/";
        refreshList();
      }
    });

    ibHome = (ImageButton) findViewById(R.id.ibHome);
    ibHome.setOnClickListener((v) -> {
      setResult(RESULT_CANCELED);
      finish();
    });
    ibNewFolder = (ImageButton) findViewById(R.id.ibNewFolder);

    ibNewFolder.setOnClickListener((v) -> {
      AlertDialog.Builder builder = new AlertDialog.Builder(CopyMoveActivity.this);
      EditText etNewFolderName = new EditText(CopyMoveActivity.this);
      builder.setTitle("Enter folder name")
          .setView(etNewFolderName)
          .setPositiveButton("Create", (dialog, which) -> {
                makeNewFolder(etNewFolderName.getText().toString());
                refreshList();
              }
          )
          .setNegativeButton("Cancel", (dialog, id) -> dialog.cancel());
      AlertDialog alert = builder.create();
      alert.show();

    });
    llCancel = (LinearLayout) findViewById(R.id.llCancel);
    llCancel.setOnClickListener(v -> finish());
    llPasteHere = (LinearLayout) findViewById(R.id.llPasteHere);
    llPasteHere.setOnClickListener(v -> {
      Intent intent = new Intent();
      intent.putExtra(DIRECTORY_COPY_TO, path);
      setResult(RESULT_OK, intent);
      finish();
    });
    listView.setOnItemClickListener((parent, view, position, id) -> {
          DirectoryItem file = (DirectoryItem) items.get(position);
          String filename = file.getFilepath();
          File intentFile = new File(filename);
          if (intentFile.isDirectory()) {
            path = filename;
            refreshList();
          }
          if (intentFile.isFile()) {
            Toast.makeText(CopyMoveActivity.this, "Choose a directory, not a file", Toast.LENGTH_LONG)
                .show();
          }
        }
    );
  }

