/*
 * Copyright (c) 2002-2016 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.coreedge.server.core;

import org.junit.Test;

import org.neo4j.collection.RawIterator;
import org.neo4j.kernel.api.exceptions.ProcedureException;

import static org.junit.Assert.assertEquals;

public class RoleProcedureTest
{
    @Test
    public void shouldReturnCore() throws Exception
    {
        // given
        RoleProcedure proc = new RoleProcedure( RoleProcedure.CoreOrEdge.CORE );

        // when
        RawIterator<Object[], ProcedureException> result = proc.apply( null, null );

        // then
        assertEquals( RoleProcedure.CoreOrEdge.CORE.name(), result.next()[0]);
    }

    @Test
    public void shouldReturnEdge() throws Exception
    {
        // given
        RoleProcedure proc = new RoleProcedure( RoleProcedure.CoreOrEdge.EDGE );

        // when
        RawIterator<Object[], ProcedureException> result = proc.apply( null, null );

        // then
        assertEquals( RoleProcedure.CoreOrEdge.EDGE.name(), result.next()[0]);
    }

    @Test
    public void shouldReturnUnknown() throws Exception
    {
        // given
        RoleProcedure proc = new RoleProcedure( null );

        // when
        RawIterator<Object[], ProcedureException> result = proc.apply( null, null );

        // then
        assertEquals( "UNKNOWN", result.next()[0]);
    }
}