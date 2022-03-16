    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // �?�得左�?�滑动时手指按下的X�??标
            touchDownX = event.getX();
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            // �?�得左�?�滑动时手指�?�开的X�??标
            v.performClick();
            touchUpX = event.getX();
            // 从左往�?�，看�?一个View
            if (touchUpX - touchDownX > 100) {
                // 显示上一�?动画
                welcome_page.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_in));
                welcome_page.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_out));
                // 显示上一�?View
                View temp = findViewById(R.id.welcome_view_1);
                if (welcome_page.getCurrentView() != temp) {
                    welcome_page.showPrevious();
                }
                // 从左往�?�，看�?�一个View
            } else if (touchDownX - touchUpX > 100) {
                // 显示下一�?动画
                welcome_page.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_in));
                welcome_page.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_out));
                // 显示下一�?View
                View temp = findViewById(R.id.welcome_view_4);
                if (welcome_page.getCurrentView() != temp) {
                    welcome_page.showNext();
                }
            }
            return true;
        }
        return false;
    }

