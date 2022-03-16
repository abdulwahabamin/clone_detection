    private void swipeToRight() {
        if (destinationActivityOnRightSide == null) {
            return;
        }
        Intent intentToMoveToActivity = new Intent(context, destinationActivityOnRightSide);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ActivityOptions options = ActivityOptions.makeCustomAnimation(context, R.anim.anim_slide_in_left,
                    R.anim.anim_slide_out_left);
            context.startActivity(intentToMoveToActivity, options.toBundle());
        } else {
            context.startActivity(intentToMoveToActivity);
        }
    }

