    public static boolean isHtml(String message) {
        String use=message.toString();
        if(use.length()-use.replace("</", "").length()>0)
            return true;
        else if(use.length()-use.replace("&amp;", "").length()>0)
            return true;
        return false;
    }

