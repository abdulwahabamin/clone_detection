    /**
     * 更新下拉头中的信�?�
     */
    private void updateHeaderView(){
        if(lastStatus!=currentStatus){
            if(currentStatus==STATUS_PULL_TO_REFRESH){
                if(lastStatus==STATUS_REFRESH_FINISHED) {
                    refreshUpdatedAtValue();
                }
                description.setText(getResources().getString(R.string.pull_to_refresh));
                arrow.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.GONE);
                rotateArrow();
            } else if(currentStatus==STATUS_RELEASE_TO_REFRESH){
                description.setText(getResources().getString(R.string.release_to_refresh));
                arrow.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.GONE);
                rotateArrow();
            }else if(currentStatus==STATUS_REFRESHING){
                description.setText(getResources().getString(R.string.refreshing));
                mProgressBar.setVisibility(View.VISIBLE);
                arrow.clearAnimation();
                arrow.setVisibility(View.GONE);
            }

        }
    }

