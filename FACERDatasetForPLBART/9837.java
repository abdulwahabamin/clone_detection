    /**
     * {@inheritDoc}
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, final long id) {

        //Retrieve the menu item
        MenuItem menuItem = ((TwoColumnsMenuListAdapter)parent.getAdapter()).getItemById((int)id);

        //What action was selected?
        switch ((int)id) {
            //- Create new object
            case R.id.mnu_actions_new_directory:
            case R.id.mnu_actions_new_file:
                // Dialog is dismissed inside showInputNameDialog
                if (this.mOnSelectionListener != null) {
                    showInputNameDialog(menuItem);
                    return;
                }
                break;

            //- Rename
            case R.id.mnu_actions_rename:
                // Dialog is dismissed inside showInputNameDialog
                if (this.mOnSelectionListener != null) {
                    showFsoInputNameDialog(menuItem, this.mFso, false);
                    return;
                }
                break;

            //- Create link
            case R.id.mnu_actions_create_link:
                // Dialog is dismissed inside showInputNameDialog
                if (this.mOnSelectionListener != null) {
                    showFsoInputNameDialog(menuItem, this.mFso, true);
                    return;
                }
                break;
            case R.id.mnu_actions_create_link_global:
                // Dialog is dismissed inside showInputNameDialog
                if (this.mOnSelectionListener != null) {
                    // The selection must be only 1 item
                    List<FileSystemObject> selection =
                            this.mOnSelectionListener.onRequestSelectedFiles();
                    if (selection != null && selection.size() == 1) {
                        showFsoInputNameDialog(menuItem, selection.get(0), true);
                    }
                    return;
                }
                break;

            //- Delete
            case R.id.mnu_actions_delete:
                DeleteActionPolicy.removeFileSystemObject(
                        this.mContext,
                        this.mFso,
                        this.mOnSelectionListener,
                        this.mOnRequestRefreshListener,
                        null);
                break;

            //- Refresh
            case R.id.mnu_actions_refresh:
                if (this.mOnRequestRefreshListener != null) {
                    this.mOnRequestRefreshListener.onRequestRefresh(null, false); //Refresh all
                }
                break;

            //- Select/Deselect
            case R.id.mnu_actions_select:
            case R.id.mnu_actions_deselect:
                if (this.mOnSelectionListener != null) {
                    this.mOnSelectionListener.onToggleSelection(this.mFso);
                }
                break;
            case R.id.mnu_actions_select_all:
                if (this.mOnSelectionListener != null) {
                    this.mOnSelectionListener.onSelectAllVisibleItems();
                }
                break;
            case R.id.mnu_actions_deselect_all:
                if (this.mOnSelectionListener != null) {
                    this.mOnSelectionListener.onDeselectAllVisibleItems();
                }
                break;

            //- Open
            case R.id.mnu_actions_open:
                IntentsActionPolicy.openFileSystemObject(
                        this.mContext, this.mFso, false, null);
                break;
            //- Open with
            case R.id.mnu_actions_open_with:
                IntentsActionPolicy.openFileSystemObject(
                        this.mContext, this.mFso, true, null);
                break;

            //- Execute
            case R.id.mnu_actions_execute:
                ExecutionActionPolicy.execute(this.mContext, this.mFso);
                break;

            //- Send
            case R.id.mnu_actions_send:
                IntentsActionPolicy.sendFileSystemObject(
                        this.mContext, this.mFso, null);
                break;
            case R.id.mnu_actions_send_selection:
                if (this.mOnSelectionListener != null) {
                    List<FileSystemObject> selection =
                            this.mOnSelectionListener.onRequestSelectedFiles();
                    if (selection.size() == 1) {
                        IntentsActionPolicy.sendFileSystemObject(
                                this.mContext, selection.get(0), null);
                    } else {
                        IntentsActionPolicy.sendMultipleFileSystemObject(
                                this.mContext, selection, null);
                    }
                }
                break;

            // Paste selection
            case R.id.mnu_actions_paste_selection:
                if (this.mOnSelectionListener != null) {
                    List<FileSystemObject> selection =
                            this.mOnSelectionListener.onRequestSelectedFiles();
                    CopyMoveActionPolicy.copyFileSystemObjects(
                            this.mContext,
                            createLinkedResource(selection, this.mFso),
                            this.mOnSelectionListener,
                            this.mOnRequestRefreshListener);
                }
                break;
            // Move selection
            case R.id.mnu_actions_move_selection:
                if (this.mOnSelectionListener != null) {
                    List<FileSystemObject> selection =
                            this.mOnSelectionListener.onRequestSelectedFiles();
                    CopyMoveActionPolicy.moveFileSystemObjects(
                            this.mContext,
                            createLinkedResource(selection, this.mFso),
                            this.mOnSelectionListener,
                            this.mOnRequestRefreshListener);
                }
                break;
            // Delete selection
            case R.id.mnu_actions_delete_selection:
                if (this.mOnSelectionListener != null) {
                    List<FileSystemObject> selection =
                            this.mOnSelectionListener.onRequestSelectedFiles();
                    DeleteActionPolicy.removeFileSystemObjects(
                            this.mContext,
                            selection,
                            this.mOnSelectionListener,
                            this.mOnRequestRefreshListener,
                            null);
                }
                break;

            //- Uncompress
            case R.id.mnu_actions_extract:
                CompressActionPolicy.uncompress(
                            this.mContext,
                            this.mFso,
                            this.mOnRequestRefreshListener);
                break;
            //- Compress
            case R.id.mnu_actions_compress:
                if (this.mOnSelectionListener != null) {
                    CompressActionPolicy.compress(
                            this.mContext,
                            this.mFso,
                            this.mOnSelectionListener,
                            this.mOnRequestRefreshListener);
                }
                break;
            case R.id.mnu_actions_compress_selection:
                if (this.mOnSelectionListener != null) {
                    CompressActionPolicy.compress(
                            this.mContext,
                            this.mOnSelectionListener,
                            this.mOnRequestRefreshListener);
                }
                break;

            //- Create copy
            case R.id.mnu_actions_create_copy:
                // Create a copy of the fso
                if (this.mOnSelectionListener != null) {
                    CopyMoveActionPolicy.createCopyFileSystemObject(
                                this.mContext,
                                this.mFso,
                                this.mOnSelectionListener,
                                this.mOnRequestRefreshListener);
                }
                break;

            //- Add to bookmarks
            case R.id.mnu_actions_add_to_bookmarks:
            case R.id.mnu_actions_add_to_bookmarks_current_folder:
                Bookmark bookmark = BookmarksActionPolicy.addToBookmarks(
                        this.mContext, this.mFso);
                if (mBackRef != null && bookmark != null) {
                    // tell NavigationActivity's drawer to add the bookmark
                    mBackRef.addBookmark(bookmark);
                }
                break;

            //- Add shortcut
            case R.id.mnu_actions_add_shortcut:
            case R.id.mnu_actions_add_shortcut_current_folder:
                IntentsActionPolicy.createShortcut(this.mContext, this.mFso);
                break;

            //- Compute checksum
            case R.id.mnu_actions_compute_checksum:
                InfoActionPolicy.showComputeChecksumDialog(this.mContext, this.mFso);
                break;

            //- Print
            case R.id.mnu_actions_print:
                PrintActionPolicy.printDocument(this.mContext, this.mFso);
                break;

            //- Properties
            case R.id.mnu_actions_properties:
            case R.id.mnu_actions_properties_current_folder:
                FileSystemObject fso = this.mFso;
                if (this.mOnSelectionListener != null) {
                    List<FileSystemObject> selection = this.mOnSelectionListener
                            .onRequestSelectedFiles();
                    if (selection.size() == 1) {
                        fso = selection.get(0);
                    }
                }
                InfoActionPolicy.showPropertiesDialog(
                        this.mContext, fso, this.mOnRequestRefreshListener);
                break;

            //- Navigate to parent
            case R.id.mnu_actions_open_parent_folder:
                NavigationActionPolicy.openParentFolder(
                        this.mContext, this.mFso, this.mOnRequestRefreshListener);
                break;

                // Set as home
            case R.id.mnu_actions_set_as_home:
            case R.id.mnu_actions_global_set_as_home:
                try {
                    Preferences.savePreference(
                            FileManagerSettings.SETTINGS_INITIAL_DIR, mFso.getFullPath(), true);
                    mOnRequestRefreshListener.onRequestBookmarksRefresh();
                    DialogHelper.showToast(mContext, R.string.msgs_success, Toast.LENGTH_SHORT);
                } catch (InvalidClassException e) {
                    ExceptionUtil.translateException(mContext, e);
                }
                break;

            default:
                break;
        }

        //Dismiss the dialog
        this.mDialog.dismiss();
    }

