    @Override
    public boolean onPrepareOptionsMenu(Menu m) {
        if (clipboard.isEmpty()) {
            pasteOption.setVisible(false);
        }
        else
        {
            pasteOption.setVisible(true);
        }
        showHiddenOption.setChecked(settings.showHidden);
        return true;
    }

