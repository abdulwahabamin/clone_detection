    /**
     * Method that show a new dialog for input a name for an existing fso.
     *
     * @param menuItem The item menu associated
     * @param fso The file system object
     * @param allowFsoName If allow that the name of the fso will be returned
     */
    private void showFsoInputNameDialog(
            final MenuItem menuItem, final FileSystemObject fso, final boolean allowFsoName) {
        //Hide the dialog
        this.mDialog.hide();

        //Show the input name dialog
        final InputNameDialog inputNameDialog =
                new InputNameDialog(
                        this.mContext,
                        this.mOnSelectionListener.onRequestCurrentItems(),
                        fso,
                        allowFsoName,
                        menuItem.getTitle().toString());
        inputNameDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                //Show the menu again
                DialogHelper.delegateDialogShow(
                        ActionsDialog.this.mContext, ActionsDialog.this.mDialog);
            }
        });
        inputNameDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                //Retrieve the name an execute the action
                try {
                    String name = inputNameDialog.getName();
                    switch (menuItem.getItemId()) {
                        case R.id.mnu_actions_rename:
                            // Rename the fso
                            if (ActionsDialog.this.mOnSelectionListener != null) {
                                CopyMoveActionPolicy.renameFileSystemObject(
                                        ActionsDialog.this.mContext,
                                        inputNameDialog.mFso,
                                        name,
                                        ActionsDialog.this.mOnSelectionListener,
                                        ActionsDialog.this.mOnRequestRefreshListener);
                            }
                            break;

                        case R.id.mnu_actions_create_link:
                        case R.id.mnu_actions_create_link_global:
                            // Create a link to the fso
                            if (ActionsDialog.this.mOnSelectionListener != null) {
                                NewActionPolicy.createSymlink(
                                        ActionsDialog.this.mContext,
                                        inputNameDialog.mFso,
                                        name,
                                        ActionsDialog.this.mOnSelectionListener,
                                        ActionsDialog.this.mOnRequestRefreshListener);
                            }
                            break;

                        default:
                            break;
                    }

                } finally {
                    ActionsDialog.this.mDialog.dismiss();
                }
            }
        });
        inputNameDialog.show();
    }

