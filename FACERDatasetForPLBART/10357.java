    /**
     * Method that initializes the view. This method loads all the necessary
     * information and create an appropriate layout for the view
     */
    private void init() {
        //Add the view of the breadcrumb
        View content = inflate(getContext(), R.layout.navigation_view_selectionbar, null);
        content.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        // Obtain the height of the view for use in expand/collapse animation
        getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        SelectionView.this.mViewHeight = getHeight();
                        getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        setVisibility(View.GONE);
                        LayoutParams params = (LayoutParams)SelectionView.this.getLayoutParams();
                        params.height = 0;
                    }
            });

        //Recovery all views
        this.mStatus = (TextView)content.findViewById(R.id.navigation_status_selection_label);

        // Obtain the duration of the effect
        this.mEffectDuration =
                getContext().getResources().getInteger(android.R.integer.config_shortAnimTime);

        addView(content);
    }

