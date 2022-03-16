    private void setRenameButtonListener() {

        rename.setOnClickListener((view -> {
            if (selectedList.size() == 0) {
                successDialog("Select a file!!!", CDConstants.WARNING, CDConstants.MEDIUM);
                return;
            }
            operationFlag=true;
            Dialog dialog = new Dialog(this);
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawableResource(com.singh.multimeet.quicxplo.R.drawable.curved_back);
            dialog.setContentView(com.singh.multimeet.quicxplo.R.layout.rename_dialog_view);
            EditText newName = dialog.findViewById(com.singh.multimeet.quicxplo.R.id.new_name);
            newName.setText(selectedList.get(0).getName());
            FloatingActionButton done = dialog.findViewById(com.singh.multimeet.quicxplo.R.id.done);
            done.setOnClickListener((view1 -> {
                if (!newName.getText().equals("")) {
                    if (fileEx.getCurrentDir().contains("emulated")) {
                        fileEx.renameTo(selectedList.get(0).getPath(), newName.getText().toString());
                        filesAdapter.clearSelectedList();
                        filesAdapter.disableSelection();
                        filesAdapter.getOnDirectoryChangeListener()
                                .onDirectoryChange(loadDirectories());
                        showOrHideOptions(View.GONE);
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Renamed successfully!!!", Toast.LENGTH_SHORT).show();

                    } else {
                        Uri treeUri = Uri.parse(sharedPreferences.getString(Util.BASE_URI, ""));
                        DocumentFile documentFile = Util.getDocumentFile(this,
                                Util.getProcessedPath(selectedList.get(0).getPath())
                                , null, treeUri);
                        documentFile.renameTo(newName.getText().toString());
                        filesAdapter.clearSelectedList();
                        filesAdapter.disableSelection();
                        filesAdapter.getOnDirectoryChangeListener()
                                .onDirectoryChange(loadDirectories());
                        showOrHideOptions(View.GONE);
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Renamed successfully!!!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "lease give some same name", Toast.LENGTH_SHORT)
                            .show();
                }
            }));
            dialog.show();
        }));
    }

