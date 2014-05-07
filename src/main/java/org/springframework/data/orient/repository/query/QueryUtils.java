package org.springframework.data.orient.repository.query;

import static org.jooq.impl.DSL.field;

import java.util.ArrayList;
import java.util.List;

import org.jooq.SortField;
import org.jooq.SortOrder;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.util.Assert;

/**
 * Utility class to create Orient queries.
 * 
 * @author Dzmitry_Naskou
 */
public final class QueryUtils {

    private QueryUtils() {
        super();
    }
    
    /**
     * Apply sorting for the given query.
     *
     * @param query the query
     * @param sort the sort
     * @return the string
     */
    public static String applySorting(String query, Sort sort) {
        Assert.hasText(query);
        
        if (null == sort || !sort.iterator().hasNext()) {
            return query;
        }
        
        throw new UnsupportedOperationException("Not implemented");
    }
    
    /**
     * Converts the given {@link Sort} into {@link SortField}s.
     *
     * @param sort the {@link Sort} instance to be transformed into JOOQ {@link SortField}s.
     * @return the list of {@link SortField}s.
     */
    public static List<SortField<?>> toOrders(Sort sort) {
        List<SortField<?>> orders = new ArrayList<SortField<?>>();
        
        for (Order order : sort) {
            orders.add(field(order.getProperty()).sort(order.getDirection() == Direction.ASC ? SortOrder.ASC : SortOrder.DESC)); 
        }

        return orders;
    }
}