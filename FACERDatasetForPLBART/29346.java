    /**
     * æ ¹æ?®å½“å‰?çš„çŠ¶æ€?æ?¥æ—‹è½¬ç®­å¤´
     */
    private void rotateArrow(){
        float pivotX=arrow.getWidth()/2f;
        float pivotY=arrow.getHeight()/2f;
        float fromDegrees=0f;
        float toDegrees=0f;
        if(currentStatus==STATUS_PULL_TO_REFRESH){
            fromDegrees=180f;
            toDegrees=360f;
        }else if(currentStatus==STATUS_RELEASE_TO_REFRESH){
            fromDegrees=0f;
            toDegrees=180f;
        }
        RotateAnimation animation=new RotateAnimation(fromDegrees,toDegrees,pivotX,pivotY);
        animation.setDuration(200);
        animation.setFillAfter(true);
        arrow.startAnimation(animation);

    }

