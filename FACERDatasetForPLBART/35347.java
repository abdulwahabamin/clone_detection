    @Override
    public void showDetail() {
        if (rotateCount[1] % 2 == 0) {
            expandView.setVisibility(View.VISIBLE);
            toDetail.setText("简略");
            Animation animation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            animation.setDuration(10);
            animation.setFillAfter(true);
            arrowDetail.startAnimation(animation);
            action_bar.setVisibility(View.GONE);

        } else {
            expandView.setVisibility(View.GONE);
            toDetail.setText("详情");
            Animation animation = new RotateAnimation(180, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            animation.setDuration(10);
            animation.setFillAfter(true);
            arrowDetail.startAnimation(animation);
            action_bar.setVisibility(View.VISIBLE);
        }
        rotateCount[1]++;
    }

