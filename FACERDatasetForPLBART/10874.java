    private float pointToHue(float y) {

        final RectF rect = mHueRect;

        float height = rect.height();

        if (y < rect.top) {
            y = 0f;
        }
        else if (y > rect.bottom) {
            y = height;
        }
        else{
            y = y - rect.top;
        }

        return 360f - (y * 360f / height);
    }

