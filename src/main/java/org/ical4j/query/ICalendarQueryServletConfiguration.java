package org.ical4j.query;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "iCalendar Query Servlet", description = "Servlet Configuration for an iCalendar query service")
@interface ICalendarQueryServletConfiguration {

    @AttributeDefinition(name = "alias", description = "Servlet alias")
    String alias() default "/query";
}
