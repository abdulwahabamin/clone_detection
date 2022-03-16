    /**
     * Method that creates the colors panel (current and new)
     *
     * @param parent The parent layout
     * @param belowOf The anchor view
     * @return id The layout id
     */
    private int createColorsPanel(ViewGroup parent, int belowOf) {
        final int dlgMarging = (int)convertDpToPixel(DEFAULT_MARGIN_DP);
        final int panelHeight = (int)convertDpToPixel(DEFAULT_PANEL_HEIGHT_DP);
        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                1);

        // Titles
        this.tvCurrent = new TextView(getContext());
        lp2 = new LinearLayout.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
                1);
        this.tvCurrent.setLayoutParams(lp2);
        this.tvCurrent.setText(this.mCurrentLabelText);
        this.tvCurrent.setTextSize(TypedValue.COMPLEX_UNIT_SP, DEFAULT_TEXT_SIZE_SP);
        this.tvNew = new TextView(getContext());
        this.tvNew.setLayoutParams(lp2);
        this.tvNew.setText(this.mNewLabelText);
        this.tvNew.setTextSize(TypedValue.COMPLEX_UNIT_SP, DEFAULT_TEXT_SIZE_SP);
        TextView sep1 = new TextView(getContext());
        lp2 = new LinearLayout.LayoutParams(
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
                0);
        lp2.setMargins(dlgMarging, 0, dlgMarging, 0);
        sep1.setLayoutParams(lp2);
        sep1.setText(" "); //$NON-NLS-1$
        sep1.setTextSize(TypedValue.COMPLEX_UNIT_SP, DEFAULT_TEXT_SIZE_SP);

        LinearLayout ll1 = new LinearLayout(getContext());
        ll1.setId(generateViewId());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(dlgMarging, 0, dlgMarging, dlgMarging/2);
        lp.addRule(RelativeLayout.BELOW, belowOf);
        ll1.setLayoutParams(lp);
        ll1.addView(this.tvCurrent);
        ll1.addView(sep1);
        ll1.addView(this.tvNew);
        parent.addView(ll1);

        // Color panels
        lp2 = new LinearLayout.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
                1);
        this.mCurrentColorView = new ColorPanelView(getContext());
        this.mCurrentColorView.setLayoutParams(lp2);
        this.mNewColorView = new ColorPanelView(getContext());
        this.mNewColorView.setLayoutParams(lp2);
        TextView sep2 = new TextView(getContext());
        lp2 = new LinearLayout.LayoutParams(
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
                0);
        lp2.setMargins(dlgMarging, 0, dlgMarging, 0);
        sep2.setLayoutParams(lp2);
        sep2.setText("-"); //$NON-NLS-1$
        sep2.setTextSize(TypedValue.COMPLEX_UNIT_SP, DEFAULT_TEXT_SIZE_SP);

        LinearLayout ll2 = new LinearLayout(getContext());
        ll2.setId(generateViewId());
        lp = new RelativeLayout.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT, panelHeight);
        lp.setMargins(dlgMarging, 0, dlgMarging, dlgMarging/2);
        lp.addRule(RelativeLayout.BELOW, ll1.getId());
        ll2.setLayoutParams(lp);
        ll2.addView(this.mCurrentColorView);
        ll2.addView(sep2);
        ll2.addView(this.mNewColorView);
        parent.addView(ll2);

        return ll2.getId();
    }

