    private void initDotGroup(){
        ll_dot_group.removeAllViews();
        String tmp=wnl_spf.getString("selectedCountyCount", "0");
        int cityCount=Integer.parseInt(tmp);
        float pxScale= DisplayUtil.pxScale(this);
        int lp_wh=(int)(pxScale*6);
        for(int i=0;i<cityCount;i++){
            View dotView=new View(getApplicationContext());
            dotView.setBackgroundResource(R.drawable.dot_selector);
            dotView.setEnabled(false);
            LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(lp_wh,lp_wh);
            if(i!=0){
                lp.leftMargin=lp_wh;
            }
            dotView.setLayoutParams(lp);
            ll_dot_group.addView(dotView);
        }
    }

