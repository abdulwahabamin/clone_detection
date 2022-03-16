	private boolean checkSelection() {
        for (IconifiedText it : mDirectoryEntries) {
            if (!it.isSelected()) {
                continue;
            }

            return true;
        }

        Toast.makeText(this, R.string.error_selection, Toast.LENGTH_SHORT).show();

        return false;
   }

