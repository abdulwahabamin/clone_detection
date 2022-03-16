    private void swipeToLeft() {
        if (destinationActivityOnLeftSide == null) {
            return;
        }
        Intent intentToMoveToActivity = new Intent(context, destinationActivityOnLeftSide);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ActivityOptions options = ActivityOptions.makeCustomAnimation(context, R.anim.anim_slide_in_right,
                    R.anim.anim_slide_out_right);
            context.startActivity(intentToMoveToActivity, options.toBundle());
        } else {
            context.startActivity(intentToMoveToActivity);
        }
    }

