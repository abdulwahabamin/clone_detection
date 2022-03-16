    /**
     * Method that initializes the navigation views of the activity
     */
    private void initNavigationViews() {
        //Get the navigation views (wishlist: multiple view; for now only one view)
        this.mNavigationViews = new NavigationView[1];
        this.mCurrentNavigationView = 0;
        //- 0
        this.mNavigationViews[0] = (NavigationView)findViewById(R.id.navigation_view);
        this.mNavigationViews[0].setId(0);
        this.mEasyModeListView = (ListView) findViewById(R.id.lv_easy_mode);
        mEasyModeAdapter = new ArrayAdapter<MimeTypeCategory>(this, R.layout
                .navigation_view_simple_item) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                convertView = (convertView == null) ?getLayoutInflater().inflate(R.layout
                        .navigation_view_simple_item, parent, false) : convertView;
                MimeTypeCategory item = getItem(position);
                String typeTitle = MIME_TYPE_LOCALIZED_NAMES[item.ordinal()];
                TextView typeTitleTV = (TextView) convertView
                        .findViewById(R.id.navigation_view_item_name);
                ImageView typeIconIV = (ImageView) convertView
                        .findViewById(R.id.navigation_view_item_icon);
                View checkBoxView = convertView.findViewById(R.id.navigation_view_item_check);
                checkBoxView.setVisibility(View.GONE);
                typeTitleTV.setText(typeTitle);
                typeIconIV.setImageDrawable(EASY_MODE_ICONS.get(item));
                convertView.setOnClickListener(mEasyModeItemClickListener);
                convertView.setTag(position);
                return convertView;
            }
        };
        mEasyModeAdapter.addAll(EASY_MODE_LIST);
        mEasyModeListView.setAdapter(mEasyModeAdapter);
    }

