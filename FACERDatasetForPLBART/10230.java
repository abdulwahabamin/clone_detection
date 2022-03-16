    /**
     * Method that initializes the view. This method loads all the necessary
     * information and create an appropriate layout for the view
     */
    private void init() {
        //Initialize data
        this.mData = new ArrayList<String>();
        this.mOnTextChangedListener = null;
        this.mTextWatcher = new FilteredTextWatcher();

        //Inflate the view
        ViewGroup v = (ViewGroup)inflate(getContext(), R.layout.inline_autocomplete, null);
        addView(v);

        //Retrieve views
        this.mBackgroundText = (EditText)findViewById(R.id.inline_autocomplete_bg_text);
        this.mBackgroundText.setOnKeyListener(this);
        this.mForegroundText = (EditText)findViewById(R.id.inline_autocomplete_fg_text);
        this.mForegroundText.setMovementMethod(new ScrollingMovementMethod());
        this.mForegroundText.addTextChangedListener(this.mTextWatcher);
        this.mForegroundText.setOnKeyListener(this);
        this.mForegroundText.requestFocus();
        this.mForegroundText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                doDone(true);
                return false;
            }
        });

        View button = findViewById(R.id.inline_autocomplete_button_tab);
        button.setOnClickListener(this);
        button.setOnLongClickListener(this);

        // Apply the theme
        applyTheme();

        //Initialize text views
        setText(""); //$NON-NLS-1$
    }

