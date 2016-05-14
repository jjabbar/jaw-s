/*
 * Copyright (c) 2016.  JAWS
 * All rights reserved
 */
package com.jaws.common;

import com.jaws.utils.ObjectMapper;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * This class is a utility class to be used for public and JAWS.
 *
 * This class will only create one and only one instance.
 *
 * This class will be responsible for beautifying the json
 *
 * @author shaikh
 */
public class PrettyPrint
{
    /** Class logger **/
    private static final Logger logger = Logger.getLogger( PrettyPrint.class.getSimpleName(  ) );

    // Making this class singleton
    private PrettyPrint prettyPrint;

    /**
     * Singleton instance of the class
     * @return instance of the class
     */
    public PrettyPrint getPrettyPrint(  )
    {
        if ( prettyPrint != null )
        {
            prettyPrint = new PrettyPrint(  );

            return prettyPrint;
        }

        return prettyPrint;
    }

    /**
     * This method will return beautified json in string format
     * @param json Object of json to beautify
     * @param clazz Value type, usually it is Object.class
     * @return beautified json
     * @throws Exception
     */
    public String beautifyJson( Object json, Class clazz )
                        throws Exception
    {
        if ( StringUtils.isEmpty( (String) json ) )
        {
            throw new RuntimeException( "JSON object can't be empty" );
        }

        return beautify( json.toString(  ),
                         clazz );
    }

    /**
     * This method will return beautified json in string format
     * @param json String of json to beautify
     * @param clazz Value type, usually it is Object.class
     * @return beautified json
     * @throws Exception
     */
    public String beautifyJson( String json, Class clazz )
                        throws Exception
    {
        if ( StringUtils.isEmpty( json ) )
        {
            throw new RuntimeException( "JSON can't be empty" );
        }

        return beautify( json, clazz );
    }

    /**
     * This method will return beautified json in string format
     * @param json String json to beautify
     * @return beautified json
     * @throws Exception
     */
    public String beautifyJson( String json )
                        throws Exception
    {
        if ( StringUtils.isEmpty( json ) )
        {
            throw new RuntimeException( "JSON can't be empty" );
        }

        return beautify( json, Object.class );
    }

    /**
     * Maps the json to ObjectMapper and beautifies it
     * @param json Json string to beautify
     * @param clazz Object.class
     * @return beautified json
     * @throws IOException
     */
    private String beautify( String json, Class clazz )
                     throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper(  );
        Object jsonToBeautify = objectMapper.readValue( json, clazz );

        return objectMapper.writerWithDefaultPrettyPrinter(  ).writeValueAsString( jsonToBeautify );
    }
}
