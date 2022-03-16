    public static int getColorByCode(int code){
        switch (code){
            case 100:
                return R.color.blue;
            case 101:
            case 102:
            case 103:
                return R.color.cyan;
            case 300:
                return R.color.gray;
            default:
                return R.color.gray;
        }
    }

