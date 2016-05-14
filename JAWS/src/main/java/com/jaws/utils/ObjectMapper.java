/*
 * Copyright (c) 2016.  JAWS
 * All rights reserved
 */
package com.jaws.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Utility Object Mapper that is customize to use in JAWS.
 *
 * this would standardize things like date format and time stamp.
 * @author shaikh.
 */
public class ObjectMapper
    extends org.codehaus.jackson.map.ObjectMapper
{
    public ObjectMapper(  )
    {
        super(  );

        final DateFormat df = new SimpleDateFormat( "yyy-MM-dd" );
        setDateFormat( df );
    }
}
