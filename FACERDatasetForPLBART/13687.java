    @Override
    public void fabClicked() {
        getView().setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                contextMenu.setHeaderTitle("Select Action");
                contextMenu.add("Create File")
                        .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                displayAlertDialogWithEdittext(getActivity(),
                                        "Create File",
                                        "New File Name",
                                        null,
                                        new AlertDialogCallback() {
                                            @Override
                                            public void alertDialogPositiveButtonClicked(Object obj) {
                                                String newFileName = String.valueOf(obj);

                                                presenter.createNewFile(CURRENT_DIR, newFileName, false);
                                            }

                                            @Override
                                            public void alertDialogNegativeButtonClicked(String message) {
                                                if (message != null)
                                                    onError(message);
                                            }
                                        });

                                return true;
                            }
                        });
                contextMenu.add("Create Folder")
                        .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                displayAlertDialogWithEdittext(getActivity(),
                                        "Create Folder",
                                        "New Folder Name",
                                        null,
                                        new AlertDialogCallback() {
                                            @Override
                                            public void alertDialogPositiveButtonClicked(Object obj) {
                                                String newFileName = String.valueOf(obj);

                                                presenter.createNewFile(CURRENT_DIR, newFileName, true);
                                            }

                                            @Override
                                            public void alertDialogNegativeButtonClicked(String message) {
                                                if (message != null)
                                                    onError(message);
                                            }
                                        });

                                return true;
                            }
                        });
            }
        });
        getView().showContextMenu();    // calling context menu on single click
    }

