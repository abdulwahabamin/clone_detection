    public Typeface getTypeFace(String fontType) {
        if(fontType != null && fontType.equals("light")){
            return lightTypeface;
        }
        return regularTypeface;
    }

