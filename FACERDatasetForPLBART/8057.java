    /**
     * Method that creates the color input
     *
     * @param parent The parent layout
     */
    private int createColorInput(ViewGroup parent) {
        final int dlgMarging = (int)convertDpToPixel(DEFAULT_MARGIN_DP);
        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
                android.view.ViewGroup.LayoutParams.MATCH_PARENT);
        lp2.setMargins(0, 0, dlgMarging, 0);
        this.tvColorLabel = new TextView(getContext());
        this.tvColorLabel.setText(this.mColorLabelText);
        this.tvColorLabel.setTextSize(TypedValue.COMPLEX_UNIT_SP, DEFAULT_LABEL_TEXT_SIZE_SP);
        this.tvColorLabel.setGravity(Gravity.BOTTOM | Gravity.LEFT);
        this.tvColorLabel.setLayoutParams(lp2);

        lp2 = new LinearLayout.LayoutParams(
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
        this.etColor = new EditText(getContext());
        this.etColor.setSingleLine();
        this.etColor.setGravity(Gravity.TOP | Gravity.LEFT);
        this.etColor.setCursorVisible(true);
        this.etColor.setImeOptions(
                EditorInfo.IME_ACTION_DONE | EditorInfo.IME_FLAG_NO_FULLSCREEN);
        this.etColor.setInputType(
                InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        this.etColor.setLayoutParams(lp2);
        InputFilter[] filters = new InputFilter[2];
        filters[0] = new InputFilter.LengthFilter(8);
        filters[1] = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start,
                    int end, Spanned dest, int dstart, int dend) {
                if (start >= end) return ""; //$NON-NLS-1$
                String s = source.subSequence(start, end).toString();
                StringBuilder sb = new StringBuilder();
                int cc = s.length();
                for (int i = 0; i < cc; i++) {
                    char c = s.charAt(i);
                    if ((c >= '0' && c <= '9') ||
                        (c >= 'a' && c <= 'f') ||
                        (c >= 'A' && c <= 'F')) {
                        sb.append(c);
                    }
                }
                return sb.toString().toUpperCase();
            }
        };
        this.etColor.setFilters(filters);
        this.etColor.addTextChangedListener(this);

        LinearLayout ll1 = new LinearLayout(getContext());
        ll1.setId(generateViewId());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(dlgMarging, 0, dlgMarging, 0);
        lp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        ll1.setLayoutParams(lp);
        ll1.addView(this.tvColorLabel);
        ll1.addView(this.etColor);
        parent.addView(ll1);

        return ll1.getId();
    }

