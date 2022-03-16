    /**
     * This is called when scrollview is touched. It contains different kinds of
     * logic dealing with pull to refresh.
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        setIsAbleToPull(event);
        if(ableToPull){
            switch(event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    yDown=event.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    float yMove=event.getRawY();
                    int distance=(int)(yMove-yDown);
                    //if the view is scrolling down and the pull header is hidden,
                    //block the pull down event.
                    if(distance<=0&&headerLayoutParams.topMargin<=hideHeaderHeight)
                    {
                        return false;
                    }
                    if(distance<=touchSlop){
                        return false;
                    }
                    if(currentStatus!=STATUS_REFRESHING){
                        if(headerLayoutParams.topMargin>0){
                            currentStatus=STATUS_RELEASE_TO_REFRESH;
                        }
                        else{
                            currentStatus=STATUS_PULL_TO_REFRESH;
                        }
                        //offset the topMargin of the pull-header to
                        //realize the effect of pulling
                        headerLayoutParams.topMargin=(distance/2)+hideHeaderHeight;
                        header.setLayoutParams(headerLayoutParams);
                    }
                    break;
                case MotionEvent.ACTION_UP:
                default:
                    if(currentStatus==STATUS_RELEASE_TO_REFRESH){
                        //if the status is STATUS_RELEASE_TO_REFRESH when release finger,
                        //invoke the RefreshingTask().execute() method to refresh.
                        new RefreshingTask().execute();
                    }
                    else if(currentStatus==STATUS_PULL_TO_REFRESH){
                        //if the status is STATUS_PULL_TO_REFRESH when release finger,
                        //invoke the HideHeaderTask().execute() method to hide header.
                        new HideHeaderTask().execute();
                    }
                    break;
            }
            //remember to refresh the data of pull-to-refresh header
            if(currentStatus==STATUS_PULL_TO_REFRESH||currentStatus==STATUS_RELEASE_TO_REFRESH){
                updateHeaderView();
                //it is now in the status of STATUS_PULL_TO_REFRESH or STATUS_RELEASE_TO_REFRESH,
                //make the scrollview being not focusable,or the scrollview will be selected all
                //the time.
                lastStatus=currentStatus;
                //it is now in the status of STATUS_PULL_TO_REFRESH or STATUS_RELEASE_TO_REFRESH,
                //return true to block the event of scrollment of scrollveiw.
                return true;
            }
        }
        return false;
    }

