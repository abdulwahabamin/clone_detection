    private void resetAdapterDataAndCurrentItem(){
        mfspa.notifyDataSetChanged();
        initDotGroup();
        int itemCount=Integer.parseInt(wnl_spf.getString("selectedCountyCount", "0"));
        if(nowPageNum<itemCount){
            myViewPager.setCurrentItem(nowPageNum);
            mTitleText.setText(wnl_spf.getString("selectedCountyName"+nowPageNum,""));
            ll_dot_group.getChildAt(nowPageNum).setEnabled(true);
        }else {
            itemCount--;
            lastPageNum=nowPageNum=itemCount;
            myViewPager.setCurrentItem(itemCount);
            mTitleText.setText(wnl_spf.getString("selectedCountyName"+itemCount,""));
            ll_dot_group.getChildAt(itemCount).setEnabled(true);
        }
    }

