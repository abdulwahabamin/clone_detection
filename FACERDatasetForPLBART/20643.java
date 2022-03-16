    /**
     * Initializing the QuickScroll, this function must be called.
     * <p/>
     *
     * @param type       the QuickScroll type. Available inputs: <b>QuickScroll.TYPE_POPUP</b> or <b>QuickScroll.TYPE_INDICATOR</b>
     * @param list       the GridView
     * @param scrollable the adapter, must implement Scrollable interface
     */
    public void init(final int type, final GridView grid, final Scrollable scrollable, final int style) {
        if (isInitialized) return;

        this.type = type;
        gridView = grid;
        this.scrollable = scrollable;
        groupPosition = -1;
        fadeInAnimation = new AlphaAnimation(.0f, 1.0f);
        fadeInAnimation.setFillAfter(true);
        fadeOutAnimation = new AlphaAnimation(1.0f, .0f);
        fadeOutAnimation.setFillAfter(true);
        fadeOutAnimation.setAnimationListener(new AnimationListener() {

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                isScrolling = false;
            }
        });
        isScrolling = false;

        gridView.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (isScrolling && (event.getAction() == MotionEvent.ACTION_MOVE || event.getAction() == MotionEvent.ACTION_DOWN)) {
                    return true;
                }
                return false;
            }
        });

        final RelativeLayout.LayoutParams containerParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        final RelativeLayout container = new RelativeLayout(getContext());
        container.setBackgroundColor(Color.TRANSPARENT);
        containerParams.addRule(RelativeLayout.ALIGN_TOP, getId());
        containerParams.addRule(RelativeLayout.ALIGN_BOTTOM, getId());
        container.setLayoutParams(containerParams);

        if (this.type == TYPE_POPUP || this.type == TYPE_POPUP_WITH_HANDLE) {
            scrollIndicatorTextView = new TextView(getContext());
            scrollIndicatorTextView.setTextColor(Color.WHITE);
            scrollIndicatorTextView.setVisibility(View.INVISIBLE);
            scrollIndicatorTextView.setGravity(Gravity.CENTER);
            final RelativeLayout.LayoutParams popupParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            popupParams.addRule(RelativeLayout.CENTER_IN_PARENT);
            scrollIndicatorTextView.setLayoutParams(popupParams);
            setPopupColor(GREY_LIGHT, GREY_DARK, 1, Color.WHITE, 1);
            setTextPadding(TEXT_PADDING, TEXT_PADDING, TEXT_PADDING, TEXT_PADDING);
            container.addView(scrollIndicatorTextView);
        } else {
            scrollIndicator = createPin();
            scrollIndicatorTextView = (TextView) scrollIndicator.findViewById(ID_PIN_TEXT);
            (scrollIndicator.findViewById(ID_PIN)).getLayoutParams().width = 25;
            container.addView(scrollIndicator);
        }

        // setting scrollbar width
        final float density = getResources().getDisplayMetrics().density;
        getLayoutParams().width = (int) (10 * density);
        scrollIndicatorTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 32);

        // scrollbar setup
        if (style != STYLE_NONE) {
            final RelativeLayout layout = new RelativeLayout(getContext());
            final RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            params.addRule(RelativeLayout.ALIGN_LEFT, getId());
            params.addRule(RelativeLayout.ALIGN_TOP, getId());
            params.addRule(RelativeLayout.ALIGN_RIGHT, getId());
            params.addRule(RelativeLayout.ALIGN_BOTTOM, getId());
            layout.setLayoutParams(params);

            final View scrollbar = new View(getContext());
            scrollbar.setBackgroundColor(GREY_SCROLLBAR);
            final RelativeLayout.LayoutParams scrollBarParams = new RelativeLayout.LayoutParams(1, LayoutParams.MATCH_PARENT);
            scrollBarParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
            scrollBarParams.topMargin = SCROLLBAR_MARGIN;
            scrollBarParams.bottomMargin = SCROLLBAR_MARGIN;
            scrollbar.setLayoutParams(scrollBarParams);
            layout.addView(scrollbar);
            ViewGroup.class.cast(gridView.getParent()).addView(layout);
            // creating the handlebar
            if (this.type == TYPE_INDICATOR_WITH_HANDLE || this.type == TYPE_POPUP_WITH_HANDLE) {
                handleBar = new View(getContext());
                setHandlebarColor(BLUE_LIGHT, BLUE_LIGHT, BLUE_LIGHT_SEMITRANSPARENT);
                final RelativeLayout.LayoutParams handleParams = new RelativeLayout.LayoutParams((int) (12 * density), (int) (36 * density));
                handleBar.setLayoutParams(handleParams);
                ((RelativeLayout.LayoutParams) handleBar.getLayoutParams()).addRule(RelativeLayout.CENTER_HORIZONTAL);
                layout.addView(handleBar);

                gridView.setOnScrollListener(new OnScrollListener() {

                    public void onScrollStateChanged(AbsListView view, int scrollState) {
                        if (onScrollListener!=null)
                            onScrollListener.onScrollStateChanged(view, scrollState);
                    }

                    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                        if (onScrollListener!=null)
                            onScrollListener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);

                        if (!isScrolling && totalItemCount - visibleItemCount > 0) {
                            moveHandlebar(getHeight() * firstVisibleItem / (totalItemCount - visibleItemCount));
                        }
                    }
                });
            }
        }

        isInitialized = true;

        ViewGroup.class.cast(gridView.getParent()).addView(container);
    }

