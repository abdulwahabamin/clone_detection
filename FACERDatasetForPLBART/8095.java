    private int[] buildHueColorArray() {

        int[] hue = new int[361];

        int count = 0;
        for (int i = hue.length -1; i >= 0; i--, count++) {
            hue[count] = Color.HSVToColor(new float[]{i, 1f, 1f});
        }

        return hue;
    }

