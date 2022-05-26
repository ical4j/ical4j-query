package org.ical4j.query;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;

@Component(
        service = {HttpServlet.class, Servlet.class},
        property = {"service.description=iCalendar Query Servlet"}
)
@Designate(ocd = ICalendarQueryServletConfiguration.class, factory = true)
public class ICalendarQueryServlet extends HttpServlet {
}
