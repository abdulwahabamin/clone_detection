    private void showDiskSizeDetails() {

        double totalspace= Device.getSdSize();

        if(totalspace!=0) {
            int pctleft = Double.valueOf(100-((100/totalspace)*Device.getSdAvailable())).intValue();
            RelativeLayout rel = (RelativeLayout) mDrawerView.findViewById(R.id.nav_show_disk_stats);

            ProgressBar progressBar = (ProgressBar) rel.findViewById(R.id.nav_show_disk_progress);
            progressBar.setProgress(pctleft);

            TextView pct = (TextView) rel.findViewById(R.id.nav_show_disk_stats_total);
            pct.setText(pctleft+" %");
        }

    }

