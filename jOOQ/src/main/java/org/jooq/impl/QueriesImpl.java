/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Other licenses:
 * -----------------------------------------------------------------------------
 * Commercial licenses for this work are available. These replace the above
 * ASL 2.0 and offer limited warranties, support, maintenance, and commercial
 * database integrations.
 *
 * For more information, please visit: http://www.jooq.org/licenses
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.jooq.impl;

import static org.jooq.impl.Tools.EMPTY_QUERY;

import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;

import org.jooq.Queries;
import org.jooq.Query;

/**
 * @author Lukas Eder
 */
final class QueriesImpl implements Queries {

    private final Collection<? extends Query> queries;

    QueriesImpl(Collection<? extends Query> queries) {
        this.queries = queries;
    }

    @Override
    public final Query[] queries() {
        return queries.toArray(EMPTY_QUERY);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public final Iterator<Query> iterator() {
        return (Iterator) queries.iterator();
    }


    @Override
    public final Stream<Query> stream() {
        return queryStream();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public final Stream<Query> queryStream() {
        return (Stream) queries.stream();
    }


    // ------------------------------------------------------------------------
    // Object API
    // ------------------------------------------------------------------------

    @Override
    public int hashCode() {
        return queries.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof QueriesImpl))
            return false;

        return queries.equals(((QueriesImpl) obj).queries);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Query query : queries)
            sb.append(query).append(";\n");

        return sb.toString();
    }
}
