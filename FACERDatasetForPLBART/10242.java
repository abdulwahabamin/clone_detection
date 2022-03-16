    /**
     * Method that autocompletes the text, showing the best matches.
     */
    private void autocomplete() {
        final String currentText = getText();
        if (!this.mData.isEmpty()) {
            Iterator<String> it = this.mData.iterator();
            while (it.hasNext()) {
                String filterData = it.next();
                if (filterData.startsWith(currentText)) {
                    this.mBackgroundText.setText(filterData);
                    this.mBackgroundText.setVisibility(View.VISIBLE);
                    int lines = this.mBackgroundText.getLineCount();
                    this.mForegroundText.setLines(lines <= 0 ? 1 : lines);
                    return;
                }
            }
        }
        this.mBackgroundText.setVisibility(View.INVISIBLE);
    }

