    @Override
    public Animator createAnimator(final ViewGroup sceneRoot, TransitionValues startValues,
                                   final TransitionValues endValues) {
        if (startValues == null || endValues == null) {
            return null;
        }
        Rect startBounds = (Rect) startValues.values.get(PROPERTY_BOUNDS);
        Rect endBounds = (Rect) endValues.values.get(PROPERTY_BOUNDS);
        if (startBounds == null || endBounds == null || startBounds.equals(endBounds)) {
            return null;
        }
        Bitmap startImage = (Bitmap) startValues.values.get(PROPERTY_IMAGE);
        Drawable startBackground = new BitmapDrawable(sceneRoot.getContext().getResources(), startImage);
        final View startView = addViewToOverlay(sceneRoot, startImage.getWidth(),
                startImage.getHeight(), startBackground);
        Drawable shrinkingBackground = new ColorDrawable(mColor);
        final View shrinkingView = addViewToOverlay(sceneRoot, startImage.getWidth(),
                startImage.getHeight(), shrinkingBackground);

        int[] sceneRootLoc = new int[2];
        sceneRoot.getLocationInWindow(sceneRootLoc);
        int[] startLoc = (int[]) startValues.values.get(PROPERTY_POSITION);
        int startTranslationX = startLoc[0] - sceneRootLoc[0];
        int startTranslationY = startLoc[1] - sceneRootLoc[1];

        startView.setTranslationX(startTranslationX);
        startView.setTranslationY(startTranslationY);
        shrinkingView.setTranslationX(startTranslationX);
        shrinkingView.setTranslationY(startTranslationY);

        final View endView = endValues.view;
        float startRadius = calculateMaxRadius(shrinkingView);
        int minRadius = Math.min(calculateMinRadius(shrinkingView), calculateMinRadius(endView));

        ShapeDrawable circleBackground = new ShapeDrawable(new OvalShape());
        circleBackground.getPaint().setColor(mColor);
        final View circleView = addViewToOverlay(sceneRoot, minRadius * 2, minRadius * 2,
                circleBackground);
        float circleStartX = startLoc[0] - sceneRootLoc[0] +
                ((startView.getWidth() - circleView.getWidth()) / 2);
        float circleStartY = startLoc[1] - sceneRootLoc[1] +
                ((startView.getHeight() - circleView.getHeight()) / 2);
        circleView.setTranslationX(circleStartX);
        circleView.setTranslationY(circleStartY);

        circleView.setVisibility(View.INVISIBLE);
        shrinkingView.setAlpha(0f);
        endView.setAlpha(0f);

        Animator shrinkingAnimator = createCircularReveal(shrinkingView, startRadius, minRadius);
        shrinkingAnimator.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                shrinkingView.setVisibility(View.INVISIBLE);
                startView.setVisibility(View.INVISIBLE);
                circleView.setVisibility(View.VISIBLE);
            }
        });

        Animator startAnimator = createCircularReveal(startView, startRadius, minRadius);
        Animator fadeInAnimator = ObjectAnimator.ofFloat(shrinkingView, View.ALPHA, 0, 1);

        AnimatorSet shrinkFadeSet = new AnimatorSet();
        shrinkFadeSet.playTogether(shrinkingAnimator, startAnimator,
                fadeInAnimator);

        int[] endLoc = (int[]) endValues.values.get(PROPERTY_POSITION);
        float circleEndX = endLoc[0] - sceneRootLoc[0] +
                ((endView.getWidth() - circleView.getWidth()) / 2);
        float circleEndY = endLoc[1] - sceneRootLoc[1] +
                ((endView.getHeight() - circleView.getHeight()) / 2);
        Path circlePath = getPathMotion().getPath(circleStartX, circleStartY, circleEndX,
                circleEndY);
        Animator circleAnimator = ObjectAnimator.ofFloat(circleView, View.TRANSLATION_X,
                View.TRANSLATION_Y, circlePath);

        final View growingView = addViewToOverlay(sceneRoot, endView.getWidth(),
                endView.getHeight(), shrinkingBackground);
        growingView.setVisibility(View.INVISIBLE);
        float endTranslationX = endLoc[0] - sceneRootLoc[0];
        float endTranslationY = endLoc[1] - sceneRootLoc[1];
        growingView.setTranslationX(endTranslationX);
        growingView.setTranslationY(endTranslationY);

        float endRadius = calculateMaxRadius(endView);

        circleAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                circleView.setVisibility(View.INVISIBLE);
                growingView.setVisibility(View.VISIBLE);
                endView.setAlpha(1f);
            }
        });

        Animator fadeOutAnimator = ObjectAnimator.ofFloat(growingView, View.ALPHA, 1, 0);
        Animator endAnimator = createCircularReveal(endView, minRadius, endRadius);
        Animator growingAnimator = createCircularReveal(growingView, minRadius, endRadius);

        growingAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                sceneRoot.getOverlay().remove(startView);
                sceneRoot.getOverlay().remove(shrinkingView);
                sceneRoot.getOverlay().remove(circleView);
                sceneRoot.getOverlay().remove(growingView);
            }
        });
        AnimatorSet growingFadeSet = new AnimatorSet();
        growingFadeSet.playTogether(fadeOutAnimator, endAnimator, growingAnimator);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(shrinkFadeSet, circleAnimator, growingFadeSet);
        return animatorSet;
    }

