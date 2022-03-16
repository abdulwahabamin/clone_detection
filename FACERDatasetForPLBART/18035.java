    public static Palette generatePalette(Bitmap bitmap) {
        if (bitmap == null){
            return null;
        }
        return Palette.from(bitmap).generate();
    }

