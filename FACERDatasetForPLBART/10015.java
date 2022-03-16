    /**
     * Method that check the consistency of copy or move operations.<br/>
     * <br/>
     * The method checks the following rules:<br/>
     * <ul>
     * <li>Any of the files of the copy or move operation can not include the
     * current directory.</li>
     * <li>Any of the files of the copy or move operation can not include the
     * current directory.</li>
     * </ul>
     *
     * @param ctx The current context
     * @param files The list of source/destination files
     * @param currentDirectory The current directory
     * @param operation the operation is copy or move
     * @return boolean If the consistency is validate successfully
     */
    private static boolean checkCopyOrMoveConsistency(Context ctx, List<LinkedResource> files,
            String currentDirectory, final COPY_MOVE_OPERATION operation) {
        int cc = files.size();
        for (int i = 0; i < cc; i++) {
            LinkedResource linkRes = files.get(i);
            String src = FileHelper.addTrailingSlash(linkRes.mSrc.getAbsolutePath());
            String dst = linkRes.mDst.getAbsolutePath();

            // 1.- Current directory can't be moved
            if (operation.equals(COPY_MOVE_OPERATION.MOVE) &&
                    currentDirectory != null && currentDirectory.startsWith(src)) {
                // Operation not allowed
                AlertDialog dialog =
                        DialogHelper.createErrorDialog(
                                ctx,
                                R.string.error_title,
                                R.string.msgs_unresolved_inconsistencies);
                DialogHelper.delegateDialogShow(ctx, dialog);
                return false;
            }

            // 2.- Destination can't be a child of source
            if (dst.startsWith(src)) {
                // Operation not allowed
                AlertDialog dialog =
                        DialogHelper.createErrorDialog(
                                ctx,
                                R.string.error_title,
                                R.string.msgs_operation_not_allowed_in_current_directory);
                DialogHelper.delegateDialogShow(ctx, dialog);
                return false;
            }
        }
        return true;
    }

