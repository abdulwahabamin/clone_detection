    public void initViews() {

        iconDownAnimator = generateAnimator(expandIcon, 0, 180);
        iconUpAnimator = generateAnimator(expandIcon, 180, 0);

        expandableLayout.setOnExpandListener(new ExpandableLayout.OnExpandListener() {
            @Override
            public void onExpand(boolean expanded) {
                isExpanded = expanded;
            }
        });

        aqiView.setColorLever(COlORS_ID, AQI_LEVELS);
        pm2_5View.setColorLever(COlORS_ID, PM2_5_LEVELS);
        pm10View.setColorLever(COlORS_ID, PM10_LEVELS);

    }

