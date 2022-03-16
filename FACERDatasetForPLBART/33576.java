    /**
     * Obtains the resource id for the app theme.
     *
     * @param appThemeValue one of the values defined in {@link R.array#pref_theme_values}
     * @return app theme resource id
     */
    private int getThemeResourceId(String appThemeValue) {
        int theme;
        switch (appThemeValue) {
            case "0":
                theme = R.style.AppThemePink;
                break;
            case "1":
                theme = R.style.AppThemeRed;
                break;
            case "2":
                theme = R.style.AppThemePurple;
                break;
            case "3":
                theme = R.style.AppThemeDeepPurple;
                break;
            case "4":
                theme = R.style.AppThemeIndigo;
                break;
            case "5":
                theme = R.style.AppThemeBlue;
                break;
            case "6":
                theme = R.style.AppThemeCyan;
                break;
            case "7":
                theme = R.style.AppThemeTeal;
                break;
            case "8":
                theme = R.style.AppThemeGreen;
                break;
            case "9":
                theme = R.style.AppThemeBrown;
                break;
            case "10":
                theme = R.style.AppThemeBlueGray;
                break;
            default:
                throw new IllegalArgumentException("Unsupported value: " + appThemeValue + ". " +
                        "(The " + "value must be defined in xml: res->values" +
                        "->strings_for_settings->pref_theme_values");
        }
        return theme;
    }

