    /**
     * Displays a "Rename" dialog and renames the specified file/folder.
     *
     * @param path The path of the folder/file that needs to be renamed.
     */
    public void rename(String path) {

        final File renameFile = new File(path);
        final AlertDialog renameAlertDialog = new AlertDialog.Builder(getActivity()).create();
        final EditText fileEditText = new EditText(getActivity());

        fileEditText.setHint(R.string.file_name);
        fileEditText.setSingleLine(true);
        fileEditText.setText(renameFile.getName());

        renameAlertDialog.setView(fileEditText);
        renameAlertDialog.setTitle(R.string.rename);
        renameAlertDialog.setButton(DialogInterface.BUTTON_NEGATIVE,
                                    mContext.getResources().getString(R.string.cancel),
                                    new DialogInterface.OnClickListener() {

                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            renameAlertDialog.dismiss();
                                        }

                                    });

        renameAlertDialog.setButton(DialogInterface.BUTTON_POSITIVE,
                                    mContext.getResources().getString(R.string.rename),
                                    new DialogInterface.OnClickListener() {

                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                            //Check if the new file name is empty.
                                            if (fileEditText.getText().toString().isEmpty()) {
                                                Toast.makeText(getActivity(), R.string.enter_a_name_for_folder, Toast.LENGTH_LONG).show();
                                            } else {

                                                File newNameFile = null;
                                                try {
                                                    newNameFile = new File(renameFile.getParentFile().getCanonicalPath() + "/" + fileEditText.getText().toString());
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                    Toast.makeText(getActivity(), R.string.folder_could_not_be_renamed, Toast.LENGTH_LONG).show();
                                                    return;
                                                }

                                                try {
                                                    if (renameFile.isDirectory())
                                                        FileUtils.moveDirectory(renameFile, newNameFile);
                                                    else
                                                        FileUtils.moveFile(renameFile, newNameFile);

                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                    Toast.makeText(getActivity(), R.string.folder_could_not_be_renamed, Toast.LENGTH_LONG).show();
                                                    return;
                                                }

                                                Toast.makeText(getActivity(), R.string.folder_renamed, Toast.LENGTH_SHORT).show();
                                                renameAlertDialog.dismiss();
                                                refreshListView();

                                            }

                                        }

                                    });

        renameAlertDialog.show();

    }

