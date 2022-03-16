    @Override
    public void onBackPressed() {
        ActionBarManager.setStopOptions(true);
        //Log.e("BACK PRESS", "item: " + State.getSectionsSize() + " -- " + (State.getCurrentSection() != State.SECTION_FILE_EXPLORE));
        if(State.getSectionsSize()<2) {
            //if(State.getCurrentSection()!=State.SECTION_FILE_EXPLORE)
            //    Bgo.openFragment(this, new FileExploreFragment());
            //else {
            if(Cal.getUnixTime()-closebackpressed<700) {

                Bgo.clearBackStack(this);

                State.clearStateAllObjects();
                if(closehandler!=null)
                    closehandler.removeCallbacks(closerun);
                //BLog.e("EXIT", "APP");
                //this.get
                super.onBackPressed();
            } else{
                closebackpressed=Cal.getUnixTime();
                closehandler=new Handler();
                closehandler.postDelayed(closerun, 750);

            }
            //}
        } else {
            Bgo.goPreviousFragment(this);
        }

    }

