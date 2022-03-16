    private void setDeleteButtonListener() {
        delete.setOnClickListener((view) -> {
            if (selectedList.size() == 0) {
                successDialog("Select a file!!!", CDConstants.WARNING, CDConstants.MEDIUM);
                return;
            }
            operationFlag=true;
            new AlertDialog.Builder(this)
                    .setCancelable(false).setTitle("Delete")
                    .setMessage("Do you want to delete...?")
                    .setPositiveButton("Yup", (dialogInterface, i) -> {

                        for (FileDirectory fileDirectory : selectedList) {
                            if (fileEx.getCurrentDir().contains("emulated")) {
                                fileEx.delete(fileDirectory.getPath());
                            } else
                                delete(fileDirectory.getPath(), fileDirectory.getName());
                        }

                        Toast.makeText(getApplicationContext(), "Files deleted.", Toast.LENGTH_SHORT).show();
                        filesAdapter.clearSelectedList();
                        filesAdapter.disableSelection();

                        paste.setVisibility(View.GONE);
                        filesAdapter.getOnDirectoryChangeListener()
                                .onDirectoryChange(loadDirectories());
                        showOrHideOptions(View.GONE);
                    }).setNegativeButton("No", ((dialogInterface, i) -> {
            })).show();
        });
    }

