/*
 * (c) Copyright 2006 Hewlett-Packard Development Company, LP
 * All rights reserved.
 * [See end of file]
 */

package com.hp.hpl.jena.sdb.layout1;

import com.hp.hpl.jena.sdb.engine.PlanTranslatorGeneral;
import com.hp.hpl.jena.sdb.sql.MySQLEngineType;
import com.hp.hpl.jena.sdb.sql.SDBConnection;
import com.hp.hpl.jena.sdb.store.*;

/** Store class for the simple layout (i.e. one triple table)
 * 
 * @author Andy Seaborne
 * @version $Id: StoreSimpleMySQL.java,v 1.6 2006/04/24 17:31:26 andy_seaborne Exp $
 */

public class StoreSimpleMySQL extends StoreBase
{
    public StoreSimpleMySQL(SDBConnection connection)
    {
        this(connection, MySQLEngineType.InnoDB, new CodecSimple()) ;
    }
    
    public StoreSimpleMySQL(SDBConnection connection, MySQLEngineType engineType)
    {
        this(connection, engineType, new CodecSimple()) ;
    }

    public StoreSimpleMySQL(SDBConnection connection, MySQLEngineType engineType, CodecSimple codec)
    {
        super(connection,
              new PlanTranslatorGeneral(true, false),
              new LoaderSimple(connection, codec), 
              new FormatterSimpleMySQL(connection, engineType),
              new QueryCompiler1(codec)) ;
    }
}

/*
 * (c) Copyright 2006 Hewlett-Packard Development Company, LP
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */