    /**
     * Method that configure the menu to show according the actual information,
     * the kind of request, the file selection, the mount point, ...
     *
     * @param menu The menu to configure
     */
    private void configureMenu(Menu menu) {
        // Selection
        List<FileSystemObject> selection = null;
        if (this.mOnSelectionListener != null) {
            selection = this.mOnSelectionListener.onRequestSelectedFiles();
        }

        //- Check actions that needs a valid reference
        if (!this.mGlobal && this.mFso != null) {
            //- Select/Deselect -> Only one of them
            if (this.mOnSelectionListener != null) {
                boolean selected =
                        SelectionHelper.isFileSystemObjectSelected(
                                this.mOnSelectionListener.onRequestSelectedFiles(),
                                this.mFso);
                menu.removeItem(selected ? R.id.mnu_actions_select : R.id.mnu_actions_deselect);

            } else {
                // Remove both menus
                menu.removeItem(R.id.mnu_actions_select);
                menu.removeItem(R.id.mnu_actions_deselect);

                // Not allowed because we need a list of the current files (only from navigation
                // activity)
                menu.removeItem(R.id.mnu_actions_rename);
                menu.removeItem(R.id.mnu_actions_create_copy);
            }

            //- Open/Open with -> Only when the fso is not a folder and is not a system file
            if (FileHelper.isDirectory(this.mFso) || FileHelper.isSystemFile(this.mFso)) {
                menu.removeItem(R.id.mnu_actions_open);
                menu.removeItem(R.id.mnu_actions_open_with);
                menu.removeItem(R.id.mnu_actions_send);
            }

            if (!IntentsActionPolicy.sendHandledByAnyActivity(mContext, this.mFso)) {
                menu.removeItem(R.id.mnu_actions_send);
            }

            // Create link (not allow in storage volume)
            if (StorageHelper.isPathInStorageVolume(this.mFso.getFullPath())) {
                menu.removeItem(R.id.mnu_actions_create_link);
            }

            //Execute only if mime/type category is EXEC
            MimeTypeCategory category = MimeTypeHelper.getCategory(this.mContext, this.mFso);
            if (category.compareTo(MimeTypeCategory.EXEC) != 0) {
                menu.removeItem(R.id.mnu_actions_execute);
            }

            //- Checksum (only supported for files)
            if (FileHelper.isDirectory(this.mFso) || this.mFso instanceof Symlink) {
                menu.removeItem(R.id.mnu_actions_compute_checksum);
            }

            //- Print (only for text and image categories)
            if (!PrintActionPolicy.isPrintedAllowed(mContext, mFso)) {
                menu.removeItem(R.id.mnu_actions_print);
            }
        }

        //- Add to bookmarks -> Only directories
        if (this.mFso != null && FileHelper.isRootDirectory(this.mFso)) {
            menu.removeItem(R.id.mnu_actions_add_to_bookmarks);
            menu.removeItem(R.id.mnu_actions_add_to_bookmarks_current_folder);
        }

        //- Remove properties option if multiple files selected
        // or this selection contains a secure folder.
        if ((selection != null && selection.size() > 1) || containsSecureDirectory(selection)) {
            menu.removeItem(R.id.mnu_actions_properties);
            menu.removeItem(R.id.mnu_actions_properties_current_folder);
        }

        //- Paste/Move only when have a selection
        if (this.mGlobal) {
            if (selection == null || selection.size() == 0 ||
                    (this.mFso != null && !FileHelper.isDirectory(this.mFso))) {
                // Remove paste/move actions
                menu.removeItem(R.id.mnu_actions_paste_selection);
                menu.removeItem(R.id.mnu_actions_move_selection);
                menu.removeItem(R.id.mnu_actions_delete_selection);
            }
        }
        //- Create link
        if (this.mGlobal && (selection == null || selection.size() == 0
                || selection.size() > 1)) {
            // Only when one item is selected
            menu.removeItem(R.id.mnu_actions_create_link_global);
        } else if (this.mGlobal  && selection != null) {
            // Create link (not allow in sdcard, secure or remote storage volumes)
            FileSystemObject fso = selection.get(0);
            if (StorageHelper.isPathInStorageVolume(fso.getFullPath())
                    || fso.isSecure() || fso.isRemote()) {
                menu.removeItem(R.id.mnu_actions_create_link_global);
            }
        } else if (!this.mGlobal) {
            // Create link (not allow in sdcard, secure or remote storage volumes)
            if (StorageHelper.isPathInStorageVolume(this.mFso.getFullPath())
                    || mFso.isSecure() || mFso.isRemote()) {
                menu.removeItem(R.id.mnu_actions_create_link);
            }
        }

        //- Compress/Uncompress (only when selection is available)
        if (this.mOnSelectionListener != null) {
            //Compress
            if (this.mGlobal) {
                if (selection == null || selection.size() == 0) {
                    menu.removeItem(R.id.mnu_actions_compress_selection);
                } else {
                    for (FileSystemObject fso : selection) {
                        // Ignore for system, secure or remote files
                        if (fso instanceof SystemFile || fso.isSecure() || fso.isRemote()) {
                            menu.removeItem(R.id.mnu_actions_compress_selection);
                            break;
                        }
                    }
                }
            } else {
                // Ignore for system, secure or remote files
                if (this.mFso instanceof SystemFile || mFso.isSecure() || mFso.isRemote()) {
                    menu.removeItem(R.id.mnu_actions_compress);
                }
            }
            //Uncompress (Only supported files)
            if (!this.mGlobal && !FileHelper.isSupportedUncompressedFile(this.mFso)) {
                menu.removeItem(R.id.mnu_actions_extract);
            }

            // Send multiple (only regular files)
            if (this.mGlobal) {
                if (selection == null || selection.size() == 0) {
                    menu.removeItem(R.id.mnu_actions_send_selection);
                } else {
                    boolean areAllFiles = true;
                    int cc = selection.size();
                    for (int i = 0; i < cc; i++) {
                        FileSystemObject fso = selection.get(i);
                        if (FileHelper.isDirectory(fso)) {
                            areAllFiles = false;
                            break;
                        }
                    }
                    if (!areAllFiles ||
                            !IntentsActionPolicy.sendHandledByAnyActivity(mContext, selection)) {
                        menu.removeItem(R.id.mnu_actions_send_selection);
                    }
                }
            }
        }

        // Shotcuts and Bookmarks (not available in virtual filesystems)
        if (!mGlobal && (mFso.isSecure() || mFso.isRemote())) {
            menu.removeItem(R.id.mnu_actions_add_shortcut);
            menu.removeItem(R.id.mnu_actions_add_to_bookmarks);
        } else if (mGlobal) {
            // Remove shortcuts for secure folders
            if (mFso != null && mFso.isSecure()) {
                menu.removeItem(R.id.mnu_actions_add_shortcut_current_folder);
            }
            if (selection != null && selection.size() > 0) {
                for (FileSystemObject fso : selection) {
                    if (fso.isSecure() || fso.isRemote()) {
                        menu.removeItem(R.id.mnu_actions_add_shortcut_current_folder);
                        menu.removeItem(R.id.mnu_actions_add_to_bookmarks_current_folder);
                        break;
                    }
                }
            }
        }

        // Set as home
        if (!mGlobal && !FileHelper.isDirectory(mFso)) {
            menu.removeItem(R.id.mnu_actions_set_as_home);
        } else if (mGlobal && (selection != null && selection.size() > 0)) {
            menu.removeItem(R.id.mnu_actions_global_set_as_home);
        } else if (!mGlobal && (mFso.isSecure() || mFso.isRemote())) {
            menu.removeItem(R.id.mnu_actions_set_as_home);
        } else if (mGlobal && (mFso.isSecure() || mFso.isRemote())) {
            menu.removeItem(R.id.mnu_actions_global_set_as_home);
        }

        // Not allowed in search
        if (this.mSearch) {
            menu.removeItem(R.id.mnu_actions_extract);
            menu.removeItem(R.id.mnu_actions_compress);
            menu.removeItem(R.id.mnu_actions_create_link);
        } else {
            // Not allowed if not in search
            menu.removeItem(R.id.mnu_actions_open_parent_folder);
        }

        // Remove unsafe operations over virtual mountpoint directories
        List<Directory> virtualDirs = VirtualMountPointConsole.getVirtualMountableDirectories();
        if (!mGlobal && FileHelper.isDirectory(mFso) && virtualDirs.contains(mFso)) {
            menu.removeItem(R.id.mnu_actions_delete);
            menu.removeItem(R.id.mnu_actions_rename);
            menu.removeItem(R.id.mnu_actions_compress);
            menu.removeItem(R.id.mnu_actions_create_copy);
            menu.removeItem(R.id.mnu_actions_create_link);
            menu.removeItem(R.id.mnu_actions_add_shortcut);
            menu.removeItem(R.id.mnu_actions_add_to_bookmarks);
        } else if (mGlobal) {
            if (selection != null && selection.size() > 0) {
                for (FileSystemObject fso : selection) {
                    if (FileHelper.isDirectory(fso) && virtualDirs.contains(fso)) {
                        menu.removeItem(R.id.mnu_actions_paste_selection);
                        menu.removeItem(R.id.mnu_actions_move_selection);
                        menu.removeItem(R.id.mnu_actions_delete_selection);
                        menu.removeItem(R.id.mnu_actions_compress_selection);
                        menu.removeItem(R.id.mnu_actions_create_link_global);
                        menu.removeItem(R.id.mnu_actions_send_selection);
                        menu.removeItem(R.id.mnu_actions_create_link_global);
                        menu.removeItem(R.id.mnu_actions_create_link_global);
                        menu.removeItem(R.id.mnu_actions_create_link_global);
                        menu.removeItem(R.id.mnu_actions_add_shortcut_current_folder);
                        menu.removeItem(R.id.mnu_actions_add_to_bookmarks_current_folder);
                        break;
                    }
                }
            }
        }

        // Remove not-ChRooted actions (actions that can't be present when running in
        // unprivileged mode)
        if (this.mChRooted) {
            menu.removeItem(R.id.mnu_actions_create_link);
            menu.removeItem(R.id.mnu_actions_create_link_global);
            menu.removeItem(R.id.mnu_actions_execute);

            // NOTE: This actions are not implemented in chrooted environments. The reason is
            // that the main target of this application is CyanogenMod (a rooted environment).
            // Adding this actions requires the use of commons-compress, an external Apache
            // library that will add more size to the ending apk.
            // For now, will maintain without implementation. Maybe, in the future.
            menu.removeItem(R.id.mnu_actions_compress);
            menu.removeItem(R.id.mnu_actions_compress_selection);
            menu.removeItem(R.id.mnu_actions_extract);
        }
    }

