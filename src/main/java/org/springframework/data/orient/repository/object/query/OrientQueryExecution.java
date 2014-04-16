package org.springframework.data.orient.repository.object.query;

import org.springframework.orm.orient.OrientObjectTemplate;

public abstract class OrientQueryExecution {

    protected final OrientObjectTemplate template;

    public OrientQueryExecution(OrientObjectTemplate template) {
        super();
        this.template = template;
    }
    
    public Object execute(AbstractOrientQuery query, Object[] values) {
        return doExecute(query, values);
    }
    
    protected abstract Object doExecute(AbstractOrientQuery query, Object[] values);
    
    static class CollectionExecution extends OrientQueryExecution {

        public CollectionExecution(OrientObjectTemplate template) {
            super(template);
        }

        @Override
        protected Object doExecute(AbstractOrientQuery query, Object[] values) {
            return template.query(query.createQuery(values), values);
        }
    }
}
