    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_DOWN:
                if (start) {
                    return false;
                }
                downX = event.getX();
                downY = event.getY();
                start = true;
                break;
            case MotionEvent.ACTION_UP:
                upX = event.getX();
                upY = event.getY();
                start = false;

                float deltaX = downX - upX;
                float deltaY = downY - upY;
                float absDeltaX = Math.abs(deltaX);

                if ((absDeltaX > Math.abs(deltaY)) && absDeltaX > 200) {
                    if (deltaX > 0){
                        swipeToRight();
                        return true;
                    } else {
                        swipeToLeft();
                        return true;
                    }
                }
                break;
        }
        return false;
    }

