    /**
     * 根�?�当�?scrollview的滚动状�?�?�设定{@link #ableToPull}
     * 的值，该方法�?次都需�?在onTouch中的第一个执行，这样�?�以判断出当�?应该是
     * 滚动scrollview还是进行下拉
     *
     * @param event
     */
    private void setIsAbleToPull(MotionEvent event){
        if(mScrollView.getScrollY()<=0){
            if(!ableToPull){
                yDown=event.getRawY();
            }
            //如果content的上边缘�?离父布局值为0，就说明scrollview的content
            //滚动到了最顶部，此时应该�?许下拉刷新.
            ableToPull=true;
        }else {
            if(headerLayoutParams.topMargin!=hideHeaderHeight){
                headerLayoutParams.topMargin=hideHeaderHeight;
                header.setLayoutParams(headerLayoutParams);
            }
            ableToPull=false;
        }
    }

