    /**
     * Removes surrounding transparent pixels from bitmap (if there are any).
     *
     * @param originalBitmap bitmap that may contain transparent pixels we would like to remove
     * @return new bitmap, which looks like an original bitmap, but with the surrounding
     * whitespace removed
     */
    public static Bitmap trimBitmap(Bitmap originalBitmap) {
        int originalHeight = originalBitmap.getHeight();
        int originalWidth = originalBitmap.getWidth();

        //trimming width from left
        int xCoordinateOfFirstPixel = 0;
        for (int x = 0; x < originalWidth; x++) {
            if (xCoordinateOfFirstPixel == 0) {
                for (int y = 0; y < originalHeight; y++) {
                    if (originalBitmap.getPixel(x, y) != Color.TRANSPARENT) {
                        xCoordinateOfFirstPixel = x;
                        break;
                    }
                }
            } else break;
        }

        //trimming width from right
        int xCoordinateOfLastPixel = 0;
        for (int x = originalWidth - 1; x >= 0; x--) {
            if (xCoordinateOfLastPixel == 0) {
                for (int y = 0; y < originalHeight; y++) {
                    if (originalBitmap.getPixel(x, y) != Color.TRANSPARENT) {
                        xCoordinateOfLastPixel = x;
                        break;
                    }
                }
            } else break;
        }

        //trimming height from top
        int yCoordinateOfFirstPixel = 0;
        for (int y = 0; y < originalHeight; y++) {
            if (yCoordinateOfFirstPixel == 0) {
                for (int x = 0; x < originalWidth; x++) {
                    if (originalBitmap.getPixel(x, y) != Color.TRANSPARENT) {
                        yCoordinateOfFirstPixel = y;
                        break;
                    }
                }
            } else break;
        }

        //trimming height from bottom
        int yCoordinateOfLastPixel = 0;
        for (int y = originalHeight - 1; y >= 0; y--) {
            if (yCoordinateOfLastPixel == 0) {
                for (int x = 0; x < originalWidth; x++) {
                    if (originalBitmap.getPixel(x, y) != Color.TRANSPARENT) {
                        yCoordinateOfLastPixel = y;
                        break;
                    }
                }
            } else break;
        }

        int newBitmapWidth = xCoordinateOfLastPixel - xCoordinateOfFirstPixel;
        int newBitmapHeight = yCoordinateOfLastPixel - yCoordinateOfFirstPixel;
        return Bitmap.createBitmap(originalBitmap, xCoordinateOfFirstPixel,
                yCoordinateOfFirstPixel, newBitmapWidth, newBitmapHeight);
    }

