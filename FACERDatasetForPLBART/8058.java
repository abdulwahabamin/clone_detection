    /**
     * Method that creates the color picker
     *
     * @param parent The parent layout
     * @param belowOf The anchor view
     * @return id The layout id
     */
    private int createColorPicker(ViewGroup parent, int belowOf) {
        final int dlgMarging = (int)convertDpToPixel(DEFAULT_MARGIN_DP);
        this.mPickerView = new ColorPickerView(getContext());
        this.mPickerView.setId(generateViewId());
        this.mPickerView.setOnColorChangedListener(this);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(dlgMarging, 0, dlgMarging, 0);
        lp.addRule(RelativeLayout.BELOW, belowOf);
        this.mPickerView.setLayoutParams(lp);
        parent.addView(this.mPickerView);
        return this.mPickerView.getId();
    }

