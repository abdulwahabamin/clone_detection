    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed:called");
        boolean furtherFlag = false;

        if (searchViewParentLl.getVisibility()==View.VISIBLE) {
            searchViewParentLl.setVisibility(View.GONE);
        } else if (musicPlayerSupl != null) {
            if (musicPlayerSupl.getPanelState() == SlidingUpPanelLayout.PanelState.EXPANDED) {
                musicPlayerSupl.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            } else {
                furtherFlag = true;
            }
        } else {
            furtherFlag = true;
        }

        if (furtherFlag) {
            if (slidingUpPanelLayout.getPanelState() == SlidingUpPanelLayout.PanelState.EXPANDED) {
                slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            } else {
                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    getSupportFragmentManager().popBackStack();
                } else {
                    super.onBackPressed();
                }
            }
        }
    }

