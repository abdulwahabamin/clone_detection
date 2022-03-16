    private void checkSdCard() {
        View v = activity.findViewById(R.id.main_no_sd_card);
        v.setVisibility(View.GONE);
        //v.setX(2000F);
        v.findViewById(R.id.main_no_sd_card_text).setVisibility(View.GONE);
        //if(v!=null) {
        if(Device.isMediaMounted()) {

            //BriefMenu.showActionBar();
        } else {
            //BLog.e("SDCARD IS DIABLED !!!!!!!!!!!!!");
            v.setVisibility(View.VISIBLE);
            //BriefMenu.hideActionBar();
            v.bringToFront();
            v.findViewById(R.id.main_no_sd_card_text).setVisibility(View.VISIBLE);
        }

        //}
        if(checkMediaMountedHandler==null)
            checkMediaMountedHandler=new Handler();
        checkMediaMountedHandler.removeCallbacks(runSdCard);
        checkMediaMountedHandler.postDelayed(runSdCard,3000);
    }

