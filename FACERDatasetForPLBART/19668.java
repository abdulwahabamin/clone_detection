    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        /* Angle around the y-axis of the rotation at the given time
         * calculated both in radians and degrees.
         */
        final double radians = Math.PI * interpolatedTime;
        float degrees = (float) (180.0 * radians / Math.PI);
 
        /* Once we reach the midpoint in the animation, we need to hide the
         * source fragment and show the destination fragment. We also need to change
         * the angle by 180 degrees so that the destination does not come in
         * flipped around.
         */
        if (interpolatedTime >= 0.5f) {
            degrees -= 180.f;
            fromView.setVisibility(View.GONE);
            toView.setVisibility(View.VISIBLE);
            
        }
 
        if (forward) {
        	degrees = -degrees; //Determines the direction of rotation when the flip begins.
        }
 
        final Matrix matrix = t.getMatrix();
        camera.save();
        camera.rotateY(degrees);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-centerX, -centerY);
        matrix.postTranslate(centerX, centerY);
    }

