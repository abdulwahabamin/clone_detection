    /**
     * Method that creates a new path divider.
     *
     * @return View The path divider
     */
    private View createItemDivider() {
        LayoutInflater inflater =
                (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(R.layout.breadcrumb_item_divider, this.mBreadcrumbBar, false);
    }

