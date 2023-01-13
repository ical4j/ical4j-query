package org.ical4j.query.command;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.filter.ComponentFilter;
import net.fortuna.ical4j.filter.FilterExpression;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.ComponentList;
import net.fortuna.ical4j.model.component.CalendarComponent;
import net.fortuna.ical4j.util.Calendars;
import picocli.CommandLine;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@CommandLine.Command(name = "calendar-collection", description = "Query a specified calendar collection using filter expressions")
public class CalendarCollectionCommand extends AbstractCollectionCommand {

    @Override
    public void run() {
        try {
            Calendar cal = null;
            if (input.filename != null) {
                cal = Calendars.load(input.filename);
            } else if (input.url != null) {
                cal = Calendars.load(input.url);
            } else if (input.stdin) {
                final CalendarBuilder builder = new CalendarBuilder();
                cal = builder.build(System.in);
            }
            Predicate<Component> filter;
            if (query != null && !query.isEmpty()) {
                filter = new ComponentFilter<>().predicate(FilterExpression.parse(query));
            } else {
                filter = (it) -> true;
            }
            List<CalendarComponent> filtered = cal.getComponents().stream().filter(filter).collect(Collectors.toList());

            System.out.print(new Calendar(new ComponentList<>(filtered)));
        } catch (IOException | ParserException e) {
            throw new RuntimeException(e);
        }
    }
}
