    private static boolean isColorDark(int color){
        double darkness = 1-(0.299*Color.red(color) + 0.587*Color.green(color) + 0.114*Color.blue(color))/255;
        if(darkness < 0.2) {
            return false; // It's a light color
        } else {
            return true; // It's a dark color
        }
    }

