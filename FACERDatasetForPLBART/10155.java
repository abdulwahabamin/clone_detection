    /**
     * Method that creates a new split path.
     *
     * @param dir The path
     * @return BreadcrumbItem The view create
     */
    private BreadcrumbItem createBreadcrumbItem(File dir) {
        LayoutInflater inflater =
                (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        BreadcrumbItem item =
                (BreadcrumbItem)inflater.inflate(
                        R.layout.breadcrumb_item, this.mBreadcrumbBar, false);
        item.setText(dir.getName().length() != 0 ? dir.getName() : dir.getPath());
        item.setItemPath(dir.getPath());
        item.setOnClickListener(this);
        return item;
    }

