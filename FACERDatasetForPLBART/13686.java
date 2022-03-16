    @Override
    public void onAdapterItemRenameClicked(View view, int position) {
        final FileModel fileModel = adapter.getItem(position);    // Fetching current file

        // Display Dialog to fetch new fileName
        displayAlertDialogWithEdittext(getActivity(),
                "Rename",
                "New File Name",
                fileModel.getName(),
                new AlertDialogCallback() {
                    @Override
                    public void alertDialogPositiveButtonClicked(Object obj) {
                        String newFileName = String.valueOf(obj);

                        presenter.renameFile(fileModel, newFileName);
                    }

                    @Override
                    public void alertDialogNegativeButtonClicked(String message) {
                        if (message != null)
                            onError(message);
                    }
                });
    }

