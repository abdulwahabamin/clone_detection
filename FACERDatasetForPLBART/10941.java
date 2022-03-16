    /**
     * Method that shows a popup with the activity main menu.
     *
     * @param anchor The anchor of the popup
     */
    private void showOverflowPopUp(View anchor) {
        SimpleMenuListAdapter adapter =
                new HighlightedSimpleMenuListAdapter(this, R.menu.editor, true);
        MenuItem noSuggestions = adapter.getMenu().findItem(R.id.mnu_no_suggestions);
        if (noSuggestions != null) {
            if (this.mBinary) {
                adapter.getMenu().removeItem(R.id.mnu_no_suggestions);
            } else {
                noSuggestions.setChecked(this.mNoSuggestions);
            }
        }
        MenuItem wordWrap = adapter.getMenu().findItem(R.id.mnu_word_wrap);
        if (wordWrap != null) {
            if (this.mBinary) {
                adapter.getMenu().removeItem(R.id.mnu_word_wrap);
            } else {
                wordWrap.setChecked(this.mWordWrap);
            }
        }
        MenuItem syntaxHighlight = adapter.getMenu().findItem(R.id.mnu_syntax_highlight);
        if (syntaxHighlight != null) {
            if (this.mBinary) {
                adapter.getMenu().removeItem(R.id.mnu_syntax_highlight);
            } else {
                syntaxHighlight.setChecked(this.mSyntaxHighlight);
            }
        }

        final ListPopupWindow popup =
                DialogHelper.createListPopupWindow(this, adapter, anchor);
        popup.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(
                    final AdapterView<?> parent, final View v,
                    final int position, final long id) {
                final int itemId = (int)id;
                switch (itemId) {
                    case R.id.mnu_no_suggestions:
                        toggleNoSuggestions();
                        break;
                    case R.id.mnu_word_wrap:
                        DialogHelper.showToast(EditorActivity.this,
                                R.string.toggle_word_wrap_msg, Toast.LENGTH_SHORT);
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                toggleWordWrap();
                            }
                        }, 50);
                        break;
                    case R.id.mnu_syntax_highlight:
                        toggleSyntaxHighlight();
                        break;
                    case R.id.mnu_settings:
                        //Settings
                        Intent settings = new Intent(EditorActivity.this, SettingsPreferences.class);
                        settings.putExtra(
                                PreferenceActivity.EXTRA_SHOW_FRAGMENT,
                                EditorPreferenceFragment.class.getName());
                        startActivity(settings);
                        break;
                }
                popup.dismiss();
            }
        });
        popup.show();
    }

