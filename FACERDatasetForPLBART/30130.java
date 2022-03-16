    /**
     * θ·ε?ζζ
     *
     * @param num 0-6
     * @return ζζ
     */
    private String getWeek(int num) {
        String week = " ";
        if (ContentUtil.APP_SETTING_LANG.equals("en") || ContentUtil.APP_SETTING_LANG.equals("sys") && ContentUtil.SYS_LANG.equals("en")) {
            switch (num) {
                case 1:
                    week = "Mon";
                    break;
                case 2:
                    week = "Tues";
                    break;
                case 3:
                    week = "Wed";
                    break;
                case 4:
                    week = "Thur";
                    break;
                case 5:
                    week = "Fri";
                    break;
                case 6:
                    week = "Sat";
                    break;
                case 7:
                    week = "Sun";
                    break;
            }
        } else {
            switch (num) {
                case 1:
                    week = "ε¨δΈ";
                    break;
                case 2:
                    week = "ε¨δΊ";
                    break;
                case 3:
                    week = "ε¨δΈ";
                    break;
                case 4:
                    week = "ε¨ε";
                    break;
                case 5:
                    week = "ε¨δΊ";
                    break;
                case 6:
                    week = "ε¨ε­";
                    break;
                case 7:
                    week = "ε¨ζ₯";
                    break;
            }
        }
        return week;
    }

