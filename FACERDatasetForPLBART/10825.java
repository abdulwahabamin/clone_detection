    /**
     * Method that initializes the view. This method loads all the necessary
     * information and create an appropriate layout for the view
     */
    private void init() {
        // To fight color branding.
        ((Activity)getContext()).getWindow().setFormat(PixelFormat.RGBA_8888);

        // Create the scrollview over the dialog
        final int dlgMarging = (int)convertDpToPixel(DEFAULT_MARGIN_DP);
        ScrollView sv = new ScrollView(getContext());
        sv.setId(generateViewId());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(dlgMarging, 0, dlgMarging, 0);
        sv.setLayoutParams(lp);
        sv.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_INSET);

        // Now the vertical layout
        LinearLayout ll = new LinearLayout(getContext());
        ll.setId(generateViewId());
        lp = new RelativeLayout.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                android.view.ViewGroup.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);

        // Creates the color input field
        int id = createColorInput(ll);

        // Creates the color picker
        id = createColorPicker(ll, id);

        // Creates the current color and new color panels
        id = createColorsPanel(ll, id);

        // Add the scrollview
        addView(sv);

        // Sets the input color
        this.etColor.setText(toHex(this.mNewColorView.getColor()));
    }

