package com.bitop.web.bisystemanalysisweb.sql;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SqlCommandLoader extends DefaultHandler {

    private String key = null;
    private SqlCommandRegistry registry = SqlCommandRegistry.getInstance();
    private SqlCommand command = null;
    private String tagName = null;
    private StringBuilder data = null;

    public SqlCommandLoader() {
    }

    public void startElement( String uri, String localName, String qName,
                              Attributes attributes ) throws SAXException {
        if( qName.equals( "command" ) ) {
            command = new SqlCommand();
        }
        this.tagName = qName;
        data = new StringBuilder();
    }

    @Override
    public void endElement( String uri, String localName, String qName )
            throws SAXException {
        if( qName.equals( "command" ) ) {
            if( this.registry.put( key, command ) != null ) {
                throw new RuntimeException( "duplicate for command " + key );
            }
        }
        this.tagName = null;
    }

    @Override
    public void characters( char[] ch, int start, int length )
            throws SAXException {
        if( this.tagName != null ) {
            data.append( ch, start, length );
            if( this.tagName.equals( "op" ) ) {
                this.key = data.toString().trim();
            }
            else if( this.tagName.equals( "sql" ) ) {
                this.command.sql = data.toString().trim();
            }
            else if( this.tagName.equals( "param_pattern" ) ) {
                this.command.paramPattern = data.toString().trim();
            }
            else if( this.tagName.equals( "param_count" ) ) {
                this.command.paramCount = Integer.parseInt( data.toString().trim() );
            }
            else if( this.tagName.equals( "batch_count" ) ) {
                this.command.batchCount = Integer.parseInt( data.toString().trim() );
            }
            data.setLength( 0 );
        }
    }
}

