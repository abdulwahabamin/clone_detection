    private int pointToAlpha(int x) {

        final RectF rect = mAlphaRect;
        final int width = (int) rect.width();

        if (x < rect.left) {
            x = 0;
        }
        else if (x > rect.right) {
            x = width;
        }
        else{
            x = x - (int)rect.left;
        }

        return 0xff - (x * 0xff / width);

    }

