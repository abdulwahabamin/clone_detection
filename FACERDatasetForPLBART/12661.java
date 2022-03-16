    private void populateLegend() {
        if (mLegendLayout == null) {
            Log.w(TAG, "Unable to find view for legend");
            return;
        }
        mLegendLayout.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        int index = 0;
        if (mDiskUsage == null) {
            Log.w(TAG, "No disk usage information");
            return;
        }
        for (DiskUsageCategory category : mDiskUsage.getUsageCategoryList()) {
            View ll = inflater.inflate(R.layout.disk_usage_category_view, null, false);
            View colorView = ll.findViewById(R.id.v_legend_swatch);
            index = (index < DiskUsageGraph.COLOR_LIST.size()) ? index : 0; // normalize index
            colorView.setBackgroundColor(DiskUsageGraph.COLOR_LIST.get(index));
            TextView titleView = (TextView) ll.findViewById(R.id.tv_legend_title);
            String localizedName = MimeTypeCategory.getFriendlyLocalizedNames(mContext)[category
                    .getCategory().ordinal()];
            titleView.setText(localizedName);
            mLegendLayout.addView(ll);
            index++;
        }
    }

