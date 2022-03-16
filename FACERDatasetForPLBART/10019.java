    /**
     * Method that check the consistency of delete operations.<br/>
     * <br/>
     * The method checks the following rules:<br/>
     * <ul>
     * <li>Any of the files of the move or delete operation can not include the
     * current directory.</li>
     * </ul>
     *
     * @param ctx The current context
     * @param files The list of source/destination files
     * @param currentDirectory The current directory
     * @return boolean If the consistency is validate successfully
     */
    private static boolean checkRemoveConsistency(
            Context ctx, List<FileSystemObject> files, String currentDirectory) {
        int cc = files.size();
        for (int i = 0; i < cc; i++) {
            FileSystemObject fso = files.get(i);

            // 1.- Current directory can't be deleted
            if (currentDirectory.startsWith(fso.getFullPath())) {
                // Operation not allowed
                AlertDialog dialog =
                        DialogHelper.createWarningDialog(
                                ctx,
                                R.string.warning_title,
                                R.string.msgs_unresolved_inconsistencies);
                DialogHelper.delegateDialogShow(ctx, dialog);
                return false;
            }
        }
        return true;
    }

