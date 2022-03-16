   public static String stripIfHtml(String in) {
       if(in!=null) {
           if(isHtml(in)) {

               in=in.replaceAll("<!\\[CDATA\\[", "")
                       .replaceAll("\\]\\]>", "")
                       .replaceAll("\\t", "")
                       .replaceAll("\\s+", " ");

               in=in.replaceAll("&amp;", "&");
               in = in.replaceAll("&#039;", "");
               in = in.replaceAll("&#160;", " ");
               in =  in.replaceAll("&quot;", "\"")
                       .replaceAll("&lt;", "<")
                       .replaceAll("&gt;", ">")
                       .replaceAll("&nbsp;", ">");



               in = in.replaceAll("<!.*?>", "")
                       .replaceAll("<head.*?>", "")
                       .replaceAll("<meta.*?>", "")
                       .replaceAll("<html.*?>", "")
                       .replaceAll("<title.*?>", "")
                       .replaceAll("</head>", "")
                       .replaceAll("</html>", "")
                       .replaceAll("</title>", "")
                       .replaceAll("<body.*?>", "")
                       .replaceAll("</body>", "")
                       .replaceAll("<ul.*?>", "")
                       .replaceAll("<li.*?>", "")
                       .replaceAll("</ul>", "\n")
                       .replaceAll("</li>", "\n")
                       .replaceAll("<b.*?>", "")
                       .replaceAll("</b>", "")
                       .replaceAll("<a.*?>", "")
                       .replaceAll("</a>", "")
                       .replaceAll("<img.*?/>", "")
                       .replaceAll("<div.*?>", "")
                       .replaceAll("</div>", "")
                       .replaceAll("<font.*?>", "")
                       .replaceAll("</font>", "")
                       .replaceAll("<span.*?>", "")
                       .replaceAll("</span>", "")
                       .replaceAll("<p.*?>", "")
                       .replaceAll("</p>", "\n")
                       .replaceAll("<table.*?>", "")
                       .replaceAll("</table>", "")
                       .replaceAll("<tr.*?>", "")
                       .replaceAll("</tr>", "")
                       .replaceAll("<td.*?>", "")
                       .replaceAll("</td>", "")
                       .replaceAll("<br.*?>", "\n")
                       .replaceAll("<em.*?>", "")
                       .replaceAll("</em>", "")
                       .replaceAll("<script.*?>.*?</script>", "")
                       .replaceAll("<script.*>", "")
                       .replaceAll("</script>", "")
                       .replaceAll("<style.*?>.*?</style>", "")
                       .replaceAll("<style.*>", "")
                       .replaceAll("</style>", "")
                       .replaceAll("<link.*>", "")
                       .replaceAll("<strong.*>", "")
                       .replaceAll("</strong>", "")
                       .replaceAll("&nbsp;", " ");

               in.trim();
           }

           
           return in;
       } else {
           return "";
       }
   }

