package org.exoplatform.study.osgi.webapp2.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.exoplatform.study.osgi.webapp2.Webapp2Service;

/**
 * Internal implementation of our example OSGi service
 */
public final class Webapp2ServiceImpl
    implements Webapp2Service
{
    // implementation methods go here...

    public String scramble( String text )
    {
        List charList = new ArrayList();

        char[] textChars = text.toCharArray();
        for( int i = 0; i < textChars.length; i++ )
        {
            charList.add( new Character( textChars[i] ) );
        }

        Collections.shuffle( charList );

        char[] mixedChars = new char[text.length()];
        for( int i = 0; i < mixedChars.length; i++ )
        {
            mixedChars[i] = ( (Character) charList.get( i ) ).charValue();
        }

        return new String( mixedChars );
    }
}

