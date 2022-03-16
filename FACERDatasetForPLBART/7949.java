    private static final boolean initIntentFilterFromXml( IntentFilter inf, XmlPullParser xpp ) {
        try {
            int outerDepth = xpp.getDepth();
            int type;
            while( (type = xpp.next()) != XmlPullParser.END_DOCUMENT
                    && (type != XmlPullParser.END_TAG || xpp.getDepth() > outerDepth) ) {
                if( type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT )
                    continue;
                final String NAME = "name";
                String tag = xpp.getName();
                if( tag.equals( "action" ) ) {
                    String name = xpp.getAttributeValue( null, NAME );
                    if( name != null )
                        inf.addAction( name );
                }
                else if( tag.equals( "category" ) ) {
                    String name = xpp.getAttributeValue( null, NAME );
                    if( name != null )
                        inf.addCategory( name );
                }
                else if( tag.equals( "data" ) ) {
                    int na = xpp.getAttributeCount();
                    for( int i = 0; i < na; i++ ) {
                        String port = null;
                        String an = xpp.getAttributeName( i );
                        String av = xpp.getAttributeValue( i );
                        if( "mimeType".equals( an ) ) {
                            try {
                                inf.addDataType( av );
                            }
                            catch( MalformedMimeTypeException e ) {
                            }
                        } else
                        if( "scheme".equals( an ) ) {
                            inf.addDataScheme( av );
                        } else
                        if( "host".equals( an ) ) {
                            inf.addDataAuthority( av, port );
                        } else
                        if( "port".equals( an ) ) {
                            port = av;
                        } else
                        if( "path".equals( an ) ) {
                            inf.addDataPath( av, PatternMatcher.PATTERN_LITERAL );
                        } else
                        if( "pathPrefix".equals( an ) ) {
                            inf.addDataPath( av, PatternMatcher.PATTERN_PREFIX );
                        } else
                        if( "pathPattern".equals( an ) ) {
                            inf.addDataPath( av, PatternMatcher.PATTERN_SIMPLE_GLOB );
                        }
                    }
                }
            }
            return true;
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
        return false;
    }

