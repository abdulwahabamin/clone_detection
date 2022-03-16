    public float getFloatValue(float fraction) {
        if (mNumKeyframes == 2) {
            if (firstTime) {
                firstTime = false;
                firstValue = ((FloatKeyframe) mKeyframes.get(0)).getFloatValue();
                lastValue = ((FloatKeyframe) mKeyframes.get(1)).getFloatValue();
                deltaValue = lastValue - firstValue;
            }
            if (mInterpolator != null) {
                fraction = mInterpolator.getInterpolation(fraction);
            }
            if (mEvaluator == null) {
                return firstValue + fraction * deltaValue;
            } else {
                return ((Number)mEvaluator.evaluate(fraction, firstValue, lastValue)).floatValue();
            }
        }
        if (fraction <= 0f) {
            final FloatKeyframe prevKeyframe = (FloatKeyframe) mKeyframes.get(0);
            final FloatKeyframe nextKeyframe = (FloatKeyframe) mKeyframes.get(1);
            float prevValue = prevKeyframe.getFloatValue();
            float nextValue = nextKeyframe.getFloatValue();
            float prevFraction = prevKeyframe.getFraction();
            float nextFraction = nextKeyframe.getFraction();
            final /*Time*/Interpolator interpolator = nextKeyframe.getInterpolator();
            if (interpolator != null) {
                fraction = interpolator.getInterpolation(fraction);
            }
            float intervalFraction = (fraction - prevFraction) / (nextFraction - prevFraction);
            return mEvaluator == null ?
                    prevValue + intervalFraction * (nextValue - prevValue) :
                    ((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
                            floatValue();
        } else if (fraction >= 1f) {
            final FloatKeyframe prevKeyframe = (FloatKeyframe) mKeyframes.get(mNumKeyframes - 2);
            final FloatKeyframe nextKeyframe = (FloatKeyframe) mKeyframes.get(mNumKeyframes - 1);
            float prevValue = prevKeyframe.getFloatValue();
            float nextValue = nextKeyframe.getFloatValue();
            float prevFraction = prevKeyframe.getFraction();
            float nextFraction = nextKeyframe.getFraction();
            final /*Time*/Interpolator interpolator = nextKeyframe.getInterpolator();
            if (interpolator != null) {
                fraction = interpolator.getInterpolation(fraction);
            }
            float intervalFraction = (fraction - prevFraction) / (nextFraction - prevFraction);
            return mEvaluator == null ?
                    prevValue + intervalFraction * (nextValue - prevValue) :
                    ((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
                            floatValue();
        }
        FloatKeyframe prevKeyframe = (FloatKeyframe) mKeyframes.get(0);
        for (int i = 1; i < mNumKeyframes; ++i) {
            FloatKeyframe nextKeyframe = (FloatKeyframe) mKeyframes.get(i);
            if (fraction < nextKeyframe.getFraction()) {
                final /*Time*/Interpolator interpolator = nextKeyframe.getInterpolator();
                if (interpolator != null) {
                    fraction = interpolator.getInterpolation(fraction);
                }
                float intervalFraction = (fraction - prevKeyframe.getFraction()) /
                    (nextKeyframe.getFraction() - prevKeyframe.getFraction());
                float prevValue = prevKeyframe.getFloatValue();
                float nextValue = nextKeyframe.getFloatValue();
                return mEvaluator == null ?
                        prevValue + intervalFraction * (nextValue - prevValue) :
                        ((Number)mEvaluator.evaluate(intervalFraction, prevValue, nextValue)).
                            floatValue();
            }
            prevKeyframe = nextKeyframe;
        }
        // shouldn't get here
        return ((Number)mKeyframes.get(mNumKeyframes - 1).getValue()).floatValue();
    }

