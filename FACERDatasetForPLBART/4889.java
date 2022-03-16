    public static void copyToClipFlashView(Activity activity, final View view) {
    	if(view!=null) {
    		Integer colorFrom = activity.getResources().getColor(R.color.copy_to_clip);
    		Integer colorTo = activity.getResources().getColor(R.color.transparent);
    		ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
    		colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

    		    @Override
    		    public void onAnimationUpdate(final ValueAnimator animator) {
    		        view.setBackgroundColor((Integer)animator.getAnimatedValue());
    		    }

    		});
    		colorAnimation.start();
    	}
    }

