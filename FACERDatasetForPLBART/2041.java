  @OnClick(R.id.ibNewFolder)
  public void ibNewFolderClick(View v) {
    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
    final EditText etNewFolderName = new EditText(MainActivity.this);  //!!!!!
    builder.setTitle("Enter folder name")
        .setView(etNewFolderName)
        .setPositiveButton("Create", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            makeNewFolder(etNewFolderName.getText().toString());
            refreshList();
          }
        })
        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
          }
        });
    AlertDialog alert = builder.create();
    alert.show();
  }

