    /**
     * Method invoked when a tab key event is requested (button or keyboard)
     * @hide
     */
    void doTab() {
        //Complete with current text
        String current = this.mForegroundText.getText().toString();
        if (current.length() == 0) {
            return;
        }

        //Get the data
        List<String> filteredData = filter(this.mData, current);
        if (filteredData.size() <= this.mFilter) {
            this.mFilter = 0;
        }
        if (filteredData.size() == 1 && this.mFilter == 0) {
            //Autocomplete with the only autocomplete option
            setText(filteredData.get(this.mFilter));
        } else {
            //Show the autocomplete options
            if (filteredData.size() > 0) {
                this.mBackgroundText.setText(filteredData.get(this.mFilter));
                this.mBackgroundText.setVisibility(View.VISIBLE);
                this.mFilter++;
            }
        }
    }

