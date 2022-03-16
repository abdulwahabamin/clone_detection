    private float[] pointToSatVal(float x, float y) {

        final RectF rect = mSatValRect;
        float[] result = new float[2];

        float width = rect.width();
        float height = rect.height();

        if (x < rect.left) {
            x = 0f;
        }
        else if (x > rect.right) {
            x = width;
        }
        else{
            x = x - rect.left;
        }

        if (y < rect.top) {
            y = 0f;
        }
        else if (y > rect.bottom) {
            y = height;
        }
        else{
            y = y - rect.top;
        }


        result[0] = 1.f / width * x;
        result[1] = 1.f - (1.f / height * y);

        return result;
    }

