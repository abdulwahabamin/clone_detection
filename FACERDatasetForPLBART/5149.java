    public static String cleanHtml(String in) {
        in=in.replaceAll("<!\\[CDATA\\[", "")
                .replaceAll("\\]\\]>", "")
                .replaceAll("\\t", "")
                .replaceAll("\\s+", " ")
                .replaceAll("\\n", "");

        in=in.replaceAll("&amp;", "&");
        in = in.replaceAll("&#039;", "");
        in =  in.replaceAll("&quot;", "\"")
                .replaceAll("&lt;", "<")
                .replaceAll("&gt;", ">")
                .replaceAll("&nbsp;", ">");



        in = in.replaceAll("<!.*?>", "");
        in = in.replaceAll("<style.*?>.*?</style>", "");
        in = in.replaceAll("<script.*?>.*?</script>", "");
        in = in.replaceAll("style=\".*?\"", "");
        return in;
    }

