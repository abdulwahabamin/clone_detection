    /**
     * Method that initializes the view. This method loads all the necessary
     * information and create an appropriate layout for the view
     */
    private void init() {
        //Initialize the listeners
        this.mBreadcrumbListeners =
              Collections.synchronizedList(new ArrayList<BreadcrumbListener>());

        //Add the view of the breadcrumb
        addView(inflate(getContext(), R.layout.breadcrumb_view, null));

        //Recovery all views
        this.mScrollView = (HorizontalScrollView)findViewById(R.id.breadcrumb_scrollview);
        this.mBreadcrumbBar = (ViewGroup)findViewById(R.id.breadcrumb);
        this.mFilesystemInfo = (ImageView)findViewById(R.id.ab_filesystem_info);
        this.mDiskUsageInfo = (ProgressBar)findViewById(R.id.breadcrumb_diskusage);
        this.mLoadingDialog = new ProgressDialog(getContext());
        this.mLoadingDialog.setMessage(getContext().getText(R.string.loading_message));
        this.mLoadingDialog.setCancelable(false);

        // Change the image of filesystem (this is not called after a changeBreadcrumbPath call,
        // so if need to be theme previously to protect from errors)
        Theme theme = ThemeManager.getCurrentTheme(getContext());
        theme.setImageDrawable(
                getContext(), this.mFilesystemInfo, "filesystem_warning_drawable"); //$NON-NLS-1$
    }

