    /**
     * Method takes a bookmark as argument and adds it to the bookmark list in
     * the drawer
     */
    private void addBookmarkToDrawer(Bookmark bookmark) {
        Theme theme = ThemeManager.getCurrentTheme(this);
        IconHolder iconholder = new IconHolder(this, false);

        // inflate single bookmark layout item and fill it
        LinearLayout view = (LinearLayout) getLayoutInflater().inflate(
                R.layout.bookmarks_item, null);

        ImageView icon = (ImageView) view
                .findViewById(R.id.bookmarks_item_icon);
        TextView name = (TextView) view.findViewById(R.id.bookmarks_item_name);
        TextView path = (TextView) view.findViewById(R.id.bookmarks_item_path);
        ImageButton actionButton = (ImageButton) view
                .findViewById(R.id.bookmarks_item_action);

        name.setText(bookmark.mName);
        path.setText(bookmark.mPath);

        theme.setTextColor(this, name, "text_color");
        theme.setTextColor(this, path, "text_color");

        icon.setImageDrawable(iconholder.getDrawable(BookmarksHelper
                .getIcon(bookmark)));

        Drawable action = null;
        String actionCd = null;
        if (bookmark.mType.compareTo(BOOKMARK_TYPE.HOME) == 0) {
            action = iconholder.getDrawable("ic_edit_home_bookmark_drawable"); //$NON-NLS-1$
            actionCd = getApplicationContext().getString(
                    R.string.bookmarks_button_config_cd);
        }
        else if (bookmark.mType.compareTo(BOOKMARK_TYPE.USER_DEFINED) == 0) {
            action = iconholder.getDrawable("ic_close_drawable"); //$NON-NLS-1$
            actionCd = getApplicationContext().getString(
                    R.string.bookmarks_button_remove_bookmark_cd);
        }

        actionButton.setImageDrawable(action);
        actionButton.setVisibility(action != null ? View.VISIBLE : View.GONE);
        actionButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                final View v = (View) view.getParent();
                final int index = mDrawerBookmarks.indexOfChild(v);
                final Bookmark bookmark = mBookmarks.get(index);

                // Configure home
                if (bookmark.mType.compareTo(BOOKMARK_TYPE.HOME) == 0) {
                    // Show a dialog for configure initial directory
                    InitialDirectoryDialog dialog = new InitialDirectoryDialog(
                            NavigationActivity.this);
                    dialog.setOnValueChangedListener(new InitialDirectoryDialog.OnValueChangedListener() {
                        @Override
                        public void onValueChanged(String newInitialDir) {
                            bookmark.mPath = newInitialDir;

                            // reset drawer bookmarks list
                            initBookmarks();
                        }
                    });
                    dialog.show();
                    return;
                }

                // Remove bookmark
                if (bookmark.mType.compareTo(BOOKMARK_TYPE.USER_DEFINED) == 0) {
                    boolean result = Bookmarks.removeBookmark(
                            getApplicationContext(), bookmark);
                    if (!result) { // Show warning
                        DialogHelper.showToast(getApplicationContext(),
                                R.string.msgs_operation_failure,
                                Toast.LENGTH_SHORT);
                        return;
                    }
                    mBookmarks.remove(bookmark);
                    mDrawerBookmarks.removeView(v);
                    return;
                }
            }
        });
        actionButton.setContentDescription(actionCd);

        // handle item click
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final int index = mDrawerBookmarks.indexOfChild(v);
                final Bookmark bookmark = mBookmarks.get(index);

                boolean showEasyMode = (mSdBookmarks.contains(bookmark)) &&
                        getResources().getBoolean(R.bool.cmcc_show_easy_mode);

                // try to navigate to the bookmark path
                try {
                    FileSystemObject fso = CommandHelper.getFileInfo(
                            getApplicationContext(), bookmark.mPath, null);
                    if (fso != null) {
                        if (showEasyMode) {
                            performShowEasyMode();
                        } else {
                            performHideEasyMode();
                        }
                        performShowBackArrow(!mDrawerToggle.isDrawerIndicatorEnabled());
                        getCurrentNavigationView().open(fso);
                        mDrawerLayout.closeDrawer(Gravity.START);
                    }
                    else {
                        // The bookmark does not exist, delete the user-defined
                        // bookmark
                        try {
                            Bookmarks.removeBookmark(getApplicationContext(),
                                    bookmark);

                            // reset bookmarks list to default
                            initBookmarks();
                        }
                        catch (Exception ex) {
                        }
                    }
                }
                catch (Exception e) { // Capture the exception
                    ExceptionUtil
                            .translateException(NavigationActivity.this, e);
                    if (e instanceof NoSuchFileOrDirectory
                            || e instanceof FileNotFoundException) {
                        // The bookmark does not exist, delete the user-defined
                        // bookmark
                        try {
                            Bookmarks.removeBookmark(getApplicationContext(),
                                    bookmark);

                            // reset bookmarks list to default
                            initBookmarks();
                        }
                        catch (Exception ex) {
                        }
                    }
                    return;
                }
            }
        });

        mDrawerBookmarks.addView(view);
    }

