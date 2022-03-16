    public final IntentFilter[] getIntentFilters( String act_name ) {
        try {
            if( mans == null )
                mans = extractManifest();
            if( mans != null && mans.length() > 0 ) {
                ArrayList<IntentFilter> list = new ArrayList<IntentFilter>(); 
                XmlPullParserFactory factory;
                factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(true);
                XmlPullParser xpp = factory.newPullParser();
                xpp.setInput( new StringReader( mans ) );
                int et;
                while( ( et = xpp.next() ) != XmlPullParser.END_DOCUMENT ) {
                    if( et == XmlPullParser.START_TAG && "activity".equals( xpp.getName() ) ) {
                        String can = xpp.getAttributeValue( null, "name" );
                        if( act_name.indexOf( can ) >= 0 ) { // ??? why not exact match?
                            int d = xpp.getDepth();
                            while( ( et = xpp.next() ) != XmlPullParser.END_DOCUMENT &&
                            ( d < xpp.getDepth() || et != XmlPullParser.END_TAG ) ) {
                                if( "intent-filter".equals( xpp.getName() ) ) {
                                    IntentFilter inf = new IntentFilter();
                                    initIntentFilterFromXml( inf, xpp );
                                    list.add( inf );
                                }
                            }
                            break;
                        }
                    }
                }
                if( list.size() > 0 ) {
                    IntentFilter[] ret = new IntentFilter[list.size()];
                    return list.toArray( ret );
                }
            }
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

