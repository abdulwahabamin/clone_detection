    /**
     *
     * @param ID the weather id
     * @return Integer weather drawable
     */
    public Integer convertWeather(Integer ID){
        switch (ID){
            case 200:
            case 201:
            case 202:
            case 210:
            case 211:
            case 212:
            case 221:
            case 230:
            case 231:
            case 232:
                istat = R.drawable.ic_rain;
                break;
            case 300:
            case 301:
            case 302:
            case 310:
            case 311:
            case 312:
            case 313:
            case 314:
            case 321:
                istat = R.drawable.ic_rain;
                break;
            case 500:
            case 501:
            case 502:
            case 503:
            case 504:
            case 511:
            case 520:
            case 521:
            case 522:
            case 531:
                istat = R.drawable.ic_rain;
                break;
            case 600:
            case 601:
            case 602:
            case 611:
            case 612:
            case 615:
            case 616:
            case 620:
            case 621:
            case 622:
                istat = R.drawable.ic_rain;
                //stat = R.drawable.ic_snow;
                break;
            case 700:
            case 711:
            case 721:
            case 731:
            case 741:
            case 751:
            case 761:
            case 762:
            case 771:
            case 781:
                istat = R.drawable.ic_cloud;
                break;
            case 800:
                istat = R.drawable.ic_sunny;
                break;
            case 801:
            case 802:
                istat = R.drawable.ic_cloudy;
                break;
            case 803:
            case 804:
                istat = R.drawable.ic_cloud;
                break;
            case 900:
            case 901:
            case 902:
            case 903:
            case 904:
            case 905:
            case 906:
                istat = R.drawable.ic_cloud;
                break;
            default:
                istat = R.drawable.ic_sunny;
                break;
        }
        return istat;
    }

